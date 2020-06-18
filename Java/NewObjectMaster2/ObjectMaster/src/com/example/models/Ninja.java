package com.example.models;

public class Ninja extends Human {
	
	public Ninja(String name) {
		super(name);
		this.setStealth(10);
	}
	public void steal(Human target){
		int stealPoints = this.getStealth();
		target.setHealth(target.getHealth()-stealPoints);
		this.setHealth(this.getHealth()+stealPoints);
		System.out.println(this.getName() + " a robado vida de : "
		+ target.getName());
	}
	public void runaway(){
		this.setHealth(this.getHealth()-10);
		System.out.println(this.getName() + " a huido ");
	}
}
