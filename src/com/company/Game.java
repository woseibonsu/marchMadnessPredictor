package com.company;

import java.io.IOException;
import java.util.*;

public class Game {

    public Game() {

    }

    public static Team playGame(Team team1, Team team2) throws IOException
    {
        Network net = new Network(28, 40, 15, 6, 1);
        TrainSet set = new TrainSet(28, 1);

        double[] statList = Analyzer.mergeStats(team1, team2);
        double[] statListReversed = Analyzer.reverseArray(Analyzer.mergeStats(team1, team2));
        set.addData(statList, new double[]{1});
        set.addData(statListReversed, new double[]{0});

        net.train(set, 100000);

        double[] test = net.calculate(Analyzer.mergeStats(team1, team2));
        System.out.println(test[0]);
        if (test[0] > 0.5) {
            return team1;
        } else {
            return team2;
        }
    }

    public static Tournament playTournament(ArrayList<Team> teams) throws IOException
    {
        ListIterator<Team> teamIterator = teams.listIterator();
        ArrayList<Team> seedOne = new ArrayList<>(16);
        ArrayList<Team> seedTwo = new ArrayList<>(8);
        ArrayList<Team> seedThree = new ArrayList<>(4);
        ArrayList<Team> seedFour = new ArrayList<>(2);
        Team runnerUp;
        Team champion;
        Team teamOne;
        Team teamTwo;

        //<editor-fold desc="Play Round One">
        for(int i = 0; i < 32; i++)
        {
            System.out.println("NUMBER: " + i);
            teamOne = teamIterator.next();
            teamTwo = teamIterator.next();
            System.out.println(teamOne + " VS " + teamTwo );
            if(playGame(teamOne, teamTwo).equals(teamOne))
            {
                System.out.println(playGame(teamOne, teamTwo));
                teamIterator.previous();
                seedOne.add(teamIterator.previous());
                teamIterator.remove();
                teamIterator.next();
                System.out.println("MOVEMENT ONE");
            }
            else
            {
                seedOne.add(teamIterator.previous());
                teamIterator.remove();
                System.out.println("MOVEMENT TWO");
            }
        }
        //</editor-fold>
        teamIterator = teams.listIterator();
        //<editor-fold desc="Play Round Two">
        for(int i = 0; i < 16; i++)
        {
            System.out.println("NUMBER: " + i);
            teamOne = teamIterator.next();
            teamTwo = teamIterator.next();
            if(playGame(teamOne, teamTwo).equals(teamOne))
            {
                teamIterator.previous();
                seedTwo.add(teamIterator.previous());
                teamIterator.remove();
                teamIterator.next();
            }
            else
            {
                seedTwo.add(teamIterator.previous());
                teamIterator.remove();
            }
        }
        //</editor-fold>
        teamIterator = teams.listIterator();
        //<editor-fold desc="Play Round Three">
        for(int i = 0; i < 8; i++)
        {
            teamOne = teamIterator.next();
            teamTwo = teamIterator.next();
            if(playGame(teamOne, teamTwo).equals(teamOne))
            {
                teamIterator.previous();
                seedThree.add(teamIterator.previous());
                teamIterator.remove();
                teamIterator.next();
            }
            else
            {
                seedThree.add(teamIterator.previous());
                teamIterator.remove();
            }
        }
        //</editor-fold>
        teamIterator = teams.listIterator();
        //<editor-fold desc="Play Round Four">
        for(int i = 0; i < 4; i++)
        {
            teamOne = teamIterator.next();
            teamTwo = teamIterator.next();
            if(playGame(teamOne, teamTwo).equals(teamOne))
            {
                teamIterator.previous();
                seedFour.add(teamIterator.previous());
                teamIterator.remove();
                teamIterator.next();
            }
            else
            {
                seedFour.add(teamIterator.previous());
                teamIterator.remove();
            }
        }
        //</editor-fold>
        teamIterator = teams.listIterator();
        //<editor-fold desc="Play Champion's Match">
        teamOne = teamIterator.next();
        teamTwo = teamIterator.next();
        champion = playGame(teamOne, teamTwo);
        if(champion.equals(teamOne))
        {
            runnerUp = teamTwo;
        }
        else
        {
            runnerUp = teamOne;
        }
        //</editor-fold>

        return new Tournament(seedOne, seedTwo, seedThree,
                seedFour, runnerUp, champion);
    }



}
