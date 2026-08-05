package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.ProductsPage;

public class VerifyProductQuantityTest extends Base {

	private HomePage hPage;
	private ProductsPage pPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "Home Page is not visible");
		pPage = new ProductsPage(DriverManager.getDriver());
	}

	@Test
	public void VerifyProdQtyTest() {
		pPage.viewProduct();
		Assert.assertTrue(pPage.isProductDetailsPageVisibe(), "Product Details is not displayed");
		pPage.changeQuantity();
		pPage.addtoCart();
		pPage.viewCart();
		pPage.cartQty();
	}
	
	@AfterMethod
	public void exit() {
		tearDown();
	}
}
