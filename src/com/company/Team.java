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

    private double[] statArray, oStatArray;

    public Team(double[] statArray , double[] oppoentStatArray, String teamName)
    {
        this.statArray = statArray;
        oStatArray = oppoentStatArray;
        this.teamName = teamName;
    }


    @Override
    public String toString()
    {
        return teamName;
    }

    public double getGamesPlayed(){return statArray[1];}

    public double getWins(){return statArray[3];}

    public double getLosses(){return statArray[4];}

    //<editor-fold desc="GET METHODS FOR WINING STATS">
    public double[] getWinningStatArray() {
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

    //<editor-fold desc="GET METHODS FOR LOOSING STATS">
    public double[] getOppStatArray() {
        return oStatArray;
    }

    public double getOppAverageScore(){return oStatArray[0];}

    public double getOppFieldGoalsMadePerGame(){return oStatArray[1];}

    public double getOppFieldGoalsAttempted(){return oStatArray[14];} //

    public double getOppFieldGoalScuessRate(){return oStatArray[2];}

    public double getOppThreePointersMadePerGame(){return oStatArray[3];}

    public double getOppThreePointersAttempted(){return oStatArray[15];} //

    public double getOppThreePointerScuessRate(){return oStatArray[4];}

    public double getOppFreeThrowsMadePerGame(){return oStatArray[5];}

    public double getOppFreeThrowsAttempted(){return oStatArray[16];} //

    public double getOppFreeThrowScuessRate(){return oStatArray[6];}

    public double getOppOffensiveReboundsPerGame(){return oStatArray[7];}

    public double getOppDefensiveReboundsPerGame(){return oStatArray[8];}

    public double getOppTurnOversPerGame(){return oStatArray[9];}

    public double getOppStealsPerGame(){return oStatArray[10];}

    public double getOppBlocksPerGame(){return oStatArray[11];}

    public double getOppPersonalFoulsPerGame(){return oStatArray[12];}

    public double getOppAssistsPerGame(){return oStatArray[13];}
    //</editor-fold>

}
