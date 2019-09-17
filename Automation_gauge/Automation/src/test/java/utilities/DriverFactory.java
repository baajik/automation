package utilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Web Driver set up
 */
class DriverFactory {

    private static Logger logger;

    DriverFactory () {}

    static { init(); }

    private static void init () {
        logger = logger == null ? Logger.getLogger(DriverFactory.class) : logger;
    }

    /**
     * @author erlan.beisen
     * @return Chrome web driver
     */
    static WebDriver getActiveDriver () /*throws MalformedURLException*/ {
//        Capabilities chromeCapabilities = DesiredCapabilities.chrome();
//        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
        ChromeDriverManager.chromedriver().setup();
        logger.info("Chrome Driver set up");
        return new ChromeDriver(/*chromeCapabilities*/);
    }
}
