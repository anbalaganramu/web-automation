
package com.ecom.objectrepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class MainRepo extends DriverClass {

	public static MainRepo mainRepo = null;

	// Page intialize
	public MainRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static MainRepo getInstance() {
		if (mainRepo == null) {
			mainRepo = new MainRepo(DriverClass.driver);
		}
		return mainRepo;

	}
	
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	public static WebElement acceptCookie;
	
	@FindBy(xpath="(//a[@href='/about-us.html'])[1]")
	public static WebElement menu1;
	
	@FindBy(xpath="(//a[@href='/products-services.html'])[1]")
	public static WebElement menu2;
	
	@FindBy(xpath="//span[text()='Wood Products']")
	public static WebElement psWood;
	
	@FindBy(xpath="(//a[@href='/sustainability.html'])[1]")
	public static WebElement menu3;
	
	@FindBy(xpath="(//a[@href='/news.html'])[1]")
	public static WebElement menu4;
	
	@FindBy(xpath="(//a[@href='/careers.html'])[1]")
	public static WebElement menu5;
	
	@FindBy(xpath="//div[contains(@class,'metrics ')]")
	public static WebElement metrics_Comp;
	
	@FindBy(xpath="//div[contains(@class,'oga-metrics-ev__heading')]")
	public static WebElement metrics_Comp_Title;
	
	@FindBy(xpath="(//div[contains(@class,'textandimage')])[1]")
	public static WebElement textAssetComp1;
	
	@FindBy(xpath="(//div[contains(@class,'oga-text-image-ev__title')])[1]")
	public static WebElement textAssetComp1Title;
	
	@FindBy(xpath="//div[contains(@class,'productcarousel')]")
	public static WebElement productCarousel;
	
	@FindBy(xpath="//div[contains(@class,'oga-product-carousel-ev__title')]")
	public static WebElement productCarouselTitle;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[1]")
	public static WebElement productItem1;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[2]")
	public static WebElement productItem2;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[3]")
	public static WebElement productItem3;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[4]")
	public static WebElement productItem4;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[5]")
	public static WebElement productItem5;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[6]")
	public static WebElement productItem6;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[7]")
	public static WebElement productItem7;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[8]")
	public static WebElement productItem8;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[9]")
	public static WebElement productItem9;
	
	@FindBy(xpath="(//div[@class='oga-product-carousel-ev__product'])[10]")
	public static WebElement productItem10;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[1]")
	public static WebElement productItem1Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[2]")
	public static WebElement productItem2Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[3]")
	public static WebElement productItem3Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[4]")
	public static WebElement productItem4Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[5]")
	public static WebElement productItem5Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[6]")
	public static WebElement productItem6Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[7]")
	public static WebElement productItem7Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[8]")
	public static WebElement productItem8Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[9]")
	public static WebElement productItem9Title;
	
	@FindBy(xpath="(//div[contains(@class,'oga-product-carousel-ev__product-title')])[10]")
	public static WebElement productItem10Title;
	
	
//	
//
//	@FindBy(linkText="Cocoa Powders")
//	public static WebElement categoryCocoaPowders;
//	
//	@FindBy(xpath="//a[@class='logo']")
//	public static WebElement logo;
//    
//	@FindBy(xpath="(//button[contains(@class,'amsearch-button')])[1]")
//	public static WebElement searchIcon;
//    
//	@FindBy(xpath="//input[@name='q']")
//	public static WebElement searchTextBox;
//    
//	@FindBy(xpath="//div[contains(@class,'amsearch-related-terms')]/following::ol//a[@class='product-item-link']")
//	public static List<WebElement> searchResultProducts;
//    
//	@FindBy(xpath="(//div[@class='no-results']/div)[1]")
//	public static WebElement noSearchResult;
//	
//	@FindBy(xpath="(//span[contains(@class,'notlogin')]/a)[1]")
//	public static WebElement loginForPrice;
//	
//	@FindBy(xpath="//ul[@class='header links']")
//	public static WebElement profileIcon;
//	
//	@FindBy(xpath="//a[text()='My Account']")
//	public static WebElement myAccountLink;
//	
//	@FindBy(xpath="//input[@id='newsletter']")
//	public static WebElement newsLetterSignUpEmail;
//	
//	@FindBy(xpath="//span[text()='SIGN UP']")
//	public static WebElement newsLetterSignUpButton;
//	
//	@FindBy(xpath="//div[@id='subscribe-success']")
//	public static WebElement newsLetterSubscriptionSuccessMsg;
//	
//	@FindBy(xpath="//a[text()='Sign Out']")
//	public static WebElement signOutLink;
	
}
