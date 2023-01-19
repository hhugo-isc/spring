<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.failed {
	color: red;
}
</style>
<title>Custom Login Page</title>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<!-- Check for Login error -->
		<c:if test="${param.error != null}">
			<i class="failed">Sorry! You entered invalid username/password</i>
		</c:if>

		<p>
			User Name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="text" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>