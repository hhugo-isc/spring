package com.hh.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hh.springrestdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

//	define @postConstruct to load the student data ... only once
	@PostConstruct
	public void loadData() {
		this.students = new ArrayList<>();
		students.add(new Student("John", "Doe"));
		students.add(new Student("Mary", "Public"));
		students.add(new Student("Mario", "Rossi"));
	}

//	define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return this.students;
	}

//	define endpoint for "/students/{studentId}" - return Student with id = studentId
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}

//	add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
//		create StudentErrorResponse
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
