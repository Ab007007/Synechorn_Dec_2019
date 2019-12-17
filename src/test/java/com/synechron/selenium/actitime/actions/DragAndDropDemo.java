package com.synechron.selenium.actitime.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class DragAndDropDemo {

	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement destEle = driver.findElement(By.id("droppable"));
		
		System.out.println("Droppable text before drag and drop " + destEle.getText());
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(sourceEle, destEle).perform();
		
		System.out.println("Droppable text after drag and drop " + destEle.getText());
		
		
	}
}
