package com.synechron.selenium.actitime.autosuggetion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class PrintSuggestedAddress {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/autocomplete");
		driver.findElement(By.id("autocomplete")).sendKeys("Pune");
		//Thread.sleep(2000);
		
		WebDriverWait wait =  new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='pac-container pac-logo']"))));
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='pac-item']"));
	
		for (WebElement suggestion : suggestions)
		{
			String text = suggestion.getText();
			System.out.println("====> " + text + " <=====");
			
			if(text.contains("Pune University"))
			{
				suggestion.click();
				break;
			}
			
		}
	
//		driver.close();
	
	
	
	
	
	
	
	
	}
}
