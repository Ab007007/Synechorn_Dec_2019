package com.synechron.selenium.actitime.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils
{
	public static WebDriver driver = null;
	
	public static WebDriver getMyDrvier()
	{
		System.out.println("Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
