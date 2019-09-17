package gov.ebooks.selenium.esto_review.tests;


import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;

import java.util.ArrayList;
import java.util.Date;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.ConflictOfInterestPage;
import gov.ebooks.selenium.esto_review.pages.UpdateChangePasswordPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;



/*
Update / Change Password 

Prerequisites: 
User should already register to application
User should have already complete initial setup

Update / Change Password
1.	Lunch the site of ESTO Review Program 
2.	Login to ESTO Review Program with user who has not login to system and has start initial setup.
3.	Provide UserID
4.	Provide Password
5.	Click the check box to acknowledge the consent
6.	Click Login button. 

7.	Expand My account dropdown
8.	Select Change Password section
9.	Click Submit button.
10.	Verify that Validation message in displaying in Current Password �Password is invalid� 
11.	Verify that Validation message in displaying in New Password �New password must contain at least 1 uppercase letter�; �New password must contain at least 1 number� ; �New password must contain at least 1 special character: �New password must be at least 8 characters�
12.	Verify that Validation message in displaying in Re-enter New Password �New password must match�
13.	Enter value in Current Password field �rev_qa�
14.	Enter Valid value in New Password field �Test*1234�
15.	Enter Valid value in Re-enter New Password field �Test*1234�
16.	Enter Submit button
17.	Verify that successful message is getting display
18.	Click Okay button

19.	Logout from the system.
20.	Close the browser and generate the report. 

*/

public class ChangePasswordTest 
{

/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
	
*/	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private UpdateChangePasswordPage updateChangePasswordPage;
	private ConflictOfInterestPage conflictOfInterestPage;

	
	@BeforeClass
	public void setUpBeforeClass() //throws Exception 
	{
		String UserName = JDBCconnection.username;
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());;
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
		updateChangePasswordPage = new UpdateChangePasswordPage(test.getDriver());
		conflictOfInterestPage = new ConflictOfInterestPage(test.getDriver());

		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
		// Alternate method to lunch the HomePage
		//Driver.GoTo("https://nasa-ebooks-qa.amer.reisystems.com/review/login");

		boolean LaunchESTOReviewHomePage = homePage.ESTOReview();
//		Driver.Sleep(5);
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin = CommonMethodsESTOReviewPages.ESTOLogin(UserName, Password);
//		Driver.Sleep(3);
		Helper.ShowTestResult("** Verify PI Login to ESTO Review System.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System Change Password.\r\n");
			System.out.println("=================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_Change Password"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			boolean SelectSoliciation = updateChangePasswordPage.SelectACT17Solicitation();
			conflictOfInterestPage.ClickSelectButton();
//			Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavSecQuestionPage = updateChangePasswordPage.NavToSecurityQuestions();
//			Driver.Sleep(3);
			Helper.ShowTestResult("2. Function of navigation to Sec Question Page.", NavSecQuestionPage);
			DataManager.SaveTestResult("Function of navigation to Sec Question Page", NavSecQuestionPage? "Passed" : "Failed", "Test Execution Completed Successfully!");

			//ESTO_UpdateChangePasswordPage.VerifyCorrectPage();
			//Driver.Sleep(3);
			
			updateChangePasswordPage.ClickSubmitButton();
//			Driver.Sleep(5);
			boolean ValMsgCurretField = updateChangePasswordPage.CurrentPaswrdFieldMsg();
//			Driver.Sleep(5);
			Helper.ShowTestResult("3. Verification of Current Field Validation Message.", ValMsgCurretField);
			DataManager.SaveTestResult("Verification of Current Field Validation Message", ValMsgCurretField? "Passed" : "Failed", "Test Execution Completed Successfully!");		
			
			boolean ValMsgNewField = updateChangePasswordPage.NewPaswrdFieldMsg();
//			Driver.Sleep(5);
			Helper.ShowTestResult("4. Verification of New Password Field Validation Message.", ValMsgNewField);
			DataManager.SaveTestResult("Verification of New Password Field Validation Message", ValMsgNewField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean EnterCurrentField = updateChangePasswordPage.EnterCurrentPassword();
//			Driver.Sleep(3);
			Helper.ShowTestResult("5. Enter Value in Current Password field.", EnterCurrentField);
			DataManager.SaveTestResult("Enter Value in Current Password field", EnterCurrentField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean EnterNewField = updateChangePasswordPage.NewPassword();
//			Driver.Sleep(3);
			Helper.ShowTestResult("6. Enter Value in New Password field.", EnterNewField);
			DataManager.SaveTestResult("Enter Value in New Password field", EnterNewField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean EnterConfirdField = updateChangePasswordPage.ReEnterPassword();
//			Driver.Sleep(3);
			Helper.ShowTestResult("7. Enter Value in Re-Enter New Password field.", EnterConfirdField);
			DataManager.SaveTestResult("Enter Value in Re-Enter New Password field", EnterConfirdField? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean ClickSubmit = updateChangePasswordPage.ClickSubmitButton();
//			Driver.Sleep(3);
			Helper.ShowTestResult("8. Verification of Submit button.", ClickSubmit);
			DataManager.SaveTestResult("Verification of Submit button", ClickSubmit? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean SuccesMsg = updateChangePasswordPage.SuccessfulMsg();
//			Driver.Sleep(3);
			Helper.ShowTestResult("9. Verification of Success message.", SuccesMsg);
			DataManager.SaveTestResult("Verification of Success message", SuccesMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean ClosePopUpBox = updateChangePasswordPage.ClickOkayButton();
//			Driver.Sleep(3);
			Helper.ShowTestResult("10. Verification of closing the Pop Up box.", ClosePopUpBox);
			DataManager.SaveTestResult("Verification of closing the Pop Up box", ClosePopUpBox? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System Change Password function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Change Password.", "Failed", "Test Execution Failed!");
		}	
	}


	@AfterClass
	public void tearDownAfterClass() //throws Exception 
	{
// Logout from the system
		boolean LogoutFunc = CommonMethodsESTOReviewPages.EstoReviewEvalutionLogout();
//		Driver.Sleep(2);
		Helper.ShowTestResult("** Verify Logout function.", LogoutFunc);
		DataManager.SaveTestResult("Verify Logout function.", LogoutFunc? "Passed" : "Failed" , "Test Execution Completed Successfully!");
		test.closeBrowserSession();
//		Driver.TearDown();

		DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Change Password.", "Reviewer_Change Password");
//		Driver.Sleep(3);

		Helper.ShowTestResult("* Browser close", true);
	}	
		

}
