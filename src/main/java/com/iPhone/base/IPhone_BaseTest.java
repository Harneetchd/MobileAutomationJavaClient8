package com.iPhone.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
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
	
	public AppiumDriver launchIPhoneApp_SauceLabs() throws MalformedURLException
	{
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("appium:app", "storage:filename=UIKitCatalog-iphonesimulator.zip");  // The filename of the mobile app
		caps.setCapability("appium:deviceName", "iPhone 11 Pro Max Simulator");
		caps.setCapability("appium:platformVersion", "17.0");
		caps.setCapability("appium:automationName", "XCUITest");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "2.1.3");
		sauceOptions.setCapability("username", "oauth-chdniti-9ab73");
		sauceOptions.setCapability("accessKey", "9fb47724-25d5-4e8a-a0dd-578b30c9dc51");
		sauceOptions.setCapability("build", "<your build id>");
		sauceOptions.setCapability("name", "<your test name>");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		IOSDriver driver = new IOSDriver(url, caps);
		return driver;
	}
	
//	public AppiumDriver launchIPhoneAppRealDevice_SauceLabs() throws MalformedURLException
//	{
//		MutableCapabilities caps = new MutableCapabilities();
//		caps.setCapability("platformName", "iOS");
//		caps.setCapability("appium:app", "storage:filename=SauceLabs-Demo-App-With-TestFairy.ipa");  // The filename of the mobile app
//		caps.setCapability("appium:deviceName", "iPhone 12");
//		caps.setCapability("appium:platformVersion", "17");
//		caps.setCapability("appium:automationName", "XCUITest");
//		MutableCapabilities sauceOptions = new MutableCapabilities();
//		sauceOptions.setCapability("appiumVersion", "latest");
//		sauceOptions.setCapability("username", "oauth-chdniti-9ab73");
//		sauceOptions.setCapability("accessKey", "9fb47724-25d5-4e8a-a0dd-578b30c9dc51");
//		sauceOptions.setCapability("build", "1");
//		sauceOptions.setCapability("name", "<your test name>");
//		caps.setCapability("sauce:options", sauceOptions);
//
//		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
//		IOSDriver driver = new IOSDriver(url, caps);
//		return driver;
//	}
	
	

}
