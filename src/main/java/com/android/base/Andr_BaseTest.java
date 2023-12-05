package com.android.base;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class Andr_BaseTest 
{
	private static AppiumDriver driver;
	
	public AppiumDriver launchAndroidApp() throws MalformedURLException 
	{
		UiAutomator2Options options  = new UiAutomator2Options();
		options.setCapability("platformName", "Android");
		options.setCapability("platformVersion", "14.0");
		options.setCapability("deviceName", "pixel_6_pro");
		options.setCapability("automationName", "UiAutomator2");
		options.setCapability("app", "/Users/harneetkaur/eclipse-workspace/MobileAutomationJavaClient8/app/Android-MyDemoAppRN.1.3.0.build-244.apk");
		//options.setCapability("app", "/Users/harneetkaur/eclipse-workspace/MobileAutomationJavaClient8/app/ApiDemos-debug.apk");
		
		
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723"),options);
		
		return driver;
	}
}
