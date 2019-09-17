package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;


public class ReviewerAccessOfProposalLinksPage extends BasePage
{
	
	public ReviewerAccessOfProposalLinksPage(WebDriver driver){
		super(driver, "ReviewerAccessOfProposalLinksPage", "esto_review");
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
			sleep (10);
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
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/a")).get(0).click();
			sleep (3);
			driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[1]/div[2]/span")).click();
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickOfCompleteProposalPackage ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[1]/a")).get(0).click();
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}	
	
	
	public boolean ClickOfCoverSheet ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[2]/a")).get(0).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickOfTechnicalProposal ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[3]/a")).get(0).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	public boolean ClickOfLOE ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[4]/a")).get(0).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickOfResumes ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[5]/a")).get(0).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickOfSupportingBudgetData ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[6]/a")).get(0).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	public boolean ClickOfQuadChart ()
	{
		try
		{
			driver.findElements(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[2]/proposal-document[7]/a")).get(0).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
}
