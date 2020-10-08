package com.indra.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.AirAsiaHomeAction;
import com.indra.test.util.ConfigurationSetup;

public class AirAsiaHomeTest extends ConfigurationSetup{
	AirAsiaHomeAction airasiaHomeAction;

	@BeforeTest
	public void init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void browser() throws Exception {
		launchURL();
	}
	
	@Test(priority=1, enabled=true)
	public WebDriver flightsTab(WebDriver driver) throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.flights();
		return driver;
	}
	
	@Test(priority=2, enabled=true)
	public WebDriver hotelsTab(WebDriver driver) throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.hotels();
		return driver;
	}
	
	@Test(priority=3, enabled=true)
	public WebDriver snapTab(WebDriver driver) throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.snap();
		return driver;
	}
	
	@Test(priority=4, enabled=false)
	public WebDriver shopTab(WebDriver driver) {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.shop();
		return driver;
	}

	@Test(priority=5, enabled=true)
	public WebDriver activitesTab(WebDriver driver) {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.activites();
		return driver;
	}
	
	@Test(priority=6, enabled=true)
	public WebDriver insuranceTab(WebDriver driver) {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.insurance();
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
