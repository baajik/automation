package gov.ebooks.selenium.esto_review.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import gov.ebooks.selenium.shared.pages.BasePage;

public class ManageUsers extends BasePage{
	
	public ManageUsers(WebDriver driver){
		super(driver, "manageUsers", "esto_review");
	}
	
public void selectManageUsers() throws InterruptedException{
//		WebElement adminTools = waitAndFindElement("admin_tools", 60);
//		Actions action = new Actions(driver);
//		action.moveToElement(adminTools).perform();
//		action.moveByOffset(1, 1).perform();
//		WebElement manageUsers = waitAndFindElement("manage_users", 60);
//		manageUsers.click();
	
	WebElement manageUsers = findElement("manage_users_navigationbar");
	manageUsers.click();
		Thread.sleep(5000);
//		return true;
	}

public void selectProposalStage() throws InterruptedException{
	WebElement manageProposalStage = findElement("manage_proposal_stage_navigator");
	manageProposalStage.click();
		Thread.sleep(5000);
//		return true;	
}

public void selectManageProposal() throws InterruptedException{
	WebElement manageProposal = findElement("manage_proposal_navigator");
	manageProposal.click();
		Thread.sleep(5000);
}



public void selectManageUser() throws InterruptedException {
	WebElement searchUser = findElement("search_user");
	searchUser.click();
	searchUser.sendKeys("Rohan");
	Thread.sleep(2000);
	new Actions(driver).moveToElement(searchUser,40,35).click().perform();
	Thread.sleep(4000);		
}



	
public void addNewUser(){
		WebElement addNewUser = findElement("add_new_user");
		addNewUser.click();
		WebElement firstName = findElement("first_name");
		firstName.click();
		firstName.sendKeys("Rohan");
		WebElement lastName = findElement("last_name");
		lastName.click();
		lastName.sendKeys("Roy");
		WebElement userEmail = findElement("user_email");
		userEmail.click();
		Random rand = new Random();
		String randomEmail = "rroy" + rand.nextInt(99999999) + "@gmail.com";
		userEmail.sendKeys(randomEmail);		
		WebElement userOrg = findElement("usre_org");
		userOrg.click();
		userOrg.sendKeys("GSFC");
		WebElement userPhone = findElement("user_phone");
		userPhone.click();
		userPhone.sendKeys("7034809100");
		WebElement potentialUserChkBox = findElement("potential_user_chk_box");
		potentialUserChkBox.click();
		WebElement submit = findElement("submit");
		submit.click();
		WebElement notification = waitAndFindElement("notification", 100);
		String text1 = notification.getText();
		System.out.println("Success message for roses eligibility:     " + text1);
	}
	
	public void manageUserAssignProposal() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement assignProposal = findElement("assign_proposal");
		assignProposal.click();
		List<WebElement> selectProposal = findElements("select_proposal");
		selectProposal.get(0).click();
		WebElement addSelect = findElement("add_select");
        jse.executeScript("arguments[0].scrollIntoView();", addSelect);
		addSelect.click();
		WebElement selectRole = findElement("select_role");
		selectRole.click();
		WebElement selectPanelMember = findElement("select_panel_member");
        jse.executeScript("arguments[0].scrollIntoView();", selectPanelMember);
        selectPanelMember.click();
		Thread.sleep(2000);
		WebElement submit = findElement("assign_proposals_submit");
		submit.click();
//		WebElement notification = waitAndFindElement("notification", 300);
//		String text1 = notification.getText();
//		System.out.println("Success message for roses eligibility:     " + text1);
		Thread.sleep(4000);
	}
	
	public void NotifyUsers() throws InterruptedException{
//		WebElement adminTools = waitAndFindElement("admin_tools", 60);
//		Actions action = new Actions(driver);
//		action.moveToElement(adminTools).perform();
//		action.moveByOffset(1, 1).perform();
//		WebElement manageUsers = waitAndFindElement("manage_users", 60);
//		manageUsers.click();	
	WebElement notifyUsers = findElement("notify_users_navigationbar");
	notifyUsers.click();
		Thread.sleep(5000);
	}
	
	public boolean selectNotifyUsers() throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement selectRole = findElement("select_role");
		selectRole.click();
		WebElement selectPanelMember = findElement("select_panel_member");
        selectPanelMember.click();
        Thread.sleep(2000);
        WebElement addSelect = findElement("add_select");
        jse.executeScript("arguments[0].scrollIntoView();", addSelect);
        List<WebElement> selectUserNotify = findElements("select_user_notify");
        selectUserNotify.get(0).click();       
		addSelect.click();
		Thread.sleep(2000);
//		WebElement emailSelf = findElement("emial_self");
//		emailSelf.click();
		WebElement prevewEmail = findElement("prevew_email");
		prevewEmail.click();
		if(driver.getPageSource().contains("Notify Users - Preview Email")){
			WebElement toField = findElement("to_email_field");
			toField.clear();
			toField.sendKeys("nayana.shivalingappa@reisystems.com");
			WebElement ccSelfCheckbox = findElement("cc_self_checkbox");
			ccSelfCheckbox.click();
			WebElement textBody = findElement("text_body");
			textBody.sendKeys("Testing");
			WebElement submitEmail = findElement("submit_email");
			submitEmail.click();
//			WebElement notification = waitAndFindElement("notification", 300);
//			String text1 = notification.getText();
//			System.out.println("Success message for roses eligibility:     " + text1);
			return true;
		}
		else
		{
			return false;
		}
			
			
		}
	
}
