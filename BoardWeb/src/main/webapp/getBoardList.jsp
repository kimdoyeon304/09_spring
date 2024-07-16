<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="java.util.List" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %> --%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%
//1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
//2. DB 연동처리
//BoardVO vo = new BoardVO();
//BoardDAO boardDAO = new BoardDAO();
//List<BoardVO> boardList = boardDAO.getBoardList(vo);

//3. 응답 화면 구성


// 세션에 저장된 글 목록을 꺼낸다
//List<BoardVO> boardList = (List)session.getAttribute("boardList");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
<h1><spring:message code="message.board.list.mainTitle" /></h1>
<!-- <h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3> -->
<h3>${userName}<spring:message code="message.board.list.welcomeMsg" />...<a href="logout.do">Log-out</a></h3>

<!-- 검색 시작 -->
<!-- <form action="getBoardList.jsp" method="post"> -->
<form action="getBoardList.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<td align="right">
<select name="searchCondition">
<!-- <option value="TITLE">제목
<option value="CONTENT">내용 -->
<c:forEach items="${conditionMap }" var="option">
<option value="${option.value }">${option.key }
</c:forEach>
</select>
<input name="searchKeyword" type="text" />
<input type="submit" value="<spring:message code="message.board.list.search.condition.btn" />" />
</td>
</tr>


</table>


</form>
<!-- 검색 종료 -->


<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq" /></th>
<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title" /></th>
<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer" /></th>
<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate" /></th>
<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt" /></th>
</tr>


<%-- <% for(BoardVO board : boardList) {%>
<tr>
<td><%= board.getSeq() %></td>
<td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
<td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
<td><%= board.getWriter() %></td>
<td><%= board.getRegDate() %></td>
<td><%= board.getCnt() %></td>
</tr>
<%} %> --%>

<c:forEach items="${boardList }" var="board">
<tr>
<td>${board.seq }</td>
<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
<td>${board.writer }</td>
<td>${board.regDate }</td>
<td>${board.cnt }</td>
</tr>
</c:forEach>



</table>
<br>
<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard" /></a>
</center>

</body>
</html>