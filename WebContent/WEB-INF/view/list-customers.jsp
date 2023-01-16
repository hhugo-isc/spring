<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
</head>
<body>

	List Customers - comming son ....
	<div id="wrapper">
		<div id="header"></div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<ul>
					<c:forEach var="customer" items="${customers }">
						<tr>
							<td>${customer.firstName }</td>
							<td>${customer.lastName }</td>
							<td>${customer.email }</td>
						</tr>
					</c:forEach>
				</ul>
			</table>
		</div>
	</div>

</body>
</html>