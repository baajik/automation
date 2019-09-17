package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class PM_DownloadNDAPage extends BasePage
{
	//Add constructor like below for each page
	public PM_DownloadNDAPage(WebDriver driver) 
	{
		super(driver, "PM Download NDA Page", "esto_review");
	}

	
	public boolean NavigateToDownloadNDA () throws InterruptedException
	{
		try
		{
			sleep(20);
			WebElement adminIcon = driver.findElement(By.id("admin-tools-dropdown"));
			//WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-tools-dropdown\"]/ul/li[8]/a"))).click().build().perform();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean SearchByFunction (String FieldValue)
	{
		try
		{
			WebElement SearchBy = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/div[1]/label/input"));
			SearchBy.sendKeys(Keys.CONTROL + "a");
			SearchBy.sendKeys(Keys.DELETE);
			SearchBy.sendKeys(FieldValue);
			sleep (6);
			return true;
			}
			catch (Exception ex)
			{
				return false;
			}
	}
	
	
	
	public boolean DownloadSingleNDA ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/div[3]/table/tbody/tr[1]/td[8]/div/a")).click();
			sleep (6);
			return true;
			}
			catch (Exception ex)
			{
				return false;
			}
	}
	
	public boolean DownloadAllNDAs ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/div[1]/input")).click();
			sleep (6);
			return true;
			
			}
			catch (Exception ex)
			{
				return false;
			}
	}
	
	
}
