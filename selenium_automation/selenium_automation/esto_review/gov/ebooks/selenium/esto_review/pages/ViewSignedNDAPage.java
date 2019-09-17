package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.ebooks.selenium.shared.pages.BasePage;


public class ViewSignedNDAPage extends BasePage
{
	
	public ViewSignedNDAPage(WebDriver driver){
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
	
	public boolean MyAccountToUpdateProfilePage ()
	{
		//Navigate to Security Question
		driver.findElement(By.id("my-account-dropdown")).click();
		sleep(3);
		driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[4]/a")).click();
		return true;
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
	
	
	public boolean DownloadNDA ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div[1]/div[2]/table/tbody/tr[1]/td[3]/a")).click();
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
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/div/div[2]/button")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	

}
