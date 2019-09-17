package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;
import junit.framework.Assert;

public class SecurityQuestionPage extends BasePage
{
	
	public SecurityQuestionPage(WebDriver driver){
		super(driver, "piAdditionalProjectInformationPage", "esto_review");
	}

	public boolean CorrectPageDisplayValidation ()
	{
		try
		{
		WebElement VerPage = driver.findElement(By.xpath("//*[@id=\'main\']/form/h1"));
		String VerifyCorrectPage = VerPage.getText();
		if(!VerifyCorrectPage.matches("Create Security Question"));		
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
			driver.findElement(By.xpath("//*[@id=\'main\']/form/div/input")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean AnswerFieldValMsg ()
	{
		try
		{
			WebElement ValMesgAnser = driver.findElement(By.xpath("//*[@id=\'main\']/form/ul/li[3]/div[2]/div"));
			String ActualMessage = ValMesgAnser.getText();
			String ExpectedMessage = ("Answer is required");
			System.out.println("Actual Message Display = " + ActualMessage);
			System.out.println("Expected Message = " + ExpectedMessage);
			//Assert.assertEquals(ExpectedMessage, ActualMessage);
			if (!ActualMessage.matches(ExpectedMessage));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SelectSecurityQuestionDD (String FieldValue)
	{
		try
		{
			WebElement SecQuesDD = driver.findElement(By.name("questionUid"));
			SecQuesDD.click();
			sleep(2);
			Select DDQuestion1 = new Select (SecQuesDD);
			DDQuestion1.selectByVisibleText(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean AnswerField (String FieldValue)
	{
		try
		{
			WebElement AnswerSecQuestion = driver.findElement(By.name("answer"));
			AnswerSecQuestion.sendKeys(Keys.CONTROL + "a");
			AnswerSecQuestion.sendKeys(Keys.DELETE);
			AnswerSecQuestion.sendKeys(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	

	
//** Voluntary change of Security Question	
	
		public boolean NavToSecurityQuestions ()
		{
			//Navigate to Security Question
			driver.findElement(By.id("my-account-dropdown")).click();
			sleep(3);
			driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[3]/a")).click();
			return true;
		}
		

		public boolean AddMoreQuestion ()
		{
			// Add more security Question
			
			driver.findElement(By.id("addQuestion")).click();
			return true;
		} 
	//
	
	public boolean SelectSecQuestion ()
	{
		try
		{
			WebElement SecQuestionDD = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[1]/div[2]/div[1]/select"));
			SecQuestionDD.click();
			Select SelectSecurityQuestion = new Select (SecQuestionDD);
			SelectSecurityQuestion.selectByVisibleText("What is your favorite movie?");
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean EnterAnswer ()
	{
		try
		{
			WebElement EnterValueInAnswer = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/form/ul/li[2]/div[2]/div[1]/input"));
			EnterValueInAnswer.sendKeys(Keys.CONTROL + "a");
			EnterValueInAnswer.sendKeys(Keys.DELETE);
			EnterValueInAnswer.sendKeys("ESTO");
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean UpdateSubmitButton ()
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
	
	
	public boolean SuccessMessage ()
	{
		try
		{
			WebElement SucsMSG = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/h4"));
			String ActualSuccessMessage = SucsMSG.getText();
			String ExpectedMessage = ("Your security question was successfully updated");
			System.out.println("Expected Message = " + ExpectedMessage);
			System.out.println("Actual Message = " + ActualSuccessMessage);
			Assert.assertEquals(ExpectedMessage,ActualSuccessMessage);
			if(!ExpectedMessage.matches(ActualSuccessMessage));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean ClickOkayToClose ()
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
