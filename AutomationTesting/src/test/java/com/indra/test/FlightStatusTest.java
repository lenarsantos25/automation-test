package com.indra.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.FlightStatusAction;

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
	public void searchByFlightNumber() throws InterruptedException {
		flightStatusAction = new FlightStatusAction(driver);
		PageFactory.initElements(driver, FlightStatusTest.class);
		flightStatusAction.searchFlightNumber();
	}

	@Test(priority = 2)
	public void searchByDestination() throws InterruptedException {
		flightStatusAction = new FlightStatusAction(driver);
		PageFactory.initElements(driver, FlightStatusTest.class);
		flightStatusAction.searchByRoute();
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
