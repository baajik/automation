package gov.ebooks.selenium.hec.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import gov.ebooks.selenium.shared.pages.BasePage;

	public class NonSMDPage extends BasePage {

		private String nonSMDRequestNumber;
		
		public NonSMDPage(WebDriver driver) {
			super(driver, "nonSMDPage", "hec");
			setNonSMDRequestNumber("");
		}
		
		public boolean createNonSMDRequest() throws InterruptedException{
			WebElement computingRequestTitle = findElement("title");
			WebElement addNewRequest = findElement("submit");			
			if(computingRequestTitle != null && addNewRequest != null){
				Select missionDirectorate = new Select(driver.findElement(By.name("topicAreaId")));
				missionDirectorate.selectByVisibleText("ARMD - Aeronautics Research");
				computingRequestTitle.click();
				computingRequestTitle.sendKeys("Testing by eBooks support");
				List<WebElement> selectPI = findElements("select_pi");
				selectPI.get(0).click();
				addNewRequest.click();	
				WebElement successMessage = waitAndFindElement("success_message", 100);
				if(successMessage == null){
					return false;
				}
				System.out.println("Coversheet:  " + successMessage.getText());
				WebElement findText = waitAndFindElement("banner_content");
				Thread.sleep(2000);
				nonSMDRequestNumber = findText.getText();
				System.out.println("Non-SMD request number from the banner:  " + nonSMDRequestNumber);
			}
			Thread.sleep(3000);
			return true;
		}
		
		public boolean submitNonSMDCoverSheet() throws InterruptedException{
			//System.out.println("Looking for this request number = " + nonSMDRequestNumber);
			List<WebElement> coverSheetlink = driver.findElements(By.linkText("Cover Sheet"));
			coverSheetlink.get(0).click();
			WebElement findText = waitAndFindElement("banner_content");
	//		Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Request number from the coversheet banner:    "  + text);
		
			Select  mdDiscipline = new Select(driver.findElement(By.name("mdDiscipline")));
			mdDiscipline.selectByVisibleText("Airspace Operations and Safety Program");			
			Select projectName = new Select(driver.findElement(By.name("projectName")));
			projectName.selectByVisibleText("Air Traffic Management Exploration Project");
			WebElement keyPhrases = findElement("key_phrases");
			keyPhrases.click();
			keyPhrases.sendKeys("Test Automation");
			Select organizationType = new Select(driver.findElement(By.name("typeOfOrganization")));
			organizationType.selectByVisibleText("Academia");
			List<WebElement> nasaContractType = findElements("nasa_contract");
			nasaContractType.get(0).click();
			WebElement enterNasaContract = findElement("enter_nasa_contract");
			enterNasaContract.click();
			enterNasaContract.sendKeys("NXS12323");
			WebElement nasaContractTitle = findElement("nasa_contract_title");
			nasaContractTitle.click();
			nasaContractTitle.sendKeys("Test");
			Select fundingManager = new Select(driver.findElement(By.name("fundingManagerId")));
			fundingManager.selectByVisibleText("Other");
			WebElement fundingManagerName = findElement("funding_manager_name");
			fundingManagerName.click();
			fundingManagerName.sendKeys("Test");
			WebElement fundingManagerEmail = findElement("funding_manager_email");
			fundingManagerEmail.click();
			fundingManagerEmail.sendKeys("Test@test.com");
			WebElement abstractTextArea = findElement("abstract");
			abstractTextArea.click();
			abstractTextArea.sendKeys("Create non smd request through automation scripts");
			WebElement saveCoverSheet = findElement("save_cover_sheet");
			saveCoverSheet.click();
			WebElement submitCoverSheet = findElement("submit_cover_sheet");
			submitCoverSheet.click();	
			WebElement successMessage = waitAndFindElement("success_message", 100);
			if(successMessage == null){
				return false;
			}
			System.out.println("Coversheet:  " + successMessage.getText() );
			return true;
		}
		
		public boolean submitNonSMDSOR() throws InterruptedException{
		//	System.out.println("Looking for this request number = " + nonSMDRequestNumber);
			List<WebElement> SORlink = driver.findElements(By.linkText("Summary of Requirements"));
			SORlink.get(0).click();
			WebElement findText = waitAndFindElement("banner_content");
			Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Request number from the sor banner:    "  + text);
			WebElement nasPleiadesLow = findElement("nas_pleiades_low");
			nasPleiadesLow.click();
			nasPleiadesLow.clear();
			nasPleiadesLow.sendKeys("12345");
			WebElement nasPleiadesHigh = findElement("nas_pleiades_high");
			nasPleiadesHigh.click();
			nasPleiadesHigh.clear();
			nasPleiadesHigh.sendKeys("100");
			WebElement nasPleiadesAverage = findElement("nas_pleiades_average");
			nasPleiadesAverage.click();
			nasPleiadesAverage.clear();
			nasPleiadesAverage.sendKeys("123");
			WebElement nasPleiadesClockhours = findElement("nas_pleiades_clock_hrs");
			nasPleiadesClockhours.click();
			nasPleiadesClockhours.clear();
			nasPleiadesClockhours.sendKeys("100");
			WebElement nasPleiadesNoRuns = findElement("nas_pleiades_no_runs");
			nasPleiadesNoRuns.click();
			nasPleiadesNoRuns.clear();
			nasPleiadesNoRuns.sendKeys("100");
			WebElement saveMachineHours = findElement("save_continue");
			saveMachineHours.click();
			WebElement memoryReq = findElement("sor_mem_req");
			memoryReq.click();
			WebElement saveApplicationInfo = findElement("save_continue");
			saveApplicationInfo.click();
			WebElement classifiedData = findElement("classified_data");
			classifiedData.click();
			WebElement sensitiveData = findElement("sensitive_data");
			sensitiveData.click();
			Select disasterRecoveryLevel = new Select(driver.findElement(By.name("summaryOfRequirementModel.diasterRecoveryLevel")));
			disasterRecoveryLevel.selectByVisibleText("High (within 2-3 days)");
			WebElement saveDataSecurity = findElement("save_continue");
			saveDataSecurity.click();
			WebElement saveDataTransfer = findElement("save_continue");
			saveDataTransfer.click();
			
			WebElement submitSOR = findElement("submit_sor");
			submitSOR.click();
			WebElement successMessage = waitAndFindElement("success_message", 100);
			if(successMessage == null){
				return false;
			}
			System.out.println("SOR:  " + successMessage.getText() );
			
			return true;
		}
		
		public boolean submitNonSMDQuadChart() throws InterruptedException{
			List<WebElement> quadChartlink = driver.findElements(By.linkText("Quad Chart"));
			quadChartlink.get(0).click();			
			Thread.sleep(2000);
			WebElement findText = waitAndFindElement("banner_content");
			Thread.sleep(2000);
			String text = findText.getText();
			System.out.println("Request number from the quad chart banner:   "   + text);			
			WebElement editobjectiveCode = findElement("edit_objectives_code");
			editobjectiveCode.click();
			WebElement objectiveUsage = findElement("objectives_usage");
			objectiveUsage.click();
			objectiveUsage.clear();
			objectiveUsage.sendKeys("Adding Objective usage");
			WebElement identifyCode = findElement("identify_code");
			identifyCode.click();
			identifyCode.clear();
			identifyCode.sendKeys("Adding codes");
			WebElement identifyCategory = findElement("identify_category");
			identifyCategory.click();
			identifyCategory.clear();
			identifyCategory.sendKeys("Adding categories");
			List<WebElement> saveObjectives = findElements("save_button");
			saveObjectives.get(0).click();
			WebElement editImage = findElement("edit_quad_image");
			editImage.click();
			WebElement uploadImage = findElement("upload_image");
			uploadImage.sendKeys("/Users/nayana.shivalingappa/Documents/Selenium/Deco.png");
			Thread.sleep(5000);
			WebElement imageCaption = findElement("image_caption");
			imageCaption.click();
			imageCaption.clear();
			imageCaption.sendKeys("Uploading Image");
			List<WebElement> saveQuadChartImage = findElements("save_button");
			saveQuadChartImage.get(2).click();
			
			WebElement editKeyMilestones = findElement("edit_key_milestone");
			editKeyMilestones.click();
			WebElement milestoneDescription = findElement("milestone_description");
			milestoneDescription.click();
			milestoneDescription.clear();
			milestoneDescription.sendKeys("Milestone 1");
			WebElement milestoneMonth = findElement("milestone_month");
			milestoneMonth.click();
			milestoneMonth.clear();
			milestoneMonth.sendKeys("10");
			WebElement milestoneYear = findElement("milestone_year");
			milestoneYear.click();
			milestoneYear.clear();
			milestoneYear.sendKeys("2011");
			
			List<WebElement> saveKeyMilestones = findElements("save_button");
			saveKeyMilestones.get(4).click();
			WebElement editScientificImpact = findElement("edit_scientific");
			editScientificImpact.click();
			WebElement scientificImpactComments = findElement("scientific_text_area");
			scientificImpactComments.click();
			scientificImpactComments.clear();
			scientificImpactComments.sendKeys("Adding comments through Selenium Automation scripts");
			List<WebElement> saveScientificImpact = findElements("save_button");
			saveScientificImpact.get(6).click();
			WebElement submitQuadChart = findElement("submit_quadchart");
			submitQuadChart.click();
			WebElement successMessage = waitAndFindElement("success_message", 100);
			if(successMessage == null){
				return false;
			}
			System.out.println("Quadchart:  " + successMessage.getText() );
			
			return true;
		}
	
	public boolean submitNonSMDFinalSubmission() throws InterruptedException{
		List<WebElement> finalSubmissionlink = driver.findElements(By.linkText("Final Submission"));
		finalSubmissionlink.get(0).click();
		Thread.sleep(2000);
		WebElement findText = waitAndFindElement("banner_content");
		Thread.sleep(2000);
		String text = findText.getText();
		System.out.println("Request number from the final submission page:    " + text);
		WebElement acknoFinalSubmission = findElement("acknowledge_final_submission");
		acknoFinalSubmission.click();
		WebElement submitFinalSubmission = findElement("submit");
		submitFinalSubmission.click();
		WebElement successMessage = waitAndFindElement("success_message", 100);
		if(successMessage == null){
			return false;
		}
		System.out.println("Final submission:  " + successMessage.getText() );
		
		return true;
	 	}
	
	public void logout() throws InterruptedException{
		Thread.sleep(2000);
		WebElement logout = findElement("logout");
		logout.click();
		Thread.sleep(2000);
	}
	
	public String getNonSMDRequestNumber() {
		return nonSMDRequestNumber;
	}

	public void setNonSMDRequestNumber(String nonSMDRequestNumber) {
		this.nonSMDRequestNumber = nonSMDRequestNumber;
	}
}

	
	
