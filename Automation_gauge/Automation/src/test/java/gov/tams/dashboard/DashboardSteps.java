package gov.tams.dashboard;

import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import gov.tams.common.CommonSteps;
import gov.tams.common.NocVO;
import org.apache.log4j.Logger;
import utilities.Common;

/**
 * @author erlan.beisen
 * August, 26 2019
 * Steps for Dashboard page
 */
public final class DashboardSteps extends CommonSteps {

    private Logger logger;
    private DashboardPage dashboardPage;

    public DashboardSteps() {
        init();
    }

    private void init() {
        dashboardPage = dashboardPage == null ? new DashboardPage(getDriver()) : dashboardPage;
        logger = logger == null ? Logger.getLogger(DashboardSteps.class) : logger;
    }

    @Step("Validate user is on Dashboard List page")
    public void validateUserIsOnDashboardPage () {
        String actualTitle = dashboardPage.getTitle();
        softAssertEquals(actualTitle, "Pending Tasks", "Dashboard title");
        assertAll();
    }

    @ContinueOnFailure
    @Step("Validate NOC Data on Dashboard page table")
    public void validateNocDataOnDashboardPageTable () {
        String drn = NocVO.getDrn();
        softAssertEquals(dashboardPage.getStatus(drn), NocVO.getNocStatus(), "Status");
        softAssertEquals(dashboardPage.getDueDate(drn), "", "Due Date");
        softAssertEquals(dashboardPage.getIssueDate(drn), NocVO.getDateEBillCreated(), "Issue Date");
        softAssertEquals(dashboardPage.getAmount(drn), Common.getUsCurrency(NocVO.getOverchargeAmount()), "Amount");
        softAssertEquals(dashboardPage.getCompany(drn), NocVO.getScac(), "Company");
        softAssertEquals(dashboardPage.getAction(drn), "Edit NOC", "Action");
        assertAll();
    }

    @Step("Click on <link> link on Dashboard page table")
    public void clickOnActionLinkOnDashboardPageTable ( String link ) {
        String drn = NocVO.getDrn();
        String actualLink = dashboardPage.getAction(drn);
        if ( !actualLink.equals(link) ) {
            failTest("Expected action link for DRN \"" + drn + "\" - " + link + ", but was " + actualLink);
        }
        dashboardPage.clickActionLink(drn);
    }
}
