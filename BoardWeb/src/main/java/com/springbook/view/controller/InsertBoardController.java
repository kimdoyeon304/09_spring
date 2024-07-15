package com.springbook.view.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class InsertBoardController{

	//@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		
		//1. 사용자 입력 정보 추출
		//request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");

		//2. DB 연동처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);

		//BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
		//3. 화면 네비게이션
		//return "getBoardList.do";
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;

	}

	
}
