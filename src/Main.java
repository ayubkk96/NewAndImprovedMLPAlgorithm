import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        CarDataset.fromInputStream(DataSetLoader.load("resources/car.data"));
        CarDataset.setEncodedArray();
        NeuralNetwork.consumeFeatures(CarDataset.allFeatureVectors);
    }
}