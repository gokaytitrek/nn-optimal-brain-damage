package skynet;

public class NeuralNetwork {
    int numberOfLayers;
    private int numberOfInputs;
    private int activationFunction; 
    protected Layer[] layers;   
    
    public NeuralNetwork(int numberOfInputs, int activationFunction) {
        this.numberOfInputs = numberOfInputs;
        this.numberOfLayers = 1;
        if (activationFunction==0)
            this.activationFunction = 0; //threshold
        else if (activationFunction==1)
            this.activationFunction = 1; //sigmoid
        // The first layer will be composed of InputPerceptrons
        Layer layer = new Layer(numberOfInputs,1); 
        layers = new Layer[1];
        layers[0] = layer;
    }
    public void addLayer(Layer layer) {
        // Connect last layer of the neural network to the new layer
        Layer lastLayer = layers[numberOfLayers-1]; // current last layer
        for (int i=0;i<lastLayer.size;i++) 
            for (int j=0;j<layer.size;j++) {
                /* add each neuron in the new layer as children of each 
                 * neuron in the last layer */
                lastLayer.getPerceptron(i).addChild(layer.getPerceptron(j));
            }
        
        /* Create a new layer array, copy the old on the the new, add the 
         * new layer as the last, assign it to layers. This will not be done
         * often, i.e. during training and testing. */
        Layer[] layersNew = new Layer[numberOfLayers+1];
        System.arraycopy(layers, 0, layersNew, 0, numberOfLayers);
        layersNew[numberOfLayers]=layer;
        layers = layersNew;
        numberOfLayers++;        
    }
    public double[] run(double[] data) {
        // Run the neural network on given input data
        for (int i=0;i<data.length;i++) {
            // Give input as stimulation to the first layer
            Perceptron p = layers[0].getPerceptron(i);
            layers[0].getPerceptron(i).stimulate(data[i]);
        }
        for (int layer = 0; layer<numberOfLayers;layer++)
            for (int j=0;j<layers[layer].size;j++) 
                // Run each neuron in each layer                
                layers[layer].getPerceptron(j).run();
            
        // Get the outputs of the last layer and return as NN output
        double[] out = new double[layers[numberOfLayers-1].size];
        for (int i=0;i<out.length;i++)
            out[i]=layers[numberOfLayers-1].getPerceptron(i).getOutput();
        return out;
    }
  
}
