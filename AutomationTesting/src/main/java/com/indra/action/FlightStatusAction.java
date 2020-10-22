package com.indra.action;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		DriverWait(driver, 10);
		commonAction.inputAction(flightNumber, "AK 6117");
//		Thread.sleep(2000);
		commonAction.clickAction(flightButton);
	}
	
	public void searchByRoute(String origin, String destination) throws InterruptedException {
		commonCodes();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonAction.clickAction(searchByRouteTab);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		commonAction.clickAction(originRoute);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		commonAction.inputAction(originField, origin);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		commonAction.inputAction(destinationField, destination);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		commonAction.clickAction(routeSearchButton);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	private void commonCodes() {
		commonAction.clickAction(flightStatusTab);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for(String childTab: driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
	}
	
	public void DriverWait(WebDriver driver, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
	}
}
