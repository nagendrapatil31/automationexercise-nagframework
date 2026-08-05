package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;

public class SubscriptionTest extends Base {

	private HomePage hPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
//		hPage.clickCartsLink(); // TestCase 11: this is to test subscription at Carts Page
	}

	@Test
	public void subsTest() {
		hPage.subscription("pat@g");
		String message = hPage.isSubscriptionSuccessMsgVisible();
		Assert.assertTrue(message.contains("successfully subscribed"),
				"Subscription success message not displayed properly");
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}
}
