package baseClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import configLibrary.ConfigLibrary;
import pageObjects.AccountSummaryPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import utilities.DriverFactory;
import utilities.JsonDataReader;
import utilities.ReportGenerator;


public class TestBase {
	public static WebDriver driver;
	public static LoginPO LoginRepo;
	public static HomePO HomePageRepo;
	public static AccountSummaryPO AccountSummaryRepo;
	public static JsonDataReader TestData;
	public static ExtentReports extentReport;
	public static ExtentTest Logger;
	
	public void InitiateTestBase() {
		InitiateWebDriver();
		InitiateObjectRepo();
		InitiateTestData();
		InitiateExtentReport();
		InitiateBrowser();
		LoadURL();
	}
	private void InitiateWebDriver() {
		if (ConfigLibrary.BrowserToTest.contains("firefox")) {
			driver = DriverFactory.getFirefoxDriver();
		}
		if (ConfigLibrary.BrowserToTest.contains("chrome")) {
			driver = DriverFactory.getChromeDriver();
		}
		
	}
	private void InitiateObjectRepo() {
		LoginRepo = new LoginPO();
		HomePageRepo = new HomePO();
		AccountSummaryRepo = new AccountSummaryPO();
	}
	private void InitiateBrowser() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	private void LoadURL() {
		driver.get(ConfigLibrary.Url);
	}
	private void InitiateTestData() {
		TestData = new JsonDataReader(ConfigLibrary.TestDataFile);
	}
	private void InitiateExtentReport() {
		ReportGenerator report = new ReportGenerator("Name", "Path");
		extentReport = report.GetExtentReport();
		Logger = report.GetReportLogger();
		
	}
}
