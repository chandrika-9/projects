package com.application.io.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.io.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
