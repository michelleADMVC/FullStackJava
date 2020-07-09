package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first_name;
	private String last_name;
	private String password;
	private String email;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public User(String first_name, String last_name, String password, String email){
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.password = password;
    	this.email = email;
    }
    public User() {};
    public Date getCreatedAt() {
		return createdAt;
	}
    public String getEmail() {
		return email;
	}
    public String getFirst_name() {
		return first_name;
	}
    public Long getId() {
		return id;
	}
    public String getLast_name() {
		return last_name;
	} 
    public String getPassword() {
		return password;
	}
    public Date getUpdatedAt() {
		return updatedAt;
	}
    public void setEmail(String email) {
		this.email = email;
	}
    public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
    public void setId(Long id) {
		this.id = id;
	}
    public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
