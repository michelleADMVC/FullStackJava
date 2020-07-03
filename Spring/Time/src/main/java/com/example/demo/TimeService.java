package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeService {
	public static String getTime() {
		return getFormaterDate ("hh:mm:ss:a");
	}
	public static String getDate() {
		return getFormaterDate ("EEEE dd MMMM yyyy");
	}
	
	private static String getFormaterDate (String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
}
