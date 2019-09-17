package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;

public class PM_MangeProposalStagesPage extends BasePage{
	
	public PM_MangeProposalStagesPage(WebDriver driver){
		super(driver, "PM Manage Propsoal Stage", "esto_review");
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
	
	
	public boolean NavToManagePropStage () throws InterruptedException
	{
		try
		{
			sleep(20);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/ul/li[4]/a"))).click().build().perform();
//			action.moveToElement(adminIcon).build().perform();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SearchByCurrentStage (String FieldValue)
	{
		try
		{
			WebElement SearchBy = driver.findElement(By.xpath("//*[@id='admin-content-wrapper\']/form/ul/li[1]/div[2]/div[1]/div[1]/div[1]/label/input"));
			SearchBy.sendKeys(Keys.CONTROL + "a");
			SearchBy.sendKeys(Keys.DELETE);
			SearchBy.sendKeys(FieldValue);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SearchVsResultForCurrentStage()
	{
		try
		{
			sleep(10);
			//WebElement SearchValue = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/form/ul/li[1]/div[2]/div[1]/div[1]/div[1]/label/input"));
			String ExpectedDisplay = "Lead Reviewer";
			System.out.println("Expected Display = " + ExpectedDisplay);
			sleep(10);
			WebElement CurrentStageValue = driver.findElement(By.className("ng-scope k-state-selected")).findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/form/ul/li[1]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]]"));
			String ActualDispaly = CurrentStageValue.getText();
			System.out.println("Actual Display = " + ActualDispaly);
			sleep(10);
			if (!ActualDispaly.contains(ExpectedDisplay));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SearchVsResultForProposal()
	{
		try
		{
			sleep(10);
			String ExpectedDisplay = "16-AIST16-0004";
			System.out.println("Expected Display = " + ExpectedDisplay);
			sleep(10);
			
			WebElement CurrentStageValue = driver.findElement(By.className("ng-scope")).findElement(By.className("//*[@id=\'admin-content-wrapper\']/form/ul/li[1]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td[1]"));
			String ActualDispaly = CurrentStageValue.getText();
			System.out.println("Actual Display = " + ActualDispaly);
			if (!ActualDispaly.contains(ExpectedDisplay));
			sleep(20);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SelectProposalToManage ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/form/ul/li[1]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr[1]")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickAddButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/form/ul/li[1]/div[2]/div[1]/div[2]/button[1]")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean SelectStageDD (String FieldValue)
	{
		try
		{
			WebElement selectLeadReviewer = driver.findElement(By.name("proposalStage"));
			selectLeadReviewer.click();
			Select DDLeadReviewer = new Select (selectLeadReviewer);
			DDLeadReviewer.selectByVisibleText(FieldValue);
			sleep(20);
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
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/form/div/input")).click();
			sleep (10);
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
			sleep (10);
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
			sleep (6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	
}
