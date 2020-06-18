package com.example.test;
import com.example.models.*;
public class HumanTest {

	public static void main(String[] args) {
		 ninjaTest();
		
		
	}
	public static void humanTest() {
		Human test1 = new Human("Cachilupi");
		Human test2 = new Human("Jaime");
		test1.displayInfo();
		test2.attack(test1); //Prueba de ataque
		test1.displayInfo();
	}
	public static void wizardTest() {
		Wizard test1 = new Wizard("Cachilupi");
		Human test2 = new Human("Jaime");
		test1.displayInfo();
		test2.displayInfo();
		test1.fireBall(test2); //Prueba de fireball
		test2.displayInfo();
		test1.heal(test2); //Prueba de heal
		test2.displayInfo();		
	}
	public static void samuraiTest() {
		Samurai test1 = new Samurai("Cachilupi");
		Human test2 = new Human("Jaime");
		test1.displayInfo();
		test2.displayInfo();
		test1.deathBlow(test2); //Prueba de deathblow
		test1.displayInfo();
		test2.displayInfo();
		test1.meditate(); //Prueba de meditate
		test1.displayInfo();
		System.out.println("Hay "+test1.howMany()+" samurais");
		howManyTest(31);//Prueba de howmany
		System.out.println("Hay "+test1.howMany()+" samurais");
	}
	public static void howManyTest(int cant) {
		System.out.println("Creando "+cant+" samurais");
		for (int i = 0; i < cant; i++) {
			new Samurai("Samurai"+i);
		}
	}
	public static void ninjaTest() {
		Ninja test1 = new Ninja("CachilupiNocturna");
		Human test2 = new Human("Jaime");
		test1.displayInfo();
		test1.steal(test2);
		test1.displayInfo();
		test2.displayInfo();
		test1.runaway();
		test1.displayInfo();
	}
	
}
