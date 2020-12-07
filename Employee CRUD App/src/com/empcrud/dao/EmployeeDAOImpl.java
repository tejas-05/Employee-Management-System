package com.empcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empcrud.entity.Employee;
import com.empcrud.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	// declare reference variable of sql pkg
	Connection dBConnection;
	PreparedStatement ps;
	ResultSet resultSet;

	// initialize dbconnection
	public EmployeeDAOImpl() {
		dBConnection = DBConnectionUtil.getDBConnection();
		// System.out.println(dBConnection);
	}

	@Override
	public List<Employee> getAllEmployee() {

		// declare reference variable
		List<Employee> empList = null;
		Employee emp = null;

		try {
			// create emplist
			empList = new ArrayList<Employee>();
			// fire the query
			ps = dBConnection.prepareStatement("SELECT * FROM employees");
			// fetch all records & store into resultSet
			resultSet = ps.executeQuery();
			// store employee data into employee data member
			while (resultSet.next()) {
				emp = new Employee();
				emp.setEmpId(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpEmail(resultSet.getString(3));
				emp.setEmpProfile(resultSet.getString(4));
				emp.setEmpContact(resultSet.getString(5));
				// System.out.println(emp);
				// add employee object into list
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return employee list
		return empList;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		try {
			ps = dBConnection.prepareStatement("DELETE FROM employees WHERE id=?");
			ps.setInt(1, empId);
			ps.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		boolean flag = false;
		try {
			ps = dBConnection.prepareStatement("INSERT INTO employees(name,email,profile,contact) VALUES(?,?,?,?)");
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getEmpEmail());
			ps.setString(3, emp.getEmpProfile());
			ps.setString(4, emp.getEmpContact());
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee emp = null;
		try {
			ps = dBConnection.prepareStatement("SELECT * FROM employees WHERE id = ?");
			ps.setInt(1, empId);
			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				emp = new Employee();
				emp.setEmpId(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpEmail(resultSet.getString(3));
				emp.setEmpProfile(resultSet.getString(4));
				emp.setEmpContact(resultSet.getString(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(emp);
		return emp;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		boolean flag = false;
		try {
		ps = dBConnection.prepareStatement("UPDATE employees SET id=?, name=?, email=?, profile=?, contact=? WHERE id=?");
		ps.setInt(1, emp.getEmpId());
		ps.setString(2, emp.getEmpName());
		ps.setString(3,emp.getEmpEmail());
		ps.setString(4,emp.getEmpProfile());
		ps.setString(5,emp.getEmpContact());
		ps.setInt(6, emp.getEmpId());
		ps.executeUpdate();
		flag = true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
