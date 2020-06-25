<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<div>글수정 화면</div>
	<div>
		<form id="frm" action="/boardMod" method="post">
			<input type="hidden" name="bid" value="${data.bid}">
			<div>
				<label>제목 : <input type="text" name="title" value="${data.title }"></label>
			</div>
			<div>
				<textarea name="ctnt">${data.ctnt}</textarea>
			</div>
			<div>				
				<input type="submit" value="수정">				
			</div>
		</form>	
	</div>
</body>
</html>