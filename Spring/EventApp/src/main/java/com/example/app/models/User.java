package com.example.app.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name= "users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
	private List<Event> attendingEvents;
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Event> hostedEvents;
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments ;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id")
    private Location location;
	public User() {}
	public User(String firstName,String lastName,String email,String password,Location location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.location = location;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public List<Event> getAttendingEvents() {
		return attendingEvents;
	}
    public List<Comment> getComments() {
		return comments;
	}
    public String getEmail() {
		return email;
	}
    public List<Event> getHostedEvents() {
		return hostedEvents;
	}
    public String getLastName() {
		return lastName;
	}
    public String getFirstName() {
		return firstName;
	}
    public Long getId() {
		return id;
	}
    public Location getLocation() {
		return location;
	}
    public String getPassword() {
		return password;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    
}
