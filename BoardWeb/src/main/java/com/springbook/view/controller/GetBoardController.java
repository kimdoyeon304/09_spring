package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class GetBoardController{

	//@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		//1. 검색할 게시글 번호 추출
		//String seq = request.getParameter("seq");

		//2. DB연동처리
		//BoardVO vo = new BoardVO();
		//vo.setSeq(Integer.parseInt(seq));

		//BoardDAO boardDAO = new BoardDAO();
		//BoardVO board = boardDAO.getBoard(vo);

		//3. 검색 결과를 세션에 저장하고 상세화면을 리턴한다
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		return "getBoard";
		
		//ModelAndView mav = new ModelAndView();
		mav.addObject("board", boardDAO.getBoard(vo)); //Model
		mav.setViewName("getBoard.jsp"); //View
		//mav.setViewName("getBoard"); //View
		return mav;
	}

	
}
