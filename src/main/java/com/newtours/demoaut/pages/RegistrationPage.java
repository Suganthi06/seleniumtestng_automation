package com.newtours.demoaut.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtours.demoaut.base.Browser;
public class RegistrationPage extends Browser {

	@FindBy(xpath="//a[contains(text(),'REGISTER')] ")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[contains(text(),'sign-in')]")
	WebElement lnkSignin;
	
	@FindBy(xpath="//img[@src='/images/masts/mast_register.gif']")
	WebElement imgRegister;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//*[@id='userName']")
	WebElement txtUsername;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement txtConfirmPassword;

	@FindBy(xpath="//select[@name='country']")
	WebElement txtCountry;
	
	@FindBy(xpath="//input[@name='register']")
	WebElement txtRegister;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}  
		
	public boolean isRegisterImagePresent() {
		lnkRegister.click();
		return imgRegister.isDisplayed();
	}

	public LoginPage registerUser(String fName, String lName, String email, String password, String sltCountry) {
		lnkRegister.click();
		Select country = new Select(txtCountry);
		txtFirstname.sendKeys(fName);
		txtLastname.sendKeys(lName);
		txtUsername.sendKeys(email);
		country.selectByVisibleText(sltCountry);
		txtEmail.sendKeys(email);
		txtPwd.sendKeys(password);
		txtConfirmPassword.sendKeys(password);
		txtRegister.click();
		lnkSignin.click();
		return new LoginPage();		
	}
	
}
