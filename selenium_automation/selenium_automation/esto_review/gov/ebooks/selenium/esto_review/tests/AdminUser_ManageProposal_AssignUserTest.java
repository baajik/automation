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
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposal_AssignUserPage;


public class AdminUser_ManageProposal_AssignUserTest {
	/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	
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
		
		
	
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
		// Alternate method to lunch the HomePage
		//Driver.GoTo("https://nasa-ebooks-qa.amer.reisystems.com/review/login");

		boolean LaunchESTOReviewHomePage = homePage.ESTOReview();
		//Driver.Sleep(5);
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin = commonMethodsPages.ESTOLogin(UserName, Password);
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

			CommonMethodsESTOReviewPages.SelectACT17Solicitation();
			boolean SelectSoliciation = CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavigationManagProposal = AdminUser_ManageProposal_AssignUserPage.NavToManageProposals();
			Helper.ShowTestResult("2. Verification of Navigation to Manage Proposal.", NavigationManagProposal);
			DataManager.SaveTestResult("Verification of Navigation to Manage Proposal", NavigationManagProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			
			AdminUser_ManageProposal_AssignUserPage.NavToAssignUsers();
			
			
			String SearchNamePanelMember1 = "Greg Kopp"; //1 Panel Member 1
			String SearchNamePanelMember2 = "Brian Drouin"; //2 Panel Member 2
			String SearchNameScribe = "Scott Ozog"; //3 Scribe
			String SearchPanelProjection = "ActPROJECTOR"; //4 Projection
			String SearchLeadReviewer = "Joan Howard"; //5 Lead Reviewer
			String SearchQualityControl = "Nahal Kardan"; //6 Quality Control
			String SearchPanelLead = "C Chapin"; //7 Panel Lead
			String SearchPanelOfficial = "Ella Atkins"; //8 Panel Official
			String SearchProgramManager = "Aaron Falk"; //9 Program Manager
		
			
			String SelectPanelMember1 = "Panel Member"; //1
			String SelectPanelMember2 = "Panel Member"; //2
			String SelectScribe = "Scribe"; //3
			String SelectPanelProjection = "Panel Projection"; //4
			String SelectLeadReviewer = "Lead Reviewer"; //5
			String SelectQualityControl = "Quality Control"; //6
			String SelectPanelLead = "Panel Lead"; //7
			String SelectPanelOfficial = "Panel Official"; //8
			String SelectProgramManager = "Program Manager"; //9
			
		
			//1	Panel Member 1	
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchNamePanelMember1);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelMember1);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//2 Panel Member 2
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchNamePanelMember2);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelMember2);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//3 Scribe
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchNameScribe);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectScribe);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//4 Projection
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchPanelProjection);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelProjection);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//5 Lead Reviewer
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchLeadReviewer);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectLeadReviewer);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//6 Quality Control
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchQualityControl);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectQualityControl);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//7 Panel Lead
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchPanelLead);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SearchPanelLead);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//8 Panel Official
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchPanelOfficial);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectPanelOfficial);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
			
			//9 Program Manager
			AdminUser_ManageProposal_AssignUserPage.SearchUser(SearchProgramManager);
			AdminUser_ManageProposal_AssignUserPage.AddButton();
			AdminUser_ManageProposal_AssignUserPage.SelectRoleFromDropdown(SelectProgramManager);
			AdminUser_ManageProposal_AssignUserPage.ClickSubmitButton();
		
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System PM Manage Proposal Stage function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System PM Manage Proposal Stage.", "Failed", "Test Execution Failed!");
		}	
	}


		//@AfterClass
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
