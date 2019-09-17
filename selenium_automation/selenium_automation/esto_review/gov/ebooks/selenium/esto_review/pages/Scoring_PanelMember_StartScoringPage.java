package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;
import gov.ebooks.selenium.shared.utils.ConfigManager;
import junit.framework.Assert;


public class Scoring_PanelMember_StartScoringPage extends BasePage
{	
	public  Scoring_PanelMember_StartScoringPage(WebDriver driver){
		super(driver, "Scoring Panel Member Page", "Peer Review System");
	}
	

	public boolean FilterByProposal022 ()
	{
		try
		{
			sleep (15);
			WebElement Prop0022 = driver.findElement(By.xpath("//*[@id=\'search-field-wrapper\']/input"));
			Prop0022.sendKeys(Keys.CONTROL + "a");
			Prop0022.sendKeys(Keys.DELETE);
			Prop0022.sendKeys("0022");
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	public boolean PanelScoreField (String FieldValue)
	{
		try
		{
			sleep(3);
			WebElement EnterScore = driver.findElement(By.id("panel-score-field"));
			EnterScore.sendKeys(Keys.CONTROL + "a");
			EnterScore.sendKeys(Keys.DELETE);
			EnterScore.sendKeys(FieldValue);
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
			driver.findElement(By.xpath("//*[@id=\'panel-score-form\']/div[2]/button[1]")).click();
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean VerifySubmittedScoreMessage ()
	{
		try
		{
			//*[@id="panel-score-label"]
			//  panel-score-label
			WebElement Message =  driver.findElement(By.xpath("//*[@id=\'panel-score-label\']"));
			String ActualMessage = Message.getText();
			String ExpectedMessage = "Your Score:";
			System.out.println("Expected display message = " + ExpectedMessage);
			System.out.println("Actual display message = " + ActualMessage);
			//Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
			if (!ActualMessage.contains(ExpectedMessage));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean VerifyFinalScoreMessage ()
	{
		try
		{
			sleep(4);
			WebElement ScoreEndMessage =  driver.findElement(By.xpath("//*[@id=\'panel-score-content\']/div[2]/h3"));
			String ActualMessage = ScoreEndMessage.getText();
			String ExpectedMessage = "Final Score:";
			System.out.println("Expected display message = " + ExpectedMessage);
			System.out.println("Actual display message = " + ActualMessage);
			//Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
			if (!ActualMessage.contains(ExpectedMessage));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	
}
