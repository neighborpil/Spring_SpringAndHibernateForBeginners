<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<script src="${pageContext.request.contextPath }/resources/js/main.js"></script>
</head>
<body>
	<img alt="logo" src="${pageContext.request.contextPath }/resources/images/Neighborpil.png">
	<br><br>
	<input type="button" class="toRed" onclick="jsTest()" value="JS Test" />
	<br><br>
	<form action="processForm" method="GET">
		<input type="text" name="studentName" placeholder="What's your name?" />
		<input type="submit" />
	</form>
	<br><br>
	<form action="processFormTwo" action="GET">
		<input type="text" name="studentName" placeholder="What's ur name" />
		<input type="submit" value="Ask">
	</form>
	
</body>
</html>