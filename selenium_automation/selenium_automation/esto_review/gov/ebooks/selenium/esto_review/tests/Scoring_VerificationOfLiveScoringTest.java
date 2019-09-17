package gov.ebooks.selenium.esto_review.tests;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;
import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;

/*import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;*/
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.LeadReviewer;
import gov.ebooks.selenium.esto_review.pages.Scoring_PanelMember_StartScoringPage;
import gov.ebooks.selenium.esto_review.pages.Scoring_ProjectorMember_ViewScoringPage;
import gov.ebooks.selenium.esto_review.pages.Scoring_SuperUser_ScoringEventPage;
import gov.ebooks.selenium.esto_review.pages.ScribePage;


public class Scoring_VerificationOfLiveScoringTest {
	
	private TestSessionInitiator panelMemeber1;
	private TestSessionInitiator panelMemeber2;
	private TestSessionInitiator projector;
	private TestSessionInitiator superUser;
	private TestSessionInitiator scribe;
	
	private HomePage homePagePanel1;
	private CommonMethodsPages commonMethodsPagesPanel1;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPagesPanel1;
	private Scoring_PanelMember_StartScoringPage scoring_PanelMember_StartScoringPagePanel1;
	private Scoring_SuperUser_ScoringEventPage scoring_SuperUser_ScoringEventPagePanel1;
	private ScribePage scribePagePanel1;
	
	private HomePage homePagePanel2;
	private CommonMethodsPages commonMethodsPagesPanel2;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPagesPanel2;
	private Scoring_PanelMember_StartScoringPage scoring_PanelMember_StartScoringPagePanel2;
	
	private HomePage homePageProjector;
	private CommonMethodsPages commonMethodsPagesProjector;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPagesProjector;
	private Scoring_ProjectorMember_ViewScoringPage scoring_ProjectorMember_ViewScoringPageProjector;
	
	
	private HomePage homePageSuperUser;
	private CommonMethodsPages commonMethodsPagesSuperUser;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPagesSuperUser;
//	private LeadReviewer leadReviewerSuperUser;
	private Scoring_SuperUser_ScoringEventPage scoring_SuperUser_ScoringEventPageSuperUser;

	private HomePage homePageScribe;
	private CommonMethodsPages commonMethodsPagesScribe;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPagesScribe;
//	private LeadReviewer leadReviewerScribe;
	private Scoring_SuperUser_ScoringEventPage scoring_SuperUser_ScoringEventPageScribe;
	private ScribePage scribePage;
	
