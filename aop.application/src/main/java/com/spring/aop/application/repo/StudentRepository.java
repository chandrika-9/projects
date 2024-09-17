package com.spring.aop.application.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.aop.application.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	
  Optional<Student> findById(long id);
  
}
