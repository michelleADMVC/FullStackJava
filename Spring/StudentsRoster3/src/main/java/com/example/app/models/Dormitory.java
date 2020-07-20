package com.example.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.criteria.Join;

@Entity
@Table(name="dormitories")
public class Dormitory {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Column(updatable = false )
	private Date createdAt;
	private Date updatedAt;
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    @OneToMany(mappedBy="dormitory", fetch = FetchType.LAZY)
    List<Student> students;
    
    public Dormitory() {}
    public Dormitory(String name) {
    	this.name = name;
    }
    public void addStudent(Student student) {
    	this.students.add(student);
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
    
}
