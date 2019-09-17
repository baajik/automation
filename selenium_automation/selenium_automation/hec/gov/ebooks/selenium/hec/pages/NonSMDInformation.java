package gov.ebooks.selenium.hec.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import gov.ebooks.selenium.shared.pages.BasePage;

public class NonSMDInformation extends BasePage {

	public NonSMDInformation(WebDriver driver) {
		super(driver, "nonSMDInformation", "hec");
	}
	
	public boolean InfoTechnicalSupport() throws InterruptedException{
		List<WebElement> informationTab = findElements("information_tab");
		Actions action = new Actions(driver);
		action.moveToElement(informationTab.get(21)).perform();
		action.moveByOffset(1, 1).perform();
		List<WebElement> TechSupport = findElements("information_tab");
		TechSupport.get(22).click();		
		String parentWindow= driver.getWindowHandle();
		for(String curWindow : driver.getWindowHandles()){
		    driver.switchTo().window(curWindow);
		}
		WebElement title = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the current window: " + title.getText());
		WebElement close = findElement("close");		
		if(driver.getPageSource().contains("If you are having any difficulties using the system, ")){
			Thread.sleep(3000);
			close.click();
			Thread.sleep(2000);
		}		
		driver.switchTo().window(parentWindow);
		Thread.sleep(7000);
		WebElement title2 = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the parent window: " + title2.getText());
	
		return true;
	}
	
	public boolean InfoRollingCalls() throws InterruptedException{
		List<WebElement> informationTab = findElements("information_tab");
		Actions action = new Actions(driver);
		action.moveToElement(informationTab.get(21)).perform();
		action.moveByOffset(1, 1).perform();
		
		List<WebElement> RollingCalls = findElements("information_tab");
		RollingCalls.get(23).click();
		
		String parentWindow= driver.getWindowHandle();
		for(String curWindow : driver.getWindowHandles()){
		    driver.switchTo().window(curWindow);
		}
		WebElement title = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the current window: " + title.getText());
		WebElement close = findElement("close");

		WebElement armdRollingCall = driver.findElement(By.linkText("ARMD Rolling Call"));
		WebElement heomdRollingCall = driver.findElement(By.linkText("HEOMD Rolling Call"));
		WebElement nescRollingCall = driver.findElement(By.linkText("NESC Rolling Call"));
		WebElement stmdRollingCall = driver.findElement(By.linkText("STMD Rolling Call"));
		
		if(armdRollingCall != null && heomdRollingCall != null && nescRollingCall != null && stmdRollingCall != null){
			Thread.sleep(3000);
			close.click();
			Thread.sleep(2000);
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(4000);
		WebElement title2 = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the parent window: " + title2.getText());
		return true;
	}
	
	public boolean InfoSubmissionInstruction() throws InterruptedException{
		List<WebElement> informationTab = findElements("information_tab");
		Actions action = new Actions(driver);
		action.moveToElement(informationTab.get(21)).perform();
		action.moveByOffset(1, 1).perform();

		List<WebElement> subInstruction = findElements("information_tab");
		subInstruction.get(24).click();
		
		String parentWindow= driver.getWindowHandle();
		for(String curWindow : driver.getWindowHandles()){
		    driver.switchTo().window(curWindow);
		}
		WebElement title = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the current window: " + title.getText());
		WebElement close = findElement("close");
		
		if(driver.getPageSource().contains("Submission Instructions for ARMD, HEOMD, NESC, STMD and MISC Mission Directorate's")){
			Thread.sleep(3000);
			close.click();
			Thread.sleep(2000);
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(7000);
		WebElement title2 = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the parent window: " + title2.getText());
	
		return true;
	}
	
	public boolean InfoFundingManagersList() throws InterruptedException{
		List<WebElement> informationTab = findElements("information_tab");
		Actions action = new Actions(driver);
		action.moveToElement(informationTab.get(21)).perform();
		action.moveByOffset(1, 1).perform();
		List<WebElement> fundingManagersList = findElements("information_tab");
		fundingManagersList.get(25).click();	
		String parentWindow= driver.getWindowHandle();
		for(String curWindow : driver.getWindowHandles()){
		    driver.switchTo().window(curWindow);
		}
		WebElement title = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the current window: " + title.getText());
		WebElement close = findElement("close");		
		if(driver.getPageSource().contains("ARMD Funding Manager Lists:") 
				&& driver.getPageSource().contains("NESC Funding Manager Lists:")){
			Thread.sleep(3000);
			close.click();
			Thread.sleep(2000);
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(7000);
		WebElement title2 = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the parent window: " + title2.getText());
		return true;
	}

	public boolean InfoQCTemplates() throws InterruptedException{
		List<WebElement> informationTab = findElements("information_tab");
		Actions action = new Actions(driver);
		action.moveToElement(informationTab.get(21)).perform();
		action.moveByOffset(1, 1).perform();
		List<WebElement> quadChartTemplates = findElements("information_tab");
		quadChartTemplates.get(26).click();
		String parentWindow= driver.getWindowHandle();

		//Time for new window to open after click
		Thread.sleep(1000);
		for(String curWindow : driver.getWindowHandles()){
			System.out.println("current window " +curWindow);
		    driver.switchTo().window(curWindow);
		}
		WebElement title = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the current window: " + title.getText());
		WebElement close = findElement("close");
		Thread.sleep(4000);
		WebElement accompQuadChart = driver.findElement(By.linkText("HEC Accomplishment Quad Chart"));
		WebElement entryQuadChart = driver.findElement(By.linkText("HEC Entry Quad Chart"));
		if(accompQuadChart != null && entryQuadChart != null){
			Thread.sleep(3000);
			close.click();
			Thread.sleep(2000);
		}else{
			return false;
		}		
		driver.switchTo().window(parentWindow);
		Thread.sleep(7000);
		WebElement title2 = driver.findElement(By.id("titlecontainer"));
		System.out.println("Title of the parent window: " + title2.getText());
		return true;
	}
}
