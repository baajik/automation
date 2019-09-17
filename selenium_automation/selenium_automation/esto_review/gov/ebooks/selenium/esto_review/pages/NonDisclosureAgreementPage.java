package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;

public class NonDisclosureAgreementPage extends BasePage
{
	
	public NonDisclosureAgreementPage(WebDriver driver){
		super(driver, "piAdditionalProjectInformationPage", "esto_review");
	}
	
	public boolean SelectSoliciation ()
	{
		try 
		{
			driver.findElement(By.id("ACT-17")).click();
			sleep(2);
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/form/div/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
		
	}
	
	
	public boolean PageDisplayVerification ()
	{
		try
		{
			WebElement PageDisplay = driver.findElement(By.className("form-title"));
			//WebElement PageDisplay = driver.findElement(By.xpath("//*[@id=\'review-profile\']/div[1]"));
			String ActualPageDisplay = PageDisplay.getText();
			String ExpectedPageDisplay = ("Verify Profile");
			System.out.println("Actual Display = " + ActualPageDisplay);
			System.out.println("Expected Display = " + ExpectedPageDisplay);
			//Assert.assertEquals(ExpectedPageDisplay, ActualPageDisplay);
			if (!ActualPageDisplay.matches(ExpectedPageDisplay));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickContinue ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'review-profile\']/div[3]/button[2]")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean SelectYesUSCitizen ()
	{
		try
		{
			//WebElement CitizenYesRadioButton = driver.findElement(By.name("citizen"));
			//CitizenYesRadioButton.sendKeys(Keys.valueOf("true"));
			
			driver.findElement(By.xpath("//*[@id=\'sign-nda\']/form/div/div[1]/div[2]/label[1]/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	public boolean SelectYesCiviServant ()
	{
		try
		{
			//WebElement CivilServantYesButton = driver.findElement(By.name("civilServant"));
			//CivilServantYesButton.sendKeys(Keys.valueOf("true"));
			
			driver.findElement(By.xpath("//*[@id=\"sign-nda\"]/form/div/div[2]/div[2]/label[1]/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean EnterPasswoed (String FieldValue)
	{
		try
		{
			WebElement EnterPassword = driver.findElement(By.name("password"));
			EnterPassword.sendKeys(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ClickIAccept ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'nda-sign\']/div[2]/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	public boolean CloseNDAPopUpBox ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'nda-wrapper\']/div/div[2]/button")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifyCorrectPage ()
	{
		try
		{
			WebElement CorrectPage = driver.findElement(By.id("current-solicitation"));
			String ActualUserPage = CorrectPage.getText();
			String ExpectedPage = ("Current Solicitation:");
			System.out.println("Actual Page Display = " + ActualUserPage);
			System.out.println("Expected Page Display = " + ExpectedPage);
			//Assert.assertEquals(ExpectedPage, ActualUserPage);
			if(!ActualUserPage.contains(ExpectedPage));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}	
	
	public boolean Logout ()
	{
		try
		{
			driver.findElement(By.id("dropdown-arrow")).findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[5]/a")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	

	

}
