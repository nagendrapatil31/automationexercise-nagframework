package dev.nagpat.automationexercise.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dev.nagpat.automationexercise.driver.DriverManager;
import dev.nagpat.automationexercise.factory.DriverFactory;
import dev.nagpat.automationexercise.listeners.DriverListener;
import dev.nagpat.automationexercise.listeners.TestNGListener;
import dev.nagpat.automationexercise.utils.ConfigReader;

public class Base {

	Properties prop;
	protected static EventFiringWebDriver eventFiringDriver;
	protected static DriverListener driverListener;
	protected static ExtentSparkReporter sparkReporter;
	protected static ExtentReports extentReports;
	protected static ExtentTest extentTest;
	protected static Logger logger = LogManager.getLogger(TestNGListener.class);

	public void setup() {

		prop = ConfigReader.initProp();
		DriverFactory.createDriver(prop.getProperty("browser"));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(prop.getProperty("url"));
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().deleteAllCookies();

		eventFiringDriver = new EventFiringWebDriver(DriverManager.getDriver());
		// now create object of driverListener to register it with
		// EventFiringWebDriver
		driverListener = new DriverListener();
		eventFiringDriver.register(driverListener);

		// adjust the code with DriverManager
		DriverManager.setDriver(eventFiringDriver);
	}

	protected static void tearDown() {
		DriverManager.quitDriver();
	}

}
