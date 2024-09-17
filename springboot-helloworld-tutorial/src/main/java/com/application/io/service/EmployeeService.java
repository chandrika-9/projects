package com.application.io.service;

import java.util.List;

import com.application.io.model.Employee;




public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeId(int id);
	void deleteEmployeeId(int id);
	
	

}
