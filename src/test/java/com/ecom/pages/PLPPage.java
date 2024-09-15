package com.ecom.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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



public class PLPPage extends BaseStepInstance {

	public static PLPPage PLPPage;

	public static PLPPage getInstance() {
		if (PLPPage == null) {
			PLPPage = new PLPPage();
		}
		return PLPPage;

	}
	public static String randomNumber;
    private WebDriver driver;
    public static String countFromFilter;
    public static String productName;
    public static String priceTextNotLoggedInActual;
    
	public void clickListView() throws InterruptedException {
		getCommonActionsInstance().waitUntilElementVisible(getPLPRepoInstance().listView, 20);
    	getCommonActionsInstance().clickAction(getPLPRepoInstance().listView);
    	getCommonActionsInstance().add_Log_With_ScreenShot("Switched to List View");
    	
    }
    public void clickProductName(String itemName) {
    	try{DriverClass.driver.findElement(By.xpath("(//ol[contains(@class,'product-items')]/li//a[contains(text(),'"+itemName+"')])[1]")).click();
    	}catch(Exception e) {
    		DriverClass.driver.navigate().refresh();
    		getCommonActionsInstance().waitForPageLoad(DriverClass.driver,30);
    		WebElement element = DriverClass.driver.findElement(By.xpath("(//ol[contains(@class,'product-items')]/li//a[contains(text(),'"+itemName+"')])[1]"));
    		element.click();
    	}
    }
    
    public void selectFilterCriteria(String filterCriteria) throws InterruptedException {
    	
    	WebElement element = DriverClass.driver.findElement(By.xpath("(//span[text()='"+filterCriteria+"']/following::span)[1]"));
		//element.click();
		getCommonActionsInstance().waitAndClickUsingJS(element);
		getCommonActionsInstance().sleep(3000);
		WebElement element_Count = DriverClass.driver.findElement(By.xpath("(//span[text()='"+filterCriteria+"']/following::span[@class='count'])[1]"));
		countFromFilter = getCommonActionsInstance().getText(element_Count);
		System.out.println("No. of products for "+filterCriteria+" : "+countFromFilter);
    
    }
    
    public void verifyNoOfProductsInProductListing() {
    	
    	int size = getCommonActionsInstance().getSizeByXpath("//ol[contains(@class,'products list')]/li[contains(@class,'product-item')]");
    	String countFromListing = String.valueOf(size);
    	System.out.println("No. of products from product listing : "+countFromListing);
    	Assert.assertTrue(countFromFilter.contains(countFromListing));
    }
    
    public void clearAllAppliedFilter() throws InterruptedException {
    
    	getCommonActionsInstance().scrollDownVerticalTo("350");
    	getCommonActionsInstance().add_Log_With_ScreenShot("Applied the Filters");
    	//getCommonActionsInstance().sleep(3000);
    	getCommonActionsInstance().refreshPage();
    	getCommonActionsInstance().sleep(3000);
    	//getCommonActionsInstance().clickAfterJS(getPLPRepoInstance().clearAllLink);
    	//getCommonActionsInstance().waitAndClickUsingJS(getPLPRepoInstance().clearAllLink);
    	WebElement element = DriverClass.driver.findElements(By.cssSelector("#layered-filter-block > div.block-content.filter-content > div.block-actions.filter-actions > a > span")).get(1);
    	getCommonActionsInstance().clickAfterJS(element);
    	getCommonActionsInstance().sleep(5000);
    	getCommonActionsInstance().add_Log_With_ScreenShot("Cleared the filters");
    }
    
    public void searchAndSelectCriteria(String filterCriteria) throws InterruptedException {
    	
    	WebElement element = null;
    	getCommonActionsInstance().sendKeysAction(getPLPRepoInstance().searchFilter, filterCriteria);
    	if(DriverClass.driver.findElements(By.cssSelector("#am-ranges-flavour > ol > li:nth-child(2) > a > span.label > span")).size()==0) {
    	element =  DriverClass.driver.findElement(By.cssSelector("#am-ranges-flavour > ol > li:nth-child(2) > a"));
    	}else {
    	element = DriverClass.driver.findElement(By.cssSelector("#am-ranges-flavour > ol > li:nth-child(2) > a > span.label > span"));
    	}
		//element.click();
    	getCommonActionsInstance().waitAndClickUsingJS(element);
		getCommonActionsInstance().sleep(3000);
		WebElement element_Count = DriverClass.driver.findElement(By.xpath("(//span[text()='"+filterCriteria+"']/following::span[@class='count'])[1]"));
		countFromFilter = getCommonActionsInstance().getText(element_Count);
		System.out.println("No. of products for "+filterCriteria+" : "+countFromFilter);
    }
    
    public void selectSortingOption(String sortingOption) throws InterruptedException {
    	
    	getCommonActionsInstance().selectByVisibleText(getPLPRepoInstance().sortingDropDown, sortingOption);
    	getCommonActionsInstance().sleep(3000);
    
    }
    
