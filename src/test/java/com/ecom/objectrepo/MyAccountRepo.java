
package com.ecom.objectrepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class MyAccountRepo extends DriverClass {

	public static MyAccountRepo myAccountRepo = null;

	// Page intialize
	public MyAccountRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static MyAccountRepo getInstance() {
		if (myAccountRepo == null) {
			myAccountRepo = new MyAccountRepo(DriverClass.driver);
		}
		return myAccountRepo;

	}

	@FindBy(linkText="Cocoa Powders")
	public static WebElement categoryCocoaPowders;
	
	@FindBy(xpath="//a[contains(text(),'Change Your Password')]")
	public static WebElement changeYourPasswordLink;
	
	@FindBy(xpath="//input[@id='current-password']")
	public static WebElement currentPasswordTextBox;
    
	@FindBy(xpath="//input[@id='password']")
	public static WebElement newPasswordTextBox;
    
	@FindBy(xpath="//input[@id='password-confirmation']")
	public static WebElement confirmNewPasswordTextBox;
    
	@FindBy(xpath="//button[@title='Save Changes']")
	public static WebElement saveChangesButton;
	
	@FindBy(xpath="//table[contains(@class,'additional-addresses')]//tr[1]/td[@data-th='City']")
	public static WebElement newAddressCity;
	
	@FindBy(xpath="//table[contains(@class,'additional-addresses')]//tr[1]/td[@data-th='State']")
	public static WebElement newAddressState;
	
	@FindBy(xpath="//ul[@class='nav items']/li[.='Address Book']")
	public static WebElement menuAddressBook;
			
	@FindBy(xpath="(//span[text()='Delete'])[1]")
	public static WebElement delete;		
			
	@FindBy(xpath="(//span[text()='OK'])[1]")
	public static WebElement okButton;
	
	@FindBy(xpath="//p[@class='empty']")
	public static WebElement noAddress;
	
	
}
