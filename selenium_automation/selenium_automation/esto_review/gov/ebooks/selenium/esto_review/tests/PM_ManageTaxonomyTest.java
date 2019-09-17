package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;

import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.PM_ManageTaxonomyPage;
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
Manage Taxonomy by Program Manager

Prerequisites: 
•	Program Manager already have Solicitation Assigned.

Program Manager’ Manage Taxonomy feature
1.	Lunch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the checkbox to acknowledge the consent
5.	Click Login button

6.	Select the solicitation which that user wishes to work on if selection of Solicitation pop up box display, otherwise proceed with next Test Case
7.	Navigate to Add Manage Taxonomy from Administrator Tool
8.	Click Add New Taxonomy
9.	Enter value in Category/Question field (Note ** question)
10.	Click Add Option button to enter more Option 
11.	Enter the answer (Value) in option
12.	Repeat steps #10 & 11 three / four times.
13.	Click Submit button

14.	Select the answer from dropdown of question.
15.	Click Save button 


16.	Click Edit button of Existing Taxonomy button
17. Change value in Category field
18.	Change value in Option
19.	Click Submit button

20.	Close the Pop-Up box
21.	Logout form application
22.	Close the browser

*/

public class PM_ManageTaxonomyTest {
	
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private PM_ManageTaxonomyPage PM_ManageTaxonomyPage;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception 
	{
		String UserName = "mlittle";
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		PM_ManageTaxonomyPage = new PM_ManageTaxonomyPage(test.getDriver());
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

			String Question1 = "what is your favorite Car?";
			String Answer1ofQ1 = "Nissan";
			String Answer2ofQ1 = "Toyota";
			String Answer3ofQ1 = "Honda";
			String Answer4ofQ1 = "Chevy";
				
			String Question2 = "what is your favorite Color?";
			String Answer1ofQ2 = "Red";
			String Answer2ofQ2 = "White";
			String Answer3ofQ2 = "Black";
			String Answer4ofQ2 = "Blue";
			

			String Question3 = "What is you favorite place to visit?";
			String Answer1ofQ3 = "Puerto Rico";
			String Answer2ofQ3 = "New York";
			String Answer3ofQ3 = "California";
			
			String SelectAnswer1 = "Honda";

			boolean SelectSoliciation = CommonMethodsESTOReviewPages.SelectACT16Solicitation();
			CommonMethodsESTOReviewPages.ClickSelectSolicitationButton();
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean NavigationTaxonomy = PM_ManageTaxonomyPage.NavToManageTaxonomy();
			Helper.ShowTestResult("2. Navigation to Taxonomy page.", NavigationTaxonomy);
			DataManager.SaveTestResult("Navigation to Taxonomy page", NavigationTaxonomy? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
//****** Add New Taxonomy
			
			boolean NavToAddNewTexonomy = PM_ManageTaxonomyPage.NavToAddNewTaxonomy();
			Helper.ShowTestResult("3. Click Add New Taxonomy.", NavToAddNewTexonomy);
			DataManager.SaveTestResult("Click Add New Taxonomy", NavToAddNewTexonomy? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean CatagoryValue = PM_ManageTaxonomyPage.CatagoryQuestion(Question1);
			Helper.ShowTestResult("4. Enter value in Catagory field.", CatagoryValue);
			DataManager.SaveTestResult("Enter value in Catagory field", CatagoryValue? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean TypeQuestion = PM_ManageTaxonomyPage.QuestionType();
			Helper.ShowTestResult("5. Select Answer to Question as dropdown.", TypeQuestion);
			DataManager.SaveTestResult("Select Answer to Question as dropdown", TypeQuestion? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
// Remove function			
			//PM_ManageTaxonomyPage.AddOption();
			boolean RemoveOption = PM_ManageTaxonomyPage.RemoveOption();
			Helper.ShowTestResult("6. Selection of Remove button.", RemoveOption);
			DataManager.SaveTestResult("Selection of Remove button", RemoveOption? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
//Add Option
			boolean AddOption = PM_ManageTaxonomyPage.AddOption();
			Helper.ShowTestResult("7. Add button function", AddOption);
			DataManager.SaveTestResult("Add button function", AddOption? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean AnswerOfQ1 = PM_ManageTaxonomyPage.EnterValueInOption1(Answer1ofQ1);
			Helper.ShowTestResult("8. Enter value in option field.", AnswerOfQ1);
			DataManager.SaveTestResult("Enter value in option field", AnswerOfQ1? "Passed" : "Failed", "Test Execution Completed Successfully!");

			PM_ManageTaxonomyPage.AddOption();
			PM_ManageTaxonomyPage.EnterValueInOption2(Answer2ofQ1);

			PM_ManageTaxonomyPage.AddOption();
			PM_ManageTaxonomyPage.EnterValueInOption3(Answer3ofQ1);
						
			PM_ManageTaxonomyPage.AddOption();
			PM_ManageTaxonomyPage.EnterValueInOption4(Answer4ofQ1);
			
			boolean SubmitVerification = PM_ManageTaxonomyPage.ClickSubmit();
			Helper.ShowTestResult("9. Function of Submit button.", SubmitVerification);
			DataManager.SaveTestResult("Function of Submit button", SubmitVerification? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
//***** Select Answer and Save 
			boolean SelectAnswerDd = PM_ManageTaxonomyPage.SelectTheAnswerDD(SelectAnswer1);
			Helper.ShowTestResult("10. Selection of answer from dropdown.", SelectAnswerDd);
			DataManager.SaveTestResult("Selection of answer from dropdown", SelectAnswerDd? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean SaveTaxon = PM_ManageTaxonomyPage.SaveManageTaxonomy();
			Helper.ShowTestResult("11. Save of Answer.", SaveTaxon);
			DataManager.SaveTestResult("Save of Answer", SaveTaxon? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			
//***** Edit the Question and set of Question
			boolean EditExitTaxonomy = PM_ManageTaxonomyPage.EditExistingTaxonomy();
			Helper.ShowTestResult("12. Function of Edit button.", EditExitTaxonomy);
			DataManager.SaveTestResult("Function of Edit button", EditExitTaxonomy? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean EditOption1 = PM_ManageTaxonomyPage.CatagoryQuestion(Question3);
			PM_ManageTaxonomyPage.QuestionType();
			Helper.ShowTestResult("13. re-enter the new value in caragory box.", EditOption1);
			DataManager.SaveTestResult("re-enter the new value in caragory box", EditOption1? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
			PM_ManageTaxonomyPage.AddOption();
			PM_ManageTaxonomyPage.EnterValueInOption1(Answer1ofQ3);
			Helper.ShowTestResult("14. re-enter the value in Add Option field.", EditOption1);
			DataManager.SaveTestResult("re-enter the value in Add Option field", EditOption1? "Passed" : "Failed", "Test Execution Completed Successfully!");

			
			PM_ManageTaxonomyPage.AddOption();
			PM_ManageTaxonomyPage.EnterValueInOption2(Answer2ofQ3);
	
			
			PM_ManageTaxonomyPage.AddOption();
			PM_ManageTaxonomyPage.EnterValueInOption3(Answer3ofQ3);
			
			PM_ManageTaxonomyPage.ClickSubmit();
			

			boolean ClosePopUp = PM_ManageTaxonomyPage.ClosePopUp();
			Helper.ShowTestResult("15. Close the Pop Up box.", ClosePopUp);
			DataManager.SaveTestResult("Close the Pop Up box", ClosePopUp? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
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
			//	Driver.TearDown();

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System PM Manage Proposal Stage.", "Program Manager_Manage Proposal Stage");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}			

}
