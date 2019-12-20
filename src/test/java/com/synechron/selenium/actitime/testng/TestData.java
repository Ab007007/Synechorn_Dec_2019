package com.synechron.selenium.actitime.testng;

import org.testng.annotations.DataProvider;

public class TestData {

	// Test data for Login Test
	@DataProvider
	  public Object[][] actitimeUsers()
	  {
	    return new Object[][] 
		{
	      new Object[] { "admin", "manager" },
	      new Object[] { "admin", "manager" },
	      new Object[] { "admin", "manager" },
	      new Object[] { "admin", "manager" },
	      new Object[] { "admin", "manager" },
	      new Object[] { "admin", "manager" },
	    };
	  }
	
	
	@DataProvider
	public Object[][] createCustomerData()
	  {
	    return new Object[][] 
		{
	      new Object[] { "SP-TestNG-Syn-Dec1a", "SP-TestNG-Syn-DecDesc11" },
	      new Object[] { "SP-TestNG-Syn-Dec1b", "SP-TestNG-Syn-DecDesc11" },
	      new Object[] { "SP-TestNG-Syn-Dec1c", "SP-TestNG-Syn-DecDesc11" },
	      new Object[] { "SP-TestNG-Syn-Dec1d", "SP-TestNG-Syn-DecDesc11" },
	      new Object[] { "SP-TestNG-Syn-Dec1e", "SP-TestNG-Syn-DecDesc11" },
	          
	    };
	  }
	
}
