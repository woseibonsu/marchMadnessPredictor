package com.company;
import java.util.*;

public class TrainSet
{
    public final int inputSize;
    public final int outputSize;

    private ArrayList<double[][]> data = new ArrayList<>();

    public TrainSet(int inputsize, int outputsize)
    {
        this.inputSize=inputsize;
        this.outputSize=outputsize;
    }

    public TrainSet extractBatch(TrainSet set, int num)
    {
        return set;
    }

    public void addData(double[] in, double[] expected)
    {
        if(in.length != inputSize || expected.length != outputSize) return;
        data.add(new double[][]{in,expected});
    }

    public int size()
    {
        return data.size();
    }

    public double[] getInput(int index)
    {
        return data.get(index)[0];
    }

    public double[] getOutput(int index)
    {
        return data.get(index)[1];
    }




}
