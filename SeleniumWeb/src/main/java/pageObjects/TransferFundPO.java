package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TransferFundPO {
	WebDriver driver;
	
	@FindBy (xpath="//select[@id='listAccounts']")
	public WebElement accountList;
	
	@FindBy (xpath="//input[@id='btnGetAccount']")
	public WebElement goButton;
	
		
	
	public TransferFundPO(WebDriver driver1){
		this.driver=driver1;		
		PageFactory.initElements(driver, this);
	}
	
	public void selectAccount(int accountNumber) {
		
		
		
	}

}
