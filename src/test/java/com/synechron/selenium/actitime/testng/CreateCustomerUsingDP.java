package com.synechron.selenium.actitime.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class CreateCustomerUsingDP 
{
	WebDriver driver = null;
	@BeforeClass
	public void setup() throws IOException
	{
		Reporter.log("Creating Browser object in Before Class Method ");
		driver = ActitimeUtils.getMyDriver("firefox");
		Reporter.log("Launching application in Before Method");
		ActitimeUtils.launchApplication(FileReaderUtils.getAppUrl());
		Reporter.log("Login to the application in Before Method");
		ActitimeUtils.login(FileReaderUtils.getUserName(), FileReaderUtils.getPassword());
	}
	
	@AfterClass
	public void cleanUp()
	{
		Reporter.log("Logging out of the Application");
		ActitimeUtils.logout();
		driver.close();
		driver = null;
	}
	
	
	@Test(dataProviderClass = TestData.class ,  dataProvider = "createCustomerData")
	public void createCustomerTest(String cn , String cd)
	{
		Reporter.log("Creating customer using TEst<br> ");
		ActitimeUtils.clickOnModule("TASKS");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer(cn,cd);
		Reporter.log("Created successfully<br>");
	}
	
	
}
