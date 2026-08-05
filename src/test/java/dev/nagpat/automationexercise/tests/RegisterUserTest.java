package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.RegisterUserPage;

public class RegisterUserTest extends Base {
	
	private HomePage hPage;
	private RegisterUserPage rPage;


	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "HomePage is not Visible");
		hPage.clickSignupLink();
		rPage = new RegisterUserPage(DriverManager.getDriver());
	}

	@Test
	public void registration(){
		rPage.signup("nag", "pat@g");
		rPage.fillingAccountDetails("1234", "12", "4", "2000", "nag", "pat", "nagpat", "ads1", "ads2", "India",
				"kar", "beng", "12345", "1234567890");
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}

}
