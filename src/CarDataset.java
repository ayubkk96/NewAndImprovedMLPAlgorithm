import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

final class CarDataset {
    public final List<CarRecord> rows = new ArrayList<>();
    public final List<float[]> features = new ArrayList<>();
    public final List<Integer> labels = new ArrayList<>();

    public void addLine(String line) {
        CarRecord r = CarParser.parse(line);
        rows.add(r);
        features.add(CarParser.toFeatures(r));
        labels.add(CarParser.labelInt(r));
    }

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

    public int size() { return rows.size(); }

    @Override
    public String toString() {
        return "CarDataset{" +
                "rows=" + rows +
                ", features=" + features +
                ", labels=" + labels +
                '}';
    }
}