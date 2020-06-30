package com.example.models;

import java.util.ArrayList;

public class Roster {
	ArrayList <Team> teams;
	
	public Roster(){
		this.teams = new ArrayList<Team>();
	}
	public void newTeam(String name) {
		this.teams.add(new Team(name));
	}
	public Team getTeam(int index) {
		return this.teams.get(index);
	}
	public void test(){
		this.newTeam("Ardillas");
		Team test = this.getTeam(0);
		test.newPlayer("Mamberru", "Maravilloflen1", 3);
		test.newPlayer("Mamberru2", "Maravillofle2n", 5);
		test.newPlayer("Mamberru3", "Maravillofl3en", 87);
		test.newPlayer("Mamberru4", "Maravillo4flen", 1);

		this.newTeam("Mamberrus");
		Team test2 = this.getTeam(1);
		test2.newPlayer("Mamberru", "Maravilloflen1", 3);
		test2.newPlayer("Mamberru2", "Maravillofle2n", 5);
		test2.newPlayer("Mamberru3", "Maravillofl3en", 87);
		test2.newPlayer("Mamberru4", "Maravillo4flen", 1);
		test2.newPlayer("Mamberru2", "Maravillofle2n", 5);
		test2.newPlayer("Mamberru3", "Maravillofl3en", 87);
		test2.newPlayer("Mamberru4", "Maravillo4flen", 1);
		
	}
	public int totalTeams(){
		return this.teams.size();
	}
	public void deleteTeam(int index){
		teams.remove(index);
	}
}
