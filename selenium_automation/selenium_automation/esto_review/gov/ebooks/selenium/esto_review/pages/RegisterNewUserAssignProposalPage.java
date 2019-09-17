package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;

public class RegisterNewUserAssignProposalPage extends BasePage
{
	
	public RegisterNewUserAssignProposalPage(WebDriver driver)
	{
		super(driver, "RegisterNewUserPageAssignProposal", "ReviewSystem");
	}
	
	
	public boolean NavToManageUsers ()
	{
		try
		{
			sleep(15);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/ul/li[2]/a"))).click().build().perform();
			sleep(5);
			return true;	
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean ClickAddNewUser ()
	{
		try
		{
			driver.findElement(By.xpath("//button[@ng-click='addNewUser()']")).click();
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean RegisterUserPage (String FieldName, String FieldValue)
	{
		try
		{
			switch (FieldName)
			{
				case "First Name":
					WebElement FName = driver.findElement(By.name("firstName"));
					FName.sendKeys(Keys.CONTROL + "a");
					FName.sendKeys(Keys.DELETE);
					FName.sendKeys(FieldValue);
					
				case "Last Name":
					WebElement LName = driver.findElement(By.name("lastName"));
					LName.sendKeys(Keys.CONTROL + "a");
					LName.sendKeys(Keys.DELETE);
					LName.sendKeys(FieldValue);
				
				case "Email":
					WebElement ValueEmail = driver.findElement(By.name("email"));
					ValueEmail.sendKeys(Keys.CONTROL + "a");
					ValueEmail.sendKeys(Keys.DELETE);
					ValueEmail.sendKeys(FieldValue);
				
				case "Organization":
					WebElement ValueOrg = driver.findElement(By.name("organization"));
					ValueOrg.sendKeys(Keys.CONTROL + "a");
					ValueOrg.sendKeys(Keys.DELETE);
					ValueOrg.sendKeys(FieldValue);
					
				case "Phone":
					WebElement ValuePhone = driver.findElement(By.name("phone"));
					ValuePhone.sendKeys(Keys.CONTROL + "a");
					ValuePhone.sendKeys(Keys.DELETE);
					ValuePhone.sendKeys(FieldValue);
			}
			
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean SelectPotentialUser ()
	{
		try
		{
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			sleep(8);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean CaptureEnteredEmail (String email)
	{
		try
		{
			WebElement EnteredEmail = driver.findElement(By.name("email"));
			String UserEmail = EnteredEmail.getText();
			System.out.println("User Email to Assing Proposal = " + UserEmail);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public boolean clickSubmit ()
	{
		try
		{
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			sleep(20);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	
	public boolean SearchByEnteredEmail (String FieldValue)
	{
		try
		{
			sleep(8);
			WebElement SearchByEmail = driver.findElement(By.xpath("//input[@ng-model='search']"));
			SearchByEmail.sendKeys(Keys.CONTROL + "a");
			SearchByEmail.sendKeys(Keys.DELETE);
			SearchByEmail.sendKeys(FieldValue);
			sleep(5);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	//Select Manage User from left menu
	public void selectManageUsers() throws InterruptedException
	{
	WebElement manageUsers = findElement("manage_users_navigationbar");
	manageUsers.click();
		Thread.sleep(5000);
	}
	
	//Navigate to Assign Users
		public boolean NavToAssignProposal ()
		{
			try
			{
				driver.findElement(By.xpath("//span[@class='assign-proposal-small-icon icon-small']")).click();
				sleep(6);
				return true;
			}
			catch (Exception ex)
			{
				return false;
			}
		}

//++++++
		

	//Search By proposal # code is in CommonMethodsESTOReviewPage/SearchManageProposalByPropNumber

	public boolean SelectFirstProposalFromList ()
	{
		try
		{
			driver.findElements(By.xpath("//tr[@class='ng-scope']")).get(0).click();
			sleep(2);
			return true;

		}
		catch (Exception ex)
		{
			return false;
		}
}
	

	public boolean  AddButton ()
	{
		try
		{
			
			sleep(2);
			driver.findElement(By.xpath("//button[@ng-click = 'addSelected()']")).click();
			sleep (3);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
			
	
	public boolean  SelectRoleFromDropdown (String FieldValue)
	{
		try
		{			
			WebElement AssigRoleDD = driver.findElement(By.name("userGroup"));
			//WebElement AssigRoleDD = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\'/div/form/ul/li[4]/div[2]/select"));
			AssigRoleDD.click();
			sleep(5);
			Select SelectRole = new Select (AssigRoleDD);
			SelectRole.selectByVisibleText(FieldValue);
			sleep(7);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}
	
	public boolean  ClickSubmitButton ()
	{
		try
		{	
			sleep(3);
			driver.findElement(By.xpath("//*[@id=\"admin-content-wrapper\"]/div/div[2]/button")).click();
			sleep(15);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	

}
