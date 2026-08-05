package dev.nagpat.automationexercise.factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dev.nagpat.automationexercise.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver createDriver(String browser) {

		WebDriver driver = null;

		if ("chrome".equalsIgnoreCase(browser)) {

			ChromeOptions options = new ChromeOptions();

			// Disables browser permission popups like like examples: “Allow notifications?”
			// “example.com wants to show notifications” ..etc
			options.addArguments("--disable-notifications");

			// Disables Infobars like “Chrome is being controlled by automated test
			// software”
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

			// Disables: Save password,Save address, Autofill popups
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false); // has to add this as "change password" was
																			// still popping up
			prefs.put("autofill.profile_enabled", false);

			options.setExperimentalOption("prefs", prefs);

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		}

		DriverManager.setDriver(driver);
		return DriverManager.getDriver();
	}
}
