package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;
import gov.ebooks.selenium.appsci.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.PM_ManageConflict_LackOfExpertisePage;
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
Manage Conflict/Lack of Expertise by Program Manager

Prerequisites: 
•	Program Manager already have Solicitation Assigned.

Program Manager’ Manage Taxonomy feature
1.	Lunch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the checkbox to acknowledge the consent
5.	Click Login button

6.	Select the solicitation which that user wishes to work on if selection of Solicitation pop up box display, otherwise proceed with next Test Case
7.	Navigate to Add Manage Conflict/Lack of Expertise from Administrator Tool
8.	Click on Proposal Number that you want to manage
9.	Click Submit button
10.	Verify that validation message display “Field is required”
11.	Click on Approved radio button 
12.	Enter value in ESTO Comments field 
13.	Click Submit button

14.	Close the Pop-Up box
15.	Logout form application
16.	Close the browser
*/


public class PM_ManageConflict_LackOfExpertiseTest {
	
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private PM_ManageConflict_LackOfExpertisePage PM_ManageConflict_LackOfExpertisePage;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception
	{
		String UserName = "mlittle";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		PM_ManageConflict_LackOfExpertisePage = new PM_ManageConflict_LackOfExpertisePage(test.getDriver());
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
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System Conflict_Lack of Expertise\r\n");
			System.out.println("=======================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PM Manage Conflict_Lack of Exper"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			boolean SelectSoliciation = CommonMethodsESTOReviewPages.SelectACT16Solicitation();
			CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavigationLackOfExpert = PM_ManageConflict_LackOfExpertisePage.ManageConflictLackOfExpertise();
			Helper.ShowTestResult("2. Navigation to Manage Conflict Page.", NavigationLackOfExpert);
			DataManager.SaveTestResult("Navigation to Manage Conflict Page", NavigationLackOfExpert? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean ExpandOfProject = PM_ManageConflict_LackOfExpertisePage.ExpandProposal();
			Helper.ShowTestResult("3. Navigation to of Project to manage.", ExpandOfProject);
			DataManager.SaveTestResult("Navigation to of Project fo manage", ExpandOfProject? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			boolean ClickAppButton = PM_ManageConflict_LackOfExpertisePage.SelectApprovedButton();
			Helper.ShowTestResult("4. Selection of Approved Button.", ClickAppButton);
			DataManager.SaveTestResult("Selection of Approved Button", ClickAppButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			String ESTOComments = "Test to check the value enter in ESTO Comments.";
			boolean EnterComments = PM_ManageConflict_LackOfExpertisePage.EnterCommentsInESTOCommets(ESTOComments);
			Helper.ShowTestResult("5. Enter value in ESTO Comments box.", EnterComments);
			DataManager.SaveTestResult("Enter value in ESTO Comments box", EnterComments? "Passed" : "Failed", "Test Execution Completed Successfully!");
							
			boolean Submit  = PM_ManageConflict_LackOfExpertisePage.SubmitButton();
			Helper.ShowTestResult("6. Function of Submit button.", Submit);
			DataManager.SaveTestResult("Function of Submit button", Submit? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClosePopUpBox = CommonMethodsESTOReviewPages.ClosePopUp();
			Helper.ShowTestResult("7. Function of closing the Pop Up box.", ClosePopUpBox);
			DataManager.SaveTestResult("Function of closing the Pop Up box", ClosePopUpBox? "Passed" : "Failed", "Test Execution Completed Successfully!");
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System PM Conflict_Lack of Expertise function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Conflict_Lack of Expertise", "Failed", "Test Execution Failed!");
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
			//	Driver.TearDown();

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Conflict_Lack of Expertise", "Program Manager_Conflict_Lack of Exper");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}	
		
		
}
