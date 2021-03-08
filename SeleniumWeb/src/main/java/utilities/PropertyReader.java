package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	static File file = null;
    static Properties prop = null;
    static FileInputStream fileInput = null;

    public static String getProperty(String key) {
           file = new File("src/test/resources/property.properties");
           prop = new Properties();
           String keyvalue;
           try {
                  fileInput = new FileInputStream(file);
                  prop.load(fileInput);
           } catch (Exception e1) {
                  System.out.println("Exception = " + e1.toString());
           }
           keyvalue = prop.getProperty(key);
           return keyvalue;
    }


}
