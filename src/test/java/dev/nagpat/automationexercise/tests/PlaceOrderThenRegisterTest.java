package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.CartPage;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.LoginPage;
import dev.nagpat.automationexercise.pages.RegisterUserPage;

public class PlaceOrderThenRegisterTest extends Base {

	private HomePage hPage;
	private CartPage cPage;
	private RegisterUserPage rPage;
	private LoginPage lPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "Home Page is not visible");
		cPage = new CartPage(DriverManager.getDriver());
		rPage = new RegisterUserPage(DriverManager.getDriver());
		lPage =  new LoginPage(DriverManager.getDriver());
	}

	@Test
	public void placeOrderTest() {
		hPage.hoverAndAddtoCart();
		Assert.assertTrue(cPage.isCartPageVisible(), "Cart Page is not visible");
		cPage.clickProceedToCheckOut();
		cPage.clickRegisterLoginLink();
		rPage.signup("nag", "pat@g");
		rPage.fillingAccountDetails("1234", "12", "4", "2000", "nag", "pat", "nagpat", "ads1", "ads2", "India",
				"kar", "beng", "12345", "1234567890");
		lPage.isLoggedInAsVisible();
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}

}
