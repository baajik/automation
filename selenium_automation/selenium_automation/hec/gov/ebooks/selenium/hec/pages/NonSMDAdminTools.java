package gov.ebooks.selenium.hec.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class NonSMDAdminTools extends BasePage {

	public NonSMDAdminTools(WebDriver driver) {
		super(driver, "nonSMDAdminTools", "hec");
	}
	
	public boolean adminToolsModifyRequest() throws InterruptedException{
		List<WebElement> adminTools = findElements("admin_tools_tab");
		Actions action = new Actions(driver);
		action.moveToElement(adminTools.get(7)).perform();
		action.moveByOffset(1, 1).perform();		
		List<WebElement> modifyRequest = findElements("admin_tools_tab");
		modifyRequest.get(9).click();		
		Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
		selectSoliciation.selectByVisibleText("ARMD-19");
		Thread.sleep(2000);
		WebElement search = findElement("search");
		search.click();
		Thread.sleep(2000);
		return true;
		}
	
	public boolean adminToolsManageAssignment() throws InterruptedException{
		List<WebElement> adminTools = findElements("admin_tools_tab");
		Actions action = new Actions(driver);
		action.moveToElement(adminTools.get(7)).perform();
		action.moveByOffset(1, 1).perform();	
		List<WebElement> manageAssignment = findElements("admin_tools_tab");
		manageAssignment.get(10).click();		
		Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
		selectSoliciation.selectByVisibleText("ARMD-19");
		Thread.sleep(2000);
		WebElement search = findElement("search");
		search.click();
		Thread.sleep(2000);
		return true;
		}
	
	public boolean adminToolsManageAllocation() throws InterruptedException{
		List<WebElement> adminTools = findElements("admin_tools_tab");
		Actions action = new Actions(driver);
		action.moveToElement(adminTools.get(7)).perform();
		action.moveByOffset(1, 1).perform();		
		List<WebElement> manageAllocation = findElements("admin_tools_tab");
		manageAllocation.get(11).click();		
		Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
		selectSoliciation.selectByVisibleText("ARMD - Aeronautics Research");
		Thread.sleep(2000);
		WebElement search = findElement("search");
		search.click();
		Thread.sleep(2000);
		return true;
		}
	
	public boolean adminToolsAwards() throws InterruptedException{
		List<WebElement> adminTools = findElements("admin_tools_tab");
		Actions action = new Actions(driver);
		action.moveToElement(adminTools.get(7)).perform();
		action.moveByOffset(1, 1).perform();		
		List<WebElement> awards = findElements("admin_tools_tab");
		awards.get(12).click();		
		Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
		selectSoliciation.selectByVisibleText("ARMD-19");
		Thread.sleep(2000);
		WebElement search = findElement("search");
		search.click();
		Thread.sleep(2000);
		return true;
		}
	
	public boolean myAccount() throws InterruptedException{
		List<WebElement> myAccount = findElements("admin_tools_tab");
		Actions action = new Actions(driver);
		action.moveToElement(myAccount.get(0)).perform();
		action.moveByOffset(1, 1).perform();		
		List<WebElement> securityQuestion = findElements("admin_tools_tab");
		securityQuestion.get(3).click();
		WebElement question = driver.findElement(By.name("securityQuestion"));
		question.click();
		question.clear();
		question.sendKeys("favourite sports");
		WebElement answer = driver.findElement(By.name("securityAnswer"));
		answer.click();
		answer.clear();
		answer.sendKeys("Volley ball");
		WebElement saveSecurityInformation = findElement("save_security_information");
		saveSecurityInformation.click();
		WebElement successMessage = waitAndFindElement("success_message", 100);
		if(successMessage == null){
			return false;
		}
		System.out.println("Success message:    " + successMessage.getText());
		return true;
	}
}
