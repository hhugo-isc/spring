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
		First name: <form:input path="firstName"/>
		Last name: <form:input path="lastName"/>
		<br><br>
		Country: 
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>