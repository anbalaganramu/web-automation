package com.ecom.runner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.aventstack.extentreports.service.ExtentService;
import com.ecom.utils.DriverClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
//@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features/001_Home.feature" }, glue = { "com.ecom.stepDefinitions" }, plugin = {
		"pretty:src\\Reports\\PrettyReport\\STDOUT", "html:src\\Reports\\PrettyReport\\install", "json:src\\Reports\\JSONReport\\cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags =  "@Home" )

//@LoginwithvalidCredentials,@Search
//@Sanity,@Rerun
//@LoginwithvalidCredentials,@PlaceSampleOrder,@SampleAndSportProductInSameCart,@SignOut,@HidePricingForGuestUser
public class RunnerClass extends AbstractTestNGCucumberTests {

	public static WebDriver driver;

	@BeforeTest
	public void initializeDriver() {
		DriverClass.getDriver("chrome");
	}

	@BeforeClass
	public void initializeReport() {
		/*
		 * ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		 * 
		 * String dateName = new SimpleDateFormat("dd_MM_YYY_hh.mm").format(new Date());
		 * extentProperties.setReportPath(
		 * "src/Reports/ExtendReports/USCocoaAutomationReport_" + dateName + ".html");
		 * extentProperties.setProjectName("testindo");
		 */
		System.out.println("Launch driver before class");
	}

	@AfterClass
	public void afterClass() {
		//Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		System.out.println("Report being generated");
		ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
		ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		ExtentService.getInstance().setSystemInfo("64 Bit", "Windows 10");
		ExtentService.getInstance().setSystemInfo("4.8.1", "Selenium");
		ExtentService.getInstance().setSystemInfo("11.0.11", "Java");
		ExtentService.getInstance().setSystemInfo("7.4.0", "TestNG");
		ExtentService.getInstance().setSystemInfo("3.8.5", "Maven");
		ExtentService.getInstance().addTestRunnerOutput("Cucumber TestNG Test Runner");

	}

	//
	@AfterSuite
	public void stopDriver() throws IOException {
		DriverClass.quitdriver();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}

}
