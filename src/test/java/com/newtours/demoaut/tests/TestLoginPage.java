package com.newtours.demoaut.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.newtours.demoaut.base.Browser;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;


public class TestLoginPage extends Browser {

	Utility util;
	LoginPage loginpage;
	RegistrationPage registration;
	String Sheet="Registration";
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		util= new Utility();
		registration = new RegistrationPage();
		loginpage=registration.registerUser(util.getDataFromXL(Sheet, 1, 0),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)),(util.getDataFromXL(Sheet, 1, 8)));
	}

	@Test(priority = 1)
	public void TestLoginPage() {
		final String LoginPageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(LoginPageTitle, "Sign-on: Mercury Tours");
	}

	@Test(priority = 2)
	public void TestLoginImage() {
		loginpage.isLoginImgPresent();
	}

	@Test(priority = 3)
	public void TestLoginProcess() {
		loginpage.signIn((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
