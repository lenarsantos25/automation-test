package com.indra.test;

import java.util.HashMap;
import java.util.Map;
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
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinatesLoc(34.052235, -118.243683, 1));
		driver.manage().window().maximize();
		driver.get("https://oldnavy.gap.com/stores");

		Thread.sleep(15000);
	}

	@Test(priority = 2)
	public void locationHouston() throws Exception {
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinatesLoc(29.749907, -95.358421, 1));
		driver.manage().window().maximize();
		driver.get("https://oldnavy.gap.com/stores");
		Thread.sleep(15000);
	}
	
	@Test(priority = 3)
	public void locationManila() throws Exception {
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinatesLoc(14.599512, 120.984222, 1));
		driver.manage().window().maximize();
		driver.get("https://oldnavy.gap.com/stores");
		Thread.sleep(15000);
	}

	@Test(priority = 4, enabled = true)
	public void locationAirAsiaMalaysia() throws Exception {
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinatesLoc(3.140853, 101.693207, 1));
		driver.manage().window().maximize();
		driver.get("https://www.stgairasia.com/en/gb");

		Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	private Map<String, Object> coordinatesLoc(double latitude, double longitude, int accuracy) {
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("latitude", latitude);
		mapping.put("longitude", longitude);
		mapping.put("accuracy", accuracy);
		return mapping;
	}
}
