package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Date;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import gov.ebooks.selenium.appsci.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.ReviewerUpdateReviewPage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.ReviewerAccessOfProposalLinksPage;

/*
Access of all uploaded files 
Prerequisites: 
•	Reviewer already have proposal assigned
•	Proposal is in in Mail-in review stage

Reviewer to complete Conflict of Interest
1.	Launch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the checkbox to acknowledge the consent
5.	Click Login button

1.	Verify that Proposal Information is clickable, and content is displaying
2.	Verify that Complete Proposal Package is clickable
3.	Verify that Cover Sheet is clickable
4.	Verify that Technical Proposal is clickable
5.	Verify that Letters of Endorsement is clickable
6.	Verify that Resumes is clickable
7.	Verify that Supporting Budget Data is clickable
8.	Verify that Quad Chart is clickable

1.	Logout form application
2.	Close the browser

*/

public class ReviewerAccessOfProposalLinksTest 
{

/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private ReviewerAccessOfProposalLinksPage ReviewerAccessOfProposalLinksPage;
	
	//private String SearchForProposalNumber = "17-ACT17-0038";
	
	@BeforeClass
	public void setUpBeforeClass() //throws Exception 
	{
		//String UserName = "ADubey";
		String UserName = JDBCconnection.username;
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		ReviewerAccessOfProposalLinksPage = new ReviewerAccessOfProposalLinksPage(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
		
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
		Helper.ShowTestResult("** Verify PI Login to ESTO Review System.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in Proposal links by Reviewer.\r\n");
			System.out.println("======================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("Peer Review_Document Link"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");
/*
			boolean SelectSoliciation = ReviewerAccessOfProposalLinksPage.SelectACT17Solicitation();
			ReviewerAccessOfProposalLinksPage.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
	*/		
			
			
			
			boolean searchFilter = CommonMethodsESTOReviewPages.SearchByProposalNumber();
			Helper.ShowTestResult("2. Search by Proposal number.", searchFilter);
			DataManager.SaveTestResult("Search by Proposal number", searchFilter? "Passed" : "Failed", "Test Execution Completed Successfully!");
			//CommonMethodsESTOReviewPages.ClickExpanArrow();	
			
			
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
	
		}
		
			catch (Exception ex)
			{
				Helper.ShowTestResult("ESTO Review System Review of proposal function Test Case", false);
				DataManager.SaveTestResult("ESTO Review System Review of proposal.", "Failed", "Test Execution Failed!");
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
				//Driver.TearDown();

				DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Review of proposal.", "Reviewer_Review of proposal");
				//Driver.Sleep(3);

				Helper.ShowTestResult("* Browser close", true);
			}	
		
			
}
