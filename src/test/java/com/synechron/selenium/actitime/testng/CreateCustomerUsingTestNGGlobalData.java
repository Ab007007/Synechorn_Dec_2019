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

public class CreateCustomerUsingTestNGGlobalData 
{
	WebDriver driver = null;
	@BeforeClass
	public void setup()
	{
		Reporter.log("Creating Browser object in Before Class Method ");
		driver = ActitimeUtils.getMyDriver("firefox");
	}
	
	@AfterClass
	public void cleanUp()
	{
		driver.close();
		driver = null;
	}
	

	@BeforeMethod
	public void preSetupToTest() throws IOException
	{
		Reporter.log("Launching application in Before Method");
		ActitimeUtils.launchApplication(FileReaderUtils.getAppUrl());
		Reporter.log("Login to the application in Before Method");
		ActitimeUtils.login(FileReaderUtils.getUserName(), FileReaderUtils.getPassword());
		
	}
	
	@AfterMethod
	public void postExecutionOfTest()
	{
		Reporter.log("Logging out of the Application");
		ActitimeUtils.logout();
	}
	
	@Test
	public void ValidateDashBoardTest()
	{
		Reporter.log(ActitimeUtils.getTextOnElement("xpath", "//div[@class='pagetitle']"));
	}
	
	
	@Test
	public void createCustomerTest()
	{
		Reporter.log("Creating customer using TEst<br> ");
		ActitimeUtils.clickOnModule("TASKS");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer("TestNG-Syn-Dec-Cust-2", "TestNG-Syn-Dec-CustDesc-2");
		Reporter.log("Created successfully<br>");
	}
	
	
}
