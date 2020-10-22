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
import com.indra.test.util.DataProviderClass;

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

	@Test(priority = 1, enabled = true, dataProvider = "getUsers", dataProviderClass = DataProviderClass.class)
	public void signupPages(DataProviderClass data) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.signUpAirasia(data.getEmail(), data.getEmailPass());
	}

	@Test(priority = 2, enabled = true, dataProvider = "getUsers", dataProviderClass = DataProviderClass.class)
	public void loginPages(DataProviderClass data) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginAirasia(data.getEmail(), data.getEmailPass());

	}

	@Test(priority = 3, enabled = true, dataProvider = "getUsers", dataProviderClass = DataProviderClass.class)
	public void forgotPassword(DataProviderClass data) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.forgotPassword(data.getEmail());
	}

	@Test(priority = 4, enabled = true)
	public void loginAsFacebook(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginWithFacebook(readPropertyFile("facebookEmail"), readPropertyFile("facebookPass"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 5, enabled = true)
	public void loginAsGoogle(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginWithGoogle(readPropertyFile("googleEmail"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 6, enabled = true)
	public void loginAsWeChat(WebDriver driver) throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.loginWithWeChat();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
