package com.synechron.selenium.actitime.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		driver.manage().window().maximize();
		return driver;
		
	}

	public static void displayProperties(WebElement ele)
	{
		System.out.println("Element Displayed Status : " + ele.isDisplayed());
		System.out.println("Element Enabled Status : " + ele.isEnabled());
		System.out.println("Element Selected Status : " + ele.isSelected());
	
	}
}
