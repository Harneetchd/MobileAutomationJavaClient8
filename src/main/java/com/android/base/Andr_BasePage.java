package com.android.base;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Andr_BasePage 
{
	 protected AppiumDriver driver;
	
	public Andr_BasePage(AppiumDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static void longPress(WebElement ele, AppiumDriver driver)
	{
		//1. get location  of element using Point class
		Point location = ele.getLocation();
		
		//2. Create an object of PointerInput class and pass enumkind.touch action
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		
		//3. create an object of Sequence class , passing the input and adding various method actions
		Sequence sequence = new Sequence(input,0);
		sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x,location.y));
		sequence.addAction(input.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(),location.x , location.y));
		sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(ImmutableList.of(sequence));	
	}
	
	protected static void swipe(Point start,Point end,Duration duration , AppiumDriver driver)
	{
		
		//Create an object of PointerInput class and pass enumkind.touch action
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
		
		//Create an object of Sequence class , passing the input and adding various method actions
		Sequence swipe = new Sequence(input,0);
		swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x,start.y));
		swipe.addAction(input.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(),end.x , end.y));
		swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(ImmutableList.of(swipe));	
	}
	
	public static void scroll(String pageDirection, double scrollRatio, AppiumDriver driver )
	{
		Duration SCROLL_DUR= Duration.ofMillis(300);
		if(scrollRatio<0 || scrollRatio>1)
		{
			throw new Error("Scroll Distance must be between 0 and 1");
		}
		
		Dimension size = driver.manage().window().getSize();
		System.out.println("ScreenSize :"+size);
		System.out.println("");
		
		Point midPoint = new Point((int)(size.width*0.5) , (int)(size.height *0.5));
		
		int a= (int)(midPoint.x * scrollRatio);// scrollRatio =.5
		int b= (int)(midPoint.y * scrollRatio);
		
		int bottom = midPoint.y+b;
		int top = midPoint.y - b;
		int left = midPoint.x-a;
		int right = midPoint.x+a;
		
		if(pageDirection =="UP")
		{
			swipe(new Point(midPoint.x, top),new Point(midPoint.x, top),SCROLL_DUR,driver);
		}else if(pageDirection =="DOWN")
		{
			swipe(new Point(midPoint.x, bottom),new Point(midPoint.x, bottom),SCROLL_DUR, driver);
		}else if(pageDirection =="lEFT")
		{
			swipe(new Point(left,midPoint.y), new Point(right,midPoint.y),SCROLL_DUR, driver);
		}else if(pageDirection=="RIGHT")
		{
			swipe(new Point(right,midPoint.y), new Point(left,midPoint.y),SCROLL_DUR, driver);
		}	
	}
	
	public void swipeMe()
	{
		
	}
	

}
