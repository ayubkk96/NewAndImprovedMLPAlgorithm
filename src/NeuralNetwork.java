import java.util.Arrays;
import java.util.List;

public class NeuralNetwork {

    public static void consumeFeatures(List<int[]> features){
        for (int[] feature : features) {
            forwardPropagation(feature);
        }
    }

    public static void consumeLabels(List<int[]> labels){
        for (int[] label : labels) {
            System.out.println(Arrays.toString(label));
        }
    }

    public static void forwardPropagation(int[] inputVector){
        
    }
}
