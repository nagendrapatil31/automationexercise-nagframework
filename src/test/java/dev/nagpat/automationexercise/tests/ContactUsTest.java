package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.ContactUsPage;
import dev.nagpat.automationexercise.pages.HomePage;

public class ContactUsTest extends Base {

	private HomePage hPage;
	private ContactUsPage cPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		hPage.clickContactUsLink();
		cPage = new ContactUsPage(DriverManager.getDriver());
	}

	@Test
	public void contactUsFormFilling() throws InterruptedException {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\cody.jpg";
		cPage.ContactUsForm("nag", "pat@g", "testing", "testing- Contact us form", filePath);
		Assert.assertTrue(cPage.isSuccessMessageVisible());
		cPage.clickHomeButton();
		Assert.assertTrue(hPage.isHomepageVisible());
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}
}
