package com.ecom.stepDefinitions;
import org.openqa.selenium.WebElement;

import com.ecom.utils.BaseStepInstance;
import com.ecom.utils.CommonActions;

import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class PDPageSteps extends BaseStepInstance {

	@And("^Enter quantity for \"([^\"]*)\" quantity as \"([^\"]*)\"$")
	public void enter_qty(String packageType, String quantity) throws Throwable {
		getPDPageInstance().enterQuantity(packageType, quantity);
		//getCommonActionsInstance().sleep(5000);
	}

	@Then("^Add the product to Cart$")
	public void add_To_Cart() throws Throwable {
		getPDPageInstance().clickAddToCart();
		getCommonActionsInstance().sleep(6000);
	}
	
	@Then("^From mini cart click Checkout now$")
	public void proceed_to_checkout() throws Throwable {
		getPDPageInstance().clickCheckoutNow();
		//getCommonActionsInstance().sleep(5000);clickCheckoutNow()
	}
	
	@Then("^Clicks Request a Sample button$")
	public void Clicks_Request_a_Sample_button() throws Throwable {
		getPDPageInstance().clickRequestASample();
		getCommonActionsInstance().sleep(5000);//clickCheckoutNow()
	}
	
	@Then("^Verify quantity and price$")
	public void Verify_quantity_and_price() throws Throwable {
		getPDPageInstance().verifyQtyAndPrice();
		//getCommonActionsInstance().sleep(5000);clickCheckoutNow()
	}
	//
	@Then("^Close Mini Cart pop up$")
	public void Close_Mini_Cart_pop_up() throws Throwable {
		getPDPageInstance().closeMiniCartPopUp();
		//getCommonActionsInstance().sleep(5000);clickCheckoutNow()
	}
	//

}
