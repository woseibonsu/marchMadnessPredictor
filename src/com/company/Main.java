package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> teamIDs = new ArrayList<>(Arrays.asList
                (
                        //THIS IS WHERE OUR TEAM IDS WILL GO

                        //HALF ONE
                        1438, 1420, 1166, 1243, 1246, 1172, 1112, 1138,
                        1274, 1260, 1397, 1460, 1305, 1400, 1153, 1209,
                        1462, 1411, 1281, 1199, 1326, 1377, 1211, 1422,
                        1222, 1361, 1276, 1285, 1401, 1344, 1314, 1252,

                        //HALF TWO
                        1437, 1347, 1439, 1104, 1452, 1296, 1455, 1267,
                        1196, 1382, 1403, 1372, 1116, 1139, 1345, 1168,
                        1242, 1335, 1371, 1301, 1155, 1308, 1120, 1149,
                        1395, 1393, 1277, 1137, 1348, 1328, 1181, 1233

                ));

        System.out.println(teamIDs.size());

        //GETS BRACKET BASED ON IDS
        ArrayList<Team> bracket = Analyzer.getBracket(teamIDs);
        System.out.println(bracket); //DEBUG
        //PLAYS THE TOURNAMENT
        Tournament marchMadness = Game.playTournament(bracket);
        System.out.println(marchMadness);
    }

}
