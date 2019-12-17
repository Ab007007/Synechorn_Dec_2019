package com.synechron.selenium.actitime.browser;

import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class BrowserActions 
{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver  =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/autocomplete");
		System.out.println("clicking on browser back button");
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		System.out.println("clicking on browser forward button");
		driver.navigate().forward();
		
		Thread.sleep(2000);
		System.out.println("clicking on browser refresh button");
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		System.out.println("clicking on browser maximize button");
		driver.manage().window().maximize();
		
		
		driver.navigate().to("http://www.google.com");
		
	}
}
