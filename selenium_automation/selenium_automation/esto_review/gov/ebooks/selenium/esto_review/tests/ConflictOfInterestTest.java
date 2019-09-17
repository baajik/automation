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
import gov.ebooks.selenium.esto_review.pages.ConflictOfInterestPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;



public class ConflictOfInterestTest 
{
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private ConflictOfInterestPage conflictOfInterestPage;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	
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
		conflictOfInterestPage = new ConflictOfInterestPage(test.getDriver());

		
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

			boolean SelectSoliciation = conflictOfInterestPage.SelectACT17Solicitation();
//			Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SelectSolicitationButton = conflictOfInterestPage.ClickSelectButton();
//			Driver.Sleep(3);
			Helper.ShowTestResult("2. Verification of Submit button in Solcitation.", SelectSolicitationButton);
			DataManager.SaveTestResult("Verification of Submit button in Solcitation", SelectSolicitationButton? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
//Conflict of Interest	
			CommonMethodsESTOReviewPages.SearchByProposalNumber();
			boolean ClickConfOfInterest = conflictOfInterestPage.ClickConflictOfInterest();
//			Driver.Sleep(5);
			Helper.ShowTestResult("3. Navigation of Conflict of Interest Page.", ClickConfOfInterest);
			DataManager.SaveTestResult("Navigation of Conflict of Interest Page", ClickConfOfInterest? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SelectRedioConInterest = conflictOfInterestPage.SelectConflictOfInterestRadioButton();
//			Driver.Sleep(4);
			Helper.ShowTestResult("4. Selection of Conflict of Interest button.", SelectRedioConInterest);
			DataManager.SaveTestResult("Selection of Conflict of Interest button.", SelectRedioConInterest? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SelectConfType = conflictOfInterestPage.SelectConflictType();
//			Driver.Sleep(4);
			Helper.ShowTestResult("5. Selection of Conflict Type.", SelectConfType);
			DataManager.SaveTestResult("Selection of Conflict Type", SelectConfType? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			String ConflictComments = "Test Enter value in comments box";
				
			boolean EnterValueInComments = conflictOfInterestPage.EnterValueForCOI(ConflictComments);
//			Driver.Sleep(4);
			Helper.ShowTestResult("6. ", EnterValueInComments);
			DataManager.SaveTestResult(".", EnterValueInComments? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			boolean SelectSubmitforCOI = conflictOfInterestPage.ClickSubmitForCOI();
//			Driver.Sleep(3);
			Helper.ShowTestResult("7. ", SelectSubmitforCOI);
			DataManager.SaveTestResult(".", SelectSubmitforCOI? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean VerSucessMsgCOI = conflictOfInterestPage.VerifySuccessMessage();
//			Driver.Sleep(4);
			Helper.ShowTestResult("8. ", VerSucessMsgCOI);
			DataManager.SaveTestResult(".", VerSucessMsgCOI? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClosePoupBoxCOI = conflictOfInterestPage.ClickOkayButton();
//			Driver.Sleep(4);
			Helper.ShowTestResult("9. ", ClosePoupBoxCOI);
			DataManager.SaveTestResult(".", ClosePoupBoxCOI? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			
//Lack Of Expertise			
			boolean SelectCOIforLackofInterest = conflictOfInterestPage.ClickConflictOfInterest();
//			Driver.Sleep(5);
			Helper.ShowTestResult("10. ", SelectCOIforLackofInterest);
			DataManager.SaveTestResult(".", SelectCOIforLackofInterest? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SelLackExpertise = conflictOfInterestPage.SelectLackOfExpertise();
//			Driver.Sleep(5);
			Helper.ShowTestResult("11. ", SelLackExpertise);
			DataManager.SaveTestResult(".", SelLackExpertise? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			String LOEVallue = "Test of text for Lack of Expertise.";
			boolean EnterLOCValue = conflictOfInterestPage.EnterValueForCOI(LOEVallue);
//			Driver.Sleep(2);
			Helper.ShowTestResult("12. ", EnterLOCValue);
			DataManager.SaveTestResult(".", EnterLOCValue? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SelectSubmitforLOE = conflictOfInterestPage.ClickSubmitForCOI();
//			Driver.Sleep(3);
			Helper.ShowTestResult("13. ", SelectSubmitforLOE);
			DataManager.SaveTestResult(".", SelectSubmitforLOE? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean VerSucessMsgLOE = conflictOfInterestPage.VerifySuccessMessage();
//			Driver.Sleep(4);
			Helper.ShowTestResult("14. ", VerSucessMsgLOE);
			DataManager.SaveTestResult(".", VerSucessMsgLOE? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClosePoupBoxLOE = conflictOfInterestPage.ClickOkayButton();
//			Driver.Sleep(4);
			Helper.ShowTestResult("15. ", ClosePoupBoxLOE);
			DataManager.SaveTestResult(".", ClosePoupBoxLOE? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
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
			boolean LogoutFunc = commonMethodsPages.EstoReviewEvalutionLogout();
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
