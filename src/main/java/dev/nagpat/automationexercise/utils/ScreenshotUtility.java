package dev.nagpat.automationexercise.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import dev.nagpat.automationexercise.base.Base;
import dev.nagpat.automationexercise.driver.DriverManager;

public class ScreenshotUtility extends Base {
	

	public static String takeScreenshotAtEndOfTest() throws IOException{

		// 3. Convert WebDriver instance to TakesScreenshot instance
		TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();

		// 4. Call getScreenshotAs() method to create image file
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		// 5. Store the file path in string variable
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String filePath = projectPath + File.separator 
				+ "screenshots" + File.separator 
				+ LocalDate.now() + "-"
				+ System.currentTimeMillis() + ".png";

		// 6. Move image file to new destination
		// Copy file at destination
		File destinationFile = new File(filePath);

		FileUtils.copyFile(sourceFile, destinationFile);
		System.out.println("SCREENSHOT_SAVED_AT: " + filePath);
		
		return filePath;
	}
}
