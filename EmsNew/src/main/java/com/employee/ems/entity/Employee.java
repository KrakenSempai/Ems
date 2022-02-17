package com.employee.ems.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "employee")
public class Employee {
	
	@Id
	private int employeeid;
	private String employee;
	private String jobName;
	
	

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employee=" + employee + ", jobName=" + jobName + "]";
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
}
