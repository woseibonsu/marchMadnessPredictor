package com.company;

public class Team {

    /*year,  teamID, GAMESPLAYED , AVERAGESCORE , WINS , LOSSES,
                FIELDGOALSPERGAME , FIELDGOALSUCCESS,
                THREEPOINTERSPERGAME , THREEPOINTERSSUCCESS,
                FREETHROWPERGAME , FREETHROWSUCCESS,
                OFFENSIVEREBOUNDSPERGAME , DEFENSIVEREBOUNDSPERGAME , TURNOVERSPERGAME,
                STEALSPERGAME, BLOCKSPERGAME, PERSONALFOULSPERGAME, AssistsPerGame
                 fieldGoalAttempts, threePointerAttempts ,freeThrowAttempts*/

    private String teamName;
    private int year, teamID;

    //CONSTRUCTS A TEAM FOR GIVEN YEAR
    private double[] statArray;
    public Team(int year, int teamID, String team, double[] statArray)
    {
        this.year = year;
        this.teamName = team;
        this.teamID = teamID;
        this.statArray = statArray;
    }

    //CONSTRUCTS A HOLISTIC TEAM
    public Team(int teamID, String team, double[] statArray)
    {
        this.year = year;
        this.teamName = team;
        this.teamID = teamID;
        this.statArray = statArray;
    }

    @Override
    public String toString()
    {
        return teamName;
    }

    public double getGamesPlayed(){return statArray[1];}

    public double getWins(){return statArray[3];}

    public double getLosses(){return statArray[4];}

    //<editor-fold desc="Get methods for statArray">
    public double[] getStatArray() {
        return statArray;
    }

    public double getAverageScore(){return statArray[2];}

    public double getFieldGoalsMadePerGame(){return statArray[5];}

    public double getFieldGoalsAttempted(){return statArray[19];} //

    public double getFieldGoalScuessRate(){return statArray[6];}

    public double getThreePointersMadePerGame(){return statArray[7];}

    public double getThreePointersAttempted(){return statArray[20];} //

    public double getThreePointerScuessRate(){return statArray[8];}

    public double getFreeThrowsMadePerGame(){return statArray[9];}

    public double getFreeThrowsAttempted(){return statArray[21];} //

    public double getFreeThrowScuessRate(){return statArray[10];}

    public double getOffensiveReboundsPerGame(){return statArray[11];}

    public double getDefensiveReboundsPerGame(){return statArray[12];}

    public double getTurnOversPerGame(){return statArray[13];}

    public double getStealsPerGame(){return statArray[15];}

    public double getBlocksPerGame(){return statArray[16];}

    public double getPersonalFoulsPerGame(){return statArray[17];}

    public double getAssistsPerGame(){return statArray[18];}
    //</editor-fold>

}
