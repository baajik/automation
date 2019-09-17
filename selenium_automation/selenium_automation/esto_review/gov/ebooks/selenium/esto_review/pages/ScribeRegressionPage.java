package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;
import gov.ebooks.selenium.shared.utils.ConfigManager;

public class ScribeRegressionPage extends BasePage
{
	
	public  ScribeRegressionPage(WebDriver driver){
		super(driver, "Scribe Regression Page", "ESTO");
	}

	
	
	public boolean ViewEvaluation ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/div/proposal-action")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean NavToMyDiscussionNotes ()
	{
		try
		{
			sleep(3);
			driver.findElement(By.xpath("//proposal-action[@type='panel_discussion_notes']")).click();
			//driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/div/proposal-action[1]/a")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean EnterValueInNotes ()
	{
		try
		{
			sleep(3);
			WebElement DisNote = driver.findElement(By.xpath("//textarea[@placeholder='Enter Notes...']"));
			//WebElement DisNote = driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div[2]/div/proposal-template/form/ul/li/div[2]/textarea"));
			DisNote.sendKeys(Keys.CONTROL + "a");
			DisNote.sendKeys(Keys.DELETE);
			DisNote.sendKeys("This is an automation Testing.This is an automation Testing.This is an automation Testing.This is an automation Testing.");
			sleep(3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SaveButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div[2]/div/proposal-template/form/div/button")).click();
			sleep(4);
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
	
	public boolean NavToViewEvaluation ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div/div[2]/div[1]/div/proposal-action[1]/a")).click();
			sleep (6);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}	
	
	
}
