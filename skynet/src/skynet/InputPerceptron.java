package skynet;

public class InputPerceptron extends Perceptron {

    @Override
     public void run() {
        // Input perceptrons do not have activation functions or bias
        output=input;
        for (int i=0;i<numberOfChildren;i++)
            children[i].stimulate(output*weights[i]); 
        input=0;
    }     
}
