package com.example.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.repositories.ClassRepository;
import com.example.app.models.Class;
import com.example.app.models.Student;

@Service
public class ClassService {
	private ClassRepository classRepo;
	public ClassService(ClassRepository inject) {
		this.classRepo = inject;
	}
	public void saveClass(Class newClass) {
		this.classRepo.save(newClass);
	}
	public void newClass(String name){
		classRepo.save(new Class(name));
	}
	public List<Class> getAll(){
		return this.classRepo.findAll();
	}
	public Class getById(Long id) {
		Optional<Class> newClass = this.classRepo.findById(id);
		if (newClass.isPresent()) {
			return newClass.get();
		}
		return null;
	}
	public List<Class> getAvailableClassesForStudent(Student student){
		return null;
	}
	public void addStudent(Long classId, Student student) {
		Class newClass = this.getById(classId);
		newClass.addStudent(student);
		this.saveClass(newClass);
	}
	public void removeStudent(Long classId, Student student) {
		Class newClass = this.getById(classId);
		newClass.removeStudent(student);
		this.saveClass(newClass);
	}
}
