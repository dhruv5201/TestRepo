package alteroAppTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseClass.TestBase;
import testCaseLibrary.Home_TestCases;
import testCaseLibrary.Login_TestCases;
import utilities.DBReader;
import utilities.ReportGenerator;

public class End2EndRegression extends TestBase{
	
  
  @BeforeTest
  public void initiateDriver() {
	  
	  InitiateTestBase();
  }
  
  @Test (priority = 1)
  public void LoginTest() {
	  Logger = extentReport.createTest("Login Case");
	  boolean IsPass = Login_TestCases.login();
	  Assert.assertTrue(IsPass);
	 // DBReader.MongoReader();
  	  
  }
  @Test (priority = 2)
  public void SelectAccountTest() {
	  Logger = extentReport.createTest("Select Account Case");
	  boolean IsPass = Home_TestCases.SelectAccount();
	  Assert.assertTrue(IsPass);
  }
  @AfterMethod
  public void GetResult(ITestResult results) {
	  ReportGenerator.LogResult(results, Logger);
	  
  }
  @AfterTest
  public void closeBrowser() {
	  extentReport.flush();
	  driver.quit();
  }
}
