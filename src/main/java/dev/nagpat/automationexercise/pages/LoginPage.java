package dev.nagpat.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dev.nagpat.automationexercise.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	private By loginHeaderLocator = By.xpath("//h2[text()='Login to your account']");
	private By emailLocator = By.xpath("//input[@data-qa='login-email']");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.xpath("//button[@data-qa='login-button']");
	private By loggedInAsLocator = By.xpath("//*[@id=\"header\"]//li[10]/a");
	private By loggedInName = By.xpath("//*[@id=\"header\"]//li[10]/a/b");
	private By deleteAccountLocator = By.xpath("//a[text()=' Delete Account']");
	private By continueLocator = By.xpath("//a[text()='Continue']");
	private By popup2Locator = By.xpath("//div[@class = 'continue-prompt-text']");
	private By deletedAccountTextLocator = By.xpath("//b[text()='Account Deleted!']");
	private By loginFailureMessageLocator = By.xpath("//p[text()='Your email or password is incorrect!']");
	private By logoutLinkLocator = By.xpath("//a[text()=' Logout']");
	
	
	//Actions
	public boolean isLoginHeaderVisible() {
		Boolean flag = utils.isDisplayed(loginHeaderLocator);
		if (flag) {
			System.out.println("Login header is visible");
		} else {
			System.out.println("Login header is NOT visible");
		}

		return flag;
	}

	public void login(String email, String password) {
		utils.enterTxt(emailLocator, email);
		utils.enterTxt(passwordLocator, password);
		utils.click(loginButtonLocator);
	}

	public boolean isLoginFailureMessageVisible() {
		Boolean flag = utils.isDisplayed(loginFailureMessageLocator);
		if (flag) {
			String FailureMessage = utils.getText(loginFailureMessageLocator);
			System.out.println(FailureMessage);
		} else {
			System.out.println("Message is NOT Displayed");
		}
		return flag;

	}
	
	public void logout() {
		utils.click(logoutLinkLocator);
	}

	public void deletingAccount() {
		utils.click(deleteAccountLocator);
		System.out.println("clicked on delete");
		utils.popupHandler(popup2Locator);
		System.out.println("clicked on cont2");
	}

	public void clickContinueAfterDelete() {
		utils.click(continueLocator);
	}

	public boolean isLoggedInAsVisible() {
		String username = utils.getText(loggedInName);
		Boolean flag = utils.isDisplayed(loggedInAsLocator);

		if (flag) {
			System.out.println("Logged in as:" + username + " is visible");
		} else {
			System.out.println("Username is NOT Displayed");
		}

		return flag;
	}

	public boolean isDeletedAccountVisible() {
		Boolean flag = utils.isDisplayed(deletedAccountTextLocator);

		if (flag) {
			System.out.println("Account is Deleted");
		} else {
			System.out.println("Message is NOT Displayed");
		}
		return flag;
	}

}
