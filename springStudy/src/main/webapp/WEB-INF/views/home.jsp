<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String serverTime = (String)request.getAttribute("serverTime");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world! Spring <%= serverTime %>
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<p>
		<a href="<%= request.getContextPath() %>/sample.do">sample.do로 이동</a>
	</p>
	<p>
		<a href="<%= request.getContextPath() %>/board/list.do">list.do로 이동</a>
	</p>
	<p>
		<a href="<%= request.getContextPath() %>/user/list.do">회원 목록으로 이동</a>
	</p>
</body>
</html>
