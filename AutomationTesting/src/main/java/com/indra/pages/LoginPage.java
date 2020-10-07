package com.indra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id="loginModal")
	public WebElement loginSignUpButton;
	
	@FindBy(className="buttontop")
	public WebElement buttonTop;
	
	@FindBy(id="wzrk-confirm")
	public WebElement allowBtnId;
	
	@FindBy(id="sso-login-email-input")
	public WebElement usernameId;
	
	@FindBy(id="sso-login-password-input")
	public WebElement passwordId;
	
	@FindBy(xpath="(//button[contains(@class, 'sso-button')])[1]")
	public WebElement loginButton;
	
	@FindBy(id="sso-forgot-password-email-input")
	public WebElement forgotEmail;
	
	@FindBy(xpath="//form[contains(@class, 'ng-untouched')]/div/a")
	public WebElement forgotPass;
	
	@FindBy(xpath="(//div[contains(@class, 'sso-social-item')]/button)[1]")
	public WebElement loginWithFacebook;
	
	@FindBy(xpath="(//div[contains(@class, 'sso-social-item')]/button)[2]")
	public WebElement loginWithGoogle;
	
	@FindBy(xpath="(//div[contains(@class, 'sso-social-item')]/button)[3]")
	public WebElement loginWithWeChat;
	
	@FindBy(xpath="(//div[@class='tab-header']/ul/li)[2]")
	public WebElement signupTab;
	
	@FindBy(id="sso-signup-email-input")
	public WebElement emailId;
	
	@FindBy(id="sso-signup-password-input")
	public WebElement emailPassId;
	
	@FindBy(xpath="(//button[contains(@class, 'sso-button')])[2]")
	public WebElement signupButton;
	
	// Facebook
	@FindBy(id="email")
	public WebElement emailFbField;
	
	@FindBy(id="pass")
	public WebElement passFbField;
	
	@FindBy(id="loginbutton")
	public WebElement loginFbButton;
	
	// Google
	@FindBy(id="identifierId")
	public WebElement emailGoogleField;
}
