package com.indra.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.constants.CommonActions;
import com.indra.pages.CheckinPage;
public class CheckinAction extends CheckinPage {
	WebDriver driver;
	CommonActions commonAction = new CommonActions();

	public CheckinAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void checkIn() throws InterruptedException {
		commonCodes();
		Thread.sleep(3000);
		commonAction.inputAction(bookingNumberId, "12345");
		Thread.sleep(3000);
		commonAction.inputAction(surnameId, "surname");
		Thread.sleep(2000);
		commonAction.clickAction(searchBtn);
	}

	private void commonCodes() {
		commonAction.clickAction(checkInTab);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for (String childTab : driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
	}

}
