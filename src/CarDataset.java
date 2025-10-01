import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

final class CarDataset {
    // A List to hold all the car records
    public static final List<CarRecord> carRecords = new ArrayList<>();
    // A List to hold all input data (features)
    public static List<int[]> allFeatureVectors = new ArrayList<>();
    // A List to hold all output data (labels)
    public static List<int[]> allLabelVectors = new ArrayList<>();

    public static CarDataset fromInputStream(InputStream file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8))) {
            String line;
            CarDataset ds = new CarDataset();
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                ds.addLine(line);
            }
            return ds;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addLine(String line) {
        carRecords.add(CarParser.parse(line));
    }

    // to be refactored into a smarter way haha!
    public static void setEncodedArray() {
        for (int i = 0; i < carRecords.size(); i++) {
            int[] buyingVector = new int[4];
            int[] maintVector = new int[4];
            int[] doorsVector = new int[4];
            int[] personsVector = new int[3];
            int[] lugBootVector = new int[3];
            int[] safetyVector = new int[3];
            int[] labelVector = new int[4];
            if (carRecords.get(i).buying.equals("vhigh")) {
                buyingVector = new int[]{1, 0, 0, 0};
            }
            if (carRecords.get(i).buying.equals("high")) {
                buyingVector = new int[]{0, 1, 0, 0};
            }
            if (carRecords.get(i).buying.equals("med")) {
                buyingVector = new int[]{0, 0, 1, 0};
            }
            if (carRecords.get(i).buying.equals("low")) {
                buyingVector = new int[]{0, 0, 0, 1};
            }
            if (carRecords.get(i).maint.equals("vhigh")) {
                maintVector = new int[]{1, 0, 0, 0};
            }
            if (carRecords.get(i).maint.equals("high")) {
                maintVector = new int[]{0, 1, 0, 0};
            }
            if (carRecords.get(i).maint.equals("med")) {
                maintVector = new int[]{0, 0, 1, 0};
            }
            if (carRecords.get(i).maint.equals("low")) {
                maintVector = new int[]{0, 0, 0, 1};
            }
            if (carRecords.get(i).doors.equals("2")) {
                doorsVector = new int[]{1, 0, 0, 0};
            }
            if (carRecords.get(i).doors.equals("3")) {
                doorsVector = new int[]{0, 1, 0, 0};
            }
            if (carRecords.get(i).doors.equals("4")) {
                doorsVector = new int[]{0, 0, 1, 0};
            }
            if (carRecords.get(i).doors.equals("5more")) {
                doorsVector = new int[]{0, 0, 0, 1};
            }
            if (carRecords.get(i).persons.equals("2")) {
                personsVector = new int[]{1, 0, 0};
            }
            if (carRecords.get(i).persons.equals("4")) {
                personsVector = new int[]{0, 1, 0};
            }
            if (carRecords.get(i).persons.equals("more")) {
                personsVector = new int[]{0, 0, 1};
            }
            if (carRecords.get(i).lugBoot.equals("small")) {
                lugBootVector = new int[]{1, 0, 0};
            }
            if (carRecords.get(i).lugBoot.equals("med")) {
                lugBootVector = new int[]{0, 1, 0};
            }
            if (carRecords.get(i).lugBoot.equals("big")) {
                lugBootVector = new int[]{0, 0, 1};
            }
            if (carRecords.get(i).safety.equals("low")) {
                safetyVector = new int[]{1, 0, 0};
            }
            if (carRecords.get(i).safety.equals("med")) {
                safetyVector = new int[]{0, 1, 0};
            }
            if (carRecords.get(i).safety.equals("high")) {
                safetyVector = new int[]{0, 0, 1};
            }
            if (carRecords.get(i).label.equals("unacc")) {
                labelVector = new int[]{1, 0, 0, 0};
            }
            if (carRecords.get(i).label.equals("acc")) {
                labelVector = new int[]{0, 1, 0, 0};
            }
            if (carRecords.get(i).label.equals("good")) {
                labelVector = new int[]{0, 0, 1, 0};
            }
            if (carRecords.get(i).label.equals("vgood")) {
                labelVector = new int[]{0, 0, 0, 1};
            }
            int[] inputVector = Stream.of(buyingVector, maintVector, doorsVector,
                            personsVector, lugBootVector, safetyVector)
                    .flatMapToInt(Arrays::stream)
                    .toArray();

            allFeatureVectors.add(inputVector);
            allLabelVectors.add(labelVector);
        }
    }
}
