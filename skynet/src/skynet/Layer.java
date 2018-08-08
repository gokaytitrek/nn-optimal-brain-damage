package skynet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer {
    protected int size;
    private Perceptron[] perceptrons;
    
    public Layer(int size, int type) {
        this.size = size;
        perceptrons = new Perceptron[size];
        if (type==0) {
            for (int i=0;i<size;i++)            
                perceptrons[i] = new Perceptron();
            return;
        }
        for (int i=0;i<size;i++)            
            perceptrons[i] = new InputPerceptron();        
    }
    public Perceptron getPerceptron(int k) {
        // Return kth perceptron in the layer. 
        return perceptrons[k];
    }
    
    public void deletePerceptron(Perceptron p)
    {
        Perceptron[] newPerceptrons = new Perceptron[this.perceptrons.length-1];
        List<Perceptron> list = new ArrayList<Perceptron>(Arrays.asList(this.perceptrons));
        list.remove(p);
        list.toArray(newPerceptrons);
        this.perceptrons = newPerceptrons;
        this.size--;
    }
    
}
