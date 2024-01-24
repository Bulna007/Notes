package com.uci.beans;

import java.util.List;

public class Team {
	private List<String> players;

	public void setPlayers(List<String> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [players=" + players + "]";
	}

}
