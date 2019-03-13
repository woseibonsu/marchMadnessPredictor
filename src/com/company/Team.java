package com.company;

public class Team {

    private int year, teamID, gamesPlayed, averageScore, wins, losses,
            fieldGoalsPerGame, threePointersPerGame, freeThrowsPerGame,
            offensiveReboundsPerGame, defensiveReboundsPerGame, turnOversPerGame,
            stealsPerGame, blocksPerGame, personalFoulsPerGame;

    private double fieldGoalSuccessRate, threePointerSuccessRate, freeThrowSuccessRate;

    private String teamName;

    public Team(int year, int teamID, String teamName, int gp , int as , int wins , int losses,
                int fpg , double fps, int fg3pg , double fg3pgs, int ftpg , double fts,
                int orpg , int drpg , int topg, int spg, int bpg, int pfpg)
    {
        this.year = year;
        this.teamID = teamID;
        this.gamesPlayed = gp;
        this.averageScore = as;
        this.wins = wins;
        this.losses = losses;
        this.fieldGoalsPerGame = fpg;
        this.threePointersPerGame = fg3pg;
        this.freeThrowsPerGame = ftpg;
        this.offensiveReboundsPerGame = orpg;
        this.defensiveReboundsPerGame = drpg;
        this.turnOversPerGame = topg;
        this.stealsPerGame = spg;
        this.blocksPerGame = bpg;
        this.personalFoulsPerGame = pfpg;
        this.fieldGoalSuccessRate = fps;
        this.threePointerSuccessRate = fg3pgs;
        this.freeThrowSuccessRate = fts;
        this.teamName = teamName;
    }


    @Override
    public String toString()
    {
        return teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getYear() {
        return year;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getFieldGoalsPerGame() {
        return fieldGoalsPerGame;
    }

    public int getThreePointersPerGame() {
        return threePointersPerGame;
    }

    public int getFreeThrowsPerGame() {
        return freeThrowsPerGame;
    }

    public int getOffensiveReboundsPerGame() {
        return offensiveReboundsPerGame;
    }

    public int getDefensiveReboundsPerGame() {
        return defensiveReboundsPerGame;
    }

    public int getTurnOversPerGame() {
        return turnOversPerGame;
    }

    public int getStealsPerGame() {
        return stealsPerGame;
    }

    public int getBlocksPerGame() {
        return blocksPerGame;
    }

    public int getPersonalFoulsPerGame() {
        return personalFoulsPerGame;
    }

    public double getFieldGoalSuccessRate() {
        return fieldGoalSuccessRate;
    }

    public double getFreeThrowSuccessRate() {
        return freeThrowSuccessRate;
    }

    public double getThreePointerSuccessRate() {
        return threePointerSuccessRate;
    }

}
