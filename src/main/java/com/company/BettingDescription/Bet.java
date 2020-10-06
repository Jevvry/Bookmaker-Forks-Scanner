package com.company.BettingDescription;

public class Bet {

	private BetShoulder firstTeam;
	private BetShoulder secondTeam;
	private BetOffice betOffice;

	//region BetProperty
	//region First
	public BetShoulder getFirstTeam() {
		return firstTeam;
	}

	//endregion
	//region Second
	public BetShoulder getSecondTeam() {
		return secondTeam;
	}

	//endregion
	//region BetOffice
	public String getBetOfficeName() {
		return betOffice.getName();
	}

	//endregion
	//endregion


	public Bet(String firstTeamName, String secondTeamName, String firstTeamCoeff,
			String secondTeamCoeff, BetOffice betOffice) {
		firstTeam = new BetShoulder(firstTeamName, firstTeamCoeff, betOffice.getName());
		secondTeam = new BetShoulder(secondTeamName, secondTeamCoeff, betOffice.getName());
		this.betOffice = betOffice;
	}

	public String getBetName() {
		return firstTeam.getTeamName() + "-" + secondTeam.getTeamName();
	}

	public void setAllCoef(String firstTeamCoef, String secondTeamCoef) {
		firstTeam.setCoefficient(Double.parseDouble(firstTeamCoef));
		secondTeam.setCoefficient(Double.parseDouble(secondTeamCoef));
	}

	public BetShoulder getShoulderWithMaxCoefficient() {
        if (firstTeam.getCoefficient() > secondTeam.getCoefficient()) {
            return firstTeam;
        }
		return secondTeam;
	}

	public BetShoulder getAnotherShoulder(BetShoulder shoulder) {
        if (shoulder == firstTeam) {
            return secondTeam;
        }
		return firstTeam;
	}
}
