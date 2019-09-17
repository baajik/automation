package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;

public class MyDiscussionNotesPage extends BasePage{
	
	public MyDiscussionNotesPage(WebDriver driver){
		super(driver, "myDiscussionNotesPage", "esto_review");
	}

	public void myDiscussionNotes() throws InterruptedException {
		WebElement myDiscussionNotes = waitAndFindElement("my_discussion_notes", 30);
		myDiscussionNotes.click();
		Thread.sleep(2000);
		WebElement discussionNotes = waitAndFindElement("discussion_notes", 30);
		discussionNotes.click();
		discussionNotes.sendKeys("Test");
		WebElement saveNotes = findElement("save_notes");
		saveNotes.click();
//		WebElement notification = waitAndFindElement("notification", 20);
//		String text1 = notification.getText();
//		System.out.println("Success message for roses eligibility:     " + text1);
	}
	
}
