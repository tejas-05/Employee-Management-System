package com.empcrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empcrud.dao.EmployeeDAO;
import com.empcrud.dao.EmployeeDAOImpl;
import com.empcrud.entity.Employee;

public class EmployeeController extends HttpServlet {

	EmployeeDAO empDao;
	RequestDispatcher dispatcher = null;

	// initialize empdao object
	public EmployeeController() {
		super();
		empDao = new EmployeeDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		if (action == null) {
			action = "LIST";
		}

		switch (action) {
		case "LIST":
			showAllEmployees(request, response);
			break;
		case "EDIT":
			getSingleEmployee(request, response);
			break;
		case "DELETE":
			deleteEmployee(request, response);
			break;
		default:
			showAllEmployees(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// fetch values from form
		String empId = request.getParameter("emp_id");
		String empName = request.getParameter("emp_name");
		String empEmail = request.getParameter("emp_email");
		String empProfile = request.getParameter("emp_profile");
		String empContact = request.getParameter("emp_contact");
		//System.out.println(empId + " "+empName + " " + empProfile +" " + empEmail + " " + empContact);
		
		
		if(empId == null) { // add employee
			 Employee emp = new Employee(empName, empEmail, empProfile, empContact);
			 empDao.addEmployee(emp);
		}
		else { // update employee
			Employee emp = new Employee(Integer.parseInt(empId), empName, empEmail, empProfile, empContact);
			boolean flag = empDao.updateEmployee(emp);
		}
		// redirect to employee list 
		showAllEmployees(request, response);
	}

	public void showAllEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// store employee list
		List<Employee> empList = empDao.getAllEmployee();
		// set employee list attribute
		request.setAttribute("emplist", empList);
		// forward employee list to response
		dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		dispatcher.forward(request, response);

	}

	public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println("id:" + id);
		Employee employee = empDao.getEmployee(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		dispatcher = request.getRequestDispatcher("/views/edit-employee.jsp");
		dispatcher.forward(request, response);
	}
	
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		int empId = Integer.parseInt(request.getParameter("id"));
		boolean flag = empDao.deleteEmployee(empId);
		System.out.println(flag);
		showAllEmployees(request, response);
		//System.out.println("id:"+ request.getParameter("id"));
		
	}

}
