package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer {

    public Analyzer()
    {

    }

    static public Team getTeam(int year, int teamID) throws IOException
    {
        File regularSeasonCompactResults = new File("DataFiles/RegularSeasonDetailedResults.csv");

        Scanner fileReader = new Scanner(regularSeasonCompactResults);
        //SKIPS HEADER
        fileReader.nextLine();
        String[] currentLine = fileReader.nextLine().split(",");

        String teamName;

        int     GAMESPLAYED, AVERAGESCORE = 0, WINS = 0, LOSSES = 0,
                FIELDGOALSPERGAME = 0, THREEPOINTERSPERGAME = 0, FREETHROWPERGAME = 0,
                OFFENSIVEREBOUNDSPERGAME = 0, DEFENSIVEREBOUNDSPERGAME = 0, TURNOVERSPERGAME = 0,
                STEALSPERGAME = 0, BLOCKSPERGAME = 0, PERSONALFOULSPERGAME = 0;

        double FIELDGOALSUCCESS, THREEPOINTERSSUCCESS, FREETHROWSUCCESS;


        int freeThrowAttempts = 0 , threePointerAttempts = 0 , fieldGoalAttempts = 0;

        while(fileReader.hasNext())
        {
            //GETS STATS FOR A WINNING TEAM
            if(Integer.parseInt(currentLine[0]) == year && Integer.parseInt(currentLine[2]) == teamID)
            {
                //ITERATES THROUGH THE WINNING STATS
                WINS++;
                AVERAGESCORE += Integer.parseInt(currentLine[3]);
                FIELDGOALSPERGAME += Integer.parseInt(currentLine[8]);
                fieldGoalAttempts += Integer.parseInt(currentLine[9]);
                THREEPOINTERSPERGAME += Integer.parseInt(currentLine[10]);
                threePointerAttempts += Integer.parseInt(currentLine[11]);
                FREETHROWPERGAME += Integer.parseInt(currentLine[12]);
                freeThrowAttempts += Integer.parseInt(currentLine[13]);
                OFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[14]);
                DEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[16]);
                TURNOVERSPERGAME += Integer.parseInt(currentLine[18]);
                STEALSPERGAME += Integer.parseInt(currentLine[19]);
                BLOCKSPERGAME += Integer.parseInt(currentLine[20]);
                PERSONALFOULSPERGAME += Integer.parseInt(currentLine[21]);

            }

            else if(Integer.parseInt(currentLine[0]) == year && Integer.parseInt(currentLine[4]) == teamID)
            {
                //ITERATES THROUGH THE LOOSING STATS
                LOSSES++;
                AVERAGESCORE += Integer.parseInt(currentLine[5]);
                FIELDGOALSPERGAME += Integer.parseInt(currentLine[22]);
                fieldGoalAttempts += Integer.parseInt(currentLine[23]);
                THREEPOINTERSPERGAME += Integer.parseInt(currentLine[24]);
                threePointerAttempts += Integer.parseInt(currentLine[25]);
                FREETHROWPERGAME += Integer.parseInt(currentLine[26]);
                freeThrowAttempts += Integer.parseInt(currentLine[27]);
                OFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[28]);
                DEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[29]);
                TURNOVERSPERGAME += Integer.parseInt(currentLine[30]);
                STEALSPERGAME += Integer.parseInt(currentLine[31]);
                BLOCKSPERGAME += Integer.parseInt(currentLine[32]);
                PERSONALFOULSPERGAME += Integer.parseInt(currentLine[33]);
            }

            currentLine = fileReader.nextLine().split(",");
        }

        //DETERMINE AVERAGES

        GAMESPLAYED = WINS + LOSSES;
        FIELDGOALSUCCESS = FIELDGOALSPERGAME / (double)fieldGoalAttempts;
        THREEPOINTERSSUCCESS = THREEPOINTERSPERGAME / (double)threePointerAttempts;
        FREETHROWSUCCESS = FIELDGOALSPERGAME / (double)freeThrowAttempts;

        //PRIOR TO THIS POINT, XXX PER GAME HAS JUST BEEN USED AS A PLACE HOLDER FOR TOTAL SUCCESSFUL XXX

        AVERAGESCORE = AVERAGESCORE / GAMESPLAYED;
        FIELDGOALSPERGAME = FREETHROWPERGAME / GAMESPLAYED;
        THREEPOINTERSPERGAME = THREEPOINTERSPERGAME / GAMESPLAYED;
        FREETHROWPERGAME = FREETHROWPERGAME / GAMESPLAYED;
        OFFENSIVEREBOUNDSPERGAME = OFFENSIVEREBOUNDSPERGAME / GAMESPLAYED;
        DEFENSIVEREBOUNDSPERGAME = DEFENSIVEREBOUNDSPERGAME / GAMESPLAYED;
        TURNOVERSPERGAME = TURNOVERSPERGAME / GAMESPLAYED;
        STEALSPERGAME = STEALSPERGAME / GAMESPLAYED;
        BLOCKSPERGAME = BLOCKSPERGAME / GAMESPLAYED;
        PERSONALFOULSPERGAME = PERSONALFOULSPERGAME / GAMESPLAYED;

        teamName = getTeamName(teamID);

        return new Team(year,  teamID, teamName, GAMESPLAYED , AVERAGESCORE , WINS , LOSSES,
                FIELDGOALSPERGAME , FIELDGOALSUCCESS,
                THREEPOINTERSPERGAME , THREEPOINTERSSUCCESS,
                FREETHROWPERGAME , FREETHROWSUCCESS,
                OFFENSIVEREBOUNDSPERGAME , DEFENSIVEREBOUNDSPERGAME , TURNOVERSPERGAME,
                STEALSPERGAME, BLOCKSPERGAME, PERSONALFOULSPERGAME);
    }

    public static ArrayList<Team> getTeamListYearly (int year) throws IOException
    {
        ArrayList<Team> XXXXTeamList = new ArrayList<>();
        File Teams = new File("mensMachineLearningCompetition2019/DataFiles/Teams.csv");
        Scanner fileReader = new Scanner(Teams).useDelimiter(",");

        fileReader.nextLine();

        while (fileReader.hasNext())
        {
            XXXXTeamList.add(getTeam(year, Integer.parseInt(fileReader.next())));
            fileReader.nextLine();
        }

        return XXXXTeamList;
    }

    private static String getTeamName(int teamID) throws IOException
    {
        File Teams = new File("DataFiles/Teams.csv");
        Scanner fileReader = new Scanner(Teams).useDelimiter(",");
        while(fileReader.hasNextLine())
        {
            if (fileReader.next().equals(Integer.toString(teamID)))
            {
                return fileReader.next();
            }
            else
            {
                fileReader.nextLine();
            }
        }

        return "ERROR: NO NAME FOUND";
    }


}
