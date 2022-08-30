package com.newtours.demoaut.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.demoaut.base.Browser;

public class LoginPage extends Browser {
	
	@FindBy(xpath="//input[@name='login']")
	WebElement btnSignIn;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	@FindBy(xpath="//img[@src='/images/masts/mast_signon.gif']")
	WebElement imgLogin;
	
	public LoginPage() {
		  PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void isLoginImgPresent() {
		imgLogin.isDisplayed();
	}

	public HomePage signIn(String username, String Password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(Password);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnSignIn);
		return new HomePage();
	}
}
