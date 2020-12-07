package com.empcrud.entity;

public class Employee {
	private int empId;
	private String empName;
	private String empEmail;
	private String empProfile;
	private String empContact;
	
	public Employee() {	
	}
	
	public Employee(int empId, String empName, String empEmail, String empProfile, String empContact) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empProfile = empProfile;
		this.empContact = empContact;
	}

	public Employee(String empName, String empEmail, String empProfile, String empContact) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empProfile = empProfile;
		this.empContact = empContact;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpProfile() {
		return empProfile;
	}
	public void setEmpProfile(String empProfile) {
		this.empProfile = empProfile;
	}
	public String getEmpContact() {
		return empContact;
	}
	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empProfile="
				+ empProfile + ", empContact=" + empContact + "]";
	}
}
