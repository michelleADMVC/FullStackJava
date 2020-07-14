package com.example.app.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name= "students")
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private int age;
	private String firstName;
	private String lastName;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="student",cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private Contact contact;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public Student(){}
    public Student(int age, String firstName, String lastName) {
    	this.age = age;
    	this.firstName=firstName;
    	this.lastName = lastName;
    }
    public Long getId() {
		return id;
	}
    public String getFirstName() {
		return firstName;
	}
    public String getLastName() {
		return lastName;
	}
    public int getAge() {
		return age;
	}
    public Contact getContact() {
		return contact;
	}
    public String getSelectOptionString(){
		return this.firstName+" " + lastName;
	}
}
