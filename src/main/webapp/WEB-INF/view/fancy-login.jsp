<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Reference Bootstrap Files -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<title>Fancy Login</title>
</head>
<body>

	<div class="container">
		<div id="loginbox" style="margin: 50px auto;"
			class="col-md-6 col-md-offset-2 col-sm-6 col-sm-offset-2">

			<div class="card">

				<div class="card-header">
					<div class="card-title">Sign In</div>
				</div>

				<div style="padding-top: 30px;" class="card-body">

					<!-- Login Group -->
					<form:form
						action="${pageContext.request.contextPath}/authenticateTheUser"
						method="POST">

						<!-- Place for messages: erorr, alert etc -->
						<div class="row">
							<div class="col-xs-12">
								<div>
									<c:if test="${param.error != null}">
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											Invalid username and password</div>
									</c:if>

									<c:if test="${param.logout != null}">
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out</div>
									</c:if>
								</div>
							</div>
						</div>

						<!-- User name -->
						<div style="margin-bottom: 25px;" class="input-group">
							<span class="input-group-text"><i class="bi bi-person"></i></span>
							<input type="text" name="username" placeholder="username"
								class="form-control" />
						</div>

						<!--  Password  -->
						<div style="margin-bottom: 25px;" class="input-group">
							<span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
							<input type="text" name="password" placeholder="password"
								class="form-control" />
						</div>

						<!--  Login/Submit Button  -->
						<div style="margin-bottom: 10px;" class="row">
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-success">Login</button>
							</div>
						</div>

					</form:form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
