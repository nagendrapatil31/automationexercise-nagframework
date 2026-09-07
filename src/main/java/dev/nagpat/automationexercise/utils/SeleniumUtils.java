package dev.nagpat.automationexercise.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;

	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.js = (JavascriptExecutor) driver;
	}

	// Generic methods below:

	// To find element
	public WebElement getElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// To find elements
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// Enter the Text
	public void enterTxt(By locator, String text) {
//		getElement(locator).clear();
		getElement(locator).sendKeys(text);
	}

	// Get the Text
	public String getText(By locator) {
		return getElement(locator).getText();
	}

	// wait for element clickable
	public WebElement waitForElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Click the WebElement
	public void click(By locator) {
		waitForElementClickable(locator).click();
	}

	// we are using Overloading concept for safeClick and creating 2 methods for
	// both parameters with and without 'adCloseLocator' parameter.
	// Safe Click: Overload Method 1
	public void safeClick(By locator, By adCloseLocator) {

		int attempts = 0;

		while (attempts < 3) {
			try {
				handleGoogleVignetteAd();

				if (adCloseLocator != null) {
					handleAdPopup(adCloseLocator);
				}

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				element.click();

				handleGoogleVignetteAd();

				return;

			} catch (Exception e) {

				System.out.println("Retrying click for: " + locator);

				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}

				try {
					WebElement element = driver.findElement(locator);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					return;
				} catch (Exception ex) {
				}
			}

			attempts++;
		}

		throw new RuntimeException("Unable to click element after retries: " + locator);
	}

	// Safe Click: Overload Method 2
	public void safeClick(By locator) {
		safeClick(locator, null);
	}

	// Waiting for URL details
	public void waitForUrlContains(String value) {
		wait.until(ExpectedConditions.urlContains(value));
	}

	// Select the Element
	public void selectElt(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	// Scroll using js
	public void scroll() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}

	// Scroll to ELement using js
	public void scrollToElement(By locator) {
		WebElement element = getElement(locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Scroll to Element Centered
	public void scrollToElementCentered(By locator) {
		WebElement element = getElement(locator);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	// js click (for tricky elements)
	public void jsClick(By locator) {
		WebElement element = getElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	// Highlight element during execution using js
	public void highlightElement(By locator) {
		WebElement element = getElement(locator);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// Alert Handling:

	// Accept alert
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	// Dismiss alert
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// Prompt Alert
	public void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// If no Alert is present
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	// Verify if WebElement is Displayed
	public boolean isDisplayed(By locator) {
	    try {
	        return getElement(locator).isDisplayed();
	    } catch (Exception e) {
	        System.out.println("Element not displayed: " + locator);
	        System.out.println("Reason: " + e.getMessage());
	        return false;
	    }
	}

	// Popup Handling
	public void popupHandler(By locator) {
		try {
			List<WebElement> elements = driver.findElements(locator);

			if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
				wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
				System.out.println("Popup closed");
			}

		} catch (Exception e) {
			System.out.println("Popup not handled, continuing...");
		}
	}

	// handling google_vignette ad
	public void handleGoogleVignetteAd() {
		if (driver.getCurrentUrl().contains("google_vignette")) {
			System.out.println("Ad detected → navigating back");
			driver.navigate().back();
		}
	}

	// Ad handling
	public void handleAdPopup(By closeBtnLocator) {

		List<WebElement> elements = getElements(closeBtnLocator);

		if (!elements.isEmpty()) {
			WebElement el = elements.get(0);

			if (el.isDisplayed()) {
				el.click();
				System.out.println("Ad popup closed");
			}
		}
	}

	// Ad Handling if it's within some frame
	public void HandleAdwithinFrame(By iframeLocator, By closeBtnLocator) {
		try {
			List<WebElement> frames = driver.findElements(iframeLocator);

			if (!frames.isEmpty()) {
				driver.switchTo().frame(frames.get(0));

				popupHandler(closeBtnLocator);

				driver.switchTo().defaultContent();
				System.out.println("Ad handled inside iframe");
			}

		} catch (Exception e) {
			System.out.println("No iframe ad found");
		}
	}

	public boolean waitForElementVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}

}
