package com.company;

import java.util.ArrayList;

public class Tournament {
    private ArrayList<Team> seedOne;
    private ArrayList<Team> seedTwo;
    private ArrayList<Team> seedThree;
    private ArrayList<Team> seedFour;
    private ArrayList<Team> seedFive;
    private Team runnerUp;
    private Team champion;

    public Tournament(ArrayList<Team> seedOne, ArrayList<Team> seedTwo, ArrayList<Team> seedThree,
                      ArrayList<Team> seedFour, Team runnerUp, Team champion)
    {
        this.seedOne = seedOne;
        this.seedTwo = seedTwo;
        this.seedThree = seedThree;
        this.seedFour = seedFour;
        this.runnerUp = runnerUp;
        this.champion = champion;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("SEED ONE: ");
        sb.append(seedOne);
        sb.append("\n");

        sb.append("SEED TWO: ");
        sb.append(seedTwo);
        sb.append("\n");

        sb.append("SEED THREE: ");
        sb.append(seedThree);
        sb.append("\n");

        sb.append("SEED FOUR: ");
        sb.append(seedFour);
        sb.append("\n");

        sb.append("RUNNER UP: ");
        sb.append(runnerUp);
        sb.append("\n");

        sb.append("CHAMPION: ");
        sb.append(champion);
        sb.append("\n");

        return sb.toString();
    }

    public ArrayList<Team> getSeedOne() {
        return seedOne;
    }

    public ArrayList<Team> getSeedTwo() {
        return seedTwo;
    }

    public ArrayList<Team> getSeedThree() {
        return seedThree;
    }

    public ArrayList<Team> getSeedFour() {
        return seedFour;
    }

    public Team getRunnerUp() {
        return runnerUp;
    }

    public Team getChampion() {
        return champion;
    }
}
