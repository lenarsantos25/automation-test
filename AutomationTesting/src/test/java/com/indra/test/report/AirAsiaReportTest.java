package com.indra.test.report;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.indra.test.ConfigurationSetup;
import com.indra.test.LoginTest;

public class AirAsiaReportTest extends ConfigurationSetup {

	ExtentReports extent;
	ExtentTest exTest;
	ThreadLocal test = new ThreadLocal();

	@BeforeTest
	public void beforeSuite() {
		extent = ExtentManager.createInstance("AirAsiaAutomationReport.html");
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method, ITestResult result) throws Exception {
		exTest = extent.createTest(method.getName());
		test.set(exTest);
		setup();
		launchURL();
	}

	@Test(priority = 1)
	public void AirAsiaSignup() throws Exception {
		LoginTest loginTest = new LoginTest();
		loginTest.SignupPages();
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			exTest.log(Status.INFO, result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			((ExtentTest) test.get()).skip(result.getThrowable());
		}

		else {
			((ExtentTest) test.get()).pass("Test passed");
		}

		extent.flush();
		closeAllTabs();
		exitDriver();
	}

	@AfterTest
	public void afterSuite() {
		extent.flush();
	}
}
