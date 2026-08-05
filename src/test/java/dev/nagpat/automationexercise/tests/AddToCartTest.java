package dev.nagpat.automationexercise.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.CartPage;
import dev.nagpat.automationexercise.pages.HomePage;

public class AddToCartTest extends Base {

	private HomePage hPage;
	private CartPage cPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "HomePage is not Visible");
		hPage.clickProductsLink();
		cPage = new CartPage(DriverManager.getDriver());
	}

	@Test
	public void addCart() {
		cPage.hoverAndAddtoCart();
		Assert.assertTrue(cPage.areProductsAddedToCart(), "Products are not added to cart");
		
		List<String> names = cPage.getProductNames();
		Assert.assertTrue(names.size() >= 2, "Less products in cart");
		
		List<String> prices = cPage.getProductPrices();
		List<String> qty = cPage.getProductQuantities();
		List<String> totals = cPage.getProductTotals();
		System.out.println("Prices: " + prices);
		System.out.println("Qty: " + qty);
		System.out.println("Totals: " + totals);
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}
}
