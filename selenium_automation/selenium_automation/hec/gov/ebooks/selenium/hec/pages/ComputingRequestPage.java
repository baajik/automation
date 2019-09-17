package gov.ebooks.selenium.hec.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.ebooks.selenium.shared.pages.BasePage;

public class ComputingRequestPage extends BasePage{
	
	private String rosesRequestNumber;
	private String nonRosesRequestNumber;
	private String crRequestNumber;
	
	public ComputingRequestPage(WebDriver driver){
		super(driver, "computingrequestPage", "hec");
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

		public boolean submitCoverSheet() throws InterruptedException{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			WebElement requestTitle = waitAndFindElement("cr_request_title");
			crRequestNumber = requestTitle.getText();
			jse.executeScript("arguments[0].scrollIntoView();", requestTitle);
			System.out.println(crRequestNumber);
			WebElement coverSheet = waitAndFindElement("cr_cover_sheet", 30, crRequestNumber);
			Thread.sleep(2000);
			coverSheet.click();
			Thread.sleep(2000);		
			WebElement findText = waitAndFindElement("project_banner", 25);
			String text = findText.getText();
			System.out.println("Request number from the coversheet banner:  " + text);
			WebDriverWait customWait = new WebDriverWait(driver, 60);
			WebElement loadingImage = findElement("loading_image");
            if(loadingImage != null){
                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
            }
			WebElement projectedEndDate = findElement("projected_end_date");
			jse.executeScript("arguments[0].scrollIntoView();", projectedEndDate);
			Thread.sleep(3000);
			WebElement preferredLocation = findElement("preferred_location");
			preferredLocation.click();
			WebElement preferredLocationData = findElement("preferred_location_data");
			preferredLocationData.click();
			WebElement keyPhrases = findElement("key_phrases");
			keyPhrases.click();
			keyPhrases.sendKeys("Automation");
			WebElement nasaContract = waitAndFindElement("nasa_contract_select", 30);
			nasaContract.click();
			WebElement nasaContractValue = findElement("nasa_contract_text");
			nasaContractValue.click();
			nasaContractValue.sendKeys("NXWQSDHEC");
			Thread.sleep(2000);
			WebElement abstractValue = findElement("abstract");
			abstractValue.click();
			abstractValue.sendKeys("HEC Automation");	
			jse.executeScript("arguments[0].scrollIntoView();", projectedEndDate);
			List<WebElement> SubmitCoverSheet = findElements("submit_cover_sheet");
			SubmitCoverSheet.get(0).click();
			WebElement notification = waitAndFindElement("notification", 300);
			String text1 = notification.getText();
			System.out.println("Success message for submitting coversheet:     " + text1);
			Thread.sleep(6000);
			List<WebElement> closePage = findElements("view_page_close");
			closePage.get(1).click();
			Thread.sleep(3000);
			return true;
		}

		public boolean submitQuadChart(String requestNumber) throws InterruptedException{
			WebElement quadChart = waitAndFindElement("cr_quad_chart", 30, requestNumber);
			quadChart.click();
			WebElement findText = waitAndFindElement("project_banner", 30);
			String text = findText.getText();
			System.out.println("Request number from the quad chart banner:  " + text);
			Thread.sleep(5000);
			WebElement objectiveUsage = waitAndFindElement("obj_of_usage");
			objectiveUsage.click();
			objectiveUsage.clear();
			objectiveUsage.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement objectiveUsage1 = waitAndFindElement("obj_of_usage_2nd");
			objectiveUsage1.click();
			objectiveUsage1.clear();
			objectiveUsage1.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement codeName = waitAndFindElement("code_name");
			codeName.click();
			codeName.clear();
			codeName.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement codeName1 = waitAndFindElement("code_name_2nd");
			codeName1.click();
			codeName1.clear();
			codeName1.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement Category = waitAndFindElement("category");
			Category.click();
			Category.clear();
			Category.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement Category1 = waitAndFindElement("category_2nd");
			Category1.click();
			Category1.clear();
			Category1.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement keyMilestone = waitAndFindElement("key_milestone");
			keyMilestone.click();
			keyMilestone.clear();
			keyMilestone.sendKeys("Testing Quad Chart through Automation Scripts");
			WebElement keyMilestoneMonth = waitAndFindElement("key_mile_month");
			keyMilestoneMonth.click();
			keyMilestoneMonth.clear();
			keyMilestoneMonth.sendKeys("9");
			WebElement keyMilestoneYear = waitAndFindElement("key_mile_year");
			keyMilestoneYear.click();
			keyMilestoneYear.clear();
			keyMilestoneYear.sendKeys("2013");
			Thread.sleep(4000);
		    WebElement quadChartInput = findElement("qc_upload_input");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].setAttribute('style', 'display:block');", quadChartInput);
			Thread.sleep(2000);
			quadChartInput.sendKeys("/Users/nayana.shivalingappa/Documents/Selenium/Deco.png");
			wait.waitForPageToLoad();
			Thread.sleep(1000);
			WebDriverWait customWait = new WebDriverWait(driver, 10);
			WebElement loadingImage = findElement("loading_image");
            if(loadingImage != null){
                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
            }
//			WebElement loadingImage = waitAndFindElement("loading_image");
//			if(loadingImage != null){
//				wait.until(ExpectedConditions.invisibilityOf(loadingImage));
//			}
			WebElement scientificImpact = waitAndFindElement("scientific_impact", 20);
			scientificImpact.click();
			scientificImpact.sendKeys("Testing Quad Chart through Automation Scripts \n Testing Quad Chart through Automation Scripts");			
			WebElement quadChartImageCaption = waitAndFindElement("qc_image_caption");
			quadChartImageCaption.click();
			quadChartImageCaption.sendKeys("Upload using scripts");			
			Thread.sleep(2000);
			List<WebElement> SubmitQuadChart = waitAndFindElements("submit_quad_chart");
			SubmitQuadChart.get(0).click();
			WebElement notification = waitAndFindElement("notification", 300);
			String text1 = notification.getText();
			System.out.println("Success message after submitting quadchart:     " + text1);
			Thread.sleep(6000);
			List<WebElement> downloadQC = findElements("downlaod");
			downloadQC.get(0).click();
			Thread.sleep(6000);
//			Alert alert = driver.switchTo().alert();
//			Thread.sleep(2000);
//	        alert.accept();
			Thread.sleep(4000);
			WebElement returnProject = waitAndFindElement("return_project", 100);
			returnProject.click();
			Thread.sleep(3000);			
			List<WebElement> closePage = findElements("view_page_close");
			closePage.get(1).click();
			Thread.sleep(3000);
			return true;
		}
		
