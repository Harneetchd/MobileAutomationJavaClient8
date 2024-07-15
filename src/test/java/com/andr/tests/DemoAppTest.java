package com.andr.tests;

import java.io.File;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.andr.pages.DemoAppPage;
import com.android.base.Andr_BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class DemoAppTest extends Andr_BaseTest
{
	static AppiumDriver driver;
	DemoAppPage page;
	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver= launchAndroidApp();
		driver= launchAndroidApp_SauceLabs("appium-build-5JHQS","clickOnWebView");
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
	
	
}
