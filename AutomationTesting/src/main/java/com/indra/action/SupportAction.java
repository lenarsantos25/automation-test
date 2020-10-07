package com.indra.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.action.resources.CommonActions;
import com.indra.pages.SupportPage;

public class SupportAction extends SupportPage {

	WebDriver driver;
	CommonActions commonAction = new CommonActions();
	
	public SupportAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Support() throws InterruptedException {
		commonCodes();
		Thread.sleep(3000);
		commonAction.inputAction(searchBox, "Airport Tax");
		Thread.sleep(2000);
		commonAction.clickAction(searchButton);
	}
	private void commonCodes() {
		commonAction.clickAction(supportLinkText);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		for (String childTab : driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
	}
}
