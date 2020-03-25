package angularPOC;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.xsit.base.TestBase;
import com.xsit.testdata.JsonDataReader;
import com.xsit.testdata.TestData;

import utilities.DriverFactory;
import utilities.PropertyReader;

public class NavTest extends TestBase{
	//WebDriver driver;
	//NgWebDriver NGDriver;
	
	@Test(enabled = false, priority = 1)
	public void allTabNav() {
		// driver.get("http://localhost:4200/");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ByAngular.buttonText("Pricing")).click();
		driver.findElement(ByAngular.buttonText("Lifts & Deliveries")).click();
		driver.findElement(ByAngular.buttonText("Rundowns")).click();
		driver.findElement(ByAngular.buttonText("Qualities")).click();
		driver.findElement(ByAngular.buttonText("Inventory")).click();
		
		

	}

	@Test(enabled = false, priority = 2)
	public void InventoryTest() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Inventory")).click();
		// SELECTING A FILTER ****************************************
		Select GroupByList = new Select(driver.findElement(By.xpath("//select[@name='no groups']")));
		GroupByList.selectByVisibleText("VTank");

		// ************************************************************
		// SEARCHING A STRING "SUP" **********************************
		driver.findElement(By.xpath("//input[@placeholder='Search' and @type='text' and @name='textbox1']"))
				.sendKeys("SUP");

		// *************************************************************

		// CAPTURING FIRST CELL VALUE OF PHYSICAL TANK COLUMN *********
		String compid = driver.findElement(By.xpath(
				"//div[@col-id='tank' and @class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value ag-cell-range-left']"))
				.getAttribute("comp-id");
		System.out.println("Comp-ID: " + compid);
		String cellValu1 = driver.findElement(By.xpath("//div[@comp-id=" + compid
				+ " and @col-id='tank' and @class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-value ag-cell-range-left']"))
				.getText();
		System.out.println("Cell Value1 is #####: " + cellValu1);
		// **************************************************************

		// WORKING WITH AG-GRID column Data ****************************
		// GETTING ROW COUNT FROM FIRST TABLE Vpls
		// WebElement
		// TableVpls=driver.findElement(By.xpath("//h3[contains(text(),'Vpls')]/parent::div"));
		WebElement TableVpls = driver.findElement(By.xpath("(//*[ag-grid-angular])[1]"));
		String rowCountStrVpls = TableVpls
				.findElement(By.xpath(
						"(//div[@class='ag-root ag-unselectable ag-layout-auto-height' and @ref='gridPanel'])[1]"))
				.getAttribute("aria-rowcount");
		System.out.println("Row Count of TableVpls is : " + rowCountStrVpls);
		int rowCountNoVpls = Integer.parseInt(rowCountStrVpls);

		// GETTING ROW COUNT FROM 2ND TABLE Vpss
		// WebElement
		// TableVpls=driver.findElement(By.xpath("//h3[contains(text(),'Vpls')]/parent::div"));
		WebElement TableVpss = driver.findElement(By.xpath("(//*[ag-grid-angular])[2]"));
		String rowCountStrVpss = TableVpss
				.findElement(By.xpath(
						"(//div[@class='ag-root ag-unselectable ag-layout-auto-height' and @ref='gridPanel'])[2]"))
				.getAttribute("aria-rowcount");
		System.out.println("Row Count of TableVpss is : " + rowCountStrVpss);
		int rowCountNoVpss = Integer.parseInt(rowCountStrVpss);

		// GETTING ALL TANK COLUMN VALUES OF FIRST TABLE
		// String ColumnID="tank";
		// List < WebElement > TankRowElements=
		// TableVpls.findElements(By.xpath("//div[@col-id='tank' and @class='ag-cell
		// ag-cell-not-inline-editing ag-cell-with-height ag-cell-value
		// ag-cell-range-left']"));
		// System.out.println(TankRowElements.size());
		List<String> TankValues = new ArrayList<String>();
		for (int i = 2; i <= rowCountNoVpls; i++) {
			String Tankvalue = (driver.findElement(By.xpath("(//div[@col-id='tank'])[" + i + "]")).getText());
			TankValues.add(Tankvalue);
		}

		System.out.println(TankValues);
		// *****************************************************************************
		/*
		 * List <String> TankValues = new ArrayList<String>();
		 * 
		 * for (WebElement i : TankRowElements) { String CellValue= i.getText();
		 * TankValues.add(CellValue);
		 * 
		 * //System.out.println("Cell Values: " + CellValue ); }
		 * System.out.println("Tank Values are: " + TankValues );
		 */

		// Working with AG-ICON MENU *********************************
		driver.findElement(ByAngular.buttonText("Qualities")).click();
		driver.findElement(ByAngular.buttonText("Inventory")).click();
		driver.findElement(By.xpath("(//span[@class='ag-icon ag-icon-menu'])[2]")).click();
		driver.findElement(By.xpath(
				"//div[@class='ag-primary-cols-header-panel']//div//span[@class='ag-icon ag-icon-checkbox-checked']"))
				.click();
		driver.findElement(By.xpath("//input[@placeholder='Filter...']")).sendKeys("TYPE");
		// driver.findElement(By.xpath("//div[@class='ag-column-tool-panel-column
		// ag-toolpanel-indent-0']//div[@class='ag-column-select-checkbox ag-labeled
		// ag-label-align-right ag-checkbox']//div[@class='ag-wrapper
		// ag-input-wrapper']//div//span[@class='ag-icon
		// ag-icon-checkbox-unchecked']")).click();
		driver.findElement(By.xpath("(//div//span[@class='ag-icon ag-icon-checkbox-unchecked'])[3]")).click();
		driver.findElement(By.xpath("//p[@class='showingSum']")).click();

