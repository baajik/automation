package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class PM_ManageConflict_LackOfExpertisePage extends BasePage
{
	//Add constructor like below for each page
	public PM_ManageConflict_LackOfExpertisePage(WebDriver driver) 
	{
		super(driver, "PM Manage Conflict Lack Of Expertise Page", "esto_review");
	}

	public boolean ManageConflictLackOfExpertise () throws InterruptedException
	{
		try
		{
			sleep(20);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-tools-dropdown\"]/ul/li[7]/a"))).click().build().perform();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean ExpandProposal ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[4]/span")).click();
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SelectApprovedButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/form/ul/li[1]/div[2]/div[1]/label/input")).click();
			sleep(5);

			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SelectNotApprovedButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/form/ul/li[1]/div[2]/div[2]/label")).click();
			sleep(5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean EnterCommentsInESTOCommets (String FieldValue)
	{
		try
		{
			WebElement ESTOcomments = driver.findElement(By.name("reviewerComment"));
			ESTOcomments.sendKeys(Keys.CONTROL + "a");
			ESTOcomments.sendKeys(Keys.DELETE);
			ESTOcomments.sendKeys(FieldValue);
			sleep(6);
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
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/form/div"));
			WebElement etlSubmit = driver.findElement(By.name("/*[@id=\'admin-content-wrapper\']/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div/form/div/input"));
			scrollPageTo (etlSubmit);
			etlSubmit.click();
			sleep(6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean VerifyAlertMsg ()
	{
		try
		{
			WebElement ValMSGOnApproval = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div[2]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div/form/ul/li[1]/div[2]/div[3]"));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
}
