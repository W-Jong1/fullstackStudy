<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>sample.do 페이지</h2>
		반갑습니다. spring framework 첫 포워드 성공을 축하합니다.
		<br>
		이름 : ${name}<br>
		나이 : ${age}<br>
		주소 : ${addr}<br>
		전화 : ${phone}<br>
		
		<form action="sample.do" method="post">
			이름 : <input type="text" name="name" id="name"><br>
			나이 : <input type="number" name="age" id="age"><br>
			주소 : <input type="text" name="addr" id="addr"><br>
			전화 : <input type="text" name="phone" id="phone"><br>
			<button>전송</button>
		</form>
	</body>
</html>