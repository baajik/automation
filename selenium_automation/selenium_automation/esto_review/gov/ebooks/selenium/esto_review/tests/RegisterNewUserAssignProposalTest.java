package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;
import gov.ebooks.selenium.appsci.pages.HomePage;
import java.util.Random;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.AdminUser_ManageProposal_AssignUserPage;
import gov.ebooks.selenium.esto_review.pages.RegisterNewUserAssignProposalPage;
import gov.ebooks.selenium.esto_review.pages.LeadReviewer;
import gov.ebooks.selenium.esto_review.pages.ManageProposal;
import gov.ebooks.selenium.esto_review.pages.QualityControlPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;


public class RegisterNewUserAssignProposalTest 
{
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/

	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private ManageProposal manageProposalPage;
	private AdminUser_ManageProposal_AssignUserPage  AdminUser_ManageProposal_AssignUserPage;
	private RegisterNewUserAssignProposalPage  RegisterNewUserAssignProposalPage;
	
	private String UserName = "alegall";
	private String Password = "rev_qa";
	private Object aaaaa;
	
	
	
	@BeforeClass
	  public void StartOfTestSession() throws InterruptedException 
	  {
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages (test.getDriver());
		AdminUser_ManageProposal_AssignUserPage = new AdminUser_ManageProposal_AssignUserPage (test.getDriver());
		manageProposalPage = new ManageProposal(test.getDriver());
		RegisterNewUserAssignProposalPage = new RegisterNewUserAssignProposalPage(test.getDriver());
     }


@BeforeMethod
	public void handleTestMethodName(Method method)
	{
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();	
		//test.stepStartMessage(method.getName());
		
		boolean LaunchESTOReviewHomePage = homePage.ESTOReview();
		//Driver.Sleep(5);
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin = CommonMethodsESTOReviewPages.ESTOLogin(UserName, Password);
		//Driver.Sleep(3);
		Helper.ShowTestResult("** Verify PM Login to ESTO Review System.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PM Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
  }


 @Test (priority =1)
 public void RegisterUser () throws Exception
 {
	 try
	 {
		 	System.out.print("\r\n** Verification of Registering User.\r\n");
			System.out.println("========================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("Peer Review - Register User and Assign Propsoal"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			CommonMethodsESTOReviewPages.SelectACT17Solicitation();
			boolean SelectSoliciation = CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavigationManagProposal = RegisterNewUserAssignProposalPage.NavToManageUsers();
			Helper.ShowTestResult("2. Verification of Navigation to Manage Proposal.", NavigationManagProposal);
			DataManager.SaveTestResult("Verification of Navigation to Manage Proposal", NavigationManagProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");
		 
			RegisterNewUserAssignProposalPage.ClickAddNewUser();
			
			Random rand = new Random();
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int N = alphabet.length();
		    
			String FirstName = "First" + alphabet.charAt(rand.nextInt(N));
			String LastName = "Last" + alphabet.charAt(rand.nextInt(N));
			String email = "test" + rand.nextInt(99999999) + "@gmail.com"; //get the random gmail address
			String Organization = "RandomTest";
			String Phone = "1231231234";
			String ReviewerRole = "Reviewer";
							
			boolean FirstNameField = RegisterNewUserAssignProposalPage.RegisterUserPage("First Name", FirstName);
			Helper.ShowTestResult("3. Entering value in first name field.", FirstNameField);
			DataManager.SaveTestResult("Entering value in first name field", FirstNameField? "Passed" : "Failed", "Test Execution Completed Successfully!");
		 
	
			boolean LastNameField = RegisterNewUserAssignProposalPage.RegisterUserPage("Last Name", LastName);
			Helper.ShowTestResult("4. Entering value in last name field.", LastNameField);
			DataManager.SaveTestResult("Entering value in last name field", LastNameField? "Passed" : "Failed", "Test Execution Completed Successfully!");
		 
			boolean EmailField = RegisterNewUserAssignProposalPage.RegisterUserPage("Email", email);
			Helper.ShowTestResult("5. Entering value in Email field.", EmailField);
			DataManager.SaveTestResult("Entering value in Email field", EmailField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean OrganizationField = RegisterNewUserAssignProposalPage.RegisterUserPage("Organization", Organization);
			Helper.ShowTestResult("6. Entering value in Organization field.", OrganizationField);
			DataManager.SaveTestResult("Entering value in Organization field", OrganizationField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean PhoneField = RegisterNewUserAssignProposalPage.RegisterUserPage("Phone", Phone);
			Helper.ShowTestResult("7. Entering value in Phone field.", PhoneField);
			DataManager.SaveTestResult("Entering value in Phone field", PhoneField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean PotentialCheckBox = RegisterNewUserAssignProposalPage.SelectPotentialUser();
			Helper.ShowTestResult("8. Select Check Box of Potential Candidate.", PotentialCheckBox);
			DataManager.SaveTestResult("Select Check Box of Potential Candidate", PotentialCheckBox? "Passed" : "Failed", "Test Execution Completed Successfully!");
/*
			boolean CapturEmailValue = RegisterNewUserAssignProposalPage.CaptureEnteredEmail();
			Helper.ShowTestResult("9. xx.", CapturEmailValue);
			DataManager.SaveTestResult("xx", CapturEmailValue? "Passed" : "Failed", "Test Execution Completed Successfully!");
*/
			boolean SubmitButton = RegisterNewUserAssignProposalPage.clickSubmit();
			Helper.ShowTestResult("10. Clicking of Submit button.", SubmitButton);
			DataManager.SaveTestResult("Clicking of Submit button", SubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
//Assign same user to Proposal
/*			boolean NavManagerUser = CommonMethodsESTOReviewPages.selectManageUsers();
			Helper.ShowTestResult("11. xx.", NavManagerUser);
			DataManager.SaveTestResult("xx", NavManagerUser? "Passed" : "Failed", "Test Execution Completed Successfully!");

*/			
			boolean SearchField = RegisterNewUserAssignProposalPage.SearchByEnteredEmail(email);
			Helper.ShowTestResult("12. Search user by previously used email.", SearchField);
			DataManager.SaveTestResult("Search user by previously used email", SearchField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavToAssign = RegisterNewUserAssignProposalPage.NavToAssignProposal();
			Helper.ShowTestResult("13. Navigate to Assign Proposal Page.", NavToAssign);
			DataManager.SaveTestResult("Navigate to Assign Proposal Page", NavToAssign? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			CommonMethodsESTOReviewPages.SearchManageProposalByPropNumber();
			boolean SelectProposal = RegisterNewUserAssignProposalPage.SelectFirstProposalFromList();
			Helper.ShowTestResult("14. Search by centralized proposal and select proposal.", SelectProposal);
			DataManager.SaveTestResult("Search by centralized proposal and select proposal", SelectProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean AddButton = RegisterNewUserAssignProposalPage.AddButton();
			Helper.ShowTestResult("15. xx.", AddButton);
			DataManager.SaveTestResult("xx", AddButton? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean SelectRole = RegisterNewUserAssignProposalPage.SelectRoleFromDropdown(ReviewerRole);
			Helper.ShowTestResult("16. xx.", SelectRole);
			DataManager.SaveTestResult("xx", SelectRole? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean VerifySubmit = RegisterNewUserAssignProposalPage.ClickSubmitButton();
			Helper.ShowTestResult("17. xx.", VerifySubmit);
			DataManager.SaveTestResult("xx", VerifySubmit? "Passed" : "Failed", "Test Execution Completed Successfully!");


			JDBCconnection.DataBaseUsernameQuery(email); //connect to DB and find Username for
			// "test2170105@gmail.com"
			String username = JDBCconnection.username;
	 }
		catch (Exception ex)
		{
			System.out.println(ex);
			Helper.ShowTestResult("Peer Review System Register User Test Case", false);
			DataManager.SaveTestResult("Peer Review System Register User Test Case.", "Failed", "Test Execution Failed!");
		}	
	 }

// @Test (priority=2)
 public void FindUserNameInDB_JDBC()
 {
	 try
	 {
		 
		 
	 }
	 catch (Exception ex)
	 {
			Helper.ShowTestResult("Peer Review System Assign Proposal to Same User Test Case", false);
			DataManager.SaveTestResult("Peer Review System Assign Proposal to Same User Test Case.", "Failed", "Test Execution Failed!");
		
	 }
 }



 //@AfterMethod
		public void take_screenshot_on_failure(ITestResult result) 
 	{
		test.takescreenshot.takeScreenShotOnException(result);
  	}
		

@AfterClass
  	public void afterClass()
 	{
	// Logout from the system
				boolean LogoutFunc = CommonMethodsESTOReviewPages.EstoReviewEvalutionLogout();
				//Driver.Sleep(2);
				Helper.ShowTestResult("** Verify Logout function.", LogoutFunc);
				DataManager.SaveTestResult("Verify Logout function.", LogoutFunc? "Passed" : "Failed" , "Test Execution Completed Successfully!");
				test.closeBrowserSession();
//				Driver.TearDown();

				DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "Peer Review System Register User_Assign Proposal", "Register User_Proposal Assign");
				//Driver.Sleep(3);

				Helper.ShowTestResult("* Browser close", true);
 	}

}
