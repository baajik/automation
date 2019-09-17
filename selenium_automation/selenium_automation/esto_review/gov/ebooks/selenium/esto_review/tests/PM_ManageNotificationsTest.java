package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.PM_ManageNotificationsPage;
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
Manage Notifications by Program Manager

Prerequisites: 
•	Program Manager already have Solicitation Assigned.

Program Manager to move Proposal Stage
1.	Lunch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the checkbox to acknowledge the consent
5.	Click Login button

6.	Select the solicitation which that user wishes to work on if selection of Solicitation pop up box display, otherwise proceed with next Test Case
7.	Select Manage Notifications from Administrator Tool
8.	Select Submit button
9.	Remove value from Notification Title field, Notification Text box.  Click Submit button. 
10.	Verify Validation message in Notification Text “Notification Text is required”

11.	Enter value in Notification Title field.
12.	Enter value in Notification Text field.
13.	Select Choose File button in Upload Attachments 
14.	Select Main-in review in Proposal Stage(s) box
15.	Select Reviewer from Select Roles(s) box 
16.	Click Add button. Verify that same proposal is displaying in Selected Proposals box.
17.	Select Submit button
18.	Close Pop Up box

19.	Logout form application
20.	Close the browser



*/
public class PM_ManageNotificationsTest {
	
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private PM_ManageNotificationsPage PM_ManageNotificationsPage;
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
		PM_ManageNotificationsPage = new PM_ManageNotificationsPage(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
			
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
		// Alternate method to lunch the HomePage
		//Driver.GoTo("https://nasa-ebooks-qa.amer.reisystems.com/review/login");

		boolean LaunchESTOReviewHomePage = CommonMethodsESTOReviewPages.ESTOReview();
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

			boolean SelectSoliciation = CommonMethodsESTOReviewPages.SelectACT16Solicitation();
			CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavToManageNotification = PM_ManageNotificationsPage.NavToManageNotifications();
			Helper.ShowTestResult("2. Navigation to Manage Notification Page.", NavToManageNotification);
			DataManager.SaveTestResult("Navigation to Manage Notification Page", NavToManageNotification? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean NavToUpdate = PM_ManageNotificationsPage.NavtoUpdate();
			Helper.ShowTestResult("3. Navigation to Update Button.", NavToUpdate);
			DataManager.SaveTestResult("Navigation to Update Button", NavToUpdate? "Passed" : "Failed", "Test Execution Completed Successfully!");

//Validation Message 
			PM_ManageNotificationsPage.MsgVerification("NotificationTitle");
			PM_ManageNotificationsPage.MsgVerification("notificationText");
			PM_ManageNotificationsPage.Submit();
			boolean AlertMessgeVerification = PM_ManageNotificationsPage.VerificationMsg();
			Helper.ShowTestResult("4. Verification of alert message.", AlertMessgeVerification);
			DataManager.SaveTestResult("Verification of alert message", AlertMessgeVerification? "Passed" : "Failed", "Test Execution Completed Successfully!");

//Submission verification	
			String Title = "Test Notification Field";
			String NotificaitonTxt = "Test AIST-16 Evaluation Plan";
			String SelectStage = "Mail-in review";
			String SelectRole = "Reviewer";

			boolean NotificationTitleField = PM_ManageNotificationsPage.AddNotificationTitle("NotificationTitle", Title);
			Helper.ShowTestResult("5. Enter value in Notification field.", NotificationTitleField);
			DataManager.SaveTestResult("Enter value in Notification field", NotificationTitleField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NotificaitonTextField = PM_ManageNotificationsPage.AddNotificationTitle("notificationText", NotificaitonTxt);
			Helper.ShowTestResult("6. Enter value in Tile field.", NotificaitonTextField);
			DataManager.SaveTestResult("Enter value in Tile field", NotificaitonTextField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean UploadFunction = PM_ManageNotificationsPage.UploadAttachements();
			Helper.ShowTestResult("7. Verification of upload function.", UploadFunction);
			DataManager.SaveTestResult("Verification of upload function", UploadFunction? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean SelecStageFunction = PM_ManageNotificationsPage.ProposalStage(SelectStage);
			Helper.ShowTestResult("8. Verification of Stage selection from box.", SelecStageFunction);
			DataManager.SaveTestResult("Verification of upload function", SelecStageFunction? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SelectRoleFunction = PM_ManageNotificationsPage.SelectRole(SelectRole);
			Helper.ShowTestResult("9. Verificaiton of Role selection from box.", SelectRoleFunction);
			DataManager.SaveTestResult("Verificaiton of Role selection from box", SelectRoleFunction? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SubmitButton = PM_ManageNotificationsPage.Submit();
			Helper.ShowTestResult("10. Verification of Submit button.", SubmitButton);
			DataManager.SaveTestResult(" Verification of Submit button", SubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ClosePopUpBox = CommonMethodsESTOReviewPages.ClosePopUp();
			Helper.ShowTestResult("11. Verification of Closing Pop Up Box.", ClosePopUpBox);
			DataManager.SaveTestResult("Verification of Closing Pop Up Box", ClosePopUpBox? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
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
