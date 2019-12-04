package alteroAppTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPO;
import utilities.DriverFactory;
import utilities.PropertyReader;

public class End2EndRegression {
	
  WebDriver driver;
  LoginPO LoginPage;
  
  
  @BeforeTest
  public void initiateDriver() {
	  driver=DriverFactory.getFirefoxDriver();
	  LoginPage = new LoginPO(driver);
	  driver.get(PropertyReader.getProperty("url"));
  }
  
  @Test
  public void LoginTest() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  LoginPage.validLoginTest();
	  
	  
	  
	  
	  
  }
  
  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }
}
