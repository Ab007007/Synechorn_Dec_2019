package com.synechron.selenium.actitime.utils;

public class ApplicationUtils extends DriverUtils
{
	
	public static void launchApplication(String url)
	{
		System.out.println("Launching application - " + url);
		driver.get(url);
	}

}
