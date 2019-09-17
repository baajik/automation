package gov.ebooks.selenium.hec.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import static org.testng.Assert.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import gov.ebooks.selenium.hec.pages.ComputingRequestPage;
import gov.ebooks.selenium.hec.pages.HECLoginPage;
import gov.ebooks.selenium.hec.pages.NonSMDAdminTools;
import gov.ebooks.selenium.hec.pages.NonSMDPage;
import gov.ebooks.selenium.hec.pages.NonSMDReports;
import gov.ebooks.selenium.hec.pages.SMDManagerPage;
import gov.ebooks.selenium.hec.pages.SMDPage;

public class Login_Test {

	TestSessionInitiator test;
	String emailId = null;
	String username = null;
	HECLoginPage loginPage;
	SMDPage	smdPage;
	SMDManagerPage smdManagerPage;
	ComputingRequestPage computingRequestPage;
	NonSMDPage nonSMDPage;
	NonSMDReports nonSMDReports;
	NonSMDAdminTools nonSMDAdminTools;

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		loginPage = new HECLoginPage(test.getDriver());
		smdPage = new SMDPage(test.getDriver());
		smdManagerPage = new SMDManagerPage(test.getDriver());
		computingRequestPage = new ComputingRequestPage(test.getDriver());
		nonSMDPage = new NonSMDPage(test.getDriver());
		nonSMDReports = new NonSMDReports(test.getDriver());
		nonSMDAdminTools = new NonSMDAdminTools(test.getDriver());
		
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
	}

	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
	public void smdLogin() throws InterruptedException {
		loginPage.loadLoginPage();
		loginPage.loginSMD("wsun");
		boolean testResult = smdPage.verifySMDPage();
		DataManager.SaveTestResult("SMD Login Test", testResult? "Passed" : "Failed", "Test Execution Completed Successfully!");
		assertTrue(testResult);
	}
	
	@Test(priority=2)
	public void smdRosesRequest() throws InterruptedException {
		assertTrue(smdPage.startNewNONROSESRequest());
	}
		
	@Test(priority=3)
	public void validation() throws InterruptedException{
		smdPage.eligiblityRequestNonROSESValidation();
	}
	
//	@Test(priority=1)	
//	public void HECLogin() throws InterruptedException{
//		loginPage.loadLoginPage();
//		assertTrue(loginPage.verifyLoginPage()
//				&& loginPage.verifySMDLogin("wsun")
//				 && loginPage.verifyNonSMDLogin("wsun"));
//	}
	
//	@Test(priority=2)	
//	public void NonSMD() throws InterruptedException{
//		assertTrue(nonSMDPage.createNonSMDRequest()
//				&& nonSMDPage.submitNonSMDCoverSheet(nonSMDPage.getNonSMDRequestNumber())
//				&& nonSMDPage.submitNonSMDSOR(nonSMDPage.getNonSMDRequestNumber())
//				&& nonSMDPage.submitNonSMDQuadChart()
//				&& nonSMDPage.submitNonSMDFinalSubmission()); 
	
   // }
	
//	@Test(priority=2)	
//	public void SMD() throws InterruptedException{
//		assertTrue(smdPage.verifySMDPage()
//				&& smdPage.startNewRequest()
//				&& smdPage.createNewRosesEligibilityRequest()
//				&& smdPage.startNewNONROSESRequest()
//         		&& smdPage.createNewNONRosesEligibilityRequest());
//	}
	
//	@Test(priority=2)	
//	public void ComputingRequestPage() throws InterruptedException{
//		 assertTrue(computingRequestPage.submitCoverSheet()
//		&& computingRequestPage.submitQuadChart()
//		&& computingRequestPage.submitSummaryOfRequirements()
//				&& computingRequestPage.submitFinalSubmission());
//	}

//	@Test(priority=3)
//	public void HECLogin1() throws InterruptedException{
//		loginPage.loadLoginPage();
//		assertTrue(loginPage.verifyLoginPage()
//				&& loginPage.verifySMDLogin("ssystem"));
//	}
	
//	@Test(priority=3)	
//	public void SMDManagerPage() throws InterruptedException{
//		assertTrue(smdManagerPage.verifyLandingPageForManagers()
//				&& smdManagerPage.eAlertReview(smdPage.getNonRosesRequestNumber())
//				&& smdManagerPage.confirmRequest()
//				&& smdManagerPage.eAlertComputingRequestReview()
//				&& smdManagerPage.eAlertComputingRequestReview());
//	}
	
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
	}

}

