package gov.ebooks.selenium.esto_review.tests;

import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsPages;
import gov.ebooks.selenium.esto_review.pages.EstoReviewLoginPage;
import gov.ebooks.selenium.esto_review.pages.LeadReviewer;
import gov.ebooks.selenium.esto_review.pages.ManageProposal;
import gov.ebooks.selenium.esto_review.pages.QualityControlPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;

public class LoginVerificationTest {

	private TestSessionInitiator test;
//	private CommonMethodsPages commonMethodsPages;
//	private CommonMethodsESTOReviewPages commonMethodsESTOReviewPages;
	
	private EstoReviewLoginPage estoReviewLoginPage;
	
//	private String proposalNumber = "17-ACT17-0038";
//	private String UserName = "jhoward2";
//	private String Password = "rev_qa";
	
	@BeforeClass
	public void Start_Test_Session() {  
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
//		commonMethodsPages = new CommonMethodsPages(test.getDriver());
//		commonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages(test.getDriver());
		estoReviewLoginPage = new EstoReviewLoginPage(test.getDriver());
		
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();	
	}
	
	@BeforeMethod
	public void handleTestMethodName(Method method){
		test.stepStartMessage(method.getName()); 
	}
	
	@Test(priority=1)
	public void ESTOLogin() throws InterruptedException {
	boolean LaunchESTOReviewHomePage = estoReviewLoginPage.verifyLoginPage();
	Helper.ShowTestResult("**1. Verification of ESTO Review Login.", LaunchESTOReviewHomePage);
	DataManager.SaveTestResult("Verification of ESTO Review Login.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");
    }
	
	@Test(priority=2)
	public void forgotPassword() throws InterruptedException{
		boolean	selectSoliciation = estoReviewLoginPage.forgotPassword();
		Helper.ShowTestResult("**2. Verification of forgot password.", selectSoliciation);
		DataManager.SaveTestResult("Verification of forgot password.", selectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");	    
	}
	
//	@Test(priority=3)
//	public void clickSelectSolicitationButton(){
//		boolean clickSelectSolicitation = commonMethodsESTOReviewPages.ClickSelectSolicitationButton();	
//		Helper.ShowTestResult("**3. Verification of click soliciation.", clickSelectSolicitation);
//		DataManager.SaveTestResult("Verification of click soliciation.", clickSelectSolicitation? "Passed" : "Failed", "Test Execution Completed Successfully!");
//	}
	
	
	
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
		DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO Review System Review of proposal.", "Reviewer_Review of proposal");
		//Driver.Sleep(3);
	}

}


