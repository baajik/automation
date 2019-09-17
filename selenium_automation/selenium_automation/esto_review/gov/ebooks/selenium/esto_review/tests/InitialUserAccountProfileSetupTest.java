package gov.ebooks.selenium.esto_review.tests;


import static gov.ebooks.selenium.shared.utils.YamlReader.getYamlValue;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gov.ebooks.selenium.appsci.pages.CommonMethodsPages;
import gov.ebooks.selenium.appsci.pages.HomePage;
import gov.ebooks.selenium.esto_review.pages.AccountProfileSetupPage;
import gov.ebooks.selenium.esto_review.pages.CommonMethodsESTOReviewPages;
import gov.ebooks.selenium.esto_review.pages.EstoReviewLoginPage;
import gov.ebooks.selenium.esto_review.pages.NonDisclosureAgreementPage;
import gov.ebooks.selenium.esto_review.pages.SecurityQuestionPage;
import gov.ebooks.selenium.esto_review.pages.UpdateChangePasswordPage;
import gov.ebooks.selenium.shared.data.TestResult;
import gov.ebooks.selenium.shared.data.TestResultList;
import gov.ebooks.selenium.shared.utils.DataManager;
import gov.ebooks.selenium.shared.utils.Helper;
import gov.ebooks.selenium.shared.utils.JDBCconnection;
import gov.ebooks.selenium.shared.utils.TestSessionInitiator;


/*
Initial Update Profile (Forced Update) 
Prerequisites: 
�	User who have not logged into the system

New User Update Profile setup
1.	Lunch the site of ESTO Review Program 
2.	Login to ESTO Review Program with user who has not login to system and has start initial setup.
3.	Provide UserID
4.	Provide Password
5.	Click the checkbox to acknowledge the consent
6.	Click Login button. Verify that user is getting to Update Profile page

7.	Remove value from Email field. 
8.	Remove value from Organization field
9.	Remove value from Street Address field
10.	Remove value from City field
11.	Remove value from State field
12.	Remove value from Zip field
13.	Remove value from County field
14.	Remove vale from Phone Number field
15.	Click Submit button
16.	Verify that validation message is displaying in Email* �Email is required�
17.	Verify that validation message is displaying in Organization* �Organization is required�
18.	Verify that validation message is displaying in Street Address* �Address is required�
19.	Verify that validation message is displaying in City* �City is required�
20.	Verify that validation message is displaying in State* �State is required�
21.	Verify that validation message is displaying in Zip* �Zipcode is required�
22.	Verify that validation message is displaying in Country* �Country is required�
23.	Verify that validation message is displaying in Phone Number* �Phone Number must be 10 characters�

24.	Provide value in Email field. 
25.	Provide value in Organization field
26.	Provide value in Street Address field
27.	Provide value in City field
28.	Provide value in State field
29.	Provide value in Zip field
30.	Provide value in County field
31.	Provide vale in Phone Number field
32.	Click Submit button
33.	Verify that user is navigating to Update / Change Password
*/


public class InitialUserAccountProfileSetupTest 
{
/*	private static final String FieldName = null;
	static UserAccount data = DataManager.GetUserAccount("ESTOReviewer");
	
	static String UserName = data.getUserName();
	static String Password = data.getPassword();*/
	
	private TestSessionInitiator test;
	private HomePage homePage;
	private CommonMethodsPages commonMethodsPages;
	private CommonMethodsESTOReviewPages CommonMethodsESTOReviewPages;
	private AccountProfileSetupPage accountProfileSetupPage;
	private UpdateChangePasswordPage updateChangePasswordPage;
	private SecurityQuestionPage securityQuestionPage;
	private NonDisclosureAgreementPage nonDisclosureAgreementPage;
	private EstoReviewLoginPage estoReviewLoginPage;
	
