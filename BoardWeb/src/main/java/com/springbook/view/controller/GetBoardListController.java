package com.springbook.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardListController{
	//@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		
		//1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		//2. DB 연동처리
		//BoardVO vo = new BoardVO();
		//BoardDAO boardDAO = new BoardDAO();
		//List<BoardVO> boardList = boardDAO.getBoardList(vo);

		//3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
//		return "getBoardList";

		//ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //Model 정보 저장
		mav.setViewName("getBoardList.jsp"); //View 정보 저장
		//mav.setViewName("getBoardList"); //View 정보 저장
		return mav;


	}

	
}
