package com.example.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Home.jsp");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("clicks"));
		if (session.getAttribute("clicks") == null) {
			session.setAttribute("clicks", 0);
		}
		request.setAttribute("count", session.getAttribute("clicks"));
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String req = request.getParameter("add");
		System.out.println(session.getAttribute("clicks"));
		
		if(req.equals("true")) {
			int count = (int) session.getAttribute("clicks")+1;
			session.setAttribute("clicks",count);
		}
		if(req.equals("false")) {
			session.setAttribute("clicks",0);
		}
		doGet(request, response);
	}

}
