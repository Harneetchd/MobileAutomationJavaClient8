package com.andr.tests;

import java.io.File;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.andr.pages.DemoAppPage;
import com.android.base.Andr_BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class DemoAppTest extends Andr_BaseTest
{
	static AppiumDriver driver;
	DemoAppPage page;
	AppiumDriverLocalService server;
	
	@BeforeSuite
	public void startAppiumServer() 
	{
//		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
//		serviceBuilder.withIPAddress("127.0.0.1");
//		serviceBuilder.usingPort(4723);
//		serviceBuilder.usingDriverExecutable(new File("/opt/homebrew/bin/node"));
//		serviceBuilder.withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"));
//		///Applications/Appium Server/GUI.app/Contents/Resources/app/node_modules/appium/build/lib/main.js
//		///Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js
//		///opt/homebrew/lib/node_modules/appium/build/lib/main.js
//	    server = AppiumDriverLocalService.buildService(serviceBuilder);
//		server.start();
	}
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
 
		driver= launchAndroidApp();
		page= new DemoAppPage(driver);
	}
	
	@Test
	public void clickOnWebView() throws InterruptedException
	{
		page.clickIcon();
		page.clickWebView();
		page.enterUrlWebView();
		page.clickGotoSiteWebView();
	    Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();   
		
	}
	
	@Test
	public void clickLogin()
	{
		page.clickIcon();
		page.clickLogin();
		page.enterIntoUsername();
		page.enterIntoPassword();
		page.loginIntoAccount();
		
	}
	
	@Test
	public void clickOnQRCodeNoPermission()
	{
		page.clickIcon();
		page.clickQRCode();
		page.clickDontAllow();
		driver.navigate().back();
	}
	
	@Test
	public void clickQRCodePermitOnce() throws InterruptedException
	{
		Thread.sleep(10000);
		page.clickIcon();
		page.clickQRCode();
		page.clickAllowOnce();
		driver.navigate().back();
	}
	
	@Test
	public void clickGeoAllowOnce()
	{
		page.clickIcon();
		page.clickGeoLocation();
		page.clickGeoAllowOnce();
		driver.navigate().back();
	}
	
	@Test
	public void clickOnDrawing()
	{
		page.clickIcon();
		page.clickDrawing();
		driver.navigate().back();
	}
	
	@AfterSuite
	public void tearDownServer()
	{
//		server.close();
	}
}
