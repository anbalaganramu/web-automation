package com.ecom.utils;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.ecom.runner.RunnerClass;

import io.cucumber.java.AfterStep;
	import io.cucumber.java.Scenario;


	public class Hooks extends BaseStepInstance {


		@AfterStep
		public static void afterScenario(Scenario scenario) {
		 
		        {
		        	
		        	  String scenarioName = scenario.getName();
		        	  
		        	  //Images will not be retained when emailing the report
					  TakesScreenshot ts = (TakesScreenshot) RunnerClass.driver;
					  byte[] source = ts.getScreenshotAs(OutputType.BYTES); 
					  scenario.attach(source,"image/png",scenarioName);
					  
					  //Images will be retained when emailing the report if step fails
					  if(scenario.isFailed())
					  {
					  ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
					  }
					  
					  //Images will be retained when emailing the report if step fails
					  else {
					  ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
					  
					  }
		        }  
		        
		 
		}
		
		public static  String getBase64Screenshot()
		{
		    return ((TakesScreenshot) RunnerClass.driver).getScreenshotAs(OutputType.BASE64);
		}
		
	}
	



