package gov.ebooks.selenium.esto_review.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import gov.ebooks.selenium.shared.pages.BasePage;
import gov.ebooks.selenium.shared.utils.ConfigManager;

public final class CommonMethodsPages extends BasePage {
	public CommonMethodsPages(WebDriver driver) {
		super(driver, "commonMethodsPages", "ESTO");
	}

	public boolean AppliedScienceERS() {
		driver.get(ConfigManager.AppliedScienceERS());
		sleep(3);
		return true;
	}

	public boolean ESTOERS() {
		driver.get(ConfigManager.ESTOERS());
		sleep(3);
		return true;
	}

	public boolean ESTOReview() {
		driver.get(ConfigManager.ESTOReview());
		sleep(3);
		return true;
	}

	public boolean HECeBooks() {
		driver.get(ConfigManager.HECeBooks());
		sleep(3);
		return true;
	}

	public boolean ARTOERS() {
		driver.get(ConfigManager.ARTOERS());
		sleep(3);
		return true;
	}

	public boolean PlanetrayERS() {
		driver.get(ConfigManager.PlanetaryERS());
		sleep(3);
		return true;
	}

	public boolean ESTOLogin(String UserName, String Password) {
		// driver.findElement(By.tagName("username")).sendKeys(UserName);
		// driver.findElement(By.tagName("password")).sendKeys(Password);
		//

		driver.findElement(By.xpath("//*[@id=\'login-form\']/input[1]")).sendKeys(UserName);
		;
		driver.findElement(By.xpath("//*[@id='login-form']/input[2]")).sendKeys(Password);
		sleep(2);
		driver.findElement(By.id("disclaimerChkBx")).click();
		driver.findElement(By.className("login")).click();
		return true;
	}

