package gov.ebooks.selenium.hec.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import gov.ebooks.selenium.shared.pages.BasePage;

public class SMDPage extends BasePage{
	
	private String rosesRequestNumber;
	private String nonRosesRequestNumber;
	
		public SMDPage(WebDriver driver){
			super(driver, "smdPage", "hec");
			setRosesRequestNumber("");
			setNonRosesRequestNumber("");
		}
	
		public boolean verifySMDPage(){
			boolean correctlyLoaded = false;	
			
			WebElement computingRequest = findElement("computing_request");
			WebElement startNewRequest = findElement("start_new_request");
			if (driver.getCurrentUrl().contains("https://nasa-ebooks-qa.amer.reisystems.com/hec_smd_qa/action/Dashboard")
			&& (computingRequest != null) && (startNewRequest != null)) {
				correctlyLoaded = true;			
				}
			return correctlyLoaded;
		 }
	
		public boolean startNewRequest() throws InterruptedException{
			WebElement startNewRequest = waitAndFindElement("start_new_request", 50);
			startNewRequest.click();
			Thread.sleep(2000);
			WebElement requestForm = waitAndFindElement("request_form", 50);
			if(requestForm == null){
				return false;
			}
		   WebElement roses = findElement("roses");
		   roses.click();
		   WebElement continueButton = findElement("submit_request");
		   continueButton.click();
			Thread.sleep(2000);
			return true;
		}
		
		public boolean createNewRosesEligibilityRequest() throws InterruptedException{
			Thread.sleep(2000);
			WebElement eligibilityRequestForm = findElement("eligibility_request_form");
			WebElement roses = findElement("erf_roses");
			WebElement rosesYear = findElement("roses_year");
			if(eligibilityRequestForm == null || rosesYear == null || !roses.isSelected()){
				return false;
			}			
			WebElement projectTitle = findElement("project_title");
			projectTitle.sendKeys("Test ROSES project");
			WebElement rosesYear1 = findElement("roses_year");
			rosesYear1.click();
			WebElement year = findElement("select_roses_year");
			year.click();
			WebElement division	= findElement("division");
			division.click();
			WebElement selectDivision	= waitAndFindElement("select_division");
			selectDivision.click();
			Thread.sleep(3000);
			WebElement programElement = waitAndFindElement("program_element");
			programElement.click();
			WebElement selectProgramElement = waitAndFindElement("program_element_data");
			selectProgramElement.click();
			List<WebElement> solicitationName = waitAndFindElements("solicitation_name");
			solicitationName.get(0).click();
			WebElement selectSolicitationName = waitAndFindElement("select_soliciation_name", 20);
			selectSolicitationName.click();
			List<WebElement> solicitationNumber = waitAndFindElements("solicitation_name");
			solicitationNumber.get(1).click();
			WebElement selectSolicitationNumber = waitAndFindElement("select_solicitation_number");
			selectSolicitationNumber.click();		
			/*
			 * Alternative method to choose the drop downs for eligibility request using 'for each' loop
			 * This will get the list of all the drop downs and select the last option from the menu.
			 */
//			List<WebElement> rosesDropDowns	= waitAndFindElements("roses_drop_down");
//			
//			for(WebElement dropDown: rosesDropDowns){
//				dropDown.click();
//				String id = dropDown.getAttribute("aria-owns");
//				List<WebElement> dropdownList = driver.findElements(By.xpath("//ul[@id='"+id +"']//li"));
//				dropdownList.get(dropdownList.size() -1).click();
//			}			
			WebElement coI = findElement("add_co_i");
			coI.click();
			WebElement coiFirstName = findElement("coi_first_name");
			coiFirstName.sendKeys("Test");
			WebElement coiLastName = findElement("coi_last_name");
			coiLastName.sendKeys("User");
			WebElement coiEmail = findElement("coi_email");
			coiEmail.sendKeys("tuser1@test.com");
			WebElement coiInstitution = findElement("coi_institution");
			coiInstitution.sendKeys("REI");
			WebElement coiPhoneNumber = findElement("coi_phone_number");
			coiPhoneNumber.sendKeys("7034809100");
			Thread.sleep(2000);
			WebElement organizationType = waitAndFindElement("organization_type");
			organizationType.click();
			WebElement organizationTypeData = waitAndFindElement("organization_type_data");
			organizationTypeData.click();		
			// scrolls to web element(Button)
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    WebElement projectedStartDate = findElement("start_date_calendar");
			jse.executeScript("arguments[0].scrollIntoView();", projectedStartDate);
			Thread.sleep(3000);
			projectedStartDate.click();
			WebElement selectProjectedStartDate = findElement("select_start_date");
			selectProjectedStartDate.click();
			WebElement popMonths = waitAndFindElement("pop_months");
			popMonths.sendKeys("24");
			Thread.sleep(1000);
			WebElement sbuRequested = waitAndFindElement("sbu_value_requested");
			sbuRequested.sendKeys("250000");
			WebElement storageRequested = findElement("storage_value_requested");
			storageRequested.sendKeys("25");
			WebElement requestJustification = findElement("justification");
			requestJustification.sendKeys("Automation Testing");
			List<WebElement> submitRequest = findElements("submit_eligibility_request");
			submitRequest.get(1).click();
			WebElement notification = waitAndFindElement("notification", 300);
			String text1 = notification.getText();
			System.out.println("Success message for roses eligibility:     " + text1);
		//	Thread.sleep(130000);
			List<WebElement> bannerSpans = waitAndFindElements("project_banner_eligibilty", 300);
		//	Thread.sleep(2000);
			String text = bannerSpans.get(1).getText();
			System.out.println("Retreive the request number from eligibility request view page:  "  + text);
			rosesRequestNumber = text;
			System.out.println("Roses Request Number :  " + rosesRequestNumber);
			Thread.sleep(6000);
			WebElement close = waitAndFindElement("view_page_close");
			close.click();
			Thread.sleep(3000);
			return true;
		}
		
