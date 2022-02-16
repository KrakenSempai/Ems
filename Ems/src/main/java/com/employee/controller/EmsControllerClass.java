package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmsControllerClass {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return this.employeeService.getAllEmployee();	
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeDetails(@PathVariable String employeeId) {
		return this.employeeService.getEmployeeDetails(employeeId);
		
	}
	
	@PutMapping("/employee")
	public Employee updateEmployeeDetail(Employee employee) {
		return this.employeeService.updateEmployeeDetail(employee);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployeeDetails(@PathVariable String employeeId) {
		try {
			
			this.employeeService.deleteEmployeeDetails(employeeId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
