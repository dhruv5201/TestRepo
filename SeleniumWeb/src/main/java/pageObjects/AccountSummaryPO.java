package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.TestBase;

public class AccountSummaryPO extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Account History')]")
	public WebElement HeaderText;

	@FindBy(xpath = "//input[@id='btnGetAccount']")
	public WebElement goButton;

	public AccountSummaryPO() {

		PageFactory.initElements(driver, this);
	}

	// ************************UTILITY FUNCTIONS********************************
	public String GetHeaderText() {
		return HeaderText.getText();
	}

}
