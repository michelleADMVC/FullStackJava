package com.animal;

public class Bat extends Animal{

	public Bat(String name) {
		super(name);
		this.setEnergy(300);
	}
	public void fly() {
		System.out.println("Volando");
		this.setEnergy(this.getEnergy()-50);
	}
	public void eatHumans() {
		System.out.println("Bueno, no importa");
		this.setEnergy(this.getEnergy()+25);
	}
	public void atackTown() {
		System.out.println("Sonido de ciudad en llamas*");
		this.setEnergy(this.getEnergy()-100);
	}
//	Para el método fly(), mostrar el sonido que hace el Bat al despegar y disminuir su nivel de energía en 50.
//	Para el método eatHumans(), Imprimir “bueno, no importa” e incrementar su nivel de energía en 25.
//	Para el método attackTown(), mostar en pantalla el sonido de la ciudad en llamas y disminuir su nivel de energía en 100.
}
