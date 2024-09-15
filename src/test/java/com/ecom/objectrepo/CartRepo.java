package com.ecom.objectrepo;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class CartRepo  extends DriverClass {

	public static CartRepo CartPageRepo = null;

	// Page intialize
	public CartRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static CartRepo getInstance() {
		if (CartPageRepo == null) {
			CartPageRepo = new CartRepo(DriverClass.driver);
		}
		return CartPageRepo;

	}
	
	
	//@FindBy(xpath = "//input[@value='shqups_GND']")
	@FindBy(xpath = "//input[@name='ko_unique_2']")
	public static WebElement upsGNDRadioButton;
	
	@FindBy(xpath = "//button[contains(.,'CONTINUE TO PAYMENT')]")
	public static WebElement continueToPaymentButton;
	
	@FindBy(xpath = "//input[@id='olamcredit']")
	public static WebElement olamCreditRadioButton;
	
	@FindBy(xpath = "//button[@title='Place Order' and @data-role='review-save']")
	public static WebElement placeOrderButton;
	
	@FindBy(xpath = "(//span[text()='Place Order'])[1]")
	public static WebElement placeOrderButtonforSampleOrder;
	
	@FindBy(xpath = "//div[@class='order-confirmation']//span[contains(text(),'Order #')]")
	public static WebElement orderNumber;
	
	//@FindBy(xpath = "//span[text()='No Payment Information Required']")
	//public static WebElement noPayment;
	
	@FindBy(xpath = "//div[@data-ui-id='checkout-cart-validationmessages-message-error']")
	public static WebElement spotSampleErrorMessage;
	
	@FindBy(xpath = "//span[text()='Add Another Address']")
	public static WebElement addAnotherAddress;
	
	@FindBy(xpath = "//input[@name='company']")
	public static WebElement companyTextBox;
	
	@FindBy(xpath = "//input[@name='telephone']")
	public static WebElement phoneNumberTextBox;
	
	@FindBy(xpath = "//input[@name='street[0]']")
	public static WebElement streetAddressTextBox;
	
	@FindBy(xpath = "//span[text()='Ship Here']")
	public static WebElement shipHereButton;
	
}
