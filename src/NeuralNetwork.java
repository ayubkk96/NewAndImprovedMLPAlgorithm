import java.util.Arrays;
import java.util.List;

public class NeuralNetwork {

    public static void consumeFeatures(List<float[]> features){
        System.out.println("Features consumed:");
        for (float[] f : features) {
            System.out.println(Arrays.toString(f));
        }
    }
}
