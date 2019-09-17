 package gov.ebooks.selenium.esto_review.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.ManageProposal;
import gov.ebooks.selenium.esto_review.pages.ManageUsers;
import gov.ebooks.selenium.esto_review.pages.AccountProfileSetupPage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

public class ManageProposalTest {

//	private static final String FieldName = null;
//	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
//	
//	static String UserName = data.getUserName();
//	static String Password = data.getPassword();
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
//	private AccountProfileSetupPage accountProfileSetupPage;
	private ManageProposal manageProposalPage;
	private ManageUsers	manageUsersPage;
/*	
	@BeforeClass
	public void Start_Test_Session() {  //throws Exception
	
		//String UserName = "achapin";
		//String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
//		accountProfileSetupPage = new AccountProfileSetupPage(test.getDriver());
		manageProposalPage = new ManageProposal(test.getDriver());
		//commonMethodsPages
		manageUsersPage = new ManageUsers(test.getDriver());

		
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
	}
	
	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
//	commonMethodsPages.ESTOLogin("achapin","rev_qa");	
	public void ESTOLogin1() throws InterruptedException {
	commonMethodsPages.ESTOLogin("ssystem", "rev_qa");	
		//assertTrue(testResult);
	
	}
	@Test(priority=2)
	public void selectACT16Solicitation(){
		commonMethodsPages.SelectACT16Solicitation();
	}
	
	@Test(priority=3)
	public void ClickSelectSolicitationButton(){
		commonMethodsPages.ClickSelectSolicitationButton();		
	}
	
//	@Test(priority=4)
//	public void ERSCofigurationStepOneAndTwo(){
//		commonMethodsPages.ERSCofigurationStepOneAndTwo();		
//	}
	
	@Test(priority=5)
	public void selectProposal() throws InterruptedException {
		manageProposalPage.selectManageProposal();
		DataManager.SaveTestResult("Select Manager Proposal", "Passed", "Manage Proposal Selection Successful!");
//		boolean testResult = manageProposalPage.selectProposal();
//		DataManager.SaveTestResult("SMD Login Test", testResult? "Passed" : "Failed", "Test Execution Completed Successfully!");
//		assertTrue(testResult);
	}
	
	@Test(priority=6)
	public void selectManageUsers() throws InterruptedException {
		manageUsersPage.selectManageUsers();
		DataManager.SaveTestResult("Select Manager Proposal", "Passed", "Manage Proposal Selection Successful!");
		manageUsersPage.selectManageUser();
		DataManager.SaveTestResult("SMD Login Test", "Passed", "Test Execution Completed Successfully!");
	//	assertTrue(testResult);
//		manageUsersPage.addNewUser();
//		DataManager.SaveTestResult("SMD Login Test", "Passed", "Test Execution Completed Successfully!");
		manageUsersPage.manageUserAssignProposal();
		DataManager.SaveTestResult("SMD Login Test", "Passed", "Test Execution Completed Successfully!");	
		
	}
	
//	@Test(priority=7)
//	public void NotifyUsers() throws InterruptedException {
//		manageUsersPage.NotifyUsers();
//		DataManager.SaveTestResult("Select Manager Proposal", "Passed", "Manage Proposal Selection Successful!");
//		boolean testResult = manageUsersPage.selectNotifyUsers();
//		DataManager.SaveTestResult("SMD Login Test", testResult? "Passed" : "Failed", "Test Execution Completed Successfully!");
//	//	assertTrue(testResult);
////		manageUsersPage.addNewUser();
////		DataManager.SaveTestResult("SMD Login Test", "Passed", "Test Execution Completed Successfully!");
//	}
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
	}

}


@Test
public void test() 
{
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
			TestResult testResult = new TestResult();/			testResult.setTestDate(new Date().toString());
			testResult.setTestName("AppsciERS_PI_Account Change Profile"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

			boolean SelectSoliciation = accountProfileSetupPage.SelectACT16Solicitation();
			accountProfileSetupPage.ClickSelectSolicitationButton();
//			Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);/			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			
			
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
		boolean LogoutFunc = commonMethodsPages.EstoReviewEvalutionLogout();
//		Driver.Sleep(2);
		Helper.ShowTestResult("** Verify Logout function.", LogoutFunc);
		DataManager.SaveTestResult("Verify Logout function.", LogoutFunc? "Passed" : "Failed" , "Test Execution Completed Successfully!");
		test.closeBrowserSession();
//		Driver.TearDown();

		DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Account Change Profile.", "Reviewer_Account Change Profile");
//		Driver.Sleep(3);

		Helper.ShowTestResult("* Browser close", true);
	}	
		
*/
}

	
	
	

