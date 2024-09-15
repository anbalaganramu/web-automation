package com.ecom.stepDefinitions;

import org.openqa.selenium.WebElement;

import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;



public class Cartpagesteps extends BaseStepInstance {
	
	
	@And("^Select shipping method$")
	public void select_shipping_method() throws Throwable {
	getCartPageInstance().selectShippingMethod();
	}
	
	@And("^Navigate to Payment page$")
	public void navigate_to_Payment_Page() throws Throwable {
	getCartPageInstance().clickContinueToPayment();
	}
	
	@And("^Select Payment option$")
	public void select_payment_option() throws Throwable {
	getCartPageInstance().selectOlamCreditPayment();
	}
	
	@And("^Place order$")
	public void Place_order() throws Throwable {
	getCartPageInstance().clickPlaceOrder();
	getCartPageInstance().printOrderNumber();
	}
	
	//
	@And("^Check for No Payment Option$")
	public void Check_for_No_Payment_Option() throws Throwable {
	getCartPageInstance().checkForNoPaymentOption();
	}
	
	@Then("^Verify the Error message \"([^\"]*)\"$")
	public void Verify_the_Error_message(String errorMessageExpected) throws Throwable {
		getCartPageInstance().verifyErrorMessage(errorMessageExpected);
		//getCommonActionsInstance().sleep(5000);clickCheckoutNow()
	}
	
	@Then("^Add another shipping address$")
	public void Add_another_shipping_address(DataTable dataTable) throws Throwable {
		getCartPageInstance().addAnotherShippingAddress(dataTable);
		//getCommonActionsInstance().sleep(5000);clickCheckoutNow()
	}
	//
	
	@Then("^Place order for Sample Order$")
	public void Place_order_for_Sample_Order() throws Throwable {
		getCartPageInstance().placeOrderForSampleOrder();
		getCartPageInstance().printOrderNumber();
		//getCommonActionsInstance().sleep(5000);clickCheckoutNow()
	}
	
}
