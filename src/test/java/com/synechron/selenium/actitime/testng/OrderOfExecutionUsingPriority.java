package com.synechron.selenium.actitime.testng;

import org.testng.annotations.Test;

public class OrderOfExecutionUsingPriority {

	@Test(priority = 0)
	public void LaunchTest() 
	{
		System.out.println("Launchint Browser");
	}

	@Test(priority = 1)
	public void LoginTest() 
	{
		System.out.println("Login to Actitime Application");
	}
	
	@Test(priority = 2)
	public void CreateCustomer()
	{
		System.out.println("Creating Customer");
	}
	
	@Test(priority = 3)
	public void LogoutTest() 
	{
		System.out.println("Logout of Application");
	}
}
