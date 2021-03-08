package com.aapium.setUp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppLaunch {
	AndroidDriver<MobileElement> driver;
  @Test
  public void AppLaunchTest() throws MalformedURLException, InterruptedException {
	  System.out.println("First Andoroid App..");
	  String myApp="C:\\Users\\dhrdas\\Downloads\\WWFWords.apk";
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi A1");
	  capabilities.setCapability(MobileCapabilityType.APP, myApp);
	  //capabilities.setCapability("appPackage", "io.appium.android.apis");
	  //capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	  capabilities.setCapability("appPackage", "com.wwftool");
	  capabilities.setCapability("appActivity", "com.wwftool.MainActivity");
	  
	  driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  Thread.sleep(10000);
	  driver.quit();
	  
	  
  }
}
