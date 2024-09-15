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
import freemarker.log.Logger;



public class MainPage extends BaseStepInstance {

	public static MainPage mainPage;

	public static MainPage getInstance() {
		if (mainPage == null) {
			mainPage = new MainPage();
		}
		return mainPage;

	}

	public void launchHomePage() throws InterruptedException {	
		try {
			getCommonActionsInstance().navigateToURL("https://www.olamagri.com");
			getCommonActionsInstance().implicitWait(30);
			getCommonActionsInstance().add_Log_With_ScreenShot("Launched the URL Successfully");
			getCommonActionsInstance().implicitWait(30);
			getCommonActionsInstance().clickAction(getMainRepoInstance().acceptCookie);
			getCommonActionsInstance().pageTitleValidation("Olam Agri | Food & Agriculture & Ag Services");
//			Assert.assertEquals("Olam Agri | Food & Agriculture & Ag Services", "Olam Agri | Food & Agriculture & Ag Services", "Matched");
//			getCommonActionsInstance().add_Log_With_ScreenShot("Landed Homepage successfully");	
			
			
		}
		catch(Exception e){
			e.getMessage();
		}
			
	}
	
	public void mouseOverMenu1() throws InterruptedException {
		try {
			getCommonActionsInstance().moveToElement(getMainRepoInstance().menu1);
			Thread.sleep(3000);
			String menu1Text=getCommonActionsInstance().getText(getMainRepoInstance().menu1);
//			String styledMenu1Text = "<h3 style=\"color: #333; font-size: 18px; font-weight: bold; margin-bottom: 10px;\">" + menu1Text + "</h3>";
//			System.out.println(styledMenu1Text);
			System.out.println("<h3>"+menu1Text+"</h3>");
			getCommonActionsInstance().add_Log_With_ScreenShot(menu1Text);		
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void mouseOverMenu2() throws InterruptedException {
		try {
			getCommonActionsInstance().moveToElement(getMainRepoInstance().menu2);
			String menu2Text=getCommonActionsInstance().getText(getMainRepoInstance().menu2);
			System.out.println("'<h3>'"+menu2Text+"'</h3>'");
			getCommonActionsInstance().add_Log_With_ScreenShot(menu2Text);
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	}
	
	public void mouseOverMenu2_Child() throws InterruptedException {
		try {
			getCommonActionsInstance().clickAction(getMainRepoInstance().psWood);
			String menu2Child=getCommonActionsInstance().getText(getMainRepoInstance().psWood);
			System.out.println("'<h3>'"+menu2Child+"'</h3>'");
			getCommonActionsInstance().add_Log_With_ScreenShot(menu2Child);
		}
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void mouseOverMenu3() throws InterruptedException {		
		try {
			getCommonActionsInstance().moveToElement(getMainRepoInstance().menu3);
			String menu3Text = getCommonActionsInstance().getText(getMainRepoInstance().menu3);
			System.out.println(menu3Text);
			getCommonActionsInstance().add_Log_With_ScreenShot(menu3Text);
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void mouseOverMenu4() throws InterruptedException {		
		try {
			getCommonActionsInstance().moveToElement(getMainRepoInstance().menu4);
			String menu4Text = getCommonActionsInstance().getText(getMainRepoInstance().menu4);
			System.out.println(menu4Text);
			getCommonActionsInstance().add_Log_With_ScreenShot(menu4Text);
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void mouseOverMenu5() throws InterruptedException {		
		try {
			getCommonActionsInstance().moveToElement(getMainRepoInstance().menu5);
			String menu5Text = getCommonActionsInstance().getText(getMainRepoInstance().menu5);
			System.out.println(menu5Text);
			getCommonActionsInstance().add_Log_With_ScreenShot(menu5Text);
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void metricsComp() throws InterruptedException {		
		try {
			getCommonActionsInstance().scrollToMakeElementVisible(getMainRepoInstance().metrics_Comp);
			String metricsCompTitle = getCommonActionsInstance().getText(getMainRepoInstance().metrics_Comp_Title);
			System.out.println(metricsCompTitle);
			getCommonActionsInstance().add_Log_With_ScreenShot(metricsCompTitle);	
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void textassetComp1() throws InterruptedException {		
		try {
			getCommonActionsInstance().scrollToMakeElementVisible(getMainRepoInstance().textAssetComp1);
			String textAssetComp1Title = getCommonActionsInstance().getText(getMainRepoInstance().textAssetComp1Title);
			System.out.println(textAssetComp1Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(textAssetComp1Title);	
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void psComp() throws InterruptedException {		
		try {
			getCommonActionsInstance().scrollToMakeElementVisible(getMainRepoInstance().productCarousel);
			String psCarouselTitle = getCommonActionsInstance().getText(getMainRepoInstance().productCarouselTitle);
			System.out.println(psCarouselTitle);
			getCommonActionsInstance().add_Log_With_ScreenShot(psCarouselTitle);
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void psItem() throws InterruptedException {		
		try {
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem1);
			String psItem1Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem1Title);
			System.out.println(psItem1Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem1Title);

			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem2);
			String psItem2Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem2Title);
			System.out.println(psItem2Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem2Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem3);
			String psItem3Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem3Title);
			System.out.println(psItem3Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem3Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem4);
			String psItem4Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem4Title);
			System.out.println(psItem4Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem4Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem5);
			String psItem5Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem5Title);
			System.out.println(psItem5Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem5Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem6);
			String psItem6Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem6Title);
			System.out.println(psItem6Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem6Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem7);
			String psItem7Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem7Title);
			System.out.println(psItem7Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem7Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem8);
			String psItem8Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem8Title);
			System.out.println(psItem8Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem8Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem9);
			String psItem9Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem9Title);
			System.out.println(psItem9Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem9Title);
			
			getCommonActionsInstance().moveToElement(getMainRepoInstance().productItem10);
			String psItem10Title = getCommonActionsInstance().getText(getMainRepoInstance().productItem10Title);
			System.out.println(psItem10Title);
			getCommonActionsInstance().add_Log_With_ScreenShot(psItem10Title);

		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	
}
