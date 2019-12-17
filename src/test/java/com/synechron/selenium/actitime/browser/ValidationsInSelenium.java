package com.synechron.selenium.actitime.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class ValidationsInSelenium {
	
	public static void main(String[] args) {
		
		WebDriver driver =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/enabled");
		
		WebElement ele1 = driver.findElement(By.id("disabledInput"));
		WebElement ele2 = driver.findElement(By.id("input"));
		
		System.out.println("Element-1 Status ");
		ActitimeUtils.displayProperties(ele1);
		
		System.out.println("Element-2 Status ");
		ActitimeUtils.displayProperties(ele2);
				
	}

	
}
