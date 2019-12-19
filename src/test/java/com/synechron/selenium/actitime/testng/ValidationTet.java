package com.synechron.selenium.actitime.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.DriverUtils;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class ValidationTet 
{
	WebDriver driver = null;
	@BeforeTest
	public void setup() throws IOException
	{
		driver = ActitimeUtils.getMyDriver("chrome");
		ActitimeUtils.launchApplication(FileReaderUtils.getAppUrl());
		
	}
	@Test
	public void loginTestWithValidCreds() throws IOException
	{
		ActitimeUtils.login(FileReaderUtils.getUserName(), FileReaderUtils.getPassword());
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		ActitimeUtils.logout();
		System.out.println("TEST END");
		
	}

	
	@Test
	public void loginTestWithInvalidCreds()
	{
		ActitimeUtils.login("XXXX","XXXX");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		ActitimeUtils.logout();
		System.out.println("TEST END");
	
	}
	
	
	@AfterMethod
	public void captureScreenShot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			DriverUtils.getScreenShot();
		}
	}
	
	
}
