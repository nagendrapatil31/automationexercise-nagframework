package dev.nagpat.automationexercise.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public static void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}
	
	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			tlDriver.remove();
		}
	}

}
