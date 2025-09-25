import java.util.Map;
import java.util.Set;

final class CarParser {
    // Allowed values for validation
    private static final Set<String> LEVEL4 = Set.of("low", "med", "high", "vhigh");
    private static final Set<String> DOORS = Set.of("2", "3", "4", "5more");
    private static final Set<String> PERSONS = Set.of("2", "4", "more");
    private static final Set<String> LUG = Set.of("small", "med", "big");
    private static final Set<String> SAFETY = Set.of("low", "med", "high");
    private static final Set<String> LABELS = Set.of("unacc", "acc", "good", "vgood");

    static CarRecord parse(String line) {
        String[] t = line.split(",");
        if (t.length != 7) {
            throw new IllegalArgumentException("Expected 7 columns, got " + t.length + ": " + line);
        }
        for (int i = 0; i < t.length; i++) t[i] = t[i].trim();

        String buying = t[0], maint = t[1], doors = t[2], persons = t[3],
                lug = t[4], safety = t[5], label = t[6];

        // Basic validation
        require(LEVEL4.contains(buying), "buying", buying);
        require(LEVEL4.contains(maint), "maint", maint);
        require(DOORS.contains(doors), "doors", doors);
        require(PERSONS.contains(persons), "persons", persons);
        require(LUG.contains(lug), "lug_boot", lug);
        require(SAFETY.contains(safety), "safety", safety);
        require(LABELS.contains(label), "label", label);

        return new CarRecord(buying, maint, doors, persons, lug, safety, label);
    }

    private static void require(boolean ok, String field, String value) {
        if (!ok) throw new IllegalArgumentException("Invalid " + field + ": " + value);
    }

    // Optional: numeric encoding helpers
    private static final Map<String,Integer> ORD4 = Map.of(
            "low",0,"med",1,"high",2,"vhigh",3
    );
    private static final Map<String,Integer> LUG2INT = Map.of(
            "small",0,"med",1,"big",2
    );
    private static final Map<String,Integer> LABEL2INT = Map.of(
            "unacc",0,"acc",1,"good",2,"vgood",3
    );

    static int buyingInt(CarRecord r){ return ORD4.get(r.buying); }
    static int maintInt(CarRecord r){ return ORD4.get(r.maint); }
    static int safetyInt(CarRecord r){ return ORD4.get(r.safety); }
    static int doorsInt(CarRecord r){ return r.doors.equals("5more") ? 5 : Integer.parseInt(r.doors); }
    static int personsInt(CarRecord r){ return r.persons.equals("more") ? 5 : Integer.parseInt(r.persons); }
    static int lugBootInt(CarRecord r){ return LUG2INT.get(r.lugBoot); }
    static int labelInt(CarRecord r){ return LABEL2INT.get(r.label); }


    static float[] toFeatures(CarRecord r) {
        return new float[]{
                buyingInt(r), maintInt(r), doorsInt(r), personsInt(r), lugBootInt(r), safetyInt(r)
        };
    }
}