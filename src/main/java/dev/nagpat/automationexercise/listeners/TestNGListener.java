package dev.nagpat.automationexercise.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.utils.ExtentReportsManager;
import dev.nagpat.automationexercise.utils.ScreenshotUtility;

public class TestNGListener extends Base implements ITestListener {

	@Override
	public void onStart(ITestContext testContext) {
		String suiteName = testContext.getName();
		logger.info("SUITE_START: " + suiteName);
		extentReports = ExtentReportsManager.getInstance();
		}

	@Override
	public void onFinish(ITestContext testContext) {
		String suiteName = testContext.getName();
		logger.info("SUITE_FINISH: " + suiteName);
		extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult itr) {
		String testName = itr.getName();
		logger.info("TEST_START: " + testName);
		extentTest =extentReports.createTest(testName);
	}

	@Override
	public void onTestSuccess(ITestResult itr) {
		String testName = itr.getName();
		logger.info("SUITE_SUCCESS: " + testName);
		extentTest.log(Status.PASS, MarkupHelper.createLabel(testName + " - TEST_CASE_PASS", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult itr) {
		String testName = itr.getName();
		logger.error("SUITE_FAILURE: " + testName);
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(testName + " - TEST_CASE_FAILURE", ExtentColor.RED));
		
		Throwable error = itr.getThrowable();
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(error + " - TEST_CASE_FAILURE", ExtentColor.RED));
		try {
			String screenshotPath = ScreenshotUtility.takeScreenshotAtEndOfTest();
			extentTest.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestSkipped(ITestResult itr) {
		String testName = itr.getName();
		logger.warn("SUITE_SKIPPED: " + testName);
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(testName + " - TEST_CASE_SKIP", ExtentColor.ORANGE));

		try {
			String screenshotPath = ScreenshotUtility.takeScreenshotAtEndOfTest();
			extentTest.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
