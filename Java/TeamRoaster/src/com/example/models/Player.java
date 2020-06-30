package com.example.models;

public class Player {
	private String name;
	private String lastName;
	private int age;
	
	public Player(String name, String lastName,int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public String getLastName() {
		return lastName;
	}
	public String getName() {
		return name;
	}
	
}
