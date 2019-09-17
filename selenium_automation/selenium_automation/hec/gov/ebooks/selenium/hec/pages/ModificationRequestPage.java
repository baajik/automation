package gov.ebooks.selenium.hec.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.ebooks.selenium.shared.pages.BasePage;

public class ModificationRequestPage extends BasePage{
		private String rosesRequestNumber;
		private String nonRosesRequestNumber;
		private String modRequestNumber;
		
			public ModificationRequestPage(WebDriver driver){
				super(driver, "modificationRequestPage", "hec");
				setRosesRequestNumber("");
				setNonRosesRequestNumber("");
			}
			
			public boolean initiateModificatonRequest() throws InterruptedException{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				List<WebElement> clickHereLink =  findElements("mr_click_here");
				WebElement requestTitle = waitAndFindElement("mod_request_title");
				jse.executeScript("arguments[0].scrollIntoView();", requestTitle);
				modRequestNumber = requestTitle.getText();
				clickHereLink.get(0).click();	
				WebElement notification = waitAndFindElement("notification", 300);
				String text1 = notification.getText();
				System.out.println("Success message after initiating modification request:     " + text1);
				Thread.sleep(2000);
				return true;
			}
			
			public boolean submitModificationCoverSheet(String requestNumber) throws InterruptedException{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				System.out.println("print the request number from the CR header of modification stage: " + requestNumber );
				WebElement coverSheet = waitAndFindElement("mod_cover_sheet", 60, requestNumber);
				coverSheet.click();
		//		Thread.sleep(2000);	
				WebDriverWait customWait = new WebDriverWait(driver, 60);
				WebElement loadingImage = findElement("loading_image");
	            if(loadingImage != null){
	                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
	            }
				WebElement findText = waitAndFindElement("project_banner", 30);
				String text = findText.getText();
				System.out.println("get the request number from the modification coversheet banner: " + text);				
				WebElement projectedEndDate = findElement("projected_end_date");
				jse.executeScript("arguments[0].scrollIntoView();", projectedEndDate);
				Thread.sleep(3000);
				WebElement preferredLocation = findElement("preferred_location");
				preferredLocation.click();
				WebElement preferredLocationData = findElement("preferred_location_data");
				preferredLocationData.click();
				WebElement keyPhrases = findElement("key_phrases");
				keyPhrases.click();
				keyPhrases.clear();
				keyPhrases.sendKeys("Automation modification request");				
				WebElement abstractValue = findElement("abstract");
				abstractValue.click();
				abstractValue.clear();
				abstractValue.sendKeys("HEC automation modification request");
				jse.executeScript("arguments[0].scrollIntoView();", projectedEndDate);
				List<WebElement> SubmitCoverSheet = findElements("submit_cover_sheet");
				SubmitCoverSheet.get(0).click();
				WebElement notification = waitAndFindElement("notification", 300);
				String text1 = notification.getText();
				System.out.println("Success message after modification coversheet submission:     " + text1);
				Thread.sleep(5000);
				List<WebElement> closePage = findElements("view_page_close");
				closePage.get(1).click();
				return true;
			}
				
			public boolean submitModificationQuadChart(String requestNumber) throws InterruptedException{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				Thread.sleep(8000);
				System.out.println("print the request number from the CR header of modification stage: " + requestNumber );
				WebElement quadChart = waitAndFindElement("mod_quad_chart", 60, requestNumber);
				quadChart.click();
		//		Thread.sleep(2000);
				WebElement findText = waitAndFindElement("project_banner", 50);
				String text = findText.getText();
				System.out.println("get the request number from the modification quad chart banner: " + text);
				WebDriverWait customWait = new WebDriverWait(driver, 60);
				WebElement loadingImage = findElement("loading_image");
	            if(loadingImage != null){
	                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
	            }
				WebElement objectiveUsage = waitAndFindElement("obj_of_usage", 30);
				objectiveUsage.click();
				objectiveUsage.clear();
				objectiveUsage.sendKeys("Testing Quad Chart through automation scripts");
				WebElement objectiveUsage1 = waitAndFindElement("obj_of_usage_2nd");
				objectiveUsage1.click();
				objectiveUsage1.clear();
				objectiveUsage1.sendKeys("Testing Quad Chart through automation scripts");			
				WebElement roleText = waitAndFindElement("role_text_area");
				roleText.click();
				roleText.clear();
				roleText.sendKeys("Testing Quad Chart through automation scripts");				
				WebElement year = waitAndFindElement("year");
				year.click();
				year.clear();
				year.sendKeys("2017");
				WebElement pubTitle = waitAndFindElement("pub_title");
				pubTitle.click();
				pubTitle.clear();
				pubTitle.sendKeys("High end computing");
				WebElement pubAuthor = waitAndFindElement("pub_author");
				pubAuthor.click();
				pubAuthor.clear();
				pubAuthor.sendKeys("Nayana");
				WebElement pubJournal = waitAndFindElement("pub_journal");
				pubJournal.click();
				pubJournal.clear();
				pubJournal.sendKeys("Automationscripts");
				WebElement pubURL = waitAndFindElement("pub_url");
				pubURL.click();
				pubURL.clear();
				pubURL.sendKeys("hec.com");
				WebElement majorResults = waitAndFindElement("major_results");
				majorResults.click();
				majorResults.clear();
				majorResults.sendKeys("Testing modification request through automation scripts");
				WebElement quadChartInput = findElement("qc_upload_input");
				jse.executeScript("arguments[0].setAttribute('style', 'display:block');", quadChartInput);
				Thread.sleep(4000);
				quadChartInput.sendKeys("/Users/nayana.shivalingappa/Documents/Selenium/Deco.png");
				wait.waitForPageToLoad();
				Thread.sleep(1000);
				List<WebElement> SubmitQuadChart = waitAndFindElements("submit_quad_chart");
				SubmitQuadChart.get(1).click();
				WebElement notification = waitAndFindElement("notification", 300);
				String text1 = notification.getText();
				System.out.println("Success message after modification quadchart submission:     " + text1);
				WebElement returnProject = waitAndFindElement("return_project", 30);
				returnProject.click();
				Thread.sleep(8000);
				List<WebElement> closePage = findElements("view_page_close");
				closePage.get(1).click();
				Thread.sleep(10000);
				return true;
			}
			
