package com.example.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.models.Roster;
import com.example.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Players.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		postActionHandler(request.getParameter("action"),request);
		request.getRequestDispatcher("teams").forward(request, response);
		
	}
	public void postActionHandler(String action, HttpServletRequest request) {
		if (action.equals("delete_player")) {
			deletePlayer(request);
			
		}
		if (action.equals("add_player")) {
			addPlayer(request);
			
		}
	}
	public void deletePlayer(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int team_index = Integer.parseInt(request.getParameter("team_id"));
		int player_index = Integer.parseInt(request.getParameter("player_id"));
		Roster roster = (Roster)session.getAttribute("roster");
		Team team = roster.getTeam(team_index);
		team.deletePlayer(player_index);
		session.setAttribute("roster",roster);
	}
	public void addPlayer(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int team_index = (int) session.getAttribute("lastTeam");
		Roster roster = (Roster)session.getAttribute("roster");
		Team team = roster.getTeam(team_index);
		String name = request.getParameter("name");
		String last_name = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		team.newPlayer(name,last_name,age);
		session.setAttribute("roster",roster);
	}
}
