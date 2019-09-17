package gov.tams.navigation_bar;

import gov.tams.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static gov.tams.navigation_bar.NavigationBarVO.*;

/**
 * @author erlan.beisen
 * August, 8 2019
 */
final class NavigationBar extends CommonPage {

    private Logger logger;

    NavigationBar(WebDriver webDriver) {
        super(webDriver);
        init();
    }

    private void init () { logger = logger == null ? Logger.getLogger(NavigationBar.class) : logger; }

    boolean isUserProfileDropdownLink () {
        return isDisplayed(userNameDropdownLink);
    }

    void clickUserProfileDropdownLink () {
        click(userNameDropdownLink);
        logger.info("Clicked on user profile dropdown link");
    }

    void clickLogoutLink () {
        boolean isLogoutLink = isDisplayed(logoutLink);
        if ( !isLogoutLink ) {
            clickUserProfileDropdownLink();
        }
        click(logoutLink);
        logger.info("Clicked on logout link");
    }

    void clickDashboardLink () {
        click(dashboardLink);
        logger.info("Clicked on Dashboard link");
    }

    void clickNocListLink () {
        click(nocListLink);
        logger.info("Clicked on NOC List link");
    }

    void clickContractManagementLink () {
        click(contractManagementLink);
        logger.info("Clicked on Contract Management link");
    }
}
