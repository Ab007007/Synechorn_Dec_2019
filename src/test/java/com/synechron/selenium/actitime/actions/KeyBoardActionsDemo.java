package com.synechron.selenium.actitime.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class KeyBoardActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://localhost/login.do");
		
		Actions act = new Actions(driver);
		act.sendKeys("admin").perform();
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		act.sendKeys("manager").perform();
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		
	}
}
