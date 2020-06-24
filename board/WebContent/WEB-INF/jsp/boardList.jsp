<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.koreait.board.model.BoardVO" %>
<%@ page import="java.util.*" %>    
    
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<div>
		<a href="boardWrite"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>		
		<% for(int i=0; i<list.size(); i++) { %>
			<% BoardVO vo = list.get(i); %>
			<tr>
				<td><%=vo.getBid() %></td>
				<td><a href="/boardDetail?bid=<%=vo.getBid()%>"><%=vo.getTitle() %></a></td>
				<td><%=vo.getR_dt() %></td>
			</tr>
		<% } %>
		</table>
	</div>
</body>
</html>




