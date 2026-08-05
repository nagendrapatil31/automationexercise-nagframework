package dev.nagpat.automationexercise.pages;

import org.openqa.selenium.WebDriver;

import dev.nagpat.automationexercise.base.BasePage;

public class TestCasesPage extends BasePage{
	
	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isTestCasesPageVisible() {
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl().equals("https://www.automationexercise.com/test_cases");	
	}
}
