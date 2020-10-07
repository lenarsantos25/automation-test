package com.indra.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.MyBookingsAction;


public class MyBookingsTest extends ConfigurationSetup{
	MyBookingsAction mybookingsAction;

	@BeforeTest
	public void Init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void Browser() throws Exception {
		launchURL();
	}
	
	@Test (priority=1)
	public void  FlightTabPage() throws InterruptedException {
		mybookingsAction = new MyBookingsAction(driver);
		PageFactory.initElements(driver, MyBookingsTest.class);
		mybookingsAction.FlightTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test (priority=2)
	public void HotelTabPage() throws InterruptedException {
		mybookingsAction = new MyBookingsAction(driver);
		PageFactory.initElements(driver, MyBookingsTest.class);
		mybookingsAction.HotelTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test (priority=3)
	public void RetrievePage() throws InterruptedException {
		mybookingsAction = new MyBookingsAction(driver);
		PageFactory.initElements(driver, MyBookingsTest.class);
		mybookingsAction.RetrieveBooking();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
