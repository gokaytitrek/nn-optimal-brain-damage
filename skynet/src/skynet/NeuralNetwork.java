package skynet;

public class NeuralNetwork {
    int numberOfLayers;
    private int numberOfInputs;
    private int activationFunction; 
    private double learnRate = 0.001;
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
  
    public void backPropagation(double[][] allData)
    {
        int epoch = 0;
        while (epoch < 1000)
        {
            for (double[] inputTargetData: allData) {
                double [] inputData = new double[numberOfInputs];
                double [] targetData = new double[layers[numberOfLayers-1].size];

                System.arraycopy(inputTargetData, 0, inputData, 0, numberOfInputs);
                System.arraycopy(inputTargetData, numberOfInputs, targetData, 0, layers[numberOfLayers-1].size);
                // Run the neural network on given input data
                /*
                for (int i=0;i<inputData.length;i++) {
                    // Give input as stimulation to the first layer
                    //Perceptron p = layers[0].getPerceptron(i);
                    layers[0].getPerceptron(i).stimulate(inputData[i]);
                }
                */
                for (Layer l : layers)
                {
                   for (int j=0;j<l.size;j++)              
                        l.getPerceptron(j).run();
                }

                for (int outputNodes = 0 ; outputNodes < layers[numberOfLayers-1].size ; outputNodes++) {
                        layers[numberOfLayers-1].getPerceptron(outputNodes).calculateDelta(targetData[outputNodes]);
                    }
                
                for (int i = numberOfLayers - 2 ; i> 0 ; i ++)
                {
                    for (int j = 0 ; j< layers[i].size ; j++)
                    {
                        double sum = 0;
                        for (int k=0;k<layers[i].getPerceptron(j).numberOfChildren;k++)
                        {
                            sum += layers[i+1].getPerceptron(j).delta * layers[i].getPerceptron(j).weights[k];
                        }
                        layers[i].getPerceptron(j).delta = sum * layers[i].getPerceptron(j).sigmoid_derivative();
                        
                        for (Perceptron p : layers[i+1].perceptrons)
                        {
                            for(double weight : p.weights)
                            {
                                weight = weight + (learnRate*p.input*p.delta);
                            }
                        }
                    }
                }
                
                epoch++;
        }
                
        }
        
    }
}