    public void verifySortedInAscendingOrder() {
    	
    	String productName = getCommonActionsInstance().getText(getPLPRepoInstance().plpFirstProduct).trim();
    	getCommonActionsInstance().add_Log_With_ScreenShot("Sorted in Ascending order");
    	Assert.assertEquals(productName, "D11A");
    }
    
    public void setDescendingOrder() throws InterruptedException {
    	
    	getCommonActionsInstance().clickAction(getPLPRepoInstance().setDescendingArrow);
    	getCommonActionsInstance().sleep(8000);
    }
    
    public void verifySortedInDescendingOrder() {
    	
    	String productName = getCommonActionsInstance().getText(getPLPRepoInstance().plpFirstProduct).trim();
    	getCommonActionsInstance().add_Log_With_ScreenShot("Sorted in Descending order");
    	Assert.assertEquals(productName, "TrueDark (N11D)");
    }
    
    public void selectNoOfItemsPerPage(String itemsPerPage) throws InterruptedException {
    	
    	getCommonActionsInstance().selectByVisibleText(getPLPRepoInstance().noOfItemsPerPageDropDown, itemsPerPage);
    	getCommonActionsInstance().sleep(3000);
    }
    
    public void clickNextIcon() throws InterruptedException {
    	
    	getCommonActionsInstance().scrollDownVerticalTo("3250");
    	getCommonActionsInstance().add_Log_With_ScreenShot("Pagination with Next Icon");
    	getCommonActionsInstance().waitAndClickUsingJS(getPLPRepoInstance().nextIcon);
    	getCommonActionsInstance().sleep(3000);
    	getCommonActionsInstance().add_Log_With_ScreenShot("Navigated to Next page");
    	
    }
    
    public void verifyURLContainsPageNo() {
    	
    	Assert.assertTrue(getCommonActionsInstance().getPageURL().contains("p=2"));
    }
    
    public void clickPageNumber() throws InterruptedException {
    	
    	getCommonActionsInstance().clickAction(getPLPRepoInstance().PageNoOne);
    	getCommonActionsInstance().sleep(3000);
    	getCommonActionsInstance().add_Log_With_ScreenShot("Navigated back to First page");
    }

    public void verifyURLNotContainsPageNo() {
    	
    	Assert.assertFalse(getCommonActionsInstance().getPageURL().contains("p=1"));
    	
    }
    
    public void clickFavoriteIcon() throws InterruptedException {
    	
    	productName = getCommonActionsInstance().getText(getPLPRepoInstance().plpFirstProduct).trim();
    	getCommonActionsInstance().clickAction(getPLPRepoInstance().firstFavoriteIcon);
    	getCommonActionsInstance().sleep(3000);
    }
    
    public void verifyCustomerIsRedirected() {
    	
    	Assert.assertTrue(getCommonActionsInstance().getPageURL().contains("wishlist"));
    }
    
    public void verifyProductIsAddedToFavorites() {
    	
    	String productNameInFavorites = getCommonActionsInstance().getText(getPLPRepoInstance().plpFirstProduct).trim();
    	getCommonActionsInstance().add_Log_With_ScreenShot("Item is added to Favorites");
    	Assert.assertEquals(productNameInFavorites,productName);
    }
    
    public void removeFromFavorites() throws InterruptedException {
    	
    	getCommonActionsInstance().clickAction(getPLPRepoInstance().removeButton);
    	getCommonActionsInstance().clickAfterJS(getPLPRepoInstance().okButton);
    	getCommonActionsInstance().sleep(3000);
    }
    
    public void verifyFavoritesIconUnselected() {
    	
    	boolean elementAvailableFlag = false;
    	getCommonActionsInstance().implicitWait(0);
    	try {
    		DriverClass.driver.findElement(By.xpath("(//ol[contains(@class,'product-items')]//a)[1][contains(@class,'item-added')]"));
    		elementAvailableFlag = true;
    	}catch(NoSuchElementException e) {
    		elementAvailableFlag = false;;
    	}
     	getCommonActionsInstance().implicitWait(20);
     	getCommonActionsInstance().add_Log_With_ScreenShot("Favorite icon is displayed as unselected after removing the item from favorites");
    	Assert.assertFalse(elementAvailableFlag);
    }
    
    public void checkForStartingPrice(String priceText) throws InterruptedException {
    	
    	getCommonActionsInstance().waitUntilElementVisible(getPLPRepoInstance().PricePLPFirstProduct,100);
    	priceTextNotLoggedInActual = getCommonActionsInstance().getText(getPLPRepoInstance().PricePLPFirstProduct).trim();
    	getCommonActionsInstance().add_Log_With_ScreenShot("Guest user can not see the price.");
    	Assert.assertEquals(priceTextNotLoggedInActual,priceText);
    }
    
}

	