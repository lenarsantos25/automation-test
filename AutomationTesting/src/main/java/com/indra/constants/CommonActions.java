package com.indra.constants;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
	
	public void inputUsernameOrEmailAndPassword(WebElement user, String username, WebElement pass, String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
	}

	public void clickAction(WebElement element) {
		element.click();
	}

	public void inputAction(WebElement element, String keys) {
		element.sendKeys(keys);
	}
	
	public void waitUntilTheElementIsVisible(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickMultipleTimesAction(WebElement webElement, int times) {
		for(int i = 0; i < times; i++) {
			webElement.click();
		}
	}
	
	public void clearInputField(WebElement webElement) {
		webElement.sendKeys(Keys.BACK_SPACE);
	}
	
	public void switchWindow(WebDriver driver) {
		for(String child: driver.getWindowHandles()) {
			driver.switchTo().window(child);
		}
	}

}
