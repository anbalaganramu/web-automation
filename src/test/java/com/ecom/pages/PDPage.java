package com.ecom.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import com.ecom.utils.BaseStepInstance;
import com.ecom.utils.DriverClass;

import cucumber.api.DataTable;



public class PDPage extends BaseStepInstance {

	public static PDPage PDPage;

	public static PDPage getInstance() {
		if (PDPage == null) {
			PDPage = new PDPage();
		}
		return PDPage;

	}
	public static String randomNumber;
    private WebDriver driver;
    
    
    public void enterQuantity(String packageType, String quantity) {
    
    	WebElement element_qty = DriverClass.driver.findElement(By.xpath("(//td[@data-th='Packaging']/*[contains(text(),'"+packageType+"')]/following::td[@data-th='Quantity']//input)[1]"));
    	getCommonActionsInstance().scrollDownVerticalTo("250");
    	getCommonActionsInstance().clearAction(element_qty);
    	getCommonActionsInstance().sendKeysAction(element_qty, quantity);
    	getCommonActionsInstance().add_Log_With_ScreenShot("Entered Quantity in PD page");
    
    }
    
    public void clickAddToCart() throws InterruptedException {
    	
    	getCommonActionsInstance().verifyElementClickableThenClick(getPDPRepoInstance().addToCartButton);
    	//getCommonActionsInstance().clickAction(getPDPRepoInstance().addToCartButton);
    	
    }
    
    public void clickCheckoutNow() throws InterruptedException {
    	getCommonActionsInstance().add_Log_With_ScreenShot("Mini Cart");
    	getCommonActionsInstance().clickAfterJS(getPDPRepoInstance().checkoutNowButton);
    	getCommonActionsInstance().sleep(8000);
    }
    
    public void clickRequestASample() throws InterruptedException {
    	
    	getCommonActionsInstance().clickAction(getPDPRepoInstance().requestSampleButton);
    	getCommonActionsInstance().sleep(4000);
    	
    }
    
    public void verifyQtyAndPrice() {
    	
    	getCommonActionsInstance().add_Log_With_ScreenShot("Mini cart for sample order");
    	String qty = getCommonActionsInstance().getAttributeValue(getPDPRepoInstance().qtyTextBoxMiniCart, "data-item-qty");
    	Assert.assertEquals(qty, "1");
    	String price = getCommonActionsInstance().getText(getPDPRepoInstance().priceSample);
    	Assert.assertEquals(price, "USD 0.00");
    	
    }
    
    public void closeMiniCartPopUp() throws InterruptedException {
    	
    	getCommonActionsInstance().clickAfterJS(getPDPRepoInstance().closeMiniCartIcon);
    }
    
}

	