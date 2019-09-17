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
import gov.ebooks.selenium.hec.pages.NonSMDPage;
import gov.ebooks.selenium.hec.pages.SMDPage;

public class HEC_Login_Test {
	TestSessionInitiator test;
	String emailId = null;
	String username = null;
	HECLoginPage loginPage;
	SMDPage smdPage;
	NonSMDPage nonSMDPage;
	

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		loginPage = new HECLoginPage(test.getDriver());
		smdPage = new SMDPage(test.getDriver());
		nonSMDPage = new NonSMDPage(test.getDriver());
	}

	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
		loginPage.loadLoginPage();
	}
	
	@Test(priority=1)
	public void testLoginPage() throws InterruptedException{
		assertTrue(loginPage.verifyLoginPage());
	}
	
	@Test(priority=2)
	public void testUserRegistration() throws InterruptedException{
		assertTrue(loginPage.userRegistrationPage());
	}
	
	@Test(priority=3)
	public void testForgotPassword() throws InterruptedException{
		assertTrue(loginPage.forgotPasswordPage());
	}
	
	@Test(priority=4)
	public void testSMDLogin() throws InterruptedException{
		loginPage.loginSMD("wsun");
		assertTrue(loginPage.verifySMDLogin());
		smdPage.logout();
	}
	@Test(priority=5)
	public void testNonSMDLogin() throws InterruptedException{
		loginPage.loginNonSMD("wsun");
		nonSMDPage.logout();
	}
	
	@Test(priority=6)
	public void testLoginValidation() throws InterruptedException{
		assertTrue(loginPage.verifyLoginValidations("wsun"));
		nonSMDPage.logout();
	}
	
	@Test(priority=7)
	public void testLoginWrongCredentials() throws InterruptedException{
		assertTrue(loginPage.loginWrongCredentials("www"));
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
