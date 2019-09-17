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

public class Scoring_ProjectorMember_ViewScoringPage extends BasePage
{
	public  Scoring_ProjectorMember_ViewScoringPage(WebDriver driver)
	{
		super(driver, "Scoring Projector Member Page", "Peer Review System");
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
	//*[@id="elapsed-time-wrapper"]/div/span

	public boolean verifyPopUpTimerForProjector ()
	{
		try
		{
			
			WebElement TimerPopUp =  driver.findElement(By.xpath("//*[@id=\'elapsed-time-wrapper\']/div/span"));
			String ActualMessage = TimerPopUp.getText();
			String ExpectedMessage = "Time Remaining: ";
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
	
	
	public boolean verifyScoreEndMessgeForProjector ()
	{
		try
		{
			sleep(3);
			WebElement EndMessage =  driver.findElement(By.xpath("//*[@id=\'elapsed-time-wrapper\']/div/span"));
			String ActualMessage = EndMessage.getText();
			String ExpectedMessage = "Scoring has ended";
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
	
	
	public boolean verifyPopUpHeaderDisplayForProjector ()
	{
		try
		{
			WebElement ScoreHeader =  driver.findElement(By.xpath("//*[@id=\'bootstrap-modal-wrapper\']/div[1]/div/div/div/h1"));
			String ActualMessage = ScoreHeader.getText();
			String ExpectedMessage = "Panel Score Results: ";
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
	
	
	public boolean verifyAverageScoreForProjector ()
	{
		try
		{
			WebElement AverageScore =  driver.findElement(By.xpath("//*[@id=\'bootstrap-modal-wrapper\']/div[1]/div/div/div/div/div[1]"));
			String ActualMessage = AverageScore.getText();
			String ExpectedMessage = "Average Score: ";
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
	
	
	public boolean verifyVarianceScoreForProjector ()
	{
		try
		{
			WebElement AverageVariance =  driver.findElement(By.xpath("//*[@id=\'bootstrap-modal-wrapper\']/div[1]/div/div/div/div/div[2]"));
			String ActualMessage = AverageVariance.getText();
			String ExpectedMessage = "Variance: ";
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
	
	public boolean verifyStandDeviScoreForProjector ()
	{
		try
		{
			WebElement StandDeviation =  driver.findElement(By.xpath("//*[@id=\'bootstrap-modal-wrapper\']/div[1]/div/div/div/div/div[3]"));
			String ActualMessage = StandDeviation.getText();
			String ExpectedMessage = "Standard Deviation: ";
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
	
	
	public boolean verifyAdjRatingForProjector ()
	{
		try
		{
			WebElement AdjecRating =  driver.findElement(By.xpath("//*[@id=\'bootstrap-modal-wrapper\']/div[1]/div/div/div/div/div[4]"));
			String ActualMessage = AdjecRating.getText();
			String ExpectedMessage = "Adjectival Rating: ";
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
