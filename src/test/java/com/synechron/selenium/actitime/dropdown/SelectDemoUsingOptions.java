package com.synechron.selenium.actitime.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.DriverUtils;

public class SelectDemoUsingOptions 
{

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/form");
		
		WebElement ele = driver.findElement(By.id("select-menu"));
		Select yearOfExp =  new Select(ele);
		
		
		List<WebElement> options = yearOfExp.getOptions();
		
		boolean flag =  false;
		for (WebElement option : options) 
		{
			System.out.println("Dropdown item : " + option.getText());
			if(option.getText().equals("11+"))
			{
				System.out.println("PASS - drop down found..!! and i'm selecting it");
				yearOfExp.selectByVisibleText("10+");
				flag = true;
				break;
			}
			
		}
		 if(!flag)
		 {
			 System.out.println("FAIL -  dropdown not found!!!!! check with admin");
		 }

		
	}
}
