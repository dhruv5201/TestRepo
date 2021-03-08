package configLibrary;

import utilities.PropertyReader;

public class ConfigLibrary {
public static String Url = PropertyReader.getProperty("url");
public static String BrowserToTest=PropertyReader.getProperty("browser");
public static String ScreenCapturePath=PropertyReader.getProperty("ScreenCapturePath");
public static String TestDataFile = PropertyReader.getProperty("datafilepath");

public static void Messages() {
	String TestPass="Test is PASS.";
	String TestFail="Test is FAIL.";
}

}
