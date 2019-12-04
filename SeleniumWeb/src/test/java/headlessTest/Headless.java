package headlessTest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.sikuli.script.App;
//import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.DriverFactory;
import utilities.PropertyReader;
import utilities.ScreenShotTaker;
import utilities.Validator;

public class Headless {
	//WebDriver driver= DriverFactory.GetHtmlUnitDriver();
	WebDriver driver= DriverFactory.getFirefoxDriver();
	
  @Test
  public void Launch() {
	  
	  //driver.get(PropertyReader.getProperty("url"));
	 // System.out.println(driver.getTitle().toString());
	  
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium HeadLess Testing..");
	  
	  //driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
	  //driver.findElement(By.xpath("//h3[contains(text(),'Selenium Headless Browser Testing: HTMLUnitDriver')] ")).click();
	  //System.out.println("Search Result is: " + searchResult);
	  //System.out.println(driver.getTitle().toString());
	  /*
	  driver.quit();
	  driver.findElement(By.xpath("")).getAttribute("Sype");
	  Alert alert=driver.switchTo().alert();
	  Assert.assertEquals("Test", "expected");
	  SoftAssert sf=new SoftAssert();
	  sf.assertEquals("aa", "sdf");
	  Actions action=new Actions(driver);
	  action.dragAndDrop(driver.findElement(By.xpath("")),driver.findElement(By.xpath(""))).perform();;
	  */
	  //ScreenShotTaker.takeScreenShot(driver);
	  System.out.println(Validator.ValidateText("abcd", null));
	  
	  driver.quit();

	  
	  
	  
	  
	  
	  
	  
  }
}
