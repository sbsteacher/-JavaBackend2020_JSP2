<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div>글쓰기 화면</div>
	<div>
		<form id="frm" action="/boardWrite" method="post" onsubmit="chk()">
			<div>
				<label>제목 : <input type="text" name="title"></label>
			</div>
			<div>
				<textarea name="ctnt"></textarea>
			</div>
			<div>				
				<input type="submit" value="저장">
				<input type="reset" value="새로작성">
			</div>
		</form>	
	</div>
	<script>
		function chk() {
			alert('체크!!')	
		}
	</script>
</body>
</html>