	@BeforeClass
	public void setUpBeforeClass() throws InterruptedException //throws Exception 
	{
		String UserNameProjector = "actprojector";
		String UserNamePanel1 = "GKopp";
		String UserNamePanel2 = "BDrouin";
		String UserNameSuperUser = "ssystem";
		String UserNameScribe = "sozog";
		String Password = "rev_qa";
		
		panelMemeber1 = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		panelMemeber1.launchApplication(getYamlValue("loginUrl"));
		homePagePanel1 = new HomePage(panelMemeber1.getDriver());
		commonMethodsPagesPanel1 = new CommonMethodsPages(panelMemeber1.getDriver());
		CommonMethodsESTOReviewPagesPanel1 = new CommonMethodsESTOReviewPages(panelMemeber1.getDriver());
		scoring_PanelMember_StartScoringPagePanel1 = new Scoring_PanelMember_StartScoringPage (panelMemeber1.getDriver());
		scribePagePanel1 = new ScribePage(panelMemeber1.getDriver());

			
		panelMemeber2 = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		panelMemeber2.launchApplication(getYamlValue("loginUrl"));
		homePagePanel2 = new HomePage(panelMemeber2.getDriver());
		commonMethodsPagesPanel2 = new CommonMethodsPages(panelMemeber2.getDriver());
		CommonMethodsESTOReviewPagesPanel2 = new CommonMethodsESTOReviewPages(panelMemeber2.getDriver());
		scoring_PanelMember_StartScoringPagePanel2 = new Scoring_PanelMember_StartScoringPage (panelMemeber2.getDriver());
	
		projector = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		projector.launchApplication(getYamlValue("loginUrl"));
		homePageProjector = new HomePage(projector.getDriver());
		commonMethodsPagesProjector = new CommonMethodsPages(projector.getDriver());
		CommonMethodsESTOReviewPagesProjector = new CommonMethodsESTOReviewPages(projector.getDriver());
		scoring_ProjectorMember_ViewScoringPageProjector = new Scoring_ProjectorMember_ViewScoringPage (projector.getDriver());
	
		superUser = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		superUser.launchApplication(getYamlValue("loginUrl"));
		homePageSuperUser = new HomePage(superUser.getDriver());
		commonMethodsPagesSuperUser = new CommonMethodsPages(superUser.getDriver());
		CommonMethodsESTOReviewPagesSuperUser = new CommonMethodsESTOReviewPages(superUser.getDriver());
//		leadReviewerSuperUser = new LeadReviewer(superUser.getDriver());
		scoring_SuperUser_ScoringEventPageSuperUser = new Scoring_SuperUser_ScoringEventPage(superUser.getDriver());
		
		scribe = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		scribe.launchApplication(getYamlValue("loginUrl"));
		homePageScribe = new HomePage(scribe.getDriver());
		commonMethodsPagesScribe = new CommonMethodsPages(scribe.getDriver());
		CommonMethodsESTOReviewPagesScribe = new CommonMethodsESTOReviewPages(scribe.getDriver());
//		leadReviewerScribe = new LeadReviewer(scribe.getDriver());
		scribePage = new ScribePage(scribe.getDriver());
		
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
			
		homePagePanel1.ESTOReview();
		CommonMethodsESTOReviewPagesPanel1.ESTOLogin(UserNamePanel1, Password);
		
		homePagePanel2.ESTOReview();
		CommonMethodsESTOReviewPagesPanel2.ESTOLogin(UserNamePanel2, Password);
		
		homePageProjector.ESTOReview();
		CommonMethodsESTOReviewPagesProjector.ESTOLogin(UserNameProjector, Password);
		
		homePageScribe.ESTOReview();
		CommonMethodsESTOReviewPagesScribe.ESTOLogin(UserNameScribe, Password);
		
		boolean LaunchESTOReviewHomePage = homePageSuperUser.ESTOReview();
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin =CommonMethodsESTOReviewPagesSuperUser.ESTOLogin(UserNameSuperUser, Password);
		Helper.ShowTestResult("** Verify Peer Review System _Scoring Verification.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PM Login Function of ESTO Review System.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
		
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in Peer Review System Scoring Functions.\r\n");
			System.out.println("===============================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("Peer Review System Scoring Function"); 
			
	//Pick random number from 1 to 5 by Panel member to enter
			int panel1Score = (int)(Math.random() * (5 - 1) + 1);
			int panel2Score = (int)(Math.random() * (5 - 1) + 1);
			double avgScore = (panel1Score + panel2Score)/2.0;
			//TODO formula for variance
		//	double variance = 4.5;
			double variance = ((panel1Score - avgScore) * (panel1Score - avgScore) + (panel2Score - avgScore) * (panel2Score - avgScore))/2.0;

			
			//*** Verification for Super User Dashboard	
			//CommonMethodsESTOReviewPages.SelectACT17Solicitation();
			
						
	// Verification for Panel member entering scribe message
			boolean PanelMember1SearchProposal  = CommonMethodsESTOReviewPagesPanel1.SearchByProposalNumber();
			Helper.ShowTestResult("M.1 Panel Member Dashboard - Search the proposal by proposal number.", PanelMember1SearchProposal);
			DataManager.SaveTestResult("M.1 Panel Member Dashboard -  Search the proposal by proposal number.", PanelMember1SearchProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			boolean ScribeSearchProposal = CommonMethodsESTOReviewPagesScribe.SearchByProposalNumber();
			Helper.ShowTestResult("M.1 Scribe Dashboard - Search the proposal by proposal number.", ScribeSearchProposal);
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Search the proposal by proposal number.", ScribeSearchProposal? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			
			boolean PanelMember1SendScribeMessage = scribePagePanel1.sendScribeMessage();
			Helper.ShowTestResult("M.1 Scribe Dashboard - Search the proposal by proposal number.", PanelMember1SendScribeMessage);
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Panel member sends the scribe message.", PanelMember1SendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Panel member clicks on the 'Send scribe message' link.", PanelMember1SendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Scribe message window pops up.", PanelMember1SendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Panel member will enter the message.", PanelMember1SendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Panle member click on 'Continue' to send the message.", PanelMember1SendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	

			boolean ScribeNotesLink = scribePage.scribeNotesLink();
			Helper.ShowTestResult("M.1 Scribe Dashboard - Scribe clicks on 'ScribeNotes' Link.", ScribeNotesLink);
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Scribe clicks on 'ScribeNotes' Link.", ScribeNotesLink? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Verification of Scibe Notes page.", ScribeNotesLink? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			
			boolean AppendScribeMessage = scribePage.appendScribeMessage();
			Helper.ShowTestResult("M.1 Scribe Dashboard - Scribe clicks on Scibe Message tab.", AppendScribeMessage);
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Scribe clicks on Scibe Message tab.", AppendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Scribe appends the Scribe Message.", AppendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Scribe clicks on Scribe Notes tab.", AppendScribeMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");	


	// Verification for Super User Dashboard		
			boolean SuperUserSelectSolicitation = CommonMethodsESTOReviewPagesSuperUser.SelectACT17Solicitation();
			Helper.ShowTestResult("M.1 Scribe Dashboard - Superuser selects solicitation.", SuperUserSelectSolicitation);
			DataManager.SaveTestResult("M.1 Scribe Dashboard -  Superuser selects solicitation.", SuperUserSelectSolicitation? "Passed" : "Failed", "Test Execution Completed Successfully!");	
			
			CommonMethodsESTOReviewPagesSuperUser.ClickSelectSolicitationButton();
			CommonMethodsESTOReviewPagesSuperUser.SearchByProposalNumber();
		
	//Super User Starts Scoring	
		//	scoring_SuperUser_ScoringEventPageSuperUser.toggle();
			scoring_SuperUser_ScoringEventPageSuperUser.panelScoringOverview();
			scoring_SuperUser_ScoringEventPageSuperUser.verifyPanelStartScoring();

	// Verification for Panel Member Dashboard
			//boolean MemberPosSelection = scoring_PanelMember_StartScoringPagePanel1.FilterByProposal022();
			//Helper.ShowTestResult("M.1 Member Dashboard - Selection of Proposal.", MemberPosSelection);
			//DataManager.SaveTestResult("M.1 Member Dashboard - Selection of Proposal.", MemberPosSelection? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
	// Panel Member 1 submits scoring	
			boolean ScoringPopUpPanel1 = scoring_PanelMember_StartScoringPagePanel1.PanelScoreField(panel1Score+"");
			Helper.ShowTestResult("M.1 Member Dashboard - Display of scoring Pop Up.", ScoringPopUpPanel1);
			DataManager.SaveTestResult("M.1 Member Dashboard -  Display of scoring Pop Up.", ScoringPopUpPanel1? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			boolean SubmitButtonPanel1 = scoring_PanelMember_StartScoringPagePanel1.ClickSubmitButton();
			Helper.ShowTestResult("M.1 Member Dashboard - function of Submit button.", SubmitButtonPanel1);
			DataManager.SaveTestResult("M.1 Member Dashboard - function of Submit button.", SubmitButtonPanel1? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SubmittedMsgPanel1 = scoring_PanelMember_StartScoringPagePanel1.VerifySubmittedScoreMessage();
			Helper.ShowTestResult("M.1 Member Dashboard - Display of Score sybmitted message.", SubmittedMsgPanel1);
			DataManager.SaveTestResult("M.1 Member Dashboard -  Display of Score sybmitted message.", SubmittedMsgPanel1? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
	//Panel Member 2 submits scoring
			boolean ScoringPopUpPanel2 = scoring_PanelMember_StartScoringPagePanel2.PanelScoreField(panel2Score+"");
			Helper.ShowTestResult("M.2 Member Dashboard - Display of scoring Pop Up.", ScoringPopUpPanel2);
			DataManager.SaveTestResult("M.2 Member Dashboard -  Display of scoring Pop Up.", ScoringPopUpPanel2? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			boolean SubmitButtonPanel2 = scoring_PanelMember_StartScoringPagePanel2.ClickSubmitButton();
			Helper.ShowTestResult("M.2 Member Dashboard - function of Submit button.", SubmitButtonPanel2);
			DataManager.SaveTestResult("M.2 Member Dashboard - function of Submit button.", SubmitButtonPanel2? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SubmittedMsgPanel2 = scoring_PanelMember_StartScoringPagePanel2.VerifySubmittedScoreMessage();
			Helper.ShowTestResult("M.2 Member Dashboard - Display of Score sybmitted message.", SubmittedMsgPanel2);
			DataManager.SaveTestResult("M.2 Member Dashboard -  Display of Score sybmitted message.", SubmittedMsgPanel2? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			
			// Verification for Projector Dashboard
//			boolean ProjectorPropSelection = scoring_ProjectorMember_ViewScoringPageProjector.FilterByProposal022();
//			Helper.ShowTestResult("P.1 Projector Dashboard - Selection of Proposal.", ProjectorPropSelection);
//			DataManager.SaveTestResult("P.1 Projector Dashboard - Selection of Proposal.", ProjectorPropSelection? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
	//Projector's Dashboard with pop up window
			boolean VerifyTimerPopUp = scoring_ProjectorMember_ViewScoringPageProjector.verifyPopUpTimerForProjector();
			Helper.ShowTestResult("P.2 Projector Dashboard - verify timer Pop up box.", VerifyTimerPopUp);
			DataManager.SaveTestResult("P.2 Projector Dashboard- verify timer Pop up box. ", VerifyTimerPopUp? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			
//*****Scoring Closed Verification
	//Super User ends the scoring
			scoring_SuperUser_ScoringEventPageSuperUser.verifyUsersInputScore(panel1Score, panel2Score);
			scoring_SuperUser_ScoringEventPageSuperUser.verifyPanelEndScoring();
			
	//Panel Member1
			boolean FinalScoreMessage = scoring_PanelMember_StartScoringPagePanel1.VerifyFinalScoreMessage();
			Helper.ShowTestResult("M.1 Member Dashboard - Display of Final Score Message.", FinalScoreMessage);
			DataManager.SaveTestResult("M.1 Member Dashboard -  Display of Final Score Message.", FinalScoreMessage? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
	//Projector Verification of End Score Message and verification of Score board
			boolean VerifyScoreEndMsg = scoring_ProjectorMember_ViewScoringPageProjector.verifyScoreEndMessgeForProjector();
			Helper.ShowTestResult("P.3 Projector Dashboard - Score End Message.", VerifyScoreEndMsg);
			DataManager.SaveTestResult("P.3 Projector Dashboard - Score End Message. ", VerifyScoreEndMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean ScoringHeader = scoring_ProjectorMember_ViewScoringPageProjector.verifyPopUpHeaderDisplayForProjector();
			Helper.ShowTestResult("P.4 Projector Dashboard - Scoring Summary Header.", ScoringHeader);
			DataManager.SaveTestResult("P.4 Projector Dashboard - Scoring Summary Header.", ScoringHeader? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean AverageScore = scoring_ProjectorMember_ViewScoringPageProjector.verifyAverageScoreForProjector();
			Helper.ShowTestResult("P.5 Projector Dashboard - Display of average Score.", AverageScore);
			DataManager.SaveTestResult("P.5 Projector Dashboard - Display of average Score. ", AverageScore? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean VaianceScore = scoring_ProjectorMember_ViewScoringPageProjector.verifyVarianceScoreForProjector();
			Helper.ShowTestResult("P.6 Projector Dashboard - Display of Vaiance Score.", VaianceScore);
			DataManager.SaveTestResult("P.6 Projector Dashboard - Display of Vaiance Score. ", VaianceScore? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean DeviationScore = scoring_ProjectorMember_ViewScoringPageProjector.verifyStandDeviScoreForProjector();
			Helper.ShowTestResult("P.7 Projector Dashboard - Display of Deviation Score.", DeviationScore);
			DataManager.SaveTestResult("P.7 Projector Dashboard - Display of Deviation Score.", DeviationScore? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean AdjectavelRating = scoring_ProjectorMember_ViewScoringPageProjector.verifyAdjRatingForProjector();
			Helper.ShowTestResult("P.8 Projector Dashboard - Display of Adjectavel Rating.", AdjectavelRating);
			DataManager.SaveTestResult("P.8 Projector Dashboard - Display of Adjectavel Rating. ", AdjectavelRating? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
	//Super User Verification of Score board		
			boolean SAverageScore = scoring_SuperUser_ScoringEventPageSuperUser.verifyUsersAverageScore(avgScore);
			Helper.ShowTestResult("S1  ", SAverageScore);
			DataManager.SaveTestResult("S1  ", SAverageScore? "Passed" : "Failed", "Test Execution Completed Successfully!");
	
			boolean SVarianceValue = scoring_SuperUser_ScoringEventPageSuperUser.verifyUsersVarianceScore(variance);
			Helper.ShowTestResult("S2  ", SVarianceValue);
			DataManager.SaveTestResult("S2  ", SVarianceValue? "Passed" : "Failed", "Test Execution Completed Successfully!");


		}
		
		catch (Exception ex)
		{
			System.out.println(ex);
			Helper.ShowTestResult("Review System Scoring Functions Test Case", false);
			DataManager.SaveTestResult("Review System Scribe.", "Failed", "Test Execution Failed!");
		}	
	}


	 @AfterClass
		public void tearDownAfterClass() //throws Exception 
		{
		// Logout from the system

				CommonMethodsESTOReviewPagesPanel1.EstoReviewEvalutionLogout();
				panelMemeber1.closeBrowserSession();
						
				CommonMethodsESTOReviewPagesPanel2.EstoReviewEvalutionLogout();
				panelMemeber2.closeBrowserSession();
				
				CommonMethodsESTOReviewPagesProjector.EstoReviewEvalutionLogout();
				projector.closeBrowserSession();
				
				CommonMethodsESTOReviewPagesScribe.EstoReviewEvalutionLogout();
				scribe.closeBrowserSession();
				
				boolean LogoutFunction = CommonMethodsESTOReviewPagesSuperUser.EstoReviewEvalutionLogout();
				superUser.closeBrowserSession();
				
				Helper.ShowTestResult("** Verify Logout function.", LogoutFunction);
				DataManager.SaveTestResult("Verify Logout function.", LogoutFunction? "Passed" : "Failed" , "Test Execution Completed Successfully!");

				DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "Review System Scoring Function.", "Scoring Functions");
				//Driver.Sleep(3);

				Helper.ShowTestResult("* Browser close", true);
			}	
		
}
