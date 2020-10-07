package com.indra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckinPage {

	@FindBy(xpath="(//div[contains(@class, 'navMenu-wrapper')]/ul/li/a)[2]")
	public WebElement checkInTab;
	
	@FindBy(id="bookingNumberInput")
	public WebElement bookingNumberId;
	
	@FindBy(id="surnameInput")
	public WebElement surnameId;
	
	@FindBy(xpath="//button[@pbutton='gtmBtnKey']")
	public WebElement searchBtn;
}
