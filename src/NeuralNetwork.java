import java.util.Arrays;
import java.util.List;

public class NeuralNetwork {

    static double[][] weightsHidden1 = new double[16][21]; // 16 neurons, 21 weights each
    static double[] biasHidden1 = new double[16];
    static final int HIDDEN_LAYER_1_SIZE = 16;


    double[][] weightsHidden2 = new double[12][16]; // 12 neurons, each takes 16 inputs
    double[] biasHidden2 = new double[12];

    double[][] weightsOutput = new double[4][12]; // 4 neurons, each takes 12 inputs
    double[] biasOutput = new double[OUTPUT_LAYER_SIZE];
    static final int OUTPUT_LAYER_SIZE = 4;
    static final int HIDDEN_LAYER_2_SIZE = 12;
    double[] hidden2Output = new double[HIDDEN_LAYER_2_SIZE];

    public static void consumeFeatures(List<int[]> features){
        for (int[] feature : features) {
           double[] hidden1Output = forwardPropagation(feature);
           System.out.println(Arrays.toString(hidden1Output));
        }
    }

    public static void consumeLabels(List<int[]> labels){
        for (int[] label : labels) {
            System.out.println(Arrays.toString(label));
        }
    }

    public static double[] forwardPropagation(int[] inputVector){
        double[] hidden1Output = new double[HIDDEN_LAYER_1_SIZE];
        for (int neuron = 0; neuron < hidden1Output.length; neuron++) {
            double sum = 0;
            for (int i = 0; i < 21; i++) {
                sum += inputVector[i] * weightsHidden1[neuron][i];
            }
            sum += biasHidden1[neuron];
            hidden1Output[neuron] = sigmoid(sum); // apply activation
        }
        return hidden1Output;
    }

    static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}
