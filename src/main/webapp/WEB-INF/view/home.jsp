<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company Home Demo</title>
</head>
<body>

	<h2>Company Home Page</h2>
	<hr>
	<p>Welcome to the Company Home Page</p>
	<hr>

	<!-- Display username and role -->
	<p>
		User: 
		<security:authentication property="principal.username" />
		<br> <br> 
		Roles(s): <security:authentication property="principal.authorities" />
	</p>

	<hr>


	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>

</body>
</html>