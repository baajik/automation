package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Common actions
 */
public class Page {

    private Logger logger;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;

    protected Page( WebDriver webDriver ) { init(webDriver); }

    private void init ( WebDriver webDriver ) {
        this.logger = this.logger == null ? Logger.getLogger(Page.class) : this.logger;
        this.webDriver = this.webDriver == null ? webDriver : this.webDriver;
        this.webDriverWait = this.webDriverWait == null ? new WebDriverWait(webDriver, 15) : this.webDriverWait;
        this.javascriptExecutor = this.javascriptExecutor == null ? (JavascriptExecutor) webDriver : this.javascriptExecutor;
        PageFactory.initElements(webDriver, this);
    }

    protected SoftAssert softAssert () {
        return Steps.softAssert;
    }

    protected void navigateUrl ( String url ) {
        webDriver.get(url);
    }

    /**
     * The method is application specific
     */
    private void waitUntilFinishLoading () {
        try {
            waitElementInvisibility(By.cssSelector(".fa-spinner"));
            waitElementInvisibility(By.cssSelector("[aria-label='please wait loading...']"));
        } catch ( TimeoutException e ) {
            String errorMessage = "Spinner was spinning more than 15 seconds";
            logger.error(errorMessage);
            Common.failTest(errorMessage);
        }
    }

    protected void scrollToElement ( By by ) { scrollToElement(getElement(by)); }

    protected void scrollToElement ( WebElement webElement ) {
        waitElementVisibility(webElement);
        int y = webElement.getLocation().getY() - 200;
        javascriptExecutor.executeScript("window.scroll(0, " + y + ")");
    }

    protected void scrollToElementView ( By by ) { scrollToElementView(getElement(by)); }

    protected void scrollToElementView ( WebElement webElement ) {
        waitElementVisibility(webElement);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    protected void waitElementVisibility ( By by ) {
        waitUntilFinishLoading();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitElementVisibility ( WebElement webElement ) {
        waitUntilFinishLoading();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitElementInvisibility ( By by ) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected WebElement getElement ( By by ) {
        waitElementVisibility(by);
        return webDriver.findElement(by);
    }

    protected WebElement getElementInElement ( By byParent, By byChild ) {
        WebElement webElement = getElement(byParent);
        return webElement.findElement(byChild);
    }

    protected List<WebElement> getElements ( By by ) {
       waitElementVisibility(by);
       return webDriver.findElements(by);
    }

    protected List<WebElement> getElementsInElement ( By byParent, By byChild ) {
        WebElement webElement = getElement(byParent);
        return webElement.findElements(byChild);
    }

    protected List<String> getElementsString ( By by ) { return getElements(by).stream().map(this::getText).collect(Collectors.toList()); }

    protected List<String> getElementsInElementString ( By byParent, By byChild ) { return getElementsInElement(byParent, byChild).stream().map(this::getText).collect(Collectors.toList()); }

    protected void click(By by) { click(getElement(by)); }

    protected void click(By byParent, By byChild ) {
        click(getElementInElement(byParent, byChild));
    }

    protected void click(WebElement webElement ) {
        try {
            scrollToElement(webElement);
            webElement.click();
        } catch ( WebDriverException e ) {
            logger.error("Click failed for element '" + webElement.toString() + "'");
            Common.sleep(1);
            scrollToElement(webElement);
            webElement.click();
        }
    }

    protected String sendKeys(By by, String text ) {
        return sendKeys(getElement(by), text);
    }

    protected String sendKeys(By byParent, By byChild, String text ) {
        return sendKeys(getElementInElement(byParent, byChild), text);
    }

    protected String sendKeys( WebElement webElement, String text ) {
        scrollToElement(webElement);
        webElement.clear();
        webElement.sendKeys(text);
        return getAttribute(webElement, "value");
    }

    protected void uploadFile ( By by, String path ) {
        webDriver.findElement(by).sendKeys(path);
    }

    /**
     * @author erlan.beisen
     * @param byDropdown - Dropdown web element locator (By)
     * @param value - value
     * @return - selected dropdown value
     */
    protected String selectDropdown ( By byDropdown, String value ) {
        Select select = new Select(getElement(byDropdown));
        select.selectByVisibleText(value);
        return getText(select.getFirstSelectedOption());
    }

    protected String randomSelectDropdown ( By byDropdown ) {
        Select select = new Select(getElement(byDropdown));
        int maxSize = select.getOptions().size();
        select.selectByIndex(Common.getRandomInt(0, maxSize - 1));
        return getText(select.getFirstSelectedOption());
    }

    protected String selectedDropdownValue ( By byDropdown ) {
        Select select = new Select(getElement(byDropdown));
        return getText(select.getFirstSelectedOption());
    }

    protected String getText ( By by ) {
        String text = null;
        try {
            text = getText(getElement(by));
        } catch ( TimeoutException e ) { logger.error("Web Element: " + by.toString() + " not found, return null"); }
        return text;
    }

    protected String getText ( By byParent, By byChild ) {
        String text = null;
        try {
            text = getText(getElementInElement(byParent, byChild));
        } catch ( TimeoutException e ) { logger.error("Web Element: " + byChild.toString() + " not found, return null"); }
        return text;
    }

    protected String getText ( WebElement webElement ) {
        String text = null;
        try {
            waitElementVisibility(webElement);
            text = webElement.getText().replaceAll("\\s+", " ").trim();
        } catch ( TimeoutException e ) { logger.error("Web Element: " + webElement.toString() + " not found"); }
        return text;
    }

    protected String getAttribute ( By by, String attribute ) {
        return getAttribute(getElement(by), attribute);
    }

    protected String getAttribute ( By byParent, By byChild, String attribute ) {
        return getAttribute(getElementInElement(byParent, byChild), attribute);
    }

    protected String getAttribute ( WebElement webElement, String attribute ) {
        return webElement.getAttribute(attribute).replaceAll("\\s+", " ").trim();
    }

    protected boolean isDisplayed ( By by ) {
        waitUntilFinishLoading();
        return isElement(by) ? webDriver.findElement(by).isDisplayed() : isElement(by);
    }

    /**
     * @author erlan.beisen
     * @param by - by
     * @return is web element exists in DOM
     */
    private boolean isElement ( By by ) {
        boolean isElement = false;
        try {
            webDriver.findElement(by);
            isElement = true;
        } catch ( NoSuchElementException e ) {
                logger.error("No such web element with locator " + by.toString());
        }
        return isElement;
    }
}