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
	public void Init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void Browser() throws Exception {
		launchURL();
	}
	
	@Test(priority=1)
	public void FlightsTab() throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.Flights();
	}
	
	@Test(priority=2)
	public void HotelsTab() throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.Hotels();
	}
	
	@Test(priority=3)
	public void SnapTab() throws InterruptedException {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.Snap();
	}
	
	@Test(priority=4)
	public void ShopTab() {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.Shop();
	}

	@Test(priority=5)
	public void ActivitesTab() {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.Activites();
	}
	
	@Test(priority=6)
	public void InsuranceTab() {
		airasiaHomeAction = new AirAsiaHomeAction(driver);
		PageFactory.initElements(driver, AirAsiaHomeTest.class);
		airasiaHomeAction.Insurance();
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
