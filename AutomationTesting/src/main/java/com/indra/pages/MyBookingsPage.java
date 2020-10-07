package com.indra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBookingsPage {

	@FindBy(xpath="(//div[contains(@class, 'navMenu-wrapper')]/ul/li/a)[1]")
	public WebElement myBookingsTab;
	
	@FindBy(id="input-lastName")
	public WebElement lastName;
	
	@FindBy(css="button[class='btn aasbw-button")
	public WebElement submitBtn;
	
	// FlightTab
	@FindBy(id="input-depCity")
	public WebElement departureCity;
	
	@FindBy(xpath="//div[@id='mat-autocomplete-0']//mat-option[@id='mat-option-3']")
	public WebElement departureComboBox;
	
	@FindBy(id="input-pnr")
	public WebElement bookingNumber;

	
	// HotelTab
	@FindBy(xpath="//div[@id='tabs-container']//div[2]")
	public WebElement hotelTab;
	
	@FindBy(id="input-orderNumber")
	public WebElement orderNumber;
	
	@FindBy(id="input-email")
	public WebElement emailAddress;
	
	// Retrieve
	@FindBy(linkText="Retrieve booking")
	public WebElement retrieveLinkText;
	
	@FindBy(id="unified-itin-emailId")
	public WebElement retrieveEmailId;
	
	@FindBy(id="unified-itin-password")
	public WebElement retrievePassId;
	
	@FindBy(id="unified-itin-submit-button")
	public WebElement submitButtonId;
}

