package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> list;
	
	public EmployeeServiceImpl() {
		list = new ArrayList<>();
		list.add(new Employee("Abc","E01","System Eng"));
		list.add(new Employee("Xyz","E02","Analist"));
		list.add(new Employee("Pqr","E03","Senior System Eng"));
		
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		return list;
	}

	@Override
	public Employee getEmployeeDetails(String employeeId) {
		// TODO Auto-generated method stub
		
		Employee emp = null;
		for(Employee e:list) {
			if(e.getEmployeeId().equals(employeeId)) {
				emp = e;
				break;
			}
		}
		return emp;
	}

	@Override
	public Employee addEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		list.add(employee);
		return employee;
	}
	
	@Override
	public Employee updateEmployeeDetail(Employee employee) {
		// TODO Auto-generated method stub
		list.forEach(e -> {
			if(e.getEmployeeId().equals(employee.getEmployeeId())) {
				e.setEmployeeName(employee.getEmployeeName());
				e.setJobLeave(employee.getJobLeave());
				
			}
		});
		return employee;
	}

	@Override
	public void deleteEmployeeDetails(String employeeId) {
		// TODO Auto-generated method stub
		list = this.list.stream().filter(e -> e.getEmployeeId()!= employeeId).collect(Collectors.toList());
		
	}


	
	
}
