package com.example.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.app.models.Dormitory;
import com.example.app.models.Student;
import com.example.app.repositories.DormitoryRepository;

@Service
public class DormitoryService {
	private DormitoryRepository dormRepo;
	public DormitoryService(DormitoryRepository inject) {
		this.dormRepo = inject;
	}
	public List<Dormitory> getAll(){
		return this.dormRepo.findAll();
	}
	public void saveDorm(Dormitory dormitory){
		this.dormRepo.save(dormitory);
	}
	public Dormitory getById(Long id) {
		Optional<Dormitory> dormitory = this.dormRepo.findById(id);
		if (dormitory.isPresent()) {
			return dormitory.get();
		}
		return null;
	}
	
	public List<Student> getStudentsDormitory(Long dormId){
		return this.getById(dormId).getStudents();
	}
	public void newDormitory(String name){
		this.dormRepo.save(new Dormitory(name));
	}
	public List<Student> getAvailableStudents(List<Student> students) {
		List<Student> availableStudents = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getDormitory() == null) {
				availableStudents.add(students.get(i));
				
			}
		}
	return availableStudents;
	}
	
}
