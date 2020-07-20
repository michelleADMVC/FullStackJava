package com.example.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class Class {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "classes_students", 
        joinColumns = @JoinColumn(name = "class_id"), 
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
	private List<Student>students;
	public Class(){}
	public Class(String name){
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Student> getStudents() {
		return students;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public void addStudent(Student student) {
		this.students.add(student);
		
	}
	public void removeStudent(Student student) {
		this.students.remove(student);
		student.getClasses().remove(this);
	}
}
