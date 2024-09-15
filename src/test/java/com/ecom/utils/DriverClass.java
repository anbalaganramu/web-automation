package com.ecom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverClass {
	public static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		if (driver == null) {

			/*
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\test\\java\\Drivers\\chromedriver.exe");
			 */
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}

		return driver;
	}

	public static void quitdriver() {
		driver.close();

	}

	public static WebElement findElement(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
