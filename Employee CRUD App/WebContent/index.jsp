<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Employee CRUD System</title>
</head>
<body>

<%
	String email_id = (String) session.getAttribute("email_id");
	if(email_id != null){
		response.sendRedirect("EmployeeController?action=LIST");
	}
	
%>

	<div class="container">
		<div class="card">
			<div class="card-header text-center">
				<h3>Login</h3>
			</div>
			<form action="LoginController" method="post">
				<div class="card-body">
					<div class="form-group">
						<input type="email" name="user_email" placeholder="Enter Email"
							class="form-control" required> <br>
							<input type="password" name="user_password"
							placeholder="Enter Password" class="form-control" required="required">
					</div>
				</div>
				<div class="card-footer">
					<input type="submit" value="Login" class="btn btn-success">
					<input type="reset" value="Reset" class="btn btn-warning">
				</div>
			</form>
		</div>
	</div>
</body>
</html>