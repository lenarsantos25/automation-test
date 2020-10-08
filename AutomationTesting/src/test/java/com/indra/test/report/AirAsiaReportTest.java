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
import com.indra.test.AirAsiaHomeTest;
import com.indra.test.CheckinTest;
import com.indra.test.FlightStatusTest;
import com.indra.test.LoginTest;
import com.indra.test.MyBookingsTest;
import com.indra.test.SupportTest;
import com.indra.test.TravelNoticesAndPromotionsTest;
import com.indra.test.util.ConfigurationSetup;

public class AirAsiaReportTest extends ConfigurationSetup {

	public LoginTest loginTest;
	public MyBookingsTest myBookingsTest;
	public CheckinTest checkinTest;
	public FlightStatusTest flightStatusTest;
	public SupportTest supportTest;
	public AirAsiaHomeTest airAsiaHomeTest;
	public TravelNoticesAndPromotionsTest travelPromotionsTest;

	ExtentReports extent;
	ExtentTest exTest;
	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	@BeforeTest
	public void setupAutomationReport() {
		extent = ExtentManager.createInstance("AirAsiaAutomationReport.html");
		loginTest = new LoginTest();
		myBookingsTest = new MyBookingsTest();
		checkinTest = new CheckinTest();
		flightStatusTest = new FlightStatusTest();
		supportTest = new SupportTest();
		airAsiaHomeTest = new AirAsiaHomeTest();
		travelPromotionsTest = new TravelNoticesAndPromotionsTest();
	}

	@BeforeMethod
	public synchronized void getResultOnStart(Method method, ITestResult result) throws Exception {
		exTest = extent.createTest(method.getName());
		test.set(exTest);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			exTest.log(Status.INFO, result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			exTest.log(Status.INFO, result.getThrowable());
		}

		else {
			exTest.log(Status.INFO, "In onTestStart method: " + result.getMethod().getMethodName());
		}

		setup();
		launchURL();
	}

	@Test(priority = 1, enabled = true)
	public void airAsiaSignupPage() throws Exception {
		loginTest.signupPages(driver);
	}

	@Test(priority = 2, enabled = true)
	public void airAsiaLoginPage() throws Exception {
		loginTest.loginPages(driver);
	}

	@Test(priority = 3, enabled = true)
	public void airAsiaForgotPasswordPage() throws Exception {
		loginTest.forgotPassword(driver);
	}

	@Test(priority = 4, enabled = true)
	public void airAsiaFacebookLoginPage() throws Exception {
		loginTest.loginAsFacebook(driver);
	}

	@Test(priority = 5, enabled = true)
	public void airAsiaGoogleLoginPage() throws Exception {
		loginTest.loginAsGoogle(driver);
	}

	@Test(priority = 6, enabled = true)
	public void airAsiaWeChatLoginPage() throws Exception {
		loginTest.loginAsWeChat(driver);
	}

	@Test(priority = 7, enabled = true)
	public void myBookingsFlightTab() throws Exception {
		myBookingsTest.flightTabPage(driver);
	}

	@Test(priority = 8, enabled = true)
	public void myBookingsHotelTab() throws Exception {
		myBookingsTest.hotelTabPage(driver);
	}

	@Test(priority = 9, enabled = true)
	public void myBookingsRetrievePage() throws Exception {
		myBookingsTest.retrievePage(driver);
	}

	@Test(priority = 10, enabled = true)
	public void checkinPage() throws Exception {
		checkinTest.CheckinPages(driver);
	}

	@Test(priority = 11, enabled = true)
	public void flightStatusSearchByFlightNumber() throws Exception {
		flightStatusTest.searchByFlightNumber(driver);
	}

	@Test(priority = 12, enabled = true)
	public void flightStatusSearchByDestination() throws Exception {
		flightStatusTest.searchByDestination(driver);
	}

	@Test(priority = 13, enabled = true)
	public void supportPage() throws Exception {
		supportTest.supportPages(driver);
	}
	
	@Test(priority = 14, enabled = true)
	public void airAsiaHomeFlightsTab() throws Exception {
		airAsiaHomeTest.flightsTab(driver);
	}
	
	@Test(priority = 15, enabled = true)
	public void airAsiaHomeHotelTab() throws Exception {
		airAsiaHomeTest.hotelsTab(driver);
	}
	
	@Test(priority = 16, enabled = false)
	public void airAsiaHomeShopTab() throws Exception {
		airAsiaHomeTest.shopTab(driver);
	}
	
	@Test(priority = 17, enabled = true)
	public void airAsiaSnapTab() throws Exception {
		airAsiaHomeTest.snapTab(driver);
	}
	
	@Test(priority = 18, enabled = true)
	public void airAsiaActivities() throws Exception {
		airAsiaHomeTest.activitesTab(driver);
	}
	
	@Test(priority = 19, enabled = true)
	public void airAsiaInsurance() throws Exception {
		airAsiaHomeTest.insuranceTab(driver);
	}

	@AfterMethod
	public synchronized void getResultOnFinish(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			exTest.log(Status.INFO, result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			exTest.log(Status.INFO, result.getThrowable());
		}

		else {
			exTest.log(Status.PASS, "Test Passed");
		}

		extent.flush();

		closeAllTabs();
		exitDriver();
	}

	@AfterTest
	public void flushAutomationReport() {
		extent.flush();
	}
}
