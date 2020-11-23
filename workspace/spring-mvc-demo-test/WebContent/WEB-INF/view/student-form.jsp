<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<br><br>
		Last Name: <form:input path="lastName" />
		<br><br>

		Country: 
		<form:select path="country">
			<form:options items="${countryOptions }" />
		</form:select>
		<br><br>
		<form:radiobuttons path="favoriteLanguage" items="${favoriteLanguageOptions }"/>
		<br><br>
		<form:checkboxes path="operatingSystems" items="${operatingSystemOptions }"/>
		<br><br>
		<input type="submit" name="Submit" />
	</form:form>
</body>
</html>