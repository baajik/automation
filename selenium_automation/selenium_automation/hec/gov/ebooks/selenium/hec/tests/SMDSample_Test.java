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
import gov.ebooks.selenium.hec.pages.NonSMDAdminTools;
import gov.ebooks.selenium.hec.pages.NonSMDInformation;
import gov.ebooks.selenium.hec.pages.NonSMDReports;
import gov.ebooks.selenium.hec.pages.SMDManagerPage;
import gov.ebooks.selenium.hec.pages.SMDPage;

public class SMDSample_Test {
	TestSessionInitiator test;
	String emailId = null;
	String username = null;
	HECLoginPage loginPage;
	SMDPage smdPage;
	SMDManagerPage smdManagerPage;
	ComputingRequestPage computingRequestPage;
	NonSMDReports nonSMDReports;
	NonSMDAdminTools nonSMDAdminTools;
	NonSMDInformation nonSMDInformation;



	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		loginPage = new HECLoginPage(test.getDriver());
		smdPage = new SMDPage(test.getDriver());
		smdManagerPage = new SMDManagerPage(test.getDriver());
		computingRequestPage = new ComputingRequestPage(test.getDriver());
		nonSMDReports = new NonSMDReports(test.getDriver());
		nonSMDAdminTools = new NonSMDAdminTools(test.getDriver());
		nonSMDInformation = new NonSMDInformation(test.getDriver());

	}

	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
//	
//	@Test(priority=1)
//	public void nonsmdLogin() throws InterruptedException {
//		loginPage.loadLoginPage();
//		loginPage.loginNonSMD("wsun");
//	}
	
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
//	@Test(priority=3)
//	public void RollingCalls() throws InterruptedException {
//		assertTrue(nonSMDInformation.InfoRollingCalls());
//	}
//	
//	@Test(priority=4)
//	public void SubmissionInstruction() throws InterruptedException {
//		assertTrue(nonSMDInformation.InfoSubmissionInstruction());
//	}
//	
//	@Test(priority=5)
//	public void FundingManagersList() throws InterruptedException {
//		assertTrue(nonSMDInformation.InfoFundingManagersList());
//	}
	
//	@Test(priority=6)
//	public void QCTemplates() throws InterruptedException {
//		assertTrue(nonSMDInformation.InfoQCTemplates());
//	}
	
	
//	@Test(priority=2)
//	public void reportsDownload() throws InterruptedException {
//		assertTrue(nonSMDReports.reportsDownload());
//	}
	
//	@Test(priority=2)
//	public void reportsSubmissionDetails() throws InterruptedException {
//		assertTrue(nonSMDReports.reportsSubmissionDetails());
//	}
//	
//	@Test(priority=3)
//	public void reportsAllocationBinder() throws InterruptedException {
//		assertTrue(nonSMDReports.reportsAllocationBinder());
//	}
//	
//	@Test(priority=4)
//	public void reportsPortfolio() throws InterruptedException {
//		assertTrue(nonSMDReports.reportsPortfolio());
//	}
//	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
	}
}