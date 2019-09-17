/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.ebooks.selenium.shared.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    private static String browser;
//    private static final DesiredCapabilities capabilities = new DesiredCapabilities();

    public WebDriver getDriver(Map<String, String> seleniumconfig) {
        browser = seleniumconfig.get("browser");
        if(seleniumconfig.get("system").equalsIgnoreCase("windows")){
	        if (seleniumconfig.get("seleniumserver").equalsIgnoreCase("local")) {
	            if (browser.equalsIgnoreCase("firefox")) {
	                return getFirefoxDriver(seleniumconfig.get("driverpathFireFox"));
	            } else if (browser.equalsIgnoreCase("chrome")) {
	                return getChromeDriver(seleniumconfig.get("driverpathChrome"));
	            } else if (browser.equalsIgnoreCase("Safari")) {
	                return getSafariDriver();
	            } else if ((browser.equalsIgnoreCase("ie"))
	                    || (browser.equalsIgnoreCase("internetexplorer"))
	                    || (browser.equalsIgnoreCase("internet explorer"))) {
	                return getInternetExplorerDriver(seleniumconfig.get("driverpathIE"));
	            }
	        }
	        if (seleniumconfig.get("seleniumserver").equalsIgnoreCase("remote")) {
	            return setRemoteDriver(seleniumconfig);
	        }
        }else{
        	return getFirefoxDriver(seleniumconfig.get("driverpathMacFireFox"));
        }
        return new FirefoxDriver();
    }

    private WebDriver setRemoteDriver(Map<String, String> selConfig) {
        DesiredCapabilities cap = null;
        browser = selConfig.get("browser");
        if (browser.equalsIgnoreCase("firefox")) {
            cap = DesiredCapabilities.firefox();
        } else if (browser.equalsIgnoreCase("chrome")) {
            cap = DesiredCapabilities.chrome();
        } else if (browser.equalsIgnoreCase("Safari")) {
            cap = DesiredCapabilities.safari();
        } else if ((browser.equalsIgnoreCase("ie"))
                || (browser.equalsIgnoreCase("internetexplorer"))
                || (browser.equalsIgnoreCase("internet explorer"))) {
            cap = DesiredCapabilities.internetExplorer();
        }
        String seleniuhubaddress = selConfig.get("seleniumserverhost");
        URL selserverhost = null;
        try {
            selserverhost = new URL(seleniuhubaddress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        cap.setJavascriptEnabled(true);
        return new RemoteWebDriver(selserverhost, cap);
    }

    private static WebDriver getChromeDriver(String driverpath) {
        System.setProperty("webdriver.chrome.driver", driverpath);
        return new ChromeDriver();
//      code used by the previous version of Selenium. Kept for configurations
//        ChromeOptions options = new ChromeOptions();
//        DesiredCapabilities cap = DesiredCapabilities.chrome();    
//        cap.setCapability(ChromeOptions.CAPABILITY, options);         
//        return new ChromeDriver(options);
        
        
    }

    private static WebDriver getInternetExplorerDriver(String driverpath) {
        System.setProperty("webdriver.ie.driver", driverpath);
        return new InternetExplorerDriver();
//      code used by the previous version of Selenium. Kept for configurations
//        capabilities.setCapability("ignoreZoomSetting", true);
//        capabilities.setCapability("ignoreZoomLevel", true);
//        capabilities.setJavascriptEnabled(true);
//        return new InternetExplorerDriver(capabilities);
        
    }

    private static WebDriver getSafariDriver() {
        return new SafariDriver();
    }

    private static WebDriver getFirefoxDriver(String driverpath) {
    	System.setProperty("webdriver.gecko.driver", driverpath);
  //  	return new FirefoxDriver();
    	FirefoxOptions options = new FirefoxOptions();
//        options.addPreference("browser.helperApps.neverAsk.openFile", "application/vnd.ms-excel");
//        options.addPreference("browser.download.folderList",2);
//        options.addPreference("browser.download.dir", "/Users/nayana.shivalingappa/Documents/Selenium/");           
    	options.addPreference("browser.download.folderList",2);
    	options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");
    	options.addPreference("browser.helperApps.neverAsk.saveToDisk", "image/png");

        options.addPreference("browser.download.dir", "/Users/nayana.shivalingappa/Documents/Selenium/");
        return new FirefoxDriver(options);
//      code used by the previous version of Selenium. Kept for configurations
//        FirefoxProfile profile = new FirefoxProfile();
//        FirefoxOptions options = new FirefoxOptions();
//        profile.setPreference("browser.cache.disk.enable", false);
//        profile.setPreference("javascript.enabled", true);
//        options.setProfile(profile);
//        return new FirefoxDriver(options);
    	
    }
}
