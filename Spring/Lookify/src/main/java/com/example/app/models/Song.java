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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song implements Comparable<Song>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String artist;
	private int rating;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Song(String title, String artist, int rating) {
    	this.title = title; 
    	this.artist = artist;
    	this.rating = rating;
    }
    public Song() {}
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	public String getArtist() {
		return artist;
	}
	
	public Long getId() {
		return id;
	}
	public int getRating() {
		return rating;
	}
	public String getTitle() {
		return title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int compareTo(Song compareSong) {
		int compareQuantity = ((Song) compareSong).getRating();
		return compareQuantity - this.rating;

	}
}
