package com.company.betting_math;

import com.company.betting_description.BetOffice;
import com.company.betting_description.Fork;

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
