package dev.nagpat.automationexercise.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.nagpat.automationexercise.base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	private By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
	private By firstProductAddToCart = By.xpath(
			"(//div[@class='product-image-wrapper'])[1]//div[@class='product-overlay']//a[contains(@class,'add-to-cart')]");
	private By secondProduct = By.xpath("(//div[@class='product-image-wrapper'])[2]");
	private By secondProductAddToCart = By.xpath(
			"(//div[@class='product-image-wrapper'])[2]//div[@class='product-overlay']//a[contains(@class,'add-to-cart')]");
	private By ctnShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
	private By viewCartLink = By.xpath("//u[text()='View Cart']");
	private By cartProducts = By.xpath("//tr[contains(@id,'product')]");
	private By productNames = By.xpath("//td[@class='cart_description']//a");
	private By productPrices = By.xpath("//td[@class='cart_price']//p");
	private By productQuantities = By.xpath("//td[@class='cart_quantity']//button");
	private By productTotals = By.xpath("//td[@class='cart_total']//p");
	private By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");
	private By floatingAdClose = By.xpath("//button[contains(@class,'close')] | //div[@role='button']");
	private By RegisterLoginLink = By.xpath("//a/u[text()='Register / Login']");
	
	
	// Is cart page visible
	public boolean isCartPageVisible() {
		return driver.getCurrentUrl().equals("https://automationexercise.com/view_cart");
	}

	// Hover and add to cart
	public void hoverAndAddtoCart() {
		WebElement product1 = utils.getElement(firstProduct);
		utils.scrollToElementCentered(firstProduct);
		actions.moveToElement(product1).perform();
		utils.waitForElementVisible(firstProductAddToCart);
		utils.safeClick(firstProductAddToCart);
		utils.safeClick(ctnShoppingBtn);
		utils.handleAdPopup(floatingAdClose);
		WebElement product2 = utils.getElement(secondProduct);
		actions.moveToElement(product2).perform();
		utils.waitForElementVisible(secondProductAddToCart);
		utils.safeClick(secondProductAddToCart);
		utils.safeClick(viewCartLink);
	}

	// Click Proceed to Checkout
	public void clickProceedToCheckOut() {
		utils.safeClick(proceedToCheckoutButton);
	}

	// Click Register/Login link
	public void clickRegisterLoginLink() {
		utils.safeClick(RegisterLoginLink);
	}

	// Verify Both Products Added
	public boolean areProductsAddedToCart() {
		return utils.getElements(cartProducts).size() >= 2;
	}

	// get names
	public List<String> getProductNames() {
		List<String> names = new ArrayList<>();

		for (WebElement el : utils.getElements(productNames)) {
			names.add(el.getText());
		}

		return names;
	}

	// get prices
	public List<String> getProductPrices() {
		List<String> prices = new ArrayList<>();

		for (WebElement el : utils.getElements(productPrices)) {
			prices.add(el.getText());
		}

		return prices;
	}

	// get quantity
	public List<String> getProductQuantities() {
		List<String> qty = new ArrayList<>();

		for (WebElement el : utils.getElements(productQuantities)) {
			qty.add(el.getText());
		}

		return qty;
	}

	// get total
	// -- this total code doesn't give u total prices of all products but gives
	// total price of each product and will differ, when u change
	// quantities
	public List<String> getProductTotals() {
		List<String> totals = new ArrayList<>();

		for (WebElement el : utils.getElements(productTotals)) {
			totals.add(el.getText());
		}

		return totals;
	}

}
