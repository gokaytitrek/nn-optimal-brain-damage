package skynet;

public class SkyNet {
    // Test class
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork(2,0);
        Layer l1 = new Layer(3,0);
        nn.addLayer(l1);
        Layer l2 = new Layer(2,0);
        nn.addLayer(l2);
        nn.backPropagation();
        
        double [] input = {0.1,0.9};
        double [] output = nn.run(input);
    }
}
