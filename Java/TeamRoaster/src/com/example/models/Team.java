package com.example.models;

import java.util.ArrayList;

public class Team {
	ArrayList <Player> players;
	private String name;
	
	public Team (String name) {
		players = new ArrayList<Player>();
		this.name = name;
	}
	
	public void newPlayer(String name, String lastName, int age){
		players.add(new Player(name,lastName,age));
	}
	public Player getPlayer(int index) {
		return players.get(index);
	}
	public String getName() {
		return name;
	}
	public int totalPlayers() {
		return players.size();
	}
	public void deletePlayer(int index) {
		this.players.remove(index);
	}
	
}
