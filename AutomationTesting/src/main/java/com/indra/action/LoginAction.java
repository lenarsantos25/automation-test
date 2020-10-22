package com.indra.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.indra.constants.CommonActions;
import com.indra.pages.LoginPage;
public class LoginAction extends LoginPage {

	WebDriver driver;

	CommonActions commonAction = new CommonActions();
	
	public LoginAction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signUpAirasia(String email, String password) throws InterruptedException {
		commonAction.waitUntilTheElementIsVisible(driver, buttonTop, 10);
		if (!buttonTop.isDisplayed()) {
			loginSignUpButton.click();
		} else {
			buttonTop.click();
		}
		commonAction.clickAction(signupTab);
		Thread.sleep(3000);
		commonAction.inputUsernameOrEmailAndPassword(emailId, email, emailPassId, password);
		Thread.sleep(2000);
		commonAction.clickAction(signupButton);
		Thread.sleep(2000);
	}

	public void loginAirasia(String username, String pass) throws InterruptedException {
		commonAction.waitUntilTheElementIsVisible(driver, buttonTop, 10);
		if (!buttonTop.isDisplayed()) {
			loginSignUpButton.click();
		} else {
			buttonTop.click();
		}
		commonAction.inputUsernameOrEmailAndPassword(usernameId, username, passwordId, pass);
		Thread.sleep(2000);
		commonAction.clickAction(loginButton);
		Thread.sleep(2000);
	}

	public void forgotPassword(String email) throws InterruptedException {
		commonAction.waitUntilTheElementIsVisible(driver, buttonTop, 10);
		if (!buttonTop.isDisplayed()) {
			loginSignUpButton.click();
		} else {
			buttonTop.click();

		}

		commonAction.clickAction(forgotPass);
		Thread.sleep(3000);
		commonAction.inputAction(forgotEmail, email);
		Thread.sleep(2000);
		commonAction.clickAction(loginButton);
		Thread.sleep(2000);

	}

	public void loginWithFacebook(String email, String pass) throws Exception {
		commonAction.waitUntilTheElementIsVisible(driver, buttonTop, 10);
		if (!buttonTop.isDisplayed()) {
			loginSignUpButton.click();
		} else {
			buttonTop.click();

		}
		commonAction.clickAction(loginWithFacebook);
		Thread.sleep(5000);
		commonAction.switchWindow(driver);
		commonAction.inputAction(emailFbField, email);
		Thread.sleep(1000);
		commonAction.inputAction(passFbField, pass);
		Thread.sleep(2000);
		commonAction.clickAction(loginFbButton);
		Thread.sleep(3000);
		
	}

	public void loginWithGoogle(String email) throws Exception {
		commonAction.waitUntilTheElementIsVisible(driver, buttonTop, 10);
		if (!buttonTop.isDisplayed()) {
			loginSignUpButton.click();
		} else {
			buttonTop.click();

		}
		commonAction.clickAction(loginWithGoogle);
		Thread.sleep(5000);
		commonAction.switchWindow(driver);
		commonAction.inputAction(emailGoogleField, email);
		Thread.sleep(3000);
	}

	public void loginWithWeChat() throws InterruptedException {
		commonAction.waitUntilTheElementIsVisible(driver, buttonTop, 10);
		if (!buttonTop.isDisplayed()) {
			loginSignUpButton.click();
		} else {
			buttonTop.click();

		}
		commonAction.clickAction(loginWithWeChat);
		Thread.sleep(5000);
	}
}
