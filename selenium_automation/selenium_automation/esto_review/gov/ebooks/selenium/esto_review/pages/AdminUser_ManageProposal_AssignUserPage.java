package gov.ebooks.selenium.esto_review.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;
import gov.ebooks.selenium.shared.utils.ConfigManager;

public class AdminUser_ManageProposal_AssignUserPage extends BasePage
{

	public AdminUser_ManageProposal_AssignUserPage(WebDriver driver)
	{
		super (driver, "AdminUser Manage Proposal Assign User Page","ESTO");
	}
	

	public boolean NavToManageProposals () throws InterruptedException
	{
		try
		{
			sleep(12);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon).moveToElement(driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/ul/li[1]/a"))).click().build().perform();
//			action.moveToElement(adminIcon).build().perform();
			sleep(10);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}	
	
	 
	//Navigate to Assign Users
	public boolean NavToAssignUsers ()
	{
		try
		{
			sleep(8);
			
			driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/div/div[3]/table/tbody/tr/td[6]/a[1]/span")).click();
			sleep(8);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
		
	}


// Assigning Users

	public boolean SearchUser (String FieldValue)
	{
		try
		{
				sleep(6);
				WebElement AssingPanelMember = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[1]/div[1]/div[1]/span/label/input"));
				AssingPanelMember.sendKeys(Keys.CONTROL + "a");
				AssingPanelMember.sendKeys(Keys.DELETE);
				AssingPanelMember.sendKeys(FieldValue);
				sleep(4);
				
			   driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr/td/div[1]")).click();
				
		return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}	
	
	
	
	
	public boolean SelectFirstUserFromList ()
	{
		try
		{
			sleep(8);
			driver.findElements(By.xpath("//tr[@ng-dblclick='doubleClickAdd(dataItem)']")).get(0).click();
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


/*	
		 Assign Panel Members - Rohan Roy, Daniel Ziskin, David Rinehart, Ranjeet Devarakonda,
			case "AssignPanelMember":
				// Assign Scribe - Teresa Kauffman, AZAD HOSSAIN
		//	case "AssignScribe":
				//WebElement AssignScribe = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[1]/div[1]/div[1]/span/label/input"));
			//	break;
	// Assign Lead reviewer - David Smith, Robert E Wolfe
		//	case "AssignLeadReviewer":
			//	WebElement AssignLeadReviewer = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[1]/div[1]/div[1]/span/label/input"));
				//break;
	// Assign Panel Official - Michael Little
			//case "AssignPanelOfficial":
			//	WebElement AssignPanelOfficial = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[1]/div[1]/div[1]/span/label/input"));
			//	break;
// Assign  Program Manager - Michael Little (mlittle),  Robert E Wolf
		//	case "AssignProgramManager":
			//	WebElement AssignProgramManager = driver.findElement(By.xpath("//*[@id=\'admin-content-wrapper\']/div/form/ul/li[3]/div[2]/div[1]/div[1]/div[1]/span/label/input"));
	//  Quality Control - Shelby Cook, Jayanthi Tumuluri  // Panel Chair - Michael Goodman // Panle Projection - DC Projector // Reader - Wei Ding // Panel Read Only - George Komar 
	// Associate Admin User - Stacey V. Mays-Smith , George Komar, Marge Cole, Shelby Cook  // Panel Lead - ANN LEGALL 
	
*/

}
