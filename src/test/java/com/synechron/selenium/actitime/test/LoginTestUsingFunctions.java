package com.synechron.selenium.actitime.test;

import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class LoginTestUsingFunctions {

	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getMyDrvier();
		
		ActitimeUtils.launchApplication("http://localhost/login.do");
		
		ActitimeUtils.typeOnElement("id", "username", "admin");
		ActitimeUtils.typeOnElement("name", "pwd", "manager");
		ActitimeUtils.clickOnElement("id", "loginButton");
		
	}
}
