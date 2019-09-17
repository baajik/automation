package gov.ebooks.selenium.hec.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class NonSMDReports extends BasePage {

		public NonSMDReports(WebDriver driver) {
			super(driver, "nonSMDReports", "hec");
		}
		
		public boolean reportsDownload() throws InterruptedException{
			Thread.sleep(4000);
			List<WebElement> reportTab = findElements("report_tab");
			Actions action = new Actions(driver);
			action.moveToElement(reportTab.get(16)).perform();
			action.moveByOffset(1, 1).perform();
			Thread.sleep(4000);
			List<WebElement> downloadToSpreadsheet = findElements("report_tab");
			downloadToSpreadsheet.get(17).click();			
			Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
			selectSoliciation.selectByVisibleText("ARMD-19");
			Thread.sleep(2000);
			WebElement contactDetails = waitAndFindElement("contact_details", 30);
			contactDetails.click();
			WebElement reportStatus = waitAndFindElement("report_status");
			reportStatus.click();
			WebElement summOfRequirements = waitAndFindElement("summ_of_requirements");
			summOfRequirements.click();
			WebElement allocationBinder = waitAndFindElement("allocation_binder");
			allocationBinder.click();
			Select sortResults = new Select(driver.findElement(By.id("sortBy")));
			sortResults.selectByVisibleText("Award Number");
			WebElement exportToSpreadsheet = waitAndFindElement("export_spreadsheet");
			exportToSpreadsheet.click();
			Thread.sleep(60000);
			return true;
		}
		
		public boolean reportsSubmissionDetails() throws InterruptedException{
			List<WebElement> reportTab = findElements("report_tab");
			Actions action = new Actions(driver);
			action.moveToElement(reportTab.get(16)).perform();
			action.moveByOffset(1, 1).perform();			
			List<WebElement> submissionDetails = findElements("report_tab");
			submissionDetails.get(18).click();
			Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
			selectSoliciation.selectByVisibleText("ARMD-19");
			Thread.sleep(5000);
			WebElement search = waitAndFindElement("search");
			search.click();
			List<WebElement> viewPrintRequestDetails = driver.findElements(By.linkText("View/Print Request Details"));
			viewPrintRequestDetails.get(0).click();
			String parentWindow= driver.getWindowHandle();
			for(String curWindow : driver.getWindowHandles()){
			    driver.switchTo().window(curWindow);
			}
			WebElement title = waitAndFindElement("container_title", 30);
			System.out.println("title of the current window:  " + title.getText());
			WebElement close = driver.findElement(By.linkText("CLOSE"));
			close.click();
			driver.switchTo().window(parentWindow);
			Thread.sleep(4000);
			WebElement title2 = waitAndFindElement("container_title", 30);
			System.out.println("title of the parent window:  "+ title2.getText());
			return true;
		}
		
		public boolean reportsAllocationBinder() throws InterruptedException{
			List<WebElement> reportTab = findElements("report_tab");
			Actions action = new Actions(driver);
			action.moveToElement(reportTab.get(16)).perform();
			action.moveByOffset(1, 1).perform();
			List<WebElement> allocationBinder = findElements("report_tab");
			allocationBinder.get(19).click();
			Select selectSoliciation = new Select(driver.findElement(By.name("solGroup")));
			selectSoliciation.selectByVisibleText("ARMD-19");
			Thread.sleep(2000);
			WebElement search = findElement("search");
			search.click();
			List<WebElement> viewPrintRequestDetails = driver.findElements(By.linkText("View/Print Request Details"));
			viewPrintRequestDetails.get(0).click();
			String parentWindow= driver.getWindowHandle();
			for(String curWindow : driver.getWindowHandles()){
			    driver.switchTo().window(curWindow);
			}
			WebElement title = waitAndFindElement("container_title", 30);
			System.out.println("title of the current window:  " + title.getText());
			WebElement close = driver.findElement(By.linkText("CLOSE"));
			close.click();
			driver.switchTo().window(parentWindow);
			Thread.sleep(4000);
			WebElement title2 = waitAndFindElement("container_title", 30);
			System.out.println("title of the current window:  " + title2.getText());
			return true;
		}
		
		public boolean reportsPortfolio() throws InterruptedException{
			List<WebElement> reportTab = findElements("report_tab");
			Actions action = new Actions(driver);
			action.moveToElement(reportTab.get(16)).perform();
			action.moveByOffset(1, 1).perform();
			List<WebElement> portfolio = findElements("report_tab");
			portfolio.get(20).click();
			Thread.sleep(6000);
			return true;
		}
}

