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
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	String firstName;
	String lastName;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@OneToOne(mappedBy="person",cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private License license;
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Person(){}
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public License getLicense() {
		return license;
	}
	public String getLicenseNumber(){
		return this.getLicense().getNumber();
	}
	public Long getId() {
		return id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSelectOptionString(){
		return this.firstName+" " + lastName;
	}
	
}
