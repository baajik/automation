package gov.ebooks.selenium.hec.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;

public class HECLoginPage extends BasePage{

	public HECLoginPage(WebDriver driver){
		super(driver, "LoginPage", "hec");
	}
	
	public void loadLoginPage(){
		driver.get("https://nasa-ebooks-qa.amer.reisystems.com/hec_qa/computing/");
	}
	
	public void loginSMD(String username) throws InterruptedException{
		WebElement userName = findElement("username_field");
		WebElement passWord = findElement("password_field");
		WebElement loginButton = findElement("login_button");
		
		userName.sendKeys(username);
		passWord.sendKeys("hec_qa");
		Select missionDirectorate = new Select(findElement("mission_directorate"));
		missionDirectorate.selectByVisibleText("SMD");

		WebElement disclaimerCheckBox = findElement("disclaimer_checkbox");
		disclaimerCheckBox.click();
		loginButton.click();
		Thread.sleep(15000);
	}
	
	public void loginNonSMD(String username) throws InterruptedException{
		WebElement userName = findElement("username_field");
		WebElement passWord = findElement("password_field");
		WebElement loginButton = findElement("login_button");
		
		userName.sendKeys(username);
		passWord.sendKeys("hec_qa");
		Select missionDirectorate = new Select(findElement("mission_directorate"));
		missionDirectorate.selectByVisibleText("ARMD,HEOMD,NESC,STMD,MISC and Archived SMD");

		WebElement disclaimerCheckBox = findElement("disclaimer_checkbox");
		disclaimerCheckBox.click();
		loginButton.click();
	}
	
	public boolean verifyLoginPage() throws InterruptedException{
		boolean correctlyLoaded = false;

		if(driver.getPageSource().contains("HEC Allocation Management eBooks") 
				&& (driver.getPageSource().contains("Welcome to HEC eBooks")
				&& (waitAndFindElement("username_field") != null && waitAndFindElement("password_field") != null 
				&& waitAndFindElement("disclaimer_checkbox") != null))){
			correctlyLoaded = true;
			}
		return correctlyLoaded;
	}
		
	public boolean verifySMDLogin() throws InterruptedException{
		if(driver.getPageSource().contains("Username cannot be empty")
				&& driver.getPageSource().contains("Password cannot be empty")
				&& driver.getPageSource().contains("Please acknowledge the disclaimer by checking the checkbox below")
				&& driver.getPageSource().contains("Login Failed. Please check your username and password information.")) {
			return false;
		} else {
			return true;
		}
	}
		
		public boolean verifyNonSMDLogin() throws InterruptedException{
			if(driver.getPageSource().contains("Username cannot be empty")
					&& driver.getPageSource().contains("Password cannot be empty")
					&& driver.getPageSource().contains("Please acknowledge the disclaimer by checking the checkbox below")
					&& driver.getPageSource().contains("Login Failed. Please check your username and password information.")) {
			return false;
			} else {
				return true;
			}	
	}
		
		public boolean verifyLoginValidations(String username) throws InterruptedException{
			WebElement loginButton = findElement("login_button");
			loginButton.click();
			if(driver.getPageSource().contains("Username cannot be empty")){
				WebElement userName = findElement("username_field");
				userName.sendKeys(username);
				loginButton.click();		    
				if(driver.getPageSource().contains("Password cannot be empty")){
				WebElement passWord = findElement("password_field");
				passWord.sendKeys("hec_qa");
					if(driver.getPageSource().contains("Please acknowledge the disclaimer by checking the checkbox below")){
					WebElement disclaimerCheckBox = findElement("disclaimer_checkbox");
				    disclaimerCheckBox.click();
				    loginButton.click();
				    WebElement page_text = waitAndFindElement("page_content", 20);
				    if(page_text != null){
				    	System.out.println("text:   " + page_text.getText());
			return true;
				  }
			    }
			  }
			}
			else
			{
			return false;
			}
			return true;
}	
		
