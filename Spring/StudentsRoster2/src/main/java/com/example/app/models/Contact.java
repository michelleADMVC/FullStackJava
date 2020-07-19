package com.example.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="contacts_info")
public class Contact {
	@Id
	@GeneratedValue
	private Long id;
	private String address;
	private String city;
	private String state;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
    private Student student;	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public Contact() {}
    public Contact(Student student,String address, String city, String state) {
    	this.student = student;
    	this.address = address;
    	this.city = city;
    	this.state = state;
    }
    public String getAddress() {
		return address;
	}
    public String getCity() {
		return city;
	}
    public String getState() {
		return state;
	}
    public Long getId() {
		return id;
	}
    public Student getStudent() {
		return student;
	}
}

