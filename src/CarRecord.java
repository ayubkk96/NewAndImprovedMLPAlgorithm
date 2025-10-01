public final class CarRecord {
    public final String buying;    // vhigh, high, med, low
    public final String maint;     // vhigh, high, med, low
    public final String doors;     // 2, 3, 4, 5more
    public final String persons;   // 2, 4, more
    public final String lugBoot;   // small, med, big
    public final String safety;    // low, med, high
    public final String label;

    public CarRecord(String buying, String maint, String doors, String persons,
                     String lugBoot, String safety, String label) {
        this.buying = buying;
        this.maint = maint;
        this.doors = doors;
        this.persons = persons;
        this.lugBoot = lugBoot;
        this.safety = safety;
        this.label = label;
    }

    @Override public String toString() {
        return String.join(",", buying, maint, doors, persons, lugBoot, safety, label);
    }

}
