package com.xsit.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.xsit.testdata.JsonDataReader;
import com.xsit.testdata.TestData;

import utilities.DriverFactory;
import utilities.PropertyReader;

public class TestBase {
	
	public static WebDriver driver;
	public static NgWebDriver ngWebDriver;
	public static JsonDataReader data;
	
	public void initializeTestBase() {
		intilizeDriver();
		initilizeBrowser();
		loadURL();
		initializeTestData();
		
	}
	
	private void intilizeDriver() {
		String browser=PropertyReader.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver=DriverFactory.getChromeDriver();
		}else 
			if (browser.equalsIgnoreCase("edge")) {
			driver=DriverFactory.getChromeDriver();
		}
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngWebDriver.waitForAngularRequestsToFinish();
		
	}
	
	private void initilizeBrowser() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	private void loadURL() {
		
		driver.get(PropertyReader.getProperty("url"));
	}
	
	private void initializeTestData() {
		data =new JsonDataReader();
		
	}

		
}
