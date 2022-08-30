package com.newtours.demoaut.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.demoaut.base.Browser;


public class HomePage extends Browser {
	
	@FindBy(xpath="//img[@src='/images/masts/mast_lightfinder.gif']")
	WebElement lblFlightFinder;
	
	@FindBy(xpath="//*[contains(text(),'SIGN-OFF')]")
	WebElement lnkSignOff;
	
	@FindBy(xpath="//a[contains(text(),'PROFILE')]")
	WebElement lnkProfile;
	
	
	@FindBy(xpath="//a[contains(text(),'ITINERARY')]")
	WebElement lnkItinerary;
	
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	WebElement lnkFlights;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void isPageLoaded() {
		lnkSignOff.isDisplayed();
		lnkItinerary.isDisplayed();
		lnkProfile.isDisplayed();
	}
	
	public FlightBookPage linkToFlights() {
		lnkFlights.click();
		return new FlightBookPage();
	}
	
}
