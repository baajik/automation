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

public class SMDRoses_Test {
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
			assertTrue(smdPage.verifySMDPage());
		}
		
		@Test(priority=2)
		public void smdRosesRequest() throws InterruptedException {
			assertTrue(smdPage.startNewRequest());
		}
		
		@Test(priority=3)
		public void smdCreateRosesRequest() throws InterruptedException {
			assertTrue(smdPage.createNewRosesEligibilityRequest());
		}
		
		@Test(priority=4)
		public void smdlogout() throws InterruptedException{
			smdPage.logout();
		}
		
		@Test(priority=5)
		public void smdLogin1() throws InterruptedException {
			loginPage.loginSMD("ssystem");
			assertTrue(smdManagerPage.verifyLandingPageForManagers());
		}
		
		@Test(priority=6)
		public void selectionProcess() throws InterruptedException{
			smdManagerPage.rosesSelection(smdPage.getRosesRequestNumber());
		}
		
		@Test(priority=7)
		public void hecManagerPage() throws InterruptedException{
			assertTrue(smdManagerPage.eAlertRosesReview(smdPage.getRosesRequestNumber()));
		}
		
		@Test(priority=8)
		public void confirmRequest() throws InterruptedException{
			assertTrue(smdManagerPage.confirmRequest());
		}
		
		@Test(priority=9)
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


