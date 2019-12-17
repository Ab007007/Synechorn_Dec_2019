package com.synechron.selenium.actitime.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CounterTextHandler 
{
	public static void main(String[] args) {
		System.out.println("Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("file:///D:/Synechron_16_Dec_2019/Eclipse_WS/actitime/html/CounterText.html");
		
		WebDriverWait wait  =  new WebDriverWait(driver, 30);
	//	WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("counter"))));
		
		wait.until(ExpectedConditions.textToBe(By.id("counter"), "3"));
		String text = driver.findElement(By.id("counter")).getText();
		
		System.out.println(text);
		
		
	}
}
