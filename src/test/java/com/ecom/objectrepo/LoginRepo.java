
package com.ecom.objectrepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.utils.DriverClass;

public class LoginRepo extends DriverClass {

	public static LoginRepo loginRepo = null;

	// Page intialize
	public LoginRepo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create Singelton Class

	public static LoginRepo getInstance() {
		if (loginRepo == null) {
			loginRepo = new LoginRepo(DriverClass.driver);
		}
		return loginRepo;

	}

	@FindBy(id="email")
	public static WebElement email;

	@FindBy(id="pass")
	public static WebElement password;
	
	@FindBy(id="onetrust-accept-btn-handler")
	public static WebElement acceptAllCookies;
	
	@FindBy(xpath = "//button[contains(.,'Login')]")
	public static WebElement loginButton;
	
	@FindBy(xpath = "(//div[@class='box-content'])[1]")
	public static WebElement accountInformation;

	@FindBy(xpath = "//div[@class='dropdown-content']//child::a[text()='Sign Out']")
	public static WebElement signOut;

    @FindBy(xpath = "//a[@class='remind']//span[text()='Forgot Your Password?']")
	public static WebElement forgotPassword;
    
    //For Registration

	@FindBy(xpath = "//input[@id='email_address']")
	public static WebElement emailAddress;

	@FindBy(xpath = "//span[text()='Submit']")
	public static WebElement submitButton;

	@FindBy(xpath = "//a[text()='Register']")
	public static WebElement registerButton;

	@FindBy(xpath="//div[@class='control']//input[@name='firstname']")
	public static WebElement firstName;

	@FindBy(xpath="//div[@class='control']//input[@name='lastname']")
	public static WebElement lastName;
	
	@FindBy(xpath = "//div[@class='control']//input[@name='businessname']")
	public static WebElement businessName;
	
	@FindBy(xpath = "//input[@name='mobile_number']")
	public static WebElement mobileNumber;

	@FindBy(xpath = "//div[@class='control']//input[@name='email']")
	public static WebElement emailAddressRegisterPage;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement registerPassword;

	@FindBy(xpath = "//input[@id='password-confirmation']")
	public static WebElement passwordConfirmation;
    
    @FindBy(xpath = "//div[@role='alert']")
	public static WebElement errorMessage;
    
    @FindBy(xpath = "//div[@class='field choice gdpr required']//span")
   	public static WebElement privacyPolicyCheckbox;
    
    @FindBy(xpath = "//span[text()='Create Account']")
   	public static WebElement createAccount;
    
  
}
