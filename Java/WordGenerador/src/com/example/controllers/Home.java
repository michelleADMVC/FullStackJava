package com.example.controllers;

import java.io.IOException;
import java.util.Date;

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
		if (session.getAttribute("clicks") == null) {
			session.setAttribute("lastWord", "Genera una palabra");
			session.setAttribute("clicks", 0);
		}
		request.setAttribute("date", null);
		request.setAttribute("lastWord", session.getAttribute("lastWord"));
		request.setAttribute("count", session.getAttribute("clicks"));
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String req = request.getParameter("add");
		
		if(req.equals("true")) {
			Date lastDate = new Date();
			int count = (int) session.getAttribute("clicks")+1;
			session.setAttribute("lastWord", Generator.newWord());
			session.setAttribute("date", lastDate);
			session.setAttribute("clicks",count);
		}
		if(req.equals("false")) {
			session.setAttribute("clicks",0);
			session.setAttribute("lastWord", "Genera una palabra");
		}
		
		doGet(request, response);
	}

}
