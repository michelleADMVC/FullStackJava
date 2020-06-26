package com.example.utilities;

import java.util.Random;

public class RandomUtility {
	public static int random(int range,int range2) {
		Random r = new Random();
		return r.nextInt(range)+range2;  
	}
}
