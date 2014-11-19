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
    public static double sigmoidDerivative(double input) {
        double sig = 1/(1+Math.exp(-input));
        return sig*(1-sig);
    }
    public void train(double[][] traindata,double[][] labels) {
        double errorThreshold = 0.01;
        double E = 1;
        int epoch = 0;
        double[] input = new double[4];
        double[] output;
        double delta;
        double totalNextError;
        double alpha = 0.001;
        boolean show=false;
        while (E>errorThreshold) {
            epoch++; 
            if (epoch%10000==0) show=true;
            if (show) System.out.print("Epoch: " + epoch);
            for (int sample=0;sample<traindata.length;sample++) {
                for (int i=0;i<4;i++) {
                    input[i]=traindata[sample][i];}
                output = run(input);
                for (int i=0;i<labels[0].length;i++) {
                     delta =  NeuralNetwork.sigmoidDerivative(layers[numberOfLayers-1].getPerceptron(i).oldInput)
                            *(labels[sample][i]-output[i]);
                     layers[numberOfLayers-1].getPerceptron(i).delta = delta;
                }
                for (int layer = numberOfLayers-2;layer>=0;layer--) {                    
                    for (int node=0;node<layers[layer].size;node++) {
                        Perceptron n = layers[layer].getPerceptron(node);
                        totalNextError = 0;
                        for (int nodeNextLayer=0;nodeNextLayer<layers[layer+1].size;nodeNextLayer++) {
                            totalNextError+=n.weights[nodeNextLayer]*layers[layer+1].getPerceptron(nodeNextLayer).delta;
                        }
                        n.delta = sigmoidDerivative(n.oldInput)*totalNextError;
                        for (int next=0;next<layers[layer+1].size;next++) {
                            n.weights[next]+=alpha*n.output*layers[layer+1].getPerceptron(next).delta;
                            layers[layer+1].getPerceptron(next).biasWeight+=alpha*(-1)*layers[layer+1].getPerceptron(next).delta; 
                        }
                    }
                }                           
            }
            E=0;
            for (int sample=0;sample<traindata.length;sample++) {
                for (int i=0;i<4;i++) {
                    input[i]=traindata[sample][i];}
                output = run(input);
                for (int i=0;i<labels[0].length;i++) {
                    E+=(1.0/2)*Math.pow(labels[sample][i]-output[i],2);
                }                
            }
            if (show) {System.out.println("\tTotal square error: "+ E); show=false;}
            
            
            
        }
        
        
    }
   
}
