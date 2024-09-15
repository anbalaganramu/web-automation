
package com.ecom.objectrepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class HomeRepo extends DriverClass {

	public static HomeRepo homeRepo = null;

	// Page intialize
	public HomeRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static HomeRepo getInstance() {
		if (homeRepo == null) {
			homeRepo = new HomeRepo(DriverClass.driver);
		}
		return homeRepo;

	}

	@FindBy(linkText="Cocoa Powders")
	public static WebElement categoryCocoaPowders;
	
	@FindBy(xpath="//a[@class='logo']")
	public static WebElement logo;
    
	@FindBy(xpath="(//button[contains(@class,'amsearch-button')])[1]")
	public static WebElement searchIcon;
    
	@FindBy(xpath="//input[@name='q']")
	public static WebElement searchTextBox;
    
	@FindBy(xpath="//div[contains(@class,'amsearch-related-terms')]/following::ol//a[@class='product-item-link']")
	public static List<WebElement> searchResultProducts;
    
	@FindBy(xpath="(//div[@class='no-results']/div)[1]")
	public static WebElement noSearchResult;
	
	@FindBy(xpath="(//span[contains(@class,'notlogin')]/a)[1]")
	public static WebElement loginForPrice;
	
	@FindBy(xpath="//ul[@class='header links']")
	public static WebElement profileIcon;
	
	@FindBy(xpath="//a[text()='My Account']")
	public static WebElement myAccountLink;
	
	@FindBy(xpath="//input[@id='newsletter']")
	public static WebElement newsLetterSignUpEmail;
	
	@FindBy(xpath="//span[text()='SIGN UP']")
	public static WebElement newsLetterSignUpButton;
	
	@FindBy(xpath="//div[@id='subscribe-success']")
	public static WebElement newsLetterSubscriptionSuccessMsg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	public static WebElement signOutLink;
	
}
