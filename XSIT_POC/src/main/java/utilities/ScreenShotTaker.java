package utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotTaker {
	
	static WebDriver driver;
	public static void takeScreenShot(WebDriver webDriver) {
		driver=webDriver;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		String time=sdf.format(timestamp);
		String pageTitle=driver.getTitle().toString();
		String screenCaptureLoaction=PropertyReader.getProperty("ScreenCapturePath");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  // Code to copy the screenshot in the desired location
		  
		  try {
			FileUtils.copyFile(scrFile, new File(screenCaptureLoaction + pageTitle + time + ".jpg"));
			System.out.println("SCREEN SHOT SAVED - SUCCESS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SCREEN SHOT SAVED - FAILED");
		}
		
	}

}
