package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Driver class
 */
class Driver extends DriverFactory {

    private static Logger logger;

    /**
     * Web driver object
     */
    private static WebDriver webDriver;

    Driver () {}

    static { initWebDriver(); }

    private static void initWebDriver () {
        logger = logger == null ? Logger.getLogger(Driver.class) : logger;
        webDriver = webDriver == null ? getActiveDriver() : webDriver;
    }

    protected static WebDriver getDriver () {
        return webDriver;
    }
}
