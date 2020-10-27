package com.company.betting_math;

import com.company.betting_description.Bet;
import com.company.betting_description.BetOffice;
import com.company.betting_description.Fork;

import java.util.ArrayList;
import java.util.Map;

public class ForksFinder {

	//Length: 2
	private ArrayList<BetOffice> offices;
	private ArrayList<Fork> forks;

	public ForksFinder() {
		offices = new ArrayList<>();
		forks = new ArrayList<>();
	}

	public ForksFinder(BetOffice betOffice) {
		forks = new ArrayList<>();
		offices = new ArrayList<>();
		offices.add(betOffice);
	}

	public void findForksOneOffice() {
		if (offices.size() != 1) {
			throw new IllegalArgumentException("Список букмейкеров превышает допустимый");
		}
		BetOffice betOffice = offices.get(0);
		forks.clear();
		for (Map.Entry<String, Bet> stringBetEntry : betOffice.getBettings().entrySet()) {
			Bet bet = stringBetEntry.getValue();
			if (!isFork(bet)) {
				continue;
			}
			Fork fork = new Fork(bet, bet);
			forks.add(fork);
		}
	}

	public boolean isFork(Bet bet) {
		Double firstCoefficient = bet.getFirstTeam().getCoefficient();
		Double secondCoefficient = bet.getSecondTeam().getCoefficient();
		return isCoefficientFork(firstCoefficient, secondCoefficient);
	}

	private boolean isCoefficientFork(Double first, Double second) {
		return first + second < first * second;
	}

	public boolean isFork(Bet firstBet, Bet secondBet) {
		Double firstBetCoefficient = firstBet.getShoulderWithMaxCoefficient().getCoefficient();
		Double secondBetCoefficient = secondBet.getShoulderWithMaxCoefficient().getCoefficient();
		return isCoefficientFork(firstBetCoefficient, secondBetCoefficient);
	}

	public int getForksCount() {
		return forks.size();
	}

	public boolean isForkInit() {
		return forks.size() != 0;
	}

	public ArrayList<String> getForks() {
		ArrayList<String> result = new ArrayList<>();
		for (Fork fork : forks) {
			result.add(fork.toMessage());
		}
		return result;
	}

	public String getFork(Integer i) {
		return forks.get(i).toMessage();
	}
}
