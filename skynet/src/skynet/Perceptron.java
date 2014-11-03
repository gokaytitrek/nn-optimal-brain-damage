package skynet;

public class Perceptron {
    protected int numberOfChildren;
    protected Perceptron[] children;
    protected double[] weights;
    protected double input; 
    protected double output;
    protected double biasWeight; // Bias weight
    
    public Perceptron() {
        input = 0;        
        numberOfChildren = 0;
        biasWeight = Math.random();
    }
    
    public void addChild(Perceptron c) {
        if (numberOfChildren==0) {
            children = new Perceptron[1];
            weights = new double[1];
        }
        /* Create new children and weights arrays and put the new child 
         * and its weight in the children and weights arrays. This will 
         * not be done often, i.e. in training and testing. */
        Perceptron[] childrenNew = new Perceptron[numberOfChildren+1];
        System.arraycopy(children,0,childrenNew,0,numberOfChildren);
        childrenNew[numberOfChildren] = c;
        children = childrenNew;
        
        double[] weightsNew = new double[numberOfChildren+1];
        System.arraycopy(weights,0,weightsNew,0,numberOfChildren);
        weightsNew[numberOfChildren] = Math.random();
        weights = weightsNew;
        
        numberOfChildren++;
    }
    
    protected void stimulate(double s) {
        // A neuron calculates its output and stimulates its children with
        // output times the weight of the link to the children. 
        input+=s;
    }    
    
    public void run() {
        input-=biasWeight; // bias is always -1
        activate(); // Run input through the activation function. 
        for (int i=0;i<numberOfChildren;i++)
            children[i].stimulate(output*weights[i]); // Stimulate all children
        input=0; // Reset input
    }

    private void activate() {
        // Run the total input to the neuron through the activation function. 
        output = 1/(1+Math.exp(-input));
    }
    public double getOutput() {
        return output;
    }
}