		public boolean submitSummaryOfRequirements(String requestNumber) throws InterruptedException{
			WebElement summaryReq = waitAndFindElement("cr_summary_of_req", 30, requestNumber);
			summaryReq.click();
			WebElement findText = waitAndFindElement("project_banner", 30);
			Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Request number from the SOR banner:  " + text);			
			List<WebElement> saveAllocationSumm = findElements("allo_summ_save_button");
			saveAllocationSumm.get(0).click();
//			Thread.sleep(30000);
			WebDriverWait customWait = new WebDriverWait(driver, 60);
			WebElement loadingImage = findElement("loading_image");
            if(loadingImage != null){
                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
            }
			List<WebElement> selectRadioButton1 = findElements("storage_resource1");
			selectRadioButton1.get(0).click();
			List<WebElement> selectRadioButton2 = findElements("storage_resource2");
			selectRadioButton2.get(0).click();			
			WebElement selectCompiler = findElement("select_compiler");
			selectCompiler.click();
			WebElement selectCompilerJava = findElement("select_complier");
			selectCompilerJava.click();
			List<WebElement> applicationInfoSave = findElements("allication_info_save_button");
			applicationInfoSave.get(1).click();			
			List<WebElement> identifyDataSecurity = findElements("identity_data_security");
			identifyDataSecurity.get(0).click();
			WebElement sensitiveData = findElement("senstitive_data");
			sensitiveData.click();
			WebElement selectRecoveryLevel = findElement("recovery_level");
			selectRecoveryLevel.click();
			WebElement selectRecoveryLevelData = findElement("select_recovery_level");
			selectRecoveryLevelData.click();			
			WebElement saveDataSecurity = findElement("save_data_security");
			saveDataSecurity.click();
			Thread.sleep(3000);
			WebElement nasTempStorage = findElement("nas_temp_storage");
			nasTempStorage.click();
			nasTempStorage.clear();
			nasTempStorage.sendKeys("1000");
			WebElement nasDuringAward = findElement("nas_during_award");
			nasDuringAward.click();
			nasDuringAward.clear();
			nasDuringAward.sendKeys("200");
			WebElement nccsTempStorage = findElement("nccs_temp_storage");
			nccsTempStorage.click();
			nccsTempStorage.clear();
			nccsTempStorage.sendKeys("3000");
			WebElement nccsPreviousAward = findElement("nccs_previous_award");
			nccsPreviousAward.click();
			nccsPreviousAward.sendKeys("30");			
			WebElement saveStorageData = findElement("save_storage_data");
			saveStorageData.click();
			Thread.sleep(3000);
			List<WebElement> saveSOR = findElements("save_sor");
			saveSOR.get(0).click();		
			WebElement notification = waitAndFindElement("notification", 300);
			String text1 = notification.getText();
			System.out.println("Success message after submitting SOR:     " + text1);
			//TODO Add the check from the loading element here, because button is obscured
	            if(loadingImage != null){
	                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
	            }
			WebElement returnProject = waitAndFindElement("return_project", 150);
			returnProject.click();
			Thread.sleep(3000);
			List<WebElement> closePage = findElements("view_page_close"); // why this close is not visible- same xpath works fine for other pages
			closePage.get(1).click();			
			Thread.sleep(5000);
			return true;
         }
		
