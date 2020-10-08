package com.indra.test.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigurationSetup {
	public WebDriver driver;
	ChromeOptions options;
	FileInputStream fileStream;
	Properties prop;
	
	public void setup() throws Exception {
		fileStream = new FileInputStream("C:\\Users\\santo\\git\\repository\\AutomationTest\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fileStream);
		
		System.setProperty(readPropertyFile("chrome"), readPropertyFile("path"));
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
	}
	
	public void launchURL() throws Exception {
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(readPropertyFile("baseURL"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public void closeAllTabs() {
		driver.close();
		driver.quit();
	}
	
	public void exitDriver() {
		driver.quit();
	}
	
	public String readPropertyFile(String keys) throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\santo\\git\\repository\\AutomationTest\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(file);
		return p.getProperty(keys);
	}
	
}
