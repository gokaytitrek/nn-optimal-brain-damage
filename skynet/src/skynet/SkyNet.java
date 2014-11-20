package skynet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SkyNet {
    // Test class
    public static void main(String[] args) throws IOException {
        read();
        NeuralNetwork nn = new NeuralNetwork(4,0);
        Layer l1 = new Layer(6,0);
        nn.addLayer(l1);
        Layer l2 = new Layer(3,0);
        nn.addLayer(l2);
        
        double [][] traindata = {{1,0,1,0},{0,1,0,1},{1,1,1,1}};
        double [][] trainlabels = {{1,0,0},{0,1,0},{0,0,1}};
        nn.train(traindata,trainlabels);
        double[] input = {1,0,1,1};
        double [] output = nn.run(input);
        
        for (int i=0;i<output.length;i++)
            System.out.println(output[i]);
        
    }
    
    public static void read() throws FileNotFoundException, IOException
    {
        String FolderPath = (new File(".").getAbsolutePath())+"/Iris_data.txt";
        BufferedReader br = new BufferedReader(new FileReader(FolderPath));
        String line = null;
       
        while ((line = br.readLine()) != null) {
            String a = line;
        }
    }
}
