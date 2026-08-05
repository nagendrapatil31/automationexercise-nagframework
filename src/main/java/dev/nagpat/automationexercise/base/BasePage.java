package dev.nagpat.automationexercise.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import dev.nagpat.automationexercise.utils.SeleniumUtils;

public class BasePage {

	protected WebDriver driver;
	protected SeleniumUtils utils;
	protected Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.utils = new SeleniumUtils(driver);
		this.actions = new Actions(driver);
	}

}