	@BeforeClass
	public void setUpBeforeClass() //throws Exception 
	{
	//Getting is Username (New User) from RegisterNewUserAssignProposalTest thru Database and running this Test
		String UserName = JDBCconnection.username;
		String Password = "rev_qa";
		
		//ASandu -  17-ACT17-0032
		//aAubrey - 17-ACT17-0031
		//gRichardson - 17-ACT17-0030
		
		
		test = new TestSessionInitiator(this.getClass().getSimpleName(), this.getClass().getPackage().getName());
		test.launchApplication(getYamlValue("loginUrl"));
		homePage = new HomePage(test.getDriver());
		commonMethodsPages = new CommonMethodsPages(test.getDriver());
		CommonMethodsESTOReviewPages = new CommonMethodsESTOReviewPages (test.getDriver());
		accountProfileSetupPage = new AccountProfileSetupPage(test.getDriver());
		updateChangePasswordPage = new UpdateChangePasswordPage(test.getDriver());
		securityQuestionPage = new SecurityQuestionPage(test.getDriver());
		nonDisclosureAgreementPage = new NonDisclosureAgreementPage(test.getDriver());
		estoReviewLoginPage = new EstoReviewLoginPage(test.getDriver());
		
		Helper.ShowTestHeader();
		TestResultList.ExternalTestSuit = new ArrayList<TestResult>();
		
		// Alternate method to lunch the HomePage
		//Driver.GoTo("https://nasa-ebooks-qa.amer.reisystems.com/review/login");

		boolean LaunchESTOReviewHomePage = homePage.ESTOReview();
//		//Driver.Sleep(5);
		Helper.ShowTestResult("** Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage);
		DataManager.SaveTestResult("Verification of Launching of ESTO Home Page.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");

		boolean ESTOUserLogin = CommonMethodsESTOReviewPages.ESTOLogin(UserName, Password);
//		//Driver.Sleep(3);
		Helper.ShowTestResult("** Verify PI Login to AppSciERS Function.", ESTOUserLogin);
		DataManager.SaveTestResult("Verify PI Login Function of Applied Science.", ESTOUserLogin? "Passed" : "Failed", "Test Execution Completed Successfully!");
	}

	
	@Test
	public void test1() 
	{
		try
		{
			System.out.print("\r\n** Verification of Field Validation in ESTO User Initial Update Profile Page.\r\n");
			System.out.println("=================================================================================");
			TestResult testResult = new TestResult();
			testResult.setTestDate(new Date().toString());
			testResult.setTestName("Peer Review_Enforce Initial Account Profile Setup"); 
			//ESTO Review System_User Profile Validation Message
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("ESTO_Update Profile Page");

/*
			
//			@Test(priority=1)
//			public void ESTOLogin1() throws InterruptedException {
			boolean LaunchESTOReviewHomePage = estoReviewLoginPage.verifyLoginPage();
			Helper.ShowTestResult("**1. Verification of ESTO Review Login.", LaunchESTOReviewHomePage);
			DataManager.SaveTestResult("Verification of ESTO Review Login.", LaunchESTOReviewHomePage? "Passed" : "Failed", "Test Execution Completed Successfully!");
		  //  }
			
//			@Test(priority=2)
//			public void forgotPassword() throws InterruptedException{
				boolean	selectSoliciation = estoReviewLoginPage.forgotPassword();
				Helper.ShowTestResult("**2. Verification of forgot password.", selectSoliciation);
				DataManager.SaveTestResult("Verification of forgot password.", selectSoliciation? "Passed" : "Failed", "Test Execution Completed Successfully!");	    
//			}
		
*/				
			//InitialUserAccountProfileSetupPage.DeleteEmail();
			
			accountProfileSetupPage.RemoveValueInFieldAndSubmit();
		
			boolean EmailValidation = accountProfileSetupPage.EmailValidationMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("1. Test of validation message for email Field.", EmailValidation);
			DataManager.SaveTestResult("Test of validation message for email Field.", EmailValidation? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean OrganizationValidationMsg = accountProfileSetupPage.OrganizationValidationMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("2. Test of validation message for Organization Field.", OrganizationValidationMsg);
			DataManager.SaveTestResult("Test of validation message for Organization Field.", OrganizationValidationMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean AddressValidationMsg =  accountProfileSetupPage.AddressValidationMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("3. Test of validation message for Address Field", AddressValidationMsg);
			DataManager.SaveTestResult("Test of validation message for Address Field.", AddressValidationMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean CityValidationMsg =accountProfileSetupPage.CityValidationMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("4. Test of validation message for City Field", CityValidationMsg);
			DataManager.SaveTestResult("Test of validation message for City Field.", CityValidationMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean StateValMsg =accountProfileSetupPage.StateValMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("5. Test of validation message for State Field", StateValMsg);
			DataManager.SaveTestResult("Test of validation message for State Field.", StateValMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean ZipcodeValMsg =accountProfileSetupPage.ZipcodeValMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("6. Test of validation message for Zipcode Field",  ZipcodeValMsg);
			DataManager.SaveTestResult("Test of validation message for Zipcode Field.", ZipcodeValMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean CountryValMsg =accountProfileSetupPage.CountryValMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("7. Test of validation message for Country Field", CountryValMsg);
			DataManager.SaveTestResult("Test of validation message for Country Field.", CountryValMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
					
			boolean PhoneValMsg = accountProfileSetupPage.PhoneValMsg();
			//Driver.Sleep(5);
			Helper.ShowTestResult("8. Test of validation message for Phone Field", PhoneValMsg);
			DataManager.SaveTestResult("Test of validation message for Phone Field.", PhoneValMsg? "Passed" : "Failed", "Test Execution Completed Successfully!");
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("Test Case of ESTO User Intial Update Profile validation message.", false);
			DataManager.SaveTestResult("Test Case of ESTO User Intial Update Profile validation message.", "Failed", "Test Execution Failed!");
		}	
	}
	
	
	
	@Test
	public void test2() 
	{
		try
		{
			System.out.print("\r\n** Test of ESTO User Initial Profile Setup Function.\r\n");
			System.out.println("==========================================================");
			//TestResult testResult = new TestResult();
			//testResult.setTestDate(new Date().toString());
			//testResult.setTestName("ESTO Review System_User Profile Setup Function");
		
		//Import data from excel
			//String data[][] = DataManager.ImportFromExcel("ESTO_Update Profile Page");
			
			//String EmailValue = "test12@gmail.com";
			Random rand = new Random();
			String EmailValue = "test" + rand.nextInt(99999999) + "@gmail.com"; //get the random gmail address
			String OrganizationValue = "VirginiaTechs";
			String AddressValue = "223 Abc Street";
			String CityValue = "Blacksburg";
			String StateValue = "VA";
			String ZipValue = "24062";
			String CountryValue  = "USA"; 
			String PhoneNumberValue = "1231231235";
			String FaxNumberValue = "2223334445";
			
			
			//boolean emailField = ESTO_AccountProfileSetupPage.UpdateProfileFields("Email", data [1][0]);
			boolean emailField = accountProfileSetupPage.UpdateProfileFields("Email", EmailValue);
			//boolean emailField = accountProfileSetupPage.UpdateProfileFields("Email", EmailValue+"");
			//Driver.Sleep(5);
			Helper.ShowTestResult("9. Verification of Phone Field.", emailField);
			DataManager.SaveTestResult("Verification of Phone Field.", emailField? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			//boolean OrganizationField = ESTO_AccountProfileSetupPage.UpdateProfileFields("organization", data [1][1]);
			boolean OrganizationField = accountProfileSetupPage.UpdateProfileFields("organization", OrganizationValue);
			//Driver.Sleep(5);
			Helper.ShowTestResult("10.Verification of Organization Field", OrganizationField);
			DataManager.SaveTestResult("Verification of Organization Field.", OrganizationField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean AddressField = ESTO_AccountProfileSetupPage.UpdateProfileFields("address", data [1][2]);
			boolean AddressField = accountProfileSetupPage.UpdateProfileFields("address", AddressValue);
			//Driver.Sleep(3);
			Helper.ShowTestResult("11.Verification of Address Field", AddressField);
			DataManager.SaveTestResult("Verification of Address Field.", AddressField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean CityField = ESTO_AccountProfileSetupPage.UpdateProfileFields("city", data [1][3]);
			boolean CityField = accountProfileSetupPage.UpdateProfileFields("city", CityValue);
			//Driver.Sleep(5);
			Helper.ShowTestResult("12.Verification of City Field", CityField);
			DataManager.SaveTestResult("Verification of City Field.", CityField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean stateField = ESTO_AccountProfileSetupPage.UpdateProfileFields("state", data [1][4]);
			boolean stateField = accountProfileSetupPage.UpdateProfileFields("state", StateValue);
			//Driver.Sleep(5);
			Helper.ShowTestResult("13.Verification of State Field", stateField);
			DataManager.SaveTestResult("Verification of State Field.", stateField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean zipField = ESTO_AccountProfileSetupPage.UpdateProfileFields("zip", data [1][5]);
			boolean zipField = accountProfileSetupPage.UpdateProfileFields("zip", ZipValue);
			//Driver.Sleep(5);
			Helper.ShowTestResult("14.Verification of Zipcode Field", zipField);
			DataManager.SaveTestResult("Verification of Zipcode Field.", zipField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean CountryField = ESTO_AccountProfileSetupPage.UpdateProfileFields("Country", data [1][6]);
			boolean CountryField = accountProfileSetupPage.UpdateProfileFields("Country", CountryValue);
			//Driver.Sleep(5);
			Helper.ShowTestResult("15.Verification of Country Field", CountryField);
			DataManager.SaveTestResult("Verification of Country Field.", CountryField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean PhoneNumberField = ESTO_AccountProfileSetupPage.UpdateProfileFields("PhoneNumber", data[1][7]);
			boolean PhoneNumberField = accountProfileSetupPage.UpdateProfileFields("PhoneNumber", PhoneNumberValue);
			//Driver.Sleep(5);
			Helper.ShowTestResult("16.Verification of Phone Number Field", PhoneNumberField);
			DataManager.SaveTestResult("Verification of Phone Number Field.", PhoneNumberField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			//boolean FaxNumberField = ESTO_AccountProfileSetupPage.UpdateProfileFields ("FaxNumber", data[1][8]);
			boolean FaxNumberField = accountProfileSetupPage.UpdateProfileFields ("FaxNumber", FaxNumberValue);
			//Driver.Sleep(10);
			Helper.ShowTestResult("17.Verification of Fax Number Field", FaxNumberField);
			DataManager.SaveTestResult("Verification of Fax Number Field.", FaxNumberField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SubmitButton = accountProfileSetupPage.SubmitButton();
			//Driver.Sleep(20);
			Helper.ShowTestResult("18.Verification of Submit Button", SubmitButton);
			DataManager.SaveTestResult("Verification of Submit Button.", SubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			updateChangePasswordPage.VerifyCorrectPage();
			
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("Test Case of ESTO User Intial Update Profile Page function.", false);
			DataManager.SaveTestResult("Test Case of ESTO User Intial Update Profile Page function.", "Failed", "Test Execution Failed!");
		}	
	}

	
	
	@Test
	public void test3() 
	{
		try
		{
			System.out.print("\r\n** Test of ESTO User Initial Change Password Function.\r\n");
			System.out.println("==========================================================");
			//TestResult testResult = new TestResult();
			//testResult.setTestDate(new Date().toString());
			//testResult.setTestName("ESTO Review System_User Profile Setup Function");
			
//Verify Change Password
/*			
			updateChangePasswordPage.ClickSubmitButton();
			boolean FieldMsgCurrent = updateChangePasswordPage.CurrentPaswrdFieldMsg();
			//Driver.Sleep(3);
			Helper.ShowTestResult("19.Test of validation message for Current Passwrod Field.", FieldMsgCurrent);
			DataManager.SaveTestResult("Test of validation message for Current Passwrod Field.", FieldMsgCurrent? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean FieldNewPassword = updateChangePasswordPage.NewPaswrdFieldMsg();
			//Driver.Sleep(3);
			Helper.ShowTestResult("20.Test of validation message for New Password Field.", FieldNewPassword);
			DataManager.SaveTestResult("Test of validation message for New Password Field.", FieldNewPassword? "Passed" : "Failed", "Test Execution Completed Successfully!");
		*/		
			String CurrentPasswrod = "rev_qa";
			String NewPassword = "Test*12345";
			String ReEnterNewPswrd = "Test*12345";
			
			boolean ChangePaswrdField = updateChangePasswordPage.ChangePasswordFields("CurrentPassword", CurrentPasswrod);
			//Driver.Sleep(3);
			Helper.ShowTestResult("21.Test of validation message for New Password Field.", ChangePaswrdField);
			DataManager.SaveTestResult("Test of validation message for New Password Field.", ChangePaswrdField? "Passed" : "Failed", "Test Execution Completed Successfully!");
				
			boolean NewPasrdField = updateChangePasswordPage.ChangePasswordFields("NewPassword", NewPassword);
			//Driver.Sleep(3);
			Helper.ShowTestResult("22.Test of validation message for New Password Field.", NewPasrdField);
			DataManager.SaveTestResult("Test of validation message for New Password Field.", NewPasrdField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ReEnterPswrdField = updateChangePasswordPage.ChangePasswordFields("ReEnterNewPswrd", ReEnterNewPswrd);
			//Driver.Sleep(3);
			Helper.ShowTestResult("23.Test of validation message for New Password Field.", ReEnterPswrdField);
			DataManager.SaveTestResult("Test of validation message for New Password Field.", ReEnterPswrdField? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SubmitButton = updateChangePasswordPage.ClickSubmitButton();
			//Driver.Sleep(3);
			Helper.ShowTestResult("24.Verification of Submit Button", SubmitButton);
			DataManager.SaveTestResult("Verification of Submit Button.", SubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
			}
		catch (Exception ex)
		{
			Helper.ShowTestResult("Test Case of ESTO User Intial Update Profile Page function.", false);
			DataManager.SaveTestResult("Test Case of ESTO User Intial Update Profile Page function.", "Failed", "Test Execution Failed!");
		}	
	}	


	

	@Test
	public void test4() //Create Security Question
	{
		try
		{
			System.out.print("\r\n** Test of ESTO User Create Security Question Function.\r\n");
			System.out.println("==========================================================");
			//TestResult testResult = new TestResult();
			//testResult.setTestDate(new Date().toString());
			//testResult.setTestName("ESTO Review System_User Profile Setup Function");*/
		
			boolean PageDisplay = securityQuestionPage.CorrectPageDisplayValidation();
			//Driver.Sleep(3);
			Helper.ShowTestResult("24. Validation of Correct page display.", PageDisplay);
			DataManager.SaveTestResult("Validation of Correct page display.", PageDisplay? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			securityQuestionPage.ClickSubmitButton();
			boolean AnswerFieldValidation = securityQuestionPage.AnswerFieldValMsg();
			//Driver.Sleep(3);
			Helper.ShowTestResult("25.Test of validation message for Answer Field.", AnswerFieldValidation);
			DataManager.SaveTestResult("Test of validation message for Answer Field.", AnswerFieldValidation? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			String SecurityQuestion = "What was your childhood nickname?";
			String Answer = "Test ESTO ERS";
						
			boolean SelectSecutiryQ = securityQuestionPage.SelectSecurityQuestionDD(SecurityQuestion);
			//Driver.Sleep(3);
			Helper.ShowTestResult("26. Validation Security Question selection.", SelectSecutiryQ);
			DataManager.SaveTestResult("Validation Security Question selection.", SelectSecutiryQ? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean EnterAnswer = securityQuestionPage.AnswerField(Answer);
			//Driver.Sleep(3);
			Helper.ShowTestResult("27.Test of validation message for Answer Field.", EnterAnswer);
			DataManager.SaveTestResult("Test of validation message for Answer Field.", EnterAnswer? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
			boolean SubmitButton = securityQuestionPage.ClickSubmitButton();
			//Driver.Sleep(3);
			Helper.ShowTestResult("28.Test of Submit button function.", SubmitButton);
			DataManager.SaveTestResult("TTest of Submit button function.", SubmitButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("Test Case of ESTO User Create Security Question Page function.", false);
			DataManager.SaveTestResult("Test Case of ESTO User Create Security Question Page function.", "Failed", "Test Execution Failed!");
	}	
	} 
	

	
	@Test
	public void test5() // Non-Disclosure Agreement 
	{
		try
		{
			System.out.print("\r\n** Test of ESTO User Non Disclosure Aggrement Function.\r\n");
			System.out.println("==========================================================");
			//TestResult testResult = new TestResult();
			//testResult.setTestDate(new Date().toString());
			//testResult.setTestName("ESTO Review System_User Profile Setup Function");
	
/*			boolean SelSolicitation = nonDisclosureAgreementPage.SelectSoliciation();
			//Driver.Sleep(3);
			Helper.ShowTestResult("29.Test of Solicitation Switch function.", SelSolicitation);
			DataManager.SaveTestResult("Test of Solicitation Switch function.", SelSolicitation? "Passed" : "Failed", "Test Execution Completed Successfully!");
		
	*/		boolean VeificationPageDisplay = nonDisclosureAgreementPage.PageDisplayVerification();
			//Driver.Sleep(2);
			Helper.ShowTestResult("30. Verification of correct page display.", VeificationPageDisplay);
			DataManager.SaveTestResult("Verification of correct page display.", VeificationPageDisplay? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean ContinueButton = nonDisclosureAgreementPage.ClickContinue();
			//Driver.Sleep(2);
			Helper.ShowTestResult("31. Verification of Click Button.", ContinueButton);
			DataManager.SaveTestResult("Verification of correct page display.", ContinueButton? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SelectUSCitizen = nonDisclosureAgreementPage.SelectYesUSCitizen();
			//Driver.Sleep(2);
			Helper.ShowTestResult("32. Verification of US Citizen Yes/No button.", SelectUSCitizen);
			DataManager.SaveTestResult("Verification of US Citizen Yes/No button.", SelectUSCitizen? "Passed" : "Failed", "Test Execution Completed Successfully!");
			
			boolean SelectCivilServant = nonDisclosureAgreementPage.SelectYesCiviServant();
			//Driver.Sleep(2);
			Helper.ShowTestResult("33. Verification of Civil Servant Yes/No button.", SelectCivilServant);
			DataManager.SaveTestResult("Verification of Civil Servant Yes/No button.", SelectCivilServant? "Passed" : "Failed", "Test Execution Completed Successfully!");

			String Password = "rev_qa";
			boolean EnterPassword = nonDisclosureAgreementPage.EnterPasswoed(Password);
			//Driver.Sleep(2);
			Helper.ShowTestResult("34. Verification of Password field.", EnterPassword);
			DataManager.SaveTestResult("Verification of Password field.", EnterPassword? "Passed" : "Failed", "Test Execution Completed Successfully!");
						
			boolean ClickAccept = nonDisclosureAgreementPage.ClickIAccept();
			//Driver.Sleep(2);
			Helper.ShowTestResult("35. Verification of Accept button.", ClickAccept);
			DataManager.SaveTestResult("Verification of Accept button.", ClickAccept? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean CloseNDA = nonDisclosureAgreementPage.CloseNDAPopUpBox();
			//Driver.Sleep(2);
			Helper.ShowTestResult("36. Verification of Closing the box.", CloseNDA);
			DataManager.SaveTestResult("Verification of Closing the box.", CloseNDA? "Passed" : "Failed", "Test Execution Completed Successfully!");

			boolean VerifyPageDisplay = nonDisclosureAgreementPage.VerifyCorrectPage();
			//Driver.Sleep(2);
			Helper.ShowTestResult("36. Verification of user navigate to correct page.", VerifyPageDisplay);
			DataManager.SaveTestResult("Verification of user navigate to correct page.", VerifyPageDisplay? "Passed" : "Failed", "Test Execution Completed Successfully!");

		
		}
		catch (Exception ex)
		{
			Helper.ShowTestResult("Test Case of ESTO User Non Disclosure Aggrement function.", false);
			DataManager.SaveTestResult("Test Case of ESTO User Non Disclosure Aggrement function.", "Failed", "Test Execution Failed!");
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
//		Driver.TearDown();

		DataManager.ExportToExcel(TestResultList.ExternalTestSuit, "ESTO User Intial Accont Setup.", "Intial Account setup");
		//Driver.Sleep(3);

		Helper.ShowTestResult("* Browser close", true);
		}
					

}
