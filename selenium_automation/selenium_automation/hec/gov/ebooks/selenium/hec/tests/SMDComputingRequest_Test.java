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
import gov.ebooks.selenium.hec.pages.ComputingRequestPage;
import gov.ebooks.selenium.hec.pages.HECLoginPage;
import gov.ebooks.selenium.hec.pages.SMDManagerPage;
import gov.ebooks.selenium.hec.pages.SMDPage;

public class SMDComputingRequest_Test {
	TestSessionInitiator test;
	String emailId = null;
	String username = null;
	HECLoginPage loginPage;
	SMDPage smdPage;
	SMDManagerPage smdManagerPage;
	ComputingRequestPage computingRequestPage;

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		loginPage = new HECLoginPage(test.getDriver());
		smdPage = new SMDPage(test.getDriver());
		smdManagerPage = new SMDManagerPage(test.getDriver());
		computingRequestPage = new ComputingRequestPage(test.getDriver());
	}

	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
	public void smdCoverSheet() throws InterruptedException {
		loginPage.loadLoginPage();
		loginPage.loginSMD("wsun");
		assertTrue(computingRequestPage.submitCoverSheet());
	}
	
	@Test(priority=2)
	public void smdQuadChart() throws InterruptedException {
		assertTrue(computingRequestPage.submitQuadChart(computingRequestPage.getCrRequestNumber()));
	}
	
	@Test(priority=3)
	public void smdSOR() throws InterruptedException {
		assertTrue(computingRequestPage.submitSummaryOfRequirements(computingRequestPage.getCrRequestNumber()));
	}
	
	@Test(priority=4)
	public void smdFinalSubmission() throws InterruptedException {
		assertTrue(computingRequestPage.submitFinalSubmission(computingRequestPage.getCrRequestNumber()));
	}
	
	@Test(priority=5)
	public void smdlogout() throws InterruptedException{
		smdPage.logout();
	}
	
	@Test(priority=6)
	public void smdLogin1() throws InterruptedException {
	//	loginPage.loadLoginPage();
		loginPage.loginSMD("ssystem");
		assertTrue(smdManagerPage.verifyLandingPageForManagers());
	}
	
	@Test(priority=7)
	public void computingRequestReview() throws InterruptedException {
		assertTrue(smdManagerPage.eAlertComputingRequestReview());
	}
	
	@Test(priority=8)
	public void allocateComputingRequest() throws InterruptedException {
		assertTrue(smdManagerPage.allocateComputingRequest());
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