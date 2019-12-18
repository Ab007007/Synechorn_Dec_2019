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
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class CreateCustomerUsingGlobalData {

	public static void main(String[] args) throws IOException {
		String url, username, password;
		url = FileReaderUtils.getUrl();
		username = FileReaderUtils.getUserName();
		password = FileReaderUtils.getPassword();
		
		WebDriver driver = ActitimeUtils.getMyDrvier();
		ActitimeUtils.launchApplication(url);
		ActitimeUtils.login(username,password);
		ActitimeUtils.clickOnModule("TASKS");
		
		File file = new File("data\\customerdata.txt");
		String line;
		FileReader fr =  new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		while((line=br.readLine())!=null)
		{
			String data[] = line.split(",");
			String cn = data[0];
			String cd = data[1];
			ActitimeUtils.clickOnNewCustomerButton();
			ActitimeUtils.createCustomer(cn,cd);

		}
		
		
		
		ActitimeUtils.logout();
	}

	
}
