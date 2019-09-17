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
import gov.ebooks.selenium.esto_review.pages.SwitchSolicitationPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

/*
Prerequisites: 
�	Reviewer already have proposal assigned with two or more solicitation

Reviewer to switch solicitation

1.	Lunch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the checkbox to acknowledge the consent
5.	Click Login button
6.	Select the Solicitation that you want to access
7.	Click on Switch Solicitation button
8.	Select the new solicitation
9.	Enter Submit button
10.	Verify that user dashboard page is switch with another solicitation

11.	Logout form application
12.	Close the browser
*/


public class SwitchSolicitationTest 
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
	private SwitchSolicitationPage switchSolicitationPage;
	
	
	@BeforeClass
	public void setUpBeforeClass() //throws Exception 
	{
		String UserName = "achapin";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
		switchSolicitationPage = new SwitchSolicitationPage(test.getDriver());

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
		Helper.ShowTestResult("** Verify PI Login to AppSciERS Function.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System Switch Solicitation.\r\n");
			System.out.println("=================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_Change Password"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("ESTO_Update Profile Page");

			boolean SelectSoliciation = switchSolicitationPage.SelectACT16Solicitation();
			switchSolicitationPage.ClickSelectButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SwitchSolicitation = switchSolicitationPage.ClickSwitchSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("2. Access of Change Solicitation.", SwitchSolicitation);
			DataManager.SaveTestResult("Access of Change Solicitation.", SwitchSolicitation? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SelAnotherSol = switchSolicitationPage.SelectAnotherSolicitation();
			//Driver.Sleep(5);
			Helper.ShowTestResult("3. Select of another Solicitation.", SelAnotherSol);
			DataManager.SaveTestResult("Select of another Solicitation.", SelAnotherSol? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			boolean ClickSelButton = switchSolicitationPage.ClickSelectButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("4. Submit button.", ClickSelButton);
			DataManager.SaveTestResult("Submit button.", ClickSelButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System Switch Solicitation function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Switch Solicitation.", "Failed", "Test Execution Failed!");
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

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Switch Solicitation.", "Reviewer_Switch Solicitation");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}

}
