<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="<%= request.getContextPath() %>/js/jquery-3.6.3.min.js"></script>
		<script>
			//필수 입력 양식들에 대한 입력 여부 값을 가지는 변수
			var checkIdFlag = false;
			var checkPasswordFlag = false;
			var checkNameFlag = false;
			var checkPhoneFlag = false;
			function checkFn(obj) {
				if(obj.value == "") {
					$(obj).next(".msg").text("필수입력입니다.").css("color","red");
					checkInputFlag = false;
					if($(obj).attr("name") == "id") {
						checkIdFlag = false;
					}else if($(obj).attr("name") == "password") {
						checkPasswordFlag = false;
					}else if($(obj).attr("name") == "name") {
						checkNameFlag = false;
					}else if($(obj).attr("name") == "phone") {
						checkPhoneFlag = false;
					}
				}else {
					// idCheck
					if($(obj).attr("name") == "id") {
						$.ajax({
							url:"checkId.do",
							type:"post",
							data:{id:$(obj).val()},
							success:function(data) {
								if(data == "0") {
									$(obj).next(".msg").text("사용할 수 있는 아이디입니다.").css("color","green");
									checkIdFlag = true;
								}else {
									$(obj).next(".msg").text("사용할 수 없는 아이디입니다.").css("color","red");
									checkIdFlag = false;
								}
							}
						});
					}else {	// id 외 값이 존재하는 경우
						$(obj).next(".msg").text("");
						if($(obj).attr("name") == "password") {
							checkPasswordFlag = true;
						}else if($(obj).attr("name") == "name") {
							checkNameFlag = true;
						}else if($(obj).attr("name") == "phone") {
							checkPhoneFlag = true;
						}
					}
				}
			}
			
			var submitFlag = false;
			function submitFn() {
				if(checkIdFlag && checkPasswordFlag && checkNameFlag && checkPhoneFlag) {
					submitFlag = true;
				}
				
				if(submitFlag) {
					$("form").submit();
				}
			}
		</script>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="join.do" method="post">
			<table>
				<tr>
					<th align="right">아이디<span style="color:red;">*</span> :</th>
					<td>
						<input type="text" name="id" id="id" onblur="checkFn(this)">
						<div class="msg"></div>
					</td>
				</tr>
				<tr>
					<th align="right">비밀번호<span style="color:red;">*</span> :</th>
					<td>
						<input type="password" name="password" id="password" onblur="checkFn(this)">
						<div class="msg"></div>
					</td>
				</tr>
				<tr>
					<th align="right">이름<span style="color:red;">*</span> :</th>
					<td>
						<input type="text" name="name" id="name" onblur="checkFn(this)">
						<div class="msg"></div>
					</td>
				</tr>
				<tr>
					<th align="right">나이 :</th>
					<td><input type="number" name="ageStr" id="ageStr"></td>
				</tr>
				<tr>
					<th align="right">성별 :</th>
					<td>
						<input type="radio" name="gender" value="M">남성
						<input type="radio" name="gender" value="F">여성
						<input type="radio" name="gender" value="">비공개
					</td>
				</tr>
				<tr>
					<th align="right">주소 :</th>
					<td><input type="text" name="addr"></td>
				</tr>
				<tr>
					<th align="right">전화번호<span style="color:red;">*</span> :</th>
					<td>
						<input type="text" name="phone" id="phone" onblur="checkFn(this)">
						<div class="msg"></div>
					</td>
				</tr>
			</table>
			<button type="button" onclick="submitFn()">가입하기</button>
		</form>
	</body>
</html>