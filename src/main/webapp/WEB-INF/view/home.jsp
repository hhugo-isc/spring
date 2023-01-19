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
		<br> <br> Roles(s):
		<security:authentication property="principal.authorities" />
	</p>


	<!-- Add a link to point to /leaders ... this is for the managers -->

	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership
			Meeting</a> (Only for Manager peeps)
	</p>
	
	<!-- Add a link to point to /systems ... this is for the managers -->
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for ADMIN peeps)
	</p>

	<hr>


	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>

</body>
</html>