<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="join.do" method="post">
			<table>
				<tr>
					<th align="right">아이디 (*) :</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th align="right">비밀번호 (*) :</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th align="right">이름 (*) :</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th align="right">나이 :</th>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<th align="right">성별 :</th>
					<td>
						<select name="gender">
							<option value="M">남성</option>
							<option value="F">여성</option>
						</select>
					</td>
				</tr>
				<tr>
					<th align="right">주소 :</th>
					<td><input type="text" name="addr"></td>
				</tr>
				<tr>
					<th align="right">전화번호 (*) :</th>
					<td><input type="text" name="phone"></td>
				</tr>
			</table>
			<button>가입하기</button>
		</form>
	</body>
</html>