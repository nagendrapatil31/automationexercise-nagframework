package dev.nagpat.automationexercise.listeners;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import dev.nagpat.automationexercise.utils.ScreenshotUtility;

public class DriverListener implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("BEFORE_NAVIGATING_TO_URL: '" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("AFTER_NAVIGATING_TO_URL: '" + url + "'");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("BEFORE_NAVIGATING_TO_PREVIOUS_PAGE");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("AFTER_NAVIGATING_TO_PREVIOUS_PAGE");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("BEFORE_NAVIGATING_TO_NEXT_PAGE");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("AFTER_NAVIGATING_TO_NEXT_PAGE");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("BEFORE_NAVIGATING_TO_REFRESH_PAGE");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("AFTER_NAVIGATING_TO_REFRESH_PAGE");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		// this extra code is remove noisy o/p '[[ChromeDriver: chrome on WINDOWS
		// (55205f9ffd973903aba6667a84dd2503)]'
		String elementInfo = by.toString();

		String locator = elementInfo.contains("->") ? elementInfo.split("->")[1].replace("]", "").trim() : elementInfo;

		System.out.println("TRYING_TO_FIND_ELEMENT_BY : " + locator);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		String elementInfo = by.toString();

		String locator = elementInfo.contains("->") ? elementInfo.split("->")[1].replace("]", "").trim() : elementInfo;

		System.out.println("FOUND_ELEMENT_BY : " + locator);
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		String elementInfo = element.toString();

		String locator = elementInfo.contains("->") ? elementInfo.split("->")[1].replace("]", "").trim() : elementInfo;

		System.out.println("TRYING_TO_CLICK_ON_ELEMENT : " + locator);
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		String elementInfo = element.toString();

		if (elementInfo.contains("->")) {
			String locator = elementInfo.substring(elementInfo.indexOf("->") + 2, elementInfo.length() - 1).trim();
			System.out.println("CLICKED_ON_ELEMENT : " + locator);
		} else {
			System.out.println("CLICKED_ON_ELEMENT : " + elementInfo);
		}
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("VALUE_OF_THE_ELEMENT : '" + element.toString() + "'" + " BEFORE_ANY_CHANGES_MADE");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("ELEMENT_VALUE_CHANGED_TO : '" + element.toString() + "'");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("BEFORE_SWITCH_TO_WINDOW : '" + windowName + "'");
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("AFTER_SWITCH_TO_WINDOW : '" + windowName + "'");
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("EXCEPTION_OCCURED: " + error);
		try {
			ScreenshotUtility.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("BEFORE GETTING TEXT FROM ELEMENT : '" + element.toString() + "'");
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("AFTER GETTING TEXT FROM ELEMENT : '" + element.toString() + "'");
	}

}
