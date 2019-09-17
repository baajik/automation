package gov.ebooks.selenium.esto_review.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;

public class QualityControlPage extends BasePage{
	
	public QualityControlPage(WebDriver driver){
		super(driver, "qualityControlPage", "esto_review");
	}
	
	public boolean toggle() throws InterruptedException {
	//	JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		WebElement proposalToggle = waitAndFindElement("toggle_button", 30);
		proposalToggle.click();
		Thread.sleep(2000);
		return true;
	}

	public boolean qcComments() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
//		WebElement proposalToggle = waitAndFindElement("toggle_button", 30);
//		proposalToggle.click();
		Thread.sleep(3000);
		WebElement qcCommentsLink = waitAndFindElement("qc_comments_link", 30);
        jse.executeScript("arguments[0].scrollIntoView();", qcCommentsLink);

		WebElement viewEvaluation = waitAndFindElement("view_evaluation", 30);
		WebElement myDiscussionNotes = waitAndFindElement("my_discussion_notes", 30);
		Thread.sleep(4000);
		if(viewEvaluation != null && myDiscussionNotes != null && qcCommentsLink != null)
		{
			qcCommentsLink.click();
		}
		return true;
	}
	
	public boolean verifyUpdateQcComments() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Review Summary") 
				&& (driver.getPageSource().contains("Proposal Summary"))){
			WebElement proposalSummary = waitAndFindElement("proposal_summary", 20);
			proposalSummary.clear();
			proposalSummary.click();
			proposalSummary.sendKeys("Test");

			WebElement strength = waitAndFindElement("strength", 20);
	        jse.executeScript("arguments[0].scrollIntoView();", strength);
			strength.clear();
			strength.click();
			strength.sendKeys("Test");
			WebElement weekness = waitAndFindElement("weekness", 20);
			weekness.clear();
			weekness.click();	
			weekness.sendKeys("Test");
			Thread.sleep(2000);
//			This piece is to check whether the score field is not editable
			List<WebElement> scoringInput = findElements("scoring_input");
			List<WebElement> scoringbox = findElements("scoring_input_shell");
			System.out.println("====================" + scoringbox.size() + "======================");
			if(scoringInput.size() > 0){
				return false;
			}else{
			System.out.println("====================" + scoringInput.size() + "=======================");
			}
			Thread.sleep(2000);

			WebElement strength1 = waitAndFindElement("strength1", 20);
	        jse.executeScript("arguments[0].scrollIntoView();", strength1);
			strength1.clear();
			strength1.click();
			strength1.sendKeys("Test");
			WebElement weekness1 = waitAndFindElement("weekness1", 20);
			weekness1.clear();
			weekness1.click();
			weekness1.sendKeys("Test");
			Thread.sleep(2000);

			WebElement strength2 = waitAndFindElement("strength2", 20);
	        jse.executeScript("arguments[0].scrollIntoView();", strength2);
			strength2.clear();
			strength2.click();
			strength2.sendKeys("Test");
			WebElement weekness2 = waitAndFindElement("weekness2", 20);
			weekness2.clear();
			weekness2.click();
			weekness2.sendKeys("Test");
			Thread.sleep(2000);
			WebElement comments = waitAndFindElement("comments", 20);
	        jse.executeScript("arguments[0].scrollIntoView();", comments);
			comments.clear();
			comments.click();
			comments.sendKeys("Test");
			Thread.sleep(2000);
			WebElement internalComments = waitAndFindElement("internal_comments", 20);
	        jse.executeScript("arguments[0].scrollIntoView();", internalComments);
			internalComments.clear();
			internalComments.click();
			internalComments.sendKeys("Lead Reviewer");
			WebElement scribeNotesView = waitAndFindElement("scibe_notes_view_mode", 20);
			String readonly = scribeNotesView.getAttribute("class");
//   		System.out.println("===========================" + readonly + "====================================");
		    if(!readonly.contains("view-mode")){
		    	return false;
		    }
	        jse.executeScript("arguments[0].scrollIntoView();", scribeNotesView);
	        WebElement qcComments = waitAndFindElement("qc_comments_textarea", 20);
	        qcComments.clear();
	        qcComments.click();
	        qcComments.sendKeys("Test QC comments");
	        WebElement checkBox	= waitAndFindElement("check_box_panel_official", 30);
	        checkBox.click();
			WebElement save = waitAndFindElement("save", 30);
			save.click();
			WebElement notification = waitAndFindElement("notification1", 100);
			String text1 = notification.getText();
			System.out.println("Success message :     " + text1);
			Thread.sleep(60000);
			WebElement latestVersion = waitAndFindElement("latest_version", 80);
			String version = latestVersion.getText();
			System.out.println("Latest version:   "+ version);
			if(!version.contains("Panel")){
				return false;
			}
			Thread.sleep(7000);
			WebElement close = waitAndFindElement("close", 30);
			close.click();
			Thread.sleep(4000);					
		}	
		return true;			
	}
	
	public boolean verifyActiveStage(){
			WebElement activeStage = findElement("active_stage");
			String stage = activeStage.getText();
			System.out.println("Next Stage:   "+ stage);
			if(!stage.contains("Panel Official")){
			return false;
		}
		return true;
	}
	
	
}
