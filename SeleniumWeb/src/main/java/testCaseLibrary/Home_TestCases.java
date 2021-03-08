package testCaseLibrary;

import baseClass.TestBase;
import utilities.ScreenShotTaker;


public class Home_TestCases extends TestBase {
	public static boolean SelectAccount() {
		boolean IsPass = false;
		if (HomePageRepo.IfHomePageLoaded()) {
			String AccountToBeSelected = TestData.getJsonData("accounts.account2");
			if (HomePageRepo.SelectAccount(AccountToBeSelected)) {
				HomePageRepo.Click_Go();
				// IsPass = Validator.ValidateText(AccountSummaryRepo.GetHeaderText(),
				// AccountToBeSelected);
				if (AccountSummaryRepo.GetHeaderText().contains(AccountToBeSelected)) {
					IsPass = true;
					Logger.info("Select Account PASS.");
				} else {
					Logger.info("Select Account FAIL.");
					ScreenShotTaker.takeScreenShot(driver);
				}
			}
		}
		return IsPass;

	}
}
