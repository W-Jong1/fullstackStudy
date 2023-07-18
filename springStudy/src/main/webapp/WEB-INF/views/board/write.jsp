<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>게시글 등록</h2>
		<form action="write.do" method="post">
			제목 : <input type="text" name="title"><br>
			작성자 : <input type="text" name="writer"><br>
			내용 : <textarea name="body"></textarea><br>
			<button>등록</button>
		</form>
	</body>
</html>