package com.synechron.selenium.actitime.autosuggetion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAutoSuggestionsUsingGrid {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.out.println("Welcome to Selenium WebDriver");
//		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		String nodeUrl  = "http://172.20.227.139:5555/wd/hub";
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("disable-infobars");
			
		RemoteWebDriver driver = new RemoteWebDriver(new URL(nodeUrl),options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium");
		//Thread.sleep(2000);
		
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='erkvQe']"))));
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='sbct']"));
	
		System.out.println(suggestions.size());
	
		for (WebElement suggestion : suggestions)
		{
			System.out.println("====> " + suggestion.getText() + " <=====");
		}
	
		driver.close();
	
	
	
	
	
	
	
	
	}
}
