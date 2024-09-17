package com.spring.aop.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.aop.application.entity.Student;
import com.spring.aop.application.repo.StudentRepository;

public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentId(@PathVariable("id") Long id) {
		Optional<Student> studentId = studentRepository.findById(id);
		if (studentId.isPresent()) {
			return new ResponseEntity<>(studentId.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getStudent")
	public ResponseEntity<List<Student>> getAllEmployee() {
		List<Student> studentData = studentRepository.findAll();
		return new ResponseEntity<>(studentData, HttpStatus.OK);
	}

	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student studentDetails = studentRepository.save(new Student(student.getId(), student.getFirstName(),
				student.getLastName(), student.getAddress(), student.getDepartment(), student.getMarks()));
		return new ResponseEntity<>(studentDetails, HttpStatus.CREATED);

	}

	@PutMapping("/updateStudent/{id)")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {

		Optional<Student> studentValue = studentRepository.findById(id);
		if (studentValue.isPresent()) {
			Student studentDetails = studentValue.get();

			studentDetails.setFirstName(student.getFirstName());
			studentDetails.setLastName(student.getLastName());
			studentDetails.setAddress(student.getAddress());
			studentDetails.setDepartment(student.getDepartment());
			studentDetails.setMarks(student.getMarks());

			return new ResponseEntity<>(studentDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		studentRepository.deleteById(id);
	
	}	 
}
