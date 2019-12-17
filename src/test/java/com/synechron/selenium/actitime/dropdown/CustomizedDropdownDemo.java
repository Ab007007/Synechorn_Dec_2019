package com.synechron.selenium.actitime.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class CustomizedDropdownDemo {

	
	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/dropdown");
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		driver.findElement(By.id("autocomplete")).click();
		
	}
}
