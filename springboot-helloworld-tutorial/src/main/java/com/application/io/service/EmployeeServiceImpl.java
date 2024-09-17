package com.application.io.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.io.model.Employee;
import com.application.io.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeId(int id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		Employee employee = null;
		if (emp.isPresent()) {
			employee = emp.get();
		} else {
			throw new RuntimeException("Employee is not found fopr this : " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeId(int id) {
		this.employeeRepo.deleteById(id);

	}

}