		public boolean loginWrongCredentials(String username) throws InterruptedException{
			WebElement userName = findElement("username_field");
			WebElement passWord = findElement("password_field");
			WebElement loginButton = findElement("login_button");
			userName.sendKeys(username);
			passWord.sendKeys("hec");
			WebElement disclaimerCheckBox = findElement("disclaimer_checkbox");
			disclaimerCheckBox.click();
			loginButton.click();
			Thread.sleep(1000);
			if(driver.getPageSource().contains("Login Failed. Please check your username and password information.")) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean userRegistrationPage() throws InterruptedException{
			WebElement userRegistration = findElement("user_registration_button");
			userRegistration.click();
			
			WebElement registrationtitle = findElement("registration_title");
			WebElement registrationbutton = findElement("register_user_button");

			if(registrationtitle != null && registrationbutton != null){
				
		Select salutation = new Select(driver.findElement(By.name("salutation")));
		salutation.selectByVisibleText("Ms.");
		WebElement firstName = findElement("first_name");
		firstName.click();
		firstName.sendKeys("Rohan");
		WebElement lastName = findElement("last_name");
		lastName.click();
		lastName.sendKeys("Roy");
		Select institution = new Select(driver.findElement(By.name("institution")));
		institution.selectByVisibleText("GSFC");
		Select state = new Select(driver.findElement(By.name("state")));
		state.selectByVisibleText("AK - Alaska");
		WebElement country = findElement("country");
		country.click();
		country.sendKeys("USA"); 
		WebElement address = findElement("address");
		address.click();
		address.sendKeys("Vintage park plaza");
		WebElement city = findElement("city");
		city.click();
		city.sendKeys("Sterling");
		WebElement zip = findElement("zip");
		zip.click();
		zip.sendKeys("20146");
		WebElement phone = findElement("phone");
		phone.click();
		phone.sendKeys("7034809100");
		WebElement email = findElement("email");
		email.click();
		//TODO DELETE THIS WHEN CLEANING UP
		Random rand = new Random();
		String randomEmail = "rroy" + rand.nextInt(99999999) + "@gmail.com";
		email.sendKeys(randomEmail);
		registrationbutton.click();
	//	Thread.sleep(60000);
		WebElement successMessage = waitAndFindElement("success_message", 100);
		if(successMessage == null){
			return false;
		}
		WebElement returnToLoginPage = waitAndFindElement("retun_to_loginpage", 50);
		returnToLoginPage.click();
		Thread.sleep(2000);
		}
		return true;
	}
	
	public boolean forgotPasswordPage() throws InterruptedException{		
		List<WebElement> forgotPassword = findElements("forgot_password_link");
		forgotPassword.get(0).click();
		WebElement submitForgotPassword = findElement("submit_forgot_password");
		if(driver.getPageSource().contains("Forgot Password")
				&& submitForgotPassword != null) {			
			WebElement firstName = waitAndFindElement("first_name");
			firstName.click();
			firstName.sendKeys("Nayana");
			WebElement lastName = waitAndFindElement("last_name");
			lastName.click();
			lastName.sendKeys("Shivalingappa");
			WebElement email = waitAndFindElement("email");
			email.click();
			email.sendKeys("nayana.shivalingappa@reisystems.com");
			WebElement zip = waitAndFindElement("zip");
			zip.click();
			zip.sendKeys("20166");
			submitForgotPassword.click();
	//		Thread.sleep(90000);
			WebElement securityKey = waitAndFindElement("securityAns", 90);
			securityKey.click();
			securityKey.sendKeys("steffi");
			WebElement submitSecuiry = waitAndFindElement("submit_security", 10);
			submitSecuiry.click();			
			WebElement successMessage = waitAndFindElement("success_message", 100);
			if(successMessage == null){
				return false;
			}
			WebElement returnToLoginPage = waitAndFindElement("retun_to_loginpage", 30);
			returnToLoginPage.click();
			Thread.sleep(2000);
			}
		return true;
	}
	
}
