package com.ecom.objectrepo;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class PLPRepo extends DriverClass {
	
	public static PLPRepo PLPRepo = null;

	// Page intialize
	public PLPRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static PLPRepo getInstance() {
		if (PLPRepo == null) {
			PLPRepo = new PLPRepo(DriverClass.driver);
		}
		return PLPRepo;

	}
	
	@FindBy(xpath="(//a[@title='List View'])[1]")
	public static WebElement listView;
	
	@FindBy(xpath="//ol[contains(@class,'product-items')]/li//div[@class='stock available']")
	public static WebElement stockStatus;

	@FindBy(xpath="//span[text()='Clear All']")
	public static WebElement clearAllLink;
	
	@FindBy(xpath="//input[@id='custom-sidebar-search']")
	public static WebElement searchFilter;
			
	@FindBy(xpath="(//select[@id='sorter'])[1]")
	public static WebElement sortingDropDown;
	
	@FindBy(xpath="(//ol[contains(@class,'product-items')]/li//a[@class='product-item-link'])[1]")
	public static WebElement plpFirstProduct;
		
	@FindBy(xpath="(//ol[contains(@class,'product-items')]/li//span[contains(@class,'notlogin')]/a)[1]")
	public static WebElement PricePLPFirstProduct;
			
	@FindBy(xpath="(//a[@title='Set Descending Direction'])[1]")
	public static WebElement setDescendingArrow;

	@FindBy(xpath="((//span[text()='Show'])[1]/following::select[@id='limiter'])")
	public static WebElement noOfItemsPerPageDropDown;

	@FindBy(xpath="(//ul[contains(@class,'pages-items')]//a[contains(@class,'next')])")
	public static WebElement nextIcon;

	@FindBy(xpath="(//ul[contains(@class,'pages-items')]//span[text()='1'])")
	public static WebElement PageNoOne;
			
	@FindBy(xpath="(//ol//a[@title='Add to Wish List'])[1]")
	public static WebElement firstFavoriteIcon;
	
	@FindBy(xpath="//div[contains(@class,'wishlist')]//span[text()='Remove']")
	public static WebElement removeButton;
	
	@FindBy(xpath="//span[text()='OK']")
	public static WebElement okButton;

	@FindBy(xpath="(//ol[contains(@class,'product-items')]//a)[1][contains(@class,'item-added')]")
	public static WebElement selectedFavoriteIcon;


}
