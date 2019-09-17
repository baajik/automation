package gov.ebooks.selenium.esto_review.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import static org.junit.Assert.*;

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
import gov.ebooks.selenium.esto_review.pages.SecurityQuestionPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

/*
5.	Change/ Update Security Question
Prerequisites: 
User should already register to application
User should have already complete initial setup

Update / Change Password
1.	Lunch the site of ESTO Review Program 
2.	Login to ESTO Review Program with user who has not login to system and has start initial setup.
3.	Provide UserID
4.	Provide Password
5.	Click the checkbox to acknowledge the consent
6.	Click Login button. 

7.	Expand My account dropdown
8.	Select Update Security Question section
9.	From dropdown on Security Question, select �What is your favorite sport?�
10.	Enter in Answer field �ESTO�
11.	Click Submit button
12.	Verify that successful message is getting display
13.	Click Okay button

14.	Logout from the system.
15.	Close the browser and generate the report. 

*/

public class ChangeSecurityQuestionTest 
{
/*
	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
	
*/	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private ConflictOfInterestPage conflictOfInterestPage;
	private SecurityQuestionPage securityQuestionPage;

	
	@BeforeClass
	public void setUpBeforeClass() //throws Exception 
	{
		String UserName = JDBCconnection.username;
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
		conflictOfInterestPage = new ConflictOfInterestPage(test.getDriver());
		securityQuestionPage = new SecurityQuestionPage(test.getDriver());

		
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
		Helper.ShowTestResult("** Verify PI Login to AppSciERS Function.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System Conflict of Interest.\r\n");
			System.out.println("=================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_Change Password"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("ESTO_Update Profile Page");

			boolean SelectSoliciation = conflictOfInterestPage.SelectACT16Solicitation();
			conflictOfInterestPage.ClickSelectButton();
//			Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean NavToSecQuestion  = securityQuestionPage.NavToSecurityQuestions();
//			Driver.Sleep(3);
			Helper.ShowTestResult("2. Navigation to Security Question update.", NavToSecQuestion);
			DataManager.SaveTestResult("Navigation to Security Question update.", NavToSecQuestion? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SecQuestion = securityQuestionPage.SelectSecQuestion();
//			Driver.Sleep(3);
			Helper.ShowTestResult("3. ", SecQuestion);
			DataManager.SaveTestResult("", SecQuestion? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean EnterSecAnswer = securityQuestionPage.EnterAnswer();
//			Driver.Sleep(3);
			Helper.ShowTestResult("4. ", EnterSecAnswer);
			DataManager.SaveTestResult("", EnterSecAnswer? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean UpdateSubmitButton = securityQuestionPage.UpdateSubmitButton();
//			Driver.Sleep(3);
			Helper.ShowTestResult("5. ", UpdateSubmitButton);
			DataManager.SaveTestResult("", UpdateSubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SuccMsgVal = securityQuestionPage.SuccessMessage();
//			Driver.Sleep(3);
			Helper.ShowTestResult("6. ", SuccMsgVal);
			DataManager.SaveTestResult("", SuccMsgVal? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClosePopUp = securityQuestionPage.ClickOkayToClose();
//			Driver.Sleep(3);
			Helper.ShowTestResult("7. ", ClosePopUp);
			DataManager.SaveTestResult("", UpdateSubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
						
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System Conflict of Interest function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Conflict of Interest.", "Failed", "Test Execution Failed!");
		}	
	}


	@AfterClass
	public void tearDownAfterClass() //throws Exception 
		{
		// Logout from the system
			boolean LogoutFunc = CommonMethodsESTOReviewPages.EstoReviewEvalutionLogout();
//			Driver.Sleep(2);
			Helper.ShowTestResult("** Verify Logout function.", LogoutFunc);
			DataManager.SaveTestResult("Verify Logout function.", LogoutFunc? "Passed" : "Failed" , "Test Execution Completed Successfully!");
			test.closeBrowserSession();
//			Driver.TearDown();

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Conflict of Interest.", "Reviewer_Conflict of Interest");
//			Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}	

}
