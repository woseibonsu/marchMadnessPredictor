package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) throws IOException {

        //TESTER
        Team kansas = Analyzer.getTeam(2018, 1242);
        Team notkansas = Analyzer.getTeam(2018, 1108);

//        System.out.println(kansas.getAverageScore());
//        System.out.println(kansas.getGamesPlayed());


        System.out.println(Game.monteCarlo(kansas, notkansas));


    }

}
