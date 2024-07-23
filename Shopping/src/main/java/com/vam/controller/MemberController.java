package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
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
		logger.info("join 진입");
		
		//회원가입 서비스 진행
		memberService.memberJoin(member);
		
		logger.info("join Service 성공");
		
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
}
