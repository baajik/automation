package gov.tams.login;

import gov.tams.common.CommonPage;
import gov.tams.common.CommonProperties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static gov.tams.login.LoginVO.*;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Log In page User actions
 */
final class LoginPage extends CommonPage {

    private Logger logger;

    LoginPage ( WebDriver webDriver ) {
        super( webDriver );
        init();
    }

    private void init () { logger = logger == null ? Logger.getLogger(LoginPage.class) : logger; }

    boolean isLoginPage () { return isDisplayed(signInButton); }

    void navigateToLoginPage () { navigateUrl(CommonProperties.BASE_URL); }

    void enterUserName ( String userName ) {
        sendKeys(signInUserNameTextBox, userName);
        logger.info("Entered " + userName + " user name");
    }

    void enterPassword ( String password ) {
        sendKeys(signInPasswordTextBox, password);
        logger.info("Entered " + password + " user password");
    }

    void clickSignInButton () {
        click(signInButton);
        logger.info("Clicked on Sign In button");
    }

    void logIn ( String userName, String password ) {
        enterUserName(userName);
        enterPassword(password);
        clickSignInButton();
    }
}
