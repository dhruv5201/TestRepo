package headlessTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.PropertyReader;

public class Headless {
	WebDriver driver= DriverFactory.GetHtmlUnitDriver();
	//WebDriver driver= DriverFactory.getFirefoxDriver();
  @Test
  public void Launch() {
	  
	  driver.get(PropertyReader.getProperty("url"));
	  System.out.println(driver.getTitle().toString());
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium HeadLess Testing..");
	  driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
	  driver.findElement(By.xpath("//div[contains(text(),'Selenium Headless Browser Testing: HTMLUnitDriver')]")).click();
	  //System.out.println("Search Result is: " + searchResult);
	  System.out.println(driver.getTitle().toString());
	  driver.quit();
  }
}
