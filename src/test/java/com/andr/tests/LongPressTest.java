package com.andr.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.andr.pages.DemoAppPage;
import com.andr.pages.LongPressPage;
import com.android.base.Andr_BaseTest;

import io.appium.java_client.AppiumDriver;

public class LongPressTest extends Andr_BaseTest
{
    static AppiumDriver driver;
	LongPressPage page;
	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver= launchAndroidApp();
		page= new LongPressPage(driver);
	}
	
	@Test
	public void testLongPress() throws InterruptedException
	{
		page.clickOnViews();
		page.clickOnExpandable();
		page.clickCustomAdapter();
		Thread.sleep(1000);
		page.clickDogNames();
	}
	
}
