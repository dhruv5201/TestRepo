package testCaseLibrary;

import baseClass.TestBase;
import utilities.ScreenShotTaker;
import utilities.Validator;

public class Login_TestCases extends TestBase {
	public static boolean login() {
		boolean IsPass = false;
		if (LoginRepo.IsLoginPageLoaded()) {
			LoginRepo.userIDinput.sendKeys(TestData.getJsonData("login.userid"));
			LoginRepo.passwordInput.sendKeys(TestData.getJsonData("login.password"));
			LoginRepo.submitButton.click();
			boolean isMatched = Validator.ValidateText(LoginRepo.loginText.getText(), "Sign Off");
			if (isMatched) {
				IsPass = true;
				Logger.info("Login Case PASS. "  + Validator.TextValivationMessage);
				
			} else {
				System.out.println("Login Case FAIL. " + Validator.TextValivationMessage);
				ScreenShotTaker.takeScreenShot(driver);
			}
		}

		return IsPass;

	}

}
