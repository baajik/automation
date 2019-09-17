package gov.ebooks.selenium.esto_review.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gov.ebooks.selenium.shared.pages.BasePage;

public class EstoReviewLoginPage extends BasePage{
	
	public EstoReviewLoginPage(WebDriver driver){
		super(driver, "estoReviewLoginPage", "esto_review");
	}
	
	public boolean verifyLoginPage() {
		boolean correctlyLoaded = false;
		WebElement loginButton = findElement("login_button");
		if (driver.getPageSource().contains("ESTO Review Evaluation System")
				&& driver.getCurrentUrl().contains("https://nasa-ebooks-qa.amer.reisystems.com/review/login")
			&& waitAndFindElement("username_field") != null && waitAndFindElement("password_field") != null
					&& loginButton != null) {
				correctlyLoaded = true;
			}
		return correctlyLoaded;
	}
	
	
	public boolean forgotPassword() throws InterruptedException{		
		WebElement forgotPassword = waitAndFindElement("forgot_password_link");
		forgotPassword.click();
		WebElement submitForgotPassword = findElement("submit_forgot_password");
		if(driver.getPageSource().contains("Forgot Password?")
				&& submitForgotPassword != null) {			
			WebElement firstName = waitAndFindElement("first_name");
			firstName.click();
			firstName.sendKeys("Nayana");
			WebElement lastName = waitAndFindElement("last_name");
			lastName.click();
			lastName.sendKeys("Huchapla Shivalingappa");
			WebElement email = waitAndFindElement("email");
			email.click();
			email.sendKeys("nayana.shivalingappa@reisystems.com");
			submitForgotPassword.click();
			Thread.sleep(4000);
			WebElement errorMessage = waitAndFindElement("notification", 10);
			if(errorMessage == null){
			WebElement securityKey = findElement("security_answer");
			securityKey.click();
			securityKey.sendKeys("Tennis");
			WebElement submitSecuiry = waitAndFindElement("submit_security", 5);
			submitSecuiry.click();			
			WebElement message = waitAndFindElement("notification", 100);
			String error = message.getText();
			System.out.println("--Error Message ----"   + error);
			if(!error.equals("Your password has been reset and sent to your email")){
				return false;
			}
			}
		}
		return true;
	}
}	


//We could not locate your profile. 
//If the issue persists, please contact ESTO eBooks technical support at: 
//(703)-480-9100 or ebooks@reisystems.com 
//Monday to Friday, 8AM to 5PM ET
