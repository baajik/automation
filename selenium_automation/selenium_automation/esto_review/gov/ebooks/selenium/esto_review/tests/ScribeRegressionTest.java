package gov.ebooks.selenium.esto_review.tests;

import java.util.Date;
import java.util.ArrayList;
import java.util.Date;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;

import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;

import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.ReviewerAccessOfProposalLinksPage;
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposalStagePage;
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposal_AssignUserPage;
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposal_AssignUserPage;
import gov.ebooks.selenium.esto_review.pages.ScribeRegressionPage;



public class ScribeRegressionTest {
	/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private AdminUser_ManageProposalStagePage AdminUser_ManageProposalStagePage;
	private AdminUser_ManageProposal_AssignUserPage AdminUser_ManageProposal_AssignUserPage;
	private ScribeRegressionPage ScribeRegressionPage;
	private ReviewerAccessOfProposalLinksPage ReviewerAccessOfProposalLinksPage;
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception 
	{
		String UserName = "sozog";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages (test.getDriver());
		AdminUser_ManageProposal_AssignUserPage = new AdminUser_ManageProposal_AssignUserPage(test.getDriver());
		AdminUser_ManageProposalStagePage= new AdminUser_ManageProposalStagePage(test.getDriver());
		ScribeRegressionPage= new ScribeRegressionPage(test.getDriver());
		ReviewerAccessOfProposalLinksPage = new ReviewerAccessOfProposalLinksPage(test.getDriver());
		
	
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
		// Alternate method to lunch the HomePage
		//Driver.GoTo("https://nasa-ebooks-qa.amer.reisystems.com/review/login");

		boolean LaunchESTOReviewHomePage = homePage.ESTOReview();
		//Driver.Sleep(5);
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin = CommonMethodsESTOReviewPages.ESTOLogin(UserName, Password);
		//Driver.Sleep(3);
		Helper.ShowTestResult("** Verify PM Login to ESTO Review System.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PM Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation for - Scribe Link Validation and enter notes.\r\n");
			System.out.println("====================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_Scribe"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

/*			CommonMethodsESTOReviewPages.SelectACT17Solicitation();
			boolean SelectSoliciation = CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
*/
			String SearchForProposalNumber = "17-ACT17-0038";
			
/*			CommonMethodsESTOReviewPages.NavOfSearchIcon();
			boolean searchFilter = CommonMethodsESTOReviewPages.FunctionSearchFilter();
			*/
			boolean searchFilter = CommonMethodsESTOReviewPages.SearchByProposalNumber(); //(SearchForProposalNumber);
			Helper.ShowTestResult("2. Search by Proposal number.", searchFilter);
			DataManager.SaveTestResult("Search by Proposal number", searchFilter? "Passed" : "Failed", "Test Execution Completed Successfully!");
			CommonMethodsESTOReviewPages.ClickExpanArrow();			
			
// Test of access of submitted documents (links)
			//Driver.Sleep(5);

			boolean ClickOfCompletePackage = ReviewerAccessOfProposalLinksPage.ClickOfCompleteProposalPackage();
			Helper.ShowTestResult("3. Click download of Complete Proposal Package.", ClickOfCompletePackage);
			DataManager.SaveTestResult("Click download of Complete Proposal Package", ClickOfCompletePackage? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickOfCoversheet = ReviewerAccessOfProposalLinksPage.ClickOfCoverSheet();
			Helper.ShowTestResult("4. Click download of Cover Sheet.", ClickOfCoversheet);
			DataManager.SaveTestResult("Click download of Cover Sheet", ClickOfCoversheet? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickOfTecProposal = ReviewerAccessOfProposalLinksPage.ClickOfTechnicalProposal();
			Helper.ShowTestResult("5. Click download of Technical Proposal.", ClickOfTecProposal);
			DataManager.SaveTestResult("Click download of Technical Proposal", ClickOfTecProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickofLOE = ReviewerAccessOfProposalLinksPage.ClickOfLOE();
			Helper.ShowTestResult("6. Click download of LOE.", ClickofLOE);
			DataManager.SaveTestResult("Click download of LOE", ClickofLOE? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickOfResume = ReviewerAccessOfProposalLinksPage.ClickOfResumes();
			Helper.ShowTestResult("7. Click download of Resume.", ClickOfResume);
			DataManager.SaveTestResult("Click download of Resume", ClickOfResume? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickOfBugetData = ReviewerAccessOfProposalLinksPage.ClickOfSupportingBudgetData();
			Helper.ShowTestResult("8. Click download of Support Budget Data.", ClickOfBugetData);
			DataManager.SaveTestResult("Click download of Support Budget Data", ClickOfBugetData? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean ClickOfQuadChart = ReviewerAccessOfProposalLinksPage.ClickOfQuadChart();
			Helper.ShowTestResult("9. Click download of Quad Chart.", ClickOfQuadChart);
			DataManager.SaveTestResult("Click download of Quad Chart", ClickOfQuadChart? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickOfProposalInformation = ReviewerAccessOfProposalLinksPage.ClickOfProposalInformation();
			Helper.ShowTestResult("10. Click of Proposal Information.", ClickOfProposalInformation);
			DataManager.SaveTestResult("Click of Proposal Information", ClickOfProposalInformation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
// Open My Discussion Notes and provide notes		

			boolean NavMyDiscussion = ScribeRegressionPage.NavToMyDiscussionNotes();
			Helper.ShowTestResult("12. Navigation of My Discussion Page.", NavMyDiscussion);
			DataManager.SaveTestResult("Navigation of My Discussion Page", NavMyDiscussion? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean EnterNotes = ScribeRegressionPage.EnterValueInNotes();
			Helper.ShowTestResult("13. Enter notes in Field.", EnterNotes);
			DataManager.SaveTestResult("Enter notes in Field.", EnterNotes? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SaveFunction = ScribeRegressionPage.SaveButton();
			Helper.ShowTestResult("14. Access of Save Button", SaveFunction);
			DataManager.SaveTestResult("Access of Save Button", SaveFunction? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClosingOfPopUp  = ScribeRegressionPage.ClosePopUp();
			Helper.ShowTestResult("15. Closing of Pop Up Box.", ClosingOfPopUp);
			DataManager.SaveTestResult("Closing of Pop Up Box", ClosingOfPopUp? "Passed" : "Failed", "Test Execution Completed Successfully!");
/*			
			boolean NavViewEvaluation  = ScribeRegressionPage.NavToViewEvaluation();
			ScribeRegressionPage.ClosePopUp();
			Helper.ShowTestResult("16. Navigation of View Evaluation Page.", NavViewEvaluation);
			DataManager.SaveTestResult("Navigation of View Evaluation Page", NavViewEvaluation? "Passed" : "Failed", "Test Execution Completed Successfully!");
		*/	
			
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System Scribe function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Scribe.", "Failed", "Test Execution Failed!");
		}	
	}


		@AfterClass
		public void tearDownAfterClass() //throws Exception 
		{
	// Logout from the system
			boolean LogoutFunc = CommonMethodsESTOReviewPages.EstoReviewEvalutionLogout();
			//Driver.Sleep(2);
			Helper.ShowTestResult("** Verify Logout function.", LogoutFunc);
			DataManager.SaveTestResult("Verify Logout function.", LogoutFunc? "Passed" : "Failed" , "Test Execution Completed Successfully!");
			test.closeBrowserSession();
//			Driver.TearDown();

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Scribe.", "Program Manager_Manage Proposal Stage");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}			


}
