package com.company;

public class NetworkTools {

    public static double[] createRandomArray(int size, double lowbound, double highbound)
    {
        if(size<1)return null;
        double[]ar= new double[size];
        for(int i=0;i<size;i++)
            ar[i]=randomValue(lowbound,highbound);
        return ar;
    }

    public static double[][] createRandomArray(int sizeX, int sizeY, double lowbound, double highbound)
    {
        if(sizeX<1||sizeY<1)return null;
        double[][]ar= new double[sizeX][sizeY];
        for(int i=0;i<sizeX;i++)
            ar[i]=createRandomArray(sizeY, lowbound, highbound);
        return ar;
    }

    public static double randomValue(double low,double high)
    {
        return Math.random()*(high-low)+low;
    }


}
