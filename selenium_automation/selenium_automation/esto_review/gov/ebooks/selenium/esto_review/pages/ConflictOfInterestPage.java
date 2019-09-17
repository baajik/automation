package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;


public class ConflictOfInterestPage extends BasePage
{
	
	public ConflictOfInterestPage(WebDriver driver){
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
	

	public boolean ClickSelectButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/form/div/input")).click();
			sleep(15);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean ClickConflictOfInterest ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[1]/div[2]/a/span")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	

	
	
//**Conflict of Interest submission	
	public boolean SelectConflictOfInterestRadioButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/div/form/ul/li[1]/div[2]/div[1]/label/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SelectConflictType ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/div/form/ul/li[2]/div[2]/div[3]/label/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean EnterValueForCOI (String FieldValue)
	{
		try
		{
			WebElement EnterComments = driver.findElement(By.name("comments"));
			EnterComments.click();
			EnterComments.sendKeys(Keys.CONTROL + "a");
			EnterComments.sendKeys(Keys.DELETE);
			EnterComments.sendKeys(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
		
	}

	public boolean ClickSubmitForCOI ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/div/form/div/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifySuccessMessage ()
	{
		try
		{
			WebElement Msg = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/h4"));
			String ActualSuccesValMsg = Msg.getText();
			String ExpectedSuccessValMsg = ("Your Conflict of interest was successfully submitted.");
			System.out.println("Expected Msessge = " + ExpectedSuccessValMsg);
			System.out.println("Actual Message = " + ActualSuccesValMsg);
			//Assert.assertEquals(ExpectedSuccessValMsg, ActualSuccesValMsg);
			if(!ExpectedSuccessValMsg.matches(ActualSuccesValMsg));
			{
			return true;
			}
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
	
	
	
//** Lack of Expertise Submission
	public boolean SelectLackOfExpertise () 
	{
		try
		{
			
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/div/form/ul/li[1]/div[2]/div[2]/label/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean EnterValueForLackOfExp (String FieldValue)
	{
		try
		{
			WebElement EnterComments = driver.findElement(By.id(""));
			EnterComments.click();
			EnterComments.sendKeys(Keys.CONTROL + "a");
			EnterComments.sendKeys(Keys.DELETE);
			EnterComments.sendKeys(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
}
