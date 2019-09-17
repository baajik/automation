package gov.ebooks.selenium.esto_review.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import gov.ebooks.selenium.shared.pages.BasePage;

public class Scoring_SuperUser_ScoringEventPage extends BasePage{
	
	
	public Scoring_SuperUser_ScoringEventPage(WebDriver driver){
		super(driver, "scoring_SuperUser_ScoringEvent"
				+ "", "esto_review");
	}

	public boolean searchProposal(String fieldvalue) throws InterruptedException{
			Thread.sleep(10000);
			WebElement searchProject = waitAndFindElement("search_field", 30);
			searchProject.click();
			searchProject.sendKeys(fieldvalue);
			Thread.sleep(20000);
	//		new Actions(driver).moveToElement(searchProject.get(1),40,35).click().perform();
			searchProject.sendKeys(Keys.RETURN);		
		return true;
	}
	
	public boolean panelScoringOverview() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(10000);
		WebElement proposalToggle = waitAndFindElement("toggle_button", 30);
		proposalToggle.click();
		Thread.sleep(2000);
		WebElement scrollToMailInStatistics = driver.findElement(By.xpath("//div[@class='proposal-statistics ng-scope']"));
		WebElement panelScoringOverview = waitAndFindElement("panel_scoring_overview", 30);
		jse.executeScript("arguments[0].scrollIntoView();", scrollToMailInStatistics);
		WebElement viewEvaluation = waitAndFindElement("view_evaluation", 30);
		WebElement myDiscussionNotes = waitAndFindElement("my_discussion_notes", 30);
		WebElement scribeNotes	= waitAndFindElement("scribe_notes", 30);
		Thread.sleep(4000);
		if(viewEvaluation != null && myDiscussionNotes != null 
				&& panelScoringOverview != null && scribeNotes != null)
		{
			panelScoringOverview.click();
		}
		return true;
	}
	
	public boolean toggle() throws InterruptedException {
		Thread.sleep(10000);
		WebElement proposalToggle = waitAndFindElement("toggle_button", 30);
		proposalToggle.click();
		Thread.sleep(4000);
		return true;
	} 
 

	
	

	public boolean verifyPanelStartScoring() throws InterruptedException {
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Average Score: ")
				&& (driver.getPageSource().contains("Variance: ")
						&& (driver.getPageSource().contains("Standard Deviation: ")
								&& (driver.getPageSource().contains("Adjectival Rating: ")
										&& driver.getPageSource().contains("Panel Scoring")))));
										
		{
			WebElement startScoringButton = waitAndFindElement("start_scoring_button", 30);
			startScoringButton.click();
		}
		
			return true;
		}
	
	
	public boolean verifyPanelEndScoring() throws InterruptedException {
			WebElement endScoringButton = waitAndFindElement("stop_scoring_button", 30);
			endScoringButton.click();
//			WebElement close = waitAndFindElement("close", 80);
//			close.click();
			Thread.sleep(4000);
			return true;
		}
	
	public boolean verifyScoring() throws InterruptedException {
		WebElement panelScore = waitAndFindElement("panel_score", 30);
		if(panelScore.getText().contains("XXX")){
		System.out.println("XXX score" + panelScore);
		}
			return true;
	}
	
	public boolean verifyUsersInputScore(int user1Score, int user2Score){
		List<WebElement> panelScore = findElements("panel_score"); 
		String userScoresHTML = panelScore.get(1).getAttribute("innerHTML");
		System.out.println("Scores :     " + userScoresHTML);
		if(userScoresHTML.contains("Greg Kopp - " + user1Score) &&
			userScoresHTML.contains("Brian J Drouin - " + user2Score)){
			return true;
		}
		return false;
	}	
	
	public boolean verifyUsersAverageScore(double expectedScore){		
			List<WebElement> averageScore =  findElements("average_score");
			System.out.println("Expected Score   "+ expectedScore);
			if(averageScore == null || averageScore.isEmpty()){
				return false;
			}
			String actualAverageValue = averageScore.get(0).getText();
			System.out.println("Actual average value: =     " + actualAverageValue);
			if(Double.toString(expectedScore).contains(actualAverageValue)){		
				return true;
			}
			return false;
	}
	
	public boolean verifyUsersVarianceScore(double expectedVariance){
		String varianceString = "Variance: " + Double.toString(expectedVariance);
		if(expectedVariance == 0){
			varianceString = "Variance: N/A";
		}
			List<WebElement> varianceValue =  waitAndFindElements("variance_value", 30);
			System.out.println("Expected variance    " + expectedVariance);
			String actualVarianceValue = varianceValue.get(1).getText();
			System.out.println("Actual variance value: =     " + actualVarianceValue);
			if(varianceString.contains(actualVarianceValue)){		
	//		if(actualVarianceValue.contains(Double.toString(expectedVariance))){
				return true;
			}
			return false;
		}
}
