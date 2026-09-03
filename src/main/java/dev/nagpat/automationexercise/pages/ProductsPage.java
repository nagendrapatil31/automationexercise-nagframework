package dev.nagpat.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dev.nagpat.automationexercise.base.BasePage;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	private By viewProduct1Locator = By.xpath("//a[@href='/product_details/1']");
	private By SearchProductLocator = By.name("search");
	private By SearchButtonLocator = By.id("submit_search");
	private By SearchedProductsNames = By.xpath("//div[@class='productinfo text-center']/p");
	private By productsListLocator = By.xpath("//div[@class='features_items']");
	private By productNameLocator = By.xpath("//div[@class='product-information']/h2");
	private By categoryLocator = By.xpath("//div[@class='product-information']/p[1]");
	private By priceLocator = By.xpath("//div[@class='product-information']/span/span");
	private By availabilityLocator = By.xpath("//div[@class='product-information']/p[2]/b");
	private By conditionLocator = By.xpath("//div[@class='product-information']/p[3]/b");
	private By brandLocator = By.xpath("//div[@class='product-information']/p[4]/b");
	private By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
	private By qauntityLocator = By.xpath("//input[@id='quantity']");
//	private By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
	private By firstProductAddToCart = By.xpath("//button[normalize-space()='Add to cart']");
	private By viewCartLink = By.xpath("//u[text()='View Cart']");
	private By cartQuantity = By.xpath("//td[@class='cart_quantity']//button");

	// Actions
	public void viewProduct() {
		utils.scrollToElementCentered(viewProduct1Locator);
		utils.safeClick(viewProduct1Locator);
		System.out.println("URL after clicking product: " + driver.getCurrentUrl());
		utils.waitForUrlContains("product_details");
	}

	public void searchProduct(String text) {
		utils.enterTxt(SearchProductLocator, text);
		utils.safeClick(SearchButtonLocator);
	}

	public void addtoCart() {
		utils.safeClick(firstProductAddToCart);
	}

	public void viewCart() {
		utils.safeClick(viewCartLink);
	}

	public boolean isSearchedProductsVisible() {
		return utils.waitForElementVisible(searchedProductsTitle);
	}

	// ***start
	// First: Get all product names
	public List<WebElement> getAllProductNames() {
		return driver.findElements(SearchedProductsNames);
	}
	
	// Then: Validate each product
	public boolean areSearchResultsRelevant(String searchText) {

		boolean matchFound = false;
		List<WebElement> products = getAllProductNames();

		for (WebElement product : products) {
			String name = product.getText().toLowerCase();
			System.out.println("Product found: " + name);

			if (name.contains(searchText.toLowerCase())) {
				matchFound = true;
			}
		}
		return matchFound;
	} // ***end

	public boolean isProductsPageVisible() {
		return driver.getCurrentUrl().equals("https://www.automationexercise.com/products");
	}

	// Verifying Product List
	public boolean isProductsListVisible() {
		return utils.isDisplayed(productsListLocator);
	}

	// Verifying Product Details Page
	public boolean isProductDetailsPageVisibe() {
		return driver.getCurrentUrl().contains("product_details");
	}

	// Verifying Products Details
	public boolean isProductNameVisible() {
		return utils.isDisplayed(productNameLocator);
	}

	public boolean isCategoryVisible() {
		return utils.isDisplayed(categoryLocator);
	}

	public boolean isPriceVisible() {
		return utils.isDisplayed(priceLocator);
	}

	public boolean isAvailabilityVisible() {
		return utils.isDisplayed(availabilityLocator);
	}

	public boolean isConditionVisible() {
		return utils.isDisplayed(conditionLocator);
	}

	public boolean isBrandvisible() {
		return utils.isDisplayed(brandLocator);
	}

	// Handling quantity
	public void changeQuantity() {
		WebElement qty = utils.getElement(qauntityLocator);
		qty.clear();
		qty.sendKeys("4");
	}

	// Checking quantity
	public void cartQty() {
		String actualQty = utils.getElement(cartQuantity).getText();
		Assert.assertEquals(actualQty, "4", "Quantity is not Matching");
		System.out.println("Product Quantity:" + actualQty);
	}
}
