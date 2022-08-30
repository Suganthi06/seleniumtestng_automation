package com.newtours.demoaut.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.newtours.demoaut.base.Browser;
import com.newtours.demoaut.pages.FlightBookPage;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;

public class TestFlightBookPage extends Browser {

	HomePage home;
	Utility util;
	LoginPage loginpage;
	RegistrationPage registration;
	FlightBookPage flightbook;
	String Sheet="Registration";

	
	public TestFlightBookPage() {
		super();
	}
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		registration= new RegistrationPage();
		loginpage= new LoginPage();
		home=loginpage.signIn((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
		flightbook = home.linkToFlights();
		//add assertions
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void TestFlightBooking() throws IOException {
		flightbook.bookFlight((util.getDataFromXL(Sheet, 5, 0)),(util.getDataFromXL(Sheet, 5, 1)),(util.getDataFromXL(Sheet, 5, 3)),(util.getDataFromXL(Sheet, 1, 0)),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 5, 4)),(util.getDataFromXL(Sheet, 5, 5)));
		Assert.assertEquals("Flight", "", "");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
