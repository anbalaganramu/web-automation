package com.ecom.stepDefinitions;
import org.testng.Assert;

import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyAccountSteps extends BaseStepInstance {



	@Then("^Verify customer is navigated to My Account \"([^\"]*)\"$")
	public void Verify_customer_is_navigated_to_My_Account(String email) throws Throwable {
		//getCommonActionsInstance().implicitWait(60);
		getCommonActionsInstance().pageTitleValidation("My Account");
		getCommonActionsInstance().add_Log_With_ScreenShot("Landed in My Account page.");
		Assert.assertTrue(getCommonActionsInstance().getText(getLoginRepoInstance().accountInformation).contains(email));
	}

	//
	
	@When("^Click on Change Password link$")
	public void click_on_change_password() throws Throwable {
		getMyAccountPageInstance().clickChangePassword();
	}
	//
	@When("^Change Password and Save \"([^\"]*)\" \"([^\"]*)\"$")
	public void change_password_and_save(String oldPassword, String NewPassword) throws Throwable {
		getMyAccountPageInstance().changePasswordAndSave(oldPassword,NewPassword);
	}
	//
	
	@When("^Verify the new Address in Address Book \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_new_address(String city, String state) throws Throwable {
		getMyAccountPageInstance().verifyNewAddress(city,state);
	}
	//
	@When("^Delete an address from Address Book$")
	public void Delete_an_address_from_Address_Book(DataTable data) throws Throwable {
		getMyAccountPageInstance().deleteAddress(data);
	}

}
