package gov.ebooks.selenium.esto_review.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;

public class ViewEvaluationPage extends BasePage{
	
	public ViewEvaluationPage(WebDriver driver){
		super(driver, "viewEvaluationPage", "esto_review");
	}

	public boolean viewEvaluation() throws InterruptedException {
		WebElement viewEvaluation = waitAndFindElement("view_evaluation", 30);
		viewEvaluation.click();
		Thread.sleep(2000);
		List<WebElement> scoringInput = findElements("scoring_input");
		List<WebElement> scoringbox = findElements("scoring_input_shell");
		System.out.println("===========================" + scoringbox.size() + "====================================");
		if(scoringInput.size() > 0){
			return false;
		}else{
		System.out.println("===========================" + scoringInput.size() +  "====================================");
		}
		Thread.sleep(2000);
		WebElement scribeNotesView = waitAndFindElement("scibe_notes_view_mode", 20);
		String readonly = scribeNotesView.getAttribute("class");
		System.out.println("===========================" + readonly + "====================================");
	    if(!readonly.contains("view-mode")){
	    	return false;
	    }
		WebElement close = waitAndFindElement("close", 80);
		close.click();
		Thread.sleep(4000);
		return true;
	}
	
}
