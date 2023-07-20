<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>로그인 페이지</h2>
		<form action="login.do" method="post">
			<table>
				<tr>
					<th align="right">ID :</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th align="right">Password :</th>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<button>로그인</button>
		</form>
	</body>
</html>