package com.newtours.demoaut.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.newtours.demoaut.base.Browser;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;

public class TestHomePage extends Browser {
	HomePage home;
	Utility util;
	LoginPage loginpage;
	String Sheet="Registration";
	
	@BeforeTest
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		home=loginpage.signIn((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
	}
	
	@Test(priority=1)
	public void TestHomePageTitle() {
		String HomePageTitle= home.getHomePageTitle();
		Assert.assertEquals(HomePageTitle, "Welcome: Mercury Tours");
	}
	
	@Test(priority=2)
	public void TestHomePage() {
		home.isPageLoaded();
		//Add assertions
	}
	
	@Test(priority=3)
	public void TestFlightBooking() {
		home.linkToFlights();
		//add assertions
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
