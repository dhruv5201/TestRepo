package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PropertyReader;
import utilities.ScreenShotTaker;
import utilities.Validator;

public class LoginPO {
	WebDriver driver;
	
	@FindBy (xpath="//input[@id='uid']")
	public WebElement userIDinput;
	
	@FindBy (xpath="//input[@id='passw']")
	public WebElement passwordInput;
	
	@FindBy (xpath="//input[@name='btnSubmit']")
	public WebElement submitButton;
	
	@FindBy (xpath="//a[@id='LoginLink']")
	public static WebElement loginText;
	
	
	public LoginPO(WebDriver driver1){
		this.driver=driver1;		
		PageFactory.initElements(driver, this);
	}
	
	public void validLoginTest() {
		//System.out.println(Validator.ValidateText(loginText.getText(), "Sign Off"));
		userIDinput.sendKeys(PropertyReader.getProperty("userid"));
		passwordInput.sendKeys(PropertyReader.getProperty("password"));
		submitButton.click();
		boolean isMatched=Validator.ValidateText(loginText.getText(), "Sign Off");
		if (isMatched) {
			System.out.println("Valid Login Case PASS. "+ Validator.TextValivationMessage);
			ScreenShotTaker.takeScreenShot(driver);
		}
		else {
			System.out.println("Valid Login Case FAIL. " + Validator.TextValivationMessage);
		}
		
	}

}
