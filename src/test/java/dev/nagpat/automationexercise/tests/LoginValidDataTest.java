package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.LoginPage;

public class LoginValidDataTest extends Base {

	private HomePage hPage;
	private LoginPage lPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		hPage.clickSignupLink();
		lPage = new LoginPage(DriverManager.getDriver());
	}

	@Test
	public void login() {
		Assert.assertTrue(lPage.isLoginHeaderVisible());
		lPage.login("nagautomation@gmail.com", "Nag@1234");
		System.out.println("URL after login: " + DriverManager.getDriver().getCurrentUrl());
		Assert.assertTrue(lPage.isLoggedInAsVisible());
		lPage.logout();
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}

}
