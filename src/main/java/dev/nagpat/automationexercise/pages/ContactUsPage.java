package dev.nagpat.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dev.nagpat.automationexercise.base.BasePage;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	private By nameLocator = By.name("name");
	private By emailLocator = By.name("email");
	private By subjectLocator = By.name("subject");
	private By messageLocator = By.id("message");
	private By uploadFileLocator = By.name("upload_file");
	private By submitLocator = By.name("submit");
	private By successMessageLocator =
		    By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");
	private By HomeButtonLocator = By.xpath("//span[text()=' Home']");

	// Actions
	public void ContactUsForm(String name, String email, String subject, String message, String filePath) throws InterruptedException {
		utils.enterTxt(nameLocator, name);
		utils.enterTxt(emailLocator, email);
		utils.enterTxt(subjectLocator, subject);
		utils.enterTxt(messageLocator, message);
		utils.getElement(uploadFileLocator).sendKeys(filePath); // Works only for <input type="file"> | If it's a custom
																// button → different approach (rare)
		utils.click(submitLocator);
		utils.acceptAlert();
	}
	
	//adding this separate bcz of naivgation problem | NOT mix navigation + validation flow
	public void clickHomeButton() {
	    utils.click(HomeButtonLocator);
	}

	public boolean isSuccessMessageVisible() {
		Boolean flag = utils.isDisplayed(successMessageLocator);
		if (flag) {
			String SuccessMessage = utils.getText(successMessageLocator);
			System.out.println(SuccessMessage);
		} else {
			System.out.println("Message is NOT Displayed");
		}
		return flag;
	}
}
