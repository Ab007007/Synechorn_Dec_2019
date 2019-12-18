package com.synechron.selenium.actitime.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.ExcelUtils;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class CreateCustomerUsingExcelData {

	public static void main(String[] args) throws IOException {
		String url, username, password,browser;
		String sheetName = "customerdata";
		url = FileReaderUtils.getUrl();
		username = FileReaderUtils.getUserName();
		password = FileReaderUtils.getPassword();
		browser = FileReaderUtils.getBrowserTyp();
		
		WebDriver driver = ActitimeUtils.getMyDriver(browser);
		ActitimeUtils.launchApplication(url);
		ActitimeUtils.login(username,password);
		ActitimeUtils.clickOnModule("TASKS");
	
		for(int i = 1; i<ExcelUtils.getNumberofRows(sheetName); i++)
		{
			String customerName = ExcelUtils.getExcelData(sheetName, i, 0);
			String customerDesc = ExcelUtils.getExcelData(sheetName, i, 1);
			String executionStatus = ExcelUtils.getExcelData(sheetName, i, 2);
			
			if(executionStatus.equalsIgnoreCase("no"))
			{
				ActitimeUtils.clickOnNewCustomerButton();
				ActitimeUtils.createCustomer(customerName,customerDesc);
			}
			else
			{
				System.out.println("Skipping customer creation for " + customerName + " and " + customerDesc);
			}

		}
		
		ActitimeUtils.logout();
	}

	
}
