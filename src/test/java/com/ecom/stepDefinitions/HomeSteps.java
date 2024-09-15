package com.ecom.stepDefinitions;
import org.testng.Assert;

import com.ecom.utils.BaseStepInstance;

import cucumber.api.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomeSteps extends BaseStepInstance {

	@Given("^Customer navigates to Home page$")
	public void Customer_navigates_to_Home_page() throws Throwable {
		getHomePageInstance().navigateToHomePage();
	}
	
	@When("^Navigate to \"([^\"]*)\" Category page$")
	public void Navigate_to_category_page(String category) throws Throwable {
		getHomePageInstance().navigateToCategoryPage(category);
	}
	//
	@When("^Click on Search Icon from header$")
	public void click_search_icon() throws Throwable {
		getHomePageInstance().clickSearchIcon();
	}
	
	@When("^Key in valid search term \"([^\"]*)\" and hit Enter$")
	public void key_in_valid_search_term(String searchTerm) throws Throwable {
		getHomePageInstance().searchWithValidTerm( searchTerm);
	}
	
	@When("^Verify Search results page shows products that contains search term \"([^\"]*)\"$")
	public void verify_search_result_page(String searchTerm) throws Throwable {
		getHomePageInstance().verifySearchResultForValidTerm(searchTerm);
	}
	//
	@When("^Key in incorrect search term \"([^\"]*)\" and hit Enter$")
	public void key_in_invalid_search_term(String searchTerm) throws Throwable {
		getHomePageInstance().searchWithInValidTerm( searchTerm);
	}
	//
	@When("^Verify the search result section for message \"([^\"]*)\"$")
	public void verify_search_result_page_for_message(String searchResultMessage) throws Throwable {
		getHomePageInstance().verifySearchResultForInValidTerm(searchResultMessage);
	}
	//
	@When("^Navigate to My Account page$")
	public void navigate_to_MyAccount_Page() throws Throwable {
		getHomePageInstance().navigateToMyAccountPage();
	}
	//
	@When("^Signup for newsletter with \"([^\"]*)\"$")
	public void sign_up_for_newsletter(String email) throws Throwable {
		getHomePageInstance().signupForNewsletter(email);
	}
	//
	@When("^Verify the newsletter subscription success message \"([^\"]*)\"$")
	public void verify_success_message(String successMessage) throws Throwable {
		getHomePageInstance().verifyNewsLetterSubscriptionSuccessMessage(successMessage);
	}
	
	@When("^clicks on Sign out from user profile$")
	public void clicks_on_Sign_out_from_user_profile() throws Throwable {
		getHomePageInstance().clickSignOut();
	}
	
	@When("^verify url contains \"([^\"]*)\"$")
	public void verify_url_for_logout(String signoutURLText) throws Throwable {
		getHomePageInstance().verifySignoutURL(signoutURLText);
	}
	
	
}
