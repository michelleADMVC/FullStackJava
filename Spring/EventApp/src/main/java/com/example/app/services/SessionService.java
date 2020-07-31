package com.example.app.services;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.app.models.User;

@Service
public class SessionService {
	
	public static boolean isLogged(HttpSession session) {
		if (session.getAttribute("user")!= null) {
			return true;
		}else {
			return false;
		}
	}
	public static void logUser(HttpSession session, User user) {
		session.setAttribute("user", user);
		
	}
	public static void unlog(HttpSession session){
		session.setAttribute("user", null);
	}
}
