package com.employee.ems.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.ems.entity.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer>{

}
