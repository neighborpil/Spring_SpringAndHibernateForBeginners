<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	
	<hr>

	<!-- Display user name and role -->
	<p>
	
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	
	<security:authorize access="hasRole('MANAGER')">
		<hr>
	
		<!-- Add a link to point to /leaders .. this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath }/leaders">
				Leadership Meeting
			</a> 
			(Only for Manager peoples)
		</p>

	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<hr>
	
		<!-- Add a link to point to /systems ... this is for the admin -->

		<p>
			<a href="${pageContext.request.contextPath }/systems">IT Systems Meeting</a>
			(Only for Admin peoples)
		</p>
	</security:authorize>

	<hr>
	<!-- Add a logout button -->	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
	
		<input type="submit" value="logout" />
	
	</form:form>

</body>
</html>