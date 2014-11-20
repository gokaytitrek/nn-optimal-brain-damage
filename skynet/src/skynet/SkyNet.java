package skynet;

import java.io.IOException;
import java.util.HashMap;

public class SkyNet {
    // Test class
    public static void main(String[] args) throws IOException {
        
        NeuralNetwork nn = new NeuralNetwork(4,0);
        Layer l1 = new Layer(6,0);
        nn.addLayer(l1);
        Layer l2 = new Layer(3,0);
        nn.addLayer(l2);
        
        int trainDataRate = 80;//%80
        String fileName="Iris_data.txt";
        int inputSize=4;
        int outputSize=3;
        
        // Iris setosa = 0 0 1, Iris versicolor = 0 1 0, Iris virginica = 1 0 0
        HashMap<String, double[]> labels = new HashMap<String, double[]>();
        labels.put("Iris-setosa", new double[] {0,0,1});
        labels.put("Iris-versicolor", new double[] {0,1,0});
        labels.put("Iris-virginica", new double[] {1,0,0});
        
        double [][] data = nn.readData(fileName,labels,inputSize,outputSize);
        
        int trainDataSize = data.length*trainDataRate/100;
        int testDataSize = data.length - trainDataSize;
        
        double [][] traindata = new double[trainDataSize][inputSize+outputSize];
        double [][] testdata = new double[testDataSize][inputSize+outputSize];
        nn.makeTrainData(data,traindata,testdata);
        
        nn.train(traindata);
        double[] input = {1,0,1,1};
        double [] output = nn.run(input);
        
        for (int i=0;i<output.length;i++)
            System.out.println(output[i]);
        

    }
}
