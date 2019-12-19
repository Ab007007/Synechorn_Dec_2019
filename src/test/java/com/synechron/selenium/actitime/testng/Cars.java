package com.synechron.selenium.actitime.testng;

import org.testng.annotations.Test;

public class Cars 
{
	@Test(groups = "mahendra")
	public void xuv500()
	{
		System.out.println("xuv500");
	}
	@Test(groups = "mahendra")
	public void xuv300()
	{
		System.out.println("xuv300");	
	}
	@Test(groups = "maruthi")
	public void swift()
	{
		System.out.println("swift");
	}
	@Test(groups = "maruthi")
	public void alto()
	{
		System.out.println("alto");
	}
	@Test(groups = {"kia","maruthi"})
	public void KIA()
	{
		System.out.println("KIA");
	}
	
	@Test(groups = "hundai")
	public void i20()
	{
		System.out.println("i20");
	}

	@Test(groups = "hundai")
	public void i10()
	{
		System.out.println("i10");
	}

}