		// Getting RowCounts
		WebElement Table = driver.findElement(By.xpath("(//*[ag-grid-angular])[1]"));
		String rowCountTable = Table
				.findElement(By.xpath(
						"(//div[@class='ag-root ag-unselectable ag-layout-auto-height' and @ref='gridPanel'])[1]"))
				.getAttribute("aria-rowcount");
		System.out.println("Row Count of Table is : " + rowCountTable);
		int rowCountNoTable = Integer.parseInt(rowCountTable);

		// Getting row Values

		List<String> rowValues = new ArrayList<String>();
		for (int i = 2; i <= rowCountNoTable; i++) {
			String Cellvalue = (driver.findElement(By.xpath("(//div[@col-id='productsComponents'])[" + i + "]"))
					.getText());
			rowValues.add(Cellvalue);
		}

		System.out.println("TYPE column values: " + rowValues);

		// *****************************************************************

	}

	@Test(enabled = false, priority = 3)
	public void QualitiesTest() {
		driver.findElement(ByAngular.buttonText("Qualities")).click();
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// EXPAND FCCB COLUMN
		WebElement colHeaderFCCB = driver.findElement(By.xpath("//span[contains(text(),'FCCB')]"));
		action.doubleClick(colHeaderFCCB).perform();

		// EXPAND COMP8 COLUMN
		WebElement colHeaderCOMP8 = driver.findElement(By.xpath("//span[contains(text(),'COMP8')]"));
		action.doubleClick(colHeaderCOMP8).perform();

		// EXPAND PENT COLUMN
		WebElement colHeaderPENT = driver.findElement(By.xpath("//span[contains(text(),'PENT')]"));
		action.doubleClick(colHeaderPENT).perform();

		// GET CELL DATA
		String cell1Data = driver.findElement(By.xpath("//div[@aria-rowindex='4']//div[@col-id='title']")).getText();
		System.out.println("CELL DATA: " + cell1Data);

		// GET TITLE COLUMN ALL DATA

		// Getting RowCounts
		WebElement Table = driver.findElement(By.xpath("(//*[ag-grid-angular])[1]"));
		
		// String rowCountTable=Table.findElement(By.xpath("(//div[@class='ag-root
		// ag-unselectable ag-layout-auto-height' and
		// @ref='gridPanel'])[1]")).getAttribute("aria-rowcount");
		String rowCountTable = Table.findElement(By.xpath(
				"(//div[contains(@class,'ag-root ag-unselectable ag-layout') and contains(@ref,'gridPanel')][1])"))
				.getAttribute("aria-rowcount");
		// div[contains(@class,'ag-root ag-unselectable ag-layout' ) and
		// contains(@ref,'gridPanel')]
		// mat-icon[contains(@class,'mat-icon notranslate material-icons')]
		System.out.println("Row Count of Table is : " + rowCountTable);
		int rowCountNoTable = Integer.parseInt(rowCountTable);

		// Getting row Values

		List<String> rowValues = new ArrayList<String>();
		for (int i = 2; i < rowCountNoTable; i++) {
			String Cellvalue = (driver.findElement(By.xpath("(//div[@col-id='title'])[" + i + "]")).getText());
			rowValues.add(Cellvalue);
		}

		System.out.println("QUALITIES values :" + rowValues);

		// TOOL TIPS
		// WebElement hoover=driver.findElement(By.xpath(""));
		// driver.findElement(By.xpath("//div[@class='footerComponent']//app-tooltip-component")).getText();

	}

	@BeforeTest
	public void LoadDriver() {
		System.out.println("Inside - BeforeTest");
		/*
		driver=DriverFactory.getChromeDriver();
		driver = DriverFactory.GetEdgeDriver();
		NgWebDriver NGDriver = new NgWebDriver((JavascriptExecutor) driver);
		NGDriver.waitForAngularRequestsToFinish();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/
		initializeTestBase();
		
		
	}
	@AfterTest
	public void CloseBrowser() {
		System.out.println("Inside AfterTest.");
		driver.close();
		
	}
	@Test (enabled = true, priority = 3)
	public void TestdataTest() throws JsonParseException, JsonMappingException, IOException {
		JsonDataReader td=new JsonDataReader();
		System.out.println("***" + data.getTestData().getAddress() );
		
		
		TestData data1 = td.getTestData();
		data1.getLastname();
		System.out.println(data1.getLastname());
		HashMap<String, String> map= (HashMap<String, String>) td.getJsonDataInMaps();
		System.out.println("PHONE NUMBERS: "+ map.get("phoneNumbers"));
		//ArrayList <String> i=map.get("phoneNumbers");
		
		
		
	}
}
