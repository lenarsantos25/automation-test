package com.indra.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.MyBookingsAction;
import com.indra.test.util.ConfigurationSetup;

public class MyBookingsTest extends ConfigurationSetup {
	MyBookingsAction mybookingsAction;

	@BeforeTest
	public void init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void browser() throws Exception {
		launchURL();
	}

	@Test(priority = 1)
	public WebDriver flightTabPage(WebDriver driver) throws InterruptedException {
		mybookingsAction = new MyBookingsAction(driver);
		PageFactory.initElements(driver, MyBookingsTest.class);
		mybookingsAction.flightTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 2)
	public WebDriver hotelTabPage(WebDriver driver) throws InterruptedException {
		mybookingsAction = new MyBookingsAction(driver);
		PageFactory.initElements(driver, MyBookingsTest.class);
		mybookingsAction.hotelTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 3)
	public WebDriver retrievePage(WebDriver driver) throws InterruptedException {
		mybookingsAction = new MyBookingsAction(driver);
		PageFactory.initElements(driver, MyBookingsTest.class);
		mybookingsAction.retrieveBooking();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@AfterMethod
	public void closeTabs() {
		closeAllTabs();
	}

	@AfterTest
	public void quitDriver() {
		exitDriver();
	}
}
