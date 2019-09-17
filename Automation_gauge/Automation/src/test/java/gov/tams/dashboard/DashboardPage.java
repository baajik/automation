package gov.tams.dashboard;

import gov.tams.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;

import static gov.tams.dashboard.DashboardVO.*;

/**
 * @author erlan.beisen
 * August, 26 2019
 * Dashboard page User actions
 */
final class DashboardPage extends CommonPage {

    private Logger logger;

    DashboardPage (WebDriver webDriver) {
        super(webDriver);
        init();
    }

    private void init () { logger = logger == null ? Logger.getLogger(DashboardPage.class) : logger; }

    String getTitle () {
        return getText(NOC_LIST_TITLE);
    }

    String getStatus ( String drn ) {
        String xpath = MessageFormat.format(statusFieldXpath, drn);
        scrollToElement(By.xpath(xpath));
        return getText(By.xpath(xpath));
    }

    String getDueDate ( String drn ) {
        String xpath = MessageFormat.format(dueDateFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getIssueDate ( String drn ) {
        String xpath = MessageFormat.format(issueDateFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getAmount ( String drn ) {
        String xpath = MessageFormat.format(amountFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getCompany ( String drn ) {
        String xpath = MessageFormat.format(companyFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getAction ( String drn ) {
        String xpath = MessageFormat.format(actionLinkXpath, drn);
        return getText(By.xpath(xpath));
    }

    void clickActionLink ( String drn ) {
        String xpath = MessageFormat.format(actionLinkXpath, drn);
        click(By.xpath(xpath));
    }
}
