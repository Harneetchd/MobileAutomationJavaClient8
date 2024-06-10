package com.iphone.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iPhone.base.IPhone_BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;



public class MobilePage extends IPhone_BasePage
{
	public MobilePage(AppiumDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="Activity Indicators")
	WebElement clickactivityIndicators;
	
	@FindBy(id="Buttons")
	WebElement clickbutton;
	
	@FindBy(id="Image View")
	WebElement imageclick;
	
	public void clickOnActivityIndicators()
	{
		 clickactivityIndicators.click();
		 driver.navigate().back();
	}
	
	public void clickOnButton() throws InterruptedException 
	{
		clickbutton.click();
		driver.navigate().back();
	}
	public void clickOnImageView() throws InterruptedException
	{
		imageclick.click();
		Thread.sleep(6000);
		driver.navigate().back();
	}
	
	
}
