package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	//create
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//read
	public List<Student> findAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	
	//update
	public void updateStudent(Integer id, Student s) {
		
		Optional<Student> optStudent = studentRepository.findById(id);
		if(optStudent.get()!=null) {
			s.setId(optStudent.get().getId());
			studentRepository.save(s);
		}
	}
	
	//delete
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}
	
}
