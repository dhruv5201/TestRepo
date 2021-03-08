package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.TestBase;
import utilities.WebElementFactory;

public class LoginPO extends TestBase{
	
	
	@FindBy (xpath="//input[@id='uid']")
	public WebElement userIDinput;
	
	@FindBy (xpath="//input[@id='passw']")
	public WebElement passwordInput;
	
	@FindBy (xpath="//input[@name='btnSubmit']")
	public WebElement submitButton;
	
	@FindBy (xpath="//a[@id='LoginLink']")
	public WebElement loginText;
			
	@FindBy (xpath="//h1[contains(text(),'Online Banking Login')]")
	public WebElement HeaderText;
	//Online Banking Login
	public LoginPO(){
			
		PageFactory.initElements(driver, this);
	}
	
	
	
	//***************************** UTILITY ACTIONS******************************************
	public boolean IsLoginPageLoaded() {
		boolean IsPass = false;
		if (WebElementFactory.IfElementExist(driver, HeaderText)) {
			IsPass = true;
		}
		return IsPass;
	}
	
	//***************************************************************************************
	

}
