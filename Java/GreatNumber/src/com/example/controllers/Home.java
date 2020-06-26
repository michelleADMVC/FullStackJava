package com.example.controllers;
import com.example.utilities.*;
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
		initGame(request);
		request.setAttribute("number",session.getAttribute("RandomUtility"));
		
		view.forward(request, response);
	}
	private void initGame(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("randomNumber") == null) {
			session.setAttribute("randomNumber", RandomUtility.random(100, 0) );
		}
	}
	private void play(HttpServletRequest request, int number){
		HttpSession session = request.getSession();
		
		int sessionNumber = (int) session.getAttribute("randomNumber");
		if (number == sessionNumber) {		
			session.setAttribute("randomNumber", RandomUtility.random(100, 0));
			request.setAttribute("gameResponse","win");
		}else {
			if(number > sessionNumber){
				request.setAttribute("gameResponse","high");
			}else{
				request.setAttribute("gameResponse","low");
			}
		}
	}
	/**s
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int playedNumber = Integer.parseInt(request.getParameter("number"));
		play(request,playedNumber);	
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Home.jsp");
		
		view.forward(request, response);
	}

}
