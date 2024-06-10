package com.iphone.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iPhone.base.IPhone_BaseTest;
import com.iphone.pages.MobilePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileTest extends IPhone_BaseTest
{
  static AppiumDriver driver;
  MobilePage page; 
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException
  {
	  driver= launchIPhoneApp();
	  page = new MobilePage(driver);
  }

  @Test
  public void clickAction() throws InterruptedException 
  {
	  page.clickOnActivityIndicators();
	  page.clickOnButton();
	  page.clickOnImageView();
	  page.clickOnButton();
	  page.clickOnImageView();
	  
  }
}
