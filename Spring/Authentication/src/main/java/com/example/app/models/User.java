package com.example.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private String email;
 private String password;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 public User() {
 }
 public User(String firstName, String lastName, String email, String password){
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.email = email;
	 this.password = password;
 }
 
 public String getFirstName() {
	return firstName;
}
 public String getLastName() {
	return lastName;
}
 public String getPassword() {
	return password;
}

 public Long getId() {
	return id;
}
 public void setPassword(String password) {
	this.password = password;
}
 public String getEmail() {
	return email;
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
