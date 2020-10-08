package com.indra.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.SupportAction;
import com.indra.test.util.ConfigurationSetup;


public class SupportTest extends ConfigurationSetup {
	SupportAction supportAction;

	@BeforeTest
	public void init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void browser() throws Exception {
		launchURL();
	}
	
	@Test(priority=1)
	public WebDriver supportPages(WebDriver driver) throws InterruptedException {
		supportAction = new SupportAction(driver);
		PageFactory.initElements(driver, SupportTest.this);
		supportAction.support();
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
