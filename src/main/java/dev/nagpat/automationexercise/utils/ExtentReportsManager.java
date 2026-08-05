package dev.nagpat.automationexercise.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import dev.nagpat.automationexercise.base.Base;

public class ExtentReportsManager extends Base {

	public static String EXTENT_REPORTS_PATH = System.getProperty("user.dir") + File.separator + "reports"
			+ File.separator + "Automation-Exercise-Framework-ExtentReports.html";

	public static ExtentReports getInstance() {
		if (extentReports == null) {
			createInstance();
		}
		return extentReports;
	}

	// Create an instance of ExtentReports
	private static ExtentReports createInstance() {
		sparkReporter = new ExtentSparkReporter(EXTENT_REPORTS_PATH);
		sparkReporter.config().setDocumentTitle("Automation Exercise Framework Test Report");
		sparkReporter.config().setReportName("Automation Exercise Framework Test Results By Sharan");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		extentReports.setSystemInfo("HostName", "RHEL8");
		extentReports.setSystemInfo("Sharan", "Sharan");
		return extentReports;
	}
}
