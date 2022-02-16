package com.employee.entity;

public class Employee {
	
	private String employeeName;
	private String employeeId;
	private String jobLeave;
	
	public Employee(String employeeName, String employeeId, String jobLeave) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.jobLeave = jobLeave;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", jobLeave=" + jobLeave + "]";
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getJobLeave() {
		return jobLeave;
	}
	public void setJobLeave(String jobLeave) {
		this.jobLeave = jobLeave;
	}
	
	
	

}
