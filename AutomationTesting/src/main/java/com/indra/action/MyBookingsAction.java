package com.indra.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.constants.CommonActions;
import com.indra.pages.MyBookingsPage;

public class MyBookingsAction extends MyBookingsPage {

	WebDriver driver;
	CommonActions commonAction = new CommonActions();
	
	public MyBookingsAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void flightTab() throws InterruptedException {
		commonCodes();
		commonAction.clickAction(departureCity);
		Thread.sleep(3000);
		commonAction.clickAction(departureComboBox);
		Thread.sleep(1000);
		commonAction.inputAction(bookingNumber, "234111");
		Thread.sleep(1000);
		commonAction.inputAction(lastName, "Sample surname");
		Thread.sleep(2000);
		commonAction.clickAction(submitBtn);
	}
	
	public void hotelTab() throws InterruptedException {
		commonCodes();
		commonAction.clickAction(hotelTab);
		Thread.sleep(3000);
		commonAction.inputAction(orderNumber, "112345");
		Thread.sleep(2000);
		commonAction.inputAction(lastName, "surname");
		Thread.sleep(2000);
		commonAction.inputAction(emailAddress, "test@gmail.com");
		Thread.sleep(3000);
		commonAction.clickAction(submitBtn);
	}
	
	public void retrieveBooking() throws InterruptedException {
		commonCodes();
		commonAction.clickAction(retrieveLinkText);
		Thread.sleep(3000);
		commonAction.inputAction(retrieveEmailId, "test@gmail.com");
		Thread.sleep(1000);
		commonAction.inputAction(retrievePassId, "password123");
		Thread.sleep(2000);
		commonAction.clickAction(submitButtonId);
	}
	
	private void commonCodes() {
		commonAction.clickAction(myBookingsTab);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for(String childTab: driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
	}
	
}
