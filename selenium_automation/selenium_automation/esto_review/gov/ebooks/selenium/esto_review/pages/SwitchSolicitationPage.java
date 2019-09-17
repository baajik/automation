package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gov.ebooks.selenium.shared.pages.BasePage;


public class SwitchSolicitationPage extends BasePage
{
	
	public SwitchSolicitationPage(WebDriver driver){
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
	
		
	public boolean ClickSelectButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[3]/form/div/input")).click();
			sleep(15);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	
	public boolean ClickSwitchSolicitationButton ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'user-menu\']/a/img")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean SelectAnotherSolicitation ()
	{
		try
		{
			driver.findElement(By.id("TEST-AIST")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
}
