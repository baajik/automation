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
import gov.ebooks.selenium.hec.pages.NonSMDAdminTools;
import gov.ebooks.selenium.hec.pages.NonSMDInformation;
import gov.ebooks.selenium.hec.pages.NonSMDPage;
import gov.ebooks.selenium.hec.pages.NonSMDReports;

public class NonSMD_Test {
	TestSessionInitiator test;
	String emailId = null;
	String username = null;
	HECLoginPage loginPage;
	NonSMDPage nonSMDPage;
	NonSMDInformation nonSMDInformation;
	NonSMDReports nonSMDReports;
	NonSMDAdminTools nonSMDAdminTools;

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		loginPage = new HECLoginPage(test.getDriver());
		nonSMDPage = new NonSMDPage(test.getDriver());
		nonSMDInformation = new NonSMDInformation(test.getDriver());
		nonSMDReports = new NonSMDReports(test.getDriver());
		nonSMDAdminTools = new NonSMDAdminTools(test.getDriver());
	}

	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
	public void nonsmdCreateRequest() throws InterruptedException {
		loginPage.loadLoginPage();
		loginPage.loginNonSMD("wsun");
		assertTrue(nonSMDPage.createNonSMDRequest());
	}
	
	@Test(priority=2)	
	public void submitCoverSheet() throws InterruptedException{
		assertTrue(nonSMDPage.submitNonSMDCoverSheet());
	}
	
	@Test(priority=3)	
	public void submitSOR() throws InterruptedException{
		assertTrue(nonSMDPage.submitNonSMDSOR());
	}

	@Test(priority=4)	
	public void submitQuadChart() throws InterruptedException{
		assertTrue(nonSMDPage.submitNonSMDQuadChart());
	}
	
	@Test(priority=5)	
	public void submitFinalSubmission() throws InterruptedException{
		assertTrue(nonSMDPage.submitNonSMDFinalSubmission());
	}
	
	@Test(priority=6)
	public void logout() throws InterruptedException{
		nonSMDPage.logout();
	}
	
	@Test(priority=7)
	public void nonsmdLogin() throws InterruptedException {
		//loginPage.loadLoginPage();
		loginPage.loginNonSMD("ssystem");
	}
	
	@Test(priority=8)
	public void adminToolsModifyRequest() throws InterruptedException {
		assertTrue(nonSMDAdminTools.adminToolsModifyRequest());
	}
	
	@Test(priority=9)
	public void adminToolsManageAssignment() throws InterruptedException {
		assertTrue(nonSMDAdminTools.adminToolsManageAssignment());
	}
	
	@Test(priority=10)
	public void adminToolsManageAllocation() throws InterruptedException {
		assertTrue(nonSMDAdminTools.adminToolsManageAllocation());
	}
	
	@Test(priority=11)
	public void adminToolsAwards() throws InterruptedException {
		assertTrue(nonSMDAdminTools.adminToolsAwards());
	}
	
	@Test(priority=12)
	public void myAccount() throws InterruptedException {
		assertTrue(nonSMDAdminTools.myAccount());
	}
	
	@Test(priority=13)
	public void reportsDownload() throws InterruptedException {
		assertTrue(nonSMDReports.reportsDownload());
	}
	
	@Test(priority=14)
	public void reportsSubmissionDetails() throws InterruptedException {
		assertTrue(nonSMDReports.reportsSubmissionDetails());
	}
	
	@Test(priority=15)
	public void reportsAllocationBinder() throws InterruptedException {
		assertTrue(nonSMDReports.reportsAllocationBinder());
	}
	
	@Test(priority=16)
	public void reportsPortfolio() throws InterruptedException {
		assertTrue(nonSMDReports.reportsPortfolio());
	}
	
	@Test(priority=17)
	public void TechnicalSupport() throws InterruptedException {
		assertTrue(nonSMDInformation.InfoTechnicalSupport());
	}
	
	@Test(priority=18)
	public void RollingCalls() throws InterruptedException {
		assertTrue(nonSMDInformation.InfoRollingCalls());
	}
	
	@Test(priority=19)
	public void SubmissionInstruction() throws InterruptedException {
		assertTrue(nonSMDInformation.InfoSubmissionInstruction());
	}
	
	@Test(priority=20)
	public void FundingManagersList() throws InterruptedException {
		assertTrue(nonSMDInformation.InfoFundingManagersList());
	}
	
	@Test(priority=21)
	public void QCTemplates() throws InterruptedException {
		assertTrue(nonSMDInformation.InfoQCTemplates());
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
