package com.synechron.selenium.actitime.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class CheckBoxValidator {

	public static void main(String[] args) {
		
		WebDriver driver =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/checkbox");
		
		WebElement cb1 = driver.findElement(By.id("checkbox-1"));
		WebElement cb2 = driver.findElement(By.id("checkbox-2"));
		WebElement cb3 = driver.findElement(By.id("checkbox-3"));
		
		System.out.println("Before clicking .....");
		ActitimeUtils.displayProperties(cb1);
		ActitimeUtils.displayProperties(cb2);
		ActitimeUtils.displayProperties(cb3);
		
		cb1.click();
		cb2.click();
		cb3.click();
			
		System.out.println("After clicking....");
		ActitimeUtils.displayProperties(cb1);
		ActitimeUtils.displayProperties(cb2);
		ActitimeUtils.displayProperties(cb3);
		
		if(cb2.isSelected())
		{
			cb2.click();
		}
		
		System.out.println("After Unselecting one ....");
		ActitimeUtils.displayProperties(cb1);
		ActitimeUtils.displayProperties(cb2);
		ActitimeUtils.displayProperties(cb3);
		
		
	
	}
}
