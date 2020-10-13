package com.indra.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.LoginAction;
import com.indra.test.util.ConfigurationSetup;


public class LoginTest extends ConfigurationSetup {
	LoginAction loginAction;

	@BeforeTest
	public void init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void browser() throws Exception {
		launchURL();
	}

	@Test(priority = 1, enabled=true)
	public WebDriver signupPages(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.signUpAirasia(readPropertyFile("email"), readPropertyFile("emailPassword"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 2, enabled=true)
	public WebDriver loginPages(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginAirasia(readPropertyFile("username"), readPropertyFile("password"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 3, enabled=true)
	public WebDriver forgotPassword(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.forgotPassword();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 4, enabled=true)
	public WebDriver loginAsFacebook(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginWithFacebook(readPropertyFile("facebookEmail"), readPropertyFile("facebookPass"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 5, enabled=true)
	public WebDriver loginAsGoogle(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginWithGoogle(readPropertyFile("googleEmail"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@Test(priority = 6, enabled=true)
	public WebDriver loginAsWeChat(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginWithWeChat();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	@AfterMethod
	public void closeTabs() {
		closeAllTabs();
	}

	@AfterTest
	public void quitDriver() {
		exitDriver();
	}

	
}
