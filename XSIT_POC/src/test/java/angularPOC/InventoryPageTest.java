package angularPOC;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.xsit.base.TestBase;

public class InventoryPageTest extends TestBase {
		
	
  @Test (description ="To Test Seach feature of Inventory" , enabled = false , priority=1 )
  public void search() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  InventoryRepo.InvetoryTab.click();
	  InventoryRepo.searchPhysicalTank(data.getJsonData("inventory.physicaltank"));
	  InventoryRepo.searchMBOTank(data.getJsonData("inventory.mbotank"));
	  InventoryRepo.searchVirtualTank(data.getJsonData("inventory.virtualtank"));
	  InventoryRepo.searchMaterial(data.getJsonData("inventory.material"));
	  
	  
	  
	  
	  
  }
  
  @Test (description ="To Test Group By Functionality" , enabled = false , priority=2)
  public void GroupByTest() {
	  InventoryRepo.InvetoryTab.click();
	  InventoryRepo.GroupBy("Virtual");
	  InventoryRepo.GroupBy("Material");
	  InventoryRepo.GroupBy("Product");
	  InventoryRepo.GroupBy("Physical Tank");
	  InventoryRepo.GroupBy("Test");
	  
	  
  }
  @Test (description ="To Test Min Fill edit Operation" , enabled = true , priority=3 )
  public void MinFillEdit() {
	  InventoryRepo.editMinFill(4, "5");
	  
  }
  
  @BeforeTest
  public void LoadDriver() {
		System.out.println("Inside - BeforeTest");
		initializeTestBase();
		
		
	}
}
