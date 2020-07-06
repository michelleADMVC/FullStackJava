package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {
	private String log;
	private String date;
	private boolean lose;
	
	public Activity(String log){
		this.log = log;
		this.lose = false;
		this.date = setActualDate();
	}
	
	private static String getFormaterDate (String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	public void setLose(){
		this.lose = true;
	}
	public String setActualDate() {
		return getFormaterDate("EEEE dd MMMM yyyy hh:mm:ss");
	}
	public String getDate() {
		return date;
	}
	public String getLog() {
		return log;
	}
	public boolean getLose() {
		return this.lose;
	}
}
