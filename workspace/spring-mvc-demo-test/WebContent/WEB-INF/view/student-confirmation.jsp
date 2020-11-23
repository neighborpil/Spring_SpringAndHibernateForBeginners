<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Student: ${student.firstName } ${student.lastName }	
	<br><br>
	Country: ${student.country }	
	<br><br>
	FavoriteLanguage: ${student.favoriteLanguage }
	<br><br>
	Operating Systems:
	<c:forEach var="temp" items="${student.operatingSystems }">
		<li>${temp}</li>
	</c:forEach>

</body>
</html>