package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class ReviewerUpdateReviewPage extends BasePage{
	
	public ReviewerUpdateReviewPage(WebDriver driver){
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
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean VerifyCorrectCurrentSolicitation ()
	{
		try
		{
			WebElement VerifyCorrectSol = driver.findElement(By.id("current-solicitation"));
			String SystemDisplay=  VerifyCorrectSol.getText();
			String ExpectedDisplay = ("ACT-17");
			System.out.print("Expected Current Solicitation = " + ExpectedDisplay);
			System.out.println("\r\nActual Current Solicitation = " +  SystemDisplay);
			if (!ExpectedDisplay.matches(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean NavOfSearchIcon ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'search-field-wrapper\']/a/span")).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
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
	
	
	public boolean VerifySortbyResult ()
	{
		try
		{	
			WebElement VerifySortBy = driver.findElement(By.xpath("//*[@id=\'proposal-search-wrapper\']/div[1]/div[1]"));
			String SystemDisplay = VerifySortBy.getText();
			String ExceptedDisplay = ("Proposal Number");
			System.out.print("Expected Display = Sort: " + ExceptedDisplay );
			System.out.println("\r\nActual Display = " +  SystemDisplay);
			if (!ExceptedDisplay.contains(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	

	public boolean ClickUpdateReviewIcon ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/div/proposal-action/a")).click();
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ClickToggleTabSummary ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/div[1]/div/div[2]/span")).click();
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickProposalSummaryTab ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'review-form-wrapper\']/form/ul/li[1]/ul/li[1]/div/span")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickFactor1Relevance ()
	{
		
		try
		{
			driver.findElement(By.xpath("//*[@id=\'review-form-wrapper\']/form/ul/li[1]/ul/li[2]/div/span")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ClickFactor2IntrinsicMerit ()
	{
		
		try
		{
			driver.findElement(By.xpath("//*[@id=\'review-form-wrapper\']/form/ul/li[1]/ul/li[3]/div/span")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ClickFactor3CostRealism ()
	{
		
		try
		{
			driver.findElement(By.xpath("//*[@id=\'review-form-wrapper\']/form/ul/li[1]/ul/li[4]/div/span")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ClickComments ()
	{
		driver.findElement(By.xpath("//*[@id=\'review-form-wrapper\']/form/ul/li[1]/ul/li[5]/div/span")).click();
		try
		{
			
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ClickInternalComments ()
	{
		driver.findElement(By.xpath("//*[@id=\"review-form-wrapper\"]/form/ul/li[1]/ul/li[6]/div/span")).click();
		try
		{
			
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	
	public boolean ValueInProposalSummary ()
	{
		try
		{
			WebElement ProposalSummary = driver.findElement(By.name("summary"));
			ProposalSummary.click();
			ProposalSummary.sendKeys(Keys.CONTROL + "a");
			ProposalSummary.sendKeys(Keys.DELETE);
			ProposalSummary.sendKeys("Test to enter Propsoal Summary for automation script.");
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean UpdateReview (String FieldName, String FieldValue)
	{
		try
		{
			switch (FieldName)
			{
			case "ProposalSummary":
				WebElement ProposalSummary = driver.findElement(By.name("summary"));
				ProposalSummary.click();
				ProposalSummary.sendKeys(Keys.CONTROL + "a");
				ProposalSummary.sendKeys(Keys.DELETE);
				ProposalSummary.sendKeys(FieldValue);
				break;
	
	//Relevance Factor1	
			case "RelevanceFactor1Score":
				WebElement Factor1Score = driver.findElement(By.id("score0"));
				scrollPageTo(Factor1Score);
				Factor1Score.click();
				Factor1Score.sendKeys(Keys.CONTROL + "a");
				Factor1Score.sendKeys(Keys.DELETE);
				Factor1Score.sendKeys(FieldValue);
				break;
				
			case "RelevanceFactor1Strengths":
				WebElement Factor1Strengths = driver.findElement(By.name("strengths_0"));
				Factor1Strengths.click();
				Factor1Strengths.sendKeys(Keys.CONTROL + "a");
				Factor1Strengths.sendKeys(Keys.DELETE);
				Factor1Strengths.sendKeys(FieldValue);
				break;
				
			case "RelevanceFactor1Weaknesses":
				WebElement Factor1Weaknesses = driver.findElement(By.name("weaknesses_0"));
				Factor1Weaknesses.click();
				Factor1Weaknesses.sendKeys(Keys.CONTROL + "a");
				Factor1Weaknesses.sendKeys(Keys.DELETE);
				Factor1Weaknesses.sendKeys(FieldValue);
				
	//Intrinsic Merit Factor2
			case "MeritFactorScore2":
				WebElement MeritScore = driver.findElement(By.id("score1"));
				scrollPageTo(MeritScore);
				MeritScore.sendKeys(Keys.CONTROL + "a");
				MeritScore.sendKeys(Keys.DELETE);
				MeritScore.sendKeys(FieldValue);
				
			case "MeritStrengths":
				WebElement MeritStrength = driver.findElement(By.name("strengths_1"));
				MeritStrength.sendKeys(Keys.CONTROL + "a");
				MeritStrength.sendKeys(Keys.DELETE);
				MeritStrength.sendKeys(FieldValue);
				
			case "MeritWeaknesses":
				WebElement MertiWeakness = driver.findElement(By.name("weaknesses_1"));
				MertiWeakness.sendKeys(Keys.CONTROL + "a");
				MertiWeakness.sendKeys(Keys.DELETE);
				MertiWeakness.sendKeys(FieldValue);
					
	//Cost Realism Factor3
	
			case "CostFactorScore3":
				WebElement CostScore = driver.findElement(By.id("score2"));
				CostScore.sendKeys(Keys.CONTROL + "a");
				CostScore.sendKeys(Keys.DELETE);
				CostScore.sendKeys(FieldValue);
				
			case "CostStrengths":
				WebElement CostStrength = driver.findElement(By.name("strengths_2"));
				CostStrength.sendKeys(Keys.CONTROL + "a");
				CostStrength.sendKeys(Keys.DELETE);
				CostStrength.sendKeys(FieldValue);
				
			case "CostWeaknesses":
				WebElement CostWeakness = driver.findElement(By.name("weaknesses_2"));
				CostWeakness.sendKeys(Keys.CONTROL + "a");
				CostWeakness.sendKeys(Keys.DELETE);
				CostWeakness.sendKeys(FieldValue);
	
	//Comments
			case "Comments":
				WebElement CommentsField = driver.findElement(By.name("comments"));
				CommentsField.sendKeys(Keys.CONTROL + "a");
				CommentsField.sendKeys(Keys.DELETE);
				CommentsField.sendKeys(FieldValue);
				
	//Internal Comments
			case "InternalComments":
				WebElement IntCommField = driver.findElement(By.name("internalComments"));
				IntCommField.sendKeys(Keys.CONTROL + "a");
				IntCommField.sendKeys(Keys.DELETE);
				IntCommField.sendKeys(FieldValue);
				
			}
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickSaveButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'saveSubmit\']/button[1]")).click();
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
			WebElement etlScrolSubmit = driver.findElement(By.xpath("//button[@ng-click='submit()']"));
			//WebElement etlScrolSubmit = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div/div[2]/div[1]/proposal-template/div[2]/button"));
			scrollPageTo(etlScrolSubmit);
			etlScrolSubmit.click();
			sleep (6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifySatusSubmitted ()
	{
		try
		{
			WebElement VerifyStatus = driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/proposal-template/div[1]/div[1]"));
			String SystemDisplay=  VerifyStatus.getText();
			String ExpectedDisplay = ("Status: ");
			System.out.print("Expected Status = " + ExpectedDisplay);
			System.out.println("\r\nActual Status = " +  SystemDisplay);
			if (!ExpectedDisplay.contains(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	public boolean VerifyAverageScore ()
	{
		try
		{
			WebElement VerifyAvgScore = driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/proposal-template/div[1]/div[2]"));
			String SystemDisplay=  VerifyAvgScore.getText();
			String ExpectedDisplay = ("Average Score:");
			System.out.print("Expected Display = " + ExpectedDisplay);
			System.out.println("\r\nActual Display = " +  SystemDisplay);
			if (ExpectedDisplay.contains(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifyAdjectivalRating ()
	{
		try
		{
			WebElement VerifyScore = driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/proposal-template/div[1]/div[3]"));
			String SystemDisplay=  VerifyScore.getText();
			String ExpectedDisplay = ("Adjectival Rating: ");
			System.out.print("Expected Display = " + ExpectedDisplay);
			System.out.println("\r\nActual Display = " +  SystemDisplay);
			if (!ExpectedDisplay.contains(SystemDisplay));
			sleep(6);
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
			WebElement notification = driver.findElement(By.xpath("//span[contains(@class,'success-notification')]/parent::div//span[contains(@class,'notification-message')]"));
			sleep (20);
			String SuccessMessage = notification.getText();
			System.out.println("Success message for Manage Proposal: " + SuccessMessage);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}	
	}
	
	
	public boolean ClosePopUp ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[1]/div[2]/span")).click();
			sleep(20);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifyScoreOfFactor1 ()
	{
		try
		{
			WebElement VerifyFac1 = driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/proposal-template/div[2]/div[2]/div[1]/span[2]"));
			String SystemDisplay=  VerifyFac1.getText();
			String ExpectedDisplay = ("Score: ");
			System.out.print("Expected Display = " + ExpectedDisplay);
			System.out.println("\r\nActual Display = " +  SystemDisplay);
			if (!ExpectedDisplay.contains(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	public boolean VerifyScoreOfFactor2 ()
	{
		try
		{
			WebElement VerifyFac2 = driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/proposal-template/div[2]/div[2]/div[2]/span[2]"));
			String SystemDisplay=  VerifyFac2.getText();
			String ExpectedDisplay = ("Score: ");
			System.out.print("Expected Display = " + ExpectedDisplay);
			System.out.println("\r\nActual Display = " +  SystemDisplay);
			if (!ExpectedDisplay.contains(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifyScoreOfFactor3 ()
	{
		try
		{
			WebElement VerifyFac3 = driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/proposal-template/div[2]/div[2]/div[3]"));
			String SystemDisplay=  VerifyFac3.getText();
			String ExpectedDisplay = ("Score: ");
			System.out.print("Expected Display = " + ExpectedDisplay);
			System.out.println("\r\nActual Display = " +  SystemDisplay);
			if (!ExpectedDisplay.contains(SystemDisplay));
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	
	public boolean ClickOfProposalInformation ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/a"));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
}
