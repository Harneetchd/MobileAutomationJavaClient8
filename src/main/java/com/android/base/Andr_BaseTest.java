package com.android.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Andr_BaseTest 
{
	private static AppiumDriver driver;
	
	AppiumDriverLocalService server;
	AppiumServiceBuilder serviceBuilder ;
	
//	@BeforeClass
//	public void startAppiumServer() throws InterruptedException 
//	{
//		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
//		serviceBuilder.withIPAddress("127.0.0.1");
//		//serviceBuilder.usingPort(4723);
//		serviceBuilder.usingDriverExecutable(new File("/opt/homebrew/bin/node"));
//		serviceBuilder.withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
//		///Applications/Appium Server/GUI.app/Contents/Resources/app/node_modules/appium/build/lib/main.js
//		///Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js
//		///opt/homebrew/lib/node_modules/appium/build/lib/main.js
//	   // server = AppiumDriverLocalService.buildService(serviceBuilder);
//		//server.start();
//		.usingPort(4723)
//		.build().start();
//		Thread.sleep(5000);
//	}
	public AppiumDriver launchAndroidApp() throws MalformedURLException 
	{
	 
		UiAutomator2Options options  = new UiAutomator2Options();
		options.setCapability("platformName", "Android");
		options.setCapability("platformVersion", "14.0");
		options.setCapability("deviceName", "pixel_6_pro");
		options.setCapability("automationName", "UiAutomator2");
		options.setCapability("app", "/Users/harneetkaur/eclipse-workspace/MobileAutomationJavaClient8/app/Android-MyDemoAppRN.1.3.0.build-244.apk");
		//options.setCapability("app", "/Users/harneetkaur/eclipse-workspace/MobileAutomationJavaClient8/app/ApiDemos-debug.apk");
		
		
		//driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		
		return driver;
	}
	
	public AppiumDriver launchAndroidApp_SauceLabs(String buildID,String testName) throws MalformedURLException 
	{
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
		caps.setCapability("appium:deviceName", "Google Pixel 6 Pro GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "14.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "2.0.0");
		sauceOptions.setCapability("username", "oauth-chdniti-9ab73");
		sauceOptions.setCapability("accessKey", "9fb47724-25d5-4e8a-a0dd-578b30c9dc51");
		sauceOptions.setCapability("build", buildID);
		sauceOptions.setCapability("name", "testName");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, caps);
		
		return driver;
		
	}
	
	
	
//	@AfterClass
//	public void tearDownServer()
//	{
//		//serviceBuilder.build().stop();
//		server.close();
//	}
}
