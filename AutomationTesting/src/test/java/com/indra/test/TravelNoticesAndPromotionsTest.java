package com.indra.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.TravelNoticesAndPromotionsAction;


public class TravelNoticesAndPromotionsTest extends ConfigurationSetup{
	TravelNoticesAndPromotionsAction tnpAction;

	@BeforeTest
	public void Init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void Browser() throws Exception {
		launchURL();
	}

	@Test(priority=1)
	public void FirstPromotionPage() throws InterruptedException {
		tnpAction = new TravelNoticesAndPromotionsAction(driver);
		PageFactory.initElements(driver, TravelNoticesAndPromotionsTest.this);
		tnpAction.FirstPromotion();
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
