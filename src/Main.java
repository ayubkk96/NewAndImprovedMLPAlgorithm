public class Main {


    public static void main(String[] args) {
        CarDataset carData = CarDataset.fromInputStream(DataSetLoader.load("resources/car.data"));
        System.out.println(carData);
    }
}