package com.company;

import java.util.ArrayList;

public class Team {

    private ArrayList<Float> statList = new ArrayList<>();
    private String teamName;

    public Team(ArrayList<Float> stats) {

        statList = stats;

        /*
        THE ORDER FOR STAT LIST FOLLOWS:

        SEASON || TEAM ID || AVERAGE SCORE || WINS || LOSSES
        FIELD GOALS PER GAME || FIELD GOAL SUCCESS
        THREE POINTERS PER GAME || THREE POINTERS SUCCESS,
        FREE THROW SUCCESS || FREE THROW SUCCESS
        OFFENSIVE REBOUNDS PER GAME || DEFENSIVE REBOUNDS PER GAME || TURN OVERS PER GAME
         */

    }

    @Override
    public String toString()
    {
        return teamName;
    }

}
