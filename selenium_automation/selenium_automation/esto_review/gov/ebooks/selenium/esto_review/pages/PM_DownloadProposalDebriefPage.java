package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class PM_DownloadProposalDebriefPage extends BasePage 
{
	//Add constructor like below for each page
		public PM_DownloadProposalDebriefPage(WebDriver driver) 
		{
			super(driver, "ESTO PM Download Proposal Debrief Page", "esto_review");
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
	
	
}
