package com.ecom.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;



public class MyAccountPage extends BaseStepInstance {

	public static MyAccountPage myAccountPageFunction;

	public static MyAccountPage getInstance() {
		if (myAccountPageFunction == null) {
			myAccountPageFunction = new MyAccountPage();
		}
		return myAccountPageFunction;

	}

	public static void navigateToHomePage() {
		
	}
	
	public void clickChangePassword() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getMyAccountRepoInstance().changeYourPasswordLink);
		getCommonActionsInstance().sleep(3000);
	}
	
	public void changePasswordAndSave(String oldPassword, String newPassword) throws InterruptedException {
		
		getCommonActionsInstance().sendKeysAction(getMyAccountRepoInstance().currentPasswordTextBox, oldPassword);
		getCommonActionsInstance().sendKeysAction(getMyAccountRepoInstance().newPasswordTextBox, newPassword);
		getCommonActionsInstance().sendKeysAction(getMyAccountRepoInstance().confirmNewPasswordTextBox, newPassword);
		getCommonActionsInstance().add_Log_With_ScreenShot("Changed the password");
		getCommonActionsInstance().clickAction(getMyAccountRepoInstance().saveChangesButton);
		getCommonActionsInstance().sleep(12000);
	}
	
	public void verifyNewAddress(String city, String state) throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getMyAccountRepoInstance().menuAddressBook);
		getCommonActionsInstance().sleep(3000);
		getCommonActionsInstance().add_Log_With_ScreenShot("In Address Book! New address is recorded");
		String cityActual = getCommonActionsInstance().getText(getMyAccountRepoInstance().newAddressCity);
		Assert.assertEquals(cityActual, city);
		String stateActual = getCommonActionsInstance().getText(getMyAccountRepoInstance().newAddressState);
		Assert.assertEquals(stateActual, state);
	}
	
	public void deleteAddress(DataTable message) throws InterruptedException {
		
		List<List<String>> values = message.raw();
		getCommonActionsInstance().clickAction(getMyAccountRepoInstance().delete);
		getCommonActionsInstance().clickAction(getMyAccountRepoInstance().okButton);
		getCommonActionsInstance().sleep(10000);
		String noAddressText = getCommonActionsInstance().getText(getMyAccountRepoInstance().noAddress);
		getCommonActionsInstance().add_Log_With_ScreenShot("Address has been deleted!");
		Assert.assertTrue(noAddressText.contains(values.get(1).get(1)));
	}

	
}
