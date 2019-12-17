package com.synechron.selenium.actitime.autosuggetion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipDemo
{

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost/login.do");
		
		WebElement usernameTextBox = driver.findElement(By.id("username"));
		usernameTextBox.sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
		Thread.sleep(3000);
		
		String settingsToopTipInfo = driver.findElement(By.xpath("//div[@class='popup_menu_icon warning_icon']")).getAttribute("title");
		
		System.out.println(settingsToopTipInfo);
		
		
		driver.findElement(By.id("logoutLink")).click();
	
	
	}

}
