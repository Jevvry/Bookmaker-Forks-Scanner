package com.company.BettingMath;

import com.company.BettingDescription.BetOffice;
import com.company.BettingDescription.Fork;

import java.util.ArrayList;

public class ForksFinder {
    //Length: 2
    private ArrayList<BetOffice> offices;
    private ArrayList<Fork> forks;

    public ForksFinder() {
        offices = new ArrayList<>();
        forks = new ArrayList<>();
    }

    public ArrayList<Fork> FindForks()
    {
        BetOffice firstEvents = offices.get(0);
        BetOffice second = offices.get(1);
        return  null;
    }

}
