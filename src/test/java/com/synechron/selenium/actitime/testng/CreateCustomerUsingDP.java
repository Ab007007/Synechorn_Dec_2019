package com.synechron.selenium.actitime.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class CreateCustomerUsingDP extends BaseTest
{
	WebDriver driver = null;
	@BeforeClass
	public void setup() throws IOException
	{
		test = reports.startTest("Setup - BeforeClass Function");
		test.log(LogStatus.INFO	, "Creating Browser object in Before Class Method ");
		driver = ActitimeUtils.getMyDriver("firefox");
		test.log(LogStatus.INFO	, "Launching application in Before Method");
		ActitimeUtils.launchApplication(FileReaderUtils.getAppUrl());
		test.log(LogStatus.INFO	, "Login to the application in Before Method");
		ActitimeUtils.login(FileReaderUtils.getUserName(), FileReaderUtils.getPassword());
		test.log(LogStatus.PASS, "Logged in successfully");
		
		reports.endTest(test);
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
		test = reports.startTest("Create Customer using " + cn  +  " and " + cd );
		test.log(LogStatus.INFO, "Creating customer ");
		Reporter.log("Creating customer using TEst<br> ");
		ActitimeUtils.clickOnModule("TASKS");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer(cn,cd);
		test.log(LogStatus.PASS, "Customer created successfully");
		
		Reporter.log("Created successfully<br>");
	}
	
	
}
