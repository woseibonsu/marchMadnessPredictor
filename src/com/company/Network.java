package com.company;


import java.util.Arrays;

public class Network {

    private double[][]outputs, bias, error, derivative;//individual outputs of neurons at layer, neuron
    private double[][][]weights;//weights between neurons at to layer, to neuron, from neuron


    private final int[] layerSize;
    private final int inputSize, networkSize, outputSize;

    private Network(int...layerSize)
    {
        this.layerSize=layerSize;
        this.inputSize=layerSize[0];
        this.networkSize=layerSize.length;
        this.outputSize=layerSize[networkSize-1];

        this.outputs=new double[networkSize][];
        this.error=new double[networkSize][];
        this.derivative=new double[networkSize][];
        this.weights=new double[networkSize][][];
        this.bias=new double[networkSize][];

        for(int i=0;i<networkSize;i++)
        {
            this.outputs[i]= new double[layerSize[i]];
            this.error[i]= new double[layerSize[i]];
            this.derivative[i]= new double[layerSize[i]];
            this.bias[i]= NetworkTools.createRandomArray(layerSize[i],-0.5,0.5);
            if(i>0) this.weights[i]=NetworkTools.createRandomArray(layerSize[i],layerSize[i-1],-0.5,0.5);
        }
    }

    private double[] calculate(double...input)
    {
        //catches mistake in input length
        if(this.inputSize!=input.length) return null;

        //puts input into first layer of network
        this.outputs[0]=input;

        for(int layer=1; layer<networkSize; layer++)
            for(int neuron=0; neuron<layerSize[layer]; neuron++) {
                double sum = bias[layer][neuron];
                for (int prevneuron = 0; prevneuron < layerSize[layer - 1]; prevneuron++)
                    sum += outputs[layer - 1][prevneuron] * weights[layer][neuron][prevneuron];
                double o1=outputs[layer][neuron] = (1.0)/ (1 + Math.exp(-sum));
                derivative[layer][neuron] = o1 * (1-o1);
            }
        return outputs[networkSize-1];
    }


    private void train(double[]input,double[]target,double rate)
    {
        if(input.length!=inputSize||target.length!=outputSize)return;
        calculate(input);
        backPropError(target);
        updateWeights(rate);
    }

    public void train(TrainSet set, int loops, int batchsize)
    {
        if(set.inputSize!=inputSize||set.outputSize!=outputSize)return;
        for(int i=0;i<loops;i++)
        {
            TrainSet batch = set.extractBatch(set,batchsize);
            for(int b=0;b<batchsize;b++)
            {
                this.train(batch.getInput(b),batch.getOutput(b),0.3);
            }
        }
    }

    public double error(double[] input, double[] target)
    {
        if(input.length!=inputSize||target.length!=outputSize)return 0;
        calculate(input);
        double v=0;
        for(int i=0;i<target.length;i++)
        {
            v+=(target[i]-outputs[networkSize-1][i])*(target[i]-outputs[networkSize-1][i]);
        }
        return v/(2.0*target.length);
    }

    public double error(TrainSet set) {
        double v=0;
        for(int i=0;i<set.size();i++)
        {
            v+=error(set.getInput(i),set.getOutput(i));
        }
        return v/set.size();
    }

    private void backPropError(double[] target) {
        for (int neuron = 0; neuron < outputSize; neuron++)
            error[networkSize-1][neuron] = (outputs[networkSize-1][neuron] - target[neuron]) * derivative[networkSize-1][neuron];
        for (int layer = networkSize - 2; layer > 0; layer--)
            for (int neuron = 0; neuron < layerSize[layer]; neuron++)
            {
                double sum = 0;
                for (int nextneuron = 0; nextneuron < layerSize[layer + 1]; nextneuron++)
                    sum += weights[layer + 1][nextneuron][neuron] * error[layer + 1][nextneuron];
                this.error[layer][neuron] = sum * derivative[layer][neuron];
            }
    }

    private void updateWeights(double rate) {
        for(int layer=1;layer<networkSize;layer++)
            for(int neuron=0;neuron<layerSize[layer];neuron++)
            {
                for(int prevneuron=0;prevneuron<layerSize[layer-1];prevneuron++)
                {
                    double delta = -rate * outputs[layer-1][prevneuron] * error[layer][neuron];
                    weights[layer][neuron][prevneuron]+=delta;
                }
                double delta = -rate * error[layer][neuron];
                bias[layer][neuron]+=delta;
            }
    }

    public static void main2(String[] args)
    {
        //Parameters you can change for the network
        double input[]=new double[]{0,0,1};
        double target[]=new double[]{1,0};
        double input2[]=new double[]{1,0,0};
        double target2[]=new double[]{0,1};
        double input3[]=new double[]{0,1,0};
        double target3[]=new double[]{1,1};
        double input4[]=new double[]{1,1,1};
        double target4[]=new double[]{0,0};
        double input5[]=new double[]{1,0,1};
        double rate=.3;
        int iterations=100000;
        Network net = new Network(input.length,15,8,3,2);

        //trains the network
        for(int i=0;i<iterations;i++){
            net.train(input,target,rate);
            net.train(input2,target2,rate);
            net.train(input3,target3,rate);
            net.train(input4,target4,rate);
        }

        //prints the network
        System.out.println(Arrays.toString(net.calculate(input)));
        System.out.println(Arrays.toString(net.calculate(input2)));
        System.out.println(Arrays.toString(net.calculate(input3)));
        System.out.println(Arrays.toString(net.calculate(input5)));
    }

    public static void main(String[] args)
    {
        Network net = new Network(4,3,2,1);
        TrainSet set = new TrainSet(4,1);

        set.addData(new double[]{0.1,0.4,0.6,0.6},new double[]{0.5});
        set.addData(new double[]{0.3,0.4,0.6,0.5},new double[]{0.7});
        set.addData(new double[]{0.5,0.4,0.6,0.4},new double[]{0.8});
        set.addData(new double[]{0.7,0.4,0.6,0.3},new double[]{0.87});
        set.addData(new double[]{0.9,0.4,0.6,0.2},new double[]{0.89});

        net.train(set,100000,4);
        for(int i=0;i<5;i++)
        {
            System.out.println(Arrays.toString(net.calculate(set.getInput(i))));
        }

    }



}

