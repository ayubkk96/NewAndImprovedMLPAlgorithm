import java.io.InputStream;

public class DataSetLoader {
    public static InputStream load(String fileName) {
        InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(fileName);
        if (in == null) {
            throw new IllegalStateException("dataset not found on classpath");
        }
        else {
            return in;
        }
    }
}
