package headlessTest;
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
	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium HeadLess Testing..");
	  driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
	  
	  driver.quit();
  }
}
