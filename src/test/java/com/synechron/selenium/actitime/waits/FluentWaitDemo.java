package com.synechron.selenium.actitime.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	//file:///D:/Synechron_16_Dec_2019/Eclipse_WS/actitime/html/tiimeout.html
	
	public static <T> void main(String[] args) {
		System.out.println("Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Synechron_16_Dec_2019/Eclipse_WS/actitime/html/tiimeout.html");
		driver.findElement(By.tagName("button")).click();
	
		FluentWait<WebElement> wait = new FluentWait<WebElement>(driver.findElement(By.id("demo")))
		.pollingEvery(Duration.ofMillis(500))
		.withTimeout(Duration.ofSeconds(10))
		.ignoring(Exception.class);
		
		Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() {

			@Override
			public Boolean apply(WebElement input) {
				String text =  input.getText();
				
				if(text.equals("Hello"))
				{
					System.out.println("Text Found!!!!!!!!!!!");
					return true;
				}
				else
				{
					System.out.println("Waiting!!!!!!!");
					return false;
				}
			}
		};
		
		wait.until(fun);
		
		
		
		
				
				
				
				
	}
	
	
}
