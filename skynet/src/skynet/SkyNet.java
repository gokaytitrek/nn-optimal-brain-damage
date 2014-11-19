package skynet;

public class SkyNet {
    // Test class
    public static void main(String[] args) {
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
}
