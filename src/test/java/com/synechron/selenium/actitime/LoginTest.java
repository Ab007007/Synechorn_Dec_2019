package com.synechron.selenium.actitime;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.synechron.selenium.actitime.utils.DriverUtils;

public class LoginTest 
{
	
	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Welcome to Selenium WebDriver");
//		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		String nodeUrl  = "http://172.20.227.139:5555/wd/hub";
		RemoteWebDriver driver =   (RemoteWebDriver) DriverUtils.getMyRemoteDriver("chrome","172.20.227.139","5555");
		
		driver.get("http://172.20.227.139:9000/login.do");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement usernameTextBox = driver.findElement(By.id("username"));
		usernameTextBox.sendKeys("admin");

		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
		
		driver.findElement(By.id("logoutLink")).click();
	
	
	}

}
