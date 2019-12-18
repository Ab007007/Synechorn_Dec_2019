package com.synechron.selenium.actitime.popup;

import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

import javafx.scene.input.KeyCode;

public class FileDownloadPopUpDemo
{
	
	public static void main(String[] args) throws IOException {
		
		
		
		WebDriver driver =  ActitimeUtils.getMyDriver("firefox");
		//driver.get("http://www.google.com" + "\&username=XXXX&password=XXXX");
		ActitimeUtils.launchApplication("https://selenium.dev/downloads/");
		ActitimeUtils.clickOnElement("linktext", "3.141.59");
		Runtime.getRuntime().exec("D:\\Synechron_16_Dec_2019\\Eclipse_WS\\actitime\\autoit\\filedownload.exe");
		
	}
	

}
