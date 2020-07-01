package com.mixi.homepage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String favleng = request.getParameter("favleng");
		String home = request.getParameter("home");
	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if (name != null) {
        	 out.write("<h1>Bienvenido " + name + "</h1>");
		}else {
			out.write("<h1>Bienvenido unknow</h1>");
		}
        if (favleng != null) {
        	out.write("<h1>Tu lenguaje favorito es " + favleng + "</h1>");
		}else {
			out.write("<h1>Tu lenguaje favorito es unknow </h1>");
		}
        if (home != null) {
        	out.write("<h1>Vives en " + home + "</h1>");
		}else {
			out.write("<h1>Vives en unknow</h1>");
		}
        
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
