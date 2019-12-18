package com.synechron.selenium.actitime.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class CreateCustomerTest {

	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.clickOnModule("TASKS");
		ActitimeUtils.clickOnNewCustomerButton();
		ActitimeUtils.createCustomer("Syn-Dec-Cust-1","Syn-Dec-Cust-2");
		ActitimeUtils.logout();
	}

	
}