	public boolean EstoReviewEvalutionLogout() {
		try {

			// Driver.getInstance().findElement(By.id("dropdown-arrow")).click();

			driver.findElement(By.id("my-account-dropdown")).click();
			sleep(2);
			driver.findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[5]/a")).click();

			// Driver.getInstance().findElement(By.id("my-account-dropdown")).findElement(By.xpath("//*[@id=\'my-account-dropdown\']/ul/li[5]/a")).click();
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public boolean ESTOLogout() {
		driver.findElement(By.id("my-account-dropdown")).findElement(By.linkText("/review/logoutSystemUser")).click();
		return true;
	}

	public boolean SelectACT16Solicitation() {
		try {
			driver.findElement(By.id("AIST-16")).click();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean SelectACT17Solicitation() {
		try {
			sleep(5);
			driver.findElement(By.id("ACT-17")).click();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean ClickSelectSolicitationButton() {
		try {
			driver.findElement(By.xpath("//*[@id=\"page\"]/div[5]/div[3]/form/div/input")).click();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean NavToManageNotifications() throws InterruptedException {
		try {
			sleep(20);
			WebElement adminIcon = driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/img"));
			Actions action = new Actions(driver);
			action.moveToElement(adminIcon)
					.moveToElement(driver.findElement(By.xpath("//*[@id=\'admin-tools-dropdown\']/ul/li[5]/a"))).click()
					.build().perform();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	// Close popup Box
	public boolean ClosePopUp() {
		try {
			driver.findElement(By.xpath("//*[@id=\'page\']/div[5]/div[1]/div[2]/span")).click();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	// ***** If data is refreshed and user's ERS Dashboard Configuration set up
	// need to complete before user can proceed. Following script will run to
	// complete the user's account setup.
	public boolean ERSCofigurationStepOneAndTwo() {

		// Step One ERS Overview
		// Step One
		driver.findElement(By.xpath("//*[@id=\'globalContent\']/div/form/ul[2]/li[2]")).click();

		// Step Two User Profile
		// Step Two - Phone
		WebElement PhoneField = driver.findElement(By.id("inputPhone"));
		PhoneField.sendKeys(Keys.CONTROL + "a");
		PhoneField.sendKeys(Keys.DELETE);
		PhoneField.sendKeys("7031231234");
		// Step Two - Email
		WebElement EmailField = driver.findElement(By.id("inputEmail"));
		EmailField.sendKeys(Keys.CONTROL + "a");
		EmailField.sendKeys(Keys.DELETE);
		EmailField.sendKeys("rashika.shrestha@reisystems.com");
		// Step Two - Address 1
		WebElement StreetField = driver.findElement(By.id("inputStreet"));
		StreetField.sendKeys(Keys.CONTROL + "a");
		StreetField.sendKeys(Keys.DELETE);
		StreetField.sendKeys("123 Abc Street");
		// Step Two - Address City
		WebElement CityField = driver.findElement(By.id("inputCity"));
		CityField.sendKeys(Keys.CONTROL + "a");
		CityField.sendKeys(Keys.DELETE);
		CityField.sendKeys("xxx");
		// Step Two - State Dropdown
		WebElement StateDD = driver.findElement(By.id("stateSelect"));
		StateDD.click();
		sleep(2);
		Select DropDownState = new Select(StateDD);
		DropDownState.selectByVisibleText("Virginia");
		// Step Two - Address Country Field
		WebElement CountryField = driver.findElement(By.id("inputCountry"));
		CountryField.sendKeys(Keys.CONTROL + "a");
		CountryField.sendKeys(Keys.DELETE);
		CountryField.sendKeys("United State");
		// Step Two - Zip Code Field
		WebElement ZipField = driver.findElement(By.id("inputZip"));
		ZipField.sendKeys(Keys.CONTROL + "a");
		ZipField.sendKeys(Keys.DELETE);
		ZipField.sendKeys("20186");
		// Step Two - Organization Field
		WebElement OrganizationFiled = driver.findElement(By.id("inputOrganization"));
		OrganizationFiled.sendKeys(Keys.CONTROL + "a");
		OrganizationFiled.sendKeys(Keys.DELETE);
		OrganizationFiled.sendKeys("uclr");

		// Step Three Security Question
		// Select Question 1
		WebElement QFavoritePet = driver.findElement(By.id("securityQuestionForm"))
				.findElement(By.id("securityQuestion_question_0"));
		QFavoritePet.click();
		sleep(3);
		Select dropdownQ1 = new Select(QFavoritePet);
		dropdownQ1.selectByVisibleText("What is the name of your favorite pet?");
		// Answer Question 1
		WebElement AFavoritePet = driver.findElement(By.id("securityQuestion_answer_0"));
		AFavoritePet.sendKeys(Keys.CONTROL + "a");
		AFavoritePet.sendKeys(Keys.DELETE);
		AFavoritePet.sendKeys("Dog");
		// Select Question2
		WebElement QFirstCar = driver.findElement(By.id("securityQuestionForm"))
				.findElement(By.id("securityQuestion_question_1"));
		QFirstCar.click();
		sleep(3);
		Select dropdownQ2 = new Select(QFirstCar);
		dropdownQ2.selectByVisibleText("What was the make and model of your first car?");
		// Answer Question 2
		WebElement AFirstCar = driver.findElement(By.id("securityQuestion_answer_1"));
		AFirstCar.sendKeys(Keys.CONTROL + "a");
		AFirstCar.sendKeys(Keys.DELETE);
		AFirstCar.sendKeys("Toyota");

		// Step Four Change Password
		// Old Password
		WebElement OldPassword = driver.findElement(By.id("password"));
		OldPassword.sendKeys(Keys.CONTROL + "a");
		OldPassword.sendKeys(Keys.DELETE);
		OldPassword.sendKeys("ers_qa");
		// New Password
		WebElement NewPassword = driver.findElement(By.id("newPassword"));
		NewPassword.sendKeys(Keys.CONTROL + "a");
		NewPassword.sendKeys(Keys.DELETE);
		NewPassword.sendKeys("Test*12345678");
		// Retype New Password
		WebElement ReTypNewPawrd = driver.findElement(By.id("retypeNewPassword"));
		ReTypNewPawrd.sendKeys(Keys.CONTROL + "a");
		ReTypNewPawrd.sendKeys(Keys.DELETE);
		ReTypNewPawrd.sendKeys("Test*12345678");

		// Click Finish
		driver.findElement(By.xpath("//*[@id=\'globalContent\']/div/form/ul[2]/li[3]")).click();
		sleep(3);

		return true;
	}
}
