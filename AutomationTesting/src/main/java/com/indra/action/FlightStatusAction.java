package com.indra.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.constants.CommonActions;
import com.indra.pages.FlightStatusPage;

public class FlightStatusAction extends FlightStatusPage{

	WebDriver driver;
	CommonActions commonAction = new CommonActions();
	
	public FlightStatusAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchFlightNumber() throws InterruptedException {
		commonCodes();
		Thread.sleep(3000);
		commonAction.inputAction(flightNumber, "AK 6117");
		Thread.sleep(2000);
		commonAction.clickAction(flightButton);
	}
	
	public void searchByRoute() throws InterruptedException {
		commonCodes();
		commonAction.clickAction(searchByRouteTab);
		Thread.sleep(2000);
		commonAction.clickAction(originRoute);
		Thread.sleep(2000);
		commonAction.clickAction(labelText);
		Thread.sleep(2000);
		commonAction.clickAction(labelText);
		Thread.sleep(2000);
		commonAction.clickAction(routeSearchButton);
	}
	
	private void commonCodes() {
		commonAction.clickAction(flightStatusTab);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for(String childTab: driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
	}
	
}
