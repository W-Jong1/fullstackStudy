<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>게시글 수정페이지</h2>
		<form method="post" action="modify.do">
			<input type="hidden" name="bidx" value="${vo.bidx}">
			<table border="1">
				<tr>
					<th align="right">제목 :</th>
					<td><input type="text" name="title" size="30" value="${vo.title}"></td>
				</tr>
				<tr>
					<th align="right">내용 :</th>
					<td><textarea name="body" rows="10" cols="30" >${vo.body}</textarea></td>
				</tr>
			</table>
			<button>저장</button>
		</form>
	</body>
</html>