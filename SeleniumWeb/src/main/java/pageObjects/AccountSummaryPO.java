package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AccountSummaryPO {
	WebDriver driver;
	
	@FindBy (xpath="//select[@id='listAccounts']")
	public WebElement accountList;
	
	@FindBy (xpath="//input[@id='btnGetAccount']")
	public WebElement goButton;
	
		
	
	public AccountSummaryPO(WebDriver driver1){
		this.driver=driver1;		
		PageFactory.initElements(driver, this);
	}
	
	public void selectAccount(String accountNumber) {
		Select sl=new Select (accountList);
		sl.selectByValue(accountNumber);
		goButton.click();
		
		
	}

}
