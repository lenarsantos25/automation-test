package com.indra.action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.action.resources.CommonActions;
import com.indra.pages.AirAsiaHomePage;

public class AirAsiaHomeAction extends AirAsiaHomePage {
	
	WebDriver driver;
	CommonActions commonAction = new CommonActions();
	
	public AirAsiaHomeAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Flights() throws InterruptedException {
		commonAction.clickAction(flightTab);
		Thread.sleep(3000);
		commonAction.clickAction(fromRouteField);
		Thread.sleep(2000);
		commonAction.clearInputField(fromRouteField);
		Thread.sleep(2000);
		commonAction.inputAction(fromRouteField, "Manila (MNL)");
		Thread.sleep(2000);
		commonAction.inputAction(toRouteField, "Kuala Lumpur");
		Thread.sleep(2000);
		commonAction.clickAction(departureDateField);
		Thread.sleep(2000);
		commonAction.clickAction(departDateCalendar);
		Thread.sleep(2000);
		commonAction.clickAction(returnDateCalendar);
		Thread.sleep(2000);
		commonAction.inputAction(promoCodeField, "VA1234");
		Thread.sleep(2000);
		commonAction.clickAction(searchFlightBtn);
	}
	
	public void Hotels() throws InterruptedException {
		commonAction.clickAction(hotelTab);
		Thread.sleep(3000);
		commonAction.inputAction(destinationField, "Kuala Lumpur");
		Thread.sleep(2000);
		commonAction.clickAction(checkInField);
		Thread.sleep(2000);
		commonAction.clickAction(checkInDate);
		Thread.sleep(2000);
		commonAction.clickAction(checkoutDate);
		Thread.sleep(2000);
		commonAction.clickAction(confirmDate);
		Thread.sleep(2000);
		commonAction.clickAction(roomAdultComboBox);
		Thread.sleep(2000);
		commonAction.clickMultipleTimesAction(addAdult, 2);
		Thread.sleep(2000);
		commonAction.clickMultipleTimesAction(addChildren, 5);
		Thread.sleep(2000);
		commonAction.clickMultipleTimesAction(addInfant, 3);
		Thread.sleep(2000);
		commonAction.clickAction(addedDone);
		Thread.sleep(2000);
		commonAction.clickAction(searchButton);
	}
	
	public void Snap() throws InterruptedException {
		commonAction.clickAction(flightTab);
		Thread.sleep(3000);
		commonAction.clickAction(fromRouteField);
		Thread.sleep(2000);
		commonAction.clearInputField(fromRouteField);
		Thread.sleep(2000);
		commonAction.inputAction(fromRouteField, "Manila (MNL)");
		Thread.sleep(2000);
		commonAction.inputAction(toRouteField, "Kuala Lumpur");
		Thread.sleep(2000);
		commonAction.clickAction(departureDateField);
		Thread.sleep(2000);
		commonAction.clickAction(departDateCalendar);
		Thread.sleep(2000);
		commonAction.clickAction(returnDateCalendar);
		Thread.sleep(2000);
		commonAction.inputAction(promoCodeField, "VA1234");
		Thread.sleep(2000);
		commonAction.clickAction(searchFlightBtn);
	}
	
	public void Shop() {
		commonAction.clickAction(shopTab);
		for(String childTab: driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
		commonAction.inputAction(shopInputId, "test shop");
		shopInputId.sendKeys(Keys.ENTER);
	}
	
	public void Activites() {
		commonAction.clickAction(activitiesTab);
		commonAction.inputAction(activityField, "test activities");
		commonAction.clickAction(searchActivityButton);
	}
	
	public void Insurance() {
		commonAction.clickAction(insuranceTab);
	}
	
	public void Deals() {
		
	}
	
	
}
