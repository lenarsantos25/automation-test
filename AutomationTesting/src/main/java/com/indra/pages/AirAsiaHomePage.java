package com.indra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AirAsiaHomePage {

	@FindBy(xpath="(//div[contains(@class, 'css-1dbjc4n')]/input)[1]")
	public WebElement fromRouteField;
	
	@FindBy(xpath="(//div[contains(@class, 'css-1dbjc4n')]/input)[2]")
	public WebElement toRouteField;
	
	@FindBy(xpath="(//input[contains(@autocapitalize, 'sentences')])[3]")
	public WebElement departureDateField;
	
	@FindBy(xpath="(//div[contains(text(), '13')])[1]")
	public WebElement departDateCalendar;
	
	@FindBy(xpath="(//div[contains(text(), '13')])[2]")
	public WebElement returnDateCalendar;
	
	@FindBy(xpath="//input[contains(@placeholder, 'Promo code')]")
	public WebElement promoCodeField;
	
	@FindBy(id="aa-web-search-button")
	public WebElement searchFlightBtn;
	
	//Flights Tab
	@FindBy(xpath="//p[contains(text(), 'Flights')]")
	public WebElement flightTab;
	
	//Hotel Tab
	@FindBy(xpath="//p[contains(text(), 'Hotels')]")
	public WebElement hotelTab;
	
	@FindBy(xpath="(//input[contains(@autocapitalize, 'sentences')])[1]")
	public WebElement destinationField;
	
	@FindBy(xpath="(//input[contains(@autocapitalize, 'sentences')])[2]")
	public WebElement checkInField;
	
	@FindBy(xpath="(//div[contains(text(),'20')])[2]")
	public WebElement checkInDate;
	
	@FindBy(xpath="(//div[contains(text(),'4')])[4]")
	public WebElement checkoutDate;
	
	@FindBy(xpath="//div[contains(text(), 'Confirm')]")
	public WebElement confirmDate;
	
	@FindBy(xpath="//div[contains(text(), '1 Room')]")
	public WebElement roomAdultComboBox;
	
	@FindBy(xpath="(//div[contains(text(), '+')])[1]")
	public WebElement addAdult;
	
	@FindBy(xpath="(//div[contains(text(), '+')])[2]")
	public WebElement addChildren;
	
	@FindBy(xpath="(//div[contains(text(), '+')])[3]")
	public WebElement addInfant;
	
	@FindBy(xpath="//div[contains(text(), 'Done')]")
	public WebElement addedDone;
	
	@FindBy(xpath="(//div[contains(text(), 'Search')])[1]")
	public WebElement searchButton;
	
	// Snap tab
	@FindBy(xpath="//p[contains(text(), 'SNAP')]")
	public WebElement snapTab;
	
	// Shop tab
	@FindBy(xpath="//p[contains(text(), 'Shop')]")
	public WebElement shopTab;
	
	@FindBy(id="inputId")
	public WebElement shopInputId;
	
	// Activities tab
	@FindBy(xpath="//p[contains(text(), 'Activities')]")
	public WebElement activitiesTab;
	
	@FindBy(xpath="//input[contains(@placeholder, 'Search by activity or attraction')]")
	public WebElement activityField;
	
	@FindBy(xpath="(//div[contains(text(), 'Search')])[1]")
	public WebElement searchActivityButton;
	
	@FindBy(xpath="//p[contains(text(), 'Insurance')]")
	public WebElement insuranceTab;
	
	@FindBy(xpath="//p[contains(text(), 'Deals')]")
	public WebElement dealsTab;
	
	
}
