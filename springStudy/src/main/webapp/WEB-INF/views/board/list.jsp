<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>게시글 목록</h2>
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bidx}</td>
					<td><a href="view.do?bidx=${board.bidx}">${board.title}</a></td>
					<td>${board.wdate}</td>
					<td>${board.hit}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="view.do">게시글 상세 페이지로 이동</a><br>
		<a href="write.do">게시글 등록 페이지로 이동</a>
	</body>
</html>