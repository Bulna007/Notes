package com.ci.beans;

import java.util.Map;
import java.util.Properties;

public class Stadium {
	private Map<String, Game> matches;
	private Properties matchWiningTeam;

	public Stadium(Map<String, Game> matches, Properties matchWiningTeam) {
		this.matches = matches;
		this.matchWiningTeam = matchWiningTeam;
	}

	@Override
	public String toString() {
		return "Stadium [matches=" + matches + ", matchWiningTeam=" + matchWiningTeam + "]";
	}

}
