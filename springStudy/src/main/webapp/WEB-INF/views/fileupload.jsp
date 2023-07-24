<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>
		</head>
	<body>
		<h2>파일 업로드 페이지</h2>
		<form action="fileupload.do" method="post" enctype="multipart/form-data">
			<!-- 파일 이름 파라미터는 VO 필드명과 다르게 해야 VO로 바로 매핑되지 않고 컨트롤러로 보낼 수 있음 -->
			file : <input type="file" name="uploadFile"><br>
			<input type="text" name="t1"><br>
			<input type="text" name="t2"><br>
			<button>업로드</button>
		</form>
	</body>
</html>