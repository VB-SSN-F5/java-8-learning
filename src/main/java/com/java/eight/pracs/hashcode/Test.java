package com.java.eight.pracs.hashcode;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		Map<Team,String> leaders = new HashMap<>();
		leaders.put(new Team("New York", "development"), "Anne");
		leaders.put(new Team("Boston", "development"), "Brian");
		leaders.put(new Team("Boston", "marketing"), "Charlie");

		Team myTeam = new Team("New York", "development");
		String myTeamLeader = leaders.get(myTeam);
		
		System.out.println(myTeamLeader);
	}

}
