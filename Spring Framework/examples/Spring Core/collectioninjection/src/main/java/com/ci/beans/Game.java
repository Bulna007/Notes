package com.ci.beans;

import java.util.List;
import java.util.Set;

public class Game {
	private List<String> players;
	private Set<String> umpires;

	public Game(Set<String> umpires) {
		this.umpires = umpires;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Game [players=" + players + ", umpires=" + umpires + "]";
	}

}
