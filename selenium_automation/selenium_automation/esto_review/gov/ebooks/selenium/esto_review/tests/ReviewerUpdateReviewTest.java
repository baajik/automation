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
import gov.ebooks.selenium.esto_review.pages.ReviewerUpdateReviewPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.data.UserAccount;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;


/*
Regression Test Steps
Update Review by Reviewer
Prerequisites: 
•	Reviewer already have proposal assigned
•	Proposal is in in Mail-in review stage

Reviewer to complete Conflict of Interest
1.	Launch the site of ESTO Review Program 
2.	Provide UserID
3.	Provide Password
4.	Click the checkbox to acknowledge the consent
5.	Click Login button

1.	Select the solicitation which you want to start.
2.	Verify that correct Solicitation is displaying in Current Solicitation field
3.	Click on Search Filter icon. Select Proposal Number in Sort By dropdown filter. 
4.	Click Confirm
5.	Verify that Proposal order be displaying correctly
6.	Click on Update Review button
7.	Click on toggle Tab/Summary icon
8.	Verify that Tab is clickable
9.	Click back to Toggle Tab / Summary 
10.	Enter value in Proposal Summary field (read from excel or from Script)  
11.	Enter value in Score of Factor 1 Relevance 
12.	Enter value in Strengths of Factor 1 Relevance 
13.	Enter value in Weaknesses of Factor 1 Relevance 

14.	Enter value in Score of Factor 2 Intrinsic Merit 
15.	Enter value in Strengths of Factor 2 Intrinsic Merit
16.	Enter value in Weaknesses of Factor 2 Intrinsic Merit

17.	Enter value in Score of Factor 3 Cost Realism 
18.	Enter value in Strengths of Factor 3 Cost Realism
19.	Enter value in Weaknesses of Factor 3 Cost Realism

20.	Enter value in Comments field 
21.	Enter value in Internal Comments field 
22.	Click Submit button
23.	Verify that Status is Submitted
24.	Verify that Average Score: has value
25.	Verify that Adjectival Rating: has value
26.	Close the Pop-Up box
27.	Verify that status is Submitted
28.	Verify that Factor 1 has value in Score: 
29.	Verify that Factor 2 has value in Score: 
30.	Verify that Factor 3 has value in Score: 

1.	Logout form application
2.	Close the browser
*/

public class ReviewerUpdateReviewTest {

/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	static String UserName = data.getUserName();
	static String Password = data.getPassword();
*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private ReviewerUpdateReviewPage reviewerUpdateReviewPage;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	
	//private String SearchForProposalNumber = "17-ACT17-0038";
	
	@BeforeClass
	public void setUpBeforeClass() //throws Exception 
	{
		//String UserName = "ADubey";
		String UserName = JDBCconnection.username;
		String Password = "rev_qa";
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());

