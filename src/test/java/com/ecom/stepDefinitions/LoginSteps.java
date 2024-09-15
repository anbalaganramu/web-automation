package com.ecom.stepDefinitions;
import org.testng.Assert;

import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends BaseStepInstance {

	@Given("^Customer launches the website$")
	public void customer_enters_the_website() throws Throwable {
		getLoginPageInstance().launchURL();
	}

	

	@When("^Customer enters email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void customer_enters_email_as_and_password_as(String email, String password) throws Throwable {
		getLoginPageInstance().login(email, password);
	}

	@When("^Enters email registered address in the password reset link \"([^\"]*)\"$")
	public void enters_email_registered_address(String email) throws Throwable {
		getCommonActionsInstance().sendKeysAction(getLoginRepoInstance().emailAddress, email);
	}
	
	@Then("^Accept Cookies and Clicks login button$")
	public void accept_cookies_Clicks_login_button() throws Throwable {
		//getCommonActionsInstance().implicitWait(60);
		//getCommonActionsInstance().clickAction(getLoginRepoInstance().acceptAllCookies);
		getCommonActionsInstance().waitUntilElementVisibleThenClick(getLoginRepoInstance().acceptAllCookies);
		getCommonActionsInstance().clickAction(getLoginRepoInstance().loginButton);
		getCommonActionsInstance().implicitWait(8);
	}
	
	@Then("^Clicks login button$")
	public void Clicks_login_button() throws Throwable {
		//getCommonActionsInstance().implicitWait(60);
		//getCommonActionsInstance().clickAction(getLoginRepoInstance().acceptAllCookies);
		//getCommonActionsInstance().waitUntilElementVisibleThenClick(getLoginRepoInstance().acceptAllCookies);
		getCommonActionsInstance().clickAction(getLoginRepoInstance().loginButton);
		getCommonActionsInstance().implicitWait(8);
	}
	

}
