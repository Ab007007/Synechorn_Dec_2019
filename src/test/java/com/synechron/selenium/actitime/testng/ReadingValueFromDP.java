package com.synechron.selenium.actitime.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class ReadingValueFromDP {

	WebDriver driver = null;
	
	@Parameters({"browser"})
	@BeforeClass
	public void createDriver(String browserType)
	{
		driver = ActitimeUtils.getMyDriver(browserType);
	}
	
	@Parameters({"url"})
	@BeforeMethod
	public void launch(String url)
	{
		ActitimeUtils.launchApplication(url);
	}
	
	
	@Test(dataProviderClass = TestData.class, dataProvider = "actitimeUsers")
	public void loginTestWithValidCredentials(String un,String pwd)
	{
		ActitimeUtils.login(un, pwd);
	}
	
	
	@AfterMethod
	public void logout()
	{
		ActitimeUtils.logout();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}
