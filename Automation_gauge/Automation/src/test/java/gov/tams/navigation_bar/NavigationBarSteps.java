package gov.tams.navigation_bar;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import gov.tams.common.CommonSteps;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Steps for Dashboard
 */
public final class NavigationBarSteps extends CommonSteps {

    private Logger logger;
    private NavigationBar navigationBar;

    public NavigationBarSteps() {
        init();
    }

    private void init () {
        navigationBar = navigationBar == null ? new NavigationBar(getDriver()) : navigationBar;
        logger = logger == null ? Logger.getLogger(NavigationBarSteps.class) : logger;
    }

    @Step("Validate User Dashboard")
    public void validateUserDashboard () {
        String msg = "Missing step implementation";
        logger.error(msg);
        Gauge.writeMessage(msg);
    }

    @Step("Click Dashboard link")
    public void clickDashboardLink () { navigationBar.clickDashboardLink(); }

    @Step("Click NOC List link")
    public void clickNocListLink () { navigationBar.clickNocListLink(); }

    @Step("Click Contract Management link")
    public void clickContractManagementLink () {
        navigationBar.clickContractManagementLink();
    }

    @Step("Logout")
    public void logout () {
        try {
            navigationBar.clickLogoutLink();
        } catch ( ElementClickInterceptedException e ) {
            logger.error("Logout link are not visible. Closing modal window...");
            closeModalWindow();
            navigationBar.clickLogoutLink();
        }
        logger.info("User logged out");
    }
}
