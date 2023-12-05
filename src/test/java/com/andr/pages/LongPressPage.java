package com.andr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.android.base.Andr_BasePage;

import io.appium.java_client.AppiumDriver;

public class LongPressPage extends Andr_BasePage{

	public LongPressPage(AppiumDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
	 WebElement eleViews;
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
	WebElement eleExpandableLists;
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")
	WebElement eleCustomAdapter;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Dog Names\"]")
	WebElement eleDogNames;
	
	public void clickOnViews()
	{
		eleViews.click();
	}
	
	public void clickOnExpandable()
	{
		eleExpandableLists.click();
	}
	
	public void clickCustomAdapter()
	{
		eleCustomAdapter.click();
	}
	
	public void clickDogNames()
	{
		longPress(eleDogNames, driver);
	}

}
