package com.example.controllers;

import java.util.Random;

public class Generator {
	private static String[] silabas = 
		{"sa","as","la","mi","po","pe","las","os","or","ta","me","xo","re","ze",
		"pan","xe","yu","no","ni","ka","ir"};
	
	public static String newWord(){
		String word = "";
		for (int i = 0; i < random(10,5); i++) {
			word += silabas[random(silabas.length,0)];
		}
		return word;
	}
	private static int random(int range,int range2) {
		Random r = new Random();
		return r.nextInt(range)+range2;  
	}

}
