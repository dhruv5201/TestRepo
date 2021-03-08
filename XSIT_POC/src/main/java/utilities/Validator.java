package utilities;

import org.openqa.selenium.WebDriver;

public class Validator {
	WebDriver driver;
	public static String TextValivationMessage;
	Validator(WebDriver driver1){
		this.driver=driver1;
	}
	
	public static boolean  ValidateText(String actual, String expected){
		
		boolean isMatched=false;
		
		if (actual != null && expected != null) {
			if (actual.equalsIgnoreCase(expected)){
				TextValivationMessage="Matched , Actual = " + actual +" & Expected= "+ expected;
				isMatched=true;
			}
			else {
				TextValivationMessage="Did NOT Matched , Actual = " + actual +" & Expected= "+ expected;
				isMatched=false;
			}
		}
		else {
			TextValivationMessage ="Validation failed. GOT NULL VALUES..!";
		}
		
		return isMatched;
		
	}
	

	
}
