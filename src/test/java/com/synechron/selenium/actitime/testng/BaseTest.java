package com.synechron.selenium.actitime.testng;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class BaseTest {

	public static ExtentReports reports = null;
	public static ExtentTest test = null;
	@BeforeSuite
	public void setupReports()
	{
		File file = new File("reports");
		String path = "\\Test_Execution_Report_" + FileReaderUtils.getDataAndTime() + ".html";
		reports = new ExtentReports(file.getAbsolutePath()+path, false);
		
	}
	
	
	
	@AfterSuite
	public void closeReport()
	{
		reports.flush();
		reports =null;
	}
}
