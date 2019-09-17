package gov.ebooks.selenium.esto_review.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;

public class ManageProposal extends BasePage{
	
	public ManageProposal(WebDriver driver){
		super(driver, "manageProposal", "esto_review");
	}
	
//	public void loadLoginPage(){
//		driver.get("https://nasa-ebooks-qa.amer.reisystems.com/hec_qa/computing/");
//	}
	
	public void selectManageProposal() throws InterruptedException{
//		WebElement userName = findElement("username_field");
//		WebElement passWord = findElement("password_field");
//		WebElement loginButton = findElement("login_button");
			Thread.sleep(15000);
			WebElement adminTools = waitAndFindElement("admin_tools", 60);
			Actions action = new Actions(driver);
			action.moveToElement(adminTools).perform();
			action.moveByOffset(1, 1).perform();
			Thread.sleep(3000);
			WebElement manageProposal = waitAndFindElement("manage_proposal", 60);
			manageProposal.click();
	    	Thread.sleep(2000);
	//		return true;
		}
	
	public boolean selectProposal() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(4000);
		WebElement searchProposal = findElement("search_proposal");
		searchProposal.click();
		searchProposal.sendKeys("16-AIST16-0001");
		Thread.sleep(2000);
		new Actions(driver).moveToElement(searchProposal,40,35).click().perform();
		Thread.sleep(4000);	
		
		WebElement expandProposal = findElement("expand_proposal");
		expandProposal.click();
		WebElement assignUsers = findElement("assign_users");
		assignUsers.click();
//		WebElement recalculateMailIn = findElement("recalculate_mail_in");		
		WebElement searchUser = findElement("search_user");
		searchUser.click();
		searchUser.sendKeys("Vikas");
		Thread.sleep(2000);
        WebElement selectUser = findElement("select_user");
        selectUser.click();
        WebElement addSelect = findElement("add_select");
        jse.executeScript("arguments[0].scrollIntoView();", addSelect);
        addSelect.click(); 
        Thread.sleep(2000);
        WebElement selectRole = findElement("select_role");
        selectRole.click();
        WebElement selectPanelMember = findElement("select_panel_member");
        selectPanelMember.click();
        Thread.sleep(1000);       
        WebElement submit =  findElement("submit");
        submit.click();
//      WebElement notification = waitAndFindElement("notification", 20);
//		String text1 = notification.getText();
//		System.out.println("Success message for roses eligibility:     " + text1);
    	return true;
	}
	
	public boolean checkWebSocketStatus(){
		WebElement websocketStatus =  waitAndFindElement("websocket_status" , 30);
		if(websocketStatus.getAttribute("class").equals("connected")){     // == connected) {
			return true;
	}		
			return false;
		
	}
	
	

}
