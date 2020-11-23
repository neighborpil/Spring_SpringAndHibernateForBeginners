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
	<image src="${pageContext.request.contextPath }/resources/images/Neighborpil.png">
	<br><br>
	<input type="button" onClick="jsTest()" value="JS Test">
	<br><br>
	<form action="processFormVersionTwo" method="GET">
		<input  type="text" name="studentName" placeholder="What's your name?" />
		<input type="submit" class="toRed" />
	</form>
	<br><br>
	<form action="processFormVersionThree" method="GET">
		<input  type="text" name="studentName" placeholder="What's your name?" />
		<input type="submit" class="toRed" />
	</form>
</body>
</html>