package com.ecom.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;



public class LoginPage extends BaseStepInstance {

	public static LoginPage loginPageFunction;

	public static LoginPage getInstance() {
		if (loginPageFunction == null) {
			loginPageFunction = new LoginPage();
		}
		return loginPageFunction;

	}

	public static String randomNumber;
    private WebDriver driver;

	public void launchURL() throws InterruptedException {
		getCommonActionsInstance().navigateToURL("https://mcstaging.dezaan.com/customer/account/login/");
		getCommonActionsInstance().implicitWait(20);//50
		getCommonActionsInstance().add_Log_With_ScreenShot("Launched the URL Successfully");

	}

	public void login(String email, String password) throws InterruptedException {
		getCommonActionsInstance().sleep(8000);
		getCommonActionsInstance().sendKeysAction(getLoginRepoInstance().email, email);
		getCommonActionsInstance().sendKeysAction(getLoginRepoInstance().password, password);
		//getCommonActionsInstance().sleep(2000);
		getCommonActionsInstance().add_Log_With_ScreenShot("Entered the login credentials");

	}
	
}
