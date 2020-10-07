package com.indra.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.indra.action.LoginAction;


public class LoginTest extends ConfigurationSetup {
	LoginAction loginAction;

	@BeforeTest
	public void Init() throws Exception {
		setup();
	}

	@BeforeMethod
	public void Browser() throws Exception {
		launchURL();
	}

	@Test(priority = 1, enabled=true)
	public void SignupPages() throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.SignUpAirasia(readPropertyFile("email"), readPropertyFile("emailPassword"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 2, enabled=true)
	public void LoginPages() throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.LoginAirasia(readPropertyFile("username"), readPropertyFile("password"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 3, enabled=true)
	public void ForgotPassword() throws InterruptedException {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.ForgotPassword();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 4, enabled=true)
	public void LoginAsFacebook() throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.LoginWithFacebook(readPropertyFile("facebookEmail"), readPropertyFile("facebookPass"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 5, enabled=true)
	public void LoginAsGoogle() throws Exception {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.LoginWithGoogle(readPropertyFile("googleEmail"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 6, enabled=true)
	public void LoginAsWeChat() throws InterruptedException {
		loginAction = new LoginAction(driver);
		PageFactory.initElements(driver, LoginTest.class);
		loginAction.LoginWithWeChat();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void CloseTabs() {
		closeAllTabs();
	}

	@AfterTest
	public void ExitDriver() {
		exitDriver();
	}

}
