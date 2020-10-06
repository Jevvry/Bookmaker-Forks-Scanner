package com.company.BettingDescription;

public class BetShoulder {

	private String teamName;
	private Double coefficient;
	private String betOfficeName;

	//region Property
	public String getTeamName() {
		return teamName;
	}

	public String getBetOfficeName() {
		return betOfficeName;
	}

	public void setCoefficient(Double value) {
		checkCoefficientValue(value);
		coefficient = value;
	}

	public Double getCoefficient() {
		return coefficient;
	}

	//endregion
	public BetShoulder(String teamName, String coefficient, String betOfficeName) {
		this.teamName = teamName;
		setCoefficient(Double.parseDouble(coefficient));
		this.betOfficeName = betOfficeName;
	}

	private void checkCoefficientValue(Double value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Коэффициент не должен быть отрицательным");
		}
	}

	public String toString() {
		return String.format("Ставка на: %s.\nВ бк: %s.\nКоэффициент: %f.", teamName, betOfficeName,
				coefficient);
	}
}
