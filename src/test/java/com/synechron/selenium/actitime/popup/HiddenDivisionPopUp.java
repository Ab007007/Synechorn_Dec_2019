package com.synechron.selenium.actitime.popup;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.synechron.selenium.actitime.utils.FileReaderUtils;

public class HiddenDivisionPopUp {

	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver =  ActitimeUtils.getMyDriver("chrome");
		ActitimeUtils.launchApplication(FileReaderUtils.getUrl());
		ActitimeUtils.clickOnElement("id", "modal-button");
		String text = ActitimeUtils.getTextOnElement("classname", "modal-body");
		System.out.println(text);
		
		ActitimeUtils.clickOnElement("id", "close-button");
	}
}
