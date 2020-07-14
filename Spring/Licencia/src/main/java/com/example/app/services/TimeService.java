package com.example.app.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeService {
	public static String getTime() {
		return getFormaterDate ("hh:mm:ss:a");
	}
	public static String getDate() {
		return getFormaterDate ("EEEE dd MMMM yyyy");
	}
	
	public static String getFormaterDate (String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	public static String getFormaterDate (String pattern,Date inputDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(inputDate);
		return date;
	}
	
}
