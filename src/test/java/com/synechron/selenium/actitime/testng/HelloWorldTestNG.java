package com.synechron.selenium.actitime.testng;

import org.testng.annotations.Test;

public class HelloWorldTestNG {

	@Test
	public void LaunchTest() 
	{
		System.out.println("Launchint Browser");
	}

	@Test
	public void LoginTest() 
	{
		System.out.println("Login to Actitime Application");
	}
	
	@Test
	public void CreateCustomer()
	{
		System.out.println("Creating Customer");
	}
	
	@Test
	public void LogoutTest() 
	{
		System.out.println("Logout of Application");
	}
}