		public boolean startNewNONROSESRequest() throws InterruptedException{
			WebElement startNewRequest = findElement("start_new_request");
			startNewRequest.click();
			Thread.sleep(2000);
			WebElement requestForm = findElement("request_form");
			if(requestForm == null){
				return false;
			}
		   WebElement nonRoses = findElement("non_roses");
		   nonRoses.click();
		   WebElement continueButton = findElement("submit_request");
		   continueButton.click();
			Thread.sleep(2000);
			return true;
		    }
		
		public boolean createNewNONRosesEligibilityRequest() throws InterruptedException{		
			WebElement eligibilityRequestForm = findElement("eligibility_request_form");
			WebElement nonRoses = findElement("erf_non_roses");
			if(eligibilityRequestForm == null || !nonRoses.isSelected()){
				return false;
			}
			WebElement projectTitle = findElement("project_title");
			projectTitle.sendKeys("Test NON-ROSES project");
			Thread.sleep(2000);
//			WebElement division	= waitAndFindElement("division");
//			division.click();
//			Thread.sleep(10000);
//			WebElement selectDivision = waitAndFindElement("select_division");
//			selectDivision.click();
			/*
			 * Alternative method to choose the drop downs for eligibility request using 'for each' loop
			 * This will get the list of all the drop downs and select the last option from the menu.
			 */
			List<WebElement> nonRosesDropDowns	= waitAndFindElements("roses_drop_down");
			for(WebElement dropDown: nonRosesDropDowns){
				dropDown.click();
				String id = dropDown.getAttribute("aria-owns");
				List<WebElement> dropdownList = driver.findElements(By.xpath("//ul[@id='"+id +"']//li"));
				dropdownList.get(dropdownList.size() -1).click();
				Thread.sleep(2000);
			}
			
			WebElement coI = findElement("add_co_i");
			coI.click();
			WebElement coiFirstName = findElement("coi_first_name");
			coiFirstName.sendKeys("Test");
			WebElement coiLastName = findElement("coi_last_name");
			coiLastName.sendKeys("User");
			WebElement coiEmail = findElement("coi_email");
			coiEmail.sendKeys("tuser1@test.com");
			WebElement coiInstitution = findElement("coi_institution");
			coiInstitution.sendKeys("REI");
			WebElement coiPhoneNumber = findElement("coi_phone_number");
			coiPhoneNumber.sendKeys("7034809100");
			Thread.sleep(2000);
			// scrolls to web element(Button)
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
			WebElement organizationTypeData = findElement("organization_type_data");
			jse.executeScript("arguments[0].scrollIntoView();", organizationTypeData);
		    WebElement projectedStartDate = findElement("start_date_calendar");
			projectedStartDate.click();
			WebElement selectProjectedStartDate = findElement("select_start_date");
			selectProjectedStartDate.click();
			Thread.sleep(2000);
			WebElement popMonths = findElement("pop_months");
			popMonths.sendKeys("30");
			Thread.sleep(1000);
			WebElement sbuRequested = findElement("sbu_value_requested");
			sbuRequested.sendKeys("350000");
			WebElement storageRequested = findElement("storage_value_requested");
			storageRequested.sendKeys("35");
			WebElement requestJustification = findElement("justification");
			requestJustification.sendKeys("Automation Testing");
			List<WebElement> submitRequest = findElements("submit_eligibility_request");
			submitRequest.get(1).click();
			WebElement notification = waitAndFindElement("notification", 300);
			String text1 = notification.getText();
			System.out.println("Success message for non-roses eligibility:     " + text1);
			//Thread.sleep(100000);
			List<WebElement> bannerSpans = waitAndFindElements("project_banner_eligibilty", 100);
			Thread.sleep(2000);
			String text = bannerSpans.get(1).getText();
			System.out.println("Retreive the request number from eligibility request view page:  " + text);
			nonRosesRequestNumber = text;
			System.out.println("NonRoses Request Number :  " + nonRosesRequestNumber);
			Thread.sleep(5000);
			WebElement close = waitAndFindElement("view_page_close");
			close.click();
			Thread.sleep(4000);
			return true;
		}	
		
