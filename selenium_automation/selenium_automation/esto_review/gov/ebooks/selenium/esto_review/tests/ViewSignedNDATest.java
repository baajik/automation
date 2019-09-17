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
import gov.ebooks.selenium.esto_review.pages.ViewSignedNDAPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;


public class ViewSignedNDATest {
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
	private ViewSignedNDAPage viewSignedNDAPage;
	

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
		viewSignedNDAPage = new ViewSignedNDAPage(test.getDriver());

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
		Helper.ShowTestResult("** Verify PI Login to ESTO Review System.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in ESTO Review System View Signed NDA.\r\n");
			System.out.println("=================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_View Signed NDA"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			boolean SelectSoliciation = viewSignedNDAPage.SelectACT17Solicitation();
			viewSignedNDAPage.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavUpdatePage = viewSignedNDAPage.MyAccountToUpdateProfilePage();
			//Driver.Sleep(3);
			Helper.ShowTestResult("2. Function of navigation to Update Profile Page.", NavUpdatePage);
			DataManager.SaveTestResult("Function of navigation to Update Profile Page", NavUpdatePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

			viewSignedNDAPage.DownloadNDA();
			//Driver.Sleep(4);
			
			viewSignedNDAPage.ClosePopUp();
			//Driver.Sleep(3);
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System View Signed NDA function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System View Signed NDA.", "Failed", "Test Execution Failed!");
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

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System View Signed NDA.", "Reviewer_View Signed NDA");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}	
			
}
