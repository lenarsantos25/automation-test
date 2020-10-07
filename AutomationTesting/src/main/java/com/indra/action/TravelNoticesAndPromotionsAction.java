package com.indra.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.action.resources.CommonActions;
import com.indra.pages.TravelNoticesAndPromotionsPage;

public class TravelNoticesAndPromotionsAction extends TravelNoticesAndPromotionsPage {
	WebDriver driver;
	CommonActions commonAction = new CommonActions();
	public TravelNoticesAndPromotionsAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void FirstPromotion() throws InterruptedException {
		String parent = driver.getWindowHandle();
		commonAction.clickAction(firstCard);
		Thread.sleep(3000);
		commonCodes(parent);
		commonAction.clickAction(secondCard);
		Thread.sleep(3000);
		commonCodes(parent);
		commonAction.clickAction(thirdCard);
		Thread.sleep(3000);
		commonCodes(parent);
		commonAction.clickAction(fourthCard);
		Thread.sleep(3000);
		commonCodes(parent);
	}

	private void commonCodes(String parent) {
		for (String childTab : driver.getWindowHandles()) {
			driver.switchTo().window(childTab);
		}
		driver.close();
		driver.switchTo().window(parent);
	}

}
