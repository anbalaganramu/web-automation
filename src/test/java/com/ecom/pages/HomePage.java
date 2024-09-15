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



public class HomePage extends BaseStepInstance {

	public static HomePage homePage;

	public static HomePage getInstance() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;

	}

	public void navigateToHomePage() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getHomeRepoInstance().logo);
	
	}
	
	public void navigateToCategoryPage(String category) throws InterruptedException {
		
		getCommonActionsInstance().clickAction(DriverClass.driver.findElement(By.xpath("//nav[@class='navigation']//a[contains(.,'"+category+"')]")));
		getCommonActionsInstance().sleep(5000);
	}
	
	public void clickSearchIcon() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getHomeRepoInstance().searchIcon);
	}

	public void searchWithValidTerm(String searchTerm) throws InterruptedException {
		
		getCommonActionsInstance().sendKeysAndHitEnter(getHomeRepoInstance().searchTextBox,searchTerm);
		getCommonActionsInstance().sleep(3000);
	}
	
	public void verifySearchResultForValidTerm(String searchTerm) {
		
		for(WebElement eachElement : getHomeRepoInstance().searchResultProducts) {
			String eachText = getCommonActionsInstance().getText(eachElement).trim();
			System.out.println(eachText);
			Assert.assertTrue(eachText.contains(searchTerm));
		}
		getCommonActionsInstance().add_Log_With_ScreenShot("Valid search results");
	}
	
	public void searchWithInValidTerm(String searchTerm) throws InterruptedException {
		
		getCommonActionsInstance().refreshPage();
		//WebElement searchIcon = DriverClass.driver.findElement(By.xpath("//input[@id='search']"));
		getCommonActionsInstance().clickAction(getHomeRepoInstance().searchIcon);
		getCommonActionsInstance().clearAction(getHomeRepoInstance().searchTextBox);
		getCommonActionsInstance().sendKeysAndHitEnter(getHomeRepoInstance().searchTextBox,searchTerm);
		getCommonActionsInstance().sleep(3000);
	}
	
	public void verifySearchResultForInValidTerm(String searchResultMessage) {
		
	String noResultMessage = getCommonActionsInstance().getText(getHomeRepoInstance().noSearchResult);
	System.out.println("Incorrect search result page message: "+noResultMessage);
	System.out.println("Expected incorrect message: "+searchResultMessage);
	Assert.assertTrue(noResultMessage.contains(searchResultMessage));
	getCommonActionsInstance().add_Log_With_ScreenShot("Invalid search term results");
		
	}
	
	public void navigateToMyAccountPage() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getHomeRepoInstance().profileIcon);
		getCommonActionsInstance().clickAction(getHomeRepoInstance().myAccountLink);
	}
	
	public void signupForNewsletter(String Email) throws InterruptedException {
		
		getCommonActionsInstance().sendKeysAction(getHomeRepoInstance().newsLetterSignUpEmail, Email);
		getCommonActionsInstance().clickAction(getHomeRepoInstance().newsLetterSignUpButton);
	}
	
	public void verifyNewsLetterSubscriptionSuccessMessage(String successMessage) {
		
		String successMessageActual = getCommonActionsInstance().getText(getHomeRepoInstance().newsLetterSubscriptionSuccessMsg);
		Assert.assertTrue(successMessageActual.contains(successMessage));
		getCommonActionsInstance().add_Log_With_ScreenShot("Newsletter subscribed");
	
	}
	
	public void clickSignOut() throws InterruptedException {
		
		getCommonActionsInstance().clickAction(getHomeRepoInstance().profileIcon);
		getCommonActionsInstance().clickAction(getHomeRepoInstance().signOutLink);
	}
	
	public void verifySignoutURL(String urlText) {
		
		String urlTextActual = getCommonActionsInstance().getPageURL();
		getCommonActionsInstance().add_Log_With_ScreenShot("Signed out from portal!");
		Assert.assertTrue(urlTextActual.contains(urlText));
	
	}
	
}
