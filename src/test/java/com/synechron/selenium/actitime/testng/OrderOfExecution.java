package com.synechron.selenium.actitime.testng;

import org.testng.annotations.Test;

public class OrderOfExecution {

	@Test
	public void LaunchTest() 
	{
		System.out.println("Launching the  Browser");
	}

	@Test(dependsOnMethods = {"LaunchTest"})
	public void LoginTest() 
	{
		System.out.println("Login to Actitime Application");
	}
	
	@Test(dependsOnMethods = {"LaunchTest","LoginTest"})
	public void CreateCustomer()
	{
		System.out.println("Creating Customer");
	}
	
	@Test(dependsOnMethods = "CreateCustomer")
	public void LogoutTest() 
	{
		System.out.println("Logout of Application");
	}
}
