package gov.tams.login;

import com.thoughtworks.gauge.Step;
import gov.tams.common.CommonProperties;
import gov.tams.common.CommonSteps;
import org.apache.log4j.Logger;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Steps for Log In Page
 */
public final class LoginSteps extends CommonSteps {

    private Logger logger;
    private LoginPage loginPage;

    public LoginSteps() {
        init();
    }

    private void init () {
        logger = logger == null ? Logger.getLogger(LoginSteps.class) : logger;
        loginPage = loginPage == null ? new LoginPage(getDriver()) : loginPage;
    }

    @Step("Navigate to Login page")
    public void navigateToLoginPage() {
        if ( !loginPage.isLoginPage() ) {
            loginPage.navigateToLoginPage();
            logger.info("Navigate to " + CommonProperties.BASE_URL);
        }
    }

    @Step("Sign in as Contract Auditor")
    public void signInAsContractAuditor () {
        loginPage.logIn(CommonProperties.CONTRACT_AUDITOR_USER_NAME, CommonProperties.CONTRACT_AUDITOR_USER_PASSWORD);
        logger.info("Log In as Contract Auditor");
        CommonProperties.CURRENT_USER_ID = CommonProperties.CONTRACT_AUDITOR_USER_NAME;
    }

    @Step("Sign in as GSA Auditor")
    public void signInAsGsaAuditor () {
        loginPage.logIn(CommonProperties.GSA_AUDITOR_USER_NAME, CommonProperties.GSA_AUDITOR_USER_PASSWORD);
        logger.info("Log In as GSA Auditor");
        CommonProperties.CURRENT_USER_ID = CommonProperties.GSA_AUDITOR_USER_NAME;
        CommonProperties.CURRENT_USER_NAME = "GSA Auditor";
        if ( !isUserProfile() ) { loginPage.clickSignInButton(); }
    }
}
