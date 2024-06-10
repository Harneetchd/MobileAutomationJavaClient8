package com.iPhone.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IPhone_BaseTest 
{
	private static AppiumDriver driver;
	
	public AppiumDriver launchIPhoneApp() throws MalformedURLException
	{
		XCUITestOptions options = new XCUITestOptions();
		options.setCapability("platformName", "iOS");
		options.setCapability("appium:platformVersion", "17.2");
		options.setCapability("appium:deviceName", "iPhone 15 Pro");
		options.setCapability("appium:automationName", "XCUITest");
		options.setCapability("appium:bundleID", "com.harneet.apple-samplecode.UICatalog");
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		return driver;
		
		
	}
}