			public boolean submitModificationSOR(String requestNumber) throws InterruptedException{
				System.out.println("print the request number from the CR header of modification stage: " + requestNumber );
				Thread.sleep(15000);
				WebElement summaryReq = waitAndFindElement("mod_summary_of_req", 100, requestNumber);
				summaryReq.click();
				Thread.sleep(2000);
				WebElement findText = waitAndFindElement("project_banner", 30);
				String text = findText.getText();
				System.out.println("get the request number from the modification SOR banner: " + text);			
				WebElement sbu = waitAndFindElement("mod_sbus", 30);
				sbu.click();
				sbu.clear();
				sbu.sendKeys("30000");
		//		Thread.sleep(10000);
				WebDriverWait customWait = new WebDriverWait(driver, 60);
				WebElement loadingImage = findElement("loading_image");
	            if(loadingImage != null){
	                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
	            }
				List<WebElement> saveAllocationSumm = findElements("allo_summ_save_button");
				saveAllocationSumm.get(0).click();
				Thread.sleep(10000);
		            if(loadingImage != null){
		                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
		            }
//				List<WebElement> portingCodes = findElements("porting_codes");
//				portingCodes.get(0).click();
//				List<WebElement> dataAnalysis = findElements("data_analysis");
//				dataAnalysis.get(0).click();
//				List<WebElement> advancedVisualization = findElements("advanced_visualization");
//				advancedVisualization.get(0).click();
				List<WebElement> applicationInfoSave = findElements("allication_info_save_button");
				applicationInfoSave.get(1).click();							
				List<WebElement> sensitiveY = findElements("sensitive_y");
				sensitiveY.get(0).click();
				List<WebElement> exportControl = findElements("export_control");
				exportControl.get(0).click();
				List<WebElement> procurementIntegrity = findElements("procurement_integrity");
				procurementIntegrity.get(0).click();
				List<WebElement> tradeSecret = findElements("trade_secret");
				tradeSecret.get(0).click();
				List<WebElement> privacyAct = findElements("privacy_act");
				privacyAct.get(0).click();
				List<WebElement> other = findElements("other");
				other.get(0).click();				
				WebElement saveDataSecurity = findElement("save_data_security");
				saveDataSecurity.click();
				Thread.sleep(3000);
				WebElement nasTempStorage = waitAndFindElement("nas_temp_storage", 30);
				nasTempStorage.click();
				nasTempStorage.clear();
				nasTempStorage.sendKeys("10");
				WebElement nasDuringAward = findElement("nas_during_award");
				nasDuringAward.click();
				nasDuringAward.clear();
				nasDuringAward.sendKeys("20");
				WebElement nccsTempStorage = findElement("nccs_temp_storage");
				nccsTempStorage.click();
				nccsTempStorage.clear();
				nccsTempStorage.sendKeys("30");
				WebElement nccsPreviousAward = findElement("nccs_previous_award");
				nccsPreviousAward.click();
				nccsPreviousAward.sendKeys("300");			
				WebElement saveStorageData = findElement("save_storage_data");
				saveStorageData.click();
				Thread.sleep(3000);
				List<WebElement> saveSOR = findElements("save_sor");
				saveSOR.get(0).click();
				WebElement notification = waitAndFindElement("notification", 300);
				String text1 = notification.getText();
				System.out.println("Success message after modification sor submission:     " + text1);
				if(loadingImage != null){
	                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
	            }
				WebElement returnProject = waitAndFindElement("return_project", 60);
				returnProject.click();
				Thread.sleep(10000);
				List<WebElement> closePage = findElements("view_page_close"); // why this close is not visible- same xpath works fine for other pages
				closePage.get(1).click();
				Thread.sleep(30000);
				return true;
	         }
			
			public boolean submitFinalSubmission(String requestNumber) throws InterruptedException{
				System.out.println("print the request number from the CR header of modification stage: " + requestNumber );
				WebElement finalSubmission = waitAndFindElement("mod_final_submission", 100, requestNumber);
				finalSubmission.click();
				WebElement findText = waitAndFindElement("project_banner", 30);
				String text = findText.getText();
				System.out.println("get the request number from the modification final submission page banner: " + text);	
				Thread.sleep(2000);
				WebDriverWait customWait = new WebDriverWait(driver, 50);
					WebElement loadingImage = findElement("loading_image");
		            if(loadingImage != null){
		                  customWait.until(ExpectedConditions.invisibilityOf(loadingImage));
		            }
				WebElement finalSubmissionAcknowledge = waitAndFindElement("final_submission_ack", 60);
				finalSubmissionAcknowledge.click();
				WebElement submitModificationRequest = waitAndFindElement("submit_computing_request", 60);
				submitModificationRequest.click();	
				WebElement notification = waitAndFindElement("notification", 400);
				String text1 = notification.getText();
				System.out.println("Success message after modification request submission:     " + text1);
				return true;
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
			
			public String getModRequestNumber() {
				return modRequestNumber;
			}
			public void setModRequestNumber(String modRequestNumber) {
				this.modRequestNumber = modRequestNumber;
			}
	}


