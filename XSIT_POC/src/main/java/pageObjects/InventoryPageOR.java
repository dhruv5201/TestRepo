package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PropertyReader;
import utilities.ScreenShotTaker;
import utilities.Validator;

public class InventoryPageOR {
	WebDriver driver;
	
	@FindBy (xpath="//button[contains(text(),'Inventory')]")
	public WebElement InvetoryTab;
		
	@FindBy (xpath="//input[@placeholder='Search']")
	public WebElement searchBox;
	
	@FindBy (xpath="//div[@aria-rowindex='2']//div[@col-id='physicaltank']")
	public WebElement FirstCell_PhysicalTank;
	
	@FindBy (xpath="//div[@aria-rowindex='2']//div[@col-id='mbotank']")
	public WebElement FirstCell_MBOTank;
	
	@FindBy (xpath="//div[@aria-rowindex='2']//div[@col-id='virtualtank']")
	public WebElement FirstCell_VirtualTank;
	
	@FindBy (xpath="//div[@aria-rowindex='2']//div[@col-id='material']")
	public WebElement FirstCell_Material;
	
	@FindBy (xpath="(//select[contains(@class,'selectpicker ')])[1]")
	public WebElement GroupByDropDown;
	
	
	
	
	public InventoryPageOR(WebDriver driver1){
		this.driver=driver1;		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will search Physical Tank and Validate.        
	 */
	public void searchPhysicalTank(String string) {
		
		searchBox.sendKeys(string);
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isMatched=Validator.ValidateText(FirstCell_PhysicalTank.getText(), string);
		if (isMatched) {
			System.out.println("Search PhysicalTank Case PASS. "+ Validator.TextValivationMessage);
			ScreenShotTaker.takeScreenShot(driver);
			
		}
		else {
			System.out.println("Search PhysicalTank Case FAIL. " + Validator.TextValivationMessage);
		}
		searchBox.clear();
		
		
	}
	
	/**
	 * This method will search MBO Tank and Validate.        
	 */
	public void searchMBOTank(String string) {
		
		searchBox.sendKeys(string);
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isMatched=Validator.ValidateText(FirstCell_MBOTank.getText(), string);
		if (isMatched) {
			System.out.println("Search MBO Tank Case PASS. "+ Validator.TextValivationMessage);
			ScreenShotTaker.takeScreenShot(driver);
		}
		else {
			System.out.println("Search MBO Tank Case FAIL. " + Validator.TextValivationMessage);
		}
		searchBox.clear();
		
		
	}
	
	/**
	 * This method will search Virtual Tank and Validate.        
	 */
	public void searchVirtualTank(String string) {
		
		searchBox.sendKeys(string);
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isMatched=Validator.ValidateText(FirstCell_VirtualTank.getText(), string);
		if (isMatched) {
			System.out.println("Search Virtual Tank Case PASS. "+ Validator.TextValivationMessage);
			ScreenShotTaker.takeScreenShot(driver);
		}
		else {
			System.out.println("Search Virtual Tank Case FAIL. " + Validator.TextValivationMessage);
		}
		searchBox.clear();
		
		
	}

	/**
	 * This method will search Material and Validate.        
	 */
	
	public void searchMaterial(String string) {
		
		searchBox.sendKeys(string);
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isMatched=Validator.ValidateText(FirstCell_Material.getText(), string);
		if (isMatched) {
			System.out.println("Search Material Case PASS. "+ Validator.TextValivationMessage);
			ScreenShotTaker.takeScreenShot(driver);
		}
		else {
			System.out.println("Search Material Case FAIL. " + Validator.TextValivationMessage);
		}
		searchBox.clear();
		
		
	

	}
	
	
	public void GroupBy(String value) {
		
		Select select = new Select(GroupByDropDown);
		
		if (value.contains("Material")){
			select.selectByVisibleText("Material");
		}
		else if (value.contains("Product")) {
			select.selectByVisibleText("Products & Components");
			
		}
		else if (value.contains("Virtual")) {
			select.selectByVisibleText("Virtual Tanks");
			
		}
		else if (value.contains("Physical")) {
			select.selectByVisibleText("Physical Tank");
			
		}
		
		else {
			System.out.println("Entered value is not exist in the Group By List");
		}
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void editMinFill(int rowNumber, String value) {
		int rownum=rowNumber;
		String xpath="//div[@aria-rowindex='"+rowNumber+"']//div[@col-id='minfill']";
		WebElement minfillCell= driver.findElement(By.xpath(xpath));
		String beforeEditText=minfillCell.getText();
			
		minfillCell.sendKeys(value);
		minfillCell.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String afterEditText=minfillCell.getText();
		
		if (!beforeEditText.equalsIgnoreCase(afterEditText)) {
			
			System.out.println("Cell Edit Success..!");
			System.out.println("BeforeEditCell Value is :" +beforeEditText + "& After Edir Cell value is: " + afterEditText);
		}
		else {
			System.out.println("Cell Edit Fail..!!");
			System.out.println("BeforeEditCell Value is :" +beforeEditText + "& After Edir Cell value is: " + afterEditText );
		}
		
		
		
		
	}
	
}
