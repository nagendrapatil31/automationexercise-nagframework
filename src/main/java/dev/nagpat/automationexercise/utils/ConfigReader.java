package dev.nagpat.automationexercise.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public static Properties initProp() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}
}
