<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %> --%>


<%
//1. 검색할 게시글 번호 추출
//String seq = request.getParameter("seq");

//2. DB연동처리
//BoardVO vo = new BoardVO();
//vo.setSeq(Integer.parseInt(seq));

//BoardDAO boardDAO = new BoardDAO();
//BoardVO board = boardDAO.getBoard(vo);

//3. 응답 화면 구성


// 세션에 저장된 게시글 정보를 꺼낸다
//BoardVO board = (BoardVO)session.getAttribute("board");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<!-- <a href="logout_proc.jsp">Log-out</a> -->
<a href="logout.do">Log-out</a>
<hr>
<!-- <form action="updateBoard_proc.jsp" method="post"> -->
<form action="updateBoard.do" method="post">
<%-- <input name="seq" type="hidden" value="<%= board.getSeq() %>" /> --%>
<input name="seq" type="hidden" value="${board.seq }" />
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td bgcolor="orange" width="70">제목</td>
<%-- <td align="left"><input name="title" type="text" value="<%= board.getTitle() %>" /></td> --%>
<td align="left"><input name="title" type="text" value="${board.title }" /></td>
</tr>
<tr>
<td bgcolor="orange">작성자</td>
<%-- <td align="left"><%= board.getWriter() %></td> --%>
<td align="left">${board.writer }</td>
</tr>
<tr>
<td bgcolor="orange">내용</td>
<%-- <td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td> --%>
<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
</tr>
<tr>
<td bgcolor="orange">등록일</td>
<%-- <td align="left"><%= board.getRegDate() %></td> --%>
<td align="left">${board.regDate }</td>
</tr>
<tr>
<td bgcolor="orange">조회수</td>
<%-- <td align="left"><%= board.getCnt() %></td> --%>
<td align="left">${board.cnt }</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="글 수정" /></td>
</tr>

</table>



</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<%-- <a href="deleteBoard_proc.jsp?seq=<%= board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">글목록</a> --%>
<%-- <a href="deleteBoard.do?seq=<%= board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp; --%>
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;&nbsp;
</center>

</body>
</html>