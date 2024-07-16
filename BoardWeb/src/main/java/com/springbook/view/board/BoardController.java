package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//검색조건목록설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
		
	//글등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{
		//파일업로드처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//글수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo) {
		System.out.println("번호: "+vo.getSeq());
		System.out.println("제목: "+vo.getTitle());
		System.out.println("작성자: "+vo.getWriter());
		System.out.println("내용: "+vo.getContent());
		System.out.println("등록일: "+vo.getRegDate());
		System.out.println("조회수: "+vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//글삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//글상세조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		mav.addObject("board", boardDAO.getBoard(vo));
//		mav.setViewName("getBoard.jsp");
//		return mav;
//	}
	
	//글목록검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition, @RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword, BoardVO vo, Model model) {
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);
		
		//Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// Model
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		mav.addObject("boardList", boardDAO.getBoardList(vo));
//		mav.setViewName("getBoardList.jsp");
//		return mav;
//	}
	
}
