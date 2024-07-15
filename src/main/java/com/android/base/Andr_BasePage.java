package com.android.base;

import java.time.Duration;
import java.util.Collections;

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
	 protected static AppiumDriver driver;
	
	public Andr_BasePage(AppiumDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static void longPress(WebElement ele)
	{
		//1. get location  of element using Point class
		Point location = ele.getLocation();
		
		//2. Create an object of PointerInput class and pass enumkind.touch action
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		
		//3. create an object of Sequence class , passing the input and adding various method actions
		Sequence sequence = new Sequence(input,1);
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
		
		driver.perform(Collections.singletonList(swipe));	
	}
	
	

}
