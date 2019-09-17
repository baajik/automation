package gov.ebooks.selenium.hec.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import gov.ebooks.selenium.hec.pages.HECLoginPage;
import gov.ebooks.selenium.hec.pages.SMDManagerPage;
import gov.ebooks.selenium.hec.pages.SMDPage;


public class eligiblityValidation_Test {
	TestSessionInitiator test;
	String emailId = null;
	String username = null;
	HECLoginPage loginPage;
	SMDPage smdPage;
	SMDManagerPage smdManagerPage;

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		loginPage = new HECLoginPage(test.getDriver());
		smdPage = new SMDPage(test.getDriver());
		smdManagerPage = new SMDManagerPage(test.getDriver());
	}

	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
	public void smdLogin() throws InterruptedException {
		loginPage.loadLoginPage();
		loginPage.loginSMD("wsun");
	}
	
	@Test(priority=2)
	public void smdstartNewRosesRequest() throws InterruptedException {
		assertTrue(smdPage.startNewRequest());
	}
	
	@Test(priority=3)
	public void smdRosesValidation() throws InterruptedException {
		smdPage.eligiblityRequestROSESValidation();
	}
	
	@Test(priority=4)
	public void smdStartNewNonRoses() throws InterruptedException {
		assertTrue(smdPage.startNewNONROSESRequest());
	}
	
	@Test(priority=5)
	public void smdNonRosesValidation() throws InterruptedException {
		smdPage.eligiblityRequestNonROSESValidation();
	}
	
	@Test(priority=6)
	public void smdlogout1() throws InterruptedException{
		smdPage.logout();
	}
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
	}

}
