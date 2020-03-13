package com.animal;

public class Gorilla extends Animal{

	public Gorilla(String name) {
		super(name);		
	}

	public void throwSomething() {
		System.out.println("Tirando algo");
		this.setEnergy(this.getEnergy()-5);
		
	}
	public void eatBananas() {
		System.out.println("Comiendo una banana");
		this.setEnergy(this.getEnergy()+10);
		
	}
	public void climb() {
		System.out.println("Escalando");
		this.setEnergy(this.getEnergy() - 10);
		
	}
	
}
