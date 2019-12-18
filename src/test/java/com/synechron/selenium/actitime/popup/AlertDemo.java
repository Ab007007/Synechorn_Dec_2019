package com.synechron.selenium.actitime.popup;

import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class AlertDemo 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = ActitimeUtils.getMyDrvier();
		
		ActitimeUtils.launchApplication("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.clickOnModule("TASKS");
		ActitimeUtils.clickOnNewCustomerButton();
		
		ActitimeUtils.typeOnElement("id", "customerLightBox_nameField", "DummyCustomer");
		ActitimeUtils.clickOnElement("id", "customerLightBox_cancelBtn");
		Thread.sleep(2000);
		String textOnalert = driver.switchTo().alert().getText();
		
		System.out.println("Printing text on alert " + textOnalert);
		
		System.out.println("clicking on cancel button on alert");
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		System.out.println("clicking on OK button on alert");
		ActitimeUtils.clickOnElement("id", "customerLightBox_cancelBtn");
		driver.switchTo().alert().accept();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
