package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;

import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.PM_MangeProposalStagesPage;
import gov.ebooks.selenium.esto_review.pages.ReviewerUpdateReviewPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

import org.testng.annotations.BeforeClass;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;

import java.util.ArrayList;
import java.util.Date;

import org.testng.annotations.AfterClass;

/*
Manage Proposal Stage by Program Manager

Prerequisites: 
•	Reviewer already have Solicitation Assigned.

Program Manager to move Proposal Stage
1.	Lunch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the check box to acknowledge the consent
5.	Click Login button

6.	Select the solicitation which that user wishes to work on if selection of Solicitation pop up box display, other wise proceed with next Test Case
7.	Select Manage Proposal Stages from Administrator Tool
8.	Enter “Panel Official” in Search box. Verify that Proposal list box is displaying proposal which are in current Stage.
9.	Enter “003” in Search box. Verify that Proposal list box is displaying proposal for proposal number.
10.	Select the Proposal number “16-AIST16-0010”.
11.	Click Add button. Verify that same proposal is displaying in Selected Proposals box.

12.	Enter Submit button
13.	Verify that Selected solicitation is remove from display

14.	Logout form application
15.	Close the browser


*/


public class PM_ManageProposalStagesTest {
	
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private PM_MangeProposalStagesPage PM_MangeProposalStagesPage;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception 
	{
		String UserName = "mlittle";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		PM_MangeProposalStagesPage = new PM_MangeProposalStagesPage(test.getDriver());
	
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
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System PM Manage Proposal Stage.\r\n");
			System.out.println("=================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_PM Manage Proposal Stage"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			boolean SelectSoliciation = PM_MangeProposalStagesPage.SelectACT16Solicitation();
			PM_MangeProposalStagesPage.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ExpandAdminTool = PM_MangeProposalStagesPage.NavToManagePropStage();
			Helper.ShowTestResult("2. Verification of Navigation to Manage Prop Stage.", ExpandAdminTool);
			DataManager.SaveTestResult("Verification of Navigation to Manage Prop Stage", ExpandAdminTool? "Passed" : "Failed", "Test Execution Completed Successfully!");

			String CurrentStage = "Lead Reviewer";
			String ProposalNumber = "16-AIST16-0004";
			
			boolean SerachByStage = PM_MangeProposalStagesPage.SearchByCurrentStage(CurrentStage);
			Helper.ShowTestResult("3. Verification of Search filter - Current Stage.", SerachByStage);
			DataManager.SaveTestResult("Verification of Search filter - Current Stage", SerachByStage? "Passed" : "Failed", "Test Execution Completed Successfully!");
/*	
			boolean VerifyStageSearchResult = PM_MangeProposalStagesPage.SearchVsResultForCurrentStage();
			Helper.ShowTestResult("4. Verification Current Stage search result.", VerifyStageSearchResult);
			DataManager.SaveTestResult("Verification Current Stage search result", VerifyStageSearchResult? "Passed" : "Failed", "Test Execution Completed Successfully!");

*/			
			boolean SerachByProposal = PM_MangeProposalStagesPage.SearchByCurrentStage(ProposalNumber);
			Helper.ShowTestResult("5. Verification of Search filter - Proposal number.", SerachByProposal);
			DataManager.SaveTestResult("Verification of Search filter - Proposal number", SerachByProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
/*			boolean VerifyProposalSearchResult = PM_MangeProposalStagesPage.SearchVsResultForProposal();
			Helper.ShowTestResult("6. Verification Proposal search result.", VerifyProposalSearchResult);
			DataManager.SaveTestResult("Verification Proposal search result", VerifyProposalSearchResult? "Passed" : "Failed", "Test Execution Completed Successfully!");

*/			
			//Change Proposal stage from one stage to other
			PM_MangeProposalStagesPage.SelectProposalToManage();
			PM_MangeProposalStagesPage.ClickAddButton();
	//		PM_MangeProposalStagesPage.SelectStageDD();
			boolean AddProposalFunction = PM_MangeProposalStagesPage.SubmitButton();
			Helper.ShowTestResult ("7. Verification Add button function.", AddProposalFunction);
			DataManager.SaveTestResult("Verification Add button function", AddProposalFunction? "Passed" : "Failed", "Test Execution Completed Successfully!");
/*	
			boolean SucNotification = PM_MangeProposalStagesPage.SuccessMessage();
			Helper.ShowTestResult("8. Notification of success message.", SucNotification);
			DataManager.SaveTestResult("Notification of success message", SucNotification? "Passed" : "Failed",  "Test Execution Completed Successfully!");

*/			
		
			boolean ClosingPopUpBox = PM_MangeProposalStagesPage.ClosePopUp();
			Helper.ShowTestResult("9. Closing of Pop Up Box.", ClosingPopUpBox);
			DataManager.SaveTestResult("Closing of Pop Up Box", ClosingPopUpBox? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
			
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System PM Manage Proposal Stage function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System PM Manage Proposal Stage.", "Failed", "Test Execution Failed!");
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

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System PM Manage Proposal Stage.", "Program Manager_Manage Proposal Stage");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}			

}
