package asana.e2e.core.baseTech.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

    static Properties properties = new Properties();

    public static String readValueFromFile(String value, String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            properties.load(fileInputStream);
            if (!properties.containsKey(value)) {
                throw new RuntimeException(
                        value + " property not found in " + fileName
                                + " file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + fileName + " file", e);
        }
        return properties.getProperty(value);
    }
}
