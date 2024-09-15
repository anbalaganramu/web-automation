package com.ecom.stepDefinitions;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.testng.Assert;

import com.ecom.utils.BaseStepInstance;

import io.cucumber.java.en.*;

public class MainSteps extends BaseStepInstance {
	
	@Given("Launch the Olam Agri Home page URL")
	public void launch_the_olam_agri_home_page_url() throws Throwable{
	   getMainPageInstance().launchHomePage();
	}
	
	@And("Mouse over Menu1 and print menu title and take a screenshot")
	public void mouse_over_menu1_and_print_menu_title_and_take_a_screenshot() throws Throwable{
	   getMainPageInstance().mouseOverMenu1();
	}
	
	@Given("Mouse over Menu2 and print menu title and take a screenshot")
	public void mouse_over_menu2_and_print_menu_title_and_take_a_screenshot() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		getMainPageInstance().mouseOverMenu2();
	}
	
	
	@When("User click on the Wood Product menu under Menu2 should display sub pages of the Wood Product menus")
	public void user_click_on_the_wood_product_menu_under_menu2_should_display_sub_pages_of_the_wood_product_menus() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		getMainPageInstance().mouseOverMenu2_Child();
	}
	
	@And("Mouse over Menu3 and print menu title and take a screenshot")
	public void mouse_over_menu3_and_print_menu_title_and_take_a_screenshot() throws Throwable{
	   getMainPageInstance().mouseOverMenu3();
	}
	
	@And("Mouse over Menu4 and print menu title and take a screenshot")
	public void mouse_over_menu4_and_print_menu_title_and_take_a_screenshot() throws Throwable{
	   getMainPageInstance().mouseOverMenu4();
	}
	
	@And("Mouse over Menu5 and print menu title and take a screenshot")
	public void mouse_over_menu5_and_print_menu_title_and_take_a_screenshot() throws Throwable{
	   getMainPageInstance().mouseOverMenu5();
	}
	
	@And("Scroll to metrics component section and print the title and take a screenshot")
	public void scroll_to_metrics_component_section_and_print_the_title_and_take_a_screenshot() throws Throwable {
	    getMainPageInstance().metricsComp();
	   
	}
	
	@And("Scroll to text and asset component section1 and print the title and take a screenshot")
	public void scroll_to_text_and_asset_component_section1_and_print_the_title_and_take_a_screenshot() throws Throwable{
	    getMainPageInstance().textassetComp1();
	}
	
	@And("Scroll to product carousel component section and print the title and take a screenshot")
	public void scroll_to_product_carousel_component_section_and_print_the_title_and_take_a_screenshot() throws Throwable{
	    getMainPageInstance().psComp();
	}
	
	@When("Mouse over each product and print the title and take a screenshot")
	public void mouse_over_each_product_and_print_the_title_and_take_a_screenshot() throws Throwable{
	    getMainPageInstance().psItem();
	}

	
	
	
//	@Then("Should display sub pages of the Wood Product menu")
//	public void should_display_sub_pages_of_the_wood_product_menu() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
////		getMainPageInstance().mouseOverMenu2_Child();
//		assertEquals("test", "test");
//	}
	
	
//	@And("Accept cookies policy")
//	public void accept_cookies_policy() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	

	
	
}
