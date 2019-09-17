package utilities;

import com.thoughtworks.gauge.Gauge;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Common Steps for all pages of TAMS application
 */
public class Steps extends Driver {

    private Logger logger;
    static SoftAssert softAssert;

    protected Steps() { init(); }

    private void init () {
        logger = logger == null ? Logger.getLogger(Steps.class) : logger;
    }

    private SoftAssert softAssert () {
        String stepName = DataStore.getValueAsString("step name");
        boolean isAssertStatus = DataStore.isObjectKey(stepName + " assert");
        if ( !isAssertStatus ) {
            DataStore.storeObject(stepName + " assert", "start");
        }
        return softAssert;
    }

    protected void softAssertTrue ( boolean condition, String errorMessage ) {
        String assertionStatus;
        try {
            Assert.assertTrue(condition, errorMessage);
            assertionStatus = " Pass";
        } catch ( AssertionError e ) {
            assertionStatus = " Fail";
            Gauge.writeMessage(errorMessage);
            Gauge.captureScreenshot();
        }
        logger.info("Assert condition: " + condition + ". Status: " + assertionStatus);
        softAssert().assertTrue(condition, errorMessage);
    }

    protected void softAssertEquals ( String actualValue, String expectedValue, String errorMessage ) {
        String assertionStatus;
        try {
            Assert.assertEquals(actualValue, expectedValue, errorMessage);
            assertionStatus = " Pass";
        } catch ( AssertionError e ) {
            assertionStatus = " Fail";
            Gauge.writeMessage(errorMessage + ": " + "Expected: " + expectedValue + ", Actual: " + actualValue);
            Gauge.captureScreenshot();
        }
        logger.info("Assert: " + actualValue + " equals " + expectedValue + "? Status: " + assertionStatus);
        softAssert().assertEquals(actualValue, expectedValue, errorMessage);
    }

    protected void assertAll () {
        String stepName = DataStore.getValueAsString("step name");
        boolean isAssertStatus = DataStore.isObjectKey(stepName + " assert");
        if ( isAssertStatus ) {
            String assertStatus = DataStore.getValueAsString(stepName + " assert");
            if ( assertStatus.equals("start") ) {
                DataStore.storeObject(stepName + " assert", "done");
            }
        } else {
            String errorMessage = "Assert for Step \"" + stepName + "\" never started. Remove assertAll(); in the step or add assertion(s) before  assertAll();";
            logger.error(errorMessage);
            Gauge.writeMessage(errorMessage);
        }
        softAssert.assertAll();
    }

    void closeBrowser () {
        WebDriver webDriver = getDriver();
        if ( webDriver != null ) {
            webDriver.quit();
        }
    }
}