		public boolean submitFinalSubmission(String requestNumber) throws InterruptedException{
			WebElement finalSubmission = waitAndFindElement("cr_final_submission", 30, requestNumber);
			finalSubmission.click();
			WebElement findText = waitAndFindElement("project_banner");
			Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Request number from the final submission banner:  " + text);	
			WebDriverWait customWait = new WebDriverWait(driver, 60);
			WebElement loadingImage = findElement("loading_image");
            if(loadingImage != null){
                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
            }
			WebElement finalSubmissionAcknowledge = waitAndFindElement("final_submission_ack", 30);
			finalSubmissionAcknowledge.click();
			WebElement submitComputingRequest = waitAndFindElement("submit_computing_request", 30);
			submitComputingRequest.click();
			WebElement notification = waitAndFindElement("notification", 300);
			String text1 = notification.getText();
			System.out.println("Success message after submitting computing request:     " + text1);
			return true;
		}
		
		public void coverSheetValidation() throws InterruptedException{
			List<WebElement> coverSheet = findElements("cover_sheet");
			coverSheet.get(0).click();
			Thread.sleep(2000);			
			List<WebElement> SubmitCoverSheet = findElements("submit_cover_sheet");
			SubmitCoverSheet.get(0).click();
			Thread.sleep(1000);
			boolean error = (driver.getPageSource().contains("Preferred Location is Required") 
					&& driver.getPageSource().contains("Key Phrases is Required") 
					&& driver.getPageSource().contains("Contract Type is Required") 
					&& driver.getPageSource().contains("NASA Contract/Grant/WBS number is Required") 
					&& driver.getPageSource().contains("Abstract Comment is Required"));
			if(error == true)
			  	{
					System.out.println("True");
				}
			else 
				{
				 	System.out.println("False");
				}
			Thread.sleep(3000);
			List<WebElement> closePage = findElements("view_page_close");
			closePage.get(1).click();
 }
		
		public void quadChartValidation() throws InterruptedException{
			List<WebElement> quadChart = findElements("quad_chart");
			quadChart.get(0).click();
			Thread.sleep(3000);
			List<WebElement> SubmitQuadChart = waitAndFindElements("submit_quad_chart");
			SubmitQuadChart.get(0).click();
			Thread.sleep(3000);
			boolean error = (driver.getPageSource().contains("At least one objective of usage is required") 
					&& driver.getPageSource().contains("At least one code name to be run is required") 
					&& driver.getPageSource().contains("At least one catagory set is required") 
					&& driver.getPageSource().contains("Image upload is required") 
					&& driver.getPageSource().contains("Image caption is required")
					&& driver.getPageSource().contains("Scientific or engineering impact is required"));
			if(error == true)
			  	{
					System.out.println("True");
				}
			else 
				{
				 	System.out.println("False");
				}
			Thread.sleep(3000);
			List<WebElement> closePage = findElements("view_page_close");
			closePage.get(1).click();
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
		
		public String getCrRequestNumber() {
			return crRequestNumber;
		}

		public void setCrRequestNumber(String crRequestNumber) {
			this.crRequestNumber = crRequestNumber;
		}
}
