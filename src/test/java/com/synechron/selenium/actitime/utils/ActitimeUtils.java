package com.synechron.selenium.actitime.utils;

public class ActitimeUtils extends DriverUtils
{
	
	public static void launchApplication(String url)
	{
		System.out.println("Launching application - " + url);
		driver.get(url);
	}

	public static void login(String un,String pwd)
	{
		System.out.println("--- logging in to actitime using " + un + " and " + pwd);
		typeOnElement("id", "username", un);
		typeOnElement("name", "pwd", pwd);
		clickOnElement("id", "loginButton");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickOnModule(String moduleName)
	{
		String xpathExpression = "//div[text()='" + moduleName.toUpperCase() + "']/parent::a";
		clickOnElement("xpath", xpathExpression);
	
	}
	
	public static void clickOnNewCustomerButton()
	{
		clickOnElement("xpath", "//div[@class='addNewContainer']");
		clickOnElement("xpath", "//div[@class='item createNewCustomer ellipsis']");
		
	}
	
	
	
	
	
	
}
