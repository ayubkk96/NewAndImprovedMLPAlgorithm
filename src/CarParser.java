import java.util.*;

final class CarParser {

    static CarRecord parse(String line) {
        String[] parts = line.split(",");
        return new CarRecord(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }



}