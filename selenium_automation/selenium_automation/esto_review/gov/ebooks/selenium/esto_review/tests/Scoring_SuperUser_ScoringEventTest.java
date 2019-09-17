package gov.ebooks.selenium.esto_review.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.LeadReviewer;
import gov.ebooks.selenium.esto_review.pages.ManageProposal;
import gov.ebooks.selenium.esto_review.pages.ManageUsers;
import gov.ebooks.selenium.esto_review.pages.PM_MangeProposalStagesPage;
import gov.ebooks.selenium.esto_review.pages.Scoring_SuperUser_ScoringEventPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

public class Scoring_SuperUser_ScoringEventTest {
	private TestSessionInitiator test;
	private CommonMethodsPages commonMethodsPages;
	private LeadReviewer leadReviewer;
	private Scoring_SuperUser_ScoringEventPage scoring_SuperUser_ScoringEventPage;
	
	@BeforeClass
	public void Start_Test_Session() {  //throws Exception 
		//String UserName = "achapin";
		//String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));

		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		leadReviewer = new LeadReviewer(test.getDriver());
		scoring_SuperUser_ScoringEventPage = new Scoring_SuperUser_ScoringEventPage(test.getDriver());

		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
	}
	
	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
//	commonMethodsPages.ESTOLogin("achapin","rev_qa");	
	public void ESTOLogin1() throws InterruptedException {
	commonMethodsPages.ESTOLogin("ssystem", "rev_qa");	
		//assertTrue(testResult);	
	}
	
	@Test(priority=2)
	public void selectACT16Solicitation(){
		commonMethodsPages.SelectACT16Solicitation();
	}
	
	@Test(priority=3)
	public void clickSelectSolicitationButton(){
		commonMethodsPages.ClickSelectSolicitationButton();		
	}
	
	@Test(priority=4)
	public void searchProposal() throws InterruptedException{
		assertTrue(scoring_SuperUser_ScoringEventPage.searchProposal("16-AIST16-0100"));		
	}
	
	@Test(priority=5)
	public void panelScoringOverview() throws InterruptedException{
		assertTrue(scoring_SuperUser_ScoringEventPage.panelScoringOverview());		
	}
	
	@Test(priority=6)
	public void verifyPanelStartScoring() throws InterruptedException{
		assertTrue(scoring_SuperUser_ScoringEventPage.verifyPanelStartScoring());		
	}
	
	@Test(priority=7)
	public void verifyPanelEndScoring() throws InterruptedException{
		assertTrue(scoring_SuperUser_ScoringEventPage.verifyPanelEndScoring());		
	}
	
	@Test(priority=8)
	public void leadReviewerLogout() throws InterruptedException{
		leadReviewer.logout();		
	}
	
//	@Test(priority=7)
//	public void mangeProposalStagesPage() throws InterruptedException{
//		mangeProposalStagesPage.NavToManagePropStage();		
//	}
//	
//	@Test(priority=8)
//	public void SelectProposalToManage() throws InterruptedException{
//		mangeProposalStagesPage.SelectProposalToManage();		
//	}
//	
//	@Test(priority=9)
//	public void ClickAddButton() throws InterruptedException{
//		mangeProposalStagesPage.ClickAddButton();		
//	}
//	
//	@Test(priority=10)
//	public void SelectStageDD() throws InterruptedException{
//		mangeProposalStagesPage.SelectStageDD("Quality Control");		
//	}
//	
//	@Test(priority=11)
//	public void SubmitButton() throws InterruptedException{
//		mangeProposalStagesPage.SubmitButton();		
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