		public void logout() throws InterruptedException{
			WebElement userName = waitAndFindElement("user_name", 60);
			Actions action = new Actions(driver);
			action.moveToElement(userName).perform();
			action.moveByOffset(1, 1).perform();
			WebElement logout = waitAndFindElement("logout", 60);
			logout.click();
			Thread.sleep(5000);
		}
		
		public void eligiblityRequestROSESValidation() throws InterruptedException{
			
			// scrolls to web element(Button)
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    WebElement projectedStartDate = findElement("start_date_calendar");
			jse.executeScript("arguments[0].scrollIntoView();", projectedStartDate);
			List<WebElement> submitRequest = findElements("submit_eligibility_request");
			submitRequest.get(1).click();
			
			boolean error = (driver.getPageSource().contains("Computing Request Title is required") 
					&& driver.getPageSource().contains("Roses Year is required") 
					&& driver.getPageSource().contains("SMD Division is required") 
					&& driver.getPageSource().contains("Program Element is required") 
					&& driver.getPageSource().contains("Solicitation Number-Year is required") 
					&& driver.getPageSource().contains("Solicitation Number is required") 
					&& driver.getPageSource().contains("Organization Type is required") 
					&& driver.getPageSource().contains("Projected Start Date is required.") 
					&& driver.getPageSource().contains("Period of Performance must be a whole number between 1 and 120 months") 
					&& driver.getPageSource().contains("SBUs is required for at least one year.") 
					&& driver.getPageSource().contains("Justification is required"));
			if(error == true)
			  	{
					System.out.println("True");
				}
			else 
				{
				 	System.out.println("False");
				}
			Thread.sleep(5000);
			WebElement close = waitAndFindElement("view_page_close");
			close.click();
}
		
		public void eligiblityRequestNonROSESValidation() throws InterruptedException{
			// scrolls to web element(Button)
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    WebElement projectedStartDate = findElement("start_date_calendar");
			jse.executeScript("arguments[0].scrollIntoView();", projectedStartDate);
			List<WebElement> submitRequest = findElements("submit_eligibility_request");
			submitRequest.get(1).click();
			//form//span[@class='fieldError'] -- 
			boolean error = (driver.getPageSource().contains("Computing Request Title is required") 
					&& driver.getPageSource().contains("SMD Division is required") 
					&& driver.getPageSource().contains("Funding Manager is required") 
					&& driver.getPageSource().contains("Organization Type is required") 
					&& driver.getPageSource().contains("Projected Start Date is required.") 
					&& driver.getPageSource().contains("Period of Performance must be a whole number between 1 and 120 months") 
					&& driver.getPageSource().contains("SBUs is required for at least one year.") 
					&& driver.getPageSource().contains("Justification is required"));
			if(error == true)
			  	{
					System.out.println("True");
				}
			else 
				{
				 	System.out.println("False");
				}
			Thread.sleep(5000);
			WebElement close = waitAndFindElement("view_page_close");
			close.click();
}
		
		public String getRosesRequestNumber() {
			return rosesRequestNumber;
		}

		public void setRosesRequestNumber(String rosesRequestNumber) {
			this.rosesRequestNumber = rosesRequestNumber;
		}

		public String getNonRosesRequestNumber() {
			return nonRosesRequestNumber;
		}

		public void setNonRosesRequestNumber(String nonRosesRequestNumber) {
			this.nonRosesRequestNumber = nonRosesRequestNumber;
		}
}