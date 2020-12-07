package com.empcrud.dao;

import java.util.List;

import com.empcrud.entity.Employee;

public interface EmployeeDAO {
	List<Employee> getAllEmployee();
	
	boolean addEmployee(Employee emp);
	
	Employee getEmployee(int empId);
	
	boolean updateEmployee(Employee emp);
	
	boolean deleteEmployee(int empId);
}
