package com.company;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Analyzer {

    public Analyzer()
    {

    }

    //GETS TEAM STATS FROM GIVEN YEAR
    static public Team getTeam(int year, int teamID) throws IOException
    {
        File regularSeasonCompactResults = new File("RegularSeasonDetailedResults.csv");

        Scanner fileReader = new Scanner(regularSeasonCompactResults);
        //SKIPS HEADER
        fileReader.nextLine();
        String[] currentLine = fileReader.nextLine().split(",");

        String teamName;

        double    GAMESPLAYED, AVERAGESCORE = 0, WINS = 0, LOSSES = 0,
            FIELDGOALSPERGAME = 0, THREEPOINTERSPERGAME = 0, FREETHROWPERGAME = 0,
            OFFENSIVEREBOUNDSPERGAME = 0, DEFENSIVEREBOUNDSPERGAME = 0, TURNOVERSPERGAME = 0,
            STEALSPERGAME = 0, BLOCKSPERGAME = 0, PERSONALFOULSPERGAME = 0, AssistsPerGame = 0;

        double  oAVERAGESCORE = 0,
                oFIELDGOALSPERGAME = 0, oTHREEPOINTERSPERGAME = 0, oFREETHROWPERGAME = 0,
                oOFFENSIVEREBOUNDSPERGAME = 0, oDEFENSIVEREBOUNDSPERGAME = 0, oTURNOVERSPERGAME = 0,
                oSTEALSPERGAME = 0, oBLOCKSPERGAME = 0, oPERSONALFOULSPERGAME = 0, oAssistsPerGame = 0;

        double FIELDGOALSUCCESS, THREEPOINTERSSUCCESS, FREETHROWSUCCESS;

        double oFIELDGOALSUCCESS, oTHREEPOINTERSSUCCESS, oFREETHROWSUCCESS;


        int freeThrowAttempts = 0 , threePointerAttempts = 0 , fieldGoalAttempts = 0;

        int ofreeThrowAttempts = 0 , othreePointerAttempts = 0 , ofieldGoalAttempts = 0;

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
                DEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[15]);
                AssistsPerGame += Integer.parseInt(currentLine[16]);
                TURNOVERSPERGAME += Integer.parseInt(currentLine[17]);
                STEALSPERGAME += Integer.parseInt(currentLine[18]);
                BLOCKSPERGAME += Integer.parseInt(currentLine[19]);
                PERSONALFOULSPERGAME += Integer.parseInt(currentLine[20]);

                oAVERAGESCORE += Integer.parseInt(currentLine[5]);
                oFIELDGOALSPERGAME += Integer.parseInt(currentLine[21]);
                ofieldGoalAttempts += Integer.parseInt(currentLine[22]);
                oTHREEPOINTERSPERGAME += Integer.parseInt(currentLine[23]);
                othreePointerAttempts += Integer.parseInt(currentLine[24]);
                oFREETHROWPERGAME += Integer.parseInt(currentLine[25]);
                ofreeThrowAttempts += Integer.parseInt(currentLine[26]);
                oOFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[27]);
                oDEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[28]);
                oAssistsPerGame += Integer.parseInt(currentLine[29]);
                oTURNOVERSPERGAME += Integer.parseInt(currentLine[30]);
                oSTEALSPERGAME += Integer.parseInt(currentLine[31]);
                oBLOCKSPERGAME += Integer.parseInt(currentLine[32]);
                oPERSONALFOULSPERGAME += Integer.parseInt(currentLine[33]);

            }

            else if(Integer.parseInt(currentLine[0]) == year && Integer.parseInt(currentLine[4]) == teamID)
            {
                //ITERATES THROUGH THE LOOSING STATS
                LOSSES++;
                oAVERAGESCORE += Integer.parseInt(currentLine[3]);
                oFIELDGOALSPERGAME += Integer.parseInt(currentLine[8]);
                ofieldGoalAttempts += Integer.parseInt(currentLine[9]);
                oTHREEPOINTERSPERGAME += Integer.parseInt(currentLine[10]);
                othreePointerAttempts += Integer.parseInt(currentLine[11]);
                oFREETHROWPERGAME += Integer.parseInt(currentLine[12]);
                ofreeThrowAttempts += Integer.parseInt(currentLine[13]);
                oOFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[14]);
                oDEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[15]);
                oAssistsPerGame += Integer.parseInt(currentLine[16]);
                oTURNOVERSPERGAME += Integer.parseInt(currentLine[17]);
                oSTEALSPERGAME += Integer.parseInt(currentLine[18]);
                oBLOCKSPERGAME += Integer.parseInt(currentLine[19]);
                oPERSONALFOULSPERGAME += Integer.parseInt(currentLine[20]);

                AVERAGESCORE += Integer.parseInt(currentLine[5]);
                FIELDGOALSPERGAME += Integer.parseInt(currentLine[21]);
                fieldGoalAttempts += Integer.parseInt(currentLine[22]);
                THREEPOINTERSPERGAME += Integer.parseInt(currentLine[23]);
                threePointerAttempts += Integer.parseInt(currentLine[24]);
                FREETHROWPERGAME += Integer.parseInt(currentLine[25]);
                freeThrowAttempts += Integer.parseInt(currentLine[26]);
                OFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[27]);
                DEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[28]);
                AssistsPerGame += Integer.parseInt(currentLine[29]);
                TURNOVERSPERGAME += Integer.parseInt(currentLine[30]);
                STEALSPERGAME += Integer.parseInt(currentLine[31]);
                BLOCKSPERGAME += Integer.parseInt(currentLine[32]);
                PERSONALFOULSPERGAME += Integer.parseInt(currentLine[33]);
            }

            currentLine = fileReader.nextLine().split(",");
        }

        //DETERMINE AVERAGES

        GAMESPLAYED = WINS + LOSSES;
        oFIELDGOALSUCCESS = oFIELDGOALSPERGAME / (double)ofieldGoalAttempts;
        oTHREEPOINTERSSUCCESS = oTHREEPOINTERSPERGAME / (double)othreePointerAttempts;
        oFREETHROWSUCCESS = oFIELDGOALSPERGAME / (double)ofreeThrowAttempts;

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

        oAVERAGESCORE = oAVERAGESCORE / GAMESPLAYED;
        oFIELDGOALSPERGAME = oFREETHROWPERGAME / GAMESPLAYED;
        oTHREEPOINTERSPERGAME = oTHREEPOINTERSPERGAME / GAMESPLAYED;
        oFREETHROWPERGAME = oFREETHROWPERGAME / GAMESPLAYED;
        oOFFENSIVEREBOUNDSPERGAME = oOFFENSIVEREBOUNDSPERGAME / GAMESPLAYED;
        oDEFENSIVEREBOUNDSPERGAME = oDEFENSIVEREBOUNDSPERGAME / GAMESPLAYED;
        oTURNOVERSPERGAME = oTURNOVERSPERGAME / GAMESPLAYED;
        oSTEALSPERGAME = oSTEALSPERGAME / GAMESPLAYED;
        oBLOCKSPERGAME = oBLOCKSPERGAME / GAMESPLAYED;
        oPERSONALFOULSPERGAME = oPERSONALFOULSPERGAME / GAMESPLAYED;

        teamName = getTeamName(teamID);

         double[] teamArray = new double[] {AVERAGESCORE,
                FIELDGOALSPERGAME,
                THREEPOINTERSPERGAME,
                FREETHROWPERGAME,
                OFFENSIVEREBOUNDSPERGAME , DEFENSIVEREBOUNDSPERGAME , TURNOVERSPERGAME,
                STEALSPERGAME, BLOCKSPERGAME, PERSONALFOULSPERGAME, AssistsPerGame, fieldGoalAttempts,
                 threePointerAttempts ,freeThrowAttempts};

        double[] oppArray = new double[] {oAVERAGESCORE ,
                oFIELDGOALSPERGAME ,
                oTHREEPOINTERSPERGAME ,
                oFREETHROWPERGAME ,
                oOFFENSIVEREBOUNDSPERGAME , oDEFENSIVEREBOUNDSPERGAME , oTURNOVERSPERGAME,
                oSTEALSPERGAME, oBLOCKSPERGAME, oPERSONALFOULSPERGAME, oAssistsPerGame, ofieldGoalAttempts,
        othreePointerAttempts, ofreeThrowAttempts};

        for(int i = 0; i < teamArray.length; i++)
        {
            teamArray[i] = teamArray[i] - oppArray[i];

        }
         return new Team(year, teamID, teamName, teamArray);

    }

    //GETS TEAM STATS FROM ALL YEARS
    static public Team getTeam(int teamID) throws IOException
    {
        File regularSeasonCompactResults = new File("RegularSeasonDetailedResults.csv");

        Scanner fileReader = new Scanner(regularSeasonCompactResults);
        //SKIPS HEADER
        fileReader.nextLine();
        String[] currentLine = fileReader.nextLine().split(",");

        String teamName;

        double    GAMESPLAYED, AVERAGESCORE = 0, WINS = 0, LOSSES = 0,
                FIELDGOALSPERGAME = 0, THREEPOINTERSPERGAME = 0, FREETHROWPERGAME = 0,
                OFFENSIVEREBOUNDSPERGAME = 0, DEFENSIVEREBOUNDSPERGAME = 0, TURNOVERSPERGAME = 0,
                STEALSPERGAME = 0, BLOCKSPERGAME = 0, PERSONALFOULSPERGAME = 0, AssistsPerGame = 0;

        double  oAVERAGESCORE = 0,
                oFIELDGOALSPERGAME = 0, oTHREEPOINTERSPERGAME = 0, oFREETHROWPERGAME = 0,
                oOFFENSIVEREBOUNDSPERGAME = 0, oDEFENSIVEREBOUNDSPERGAME = 0, oTURNOVERSPERGAME = 0,
                oSTEALSPERGAME = 0, oBLOCKSPERGAME = 0, oPERSONALFOULSPERGAME = 0, oAssistsPerGame = 0;

        double FIELDGOALSUCCESS, THREEPOINTERSSUCCESS, FREETHROWSUCCESS;

        double oFIELDGOALSUCCESS, oTHREEPOINTERSSUCCESS, oFREETHROWSUCCESS;


        int freeThrowAttempts = 0 , threePointerAttempts = 0 , fieldGoalAttempts = 0;

        int ofreeThrowAttempts = 0 , othreePointerAttempts = 0 , ofieldGoalAttempts = 0;

        while(fileReader.hasNext())
        {
            //GETS STATS FOR A WINNING TEAM
            if(Integer.parseInt(currentLine[2]) == teamID)
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
                DEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[15]);
                AssistsPerGame += Integer.parseInt(currentLine[16]);
                TURNOVERSPERGAME += Integer.parseInt(currentLine[17]);
                STEALSPERGAME += Integer.parseInt(currentLine[18]);
                BLOCKSPERGAME += Integer.parseInt(currentLine[19]);
                PERSONALFOULSPERGAME += Integer.parseInt(currentLine[20]);

                oAVERAGESCORE += Integer.parseInt(currentLine[5]);
                oFIELDGOALSPERGAME += Integer.parseInt(currentLine[21]);
                ofieldGoalAttempts += Integer.parseInt(currentLine[22]);
                oTHREEPOINTERSPERGAME += Integer.parseInt(currentLine[23]);
                othreePointerAttempts += Integer.parseInt(currentLine[24]);
                oFREETHROWPERGAME += Integer.parseInt(currentLine[25]);
                ofreeThrowAttempts += Integer.parseInt(currentLine[26]);
                oOFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[27]);
                oDEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[28]);
                oAssistsPerGame += Integer.parseInt(currentLine[29]);
                oTURNOVERSPERGAME += Integer.parseInt(currentLine[30]);
                oSTEALSPERGAME += Integer.parseInt(currentLine[31]);
                oBLOCKSPERGAME += Integer.parseInt(currentLine[32]);
                oPERSONALFOULSPERGAME += Integer.parseInt(currentLine[33]);

            }

            else if(Integer.parseInt(currentLine[4]) == teamID)
            {
                //ITERATES THROUGH THE LOOSING STATS
                LOSSES++;
                oAVERAGESCORE += Integer.parseInt(currentLine[3]);
                oFIELDGOALSPERGAME += Integer.parseInt(currentLine[8]);
                ofieldGoalAttempts += Integer.parseInt(currentLine[9]);
                oTHREEPOINTERSPERGAME += Integer.parseInt(currentLine[10]);
                othreePointerAttempts += Integer.parseInt(currentLine[11]);
                oFREETHROWPERGAME += Integer.parseInt(currentLine[12]);
                ofreeThrowAttempts += Integer.parseInt(currentLine[13]);
                oOFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[14]);
                oDEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[15]);
                oAssistsPerGame += Integer.parseInt(currentLine[16]);
                oTURNOVERSPERGAME += Integer.parseInt(currentLine[17]);
                oSTEALSPERGAME += Integer.parseInt(currentLine[18]);
                oBLOCKSPERGAME += Integer.parseInt(currentLine[19]);
                oPERSONALFOULSPERGAME += Integer.parseInt(currentLine[20]);

                AVERAGESCORE += Integer.parseInt(currentLine[5]);
                FIELDGOALSPERGAME += Integer.parseInt(currentLine[21]);
                fieldGoalAttempts += Integer.parseInt(currentLine[22]);
                THREEPOINTERSPERGAME += Integer.parseInt(currentLine[23]);
                threePointerAttempts += Integer.parseInt(currentLine[24]);
                FREETHROWPERGAME += Integer.parseInt(currentLine[25]);
                freeThrowAttempts += Integer.parseInt(currentLine[26]);
                OFFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[27]);
                DEFENSIVEREBOUNDSPERGAME += Integer.parseInt(currentLine[28]);
                AssistsPerGame += Integer.parseInt(currentLine[29]);
                TURNOVERSPERGAME += Integer.parseInt(currentLine[30]);
                STEALSPERGAME += Integer.parseInt(currentLine[31]);
                BLOCKSPERGAME += Integer.parseInt(currentLine[32]);
                PERSONALFOULSPERGAME += Integer.parseInt(currentLine[33]);
            }

            currentLine = fileReader.nextLine().split(",");
        }

        //DETERMINE AVERAGES

        GAMESPLAYED = WINS + LOSSES;
        oFIELDGOALSUCCESS = oFIELDGOALSPERGAME / (double)ofieldGoalAttempts;
        oTHREEPOINTERSSUCCESS = oTHREEPOINTERSPERGAME / (double)othreePointerAttempts;
        oFREETHROWSUCCESS = oFIELDGOALSPERGAME / (double)ofreeThrowAttempts;

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

        oAVERAGESCORE = oAVERAGESCORE / GAMESPLAYED;
        oFIELDGOALSPERGAME = oFREETHROWPERGAME / GAMESPLAYED;
        oTHREEPOINTERSPERGAME = oTHREEPOINTERSPERGAME / GAMESPLAYED;
        oFREETHROWPERGAME = oFREETHROWPERGAME / GAMESPLAYED;
        oOFFENSIVEREBOUNDSPERGAME = oOFFENSIVEREBOUNDSPERGAME / GAMESPLAYED;
        oDEFENSIVEREBOUNDSPERGAME = oDEFENSIVEREBOUNDSPERGAME / GAMESPLAYED;
        oTURNOVERSPERGAME = oTURNOVERSPERGAME / GAMESPLAYED;
        oSTEALSPERGAME = oSTEALSPERGAME / GAMESPLAYED;
        oBLOCKSPERGAME = oBLOCKSPERGAME / GAMESPLAYED;
        oPERSONALFOULSPERGAME = oPERSONALFOULSPERGAME / GAMESPLAYED;

        teamName = getTeamName(teamID);

        double[] teamArray = new double[] {AVERAGESCORE,
                FIELDGOALSPERGAME,
                THREEPOINTERSPERGAME,
                FREETHROWPERGAME,
                OFFENSIVEREBOUNDSPERGAME , DEFENSIVEREBOUNDSPERGAME , TURNOVERSPERGAME,
                STEALSPERGAME, BLOCKSPERGAME, PERSONALFOULSPERGAME, AssistsPerGame, fieldGoalAttempts,
                threePointerAttempts ,freeThrowAttempts};

        double[] oppArray = new double[] {oAVERAGESCORE ,
                oFIELDGOALSPERGAME ,
                oTHREEPOINTERSPERGAME ,
                oFREETHROWPERGAME ,
                oOFFENSIVEREBOUNDSPERGAME , oDEFENSIVEREBOUNDSPERGAME , oTURNOVERSPERGAME,
                oSTEALSPERGAME, oBLOCKSPERGAME, oPERSONALFOULSPERGAME, oAssistsPerGame, ofieldGoalAttempts,
                othreePointerAttempts, ofreeThrowAttempts};

        for(int i = 0; i < teamArray.length; i++)
        {
            teamArray[i] = teamArray[i] - oppArray[i];

        }
        return new Team(teamID, teamName, teamArray);

    }

    public static ArrayList<Team> getTeamList (int year) throws IOException
    {
        ArrayList<Team> XXXXTeamList = new ArrayList<>();
        File Teams = new File("Teams.csv");
        Scanner fileReader = new Scanner(Teams).useDelimiter(",");

        fileReader.nextLine();

        while (fileReader.hasNext())
        {
            XXXXTeamList.add(getTeam(year, Integer.parseInt(fileReader.next())));
            fileReader.nextLine();
        }

        return XXXXTeamList;
    }

    public static ArrayList<Team> getBracket (ArrayList<Integer> teamIDs) throws IOException
    {
        ArrayList<Team> bracket = new ArrayList<>();
        File Teams = new File("Teams.csv");
        Scanner fileReader = new Scanner(Teams).useDelimiter(",");

        fileReader.nextLine();

        for(int i = 0; i < teamIDs.size(); i++)
        {
            bracket.add(getTeam(teamIDs.get(i)));
        }

        return bracket;
    }

    private static String getTeamName(int teamID) throws IOException
    {
        File Teams = new File("Teams.csv");
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

    public static double[] mergeStats(Team teamOne, Team teamTwo)
    {
        double[] statOne = teamOne.getStatArray();
        double[] statTwo = teamTwo.getStatArray();

        double[] merge = new double[statTwo.length + statTwo.length];
        for(int i = 0; i < statOne.length; i++)
        {
            merge[i] = statOne[i];
            merge[i + statOne.length] = statTwo[i];
        }
        return merge;
    }

    public static double[] reverseArray(double[] stats)
    {
        double[] reverseArray = stats;
        for (int i = 0; i < reverseArray.length / 2; i++)
        {
            double temp = reverseArray[reverseArray.length -1];
            reverseArray[reverseArray.length -1] = reverseArray[i];
            reverseArray[i] = temp;
        }
        return reverseArray;
    }


}
