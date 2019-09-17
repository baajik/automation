package gov.ebooks.selenium.esto_review.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;
import gov.ebooks.selenium.shared.utils.ConfigManager;

public class PM_ManageNotificationsPage extends BasePage{

//Add constructor like below for each page	
	public PM_ManageNotificationsPage(WebDriver driver)
	{
		super(driver, "PM Manage Notificatio", "esto_review");
	}

/*
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
	*/
	
	public boolean NavToManageNotifications () throws InterruptedException
	{
		try
		{
			sleep(20);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/ul/li[5]/a"))).click().build().perform();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	public boolean NavtoUpdate ()
	
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/div[3]/div[2]/table/tbody/tr[1]/td[7]/button[2]")).click();
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}	
	}
	
	public boolean MsgVerification (String FieldName)
	{
		try
		{
			switch (FieldName)
			{	
			case "NotificationTitle":
			WebElement NotTitle = driver.findElement(By.name("NotificationTitle"));
			NotTitle.sendKeys(Keys.CONTROL + "a");
			NotTitle.sendKeys(Keys.DELETE);
			sleep(3);
			break;
			
			case "notificationText":
			WebElement NotText = driver.findElement(By.name("notificationText"));
			NotText.sendKeys(Keys.CONTROL + "a");
			NotText.sendKeys(Keys.DELETE);
			sleep(5);
			break;
			}
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean AddNotificationTitle (String FieldName, String FieldValue)
	{
		try
		{
			switch (FieldName)
			{	
			case "NotificationTitle":
			WebElement NotTitle = driver.findElement(By.name("NotificationTitle"));
			NotTitle.sendKeys(Keys.CONTROL + "a");
			NotTitle.sendKeys(Keys.DELETE);
			NotTitle.sendKeys(FieldValue);
			sleep(3);
			break;
			
			case "notificationText":
			WebElement NotText = driver.findElement(By.name("notificationText"));
			NotText.sendKeys(Keys.CONTROL + "a");
			NotText.sendKeys(Keys.DELETE);
			NotText.sendKeys(FieldValue);
			sleep(5);
			break;
			}
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean UploadAttachements ()
	{
		try
		{
			WebElement UploadFile = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[3]/input"));
			UploadFile.sendKeys ("C:\\Users\\rashika.shrestha\\OneDrive - REI Systems Inc\\Desktop\\Old Projects\\SampleUpload.pdf");
			
			//UploadFile.sendKeys (ConfigManager.Uploads() + "SampleQuadChart.png");
			sleep(5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}


	public boolean ProposalStage (String FieldValue)
	{
		try
		{
			WebElement SelectProposalStage = driver.findElement(By.name("proposalStage"));
			SelectProposalStage.sendKeys(FieldValue);
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean SelectRole (String FieldValue)
	{
		try
		{
			WebElement SelectRole = driver.findElement(By.name("groupStage"));
			SelectRole.sendKeys(FieldValue);
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean Submit ()
	{
		try
		{

			WebElement etlScrollToSubmit =  driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/div/button"));
			scrollPageTo (etlScrollToSubmit);
			etlScrollToSubmit.click();
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean VerificationMsg ()
	{
		try
		{
			WebElement VerifMsg = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[2]/div[3]"));
			String ActualMsg =  VerifMsg.getText();
			sleep (4);
			System.out.println("Actual display Message = " + ActualMsg);
			String ExpectedMessage = "Notification Text is required";
			System.out.println("Expected Message = " + ExpectedMessage);
			Assert.assertEquals(ExpectedMessage, ActualMsg);
			//if (!ActualMsg.matches(ExpectedMessage));
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
}

