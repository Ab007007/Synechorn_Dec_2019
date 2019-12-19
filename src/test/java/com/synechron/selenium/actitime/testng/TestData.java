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
	      new Object[] { "SP-TestNG-Syn-Dec1", "SP-TestNG-Syn-DecDesc1" },
	      new Object[] { "SP-TestNG-Syn-Dec2", "SP-TestNG-Syn-DecDesc2" },
	      new Object[] { "SP-TestNG-Syn-Dec3", "SP-TestNG-Syn-DecDesc3" },
	      new Object[] { "SP-TestNG-Syn-Dec4", "SP-TestNG-Syn-DecDesc4" },
	      new Object[] { "SP-TestNG-Syn-Dec5", "SP-TestNG-Syn-DecDesc5" },
	      new Object[] { "SP-TestNG-Syn-Dec6", "SP-TestNG-Syn-DecDesc6" },
	    
	    };
	  }
	
}
