package com.synechron.selenium.actitime.testng;

import java.util.Date;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertsDemo 
{
	

	
	@Test
	public void sumOfNumbers()
	{
		int a = 10; 
		int b = 20;
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Sum1");
		sa.assertEquals(a+b, 30);
		System.out.println("Sum2");
		sa.assertEquals(a+b, 20);
		System.out.println("Sum3");
		sa.assertEquals(a+b, 30);
		System.out.println("Sum4");
		sa.assertEquals(a+b, 10);
		System.out.println("Sum5");
		sa.assertEquals(a+b, 50);
		
		System.out.println("Sum Ended");
		
		sa.assertAll();
	}

}
