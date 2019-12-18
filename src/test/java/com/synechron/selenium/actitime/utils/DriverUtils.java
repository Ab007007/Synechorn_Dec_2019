package com.synechron.selenium.actitime.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {
	public static WebDriver driver = null;

	/***
	 * getMyDriver returns ChromeDriver by default
	 * 
	 * @return - driver
	 * @author Aravind
	 */
	public static WebDriver getMyDrvier() {
		System.out.println("Welcome to Selenium WebDriver");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
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
		System.out.println("*****Finding the element by using " + locator + " and " + locatorValue + "*****");
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
			System.out.println("Check the locator..!!!!!!!");
			break;
		}
		displayProperties(ele);
		System.out.println("**** Element found successfully ***");
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
		System.out.println("*****Finding the element by using " + locator + " and " + locatorValue + "*****");
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
			System.out.println("Check the locator..!!!!!!!");
			break;
		}
		System.out.println("**** Elements found successfully ***");
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
		System.out.println("Clicking on element....");
		getMyElement(locator, locatorValue).click();
		System.out.println("Clicking on element successfull...");
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
		System.out.println("Typing --" + textToType + " -- on element ...");
		getMyElement(locator, locatorValue).sendKeys(textToType);
		System.out.println("Type on element is successfull...");
	}

	/**
	 * @author Aravind
	 * @param locator      -
	 *                     id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * @return - String function used to get the text on the given element
	 */
	public static String getTextOnElement(String locator, String locatorValue) {
		System.out.println("Getting text on Elment ");
		String text = getMyElement(locator, locatorValue).getText();
		System.out.println("$$$$ Got " + text + " on the element $$$$");
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
		System.out.println("Getting text on Elment ");
		String text = getMyElement(locator, locatorValue).getAttribute(attributeName);
		System.out.println("$$$$ Attribute Value  " + text + " found from the element $$$$");
		return text;
	}

	/**
	 * @author Aravind
	 * @param locator - id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param locatorValue - value associated with locator
	 * function used to get the text  on the given element
	 */
	public static void displayProperties(WebElement ele) {
		System.out.println("Element Displayed Status : " + ele.isDisplayed());
		System.out.println("Element Enabled Status : " + ele.isEnabled());
		System.out.println("Element Selected Status : " + ele.isSelected());

	}
}
