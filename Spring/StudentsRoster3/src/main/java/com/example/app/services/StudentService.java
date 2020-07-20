package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Dormitory;
import com.example.app.models.Student;
import com.example.app.repositories.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepo;
	public StudentService(StudentRepository inject){
		this.studentRepo = inject;
	}
	public void saveStudent(Student student){
		this.studentRepo.save(student);
	}
	public Student getById(Long id) {
		Optional<Student> findStudent= this.studentRepo.findById(id);
		if (findStudent.isPresent()) {
			return findStudent.get();
		}
		return null;
	}
	public List<Student> getAll(){
		return this.studentRepo.findAll();
	}
	public void newStudent(String firstName, String lastName, int age){
		this.saveStudent(new Student(age, firstName,lastName));
	}
	public void addDormitoryToStudent(Dormitory dorm, Long studentId){
		Student student = this.getById(studentId);
		student.setDormitory(dorm);
		this.saveStudent(student);
	}
	public void removeDormitoryStudent(Student student){
		student.deleteDormitory();
		this.saveStudent(student);
	}
}
