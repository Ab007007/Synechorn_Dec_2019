package com.synechron.selenium.actitime.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class FileReaderUtils {

	private static File file = null;
	private static FileInputStream fis = null;
	private static Properties props = null;
	private static FileReader fr = null;
	private static BufferedReader br = null;

	
	public static String getDataAndTime()
	{
		Date d = new Date();
		return d.toString().replace(" ", "_").replace(":", "_");
	}
	public static void getDataFromTextFile() throws IOException {
		String line;
		file = new File("data\\customerdata.txt");

		fr = new FileReader(file);
		br = new BufferedReader(fr);

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
		fr.close();
	}

	private static Properties getProppertiesObj() throws IOException {
		file = new File("data\\config.properties");
		fis = new FileInputStream(file);
		props = new Properties();
		props.load(fis);

		return props;
	}

	private static void closeFileObj() throws IOException {
		fis.close();

	}

	public static String getBrowserTyp() throws IOException {

		getProppertiesObj();
		String browser = props.getProperty("browser");
		closeFileObj();
		return browser;

	}

	public static String getUserName() throws IOException {

		getProppertiesObj();
		String username = props.getProperty("username");
		closeFileObj();
		return username;

	}

	public static String getPassword() throws IOException {
		getProppertiesObj();
		String password = props.getProperty("password");
		closeFileObj();
		return password;
	}

	public static String getUrl() throws IOException {
		getProppertiesObj();
		String url = props.getProperty("url");
		closeFileObj();
		return url;
	}

	public static String getTimeout() throws IOException {
		getProppertiesObj();
		String timeout = props.getProperty("timeout");
		closeFileObj();
		return timeout;
	}

	public static String getAppUrl() throws IOException {
		getProppertiesObj();
		String appurl = props.getProperty("actitimeUrl");
		closeFileObj();
		return appurl;
	}

}
