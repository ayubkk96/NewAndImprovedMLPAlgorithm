import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        CarDataset carData = CarDataset.fromInputStream(DataSetLoader.load("resources/car.data"));
        System.out.println("Row: 1" + carData.rows.get(0));
        System.out.println("Features: 1" + Arrays.toString(carData.features.get(0)));
        Float[] vectors = CarParser.toOneHotFeatures(carData)
//        NeuralNetwork.consumeFeatures(carData.features);
    }
}