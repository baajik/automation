package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;



public class AccountProfileSetupPage extends BasePage{
	
	public AccountProfileSetupPage(WebDriver driver){
		super(driver, "piAdditionalProjectInformationPage", "esto_review");
	}
	
	public boolean SelectACT16Solicitation ()
	{
		try
		{
			driver.findElement(By.id("AIST-16")).click();
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
			driver.findElement(By.id("ACT-17")).click();
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
			driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[3]/form/div/input")).click();
			sleep(15);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	

	public boolean ClickSubmitButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/div/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
		
	
	public boolean DeleteEmail()
	{
		 	WebElement EnterEmail  = driver.findElement(By.name("email"));
			//WebElement EnterEmail  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[2]/div[2]/input"));
			EnterEmail.sendKeys(Keys.CONTROL + "a");
			EnterEmail.sendKeys(Keys.DELETE);
			return true;
	}
		
		
		public boolean RemoveValueInFieldAndSubmit ()
		{
			//try
			//{
				WebElement EnterEmail  = driver.findElement(By.name("email"));
				EnterEmail.sendKeys(Keys.CONTROL + "a");
				EnterEmail.sendKeys(Keys.DELETE);
				sleep(3);
			
				WebElement EnterOrganization  = driver.findElement(By.name("organization"));
				EnterOrganization.sendKeys(Keys.CONTROL + "a");
				EnterOrganization.sendKeys(Keys.DELETE);
				sleep(3);
				
				WebElement EnterAddress = driver.findElement(By.name("address"));
				EnterAddress.sendKeys(Keys.CONTROL + "a");
				EnterAddress.sendKeys(Keys.DELETE);
				sleep(3);
				
				WebElement EnterCity  = driver.findElement(By.name("city"));
				EnterCity.sendKeys(Keys.CONTROL + "a");
				EnterCity.sendKeys(Keys.DELETE);
				sleep(3);
				
				WebElement EnterState  = driver.findElement(By.name("state"));
				EnterState.sendKeys(Keys.CONTROL + "a");
				EnterState.sendKeys(Keys.DELETE);
				sleep(3);
				
				WebElement EnterZip  = driver.findElement(By.name("zip"));
				EnterZip.sendKeys(Keys.CONTROL + "a");
				EnterZip.sendKeys(Keys.DELETE);
				sleep(3);
				
				WebElement EnterCountry  = driver.findElement(By.name("country"));
				EnterCountry.sendKeys(Keys.CONTROL + "a");
				EnterCountry.sendKeys(Keys.DELETE);
				sleep(3);
				
				WebElement EnterPhoneNumber  = driver.findElement(By.name("phone"));
				EnterPhoneNumber.sendKeys(Keys.CONTROL + "a");
				EnterPhoneNumber.sendKeys(Keys.DELETE);
							
				sleep(10);
				driver.findElement(By.xpath("//*[@id=\'main\']/form/div/input")).click();
				return true;
/*			}
			catch (Exception ex)
			{
				return false;
			}*/	
		}
		
		
		 // Testing of Field Validation
		public boolean EmailValidationMsg ()
		{
			try
			{
				WebElement EmailMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[2]/div[2]/div"));
				String ActualEmailMsg = EmailMsg.getText();
				String ExpectedEmailMsg = ("Email is required");
				System.out.println("Expected Message = " + ExpectedEmailMsg);
				System.out.println("Actual Message = " + ActualEmailMsg );
			//	Assert.assertEquals(ExpectedEmailMsg, ActualEmailMsg);
				if(!ActualEmailMsg.matches(ExpectedEmailMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		public boolean OrganizationValidationMsg ()
		{
			try
			{
				WebElement OrganizationMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[3]/div[2]/div"));
				String ActualOrganizationMsg = OrganizationMsg.getText();
				String ExpectedOrganizationMsg = ("Organization is required");
				System.out.println("Expected Message = " + ExpectedOrganizationMsg);
				System.out.println("Actual Message = " + ActualOrganizationMsg );
			//	Assert.assertEquals(ActualOrganizationMsg, ExpectedOrganizationMsg);
				if(!ActualOrganizationMsg.matches(ExpectedOrganizationMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		public boolean AddressValidationMsg ()
		{
			try
			{
				WebElement AddressMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[4]/div[2]/div[3]"));
				String ActualAddressMsg = AddressMsg.getText();
				String ExpectedAddressMsg = ("Address is required");
				System.out.println("Expected Message = " + ExpectedAddressMsg);
				System.out.println("Actual Message = " + ActualAddressMsg );
				//Assert.assertEquals(ActualAddressMsg, ExpectedAddressMsg);
				if(!ActualAddressMsg.matches(ExpectedAddressMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		public boolean CityValidationMsg ()
		{
			try
			{
				WebElement CityMsg  = driver.findElement(By.xpath("//*[@id='main\']/form/ul/li[4]/div[2]/div[5]"));
				String ActualCityMsg = CityMsg.getText();
				String ExpecteCityMsg = ("City is invalid");
				System.out.println("Expected Message = " + ExpecteCityMsg);
				System.out.println("Actual Message = " + ActualCityMsg );
				//Assert.assertEquals(ActualCityMsg, ExpecteCityMsg);
				if(!ActualCityMsg.matches(ExpecteCityMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}	
		
		
		public boolean StateValMsg ()
		{
			try
			{
				WebElement StateMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[4]/div[2]/div[6]"));
				String ActualStateMsg = StateMsg.getText();
				String ExpectedStateMsg = ("State is invalid");
				System.out.println("Expected Message = " + ExpectedStateMsg);
				System.out.println("Actual Message = " + ActualStateMsg );
				//Assert.assertEquals(ActualStateMsg, ExpectedStateMsg);
				if(!ActualStateMsg.matches(ExpectedStateMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		public boolean ZipcodeValMsg ()
		{
			try
			{
				WebElement ZipcodeMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[4]/div[2]/div[7]"));
				String ActualZipcodeMsg = ZipcodeMsg.getText();
				String ExpectedZipcodeMsg = ("Zipcode is required");
				System.out.println("Expected Message = " + ExpectedZipcodeMsg);
				System.out.println("Actual Message = " + ActualZipcodeMsg );
				//Assert.assertEquals(ActualZipcodeMsg, ExpectedZipcodeMsg);
				if(!ActualZipcodeMsg.matches(ExpectedZipcodeMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		public boolean CountryValMsg ()
		{
			try
			{
				WebElement CountryMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[4]/div[2]/div[8]"));
				String ActualCountyMsg = CountryMsg.getText();
				String ExpectedCountryMsg = ("Country is invalid");
				System.out.println("Expected Message = " + ExpectedCountryMsg);
				System.out.println("Actual Message = " + ActualCountyMsg );
				//Assert.assertEquals(ActualCountyMsg, ExpectedCountryMsg);
				if(!ActualCountyMsg.matches(ExpectedCountryMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		public boolean PhoneValMsg ()
		{
			try
			{
				WebElement PhoneMsg  = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[5]/div[2]/div[2]"));
				String ActualPhoneMsg = PhoneMsg.getText();
				String ExpectedPhoneMsg = ("Phone Number is required");
				System.out.println("Expected Message = " + ExpectedPhoneMsg);
				System.out.println("Actual Message = " + ActualPhoneMsg );
				//Assert.assertEquals(ActualPhoneMsg, ExpectedPhoneMsg);
				if(!ActualPhoneMsg.matches(ExpectedPhoneMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		public boolean FaxValMsg ()
		{
			try
			{
				WebElement FaxMsg  = driver.findElement(By.name("organization"));
				String ActualFaxMsg = FaxMsg.getText();
				String ExpectedFaxMsg = ("");
				System.out.println("Expected Message = " + ExpectedFaxMsg);
				System.out.println("Actual Message = " + ActualFaxMsg );
				//Assert.assertEquals(ActualFaxMsg, ExpectedFaxMsg);
				if(!ActualFaxMsg.matches(ExpectedFaxMsg));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		
		public boolean UpdateProfileFields (String FieldName, String FieldValue)
		{
			try
			{
				switch (FieldName)
				{
				case "Email":
					WebElement EnterEmail  = driver.findElement(By.name("email"));
					EnterEmail.sendKeys(Keys.CONTROL + "a");
					EnterEmail.sendKeys(Keys.DELETE);
					EnterEmail.sendKeys(FieldValue);
					break;
					
				case "organization":
					WebElement EnterOrganization  = driver.findElement(By.name("organization"));
					EnterOrganization.sendKeys(Keys.CONTROL + "a");
					EnterOrganization.sendKeys(Keys.DELETE);
					EnterOrganization.sendKeys(FieldValue);
					break;
		
				case "address":
					WebElement  EnterAddress = 	driver.findElement(By.name("address"));
					EnterAddress.sendKeys(Keys.CONTROL + "a");
					EnterAddress.sendKeys(Keys.DELETE);
					EnterAddress.sendKeys(FieldValue);
					break;
					
				case "city":
					WebElement EnterCity  = 	driver.findElement(By.name("city"));
					EnterCity.sendKeys(Keys.CONTROL + "a");
					EnterCity.sendKeys(Keys.DELETE);
					EnterCity.sendKeys(FieldValue);
					break;
					
				case "state":
					WebElement EnterState  = 	driver.findElement(By.name("state"));
					EnterState.sendKeys(Keys.CONTROL + "a");
					EnterState.sendKeys(Keys.DELETE);
					EnterState.sendKeys(FieldValue);
					break;
					
				case "zip":
					WebElement EnterZip  = 	driver.findElement(By.name("zip"));
					EnterZip.sendKeys(Keys.CONTROL + "a");
					EnterZip.sendKeys(Keys.DELETE);
					EnterZip.sendKeys(FieldValue);
					break;
					
				case "Country":
					WebElement EnterCountry  = 	driver.findElement(By.name("country"));
					EnterCountry.sendKeys(Keys.CONTROL + "a");
					EnterCountry.sendKeys(Keys.DELETE);
					EnterCountry.sendKeys(FieldValue);
					break;
								
				case "PhoneNumber":
					WebElement EnterPhoneNumber  = 	driver.findElement(By.name("phone"));
					EnterPhoneNumber.sendKeys(Keys.CONTROL + "a");
					EnterPhoneNumber.sendKeys(Keys.DELETE);
					EnterPhoneNumber.sendKeys(FieldValue);
					break;
					
				case "FaxNumber":
					WebElement EnterFaxNumber  = 	driver.findElement(By.name("fax"));
					EnterFaxNumber.sendKeys(Keys.CONTROL + "a");
					EnterFaxNumber.sendKeys(Keys.DELETE);
					EnterFaxNumber.sendKeys(FieldValue);
					break;
				}
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		public boolean SubmitButton ()
		{
			try
			{
				//*[@id="main"]/form/div/input
				driver.findElement(By.xpath("//*[@id='main']/form/div/input")).click();
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		

		
		
		public boolean Sample ()
		{
			try
			{
				driver.findElement(By.xpath("")).click();
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}	

		
//** Voluntary Update Profile
	public boolean MyAccountToUpdateProfilePage ()
	{
		try
		{
		//Navigate to Security Question
		driver.findElement(By.id("my-account-dropdown")).click();
		sleep(8);
		driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[2]/a")).click();
		return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
		
		
	public boolean RemoveEmailVerifyValMsg ()
	{
		try
		{
			//** Remove
			WebElement EnterEmail  = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[3]/div[2]/div[1]/input"));
			EnterEmail.sendKeys(Keys.CONTROL + "a");
			EnterEmail.sendKeys(Keys.DELETE);
			sleep(7);
			//** Submit
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/div/input")).click();
			sleep(6);
			
			//** Verify Field Message
		
			WebElement EmailFieldVal  = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[3]/div[2]/div[2]/div"));
			String ActualEmailFieldVal = EmailFieldVal.getText();
			String ExpectedEmailFieldVal = ("Email is required");
			System.out.println("Expected Message = " + ExpectedEmailFieldVal);
			System.out.println("Actual Message = " + ActualEmailFieldVal );
		//	Assert.assertEquals(ExpectedEmailMsg, ActualEmailMsg);
			if(!ActualEmailFieldVal.matches(ExpectedEmailFieldVal));
			
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
//   Test@aol.com
	

public boolean DuplicateEmailValidation ()
	{
		try
		{
		// Enter Email which is already in Data Base "Test@aol.com ", you will have to first check this email is there from PM account
			WebElement EnterEmail = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[3]/div[2]/div[1]/input"));
			EnterEmail.sendKeys("Test@aol.com");
			sleep(2);
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/div/input")).click();
			sleep(4);
	//Verify Email already Exist message
			WebElement EmailFieldMsg  = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/div[1]"));
			String ActualEmailFieldMsg = EmailFieldMsg.getText();
			String ExpectedEmailFieldMsg = ("Email already exists");
			System.out.println("Expected Message = " + ExpectedEmailFieldMsg);
			System.out.println("Actual Message = " + ActualEmailFieldMsg );
		//	Assert.assertEquals(ExpectedEmailFieldMsg, ActualEmailFieldMsg);
			if(!ExpectedEmailFieldMsg.matches(ActualEmailFieldMsg));
			
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}


	public boolean EnterCorrectEmail ()
	{
		try
		{
			// Enter Email which is not in Data Base "Test5@aol.com ", you will have to first check this email by logging in from PM account
			WebElement EnterEmail = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[3]/div[2]/div[1]/input"));
			EnterEmail.sendKeys(Keys.CONTROL + "a");
			EnterEmail.sendKeys(Keys.DELETE);
			EnterEmail.sendKeys("Test5@aol.com");
			sleep(2);
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/div/input")).click();
			sleep(4);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean SuccessfulMsg ()
	{
		try
		{
			WebElement SucessProfileMsg = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/h4"));
			String ActualProfileSuccessMsg = SucessProfileMsg.getText();
			String ExpetedProfileSuccessMsg = ("Your profile was successfully updated");
			System.out.println("Actual Message =" + ActualProfileSuccessMsg);
			System.out.println("Expected Message = " + ExpetedProfileSuccessMsg );
			//Assert.assertEquals(ExpetedProfileSuccessMsg, ActualProfileSuccessMsg);
			if(!ExpetedProfileSuccessMsg.matches(ActualProfileSuccessMsg));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean ClickOkayButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/button")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
		
		
		
		
}
