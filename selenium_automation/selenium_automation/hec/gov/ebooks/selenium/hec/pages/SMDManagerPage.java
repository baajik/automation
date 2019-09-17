package gov.ebooks.selenium.hec.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

public class SMDManagerPage extends BasePage{

	public SMDManagerPage(WebDriver driver){
			super(driver, "managerLandingPage", "hec");
	}
	
	public boolean verifyLandingPageForManagers() throws InterruptedException{
		boolean correctlyLoaded = false;
	//	Thread.sleep(2000);
		WebElement adminTools = waitAndFindElement("admin_tools_widget", 20);
		WebElement eAlerts = waitAndFindElement("ealerts_widget", 20);
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("https://nasa-ebooks-qa.amer.reisystems.com/hec_smd_qa/action/Dashboard")
				&& (adminTools != null) && (eAlerts != null)){
			correctlyLoaded = true;
		    }
		return correctlyLoaded;
	}

	public boolean eAlertRosesReview(String rosesRequestNumber) throws InterruptedException{
	//	Thread.sleep(30000);
		System.out.println("Looking for this request number = " + rosesRequestNumber);
			WebElement reviewIcon = waitAndFindElement("non_roses_ealert_line", 100 , rosesRequestNumber);
				
//			if (reviewIcon == null){
//				driver.navigate().refresh();
//			}
//			else{
//			reviewIcon.click();
//			}
			
			reviewIcon.click();

		System.out.println("Eligibility request review page opens to confirm");
		Thread.sleep(1000);
		return true;
	}
	
	public boolean eAlertNonRosesReview(String nonRosesRequestNumber) throws InterruptedException{
	//	Thread.sleep(30000);
		System.out.println("Looking for this request number = " + nonRosesRequestNumber);
			WebElement reviewIcon = waitAndFindElement("non_roses_ealert_line", 100, nonRosesRequestNumber);
			reviewIcon.click();
		System.out.println("Eligibility request review page opens to confirm");
		Thread.sleep(1000);
		return true;
	}
	
	public boolean confirmRequest() throws InterruptedException{
		if(driver.getPageSource().contains("Eligibility Request Review")
				&& driver.getPageSource().contains("Projected Start Date :")
						&& driver.getPageSource().contains("Comments:")){
			Thread.sleep(3000);
			WebElement findText = waitAndFindElement("project_banner");
			Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Retreive Request number from the banner = " + text);
			WebElement reviewComment = findElement("comment_area");
			reviewComment.click();
			reviewComment.sendKeys("Confirmed by eBooks support using automation scripts");
//			WebElement sendEmail = findElement("send_email");
//			sendEmail.click();
			List<WebElement> submitButton = findElements("submit_button");
			submitButton.get(1).click();
	//  	Thread.sleep(200000);
			WebElement notification = waitAndFindElement("notification", 400);
			String text1 = notification.getText();
			System.out.println("Success message after confirm:     " + text1);
			}
		return true;
	}
	
	public boolean eAlertComputingRequestReview() throws InterruptedException{
		Thread.sleep(30000);
	   if(driver.getPageSource().contains("Computing Request Submitted")){
		List<WebElement> reviewIcon = waitAndFindElements("review_icon");
		Thread.sleep(5000);
		reviewIcon.get(0).click();
	   }
		System.out.println("Computing Request Review page");
		Thread.sleep(1000);
		return true;
	}
	
	public boolean allocateComputingRequest() throws InterruptedException{
		if(driver.getPageSource().contains("Computing Request Authorization")
				&& driver.getPageSource().contains("GID ")){
			WebElement findText = waitAndFindElement("project_banner", 100);
			String text = findText.getText();
			System.out.println("Request number from computing request review page: " + text);
			WebElement nasPleiadesSBU = waitAndFindElement("nas_pleiades_sbus", 60);
			nasPleiadesSBU.click();
			nasPleiadesSBU.clear();
			nasPleiadesSBU.sendKeys("345678");			
			WebElement nasEndeavourSBU = waitAndFindElement("nas_endeavour_sbus");
			nasEndeavourSBU.click();
			nasEndeavourSBU.clear();
			nasEndeavourSBU.sendKeys("30000");		
			WebElement nasDiscoverSBU = waitAndFindElement("nccs_discover_sbus");
			nasDiscoverSBU.click();
			nasDiscoverSBU.clear();
			nasDiscoverSBU.sendKeys("50000");			
			WebElement nasPleiadesStorage = waitAndFindElement("nas_pleiades_storage");
			nasPleiadesStorage.click();
			nasPleiadesStorage.clear();
			nasPleiadesStorage.sendKeys("34");			
			WebElement gID = waitAndFindElement("gid");
			gID.click();
			gID.clear();
			gID.sendKeys("s1234/g4567");			
			Select approveStatus = new Select(waitAndFindElement("approval_status"));
			approveStatus.selectByVisibleText("Approved");
			WebElement reviewComment = findElement("comment_area");
			reviewComment.click();
			reviewComment.sendKeys("Approved by eBooks support using automation scripts");
			WebElement sendEmail = findElement("send_email_cr");
			sendEmail.click();
			WebElement submitButton = findElement("submit_cr_review");
			submitButton.click();
			WebElement notification = waitAndFindElement("notification", 400);
			String text1 = notification.getText();
			System.out.println("Success message after computing request is approved:     " + text1);		
		//	Thread.sleep(80000);
		}
		return true;
	}
	
	public void rosesSelection(String requestNumber) throws InterruptedException{
		List<WebElement> retreiveRequest = driver.findElements(By.xpath("//span[@class='action-link-text']"));
		retreiveRequest.get(0).click();		
		WebElement requestNumberInput = driver.findElement(By.xpath("//input[@title='Request Number']"));
		requestNumberInput.click();
		requestNumberInput.sendKeys(requestNumber);		
		WebElement search = driver.findElement(By.id("userSearchSubmit"));
		search.click();
		Thread.sleep(8000);		
		WebElement selectRequest = driver.findElement(By.xpath("//div[@id='availableRequestsGrid']//table[@data-role='selectable']"));
		selectRequest.click();		
	// scrolls to web element(Button)
		WebElement addRequest = driver.findElement(By.id("addSelectedRequest"));
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", addRequest);
		Thread.sleep(3000);
		addRequest.click();
		WebElement select = driver.findElement(By.xpath("//select[@class='hec-admin-select']"));
		select.click();
		List<WebElement> selections = driver.findElements(By.xpath("//select[@class='hec-admin-select']//option"));
		selections.get(1).click();
		WebElement process = driver.findElement(By.id("hecAdminSelectionProcess"));
		process.click();
	//	Thread.sleep(90000);
//		WebDriverWait customWait = new WebDriverWait(driver, 120);
//		WebElement loadingImage = findElement("loading_image");
//		if(loadingImage != null){
//            customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
//      }
		WebElement notification = waitAndFindElement("notification", 300);
		String text = notification.getText();
		System.out.println("Success message after ROSES selection:    " + text);
		Thread.sleep(6000);
		
		WebElement close = waitAndFindElement("view_page_close");
		close.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		//driver.get("https://nasa-ebooks-qa.amer.reisystems.com/hec_smd_qa/action/Dashboard");
		//Thread.sleep(10000);
	}
	
	public boolean eAlertModificationRequestReview() throws InterruptedException{
		Thread.sleep(30000);
	   if(driver.getPageSource().contains("HEC Modification  Request Submitted by")){
		List<WebElement> reviewIcon = waitAndFindElements("review_icon");
		Thread.sleep(5000);
		reviewIcon.get(0).click();
	   }
		System.out.println("Modification Request Review page");
		Thread.sleep(1000);
		return true;
	}
	
	public boolean allocateModificationRequest() throws InterruptedException{
		if(driver.getPageSource().contains("Modification Request Authorization")
				&& driver.getPageSource().contains("GID ")){
	//		Thread.sleep(3000);			
			WebElement findText = waitAndFindElement("project_banner", 30);
	//		Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Request number from modification request review page: " + text);
	//		Thread.sleep(3000);
			WebElement nasPleiadesSBU = waitAndFindElement("nas_pleiades_sbus", 30);
			nasPleiadesSBU.click();
			nasPleiadesSBU.clear();
			nasPleiadesSBU.sendKeys("345678");			
			WebElement nasEndeavourSBU = waitAndFindElement("nas_endeavour_sbus");
			nasEndeavourSBU.click();
			nasEndeavourSBU.clear();
			nasEndeavourSBU.sendKeys("30000");		
			WebElement nasDiscoverSBU = waitAndFindElement("nccs_discover_sbus");
			nasDiscoverSBU.click();
			nasDiscoverSBU.clear();
			nasDiscoverSBU.sendKeys("40000");			
			WebElement nasPleiadesStorage = waitAndFindElement("nas_pleiades_storage");
			nasPleiadesStorage.click();
			nasPleiadesStorage.clear();
			nasPleiadesStorage.sendKeys("34");			
			WebElement gID = waitAndFindElement("gid");
			gID.click();
			gID.clear();
			gID.sendKeys("s1234/g4567");		
			Select approveStatus = new Select(waitAndFindElement("approval_status"));
			approveStatus.selectByVisibleText("Approved");
			WebElement reviewComment = findElement("comment_area");
			reviewComment.click();
			reviewComment.sendKeys("Approved by eBooks support using automation scripts");
			WebElement sendEmail = findElement("send_email_cr");
			sendEmail.click();
			WebElement submitButton = findElement("submit_cr_review");
			submitButton.click();
			
			WebElement notification = waitAndFindElement("notification", 600);
			String text1 = notification.getText();
			System.out.println("Success message after reviewing modification request:     " + text1);
			Thread.sleep(2000);
		}
		return true;
	}
	
}