package com.ecom.stepDefinitions;
import org.openqa.selenium.WebElement;

import com.ecom.utils.BaseStepInstance;
import com.ecom.utils.CommonActions;

import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class PLPpagesteps extends BaseStepInstance {
	

	@And("^Switch to List View$")
	public void Switch_to_List_View() throws Throwable {
		
		getPLPPageInstance().clickListView();
		getCommonActionsInstance().sleep(3000);
	}
	
	@Then("^Clicks on product \"([^\"]*)\"$")
	public void Clicks_on_product(String productName) throws Throwable {
		
		getPLPPageInstance().clickProductName(productName);
		//getCommonActionsInstance().sleep(5000);
	}
	
	@Then("^Select a filter \"([^\"]*)\" under Applications$")
	public void select_a_filter_under_Applications(String filterCriteria) throws Throwable {
		
		getPLPPageInstance().selectFilterCriteria(filterCriteria);
		getCommonActionsInstance().sleep(5000);
	}
	
	@Then("^Select a filter \"([^\"]*)\" under PH value$")
	public void select_a_filter_under_PH_Value(String filterCriteria) throws Throwable {
		
		getPLPPageInstance().selectFilterCriteria(filterCriteria);
		//getCommonActionsInstance().sleep(5000);
	}
	
	@Then("^Select a filter \"([^\"]*)\" under Color$")
	public void select_a_filter_under_Color(String filterCriteria) throws Throwable {
		
		getPLPPageInstance().selectFilterCriteria(filterCriteria);
		//getCommonActionsInstance().sleep(5000);
	}
	 
	@And("^Verify number of products in product listing$")
	public void Verify_number_of_products_in_product_listing() throws Throwable {
		
		getPLPPageInstance().verifyNoOfProductsInProductListing();
		//getCommonActionsInstance().sleep(5000);
	}
	 
	@Then("^Clear all the applied filter$")
	public void Clear_all_the_applied_filter() throws Throwable {

		getPLPPageInstance().clearAllAppliedFilter();
		// getCommonActionsInstance().sleep(5000);
	}
	//Then Search a filter criteria "<SearchFilterCriteria>" and select
	
	@Then("^Search a filter criteria \"([^\"]*)\" and select$")
	public void search_filter_Criteria_And_Select(String filterCriteria) throws Throwable {

		getPLPPageInstance().searchAndSelectCriteria(filterCriteria);
		// getCommonActionsInstance().sleep(5000);
	}
	
	@Then("^Customer selects a sorting option as \"([^\"]*)\"$")
	public void customer_selects_sorting_option(String sortingOption) throws Throwable {

		getPLPPageInstance().selectSortingOption(sortingOption);
		getCommonActionsInstance().sleep(5000);
	}
	
	//
	@Then("^Verify products are sorted in Ascending order$")
	public void Verify_products_are_sorted_in_Ascending_order() throws Throwable {

		getPLPPageInstance().verifySortedInAscendingOrder();
		// getCommonActionsInstance().sleep(5000);
	}
	//Customer clicks on Descending order
	@Then("^Customer clicks on Descending order$")
	public void Customer_clicks_on_Descending_order() throws Throwable {

		getPLPPageInstance().setDescendingOrder();
		// getCommonActionsInstance().sleep(5000);
	}
	//
	@Then("^Verify products are sorted in Descending order$")
	public void Verify_products_are_sorted_in_Descending_order() throws Throwable {

		getPLPPageInstance().verifySortedInDescendingOrder();
		// getCommonActionsInstance().sleep(5000);
	}
	//
	
	@Then("^Customer selects the number of items per page as \"([^\"]*)\"$")
	public void Customer_selects_the_number_of_items_per_page(String itemsPerPage) throws Throwable {

		getPLPPageInstance().selectNoOfItemsPerPage(itemsPerPage);
		// getCommonActionsInstance().sleep(5000);
	}
	//
	@Then("^Click on Next icon$")
	public void Click_on_Next_icon() throws Throwable {

		getPLPPageInstance().clickNextIcon();
		// getCommonActionsInstance().sleep(5000);
	}
	
	@Then("^Verify the URL contains page number$")
	public void Verify_the_URL_contains_pageNo() throws Throwable {

		getPLPPageInstance().verifyURLContainsPageNo();
		getCommonActionsInstance().sleep(5000);
	}
	//
	@Then("^Click on page number$")
	public void Click_on_page_number() throws Throwable {

		getPLPPageInstance().clickPageNumber();
		// getCommonActionsInstance().sleep(5000);
	}
	
	@Then("^Verify the URL does not contain page number$")
	public void Verify_the_URL_does_not_contain_pageNo() throws Throwable {

		getPLPPageInstance().verifyURLNotContainsPageNo();
		// getCommonActionsInstance().sleep(5000);
	}
	//
	@Then("^Click on favorite icon for a product$")
	public void click_favorite_icon() throws Throwable {

		getPLPPageInstance().clickFavoriteIcon();
	}
	
	//
	@Then("^Verify customer is redirected to My Favorites$")
	public void verify_customer_redirected_My_Favorites() throws Throwable {

		getPLPPageInstance().verifyCustomerIsRedirected();
	}
	//
	@Then("^Verify product is added to favorites list$")
	public void verify_product_added_to_favorites() throws Throwable {

		getPLPPageInstance().verifyProductIsAddedToFavorites();
	}
	//
	@Then("^Clear favorites list$")
	public void Clear_favorites_list() throws Throwable {

		getPLPPageInstance().removeFromFavorites();
	}
	
	@And("^Verify favorite icon is displayed as unselected$")
	public void verify_favorites_icon_is_unselected() throws Throwable {

		getPLPPageInstance().verifyFavoritesIconUnselected();
	}
	//
	@And("^Check starting price for a product is showing as \"([^\"]*)\"$")
	public void check_starting_price_for_a_product(String priceText) throws Throwable {

		getPLPPageInstance().checkForStartingPrice(priceText);
	}
	
}
