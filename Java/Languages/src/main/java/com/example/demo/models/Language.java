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
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String creator;
	private String currentVersion;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	public Language(String name, String creator, String currentVersion) {
		this.name = name;
		this.creator =creator;
		this.currentVersion = currentVersion;
	}
	public Language(){}
	public Date getCreatedAt() {
		return createdAt;
	}
	public String getCreator() {
		return creator;
	}
	public String getCurrentVersion() {
		return currentVersion;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
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
