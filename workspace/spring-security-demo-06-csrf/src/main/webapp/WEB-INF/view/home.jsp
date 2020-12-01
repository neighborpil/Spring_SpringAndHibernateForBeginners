<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Security Test</title>
</head>
<body>

	<h2>neighborpil company home page - Yoohoooo</h2>	
	<hr>
	<p>
		Welcome to the neighborpil company home page
	</p>
	
	<!-- Add a logout button -->	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
	
		<input type="submit" value="logout" />
	
	</form:form>

</body>
</html>