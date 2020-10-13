package com.indra.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.indra.test.util.ConfigurationSetup;

public class AirAsiaGeolocation extends ConfigurationSetup {

	ChromeDriver driver;

	@BeforeMethod
	public void getDriver() throws Exception {
		System.setProperty(readPropertyFile("chrome"), readPropertyFile("path"));
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void locationLosAngeles() throws Exception {
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("latitude", 34.052235);
		mapping.put("longitude", -118.243683);
		mapping.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", mapping);
		driver.manage().window().maximize();
		driver.get("https://oldnavy.gap.com/stores");

		Thread.sleep(15000);
	}

	@Test(priority = 2)
	public void locationHouston() throws Exception {
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("latitude", 29.749907);
		mapping.put("longitude", -95.358421);
		mapping.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", mapping);
		driver.manage().window().maximize();
		driver.get("https://oldnavy.gap.com/stores");
		Thread.sleep(15000);
	}
	
	@Test(priority = 3)
	public void locationManila() throws Exception {
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("latitude", 14.599512);
		mapping.put("longitude", 120.984222);
		mapping.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", mapping);
		driver.manage().window().maximize();
		driver.get("https://oldnavy.gap.com/stores");
		Thread.sleep(15000);
	}

	@Test(priority = 4, enabled = true)
	public void locationAirAsiaMalaysia() throws Exception {
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("latitude", 3.140853);
		mapping.put("longitude", 101.693207);
		mapping.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", mapping);
		driver.manage().window().maximize();
		driver.get("https://www.airasia.com/en/gb");

		Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
