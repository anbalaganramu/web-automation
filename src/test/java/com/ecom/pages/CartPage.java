package com.ecom.pages;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;



public class CartPage extends BaseStepInstance {

	public static CartPage CartPageFunction;

	public static CartPage getInstance() {
		if (CartPageFunction == null) {
			CartPageFunction = new CartPage();
		}
		return CartPageFunction;

	}

	public static String number;
	public static int randomNumber;
	private WebElement streetAddress;
	
	public void selectShippingMethod() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getCartRepoInstance().upsGNDRadioButton);
		getCommonActionsInstance().sleep(5000);
		getCommonActionsInstance().add_Log_With_ScreenShot("Selected Shipping method");
	}
	
	public void selectShippingMethod(String shippingMethod) {
		
	}
	
	public void clickContinueToPayment() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getCartRepoInstance().continueToPaymentButton);
		getCommonActionsInstance().sleep(5000);
	}
	
	public void selectOlamCreditPayment() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getCartRepoInstance().olamCreditRadioButton);
		getCommonActionsInstance().sleep(5000);
		getCommonActionsInstance().add_Log_With_ScreenShot("Selected Olam Credit Payment");
	}
	
	public void clickPlaceOrder() throws InterruptedException {
		getCommonActionsInstance().clickAction(getCartRepoInstance().placeOrderButton);
	}
	
	public void placeOrderForSampleOrder() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getCartRepoInstance().placeOrderButtonforSampleOrder);
	}
	
	public void printOrderNumber() throws InterruptedException {//
		getCommonActionsInstance().sleep(20000);
		String orderNumber = getCommonActionsInstance().getText(getCartRepoInstance().orderNumber);
		System.out.println("Order is placed!, "+orderNumber);
		getCommonActionsInstance().add_Log_With_ScreenShot("Order has been placed! Order Number: "+orderNumber);
	}
	
	public void checkForNoPaymentOption() {
		
		boolean flag = getCommonActionsInstance().isDisplayed("//span[text()='No Payment Information Required']");
		getCommonActionsInstance().add_Log_With_ScreenShot("In Payment page.No payment options displayed");
		Assert.assertTrue(flag);
		//getCommonActionsInstance().add_Log_With_ScreenShot("In Payment page.No payment options displayed");
		
	}
	
    public void verifyErrorMessage(String errorMessageExpected) throws InterruptedException {
    	
    	getCommonActionsInstance().sleep(3000);
    	String errorMessageActual = getCommonActionsInstance().getText(getCartRepoInstance().spotSampleErrorMessage);
    	getCommonActionsInstance().add_Log_With_ScreenShot("Cart page showing error when adding spot product with sample product");
    	Assert.assertTrue(errorMessageActual.contains(errorMessageExpected));
    	
    }
    
    public void addAnotherShippingAddress(DataTable addressData) throws InterruptedException {
    	
    	String phoneNumber ="";
    	List<List<String>> addressDetails = addressData.raw();
    	getCommonActionsInstance().clickAction(getCartRepoInstance().addAnotherAddress);
    	getCommonActionsInstance().sendKeysAction(getCartRepoInstance().companyTextBox, addressDetails.get(1).get(1));
    	if(addressDetails.get(2).get(1).contains("random")) {
    		phoneNumber = String.valueOf(getCommonActionsInstance().randomNumber(5))+String.valueOf(getCommonActionsInstance().randomNumber(5));
    	}
    	getCommonActionsInstance().sendKeysAction(getCartRepoInstance().phoneNumberTextBox,phoneNumber);
    	getCommonActionsInstance().enterAndSelectFromSuggestionList(getCartRepoInstance().streetAddressTextBox,addressDetails.get(3).get(1));
    	getCommonActionsInstance().add_Log_With_ScreenShot("Adding new shipping address");
    	getCommonActionsInstance().clickAction(getCartRepoInstance().shipHereButton);
    	getCommonActionsInstance().sleep(3000);
    	
    }
	
	
}

	
	
	

	


