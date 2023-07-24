<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="<%= request.getContextPath() %>/js/jquery-3.6.3.min.js"></script>
		<script>
			/* $(document).ready(function() {
				alert("JQuery 동작!");
			});
			$(function() {
				alert("JQuery 동작!");
			}); */
			
			function ajaxCallFn1() {
				$.ajax({
					url:"stringCall.do",
					type:"get",
					success:function(data) {
						$("#result").text(data);
					},
					error:function() {
						alert("예외발생!");
					}
				});
			}
			
			/* jackson 라이브러리로 객체를 json으로 변환 */
			function ajaxCallJSON() {
				$.ajax({
					url:"jsonCall.do",
					type:"post",
					data:"bidx=1",
					success:function(data) {
						console.log(data.title);
						console.log(data.id);
					},
					error:function() {
						alert("예외발생!");
					}
				});
			}
			
			function findBoardFn() {
				$.ajax({
					url:"findBoard.do",
					type:"get",
					data:"bidx="+$("#bidx").val(),
					success:function(data) {
						if(data != '') {
							var html =	 data.title+"<br>"
										+data.id+"<br>"
										+data.wdate+"<br>"
										+data.hit+"<br>"
										+data.body;
							$("#result").html(html);
						}else {
							$("#result").html("");
						}
					},
					error:function() {
						alert("예외발생!");
					}
				});
			}
			
			function idCheckFn() {
				$.ajax({
					url:"idCheck.do",
					type:"get",
					data:"id="+$("#id").val(),
					success:function(data) {
						if(data==0) {
							$("#idCheck").html("<p style='color:green;'>사용할 수 있는 아이디입니다.</p>");
						}else {
							$("#idCheck").html("<p style='color:red;'>이미 존재하는 아이디입니다.</p>");
						}
					},
					error:function() {
						alert("예외발생!");
					}
				});
			}
		</script>
	</head>
	<body>
		<h2>ajax 샘플페이지</h2>
		<button onclick="ajaxCallFn1()">click</button>
		<button onclick="ajaxCallJSON()">click2</button>
		<hr>
		<input type="number" id="bidx"><button onclick="findBoardFn()">find board</button>
		<div id="result"></div>
		<hr>
		ID : <input type="text" id="id" onblur="idCheckFn()">
		<div id="idCheck"></div>
	</body>
</html>