package com.synechron.selenium.actitime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest 
{
	
	public static void main(String[] args) {
		System.out.println("Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost/login.do");
		
		WebElement usernameTextBox = driver.findElement(By.id("username"));
		usernameTextBox.sendKeys("admin");

		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
		
		driver.findElement(By.id("logoutLink")).click();
	
	
	}

}
