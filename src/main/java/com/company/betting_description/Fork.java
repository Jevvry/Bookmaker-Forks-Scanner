package com.company.betting_description;

public class Fork {

	private Bet firstEvent;
	private Bet secondEvent;
	private Double eventCoefficient;
	private Double leftRateCoefficient;
	private Double rightRateCoefficient;
	public BetShoulder lefShoulder;
	public BetShoulder rightShoulder;

	//region Property
	public Double getLeftRateCoefficient() {
		return leftRateCoefficient;
	}

	public Double getRightRateCoefficient() {
		return rightRateCoefficient;
	}

	//endregion

	public Fork(Bet firstEvent, Bet secondEvent) {
		this.firstEvent = firstEvent;
		this.secondEvent = secondEvent;
		lefShoulder = firstEvent.getShoulderWithMaxCoefficient();
		rightShoulder = secondEvent.getShoulderWithMaxCoefficient();
		eventCoefficient = 1 / lefShoulder.getCoefficient() + 1 / rightShoulder.getCoefficient();
		leftRateCoefficient = 1 / (lefShoulder.getCoefficient() * eventCoefficient);
		rightRateCoefficient = 1 / (rightShoulder.getCoefficient() * eventCoefficient);
	}

	public String toString() {
		return "Событие:" + firstEvent.getBetName() + lefShoulder.toString() +
				rightShoulder.toString();
	}
}
