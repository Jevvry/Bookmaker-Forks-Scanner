package com.company.betting_description;

import java.util.HashMap;

public class BetOffice {

	private HashMap<String, Bet> bettings;
	private String officeName;

	public BetOffice(String officeName) {
		bettings = new HashMap<>();
		this.officeName = officeName;
	}

	public boolean containsBet(String betName) {
		return bettings.containsKey(betName);
	}

	public Bet getBet(String betName) {
        if (!bettings.containsKey(betName)) {
            throw new IllegalArgumentException();
        }
		return bettings.get(betName);
	}

	public void addBet(String betName, Bet bet) {
		bettings.put(betName, bet);
	}

	public String getName() {
		return officeName;
	}

}
