package com.synechron.selenium.actitime.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

public class FileUploadDemo {

	public static void main(String[] args) throws IOException {
	//	D:\Synechron_16_Dec_2019\Eclipse_WS\actitime\toastmsg.png
		
		WebDriver driver = ActitimeUtils.getMyDriver("chrome");
		ActitimeUtils.launchApplication("http://formy-project.herokuapp.com/fileupload");
		ActitimeUtils.clickOnElement("id", "file-upload-field");
		Runtime.getRuntime().exec("D:\\Synechron_16_Dec_2019\\Eclipse_WS\\actitime\\autoit\\uploadCode.exe");
		
		
		
		
		
		
		
	}
}
