package com.example.demo.models;

public class Survey {
	private String name;
	private String location;
	private String favLenguage;
	private String comment;
	
	public Survey(String name, String location, String favLenguage, String comment) {
		this.name = name;
		this.location = location;
		this.favLenguage = favLenguage;
		
		if (comment.equals("")) {
			System.out.println("Detectado comment null");
			this.comment = "No comment";
		}else {
			this.comment = comment;
		}
	}
	public String getName() {
		return name;
	}
	public String getComment() {
		return comment;
	}
	public String getFavLenguage() {
		return favLenguage;
	}
	public String getLocation() {
		return location;
	}
	public void showResults() {
		System.out.println("Resultados de la encuesta");
		System.out.println(this.name);
		System.out.println(this.location);
		System.out.println(this.favLenguage);
		System.out.println(this.comment);
	}
}
