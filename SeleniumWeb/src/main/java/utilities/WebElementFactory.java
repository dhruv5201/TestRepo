package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class WebElementFactory{
	public static WebDriver driver;

	public static WebElement GetElementByXpath(WebDriver webdriver, String xpath) {
		WebElement element = null;
		driver = webdriver;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (WebDriverException e) {
			System.out.println("Element can not found" + e.getMessage().toString());
			return element;
		}

		return element;
	}

	public static boolean IfElementExist(WebDriver Driver , WebElement element) {
		boolean IsExist = false;
		driver = Driver;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			IsExist = true;
			

		} catch (WebDriverException e) {
			return IsExist;
		}

		return IsExist;
	}
	public static boolean SelectValueFromWebList( WebElement Element, String Value) {
		boolean IsSelected = false;
		if (Element != null && Value !=null) {
			Select ls = new Select (Element);
			List <WebElement> ElementList = ls.getOptions();
			for (WebElement element : ElementList) {
				if (element.getText().equalsIgnoreCase(Value)) {
					ls.selectByValue(Value);
					IsSelected = true;
				}
				else if (element.getText().contains(Value)){
					ls.selectByValue(Value);
					IsSelected = true;
				}
			}
		}
		
		return IsSelected;
	}
}
