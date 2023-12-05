package com.andr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.android.base.Andr_BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DemoAppPage extends Andr_BasePage{

	public DemoAppPage(AppiumDriver driver) 
	{
		super(driver);	
	}
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")
	WebElement eleBurgerIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Log In\"]")
	WebElement eleLogin;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"Username input field\"]")
	WebElement eleUsername;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"Password input field\"]")
	WebElement elePassword;
	
	@FindBy(xpath="(//android.widget.TextView[@text=\"Login\"])[2]")
	WebElement eleLoginAccount;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Webview\"]")
	WebElement elewebView;
	
	@AndroidFindBy(accessibility="URL input field")
	WebElement eleUrl;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Go To Site\"]")
	WebElement eleGotoSite;
	
	@FindBy(xpath="(//android.widget.TextView[@text=\"QR Code Scanner\"])[1]")
	WebElement eleQRScan;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
	WebElement eleDontAllow;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_one_time_button")
	WebElement elePermitOnce;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Geo Location\"]")
	WebElement eleGeoLocation;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_one_time_button")
	WebElement eleGeoAllowOnce;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Drawing\"]")
	WebElement eleDrawing;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")
	WebElement eleScrollUp;
	
	public void clickIcon()
	{
		eleBurgerIcon.click();
	}
	
	public void clickLogin()
	{
		eleLogin.click();
	}
	
	public void enterIntoUsername()
	{
		eleUsername.sendKeys("bob@example.com");
	}
	
	public void enterIntoPassword()
	{
		elePassword.sendKeys("10203040");
	}
	
	public void loginIntoAccount()
	{
		eleLoginAccount.click();
	}
	public void clickWebView()
	{
		elewebView.click();
	}
	
	public void enterUrlWebView()
	{
		eleUrl.sendKeys("https://www.google.com");
	}
	
	public void clickGotoSiteWebView()
	{
		eleGotoSite.click();
	}
	
	public void clickQRCode()
	{
		eleQRScan.click();
	}
	
	public void clickDontAllow()
	{
		eleDontAllow.click();
	}
	
	public void clickAllowOnce()
	{
		elePermitOnce.click();
	}
	
	public void clickGeoLocation()
	{
		eleGeoLocation.click();
	}
	
	public void clickGeoAllowOnce()
	{
		eleGeoAllowOnce.click();
	}
	
	public void clickDrawing()
	{
		eleDrawing.click();
	}
	
	public void scrollUp() throws InterruptedException
	{
		eleScrollUp.click();
		Thread.sleep(2000);
	}
	

}
