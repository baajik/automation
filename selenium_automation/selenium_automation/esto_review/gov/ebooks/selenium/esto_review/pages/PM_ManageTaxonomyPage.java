package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;

public class PM_ManageTaxonomyPage extends BasePage 
{
	//Add constructor like below for each page	
	public PM_ManageTaxonomyPage(WebDriver driver)
	{
		super(driver, "PM ManageTaxonomy Page", "esto_review");
	}
	
	public boolean NavToManageTaxonomy () throws InterruptedException
	{
		try
		{
			sleep(20);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-tools-dropdown\"]/ul/li[6]/a"))).click().build().perform();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
		
	}	

	
//******* Add New Taxonomy	
	public boolean NavToAddNewTaxonomy ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/div[3]/a")).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean CatagoryQuestion (String FieldValue)
	{
		try
		{
			WebElement CategoryField = driver.findElement(By.name("taxonomyTitle"));
			CategoryField.sendKeys(Keys.CONTROL + "a");
			CategoryField.sendKeys(Keys.DELETE);
			CategoryField.sendKeys(FieldValue);
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}	
	
	
	
	public boolean QuestionType ()
	{
		try
		{
			WebElement QuestionType = driver.findElement(By.name("categoryType"));
			QuestionType.click();
			sleep (3);
			Select QuestionTypeDD = new Select (QuestionType);
			QuestionTypeDD.selectByVisibleText("Drop-Down List");
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
		
	public boolean RemoveOption ()
	{
		try
		{
			driver.findElement(By.className("remove")).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}
	
	
	public boolean AddOption()
	{
		try
		{
			WebElement Catagory =  driver.findElement(By.className("addfields"));
			Catagory.click();
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}	
	
	
	public boolean EnterValueInOption1 (String FieldValue)
	{
		try
		{
			
			
			WebElement OptionValue = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[3]/div/fieldset[1]/input"));
			OptionValue.sendKeys(Keys.CONTROL + "a");
			OptionValue.sendKeys(Keys.DELETE);
			OptionValue.sendKeys(FieldValue);
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}	
		

	public boolean EnterValueInOption2 (String FieldValue)
	{
		try
		{
			
			
			WebElement OptionValue = driver.findElement(By.xpath("	//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[3]/div/fieldset[2]/input"));
			OptionValue.sendKeys(Keys.CONTROL + "a");
			OptionValue.sendKeys(Keys.DELETE);
			OptionValue.sendKeys(FieldValue);
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}	
	
	public boolean EnterValueInOption3 (String FieldValue)
	{
		try
		{
			
			
			WebElement OptionValue = driver.findElement(By.xpath("	//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[3]/div/fieldset[3]/input"));
			OptionValue.sendKeys(Keys.CONTROL + "a");
			OptionValue.sendKeys(Keys.DELETE);
			OptionValue.sendKeys(FieldValue);
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}
	
	public boolean EnterValueInOption4 (String FieldValue)
	{
		try
		{
			
			
			WebElement OptionValue = driver.findElement(By.xpath("	//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[3]/div/fieldset[4]/input"));
			OptionValue.sendKeys(Keys.CONTROL + "a");
			OptionValue.sendKeys(Keys.DELETE);
			OptionValue.sendKeys(FieldValue);
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}
	
	
	public boolean ClickSubmit ()
	{
		try
		{
			WebElement etlSubmitValue = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/input"));
			scrollPageTo(etlSubmitValue);
			etlSubmitValue.click();
			sleep (5);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}	
	
	

//******* Select the Taxonomy answer and Save	
	
	public boolean SelectTheAnswerDD (String FieldValue)
	{
		try
		{
			WebElement SelectQuestion = driver.findElement(By.name("1-21"));
			SelectQuestion.click();
			sleep (3);
			Select AnswerDD = new Select (SelectQuestion);
			AnswerDD.selectByVisibleText(FieldValue);
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}
	
	
	public boolean SaveManageTaxonomy ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/input[1]")).click();
			sleep (6);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}
	

	
//****** Edit Existing Taxonomy 
	
	public boolean EditExistingTaxonomy ()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/div[3]/div[2]/button")).click();
			sleep (7);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
		
	}
	
	
		//***** Call methods from Add New Taxonomy
	
	public boolean EditValue (String FieldValue)
	{
		try
		{
			WebElement RemoveValue = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[3]/div/fieldset[1]/input"));
			RemoveValue.sendKeys(Keys.CONTROL + "a");
			RemoveValue.sendKeys(Keys.DELETE);
			RemoveValue.sendKeys(FieldValue);
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
				return false;
		}
	}
	
	
	
	public boolean EditOption (String FieldValue)
	{
		try
		{
			WebElement ValueOption = driver.findElement(By.name("optionList"));
			ValueOption.sendKeys(Keys.CONTROL + "a");
			ValueOption.sendKeys(Keys.DELETE);
			ValueOption.sendKeys(FieldValue);
			sleep (3);
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
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}	
	}
	
	
	
}
