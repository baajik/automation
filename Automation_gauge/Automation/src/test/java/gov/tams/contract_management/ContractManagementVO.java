package gov.tams.contract_management;

import org.openqa.selenium.By;

/**
 * @author erlan.beisen
 * August, 19 2019
 * Web Elements locators of Contract Management page
 */
final class ContractManagementVO {

    private ContractManagementVO() {}

    static final String CONTRACT_NUMBER_LINK_XPATH = "//tbody//a/span[text()=\"{0}\"]";
    static final String CONTRACT_COMPANY_NAME_FIELD_XPATH ="//table//span[text()=\"{0}\"]/ancestor::tr//td[2]";
    static final String FISCAL_YEAR_FIELD_XPATH ="//table//span[text()=\"{0}\"]/ancestor::tr//td[3]";

    static final By RESET_FILTERS_BUTTON = By.xpath("//button[text()='Reset Filters']");
    static final By SHOW_RECORDS_DROPDOWN = By.id("show-records-select");

    /**
     * @author erlan.beisen
     * August, 19 2019
     * A Sub Page of Contract Management page
     */
    final static class ContractDetailsVO {

        private ContractDetailsVO () {}

        /* header */
        static final By CONTRACT_DETAILS_TITLE = By.cssSelector(".contract-details-title");
        /* links */
        static final String CONTRACT_FISCAL_YEAR_LINK_XPATH = "//ul[contains(@class,'contract-years')]//a[text()=\"{0}\"]";
        static final By RETURN_TO_SEARCH_RESULTS_LINK = By.cssSelector(".return-results");
        /* buttons */
        static final By CONTRACT_AUDITOR_PROFILE_UPDATE_BUTTON = By.id("btn-update-auditor-data");
        static final By CONTRACT_AUDITOR_PROFILE_SAVE_BUTTON = By.xpath("//h4[text()='Contract Auditor Profile']/../..//button[text()='Save']");
        static final By CONTRACT_AUDITOR_PROFILE_CANCEL_BUTTON = By.xpath("//h4[text()='Contract Auditor Profile']/../..//button[text()='Save']");
        static final By APPROPRIATIONS_AND_ALLOCATIONS_UPDATE_BUTTON = By.id("btn-update-allocations");
        static final By APPROPRIATIONS_AND_ALLOCATIONS_SAVE_BUTTON = By.xpath("//h4[text()='Appropriations and Allocations']/../..//button[text()='Save']");
        static final By APPROPRIATIONS_AND_ALLOCATIONS_CANCEL_BUTTON = By.xpath("//h4[text()='Appropriations and Allocations']/../..//button[text()='Save']");
        static final By COMMISSION_BY_MODE_UPDATE_BUTTON = By.id("btn-update-mode-data");
        static final By COMMISSION_BY_MODE_SAVE_BUTTON = By.xpath("//h4[text()='Commission By Mode']/../..//button[text()='Save']");
        static final By COMMISSION_BY_MODE_CANCEL_BUTTON = By.xpath("//h4[text()='Commission By Mode']/../..//button[text()='Save']");
        /* sections */
        static final By CONTRACT_AUDITOR_PROFILE_SECTION = By.cssSelector(".section-contractor-info");
        static final By APPROPRIATIONS_AND_ALLOCATIONS_SECTION = By.cssSelector(".section-allocations");
        static final By CONTRACT_PERFORMANCE_DATA_SECTION = By.cssSelector(".contract-performance");
        static final By COMMISSION_BY_MODE_SECTION = By.cssSelector(".section-mode-data");
        /* section fields */
        static final String FIELD_VALUE_XPATH = "//p[contains(.,\"{0}\")]/span";
        static final String CONTRACT_PERFORMANCE_DATA_TABLE_FIELD_VALUE_XPATH = "//table[contains(@class,'contract-performance')]//td[text()=\"{0}\"]/following-sibling::td";
        /* Contract Auditor Profile entry fields */
        static final By CONTRACTOR_CODE_TEXT_BOX = By.name("contractCode");
        static final By COMPANY_NAME_TEXT_BOX = By.name("organizationName");
        static final By ADDRESS_1_TEXT_BOX = By.name("addressOne");
        static final By ADDRESS_2_TEXT_BOX = By.name("addressTwo");
        static final By CITY_TEXT_BOX = By.name("city");
        static final By STATE_DROPDOWN = By.name("state");
        static final By ZIP_TEXT_BOX = By.name("zip");
        static final By TIN_TEXT_BOX = By.name("tin");
        static final By REPRESENTATIVE_TEXT_BOX = By.name("representativeName");
        static final By EMAIL_TEXT_BOX = By.name("representativeEmail");
        static final By PHONE_TEXT_BOX = By.name("representativePhone");
        static final By FAX_NUMBER_TEXT_BOX = By.name("representativeFax");
        /* Commission By Mode */
        static final By COMMISSION_TEXT_BOX = By.name("commissionPer");
        static final By AUDIT_TYPE_DROPDOWN = By.name("auditType");
        static final By STATUS_DROPDOWN = By.name("status");
    }
}