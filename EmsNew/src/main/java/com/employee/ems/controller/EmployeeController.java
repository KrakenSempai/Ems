package com.employee.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.ems.entity.Employee;
import com.employee.ems.exception.ResourceNotFoundException;
import com.employee.ems.repository.EmployeeRepo;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	//Adding Employee
	@PostMapping("/addEmployee")
	public String addEmployeeDetails(@RequestBody Employee employee) {
		empRepo.save(employee);
		String details = employee.getEmployee()+ " added with EmployeeId:"+ employee.getEmployeeid();
		return details;
	}
	
	//Getting particular EmployeeDetail
		@GetMapping("/findAllEmployees/{employeeid}")
		public Optional<Employee> getEmployee(@PathVariable int employeeid) {
			return empRepo.findById(employeeid);
		}
	
	//Getting All Employee Details
	@GetMapping("/findAllEmployees")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	

	//Update the Details of particular Employee
	@PutMapping("/updateEmployeeDetails/{employeeid}")
	public ResponseEntity<Employee> updateEmployeeDetail(@PathVariable int employeeid, @RequestBody Employee employee)
		throws ResourceNotFoundException{
		//return empRepo.insert(employee);
	
			Employee empl = empRepo.findById(employeeid)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeid));

			empl.setEmployee(employee.getEmployee());
			empl.setEmployeeid(employee.getEmployeeid());
			empl.setJobName(employee.getJobName());
			
			final Employee updatedEmployee = empRepo.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
	

	

	//Deleting the particular Employee
	@DeleteMapping("/delete/{employeeid}")
	public String deleteEmployee(@PathVariable int employeeid) {
		empRepo.deleteById(employeeid);
		return "Employee details deleted with id : " + employeeid;
	}

}
