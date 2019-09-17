package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;
import gov.ebooks.selenium.shared.utils.ConfigManager;

public class CommonMethodsESTOReviewPages extends BasePage
{
	public  CommonMethodsESTOReviewPages(WebDriver driver){
		super(driver, "CommonMethodsESTOReviewPages", "ESTO");
	}
	
	private String SearchForProposalNumber = "17-ACT17-0031";
	
	//Search by Proposal Numebr 
	public boolean SearchByProposalNumber () //(String SearchProposalNumber)
	{
		try
		{
			sleep(10);
			WebElement SearchBy = driver.findElement(By.xpath("//*[@id=\'search-field-wrapper\']/input"));
			SearchBy.sendKeys(Keys.CONTROL +"a");
			SearchBy.sendKeys(Keys.DELETE);
	//		SearchBy.sendKeys("17-ACT17-0036");
			SearchBy.sendKeys(SearchForProposalNumber);
			//SearchBy.sendKeys(SearchProposalNumber);
			sleep (10);
			return true;
		}
		catch (Exception ex)
		{
		return false;
		}
	}
	
	
	//Manage Proposals Page - search by Proposal Number
	public boolean SearchManageProposalByPropNumber () // (String FieldValue)
	{
		try
		{
			sleep(6);
			
			WebElement ProposalNumber = driver.findElement(By.xpath("//input[@ng-model='search']"));
			ProposalNumber.sendKeys(Keys.CONTROL + "a");
			ProposalNumber.sendKeys(Keys.DELETE);
			ProposalNumber.sendKeys(SearchForProposalNumber);
			sleep(5);
			//ProposalNumber.sendKeys(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean AppliedScienceERS()
		{
			driver.get(ConfigManager.AppliedScienceERS());
			sleep(3);
			return true;
		}

		public boolean ESTOERS()
		{
			driver.get(ConfigManager.ESTOERS());
			sleep(3);
			return true;
		}

		public boolean ESTOReview()
		{
			driver.get(ConfigManager.ESTOReview());
			sleep(3);
			return true;
		}
		
		public boolean HECeBooks()
		{
			driver.get(ConfigManager.HECeBooks());
			sleep(3);
			return true;
		}

		public boolean ARTOERS()
		{
			driver.get(ConfigManager.ARTOERS());
			sleep(3);
			return true;
		}
		
		public boolean PlanetrayERS()
		{
			try
			{
				driver.get(ConfigManager.PlanetaryERS());
				sleep(3);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}


		public boolean ESTOLogin (String UserName, String Password)
		{
//			driver.findElement(By.tagName("username")).sendKeys(UserName);
//			driver.findElement(By.tagName("password")).sendKeys(Password);
//			

			driver.findElement(By.xpath("//*[@id=\'login-form\']/input[1]")).sendKeys(UserName);;
			driver.findElement(By.xpath("//*[@id='login-form']/input[2]")).sendKeys(Password);
			sleep(2);
			driver.findElement(By.id("disclaimerChkBx")).click();
			driver.findElement(By.className("login")).click();		
			return true;
		}

		
		public boolean EstoReviewEvalutionLogout ()
		{
			try
			{
				sleep(5);
				driver.findElement(By.xpath("//a[@ng-href='/review/logoutSystemUser']")).click();
				
				//driver.getInstance().findElement(By.xpath("//span[@id='my-account-dropdown']//a[@ng-href='/review/logoutSystemUser']")).click();
				
				//driver.findElement(By.id("my-account-dropdown")).click();
				//sleep(3);
				//driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[6]/a")).click();
				sleep(6);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
			
		} 
		
		
		public boolean ESTOLogout ()
		{
			driver.findElement(By.id("my-account-dropdown")).findElement(By.linkText("/review/logoutSystemUser")).click();
			return true;
		}
		
		
		public boolean SelectACT16Solicitation ()
		{
			try
			{
				driver.findElement(By.id("AIST-16")).click();
				sleep(3);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		public boolean SelectACT17Solicitation ()
		{
			try
			{
				sleep(3);
				driver.findElement(By.id("ACT-17")).click();
				sleep (3);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		public boolean ClickSelectSolicitationButton ()
		{
			try
			{
				driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/form/div/input")).click();
				sleep(5);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}


		
		public boolean NavToManageNotifications () throws InterruptedException
		{
			try
			{
				sleep(20);
				WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
				Actions action = new Actions(driver);
				action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/ul/li[5]/a"))).click().build().perform();
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
				

		//Close popup Box
		public boolean ClosePopUp ()
		{
			try
			{
				driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[1]/div[2]/span")).click();
				sleep (5);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		


		
		//Manage Proposals Stages Page - search by Proposal Number
		public boolean SearchByPropNumberInProposalStage () //(String FieldValue)
		{
			try
			{
				WebElement ProposalNumber = driver.findElement(By.xpath("//input[@ng-model='search']"));
				ProposalNumber.sendKeys(Keys.CONTROL + "a");
				ProposalNumber.sendKeys(Keys.DELETE);
				ProposalNumber.sendKeys(SearchForProposalNumber);
				//ProposalNumber.sendKeys(FieldValue);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		//Expand of proposal / Clicking toggle
		public boolean ClickExpanArrow () 
		{
			try
			{
				sleep(2);
				driver.findElement(By.xpath("//span[@title='Toggle View']")).click();
				//driver.findElement(By.className("proposal-arrow-show")).click();
				sleep (4);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		//Filter By Icon
		public boolean NavOfSearchIcon ()
		{
			try
			{
				sleep (10);
				driver.findElement(By.xpath("//*[@id=\'search-field-wrapper\']/a/span")).click();
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		//Search Filter __ Sort By Proposal Number 
		public boolean FunctionSearchFilter ()
		{
			try
			{
				WebElement SelectVisible = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/ul/li[1]/div[2]/select"));
				SelectVisible.click();
				Select DDselection = new Select (SelectVisible);
				DDselection.selectByVisibleText("Proposal Number");
				sleep (3);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		//Filter by Confirm button
		public boolean ClickConfirmButton ()
		{
			try
			{
				driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/ul/div/button[1]")).click();
				sleep (5);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		//Select Manage User from left menu
		public boolean selectManageUsers() throws InterruptedException
		{
			try
			{
				WebElement manageUsers = findElement("manage_users_navigationbar");
				manageUsers.click();
			    sleep (3);
			    return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		//Select Manage Proposal from left menu (Option 2)
		public boolean SelectManageProposalFromLeft ()
		{
			try
			{
				driver.findElement(By.xpath("//*[@id=\'admin-navigation\']/ul/li[1]/a")).click();
				sleep(5);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}

		}
		
		
		//Select Proposal Stage from left menu	
	public void selectProposalStage() throws InterruptedException{
		WebElement manageProposalStage = findElement("manage_proposal_stage_navigator");
		manageProposalStage.click();
			Thread.sleep(5000);
	} 
	
	
	 
	
	//Select Proposal Stage from left menu
	public void selectManageProposal() throws InterruptedException{
		WebElement manageProposal = findElement("manage_proposal_navigator");
		manageProposal.click();
			Thread.sleep(5000);
	} 
	
	//Select Proposal Stage from left menu (Option2)
	public boolean SelectProposalStageFromLeft ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-navigation\']/ul/li[4]/a")).click();
			sleep(5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}

	}

	
	
	
	
		
// ***** If data is refreshed and user's ERS Dashboard Configuration set up need to complete before user can proceed. Following script will run to complete the user's account setup.
		public boolean ERSCofigurationStepOneAndTwo ()
		{
			
			//Step One ERS Overview
			//Step One
			driver.findElement(By.xpath("//*[@id=\'globalContent\']/div/form/ul[2]/li[2]")).click();

			//Step Two User Profile
			//Step Two - Phone
			WebElement PhoneField = driver.findElement(By.id("inputPhone"));
			PhoneField.sendKeys(Keys.CONTROL + "a");
			PhoneField.sendKeys(Keys.DELETE);
			PhoneField.sendKeys("7031231234");
			//Step Two - Email
			WebElement EmailField = driver.findElement(By.id("inputEmail"));
			EmailField.sendKeys(Keys.CONTROL + "a");
			EmailField.sendKeys(Keys.DELETE);
			EmailField.sendKeys("rashika.shrestha@reisystems.com");
			//Step Two - Address 1
			WebElement StreetField = driver.findElement(By.id("inputStreet"));
			StreetField.sendKeys(Keys.CONTROL + "a");
			StreetField.sendKeys(Keys.DELETE);
			StreetField.sendKeys("123 Abc Street");
			//Step Two - Address City
			WebElement CityField = driver.findElement(By.id("inputCity"));
			CityField.sendKeys(Keys.CONTROL + "a");
			CityField.sendKeys(Keys.DELETE);
			CityField.sendKeys("xxx");
			//Step Two - State Dropdown
			WebElement StateDD = driver.findElement(By.id("stateSelect"));
			StateDD.click();
			sleep(2);
			Select DropDownState = new Select (StateDD);
			DropDownState.selectByVisibleText("Virginia");
			//Step Two - Address Country Field
			WebElement CountryField = driver.findElement(By.id("inputCountry"));
			CountryField.sendKeys(Keys.CONTROL + "a");
			CountryField.sendKeys(Keys.DELETE);
			CountryField.sendKeys("United State");
			//Step Two - Zip Code Field
			WebElement ZipField = driver.findElement(By.id("inputZip"));
			ZipField.sendKeys(Keys.CONTROL + "a");
			ZipField.sendKeys(Keys.DELETE);
			ZipField.sendKeys("20186");
			//Step Two - Organization Field
			WebElement OrganizationFiled = driver.findElement(By.id("inputOrganization"));
			OrganizationFiled.sendKeys(Keys.CONTROL + "a");
			OrganizationFiled.sendKeys(Keys.DELETE);
			OrganizationFiled.sendKeys("uclr");
		
			//Step Three Security Question 
			//Select Question 1
			WebElement QFavoritePet  = driver.findElement(By.id("securityQuestionForm")).findElement(By.id("securityQuestion_question_0"));
			QFavoritePet.click();
			sleep(3);
			Select dropdownQ1 = new Select (QFavoritePet);
			dropdownQ1.selectByVisibleText("What is the name of your favorite pet?");
			//Answer Question 1
			WebElement AFavoritePet = driver.findElement(By.id("securityQuestion_answer_0"));
			AFavoritePet.sendKeys(Keys.CONTROL + "a");
			AFavoritePet.sendKeys(Keys.DELETE);
			AFavoritePet.sendKeys("Dog");
			//Select Question2 
			WebElement QFirstCar  = driver.findElement(By.id("securityQuestionForm")).findElement(By.id("securityQuestion_question_1"));
			QFirstCar.click();
			sleep(3);
			Select dropdownQ2 = new Select (QFirstCar);
			dropdownQ2.selectByVisibleText("What was the make and model of your first car?");
			//Answer Question 2
			WebElement AFirstCar = driver.findElement(By.id("securityQuestion_answer_1"));
			AFirstCar.sendKeys(Keys.CONTROL + "a");
			AFirstCar.sendKeys(Keys.DELETE);
			AFirstCar.sendKeys("Toyota");

			//Step Four Change Password
			//Old Password
		    WebElement OldPassword = driver.findElement(By.id("password"));
			OldPassword.sendKeys(Keys.CONTROL + "a");
			OldPassword.sendKeys(Keys.DELETE);
			OldPassword.sendKeys("ers_qa");
			//New Password
			WebElement NewPassword = driver.findElement (By.id("newPassword"));
			NewPassword.sendKeys(Keys.CONTROL + "a");
			NewPassword.sendKeys(Keys.DELETE);
			NewPassword.sendKeys("Test*12345678");
			//Retype New Password
			WebElement ReTypNewPawrd = driver.findElement(By.id("retypeNewPassword"));
			ReTypNewPawrd.sendKeys(Keys.CONTROL + "a");
			ReTypNewPawrd.sendKeys(Keys.DELETE);
			ReTypNewPawrd.sendKeys("Test*12345678");			
			
			//Click Finish
			driver.findElement(By.xpath("//*[@id=\'globalContent\']/div/form/ul[2]/li[3]")).click();
			sleep(3);
			
			return true;
		}

}

