package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Game {

    public Game()
    {
        /*year,  teamID, GAMESPLAYED , AVERAGESCORE , WINS , LOSSES,
                FIELDGOALSPERGAME , FIELDGOALSUCCESS,
                THREEPOINTERSPERGAME , THREEPOINTERSSUCCESS,
                FREETHROWPERGAME , FREETHROWSUCCESS,
                OFFENSIVEREBOUNDSPERGAME , DEFENSIVEREBOUNDSPERGAME , TURNOVERSPERGAME,
                STEALSPERGAME, BLOCKSPERGAME, PERSONALFOULSPERGAME, AssistsPerGame,
                fieldGoalAttempts, threePointerAttempts ,freeThrowAttempts*/
    }

    public static Team playGame(Team team1, double[] winningWeightsTeam1, double[] loosingWeightsTeam1,
                                Team team2, double[] winningWeightsTeam2, double[] loosingWeightsTeam2)
    {
        double team1Score = getScore(team1, winningWeightsTeam1, loosingWeightsTeam1);

        double team2Score = getScore(team2, winningWeightsTeam2, loosingWeightsTeam2);;


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

    static private double getScore(Team team, double[] winningWeights, double[] loosingWeights)
    {
        double teamScore = 0;

        double[] wStat = team.getWinningStatArray();
        double[] lStat = team.getOppStatArray();

        for(int i = 0; i < wStat.length; i++)
        {
            teamScore += wStat[i] * winningWeights[i];
            try //THIS IS HERE BECAUSE THE LOOSING STATS HAVE LESS INDICES THAN THE WINING, WHICH WOULD CAUSE AN ERROR
            {
                teamScore += lStat[i] * loosingWeights[i];
            } catch (Exception e) {}
        }

        return teamScore;
    }

    public static Team playtTournament(LinkedList<Team> bracket)
    {
        Iterator iterator = bracket.listIterator();

        for (int i = 0; i < 0; i++)
        {
            playGame(iterator.next(iterator.next(), new double[], new double[], //NEW DOUBLE PLACE HOLDER
                                    iterator.next(), new double[], new double[])); //NEW DOUBLE PLACE HOLDER
            //iterator.remove or iterator.previous, iterator.remove()
        }

    }
}
