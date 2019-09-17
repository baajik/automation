package gov.ebooks.selenium.shared.pages;

import static gov.ebooks.selenium.shared.utils.ObjectFileReader.getELementFromFile;
import static gov.ebooks.selenium.shared.utils.ObjectFileReader.getPageTitleFromFile;
import static gov.ebooks.selenium.shared.utils.ConfigPropertyReader.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import gov.ebooks.selenium.shared.utils.ConfigPropertyReader;
import gov.ebooks.selenium.shared.utils.LayoutValidation;
import gov.ebooks.selenium.shared.utils.Locators;
import gov.ebooks.selenium.shared.utils.SeleniumWait;

public class BasePage {

	protected WebDriver driver;
	protected SeleniumWait wait;
	String pageName;
	String project;
	LayoutValidation layouttest;	

	public BasePage(WebDriver driver, String pageName, String project) {
		this.driver = driver;
		this.pageName = pageName;
		this.project = project;
		layouttest = new LayoutValidation(driver, pageName);
		this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty("Config.properties", "timeout")));
	}
	// verified methods ===============================================================================================================================
	/**
	 * Find the first matching element on the webpage based on the provided element token as defined in the spec file for the page.
	 * This method will return null if no matching element is found.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @return The first matching element, or null if no element is found.
	 */
	protected WebElement findElement(String elementToken){
		return findElement(elementToken, "");
	}
	
	/**
	 * Find the first matching element on the webpage based on the provided element token as defined in the spec file for the page.
	 * This method will return null if no matching element is found.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return The first matching element, or null if no element is found.
	 */
	protected WebElement findElement(String elementToken, String replacement){
		List<WebElement> foundElements = driver.findElements(getLocator(elementToken, replacement));
		if(foundElements.size() > 0){
			return foundElements.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * Find the first matching element on the webpage based on the provided element token as defined in the spec file for the page.
	 * This method will return null if no matching element is found.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @param replacement2 Secondary replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return The first matching element, or null if no element is found.
	 */
	protected WebElement findElement(String elementToken, String replacement1, String replacement2){
		List<WebElement> foundElements = driver.findElements(getLocator(elementToken, replacement1, replacement2));
		if(foundElements.size() > 0){
			return foundElements.get(0);
		}else{
			return null;
		}
	}
	/**
	 * Find all matching elements on the webpage based on the provided element token as defined in the spec file for the page.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @return A list of WebElement objects.
	 */
	protected List<WebElement> findElements(String elementToken){
		return findElements(elementToken, "");
	}
	
	/**
	 * Find all matching elements on the webpage based on the provided element token as defined in the spec file for the page.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return A list of WebElement objects.
	 */
	protected List<WebElement> findElements(String elementToken, String replacement){
		return driver.findElements(getLocator(elementToken, replacement));
	}
	
	/**
	 * Find all matching elements on the webpage based on the provided element token as defined in the spec file for the page.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @param replacement2 Secondary replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return A list of WebElement objects.
	 */
	protected List<WebElement> findElements(String elementToken, String replacement1, String replacement2){
		return driver.findElements(getLocator(elementToken, replacement1, replacement2));
	}
	
	/**
	 * Explicitly wait for element to be visible on the page and attempt to find it.
	 * Uses the findElement method, and so catches the NoSuchElementException. 
	 * Logs a message in TestNG Report when an exception is caught.
	 * 
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @return The first matching element on the page, or null if no element is found.
	 */
	protected WebElement waitAndFindElement(String elementToken) {
		return waitAndFindElement(elementToken, "");
	}

	/**
	 * Explicitly wait for element to be visible on the page and attempt to find it.
	 * Uses the findElement method, and so catches the NoSuchElementException. 
	 * Logs a message in TestNG Report when an exception is caught.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * 
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return The first matching element on the page, or null if no element is found.
	 */
	protected WebElement waitAndFindElement(String elementToken, String replacement) {
		WebElement elem = null;
		try {
			elem = wait.waitForElementToBeVisible(driver.findElement(getLocator(elementToken, replacement)));
		} catch (NoSuchElementException excp) {
			logMessage("FAILED: Element '" + elementToken + "' with text '" + replacement + "' not found on the "
					+ this.pageName + " !!!");
		}
		return elem;
	}

	/**
	 * Explicitly wait for element to be visible on the page and attempt to find it.
	 * Uses the findElement method, and so catches the NoSuchElementException. 
	 * Logs a message in TestNG Report when an exception is caught.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * 
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @param replacement2 Secondary replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return The first matching element on the page, or null if no element is found.
	 */
	protected WebElement waitAndFindElement(String elementToken, String replacement1, String replacement2) {
		WebElement elem = null;
		try {
			elem = wait.waitForElementToBeVisible(
					driver.findElement(getLocator(elementToken, replacement1, replacement2)));
		} catch (NoSuchElementException excp) {
			logMessage("FAILED: Element " + elementToken + " not found on the " + this.pageName + " !!!");
		}
		return elem;
	}
	
	/**
	 * Explicitly wait for elements to be visible on the page and attempt to find them.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @return A list of WebElement objects that match the parameter.
	 */
	protected List<WebElement> waitAndFindElements(String elementToken) {
		return waitAndFindElements(elementToken, "");
	}

	/**
	 * Explicitly wait for elements to be visible on the page and attempt to find them.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return A list of WebElement objects that match the parameter.
	 */
	protected List<WebElement> waitAndFindElements(String elementToken, String replacement) {
		return wait.waitForElementsToBeVisible(driver.findElements(getLocator(elementToken, replacement)));
	}

	/**
	 * Explicitly wait for elements to be visible on the page and attempt to find them.
	 * This version of the method allows to dynamically alter the locator stored in the .spec file by providing a replacement String.
	 * Note that the locator must follow specific naming convention to make use of this method.
	 * @param elementToken Identifier for the desired element as it appears on the .spec page.
	 * @param replacement1 Replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @param replacement2 Secondary replacement String used to dynamically alter the element locator found in the .spec file. Can be empty String if no replacement is needed.
	 * @return A list of WebElement objects that match the parameter.
	 */
	protected List<WebElement> waitAndFindElements(String elementToken, String replacement1, String replacement2) {
		return driver.findElements(getLocator(elementToken, replacement1, replacement2));
	}
	
	//NEW METHODS================================================
	protected WebElement waitAndFindElement(String elementToken, int timeout) {
		return waitAndFindElement(elementToken, timeout, "");
	}
	
	protected WebElement waitAndFindElement(String elementToken, int timeout, String replacement) {
		WebDriverWait customWait = new WebDriverWait(driver, timeout);
		WebElement elem = null;
		try {
			elem = customWait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(elementToken, replacement)));
		} catch (Exception excp) {
			logMessage("FAILED: Element '" + elementToken + "' with text '" + replacement + "' not found or not visible on the "
					+ this.pageName + " !!!");
		}
		return elem;
	}
	
	protected List<WebElement> waitAndFindElements(String elementToken, int timeout) {
		return waitAndFindElements(elementToken, timeout, "");
	}
	
	protected List<WebElement> waitAndFindElements(String elementToken, int timeout, String replacement) {
		WebDriverWait customWait = new WebDriverWait(driver, timeout);
		//wait;// instead of id u can use cssSelector or xpath of ur element.
		//SeleniumWait customWait = new SeleniumWait(driver, timeout);
		//ExpectedConditions.visi
		return customWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocator(elementToken, replacement)));
	}
	
	protected WebElement waitAndFindClickableElement(String elementToken, int timeout) {
		return waitAndFindClickableElement(elementToken, timeout, "");
	}
	
	protected WebElement waitAndFindClickableElement(String elementToken, int timeout, String replacement) {
		WebDriverWait customWait = new WebDriverWait(driver, timeout);
		WebElement elem = null;
		try {
			elem = customWait.until(ExpectedConditions.elementToBeClickable(getLocator(elementToken, replacement)));
		} catch (NoSuchElementException excp) {
			logMessage("FAILED: Element '" + elementToken + "' with text '" + replacement + "' not found on the "
					+ this.pageName + " !!!");
		}
		return elem;
	}
	//Newly Merged Methods================================================================
	public void sleep(int TimeInSeconds)
	{
		try 
		{
			Thread.sleep(TimeInSeconds*1000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());		
		}
	}
	
	public void wait(int TimeInSeconds)
	{
		driver.manage().timeouts().implicitlyWait(TimeInSeconds, TimeUnit.SECONDS);
	}
	
	public void scrollPageTo(WebElement elt)
    {
		((JavascriptExecutor) driver).executeScript("javascript:window.scrollTo(0," + elt.getLocation().getY() +");", elt);
    }
	
	public void scrollHorizontal ()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1000,0)", "");
	} 
	
	public void scrollToRight ()
	{ 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("document.getElementById('gvLocationHorizontalRail').scrollright += 250", ""); 
	}
	
	public WebElement getEditable()
	{
		return driver.switchTo().activeElement();
	}
	
	public void scrollMenuTo(WebElement elt)
    {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elt);
    }
	
	//END OF NEW METHODS ===================================================
	protected By getLocator(String elementToken) {
		return getLocator(elementToken, "");
	}

	protected By getLocator(String elementToken, String replacement) {
		String[] locator = getELementFromFile(this.pageName, this.project, elementToken);
		locator[2] = locator[2].replaceAll("\\{\\S+\\}", replacement);
		return getBy(locator[1].trim(), locator[2].trim());
	}

	protected By getLocator(String elementToken, String replacement1, String replacement2) {
		String[] locator = getELementFromFile(this.pageName, this.project, elementToken);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replacement1);
		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replacement2);
		return getBy(locator[1].trim(), locator[2].trim());
	}
	
	private By getBy(String locatorType, String locatorValue) {
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

	// everything else

	// TODO: put this in right place, create dedicated class for frame and
	// window handlers
	protected void switchToNestedFrames(String frameNames) {
		switchToDefaultContent();
		String[] frameIdentifiers = frameNames.split(":");
		for (String frameId : frameIdentifiers) {
			wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator(frameId.trim()));
		}
	}

	protected boolean checkIfElementWithGivenTextIsNotThere(String eleString, String textToBeReplaced) {
		boolean flag = false;
		try {
			if (driver.findElement(getLocator(eleString, textToBeReplaced)).isDisplayed()) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (NoSuchElementException ex) {
			flag = true;
		}
		return flag;
	}

	protected boolean checkIfElementIsNotThere(String eleString) {
		boolean flag = false;
		try {
			if (driver.findElement(getLocator(eleString)).isDisplayed()) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception ex) {
			flag = true;
		}
		return flag;
	}

	protected boolean checkIfElementIsThere(String eleString) {
		boolean flag = false;
		try {
			if (driver.findElement(getLocator(eleString)).isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (NoSuchElementException ex) {
			flag = false;
		}
		return flag;
	}

	protected boolean checkIfElementIsThere(String eleString, String replacement) {
		boolean flag = false;
		try {
			if (driver.findElement(getLocator(eleString, replacement)).isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (NoSuchElementException ex) {
			flag = false;
		}
		return flag;
	}

	protected void _waitForElementToDisappear(String elementToken, String replacement) {
		int i = 0;
		int initTimeout = wait.getTimeout();
		wait.resetImplicitTimeout(2);
		int count;
		while (i <= 20) {
			if (replacement.isEmpty())
				count = waitAndFindElements(elementToken).size();
			else
				count = waitAndFindElements(elementToken, replacement).size();
			if (count == 0)
				break;
			i += 2;
		}
		wait.resetImplicitTimeout(initTimeout);
	}

	protected void waitForElementToDisappear(String elementToken) {
		_waitForElementToDisappear(elementToken, "");
	}

	protected void waitForElementToDisappear(String elementToken, String replacement) {
		_waitForElementToDisappear(elementToken, replacement);
	}

	public void clickOnFirstLinkBasedOnProvidedText(String elementToken, String linkText) {
		waitAndFindElement(elementToken, linkText).click();
	}

	public boolean matchGivenPatternWithProvidedText(String pattern, String text) {
		Matcher matcher = Pattern.compile(pattern).matcher(text);
		return matcher.matches();
	}

	public boolean redirectionToTestEnvironment() {
		String baseURl = null;

		if (ConfigPropertyReader.getProperty("tier").equalsIgnoreCase("Staging")
				|| ConfigPropertyReader.getProperty("tier").equalsIgnoreCase("Stag")) {

			String currentURL = getCurrentURL();

			if (!(currentURL.contains("qa")) && (currentURL.contains("hec.reisys.com"))) {
				baseURl = currentURL.split(".org")[0];
				currentURL = currentURL.replaceAll(baseURl, "https://nasa-ebooks-qa.amer.reisystems.com");
				driver.get(currentURL);
				wait.waitForPageToLoad();
				return true;
			}

		} else {
			logMessage("No need for any redirections");
			return false;
		}
		return false;
	}
	
	protected void logMessage(String message) {
		Reporter.log(message, true);
	}

	/**
	 * Verification of the page title with the title text provided in the page
	 * object repository
	 * 
	 */
	protected void verifyPageTitleContains() {
		String expectedPagetitle = getPageTitleFromFile(pageName).trim();
		verifyPageTitleContains(expectedPagetitle);
	}

	protected void assertPageTitleContains() {
		String expectedPagetitle = getPageTitleFromFile(pageName).trim();
		assertThatPageTitleContains(expectedPagetitle);
	}

	protected void verifyPageTitleExact(String expectedPagetitle) {
		if (((expectedPagetitle == "") || (expectedPagetitle == null) || (expectedPagetitle.isEmpty()))
				&& (getProperty("browser").equalsIgnoreCase("chrome"))) {
			expectedPagetitle = getCurrentURL();
		}
		try {
			wait.waitForPageTitleToBeExact(expectedPagetitle);
			logMessage("TEST PASSED: PageTitle for '" + pageName + "' is exactly: '" + expectedPagetitle + "'");
		} catch (TimeoutException ex) {
			Assert.fail("TEST FAILED: PageTitle for " + pageName + " is not exactly: '" + expectedPagetitle
					+ "'!!!\n instead it is :- " + driver.getTitle());
		}
	}

	/**
	 * this method will get page title of current window and match it partially
	 * with the param provided
	 *
	 * @param expectedPagetitle
	 *            - Partial page title text
	 * 
	 */
	protected void verifyPageTitleContains(String expectedPagetitle) {
		if (((expectedPagetitle == "") || (expectedPagetitle == null) || (expectedPagetitle.isEmpty()))
				&& (getProperty("browser").equalsIgnoreCase("chrome"))) {
			expectedPagetitle = getCurrentURL();
		}
		try {
			wait.waitForPageTitleToContain(expectedPagetitle);
			String actualPageTitle = getPageTitle().trim();
			logMessage("TEST PASSED: PageTitle for '" + actualPageTitle + "' contains: '" + expectedPagetitle + "'.");
		} catch (TimeoutException exp) {
			String actualPageTitle = driver.getTitle().trim();
			logMessage("TEST FAILED: As actual Page Title: '" + actualPageTitle
					+ "' does not contain expected Page Title : '" + expectedPagetitle + "'.");
		}
	}

	public void assertThatPageTitleContains(String expectedPageTitle) {
		if (((expectedPageTitle == "") || (expectedPageTitle == null) || (expectedPageTitle.isEmpty()))
				&& (getProperty("browser").equalsIgnoreCase("chrome"))) {
			expectedPageTitle = getCurrentURL();
		}
		wait.waitForPageToLoad();
		String pageTitle = getPageTitle();

		Assert.assertTrue(
				pageTitle.toLowerCase().replaceAll("\\s", "").trim()
						.contains(expectedPageTitle.toLowerCase().replaceAll("\\s", "").trim()),
				"TEST FAILED: As actual Page Title: '" + pageTitle + "' does not contain expected Page Title : '"
						+ expectedPageTitle + "'.");
		logMessage("TEST PASSED: PageTitle for '" + pageTitle + "' contains: '" + expectedPageTitle + "'.");
	}

	protected void switchToFrame(WebElement element) {
		wait.waitForElementToBeVisible(element);
		driver.switchTo().frame(element);
	}

	public void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}

	public void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	protected Object executeJavascript(String script) {
		return ((JavascriptExecutor) driver).executeScript(script);
	}

	protected Object executeJavascript(String script, Object object) {
		return (Object) ((JavascriptExecutor) driver).executeScript(script, object);
	}

	protected void handleAlert() {
		try {
			switchToAlert().accept();
			logMessage("Alert handled..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("No Alert window appeared...");
		}
	}

	protected void dismissAlert() {
		try {
			switchToAlert().dismiss();
			logMessage("Alert dismissed..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("No Alert window appeared...");
		}
	}

	protected String handleAlertAndReturnText() {
		String message = null;
		try {
			Alert alert = switchToAlert();
			message = alert.getText();
			alert.accept();
			logMessage("Alert handled..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("No Alert window appeared...");
		}
		return message;
	}

	public boolean isAlertPresent() {
		boolean flag = false;
		try {
			switchToAlert();
			flag = true;
		} catch (TimeoutException Ex) {
			flag = false;
		}
		return flag;
	}

	private Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	protected String getAlertMessage() {
		String message = null;
		try {
			message = switchToAlert().getText();
			logMessage("Retrieved message from Alert saying:- " + message);
			driver.switchTo().defaultContent();
		} catch (Exception ex) {
			logMessage("No Alert appeared ");
		}
		return message;
	}

	protected void selectProvidedTextFromDropDown(WebElement el, String text) {
		wait.waitForElementToBeVisible(el);
		scrollDown(el);
		Select sel = new Select(el);
		sel.selectByVisibleText(text);
	}

	protected void deSelectEverythingFromDropDown(WebElement el) {
		wait.waitForElementToBeVisible(el);
		scrollDown(el);
		Select sel = new Select(el);
		sel.deselectAll();
	}

	protected void selectValueIndexFromDropDown(WebElement el, int index) {
		wait.waitForElementToBeVisible(el);
		scrollDown(el);
		Select sel = new Select(el);
		sel.selectByIndex(index);
	}

	protected String getFirstSelectedOptionFromDropdown(WebElement el) {
		wait.waitForElementToBeVisible(el);
		scrollDown(el);
		Select sel = new Select(el);
		return sel.getFirstSelectedOption().getText();
	}

	protected int getNoOfOptionsInDropdown(WebElement el) {
		wait.waitForElementToBeVisible(el);
		scrollDown(el);
		Select sel = new Select(el);
		return sel.getOptions().size();
	}

	protected List<WebElement> getListOfOptionsInDropdown(WebElement el) {
		wait.waitForElementToBeVisible(el);
		scrollDown(el);
		Select sel = new Select(el);
		return sel.getOptions();
	}

	/**
	 * Method which clicks on specific View Selector
	 * 
	 * @param viewSelector
	 *            - Type of view selector
	 * 
	 */
	public void clickOnSpecificViewSelector(String viewSelector) {
		if (viewSelector.equalsIgnoreCase("List View")) {
			executeJavascript("document.getElementById('listView').click()");
		} else if (viewSelector.equalsIgnoreCase("Grid View")) {
			executeJavascript("document.getElementById('gridView').click()");
		} else {
			executeJavascript("document.getElementById('printView').click()");
		}
		logMessage("User clicked on '" + viewSelector + "' view selector below 'Search Results' header");
	}

	protected void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,10000)");
	}

	protected void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-10000)");
	}

	protected void hover(WebElement element) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(element).build().perform();
	}

	public void hoverAndClick(WebElement element) {
		Actions hoverClick = new Actions(driver);
		hoverClick.moveToElement(element).click().build().perform();
	}

	public void hoverOnMainAndClickSubLink(WebElement mainElement, WebElement subElement) {
		Actions actions = new Actions(driver);
		Actions builder = actions.moveToElement(mainElement);
		Action b = builder.build();
		b.perform();
		actions.moveToElement(mainElement).build().perform();
		wait.hardWait(1);
		actions.moveToElement(subElement);
		actions.click().build().perform();
	}

	protected void click(WebElement element) {
		try {
			wait.waitForElementToBeVisible(element);
			scrollDown(element);
			element.click();
		} catch (StaleElementReferenceException ex1) {
			wait.waitForElementToBeVisible(element);
			scrollDown(element);
			element.click();
			logMessage("Clicked Element " + element + " after catching Stale Element Exception");
		} catch (Exception ex2) {
			logMessage("Element " + element + " could not be clicked! " + ex2.getMessage());
		}
	}

	public void mouseHoverJScript(WebElement HoverElement) {
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} "
				+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
	}

	public void navigateToPreviousPage() {
		driver.navigate().back();
		wait.waitForPageToLoad();
		logMessage("User had redirected to the previous page");
	}

	public void changeWindow(int i) {
		hardWait(1);
		Set<String> windows = driver.getWindowHandles();
		if (i > 0) {
			for (int j = 0; j < 9; j++) {
				System.out.println("Windows: " + windows.size());
				hardWait(1);
				if (windows.size() >= 2) {
					try {
						Thread.sleep(5000);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					break;
				}
				windows = driver.getWindowHandles();
			}
		}
		String wins[] = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(wins[i]);
		hardWait(1);
		System.out.println("Title: " + driver.switchTo().window(wins[i]).getTitle());
	}

	/**
	 * This method overrides the default wait timeout with the new wait time
	 * provided.
	 * 
	 * @param implicitWaitTimeout
	 *            : new implicit wait timeout
	 * @param expicitWaitTimeout
	 *            : new explicit wait time out
	 */

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	protected void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void closeCurrentWindow() {
		driver.close();
		logMessage("Current window is closed");
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * This method overrides the default wait timeout with the new wait time
	 * provided.
	 * 
	 * @param implicitWaitTimeout
	 *            : new implicit wait timeout
	 * @param expicitWaitTimeout
	 *            : new explicit wait time out
	 */
	public void resetWaitTimeOut(int implicitWaitTimeout, int expicitWaitTimeout) {
		this.wait.resetImplicitTimeout(implicitWaitTimeout);
		this.wait.resetExplicitTimeout(expicitWaitTimeout);
		logMessage("Wait Time reset ( implicit - " + implicitWaitTimeout + "seconds" + " Explicit - "
				+ expicitWaitTimeout + "seconds )");
	}

	public void resetWaitTimeOutToDefault() {
		int timeout = Integer.parseInt(getProperty("Config.properties", "timeout"));
		logMessage("RESETTING TO DEFAULT WAIT TIME : " + timeout);
		this.wait.resetImplicitTimeout(timeout);
		this.wait.resetExplicitTimeout(timeout);
	}

	// Pending
	// Deletion============================================================================================================

	protected void isStringMatching(String actual, String expected) {
		logMessage("Comparing 2 strings");
		logMessage("EXPECTED STRING :" + expected);
		logMessage("ACTUAL STRING :" + actual);
		Assert.assertEquals(actual, expected, "The strings does not match!!!");
		logMessage("String compare Assertion passed.");
	}

	public void testPageLayout(List<String> tagsToBeTested) {
		layouttest.checklayout(tagsToBeTested);
	}

	public void testPageLayout(String tagToBeTested) {
		testPageLayout(Arrays.asList(tagToBeTested));
	}

	public void testPageLayout() {
		testPageLayout(Arrays.asList(getProperty("./Config.properties", "browser")));
	}

	protected boolean isElementDisplayed(String elementName, String elementTextReplace) {
		wait.waitForElementToBeVisible(waitAndFindElement(elementName, elementTextReplace));
		boolean result = waitAndFindElement(elementName, elementTextReplace).isDisplayed();
		assertTrue(result,
				"TEST FAILED: element '" + elementName + "with text " + elementTextReplace + "' is not displayed.");
		logMessage("TEST PASSED: element " + elementName + " with text " + elementTextReplace + " is displayed.");
		return result;
	}

	protected void verifyElementText(String elementName, String expectedText) {
		wait.waitForElementToBeVisible(waitAndFindElement(elementName));
		assertEquals(waitAndFindElement(elementName).getText().trim(), expectedText,
				"TEST FAILED: element '" + elementName + "' Text is not as expected: ");
		logMessage("TEST PASSED: element " + elementName + " is visible and Text is " + expectedText);
	}

	protected void verifyElementTextContains(String elementName, String expectedText) {
		wait.waitForElementToBeVisible(waitAndFindElement(elementName));
		assertThat("TEST FAILED: element '" + elementName + "' Text is not as expected: ",
				waitAndFindElement(elementName).getText().trim(), containsString(expectedText));
		logMessage("TEST PASSED: element " + elementName + " is visible and Text is " + expectedText);
	}

	protected boolean isElementDisplayed(String elementName) {
		wait.waitForElementToBeVisible(waitAndFindElement(elementName));
		boolean result = waitAndFindElement(elementName).isDisplayed();
		assertTrue(result, "TEST FAILED: element '" + elementName + "' is not displayed.");
		logMessage("TEST PASSED: element " + elementName + " is displayed.");
		return result;
	}

	protected boolean isElementNotDisplayed(String elementName) {
		boolean result;
		result = checkIfElementIsNotThere(elementName);
		assertTrue(result, "Assertion Failed: element '" + elementName + "' is displayed which should not be there");
		logMessage("Assertion Passed: element " + elementName
				+ " is not displayed after waiting for 10 seconds on the page as expected!!!");
		return result;
	}

	protected boolean isElementNotDisplayed(String elementName, String elementTextReplace) {
		boolean result;
		try {
			wait.waitForElementToBeVisible(waitAndFindElement(elementName, elementTextReplace));
			driver.findElement(getLocator(elementName, elementTextReplace));
			result = false;
		} catch (NoSuchElementException excp) {
			result = true;
		}
		assertTrue(result, "Assertion Failed: element '" + elementName + "' with text " + elementTextReplace
				+ " is displayed as expected");
		logMessage("Assertion Passed: element " + elementName + " with text " + elementTextReplace
				+ "is not displayed as expected!!!");
		return result;
	}

	protected boolean isElementEnabled(String elementName, boolean expected) {
		wait.waitForElementToBeVisible(waitAndFindElement(elementName));
		boolean result = expected && waitAndFindElement(elementName).isEnabled();
		assertTrue(result, "TEST FAILED: element '" + elementName + "' is  ENABLED :- " + !expected);
		logMessage("TEST PASSED: element " + elementName + " is enabled :- " + expected);
		return result;
	}

	protected boolean isElementDisplayed(String elementName, String elementTextReplace1, String elementTextReplace2) {
		wait.waitForElementToBeVisible(waitAndFindElement(elementName, elementTextReplace1, elementTextReplace2));
		boolean result = waitAndFindElement(elementName, elementTextReplace1, elementTextReplace2).isDisplayed();
		assertTrue(result, "TEST FAILED: element '" + elementName + "with text " + elementTextReplace1
				+ elementTextReplace2 + "' is not displayed.");
		logMessage("TEST PASSED: element " + elementName + " with text " + elementTextReplace1 + elementTextReplace2
				+ " is displayed.");
		return result;
	}

	public boolean waitForAValueToAppearForAnElementBasedOnGivenTime(String element, String expectedValue,
			int maxTimeInSeconds) {
		int i;
		boolean flag = false;
		wait.waitForPageToLoadCompletely();

		for (i = 1; i <= maxTimeInSeconds; i++) {
			if (waitAndFindElement(element).getText().trim().equalsIgnoreCase(expectedValue)) {
				flag = true;
				break;
			} else {
				wait.hardWait(1);
			}
		}

		return flag;
	}

	protected void verifyPageTitleExact() {
		String pageTitle = getPageTitleFromFile(pageName);
		verifyPageTitleExact(pageTitle);
	}

	protected WebElement getElementByExactText(List<WebElement> elementlist, String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().equalsIgnoreCase(elementtext.trim())) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list No element
		// exception
		if (element == null) {
		}
		return element;
	}

	protected WebElement getElementByContainsText(List<WebElement> elementlist, String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().contains(elementtext.trim())) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list
		if (element == null) {
		}
		return element;
	}

	public void navigateBackToTestEnvironment() {
		navigateToPreviousPage();
		if (ConfigPropertyReader.getProperty("tier").equalsIgnoreCase("Staging")
				|| ConfigPropertyReader.getProperty("tier").equalsIgnoreCase("Stag")) {
			String currentURL = getCurrentURL();
			if (!(currentURL.contains("qa")) && (currentURL.contains("hec.reisys.com"))) {
				navigateToPreviousPage();
			}
		}
	}

	public String createRedirectionToPubsTestEnvironment(String currentURL) {
		String baseURl = null;
		if (ConfigPropertyReader.getProperty("tier").equalsIgnoreCase("Staging")
				|| ConfigPropertyReader.getProperty("tier").equalsIgnoreCase("Stag")) {
			logMessage("DEBUG : " + currentURL);
			if (!(currentURL.contains("qa")) && (currentURL.contains("hec.reisys.com"))) {
				baseURl = currentURL.split(".org")[0];
				logMessage("DEBUG : " + baseURl);
				currentURL = currentURL.replaceAll(baseURl, "https://nasa-ebooks-qa.amer.reisystems.com");
				return currentURL;
			}
			logMessage("User is redirected to test environment - a known issue");
		} else {
			logMessage("no need for any redirections");
		}
		return currentURL;
	}
	
	protected WebElement getElement(String elementToken, String replacement1, String replacement2) {
		WebElement elem = null;
		elem = wait.waitForElementToBeVisible(driver.findElement(getLocator(elementToken, replacement1, replacement2)));
		return elem;
	}

	protected WebElement getElement(String elementToken) throws NoSuchElementException {
		WebElement elem = null;
		elem = wait.waitForElementToBeVisible(driver.findElement(getLocator(elementToken)));
		return elem;
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

}
