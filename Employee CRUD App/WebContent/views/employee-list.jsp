<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">	
		
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.22/datatables.min.css"/>

<meta charset="ISO-8859-1">
<title>Employee CRUD App</title>
<body>

<%
	String email_id = (String) session.getAttribute("email_id");
	if(email_id == null)
		response.sendRedirect("index.jsp");
%>


	<div class="container">
	
	<div class="float-right">
		<a href="logout.jsp" class="btn btn-danger">Log Out</a>	
	</div>
	
		<h3 align="center">Employee List</h3>
		<hr>
		<button class="btn btn-primary"
			onclick="window.location.href='views/add-employee.jsp'">Add
			Employee</button>
		<br>
		<br>
		<table class="table table-striped table-bordered" id="myTable">

			<thead>
				<tr class="thead-dark">
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Profile</th>
				<th>Contact No</th>
				<th>Action</th>
			</tr>		
			</thead>
			
			<tbody>		
			<c:forEach items="${emplist}" var="emp">
				<tr>
					<td>${emp.empId}</td>
					<td>${emp.empName}</td>
					<td>${emp.empEmail}</td>
					<td>${emp.empProfile}</td>
					<td>${emp.empContact}</td>
					<td><a
						href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${emp.empId}"
						class="btn btn-info">Edit</a> | <a
						href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${emp.empId}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
			
			</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.22/datatables.min.js"></script>	
	<script>
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );
	</script>
</body>
</html>