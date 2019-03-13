package com.company;

import java.util.Random;

public class Game {

    public Game()
    {

    }

    public static Team monteCarlo(Team team1, Team team2)
    {
        double team1Score = 0;
        team1Score += team1.getTurnOversPerGame() * .10;
        team1Score += team1.getDefensiveReboundsPerGame() * .05;
        team1Score += team1.getOffensiveReboundsPerGame() * .05;
        team1Score += team1.getBlocksPerGame() * 0.50;
        team1Score += (team1.getFieldGoalsPerGame() + team1.getFreeThrowsPerGame() + team1.getThreePointersPerGame()) * .50;
        team1Score -= team1.getPersonalFoulsPerGame() * .2;
        team1Score += team1.getTurnOversPerGame() * .3;

        double team2Score = 0;
        team2Score += team2.getTurnOversPerGame() * .10;
        team2Score += team2.getDefensiveReboundsPerGame() * .05;
        team2Score += team2.getOffensiveReboundsPerGame() * .05;
        team2Score += team2.getBlocksPerGame() * 0.50;
        team2Score += (team2.getFieldGoalsPerGame() + team2.getFreeThrowsPerGame() + team2.getThreePointersPerGame()) * .50;
        team2Score -= team2.getPersonalFoulsPerGame() * .2;
        team2Score += team2.getTurnOversPerGame() * .3;

        if(team1Score > team2Score)
        {
            return  team1;
        }
        else if (team1Score < team1Score)
        {
            return team2;
        }
        else
        {
            int r = new Random().nextInt(101);
            if(r > 50)
            {
                return team1;
            }
            else
            {
                return team2;
            }
        }

    }
}
