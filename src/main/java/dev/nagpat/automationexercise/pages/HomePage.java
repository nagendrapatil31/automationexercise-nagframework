package dev.nagpat.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.nagpat.automationexercise.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	private By productsLinkLocator = By.xpath("//a[text()=' Products']");
	private By CartsLinkLocator = By.xpath("//*[text()=' Cart']");
	private By signupLinkLocator = By.xpath("//a[text() = ' Signup / Login']");
	private By contactUsLinkLocator = By.xpath("//a[text()=' Contact us']");
	private By testCasesLinkLocator = By.xpath("//a[text()=' Test Cases']");
	private By subscriptionLocator = By.id("susbscribe_email");
	private By subscribebutton = By.id("subscribe");
	private By successMsg = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");
	private By adpopup = By.xpath("//*[@id=\"dismiss-button-element\"]/div");

	private By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
	private By firstProductAddToCart = By.xpath(
			"(//div[@class='product-image-wrapper'])[1]//div[@class='product-overlay']//a[contains(@class,'add-to-cart')]");
	private By secondProduct = By.xpath("(//div[@class='product-image-wrapper'])[2]");
	private By secondProductAddToCart = By.xpath(
			"(//div[@class='product-image-wrapper'])[2]//div[@class='product-overlay']//a[contains(@class,'add-to-cart')]");
	private By ctnShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
	private By viewCartLink = By.xpath("//u[text()='View Cart']");
	private By floatingAdClose = By.xpath("//button[contains(@class,'close')] | //div[@role='button']");

	public boolean isHomepageVisible() {
		 System.out.println("Current URL: " + driver.getCurrentUrl());
		return driver.getCurrentUrl().equals("https://www.automationexercise.com/");
	}

	public void closeAd() {
		utils.handleAdPopup(adpopup);
	}

	public void clickProductsLink() {
		utils.safeClick(productsLinkLocator);
	}

	public void clickCartsLink() {
		utils.safeClick(CartsLinkLocator);
	}

	public void clickSignupLink() {
		utils.safeClick(signupLinkLocator);
	}

	public void clickContactUsLink() {
		utils.safeClick(contactUsLinkLocator);
	}

	public void clickTestCasesLink() {
		utils.safeClick(testCasesLinkLocator);
	}

	public void subscription(String text) {
		utils.scrollToElementCentered(subscriptionLocator);
		utils.enterTxt(subscriptionLocator, text);
		utils.safeClick(subscribebutton);
	}

	public String isSubscriptionSuccessMsgVisible() {
		try {
			WebElement msg = new WebDriverWait(driver, 5)
					.until(ExpectedConditions.visibilityOfElementLocated(successMsg));

			String text = msg.getText();
			System.out.println("Success Message: " + text);
			return text;
		} catch (Exception e) {
			System.out.println("❌ Success message not found");
			return null;
		}
	}

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
}
