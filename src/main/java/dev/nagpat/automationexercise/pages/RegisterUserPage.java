package dev.nagpat.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dev.nagpat.automationexercise.base.BasePage;

public class RegisterUserPage extends BasePage {

	public RegisterUserPage(WebDriver driver) {
		super(driver);
	}

	// signupLocators
	private By signupNameLocator = By.name("name");
	private By signupEmailLocator = By.xpath("//input[@data-qa ='signup-email']");
	private By signupButton = By.xpath("//button[text()='Signup']");

	// account-info Locators
	private By maleTitleLocator = By.id("id_gender1");
//	private By femaleTitleLocator = By.id("id_gender2");
	private By passwordLocator = By.id("password");
	private By dayLocator = By.id("days");
	private By monthLocator = By.id("months");
	private By yearLocator = By.id("years");
	private By newsLetterLocator = By.id("newsletter");
	private By specialOffersLocator = By.id("optin");
	private By firstnameLocator = By.id("first_name");
	private By lastnameLocator = By.id("last_name");
	private By companyLocator = By.id("company");
	private By address1Locator = By.id("address1");
	private By address2Locator = By.id("address2");
	private By countryLocator = By.id("country");
	private By stateLocator = By.id("state");
	private By cityLocator = By.id("city");
	private By zipcodeLocator = By.id("zipcode");
	private By mobileNoLocator = By.id("mobile_number");
	private By createAccountLocator = By.xpath("//button[text() = 'Create Account']");
	private By popup1Locator = By.xpath("//div[@class='grippy-host']");
	private By popup2Locator = By.xpath("//div[@class = 'continue-prompt-text']");
	private By continueLocator = By.xpath("//a[text()='Continue']");
	private By deleteAccountLocator = By.xpath("//a[text()=' Delete Account']");
	private By emailExistMessageLocator = By.xpath("//p[text()='Email Address already exist!']");

	// Actions
	public void signup(String name, String email) {
		utils.enterTxt(signupNameLocator, name);
		utils.enterTxt(signupEmailLocator, email);
		utils.popupHandler(popup1Locator);
		utils.safeClick(signupButton);
		System.out.println("URL after Signup click: " + driver.getCurrentUrl());
	}

	public void fillingAccountDetails(String password, String day, String month, String year, String firstname,
			String lastname, String company, String address1, String address2, String country, String state,
			String city, String zipcode, String mobileNo) {
		utils.safeClick(maleTitleLocator);
		utils.enterTxt(passwordLocator, password);
		utils.enterTxt(dayLocator, day);
		utils.enterTxt(monthLocator, month);
		utils.enterTxt(yearLocator, year);
		utils.safeClick(newsLetterLocator);
		utils.safeClick(specialOffersLocator);
		utils.enterTxt(firstnameLocator, firstname);
		utils.enterTxt(lastnameLocator, lastname);
		utils.enterTxt(companyLocator, company);
		utils.enterTxt(address1Locator, address1);
		utils.enterTxt(address2Locator, address2);
		utils.enterTxt(countryLocator, country);
		utils.enterTxt(stateLocator, state);
		utils.enterTxt(cityLocator, city);
		utils.enterTxt(zipcodeLocator, zipcode);
		utils.enterTxt(mobileNoLocator, mobileNo);
		utils.popupHandler(popup1Locator);
		utils.safeClick(createAccountLocator);
		utils.popupHandler(popup2Locator);
		utils.safeClick(continueLocator);
		System.out.println("clicked on cont1");
		utils.popupHandler(popup2Locator);
		utils.safeClick(deleteAccountLocator);
		System.out.println("clicked on delete");
		utils.popupHandler(popup2Locator);
		utils.safeClick(continueLocator);
		System.out.println("clicked on cont2");
	}

	public boolean isEmailAlreadyExistMessageVisible() {
		Boolean flag = utils.isDisplayed(emailExistMessageLocator);
		if (flag) {
			String EmailExistMessage = utils.getText(emailExistMessageLocator);
			System.out.println(EmailExistMessage);
		} else {
			System.out.println("Message is NOT Displayed");
		}
		return flag;
	}

}
