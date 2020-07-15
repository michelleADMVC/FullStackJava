package com.example.app.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public Ninja() {}
    public Ninja(Dojo dojo,String first_name,String last_name, int age) {
    	this.dojo = dojo;
    	this.firstName = first_name;
    	this.lastName = last_name;
    	this.age = age;
    }
    
    public int getAge() {
		return age;
	}
    public Dojo getDojo() {
		return dojo;
	}
    public String getFirstName() {
		return firstName;
	}
    public long getId() {
		return id;
	}
    public String getLastName() {
		return lastName;
	}
 
    
}
