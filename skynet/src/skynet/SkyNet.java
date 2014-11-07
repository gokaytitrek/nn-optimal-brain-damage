package skynet;

public class SkyNet {
    // Test class
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork(2,0);
        Layer l1 = new Layer(2,0);
        nn.addLayer(l1);
        Layer l2 = new Layer(1,0);
        nn.addLayer(l2);
        
        nn.layers[0].getPerceptron(0).weights[0]=1;
        nn.layers[0].getPerceptron(1).weights[0]=1;
        nn.layers[0].getPerceptron(0).weights[1]=1;
        nn.layers[0].getPerceptron(1).weights[1]=1;        
        
        nn.layers[1].getPerceptron(0).weights[0]=-1;
        nn.layers[1].getPerceptron(1).weights[0]=1;
        nn.layers[1].getPerceptron(0).biasWeight = 1.5;
        nn.layers[1].getPerceptron(1).biasWeight = 0.5;
        
        nn.layers[2].getPerceptron(0).biasWeight= 0.5;
        
        
        double [] input = {1,1};
        double [] output = nn.run(input);
    }
}
