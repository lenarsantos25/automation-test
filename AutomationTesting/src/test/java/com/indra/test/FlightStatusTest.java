package com.indra.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.FlightStatusAction;
import com.indra.test.util.ConfigurationSetup;

public class FlightStatusTest extends ConfigurationSetup {
	FlightStatusAction flightStatusAction;

	@BeforeTest
	public void Init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void Browser() throws Exception {
		launchURL();
	}

	@Test(priority = 1)
	public WebDriver searchByFlightNumber(WebDriver driver) throws InterruptedException {
		flightStatusAction = new FlightStatusAction(driver);
		PageFactory.initElements(driver, FlightStatusTest.class);
		flightStatusAction.searchFlightNumber();
		return driver;
	}

	@Test(priority = 2)
	public WebDriver searchByDestination(WebDriver driver) throws InterruptedException {
		flightStatusAction = new FlightStatusAction(driver);
		PageFactory.initElements(driver, FlightStatusTest.class);
		flightStatusAction.searchByRoute();
		return driver;
	}

	@AfterMethod
	public void CloseTabs() {
		closeAllTabs();
	}

	@AfterTest
	public void ExitDriver() {
		exitDriver();
	}
}
