package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.ProductsPage;

public class ProductsTest extends Base {

	private HomePage hPage;
	private ProductsPage pPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "HomePage is not Visible");
		hPage.clickProductsLink();
		pPage = new ProductsPage(DriverManager.getDriver());
	}

	@Test
	public void pTest() {
		Assert.assertTrue(pPage.isProductsPageVisible(), "Products Page is not displayed");
		Assert.assertTrue(pPage.isProductsListVisible(), "Products List is not displayed");
		pPage.viewProduct();
		Assert.assertTrue(pPage.isProductDetailsPageVisibe(), "Product Details is not displayed");
		Assert.assertTrue(pPage.isProductNameVisible(), "Product Name is not displayed");
		Assert.assertTrue(pPage.isCategoryVisible(), "Product Category is not displayed");
		Assert.assertTrue(pPage.isPriceVisible(), "Product Price is not displayed");
		Assert.assertTrue(pPage.isAvailabilityVisible(), "Product Availability is not displayed");
		Assert.assertTrue(pPage.isConditionVisible(), "Product Condition is not displayed");
		Assert.assertTrue(pPage.isBrandvisible(), "Product Brand is not displayed");
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}

}
