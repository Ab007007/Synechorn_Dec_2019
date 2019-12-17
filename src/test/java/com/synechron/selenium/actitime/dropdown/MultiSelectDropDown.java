package com.synechron.selenium.actitime.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("file:///D:/Synechron_16_Dec_2019/Eclipse_WS/actitime/html/multiSelect.html");
		
		WebElement multiSelectDD = driver.findElement(By.tagName("select"));
		
		Select sel  = new Select(multiSelectDD);
	
		sel.selectByIndex(3);
		Thread.sleep(2000);
		sel.selectByVisibleText("Volvo");
		Thread.sleep(2000);
		sel.selectByValue("mercedes");
		Thread.sleep(2000);
		sel.deselectByIndex(0);
		Thread.sleep(2000);
		sel.deselectByValue("audi");
		
	}
}
