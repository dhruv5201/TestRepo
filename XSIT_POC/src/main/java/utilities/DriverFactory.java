package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Dhrubajit Das Driver Factory class using Singleton Pattern, to make
 *         sure that only one instance of the driver is created
 */
public class DriverFactory {

	private static WebDriver driver;

	// Mandatory Private Constructor to resist Objects getting created
	private DriverFactory() {
	}

	/**
	 * Creating the driver object for browser provided in property file
	 */
	private static void FirefoxDriver() {
		// prop = new PropertyUtils();

		if (driver == null) {

			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();

		}
	}

	private static void ChromeDriver() {
		// prop = new PropertyUtils();

		if (driver == null) {

			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();

		}
	}
	
	
	private static void ChromeDriverDebug() {
		// prop = new PropertyUtils();

		if (driver == null) {

			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "localhost:8074");
			driver = new ChromeDriver(options);

		}
	}
	
	
	private static void EdgeDriver() {
		// prop = new PropertyUtils();

		if (driver == null) {

			System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
			driver = new EdgeDriver();
			

		}
	}

	private static void UnitDriver() {
		// prop = new PropertyUtils();

		if (driver == null) {

			driver = new HtmlUnitDriver();

		}
	}

	/**
	 * Returning the driver instance. If not created then it is going to call
	 * newDriver function
	 */
	public static WebDriver getFirefoxDriver() {

		if (driver == null) {
			FirefoxDriver();
		}
		return driver;
	}

	public static WebDriver getChromeDriver() {

		if (driver == null) {
			ChromeDriver();
		}
		return driver;
	}
	public static WebDriver getChromeDriverDebug() {

		if (driver == null) {
			ChromeDriverDebug();
		}
		return driver;
	}
	public static WebDriver GetHtmlUnitDriver() {

		if (driver == null) {
			UnitDriver();
		}
		return driver;
	}
	
	public static WebDriver GetEdgeDriver() {

		if (driver == null) {
			EdgeDriver();
		}
		return driver;
	}

}
