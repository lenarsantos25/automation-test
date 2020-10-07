package com.indra.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.CheckinAction;

public class CheckinTest extends ConfigurationSetup{
	CheckinAction checkInAction;

	@BeforeTest
	public void init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void browser() throws Exception {
		launchURL();
	}
	
	@Test(priority=1)
	public void CheckinPages() throws InterruptedException {
		checkInAction = new CheckinAction(driver);
		PageFactory.initElements(driver, CheckinTest.class);
		checkInAction.checkIn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
