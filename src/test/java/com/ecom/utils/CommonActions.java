package com.ecom.utils;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;


public class CommonActions {

	public static WebDriver driver;

	public static CommonActions actionItem = null;

	public CommonActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public static CommonActions getInstance() {
		if (actionItem == null) {
			actionItem = new CommonActions(DriverClass.driver);
		}
		return actionItem;
	}
	
	
	// Step log
	public void report_Setp_Log(String message) {	
		ExtentCucumberAdapter.addTestStepLog(message);
	}
	
	// Report log with screen shot
	public void add_Log_With_ScreenShot(String message)  {
		ExtentCucumberAdapter.addTestStepLog(message);
		//get_Screenshot(AppUtil.driver);
		getBase64Screenshot();
	}
	
	//Attach screenshot in the form of embedded image
		public static  void getBase64Screenshot() 
		{
		   String Screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		  ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot).build());
		}

		// Attach screenshot
		public void get_Screenshot(WebDriver driver) {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/test-output/" + "screenshot" + dateName + ".png";
			File finalDestination = new File(destination);
			try {
				FileUtils.copyFile(source, finalDestination);
				ExtentCucumberAdapter.addTestStepLog(
						System.getProperty("user.dir") + "/test-output/" + "screenshot" + dateName + ".png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	// Navigate to URL

	public void navigateToURL(String URL) throws InterruptedException {
		driver.get(URL);
	}

	// Sleep

	public void sleep(int seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}

	// Click Action

	public void clickAction(WebElement element) throws InterruptedException {
		element.click();

	}

	// Send Keys Action

	public void sendKeysAction(WebElement element, String inputText) {
		element.sendKeys(inputText);

	}

	// Clear Action
	public void clearAction(WebElement element) {
		element.clear();

	}

	// get text from element by attribute
	public String getAttributeValue(WebElement element, String attributeValue) {
		String text = element.getAttribute(attributeValue);
		return text;

	}

	// get size of the elements
	public int getSizeByXpath(String xpath) {
		int size = driver.findElements(By.xpath(xpath)).size();
		return size;

	}

	// get text of the element

	public String getText(WebElement element) {
		String text = element.getText();
		return text;

	}

	// Implicit wait

	public void implicitWait(int sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	// Tab Keys

	public void pressKeys(Keys key) {

		driver.switchTo().activeElement().sendKeys(key);
	}

	// moveToElement using action Method

	public void moveToElement(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	// Send keys using active element

	public void typeIntoActiveElement(String inputText) {
		driver.switchTo().activeElement().sendKeys(inputText);

	}

	// scroll by visible element

	public void scrollToMakeElementVisible(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// scroll to the bottom of the page

	public void scrollToBottomOfPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// scroll to the top of the page

	public void scrollToToOfPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
	}
	
	// vertical scroll

	public void scrollDownVerticalTo(String y) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+y+")");
	}

	// wait till element clickable

	public void verifyElementClickableThenClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(600));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	// verify if the field is enabled
	public boolean isEnabled(WebElement element) {
		boolean flag = element.isEnabled();
		return flag;
	}

	// verify if the field is displayed
	public boolean isDisplayed(WebElement element) {
		boolean flag = element.isDisplayed();
		return flag;
	}

	// verify if the field is selected
	public boolean isSelected(WebElement element) {
		boolean flag = element.isSelected();
		return flag;
	}

	// select the value from dropdown using text
	public void selectByVisibleText(WebElement element, String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	// select the value from dropdown using value
	public void selectByValue(WebElement element, String Value) {
		Select se = new Select(element);
		se.selectByValue(Value);

	}

	public void clickAfterJS(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click()", element);
	}

	// Check if the page is ready to perform the actions
	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	// Assert the page title
	public void pageTitleValidation(String actualTitle) {
		waitForPageLoad(driver,15);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
//		wait.until(ExpectedConditions.visibilityOf(element));
		String expectedTitle = driver.getTitle();
		org.testng.Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(actualTitle);
		System.out.println("Title has matched");
	}

	// Generates 1 Random Number in the range
	public int randomNumber(int size) {
		int randomNum = ThreadLocalRandom.current().nextInt(1, size + 1);
		return randomNum;
	}
	
	public void elementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	} 
	
	//wait till element visible
	public void waitUntilElementVisibleThenClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	} 
	
	public void waitUntilElementVisible(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	} 

	// Get current time stamp
	public String currentTime() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	// Get the last date of the monthe based on the month say oct-31,nov-30,feb-28
	/**
	 * @return
	 */
	public int maxDateOfTheMonth() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		int date = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return date;
	}

	// Verify if order created is displayed in My orders tab
	public boolean orderNumber(String orderNumber) {
		boolean order = driver.findElement(By.xpath("//td[text()='" + orderNumber + "']")).isDisplayed();
		return order;
	}

	// Click on the product from the PLP page based on the Parameterized SKU
	public void clickProductViewDetails(String productCode) {
		driver.findElement(By.xpath("//div[@class='text-alt' and text()='" + productCode
				+ "']//ancestor::tr//a[contains(text(),'View Details')]")).click();
	}

	public void downloadSpecficationURLValidation() {
		String originalHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				String URL = driver.getCurrentUrl();
				assertTrue(URL.contains("https://shopausuat.olammarkets.com/almonds/mwdownloads/download/link"));
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
	}

	// Click on the contract in the My contracts page with contract number generated
	public void clickContractOrder() {
		driver.findElement(By.xpath("//tbody//tr[1]//td[@class=' details-control']")).click();
	}

	// Replace the values instead of clearing and sending the values
	public void replaceValues(WebElement element, String Quantity) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Quantity);
	}

	// Select filter

	public void selectFilterSubcatageory(String subcatageory) {
		driver.findElement(By.xpath("//a[text()[contains(.,'" + subcatageory + "')]]")).click();
	}
	// Select subfilter
	public void selectFilter(String type) {
		driver.findElement(By.xpath("//div[@class='filter-options-title' and contains(text(),'" + type + "')] "))
				.click();
	}
	// Verify filter
	public boolean verifyFilter(String type) {
		boolean value=driver.findElement(By.xpath("//div[@class='product data items specs-layout d-none d-md-block']//strong[text()='"+ type +"'] ")).isDisplayed();
		return value;
	}
	// Verify subfilter
	public boolean verifyFilterSubcatageory(String subcatageory) {
		boolean value=driver.findElement(By.xpath("//div[@class='product data items specs-layout d-none d-md-block']//span[text()='" + subcatageory + "']")).isDisplayed();
		return value;
	}
	
	//get page URL
	public String getPageURL() {
		
		String url = driver.getCurrentUrl();
		System.out.println("current page URL: "+url);
		return url;
	}
	
	// Send Keys And enter

	public void sendKeysAndHitEnter(WebElement element, String inputText) {
		element.sendKeys(inputText, Keys.ENTER);

	}
	
	//Refresh page
	public void refreshPage() {
		
		driver.navigate().refresh();
	}
	
	// verify if the field is displayed using xpath
	public boolean isDisplayed(String xpath) {
		boolean flag = false;
		flag = driver.findElements(By.xpath(xpath)).size()>0;
		return flag;
	}
	
	//sendkeys then press down and hit enter
	public void enterAndSelectFromSuggestionList(WebElement element, String Quantity) {
		element.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER), Quantity);
	}
	
	public void waitForPageLoad(WebDriver driver, long timeOutInSeconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").	equals("complete"));
	}
	
	public void waitAndClickUsingJS(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		clickAfterJS(element);
	}
	

}
