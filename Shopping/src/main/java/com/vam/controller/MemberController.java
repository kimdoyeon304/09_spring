package com.vam.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//회원가입 페이지 이동
	@GetMapping("join")
	public void joinGET() {
		logger.info("회원가입 페이지 진입");
	}
	
	//로그인 페이지 이동
	@GetMapping("login")
	public void loginGET() {
		logger.info("로그인 페이지 진입");
	}
	
	//회원가입
	@PostMapping("/join")
	public String joinPOST(MemberVO member) throws Exception{
		//logger.info("join 진입");
		
		//회원가입 서비스 진행
		//memberService.memberJoin(member);
		
		//logger.info("join Service 성공");
		String rawPw = ""; //인코딩 전 비밀번호
		String encodePw = ""; //인코딩 후 비밀번호
		
		rawPw = member.getMemberPw(); //비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(rawPw); //비밀번호 인코딩
		member.setMemberPw(encodePw); //인코딩된 비밀번호 member객체에 다시 저장
		
		//회원가입 쿼리 실행
		memberService.memberJoin(member);
		
		return "redirect:/main";
	}
	
	//아이디 중복 검사
	@PostMapping("/memberIdChk")
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception{
		//logger.info("memberIdChk() 진입");
		
		int result = memberService.idCheck(memberId);
		
		logger.info("걸과값 = " + result);
		if(result != 0) {
			return "fail"; //중복아이디 존재
		}else {
			return "success"; //중복아이디 없음
		}
	}
	
	//이메일 인증
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		//뷰로부터 넘어온 데이터 확인
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증번호: " + email);
		
		//인증번호 난수 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호" + checkNum);
		
		//이메일 보내기
		String setFrom = "이메일 주소";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다";
		String content = "홈페이지를 방문해주셔서 감사합니다"+"<br><br>"+"인증 번호는 "+checkNum + "입니다"+"<br>"+"해당 인증번호를 인증번호 확인란에 기입해주세요";
		//이메일 전송코드(try-catch) 주석처리하면 메일 말고 콘솔창 확인
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true, "utf-8" );
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String num = Integer.toString(checkNum);
		return num;
	}
	
	//로그인
    //@RequestMapping(value="login", method=RequestMethod.POST)
    @PostMapping("/login.do")
    public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{
        
        //System.out.println("login 메서드 진입");
        //System.out.println("전달된 데이터 : " + member);
        
        HttpSession session = request.getSession();
        String rawPw = "";
        String encodePw = "";
        
        MemberVO lvo = memberService.memberLogin(member); //제출한 아이디와 일치하는 아이디 있는지
        
        if(lvo != null) {                                //일치하는 아이디 존재시
            rawPw = member.getMemberPw(); //사용자가 제출한 비밀번호
            encodePw = lvo.getMemberPw(); //데이터베이스에 저장한 인코딩된 비밀번호
            
            if(true == pwEncoder.matches(rawPw, encodePw)) { //비밀번호 일치여부 판단
            	lvo.setMemberPw(""); //인코딩된 비밀번호 정보 지움
            	session.setAttribute("member", lvo); //session에 사용자의 정보 저장
            	return "redirect:/main"; //메인페이지 이동
            }else {
            	rttr.addFlashAttribute("result",0);
            	return "redirect:/member/login"; //로그인 페이지로 이동
            }
        }else { //일치하는 아이디가 존재하지 않을 시(로그인 실패)
        	rttr.addFlashAttribute("result",0);
        	return "redirect:/member/login"; //로그인 페이지로 이동
        }
  
    }
    
    //메인페이지 로그아웃
    @GetMapping("/logout.do")
    public String logoutMainGET(HttpServletRequest request) throws Exception{
    	logger.info("logoutMainGET에서도 진입");
    	
    	HttpSession session = request.getSession();
    	session.invalidate();
    	return "redirect:/main";
    }
    
    //비동기방식 로그아웃 메서드
    @PostMapping("/logout.do")
    @ResponseBody
    public void logoutPOST(HttpServletRequest request) throws Exception{
    	logger.info("비동기 로그아웃 메서드 진입");
    	HttpSession session = request.getSession();
    	session.invalidate();
    }
    
}