package com.example.models;

public class Samurai extends Human {
	public static int samuraiCount = 0;
	public Samurai(String name) {
		super(name);
		this.setHealth(200);
		samuraiCount++;
	}
	public void deathBlow(Human target){
		target.setHealth(0);
		this.setHealth(this.getHealth()/2);
		System.out.println(this.getName() + " a eliminado a : "+ target.getName());
	}
	public void meditate(){
		int healPoints = this.getHealth()/2;
		this.setHealth(this.getHealth()+healPoints);
		System.out.println(this.getName() + " a meditado");
	}
	public int howMany(){
		return samuraiCount;
	}

}
