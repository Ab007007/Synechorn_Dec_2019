package com.synechron.selenium.actitime.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.synechron.selenium.actitime.utils.ApplicationUtils;
import com.synechron.selenium.actitime.utils.DriverUtils;

public class SelectDemo 
{

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  ApplicationUtils.getMyDrvier();
		ApplicationUtils.launchApplication("http://formy-project.herokuapp.com/form");
		
		WebElement ele = driver.findElement(By.id("select-menu"));
		Select yearOfExp =  new Select(ele);
		
		yearOfExp.selectByIndex(3);
		Thread.sleep(2000);
		yearOfExp.selectByValue("4");
		Thread.sleep(2000);
		yearOfExp.selectByVisibleText("0-1");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
