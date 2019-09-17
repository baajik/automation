package gov.ebooks.selenium.esto_review.tests;

import java.util.Date;
import java.util.ArrayList;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;

import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;

import gov.ebooks.selenium.appsci.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposalStagePage;
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposal_AssignUserPage;


public class AdminUserRegressionTest {
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
	
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception 
	{
		String UserName = "alegall";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages (test.getDriver());
		AdminUser_ManageProposal_AssignUserPage = new AdminUser_ManageProposal_AssignUserPage(test.getDriver());
		AdminUser_ManageProposalStagePage= new AdminUser_ManageProposalStagePage(test.getDriver());
		
	
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
			System.out.print("\r\n** Verification of Field Validation in Admin User -Manage Proposal and Assignments.\r\n");
			System.out.println("=======================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("Review System - Admin User - Manage Proposal"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			CommonMethodsESTOReviewPages.SelectACT17Solicitation();
			boolean SelectSoliciation = CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean ExpandAdminTool = AdminUser_ManageProposalStagePage.NavToManagePropStage();
			Helper.ShowTestResult("2. Verification of Navigation to Manage Prop Stage.", ExpandAdminTool);
			DataManager.SaveTestResult("Verification of Navigation to Manage Prop Stage", ExpandAdminTool? "Passed" : "Failed", "Test Execution Completed Successfully!");

			String CurrentStage = "Lead Reviewer";
			//String ProposalNumber = "17-ACT17-0038";
			String StageDropDown = "Pre-panel";
			//String SearchByPropInStages = "17-ACT17-0038";
/*			
			boolean SerachByStage = AdminUser_ManageProposalStagePage.SearchByCurrentStage(CurrentStage);
			Helper.ShowTestResult("3. Verification of Search filter - Proposal Number.", SerachByStage);
			DataManager.SaveTestResult("Verification of Search filter -  Proposal Number", SerachByStage? "Passed" : "Failed", "Test Execution Completed Successfully!");


			boolean VerifyStageSearchResult = AdminUser_ManageProposalStagePage.SearchVsResultForCurrentStage();
			Helper.ShowTestResult("4. Verification Current Stage search result.", VerifyStageSearchResult);
			DataManager.SaveTestResult("Verification Current Stage search result", VerifyStageSearchResult? "Passed" : "Failed", "Test Execution Completed Successfully!");
*/
			
/*			boolean SerachByProposal = AdminUser_ManageProposalStagePage.SearchByCurrentStage(ProposalNumber);
			Helper.ShowTestResult("3. Verification of Search filter - Proposal number.", SerachByProposal);
			DataManager.SaveTestResult("Verification of Search filter - Proposal number", SerachByProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
		*/
			//Change Proposal stage from Mail-In Review to Pre-panel
			
			CommonMethodsESTOReviewPages.SearchByPropNumberInProposalStage(); //(SearchByPropInStages);
			AdminUser_ManageProposalStagePage.SelectProposalToManage();
			AdminUser_ManageProposalStagePage.ClickAddButton();
			AdminUser_ManageProposalStagePage.SelectStageDD(StageDropDown);
			boolean AddProposalFunction = AdminUser_ManageProposalStagePage.SubmitButton();
			Helper.ShowTestResult ("4. Verification Select, Add and change stage function.", AddProposalFunction);
			DataManager.SaveTestResult("Verification Select, Add and change stage function", AddProposalFunction? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean SwitchToManagerProp = CommonMethodsESTOReviewPages.SelectManageProposalFromLeft();
			Helper.ShowTestResult ("5. Switch to Manage Proposal.", SwitchToManagerProp);
			DataManager.SaveTestResult("Switch to Manage Proposal", SwitchToManagerProp? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//String SearchInManageProposal = "17-ACT17-0038";
			
			CommonMethodsESTOReviewPages.SearchManageProposalByPropNumber();   //(SearchInManageProposal);
			boolean NavToAssign = AdminUser_ManageProposal_AssignUserPage.NavToAssignUsers();
			Helper.ShowTestResult ("6. Navigation to Assign user page.", NavToAssign);
			DataManager.SaveTestResult("Navigation to Assign user page", NavToAssign? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
			String SearchNamePanelMember1 = "Greg Kopp"; //1 Panel Member 1
			String SearchPanelOfficial = "Ella Atkins"; //8 Panel Official
			String SearchNamePanelMember2 = "Brian Drouin"; //2 Panel Member 2
			String SearchNameScribe = "Scott Ozog"; //3 Scribe
			String SearchPanelProjection = "ActPROJECTOR"; //4 Projection
			String SearchLeadReviewer = "Joan Howard"; //5 Lead Reviewer // David Smith
			String SearchQualityControl = "Nahal Kardan"; //6 Quality Control //Sudhir Shrestha
			String SearchPanelLead = "Elaine Chapin"; //7 Panel Lead
			String SearchProgramManager = "Aaron Falk"; //9 Program Manager
					
			String SelectPanelMember1 = "Panel Member"; //1
			String SelectPanelOfficial = "Panel Official"; //8
			String SelectScribe = "Scribe"; //3
			String SelectPanelMember2 = "Panel Member"; //2
			String SelectPanelProjection = "Panel Projection"; //4
			String SelectLeadReviewer = "Lead Reviewer"; //5
			String SelectQualityControl = "Quality Control"; //6
			String SelectPanelLead = "Panel Lead"; //7
		
			String SelectProgramManager = "Program Manager"; //9
			
					
					
			//1	Panel Member 1	
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchNamePanelMember1);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelMember1);
			boolean PanelMember1 = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("7. Function of Search and Assign Panel Member 1.", PanelMember1);
			DataManager.SaveTestResult("Function of Search and Assing Panel Member 1", PanelMember1? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//8 Panel Official
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchPanelOfficial);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelOfficial);
			boolean PanelOfficial = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("14. Function of Search and Assing of Panel Official.", PanelOfficial);
			DataManager.SaveTestResult("Function of Search and Assing of Panel Official", PanelOfficial? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//3 Scribe
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchNameScribe);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectScribe);
			boolean Scribe = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("9. Function of Search and Assing of Scribe.", Scribe);
			DataManager.SaveTestResult("Function of Search and Assing of Scribe", Scribe? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			//2 Panel Member 2
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchNamePanelMember2);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelMember2);
			boolean PanelMember2 = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("8. Function of Search and Assign Panel Member 2.", PanelMember2);
			DataManager.SaveTestResult("Function of Search and Assing Panel Member 2", PanelMember2? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			
			//9 Program Manager
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchProgramManager);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectProgramManager);
			boolean ProgramManager = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("15. Function of Search and Assing of Program Manager", ProgramManager);
			DataManager.SaveTestResult("Function of Search and Assingof Program Manager", ProgramManager? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
			//4 Panel Projection
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchPanelProjection);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelProjection);
			boolean Projector = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("10. Function of Search and Assing of Projector.", Projector);
			DataManager.SaveTestResult("Function of Search and Assing of Projector", Projector? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
						
			//5 Lead Reviewer
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchLeadReviewer);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectLeadReviewer);
			boolean LeadReviewer = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("11. Function of Search and Assing of Lead Reviewer.", LeadReviewer);
			DataManager.SaveTestResult("Function of Search and Assing of Lead Reviewer", LeadReviewer? "Passed" : "Failed", "Test Execution Completed Successfully!");

			//6 Quality Control
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchQualityControl);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectQualityControl);
			boolean QualityControl = AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("12. Function of Search and Assing of Quality Control.", QualityControl);
			DataManager.SaveTestResult("Function of Search and Assing of Quality Control", QualityControl? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			//7 Panel Lead
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchPanelLead);
			AdminUser_ManageProposal_AssignUserPage.SelectFirstUserFromList();
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelLead);
			boolean PanelLead =AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			Helper.ShowTestResult ("13. Function of Search and Assing of Panel Lead.", PanelLead);
			DataManager.SaveTestResult("Function of Search and Assing of Panel Lead", PanelLead? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			
			

//Change Proposal stage from Pre-panel to Scribe
			
			String PrePanelToScribe = "Scribe";
		
			CommonMethodsESTOReviewPages.SelectProposalStageFromLeft();
			CommonMethodsESTOReviewPages.SearchByPropNumberInProposalStage(); //(SearchByPropInStages);

			AdminUser_ManageProposalStagePage.SelectProposalToManage();
			AdminUser_ManageProposalStagePage.ClickAddButton();
			AdminUser_ManageProposalStagePage.SelectStageDD(PrePanelToScribe);
			boolean ChangeProposalStage = AdminUser_ManageProposalStagePage.SubmitButton();
			Helper.ShowTestResult ("16. Change of Stage from Pre-pane to Scribe.", ChangeProposalStage);
			DataManager.SaveTestResult("Change of Stage from Pre-pane to Scribe", ChangeProposalStage? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean ClosingPopUpBox = AdminUser_ManageProposalStagePage.ClosePopUp();
			Helper.ShowTestResult("17. Closing of Pop Up Box.", ClosingPopUpBox);
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

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "Review System - Admin User - Manage Proposal", "Manage Proposal by Admin");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}			


}
