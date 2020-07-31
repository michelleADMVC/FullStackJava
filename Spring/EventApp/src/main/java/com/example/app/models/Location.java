package com.example.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name = "locations")
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	private String address;
	private String state;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="location", fetch = FetchType.LAZY)
	private List<User> Users ;
	@OneToMany(mappedBy="location", fetch = FetchType.LAZY)
	private List<Event> Events ;
	public Location() {}
	public Location(String address, String state) {
		this.address = address;
		this.state = state;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Long getId() {
		return id;
	}
    public String getAddress() {
		return address;
	}
    public String getState() {
		return state;
	}
}
