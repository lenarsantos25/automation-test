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
import com.indra.test.util.DataProviderClass;

public class FlightStatusTest extends ConfigurationSetup {
	FlightStatusAction flightStatusAction;
	DataProviderClass flights = new DataProviderClass();

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

	@Test(priority = 2, dataProvider = "getFlights", dataProviderClass = DataProviderClass.class)
	public void searchByDestination(DataProviderClass data) throws InterruptedException {
		flightStatusAction = new FlightStatusAction(driver);
		PageFactory.initElements(driver, FlightStatusTest.class);
		flightStatusAction.searchByRoute(data.getOrigin(), data.getDestination());
//		return driver;
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
