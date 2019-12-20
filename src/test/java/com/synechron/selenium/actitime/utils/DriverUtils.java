package com.synechron.selenium.actitime.utils;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.synechron.selenium.actitime.testng.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils extends BaseTest
{
	public static WebDriver driver = null;

	
	public static void getScreenShot() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("reports\\ss_" + FileReaderUtils.getDataAndTime()+".png"));
	}
	
	
	/***
	 * getMyDriver returns ChromeDriver by default
	 * 
	 * @return - driver
	 * @author Aravind
	 */
	public static WebDriver getMyDrvier() {
		test.log(LogStatus.INFO,"Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}
	
	public static WebDriver getMyRemoteDriver(String type, String nodeIP, String portnum) throws MalformedURLException
	{
		String nodeUrl  = "http://" + nodeIP + ":" + portnum + "/wd/hub";
		
		switch (type) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, false); //options.addArguments("disable-infobars");
			driver = new RemoteWebDriver(new URL(nodeUrl),options);
			break;
		case "ff":
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			foptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			foptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			foptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, false); //foptions.addArguments("disable-infobars");
			break;
			
		case "edge":
			EdgeOptions eoptions = new EdgeOptions();
			eoptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			eoptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			eoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			eoptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, false);
			break;
		default:
			System.out.println("Please contact framework developers for more info");
			break;
		}
		
		
		
		return driver;
	}
	public static WebDriver getMyDriver(String type)
	{
		test.log(LogStatus.INFO,"Creating browser object for " + type);
		
		switch (type) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new  OperaDriver();
			break;

		default:
			test.log(LogStatus.INFO,"Please contact framework development team for new browser support....");
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	


	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * @return returns WebElement
	 */
	public static WebElement getMyElement(String locator, String locatorValue) {
		test.log(LogStatus.INFO,"*****Finding the element by using " + locator + " and " + locatorValue + "*****");
		WebElement ele = null;
		switch (locator) {
		case "id":
			ele = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			ele = driver.findElement(By.name(locatorValue));
			break;
		case "classname":
			ele = driver.findElement(By.className(locatorValue));
			break;
		case "tagname":
			ele = driver.findElement(By.tagName(locatorValue));
			break;
		case "linktext":
			ele = driver.findElement(By.linkText(locatorValue));
			break;
		case "partiallinktext":
			ele = driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "css":
			ele = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "xpath":
			ele = driver.findElement(By.xpath(locatorValue));
			break;
		default:
			ele = null;
			test.log(LogStatus.INFO,"Check the locator..!!!!!!!");
			break;
		}
		displayProperties(ele);
		test.log(LogStatus.INFO,"**** Element found successfully ***");
		return ele;
	}

	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * @return returns WebElements - List<WebElement>
	 */
	public static List<WebElement> getMyElements(String locator, String locatorValue) {
		test.log(LogStatus.INFO,"*****Finding the element by using " + locator + " and " + locatorValue + "*****");
		List<WebElement> ele = null;
		switch (locator) {
		case "id":
			ele = driver.findElements(By.id(locatorValue));
			break;
		case "name":
			ele = driver.findElements(By.name(locatorValue));
			break;
		case "classname":
			ele = driver.findElements(By.className(locatorValue));
			break;
		case "tagname":
			ele = driver.findElements(By.tagName(locatorValue));
			break;
		case "linktext":
			ele = driver.findElements(By.linkText(locatorValue));
			break;
		case "partiallinktext":
			ele = driver.findElements(By.partialLinkText(locatorValue));
			break;
		case "css":
			ele = driver.findElements(By.cssSelector(locatorValue));
			break;
		case "xpath":
			ele = driver.findElements(By.xpath(locatorValue));
			break;
		default:
			ele = null;
			test.log(LogStatus.INFO,"Check the locator..!!!!!!!");
			break;
		}
		test.log(LogStatus.INFO,"**** Elements found successfully ***");
		return ele;
	}

	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * 
	 *                     function used to perform click operation on the given
	 *                     element
	 */
	public static void clickOnElement(String locator, String locatorValue) {
		test.log(LogStatus.INFO,"Clicking on element....");
		getMyElement(locator, locatorValue).click();
		test.log(LogStatus.INFO,"Clicking on element successfull...");
	}

	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * 
	 *                     function used to perform type operation on the given
	 *                     element
	 */
	public static void typeOnElement(String locator, String locatorValue, String textToType) {
		test.log(LogStatus.INFO,"Typing --" + textToType + " -- on element ...");
		getMyElement(locator, locatorValue).sendKeys(textToType);
		test.log(LogStatus.INFO,"Type on element is successfull...");
	}

	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * @return - String function used to get the text on the given element
	 */
	public static String getTextOnElement(String locator, String locatorValue) {
		test.log(LogStatus.INFO,"Getting text on Elment ");
		String text = getMyElement(locator, locatorValue).getText();
		test.log(LogStatus.INFO,"$$$$ Got " + text + " on the element $$$$");
		return text;
	}

	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * @return - String function used to get the attribute value at runtime on the given element
	 */
	public static String getAttributeOnElement(String locator, String locatorValue, String attributeName) {
		test.log(LogStatus.INFO,"Getting text on Elment ");
		String text = getMyElement(locator, locatorValue).getAttribute(attributeName);
		test.log(LogStatus.INFO,"$$$$ Attribute Value  " + text + " found from the element $$$$");
		return text;
	}

	/**
	 * @author Aravind
	 * @param locator - id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * function used to get the text  on the given element
	 */
	public static void displayProperties(WebElement ele) {
		test.log(LogStatus.INFO,"Element Displayed Status : " + ele.isDisplayed());
		test.log(LogStatus.INFO,"Element Enabled Status : " + ele.isEnabled());
		test.log(LogStatus.INFO,"Element Selected Status : " + ele.isSelected());

	}
}
