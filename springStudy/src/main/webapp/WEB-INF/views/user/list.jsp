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
		<h2>유저 목록</h2>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>학점</th>
				<th>가입일</th>
				<th>탈퇴여부</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.gender}</td>
					<td>${user.grade}</td>
					<td>${user.regdate}</td>
					<td>${user.delyn}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="view.do">게시글 상세 페이지로 이동</a><br>
		<a href="write.do">게시글 등록 페이지로 이동</a>
	</body>
</html>