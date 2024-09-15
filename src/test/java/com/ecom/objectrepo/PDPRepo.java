package com.ecom.objectrepo;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class PDPRepo extends DriverClass {
	
	public static PDPRepo PDPRepo = null;

	// Page intialize
	public PDPRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static PDPRepo getInstance() {
		if (PDPRepo == null) {
			PDPRepo = new PDPRepo(DriverClass.driver);
		}
		return PDPRepo;

	}
	
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	public static WebElement addToCartButton;

	@FindBy(xpath="//button[text()='CHECKOUT NOW']")
	public static WebElement checkoutNowButton;

	@FindBy(xpath="//span[text()='Request a Sample']")
	public static WebElement requestSampleButton;
	
	@FindBy(xpath="//ol[@id='mini-cart']//input")
	public static WebElement qtyTextBoxMiniCart;
			
	@FindBy(xpath="(//span[@class='price'])[1]")
	public static WebElement priceSample;
	
	@FindBy(xpath="//button[@id='btn-minicart-close']")
	public static WebElement closeMiniCartIcon;
	
}
