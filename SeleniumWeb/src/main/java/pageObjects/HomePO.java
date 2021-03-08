package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import baseClass.TestBase;
import utilities.WebElementFactory;

public class HomePO extends TestBase {

	@FindBy(xpath = "//select[@id='listAccounts']")
	private WebElement accountList;

	@FindBy(xpath = "//input[@id='btnGetAccount']")
	private WebElement goButton;

	public HomePO() {
		PageFactory.initElements(driver, this);
	}

	public void Click_Go() {
		goButton.click();
		
	}
	// ****************************** UTILITY FUNCTIONS*******************************************
	public boolean IfHomePageLoaded() {
		boolean IsLoaded = false;
		if (WebElementFactory.IfElementExist(driver, accountList)) {
			IsLoaded = true;
		}
			
		return IsLoaded;
	}
	public boolean SelectAccount(String accountNumber) {
		boolean IsSelected = false;
		if (accountNumber != null && WebElementFactory.IfElementExist(driver, accountList)) {
			IsSelected = WebElementFactory.SelectValueFromWebList(accountList, accountNumber);
		}
		
		return IsSelected;
	}
	//*********************************************************************************************
}
