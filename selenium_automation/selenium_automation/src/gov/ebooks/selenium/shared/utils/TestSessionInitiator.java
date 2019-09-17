package gov.ebooks.selenium.shared.utils;

import static gov.ebooks.selenium.shared.utils.ConfigPropertyReader.getProperty;
import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import static gov.ebooks.selenium.shared.utils.YamlReader.setYamlFilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import gov.ebooks.selenium.shared.utils.TakeScreenshot;

public class TestSessionInitiator {

	protected WebDriver driver;
	private final WebDriverFactory wdfactory;
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	String datafileloc = "";
	static int timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;
		

	/**
	 * Initiating the page objects
	 * _initPage
	 */
//	public ERSHomePage ersHomePage;
//	public LoginPage registrationAndLoginPage;
	public TakeScreenshot takescreenshot;

	public WebDriver getDriver() {
		return this.driver;
	}

//	private void _initPage() {
//		ersHomePage = new ERSHomePage(driver);
//		registrationAndLoginPage = new LoginPage(driver);
//		
//	}

	/**
	 * Page object Initiation done
	 * 
	 */
	public TestSessionInitiator(String testname, String packageString) {
		wdfactory = new WebDriverFactory();
		testInitiator(testname, packageString);
	}

	private void testInitiator(String testname, String packageString) {
		setYamlFilePath(packageString);
		_configureBrowser();
//		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
	}

	private void _configureBrowser() {
		driver = wdfactory.getDriver(_getSessionConfig());
		driver.manage().window().maximize();
		driver.manage()
				.timeouts()
				.implicitlyWait(Integer.parseInt(getProperty("timeout")),
						TimeUnit.SECONDS);
		driver.manage()
				.timeouts()
				.setScriptTimeout(Integer.parseInt(getProperty("timeout")),
						TimeUnit.SECONDS);
		
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "system", "browser", "seleniumserver",
				"seleniumserverhost", "timeout", "driverpathIE", "driverpathChrome", "driverpathFireFox", "driverpathMacFireFox" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("./Config.properties", string));
		}
		return config;
	}

	public void launchApplication() {
		launchApplication(getYamlValue("loginUrl"));
	}

	public void launchApplication(String loginUrl) {
		Reporter.log("The application url is :- " + loginUrl, true);
		Reporter.log("The test browser is :- " + _getSessionConfig().get("browser") + "\n", true);
		driver.manage().deleteAllCookies();
		driver.get(loginUrl);
	}

	public void stepStartMessage(String testStepName) {
		Reporter.log(" ", true);
		Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase() + " *****", true);
		Reporter.log(" ", true);
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}

	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void closeBrowserSession() {
		Reporter.log("Browser selected from 'Config.properties' file: "
				+ _getSessionConfig().get("browser"));
		
		/*if(_getSessionConfig().get("browser").equalsIgnoreCase("firefox")){
			Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
			driver.close();
		}
		driver.close();*/
		driver.quit();
	}

	
	public void pageRefresh(){
		driver.navigate().refresh();
	}
	
}

