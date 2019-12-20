package com.synechron.selenium.actitime.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.ExcelUtils;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class DeleteCustomerUsingExcel {
	public static ExtentReports reports = null;
	public static ExtentTest test = null;

	public static void main(String[] args) throws IOException {
//		reports = new ExtentReports("reports" + "\\Execution_" + FileReaderUtils.getDataAndTime() + ".html");
//		test =  reports.startTest("my new test");
		String url, username, password, browser;
		String sheetName = "customerdata";
		url = FileReaderUtils.getAppUrl();
		username = FileReaderUtils.getUserName();
		password = FileReaderUtils.getPassword();
		browser = FileReaderUtils.getBrowserTyp();
		WebDriver driver = ActitimeUtils.getMyDriver(browser);
		ActitimeUtils.launchApplication(url);
		ActitimeUtils.login(username, password);

		int rowCount = ExcelUtils.getNumberofRows(sheetName);
		for (int i = 1; i < rowCount; i++) {
			ActitimeUtils.clickOnModule("TASKS");
			String customerName = ExcelUtils.getExcelData(sheetName, i, 0);
			ActitimeUtils.searchCustomerToDelete(customerName);
			ActitimeUtils.deleteCustomer();
			ActitimeUtils.clickOnModule("Reports");
		}
		ActitimeUtils.logout();

	}

}
