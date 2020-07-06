package com.example.demo.models;

import java.util.ArrayList;
import java.util.Random;

public class UserData {
	
	private ArrayList<Activity> logs;
	private int gold;
	
	public UserData() {
		this.logs = new ArrayList<Activity>();
		this.gold = 0;
	}
	
	public int getGold() {
		return gold;
	}
	public void perfomFarm() {
		int randomGold = getRandom(10,10);
		this.gold = this.gold + randomGold;
		this.addLog("You entered to a farm and earned "+randomGold+ " gold");
	}
	public void perfomCave() {
		int randomGold = getRandom(5,5);
		this.gold = this.gold + randomGold;
		this.addLog("You entered to a cave and earned "+randomGold+ " gold");
	}
	public void perfomHouse() {
		int randomGold = getRandom(2,3);
		this.gold = this.gold + randomGold;
		this.addLog("You entered to a house and earned "+randomGold+ " gold");
	}
	public void perfomCasino() {
		if (this.getRandomBoolean()) {
			this.gold = this.gold + 50;
			this.addLog("You entered to a casino and earned "+50+ " gold");
		}else {
			this.gold = this.gold - 50;
			this.addBadLog("You entered to a casino and you lost "+50+ " gold");
			
		}
		
	}
	private void addLog(String log) {
		this.logs.add(new Activity(log));
	}
	private void addBadLog(String log) {
		Activity newActivity = new Activity(log);
		newActivity.setLose();
		this.logs.add(newActivity);
	}
	public Activity getLog(int index){
		return this.logs.get(index);
	}
	public ArrayList<Activity> getLogs() {
		return logs;
	}
	private int getRandom(int from, int to) {
		return new Random().nextInt(to)+from;
	}
	private boolean getRandomBoolean() {
		return new Random().nextBoolean();
	}
	
}
