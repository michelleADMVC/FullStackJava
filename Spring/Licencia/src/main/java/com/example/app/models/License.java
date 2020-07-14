package com.example.app.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.example.app.services.TimeService;

@Entity
@Table(name="licenses")
public class License {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public License() {}
    
    public License(String number,Date expDate,String state,Person person){
    	this.number = number;
    	this.expirationDate = expDate;
    	this.state = state;
    	this.person = person;
    }
	
    public Long getId() {
		return id;
	}
    public String getState() {
		return state;
	}
    public String getNumber() {
		return number;
	}
    public Date getExpirationDate() {
		return expirationDate;
	}
    public String getParsedExpirationDate() {
 		return TimeService.getFormaterDate("EEEE dd MMMM yyyy",expirationDate);
 	}
    public Person getPerson() {
		return person;
	}
    public Date getUpdatedAt() {
		return updatedAt;
	}
    
	
}
