package com.synechron.selenium.actitime.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class MouseMovementUsingActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement closeButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"))));
		
		if(closeButton.isDisplayed())
		{
			closeButton.click();
		}
		
		WebElement electronicsTab = driver.findElement(By.xpath("//span[text()='Electronics']"));
		WebElement mensTab = driver.findElement(By.xpath("//span[text()='Men']"));
		WebElement womensTab = driver.findElement(By.xpath("//span[text()='Women']"));
		WebElement homeFurnitureTab = driver.findElement(By.xpath("//span[text()='Home & Furniture']"));
		WebElement babyKidsTab = driver.findElement(By.xpath("//span[text()='Baby & Kids']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(electronicsTab).perform();
		Thread.sleep(2000);
		act.moveToElement(babyKidsTab).perform();
		Thread.sleep(2000);
		act.moveToElement(womensTab).perform();
		Thread.sleep(2000);
		act.moveToElement(mensTab).perform();
		Thread.sleep(2000);
		act.moveToElement(homeFurnitureTab).perform();
		Thread.sleep(2000);
		
	}
}
