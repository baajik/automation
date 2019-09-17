package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;

import gov.ebooks.selenium.appsci.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.PM_DownloadNDAPage;
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

public class PM_DownloadProposalDebriefTest {
	/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private PM_DownloadNDAPage PM_DownloadNDAPage;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception
	{
		String UserName = "mlittle";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		PM_DownloadNDAPage = new PM_DownloadNDAPage(test.getDriver());
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
			
			
			
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System PM Conflict_Lack of Expertise function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Conflict_Lack of Expertise", "Failed", "Test Execution Failed!");
		}	
	}


		//@AfterClass
		public void tearDownAfterClass() //throws Exception 
		{
	// Logout from the system
			boolean LogoutFunc = commonMethodsPages.EstoReviewEvalutionLogout();
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
