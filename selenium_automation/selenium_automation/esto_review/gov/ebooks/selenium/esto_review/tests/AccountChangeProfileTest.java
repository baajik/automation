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

import gov.ebooks.selenium.appsci.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.AccountProfileSetupPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;



public class AccountChangeProfileTest 
{
/*
	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
	
*/	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private AccountProfileSetupPage accountProfileSetupPage;

	
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
		accountProfileSetupPage = new AccountProfileSetupPage(test.getDriver());

		
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
		// Alternate method to lunch the HomePage
		//Driver.GoTo("https://nasa-ebooks-qa.amer.reisystems.com/review/login");

		boolean LaunchESTOReviewHomePage = homePage.ESTOReview();
//		Driver.Sleep(5);
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin = commonMethodsPages.ESTOLogin(UserName, Password);
//		Driver.Sleep(3);
		Helper.ShowTestResult("** Verify PI Login to ESTO Review System.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System Account Change Profile.\r\n");
			System.out.println("====================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_Account Change Profile"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			boolean SelectSoliciation = accountProfileSetupPage.SelectACT17Solicitation();
			accountProfileSetupPage.ClickSelectSolicitationButton();
//			Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavUpdatePage = accountProfileSetupPage.MyAccountToUpdateProfilePage();
//			Driver.Sleep(4);
			Helper.ShowTestResult("2. Function of navigation to Update Profile Page.", NavUpdatePage);
			DataManager.SaveTestResult("Function of navigation to Update Profile Page", NavUpdatePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean EmailValidation = accountProfileSetupPage.RemoveEmailVerifyValMsg();
//			Driver.Sleep(3);
			Helper.ShowTestResult("3. Verification of Email Field Validation.", EmailValidation);
			DataManager.SaveTestResult("Verification of Email Field Validation", EmailValidation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean DuplEmailValMsg = accountProfileSetupPage.DuplicateEmailValidation();
//			Driver.Sleep(3);
			Helper.ShowTestResult("4. Verification of validation msg for duplicate email.", DuplEmailValMsg);
			DataManager.SaveTestResult("Verification of validation msg for duplicate email", DuplEmailValMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean CorrectEmail = accountProfileSetupPage.EnterCorrectEmail();
//			Driver.Sleep(3);
			Helper.ShowTestResult("5. Verification of enter value in Email field.", CorrectEmail);
			DataManager.SaveTestResult("Verification of enter value in Email field", CorrectEmail? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean SuccessMsg = accountProfileSetupPage.SuccessfulMsg();
//			Driver.Sleep(3);
			Helper.ShowTestResult("6. Verification of Email success message.", SuccessMsg);
			DataManager.SaveTestResult("Verification of Email success message", SuccessMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean ClickOkay = accountProfileSetupPage.ClickOkayButton();
//			Driver.Sleep(3);
			Helper.ShowTestResult("7. Verification of Click Okay button.", ClickOkay);
			DataManager.SaveTestResult("Verification of Click Okay button", ClickOkay? "Passed" : "Failed", "Test Execution Completed Successfully!");

			}
			catch (Exception ex)
			{
				Helper.ShowTestResult("ESTO Review System Account Change Profile function Test Case", false);
				DataManager.SaveTestResult("ESTO Review System Account Change Profile.", "Failed", "Test Execution Failed!");
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

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Account Change Profile.", "Reviewer_Account Change Profile");
//			Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}	
			


}
