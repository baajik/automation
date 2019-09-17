package gov.ebooks.selenium.esto_review.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.LeadReviewer;
import gov.ebooks.selenium.esto_review.pages.ManageProposal;
import gov.ebooks.selenium.esto_review.pages.QualityControlPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

public class LeadReviewerTest {

	private TestSessionInitiator test;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages commonMethodsESTOReviewPages;
	private ManageProposal manageProposalPage;
	private LeadReviewer leadReviewer;
	private QualityControlPage qualityControlPage;
	
//	private String proposalNumber = "17-ACT17-0038";
	private String UserName = "jhoward2";
	private String Password = "rev_qa";
	
	@BeforeClass
	public void Start_Test_Session() {  
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		commonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
		manageProposalPage = new ManageProposal(test.getDriver());
		leadReviewer = new LeadReviewer(test.getDriver());
		qualityControlPage = new QualityControlPage(test.getDriver());

		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();	
	}
	
	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
	public void ESTOLogin1() throws InterruptedException {
	boolean LaunchESTOReviewHomePage = commonMethodsPages.ESTOLogin(UserName, Password);
	Helper.ShowTestResult("**1. Verification of ESTO Review Login.", LaunchESTOReviewHomePage);
	DataManager.SaveTestResult("Verification of ESTO Review Login.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");
    }
	
	@Test(priority=2)
	public void SelectACT17Solicitation(){
		boolean	selectSoliciation = commonMethodsESTOReviewPages.SelectACT17Solicitation();
		Helper.ShowTestResult("**2. Verification of select soliciation window.", selectSoliciation);
		DataManager.SaveTestResult("Verification of select soliciation window.", selectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");	    
	}
	
	@Test(priority=3)
	public void clickSelectSolicitationButton(){
		boolean clickSelectSolicitation = commonMethodsESTOReviewPages.ClickSelectSolicitationButton();	
		Helper.ShowTestResult("**3. Verification of click soliciation.", clickSelectSolicitation);
		DataManager.SaveTestResult("Verification of click soliciation.", clickSelectSolicitation? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=4)
	public void checkWebSocketStatus(){
		boolean checkWebsocketstatus = manageProposalPage.checkWebSocketStatus();
		Helper.ShowTestResult("**4. Verification of websocket status.", checkWebsocketstatus);
		DataManager.SaveTestResult("Verification of websocket status.", checkWebsocketstatus? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=5)
	public void searchProposal() throws InterruptedException{
		boolean searchProposal = commonMethodsESTOReviewPages.SearchByProposalNumber();
		Helper.ShowTestResult("**5. Verification of search proposal.", searchProposal);
		DataManager.SaveTestResult("Verification of search proposal.", searchProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=6)
	public void toggle() throws InterruptedException{
		boolean toggleProposal = qualityControlPage.toggle();	
		Helper.ShowTestResult("**6. Verification of proposal toggle.", toggleProposal);
		DataManager.SaveTestResult("Verification of proposal toggle.", toggleProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=7)
	public void verifyForLeadReviewer() throws InterruptedException{
		boolean leadReviewerUpdateEvaluationLink = leadReviewer.updateEvaluation();		
		Helper.ShowTestResult("**7. Verification of leadReviewer 'UpdateEvaluation' link.", leadReviewerUpdateEvaluationLink);
		DataManager.SaveTestResult("Verification of leadReviewer 'UpdateEvaluation' link.", leadReviewerUpdateEvaluationLink? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=8)
	public void verifyUpdateLeadReviewer() throws InterruptedException{
		boolean leadReviewerUpdateEvaluation = leadReviewer.verifyUpdateEvaluation();
		Helper.ShowTestResult("**8. Verification of leadReviewer UpdateEvaluation Page.", leadReviewerUpdateEvaluation);
		DataManager.SaveTestResult("Verification of leadReviewer UpdateEvaluation Page.", leadReviewerUpdateEvaluation? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=9)
	public void toggleToVerifyActiveStage() throws InterruptedException{
		boolean toggleProposal = qualityControlPage.toggle();	
		Helper.ShowTestResult("**9. Verification of proposal toggle.", toggleProposal);
		DataManager.SaveTestResult("Verification of proposal toggle.", toggleProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=10)
	public void verifyActiveStage() throws InterruptedException{
		boolean nextActiveStage = leadReviewer.verifyActiveStage();	
		Helper.ShowTestResult("**10. Verification of next active stage.", nextActiveStage);
		DataManager.SaveTestResult("Verification of next active stage.", nextActiveStage? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}
	
	@Test(priority=11)
	public void leadReviewerLogout() throws InterruptedException{
		boolean leadReviewerLogout = leadReviewer.logout();
		Helper.ShowTestResult("**11. Verification of leadReviewer logout.", leadReviewerLogout);
		DataManager.SaveTestResult("Verification of leadReviewer logout.", leadReviewerLogout? "Passed" : "Failed", "Test Execution Completed Successfully!");	
	}
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
		DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Review of proposal.", "Reviewer_Review of proposal");
		//Driver.Sleep(3);
	}

}


