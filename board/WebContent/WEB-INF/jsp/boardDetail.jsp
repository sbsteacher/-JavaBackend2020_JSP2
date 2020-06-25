<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<div>
		<a href="/boardDel?bid=${data.bid}">
			<button>삭제</button>
		</a>
		<a href="/boardMod?bid=${data.bid}">
			<button>수정</button>
		</a>
	</div>
	<div>
		${data.bid}, ${data.title}, ${data.ctnt}, ${data.r_dt}
	</div>
</body>
</html>