<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<% 
	String email_id = (String) session.getAttribute("email_id");
	if(email_id == null)
		response.sendRedirect("../index.jsp");
%>

	<div class="container">
		<div class="card">
			<div class="card-header text-center">Edit Employee</div>
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/EmployeeController" method="post">
					<div class="form-group">
						<label>Enter Id</label>
						<input type="text" class="form-control" name="emp_id" value="${employee.empId}" required>
						<label>Enter Name</label>
						<input type="text" class="form-control" name="emp_name" value="${employee.empName}" required>
						<label>Enter Email</label>
						<input type="email" class="form-control" name="emp_email" value="${employee.empEmail}" required>
						<label>Enter Profile</label>
						<input type="text" class="form-control" name="emp_profile" value="${employee.empProfile}" required>
						<label>Enter Contact</label>
						<input type="number" class="form-control" name="emp_contact" value="${employee.empContact}" required><br>
						<input type="submit" class="btn btn-success" value="Update Employee">
					</div>
				</form>
		</div>
	</div>
	</div>
</body>
</html>