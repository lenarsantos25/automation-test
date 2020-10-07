package com.indra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupportPage {
	
	@FindBy(xpath="(//div[contains(@class, 'navMenu-wrapper')]/ul/li/a)[4]")
	public WebElement supportLinkText;
	
	@FindBy(xpath="//input[contains(@role, 'combobox')]")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[contains(text(), 'Search')]")
	public WebElement searchButton;
}
