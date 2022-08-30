package com.newtours.demoaut.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.newtours.demoaut.base.Browser;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;

public class TestRegistrationPage extends Browser {

	RegistrationPage register; 
	Utility util;
	LoginPage loginpage;
	
	String Sheet="Registration";
	@BeforeTest
	public void setup() {
		initialization();
		register= new RegistrationPage();
		loginpage= new LoginPage();
		util=new Utility();
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2)
	public void TestRegister() throws InterruptedException {
		register.registerUser(util.getDataFromXL(Sheet, 1, 0),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)),(util.getDataFromXL(Sheet, 1, 8)));
	}
	@Test(priority=1)
	public void TestRegistration() throws InterruptedException {
		register.isRegisterImagePresent();
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
}
