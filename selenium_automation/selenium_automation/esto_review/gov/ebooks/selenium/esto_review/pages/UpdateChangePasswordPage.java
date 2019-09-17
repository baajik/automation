package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import gov.ebooks.selenium.shared.pages.BasePage;

public class UpdateChangePasswordPage extends BasePage
{
	
	public UpdateChangePasswordPage(WebDriver driver){
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
	

	public boolean ClickSubmitButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/div/input")).click();
			sleep(30);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
		
	
		public boolean CurrentPaswrdFieldMsg ()
		{
			try
			{
				WebElement VerCurrentPasswrdMsg = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[1]/div[2]/div[2]/div[1]"));
				String ActualFieldCurrentPaswrd = VerCurrentPasswrdMsg.getText();
				String ExpetedPasswordValidation = ("Password is required");
				System.out.println("Actual Message =" + ActualFieldCurrentPaswrd);
				System.out.println("Expected Message = " + ExpetedPasswordValidation );
				//Assert.assertEquals(ExpetedPasswordValidation, ActualFieldCurrentPaswrd);
				if(!ActualFieldCurrentPaswrd.matches(ExpetedPasswordValidation));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		
		public boolean NewPaswrdFieldMsg ()
		{
			try
			{
				WebElement VerNewPaswrdMsg = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[2]/div[2]/div[2]/div[1]"));
				String ActualFieldNewPaswrd = VerNewPaswrdMsg.getText();
				System.out.println("Actual Message =" + ActualFieldNewPaswrd);
				String ExpetedNewPasswordVal = ("New Password is required");
				System.out.println("Expected Message = " + ExpetedNewPasswordVal );
				//Assert.assertEquals(ExpetedNewPasswordVal, ActualFieldNewPaswrd);
				if(!ExpetedNewPasswordVal.matches(ActualFieldNewPaswrd));
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
	
		}
		
		
	
		public boolean ChangePasswordFields (String FieldName, String FieldValue)
		{
			try
			{
				switch (FieldName)
				{
				case "CurrentPassword":
					WebElement OldPassword = driver.findElement(By.name("currentPassword"));
					OldPassword.sendKeys(Keys.CONTROL + "a");
					OldPassword.sendKeys(Keys.DELETE);
					OldPassword.sendKeys(FieldValue);
					break;
					
				case "NewPassword":
					WebElement NewPassword = driver.findElement (By.name("newPassword"));
					NewPassword.sendKeys(Keys.CONTROL + "a");
					NewPassword.sendKeys(Keys.DELETE);
					NewPassword.sendKeys(FieldValue);
					break;
					
				case "ReEnterNewPswrd":
					WebElement ReTypNewPawrd = driver.findElement(By.name("newPassword2"));
					ReTypNewPawrd.sendKeys(Keys.CONTROL + "a");
					ReTypNewPawrd.sendKeys(Keys.DELETE);
					ReTypNewPawrd.sendKeys(FieldValue);
					sleep (2);
				}
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		

		
		
// **  Voluntary change of Security Question
		
		public boolean MyAccountToSelChangePaswrd ()
		{
			//Navigate to Security Question
			driver.findElement(By.id("my-account-dropdown")).click();
			sleep(3);
			driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[1]/a")).click();
			return true;
		}
		

						
		public boolean EnterCurrentPassword ()
		{
			try
			{
				WebElement CurrPaswrd = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[1]/div[2]/div[1]/input"));
				CurrPaswrd.sendKeys(Keys.CONTROL + "a");
				CurrPaswrd.sendKeys(Keys.DELETE);
				CurrPaswrd.sendKeys("rev_qa");
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}

		
		public boolean NewPassword ()
		{
			try
			{
				WebElement CurrPaswrd = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[2]/div[2]/div[1]/input"));
				CurrPaswrd.sendKeys(Keys.CONTROL + "a");
				CurrPaswrd.sendKeys(Keys.DELETE);
				CurrPaswrd.sendKeys("Test*12345");
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
		public boolean ReEnterPassword ()
		{
			try
			{
				WebElement CurrPaswrd = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[3]/div[2]/div[1]/input"));
				CurrPaswrd.sendKeys(Keys.CONTROL + "a");
				CurrPaswrd.sendKeys(Keys.DELETE);
				CurrPaswrd.sendKeys("Test*12345");
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		
				
		public boolean ClosePopup ()
		{
			try
			{
				wait(3);
				driver.findElement(By.xpath("/html/body/div[8]/div[1]/div/a[2]/span")).click();
				return true;
				}
				catch (Exception ex)
				{
					return false;
				}
		}
		
// ** Voluntary change of Password	
	
		public boolean NavToSecurityQuestions ()
		{
			try
			{
				//Navigate to Security Question
				driver.findElement(By.id("my-account-dropdown")).click();
				sleep(3);
				driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[1]/a")).click();
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}


		
		public boolean VerifyCorrectPage()
		{
			try
			{
				WebElement VerPage = driver.findElement(By.xpath("//*[@id=\'main\']/form/h1"));
				String VerifyCorrectPage = VerPage.getText();
				if(!VerifyCorrectPage.matches("Update / Change Password"));		
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
				WebElement SucessMsg = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/h4"));
				String ActualSuccessMsg = SucessMsg.getText();
				String ExpetedSuccessMsg = ("Your password was successfully changed");
				System.out.println("Actual Message =" + ActualSuccessMsg);
				System.out.println("Expected Message = " + ExpetedSuccessMsg );
				//Assert.assertEquals(ExpetedNewPasswordVal, ActualFieldNewPaswrd);
				if(!ExpetedSuccessMsg.matches(ActualSuccessMsg));
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

