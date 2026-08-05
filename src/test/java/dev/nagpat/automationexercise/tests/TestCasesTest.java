package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.TestCasesPage;

public class TestCasesTest extends Base {

	private HomePage hPage;
	private TestCasesPage tPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "HomePage is not Visible");
		hPage.clickTestCasesLink();
		tPage = new TestCasesPage(DriverManager.getDriver());
	}

	@Test
	public void tTest() {
		Assert.assertTrue(tPage.isTestCasesPageVisible(), "TestCases Page is not Visible");
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}
}
