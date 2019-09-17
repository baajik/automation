package gov.ebooks.selenium.esto_review.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;

public class ScribePage extends BasePage{
	
	public ScribePage(WebDriver driver){
		super(driver, "scribePage", "esto_review");
	}
	
public boolean scribeNotesLink() throws InterruptedException {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	Thread.sleep(10000);
	WebElement proposalToggle = waitAndFindElement("toggle_button", 30);
	proposalToggle.click();
	Thread.sleep(2000);
	WebElement scibeNotesLink = waitAndFindElement("scribe_notes_link", 30);
    jse.executeScript("arguments[0].scrollIntoView();", scibeNotesLink);
	WebElement myDiscussionNotes = waitAndFindElement("my_discussion_notes", 30);
	Thread.sleep(4000);
	if(myDiscussionNotes != null && scibeNotesLink != null)
	{
		scibeNotesLink.click();
	}
	return true;
	}

	public boolean appendScribeMessage() throws InterruptedException{
	//	JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(3000);
		WebElement discardButton = waitAndFindElement("discard_button", 10);
		if(discardButton != null){
			discardButton.click();
		}
	    WebElement scribeNotes = waitAndFindElement("scribe_notes", 30);
		WebElement scribeMessages = waitAndFindElement("scribe_messages", 30);
		scribeMessages.click();
		List<WebElement> appendScribeMessage1 = findElements("append_scribe_notes");
		appendScribeMessage1.get(0).click();
//		List<WebElement> appendScribeMessage2 = findElements("append_scribe_notes");
//		appendScribeMessage2.get(1).click();
		Thread.sleep(2000);
		scribeNotes.click();
		WebElement scribeNotesTextarea = waitAndFindElement("scribe_notes_textarea", 30);
		String notes = scribeNotesTextarea.getText();
		System.out.println("scribe message   " + notes);
		Thread.sleep(3000);
		WebElement close = waitAndFindElement("close", 80);
		close.click();
		Thread.sleep(4000);
		return true;
	}
	
public boolean verifyScibeNotes() throws InterruptedException {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	Thread.sleep(3000);
//	WebElement discardButton = waitAndFindElement("discard_button", 10);
//	if(discardButton != null){
//		discardButton.click();
//	}
	WebElement scribeNotes = waitAndFindElement("scribe_notes", 30);
	WebElement scribeMessages = waitAndFindElement("scribe_messages", 30);
	WebElement scribeNotesTextarea = waitAndFindElement("scribe_notes_textarea", 30);
	if(scribeNotes != null && scribeMessages != null){
		scribeNotesTextarea.clear();
		scribeNotesTextarea.sendKeys("Enter Notes through automation scritps");
	}
	WebElement proposalSummary = waitAndFindElement("proposal_summary", 30);
    jse.executeScript("arguments[0].scrollIntoView();", proposalSummary);
	WebElement factor2 = waitAndFindElement("factor2", 30);
    jse.executeScript("arguments[0].scrollIntoView();", factor2);
    WebElement internalComments = waitAndFindElement("internal_comments", 20);
    jse.executeScript("arguments[0].scrollIntoView();", internalComments);
    WebElement checkBox	= waitAndFindElement("check_box_lead_reviewer", 30);
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
	if(!version.contains("Lead")){
		return false;
	}
	Thread.sleep(8000);
	WebElement close = waitAndFindElement("close", 80);
	close.click();
	Thread.sleep(4000);
    
    
	return true;
	}

	public boolean verifyActiveStage(){
		WebElement activeStage = findElement("active_stage");
		String stage = activeStage.getText();
		System.out.println("Next Stage:   "+ stage);
		if(!stage.contains("Lead Reviewer")){
			return false;
		}
		return true;
	}
	
	public boolean sendScribeMessage() throws InterruptedException{
		Thread.sleep(10000);
		WebElement proposalToggle = waitAndFindElement("toggle_button", 30);
		proposalToggle.click();
		Thread.sleep(2000);
		WebElement sendScribeMessageLink = findElement("send_scribe_message");
		sendScribeMessageLink.click();
		WebElement cancelButton = findElement("button");

		WebElement popUpWindowHeader = findElement("window_header");
		String header = popUpWindowHeader.getText();
		System.out.println("Pop up window header:     "     + header);
		if(!header.contains("Message to Scribe") && cancelButton == null){
			return false;
		}
		WebElement scribeMessage = findElement("message_text_area");
		scribeMessage.click();
		scribeMessage.sendKeys("Automation scripts");
		WebElement submitMessage = findElement("submit_message");
		submitMessage.click();
		WebElement successMessage = findElement("success_message");
		String succMessage = successMessage.getText();
		if(succMessage.contains("Your scribe message was successfully sent")){
			WebElement okayButton = findElement("button");
			okayButton.click();
			Thread.sleep(2000);
		}		
		return true;
	}
}
