package gov.tams.dashboard;

import org.openqa.selenium.By;

/**
 * @author erlan.beisen
 * August, 26 2019
 * Web Elements locators of Dashboard page
 */
final class DashboardVO {

    private DashboardVO() {}

    /* title */
    static final By NOC_LIST_TITLE = By.tagName("h3");
    /* Table fields found by using 'Doc Ref Number - DRN' */
    static final String drnLinkXpath = "//a[contains(., \"{0}\")]";
    static final String statusFieldXpath = "//tr[contains(.,\"{0}\")]//td[2]";
    static final String dueDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[3]";
    static final String issueDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[4]";
    static final String amountFieldXpath = "//tr[contains(.,\"{0}\")]//td[5]";
    static final String companyFieldXpath = "//tr[contains(.,\"{0}\")]//td[6]";
    /* links */
    static final String actionLinkXpath = "//tr[contains(.,\"{0}\")]//td[7]/a";
}
