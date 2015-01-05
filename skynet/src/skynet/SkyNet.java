package skynet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class SkyNet {
    // Test class
    public static void main(String[] args) throws IOException {
        
        int numberOfIterationOBD = 2;
        
        NeuralNetwork nn = new NeuralNetwork(4,0);
        Layer l1 = new Layer(6,0);
        nn.addLayer(l1);
//        Layer l2 = new Layer(30,0);
//        nn.addLayer(l2);
////        
//        Layer l3 = new Layer(30,0);
//        nn.addLayer(l3);
//        
//        Layer l4 = new Layer(3,0);
//        nn.addLayer(l4);
//        
        Layer l5 = new Layer(3,0);
        nn.addLayer(l5);
        
        int trainDataRate = 80;//%
        String fileName="Iris_data.txt";//~/rootFolder/Iris_data.txt
        int inputSize=nn.layers[0].size;
        int outputSize=nn.layers[nn.layers.length-1].size;
        
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
        
        System.out.println("Train - 1 (Only BackPropagation)"); 
        nn.train(traindata);
        
        int numberOfCorrect = 0;
        int [] numberOfCorrectOBD = new int[numberOfIterationOBD];
        
        
        for(double[] test : testdata)
        {
            double[] input = new double[inputSize];
            double[] desiredOutput = new double[outputSize];

            System.arraycopy(test, 0, input, 0, inputSize);

            System.arraycopy(test, inputSize, desiredOutput, 0, outputSize);

            double [] output = nn.run(input);
            
            if(check(desiredOutput, output))
                numberOfCorrect++;
           
        }
        
        

        for(int i=0;i<numberOfIterationOBD;i++)
        {
            System.out.println("Train - " + (i+2) + " (OBD)");
            nn.findMinWeightedPerceptron();
            nn.train(traindata);
            for(double[] test : testdata)
            {
                double[] input = new double[inputSize];
                double[] desiredOutput = new double[outputSize];

                System.arraycopy(test, 0, input, 0, inputSize);

                System.arraycopy(test, inputSize, desiredOutput, 0, outputSize);

                double [] output = nn.run(input);

                if(check(desiredOutput, output))
                    numberOfCorrectOBD[i]++;

            }
        }
        System.out.println("Test Data Size: " + testDataSize); 
        System.out.println("Num of correct: " + numberOfCorrect); 
        
        for(int i=0;i<numberOfIterationOBD;i++)
            System.out.println("Num of correct OBD_"+ (i+1) + ": " + numberOfCorrectOBD[i]); 
        System.out.println();  
        
        System.out.println("Check OBM_Results.txt");  
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("OBM_Results.txt", true)))) {
            
            String temp="";
            for(int i=0;i<numberOfIterationOBD;i++)
                temp += " OBD_"+ (i+1) + ": " + numberOfCorrectOBD[i] + " "; 
            String s = "(Train Data Size: " + trainDataSize + ") (Test Data Size: " + testDataSize + ") (# of Iteration(OBD): " + numberOfIterationOBD + ") (# of BP: "+numberOfCorrect + ") (" +temp + ")";
            out.println(s);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
    
    private static double threshold(double x)
    {
        if (x <= 0.5)
            x = 0;
        else
            x = 1;
        return x;
    }
    
    private static boolean check(double [] desiredOutput,double [] output)
    {
        if(desiredOutput.length == output.length)
        {
            for(int i=0; i<output.length;i++)
                if(desiredOutput[i] != threshold(output[i]))
                    return false;
            
            return true;
        }
        else 
            return false;
        
    }
}
