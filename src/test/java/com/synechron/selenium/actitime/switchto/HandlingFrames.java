package com.synechron.selenium.actitime.switchto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("https://jqueryui.com/droppable/");
		
		//driver.switchTo().frame(0);
		driver.switchTo().frame(ActitimeUtils.getMyElement("xpath", "//iframe[@class='demo-frame']"));
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement destEle = driver.findElement(By.id("droppable"));
		
		System.out.println("Droppable text before drag and drop " + destEle.getText());
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(sourceEle, destEle).perform();
		
		System.out.println("Droppable text after drag and drop " + destEle.getText());
		
		driver.switchTo().defaultContent();
		
		ActitimeUtils.clickOnElement("linktext", "Selectable");
		
		driver.switchTo().frame(ActitimeUtils.getMyElement("xpath", "//iframe[@class='demo-frame']"));
		
		List<WebElement> items = ActitimeUtils.getMyElements("xpath", "//li");
		
		for (WebElement item : items)
		{
			item.click();
			Thread.sleep(1000);
			
		}
		
		driver.switchTo().defaultContent();
		driver.close();
		
		
	}
}
