package com.synechron.selenium.actitime.switchto;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class MultiBrowserDemo {

	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDrvier();
		
		ActitimeUtils.launchApplication("https://www.irctc.co.in/eticketing/errors.html#");
		
		ActitimeUtils.clickOnElement("linktext", "Contact Us");
		
		Set<String> windowIds = driver.getWindowHandles();
		
		Iterator<String>  it  = windowIds.iterator();
		
		String parentID = it.next();
		String childID = it.next();
		
		System.out.println("Parent id " + parentID);
		System.out.println("Child id " + childID);
		
		driver.switchTo().window(childID);
		
		List<WebElement> emailIDS = ActitimeUtils.getMyElements("tagname", "a");
		
		System.out.println("Printing all email id's");
		for (WebElement emailID : emailIDS) {
			
			System.out.println(emailID.getText());
		}
		driver.close();
		driver.switchTo().window(parentID);
		
		ActitimeUtils.clickOnElement("linktext", "Home");
		
	
	}
}
