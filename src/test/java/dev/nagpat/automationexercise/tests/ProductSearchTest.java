package dev.nagpat.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.pages.HomePage;
import dev.nagpat.automationexercise.pages.ProductsPage;

public class ProductSearchTest extends Base {

	private HomePage hPage;
	private ProductsPage pPage;

	@BeforeMethod
	public void init() {
		setup();
		hPage = new HomePage(DriverManager.getDriver());
		Assert.assertTrue(hPage.isHomepageVisible(), "HomePage is not Visible");
		hPage.clickProductsLink();
		pPage = new ProductsPage(DriverManager.getDriver());
		Assert.assertTrue(pPage.isProductsPageVisible(), "Products Page is not Visible");
	}

	@Test
	public void searchProdTest() {		
		pPage.searchProduct("Dress");
		Assert.assertTrue(pPage.isSearchedProductsVisible(), "Searched Products title not visible");
		Assert.assertTrue(pPage.areSearchResultsRelevant("Dress"), "Search results are not relevant");
	}

	@AfterMethod
	public void exit() {
		tearDown();
	}

}