		reviewerUpdateReviewPage = new ReviewerUpdateReviewPage(test.getDriver());
		
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
			System.out.print("\r\n** Verification of Field Validation in Reviwer - Update/Add comments to Proposal.\r\n");
			System.out.println("====================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("ESTOReviewSystem_Reviewer_Update Review"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("Change_Password");

/*			boolean SelectSoliciation = reviewerUpdateReviewPage.SelectACT17Solicitation();
			reviewerUpdateReviewPage.ClickSelectSolicitationButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Selection of solicitation.", SelectSoliciation);
			DataManager.SaveTestResult("Selection of solicitation.", SelectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");
	*/
			boolean verifyCorrectSolPage = reviewerUpdateReviewPage.VerifyCorrectCurrentSolicitation();
			Helper.ShowTestResult("2. Verification of navigation to correct solicitation.", verifyCorrectSolPage);
			DataManager.SaveTestResult("Verification of navigation to correct solicitation", verifyCorrectSolPage? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
//Verify Sort By Filter Function
/*			
			reviewerUpdateReviewPage.NavOfSearchIcon();
			reviewerUpdateReviewPage.FunctionSearchFilter();
			boolean SortByFuction = reviewerUpdateReviewPage.ClickConfirmButton();
			Helper.ShowTestResult("3. Verification of Sort By Function.", SortByFuction);
			DataManager.SaveTestResult("Verification of Sort By Function", SortByFuction? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean SortByResult = reviewerUpdateReviewPage.VerifySortbyResult();
			Helper.ShowTestResult("4. Verification of Search result.", SortByResult);
			DataManager.SaveTestResult("Verification of Search result", SortByResult? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
		*/	
			
			
			
			boolean searchFilter = CommonMethodsESTOReviewPages.SearchByProposalNumber();
			Helper.ShowTestResult("2. Search by Proposal number.", searchFilter);
			DataManager.SaveTestResult("Search by Proposal number", searchFilter? "Passed" : "Failed", "Test Execution Completed Successfully!");
			//CommonMethodsESTOReviewPages.ClickExpanArrow();	
		
			reviewerUpdateReviewPage.ClickUpdateReviewIcon();
			//Driver.Sleep(5);
			
			
//** Toggle back 			
			boolean ToggleTabSum = reviewerUpdateReviewPage.ClickToggleTabSummary();
			Helper.ShowTestResult("5. Navigtion of Tottle/Tab Summary.", ToggleTabSum);
			DataManager.SaveTestResult("Navigtion of Tottle/Tab Summary", ToggleTabSum? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ClickSummaryTab = reviewerUpdateReviewPage.ClickProposalSummaryTab();
			Helper.ShowTestResult("6. Click of Propsoal Summary Tab.", ClickSummaryTab);
			DataManager.SaveTestResult("Click of Propsoal Summary Tab", ClickSummaryTab? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ClickRelevanceTab = reviewerUpdateReviewPage.ClickFactor1Relevance();
			Helper.ShowTestResult("7. Click of Factor 1 Relevance Tab.", ClickRelevanceTab);
			DataManager.SaveTestResult("Click of Factor 1 Relevance Tab", ClickRelevanceTab? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ClickIntrinsicMeritTab = reviewerUpdateReviewPage.ClickFactor2IntrinsicMerit();
			Helper.ShowTestResult("8. Click of Factor 2 Intrinsic Merit Tab.", ClickIntrinsicMeritTab);
			DataManager.SaveTestResult("Click of Factor 2 Intrinsic Merit Tab", ClickIntrinsicMeritTab? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ClickCostRealismTab = reviewerUpdateReviewPage.ClickFactor3CostRealism();
			Helper.ShowTestResult("9. Click of Factor 3 Cost Realism Tab.", ClickCostRealismTab);
			DataManager.SaveTestResult("Click of Factor 3 Cost Realism Tab", ClickCostRealismTab? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ClickCommentsTab = reviewerUpdateReviewPage.ClickComments();
			Helper.ShowTestResult("10. Click of Comments Tab.", ClickCommentsTab);
			DataManager.SaveTestResult("Click of Comments Tab", ClickCommentsTab? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ClickInterCommentsTab = reviewerUpdateReviewPage.ClickInternalComments();
			Helper.ShowTestResult("11. Click of Internal Comments Tab.", ClickInterCommentsTab);
			DataManager.SaveTestResult("Click of Internal Comments Tab", ClickInterCommentsTab? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			//Toggle back
			reviewerUpdateReviewPage.ClickToggleTabSummary();

			
			String Summary = "Automation Test enter value in Summary";
			String FacOneScore = "4.0";
			String FacOneStrength = "Automation Strengths Test";
			String FacOneWeakness = "Automation Weakness Test";
			String FacTwoScore = "2.0";
			String InstMeritStrength = "Automation Test for Merit Strength";
			String InsMeritWeakess = "Automation Test for Merit Weakness";
			String FacThreeScore = "3.5";
			String CostStrenght = "Automation Test for Cost Strength";
			String CostWeakness = "Automation Test for Cost Weakness";
			String Comments = "Test to put value in Comments";
			String InternalComments = "Enter value in Internal Comments";
			
			
			boolean ValueSummary = reviewerUpdateReviewPage.UpdateReview("ProposalSummary", Summary);
			//Driver.Sleep(5);
			Helper.ShowTestResult("11. Verification of Summary field.", ValueSummary);
			DataManager.SaveTestResult("Verification of Summary field", ValueSummary? "Passed" : "Failed", "Test Execution Completed Successfully!");

//Factor 1			
			boolean Factor1Score = reviewerUpdateReviewPage.UpdateReview("RelevanceFactor1Score", FacOneScore);
			//Driver.Sleep(5);
			Helper.ShowTestResult("12. Verification of Factor One Score field.", Factor1Score);
			DataManager.SaveTestResult("Verification of Factor One Score field", Factor1Score? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean RelevanceStrengths  = reviewerUpdateReviewPage.UpdateReview("RelevanceFactor1Strengths", FacOneStrength);
			//Driver.Sleep(5);
			Helper.ShowTestResult("13. Verification of Relevance Strengths field.", RelevanceStrengths);
			DataManager.SaveTestResult("Verification of Relevance Strengths field", RelevanceStrengths? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean RelevanceWeaknesses = reviewerUpdateReviewPage.UpdateReview("RelevanceFactor1Weaknesses", FacOneWeakness);
			//Driver.Sleep(5);
			Helper.ShowTestResult("14. Verification of Relevance Weakness field.", RelevanceWeaknesses);
			DataManager.SaveTestResult("Verification of Relevance Weakness field", RelevanceWeaknesses? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
//Factor 2
			boolean Factor2Scrore = reviewerUpdateReviewPage.UpdateReview("MeritFactorScore2", FacTwoScore);
			//Driver.Sleep(5);
			Helper.ShowTestResult("15. Verification of Factor Two Score field.", Factor2Scrore);
			DataManager.SaveTestResult("Verification of Factor Two Score field", Factor2Scrore? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean Fac2MeritStrength = reviewerUpdateReviewPage.UpdateReview("MeritStrengths", InstMeritStrength);
			//Driver.Sleep(5);
			Helper.ShowTestResult("16. Verification of Merit Strengths field.", Fac2MeritStrength);
			DataManager.SaveTestResult("Verification of Merit Strengths field", Fac2MeritStrength? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean Fac2MeritWeakness = reviewerUpdateReviewPage.UpdateReview("MeritWeaknesses", InsMeritWeakess);
			//Driver.Sleep(5);
			Helper.ShowTestResult("17. Verification of Merit Weakness field.", Fac2MeritWeakness);
			DataManager.SaveTestResult("Verification of Merit Weakness field", Fac2MeritWeakness? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
//Factor 2			
			boolean Factor3Score = reviewerUpdateReviewPage.UpdateReview("CostFactorScore3", FacThreeScore);
			//Driver.Sleep(5);
			Helper.ShowTestResult("18. Verification of Factor Three Score field.", Factor3Score);
			DataManager.SaveTestResult("Verification of Factor Three Score field", Factor3Score? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean Fac3CostStrength = reviewerUpdateReviewPage.UpdateReview("CostStrengths", CostStrenght);
			//Driver.Sleep(5);
			Helper.ShowTestResult("19. Verification of Cost Strengths field. ", Fac3CostStrength);
			DataManager.SaveTestResult("Verification of Cost Strengths field", Fac3CostStrength? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean Fac3CostWeakness = reviewerUpdateReviewPage.UpdateReview("CostWeaknesses", CostWeakness);
			//Driver.Sleep(5);
			Helper.ShowTestResult("20. Verification of Cost Weaknesses field.", Fac3CostWeakness);
			DataManager.SaveTestResult("Verification of Cost Weaknesses field", Fac3CostWeakness? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ValueEnterInComments = reviewerUpdateReviewPage.UpdateReview("Comments", Comments);
			//Driver.Sleep(5);
			Helper.ShowTestResult("21. Verification of Comments field.", ValueEnterInComments);
			DataManager.SaveTestResult("Verification of Comments field.", ValueEnterInComments? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ValueInInternalComments = reviewerUpdateReviewPage.UpdateReview("InternalComments", InternalComments);
			//Driver.Sleep(5);
			Helper.ShowTestResult("22. Verification of Internal Comments field.", ValueInInternalComments);
			DataManager.SaveTestResult("Verification of Internal Comments field", ValueInInternalComments? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SaveButton = reviewerUpdateReviewPage.ClickSaveButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("23. Verification of Save Button fuction.", SaveButton);
			DataManager.SaveTestResult("Verification of Save Button fuction", SaveButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean Submit = reviewerUpdateReviewPage.SubmitButton();
			//Driver.Sleep(5);
			Helper.ShowTestResult("24. Verification of Submit button.", Submit);
			DataManager.SaveTestResult("Verification of Submit button", Submit? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean StatusSubmitted = reviewerUpdateReviewPage.VerifySatusSubmitted();
			Helper.ShowTestResult("25. Verification of Status", StatusSubmitted);
			DataManager.SaveTestResult("Verification of Status", StatusSubmitted? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean AverageScore = reviewerUpdateReviewPage.VerifyAverageScore();
			Helper.ShowTestResult("26. Verification of Average Score.", AverageScore);
			DataManager.SaveTestResult("Verification of Average Score", AverageScore? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean AdjRating = reviewerUpdateReviewPage.VerifyAdjectivalRating();
			Helper.ShowTestResult("27. Verification of Adjectival Rating.", AdjRating);
			DataManager.SaveTestResult("Verification of Adjectival Rating", AdjRating? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean ClosePopUp = reviewerUpdateReviewPage.ClosePopUp();
			//Driver.Sleep(5);
			Helper.ShowTestResult("28. Verification of closing Pop Up.", ClosePopUp);
			DataManager.SaveTestResult("Verification of closing Pop Up", ClosePopUp? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ScoreFactor1 = reviewerUpdateReviewPage.VerifyScoreOfFactor1();
			Helper.ShowTestResult("29. Verification of Score Factor 1.", ScoreFactor1);
			DataManager.SaveTestResult("Verification of Score Factor 1", ScoreFactor1? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ScoreFactor2 = reviewerUpdateReviewPage.VerifyScoreOfFactor2();
			Helper.ShowTestResult("30. Verification of Score Factor 2.", ScoreFactor2);
			DataManager.SaveTestResult("Verification of Score Factor 2", ScoreFactor2? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean ScoreFactor3 = reviewerUpdateReviewPage.VerifyScoreOfFactor3();
			Helper.ShowTestResult("31. Verification of Score Factor 3.", ScoreFactor3);
			DataManager.SaveTestResult("Verification of Score Factor 3", ScoreFactor3? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			}
		
		catch (Exception ex)
		{
			Helper.ShowTestResult("ESTO Review System Review of proposal function Test Case", false);
			DataManager.SaveTestResult("ESTO Review System Review of proposal.", "Failed", "Test Execution Failed!");
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

			DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Review of proposal.", "Reviewer_Review of proposal");
			//Driver.Sleep(3);

			Helper.ShowTestResult("* Browser close", true);
		}	

}
