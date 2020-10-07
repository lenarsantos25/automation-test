package com.indra.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.AirAsiaHomeAction;

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
	public void flightsTab() throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.flights();
	}
	
	@Test(priority=2, enabled=true)
	public void hotelsTab() throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.hotels();
	}
	
	@Test(priority=3, enabled=true)
	public void snapTab() throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.snap();
	}
	
	@Test(priority=4, enabled=false)
	public void shopTab() {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.shop();
	}

	@Test(priority=5, enabled=true)
	public void activitesTab() {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.activites();
	}
	
	@Test(priority=6, enabled=true)
	public void insuranceTab() {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.insurance();
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
