package com.newtours.demoaut.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtours.demoaut.base.Browser;
import com.newtours.demoaut.utility.Utility;

public class FlightBookPage extends Browser {
	@FindBy(xpath="//input[@value='oneway']")
	WebElement btnOneWay;
	
	@FindBy(xpath="//img[@src='/images/masts/mast_lightfinder.gif']")
	WebElement lblFlightFinder;
	
	@FindBy(xpath="//input[@value='roundtrip']")
	WebElement btnRoundTrip;
	
	//service class type radio button
	@FindBy(xpath="//input[@value='Coach']")
	WebElement rdoCoach;
	
	@FindBy(xpath="//input[@value='Business']")  
	WebElement rdoBusiness;
	
	@FindBy(xpath="//input[@value='First']")  
	WebElement rdoFirstClass;
	
	@FindBy(xpath="//select[@name='fromMonth']")
    WebElement dtFrom;
	
	@FindBy(xpath="//select[@name='toMonth']")
    WebElement dtTo;
	
	@FindBy(xpath="//select[@name='fromDay']")
    WebElement dayFrom;
	
	@FindBy(xpath="//select[@name='toDay']")
    WebElement  dayTo;
	
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement lstFromPlace;
	
	@FindBy(xpath="//select[@name='toPort']")
	WebElement lstToPlace;
	
	@FindBy(xpath="//select[@name='airline']")
	WebElement lstAirlineType;
	
	@FindBy(xpath="//select[@name='passCount']")   
	WebElement lstNoPassengers;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement lnkContinue;
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement lblConfirm;
	
	@FindBy(xpath="//select[@name='pass.0.meal']")
	WebElement lstMealType;
	
	@FindBy(xpath="//input[@name='passFirst0']")
	WebElement lblFirstname;
	
	@FindBy(xpath="//input[@name='passLast0']")
	WebElement lblLastname;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement txtCard;
	
	@FindBy(xpath="//input[@src='/images/forms/purchase.gif']")
	WebElement txtSecure;

	Utility util = new Utility();
	public FlightBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void bookFlight(String source, String destination , String airline, String fName, String lName, String meal, String number) throws IOException {
		fillFirstPage(source, destination, airline);
		fillSecondPage(fName, lName, meal, number);
		driver.manage().timeouts().implicitlyWait(30 ,TimeUnit.SECONDS); 
		util.takeScreenshotAtEndOfTest();
	}

	private void fillSecondPage(String fName, String lName, String meal, String number) {
		lblFirstname.sendKeys(fName);
		lblLastname.sendKeys(lName);
		Select Meal_types= new Select(lstMealType);
		Meal_types.selectByVisibleText(meal);
		txtCard.sendKeys(number);
		txtSecure.click();
	}

	private void fillFirstPage(String source, String destination, String airline) {
		Select FromPlace= new Select(lstFromPlace);
		FromPlace.selectByVisibleText(source);
		Select Toplace= new Select(lstToPlace);
		Toplace.selectByVisibleText(destination);
		Select airlines= new Select(lstAirlineType);
		airlines.selectByVisibleText(airline);
		lnkContinue.click();
		lblConfirm.click();
	}
}
