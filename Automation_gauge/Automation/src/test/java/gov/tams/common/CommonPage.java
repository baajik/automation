package gov.tams.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Common;
import utilities.Page;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static gov.tams.common.CommonVO.*;

/**
 * @author erlan.beisen
 * August, 20 2019
 * TAMS common web page actions
 */
public class CommonPage extends Page {

    private Logger logger;

    protected CommonPage ( WebDriver webDriver ) {
        super(webDriver);
        init();
    }

    private void init () {
        logger = logger == null ? Logger.getLogger(CommonPage.class) : logger;
    }

    enum DrnDetailsField {
        DOC_REF_NUMBER("Doc. Ref Number"), CARRIER_BILL_NUMBER("Carrier Bill Number"), SCAC("SCAC"),
        AGENCY_CODE("Agency Code"), SPECIAL_ISSUE_CODE("Special Issue Code"), IATA_CODE("IATA Code"),
        AUDITOR_NUMBER("Auditor Number"), TIME_SPEND_BY_AUDITOR("Time Spent By Auditor"), AUDIT_COMPANY("Audit Company"),
        PREPAYMENT_AUDITOR("Prepayment Auditor"), DATE_EBILL_CREATED("Date EBill Created"), SHOULD_BE_AMOUNT("Should Be Amount"), AMOUNT_PAID("Amount Paid"),
        OVERCHARGE_AMOUNT("Overcharge Amount"), OVERCHARGE_TYPE("Overcharge Type"), FOREIGN_CURRENCY("Foreign Currency"), DATE_BILL_PAID("Date Bill Paid"),
        DATE_INVOICE_RECEIVED("Date Invoice Received"), ORIGIN_CITY("Origin City"), ORIGIN_STATE("State"), ORIGIN_COUNTRY("Country"),
        DESTINATION_CITY("Destination City"), DESTINATION_STATE("State"), DESTINATION_COUNTRY("Country"),
        SHIPPING_DATE("Shipping Date"), MODE("Mode"), GTR_GBL_INDICATOR("GTR/GBL Indicator"), SHIP_SPECIFIC_REFERENCE("Ship Specific Reference"),
        ROUTING("Routing"), BASIS_AND_AUTHORITY("Basis And Authority");
        private String description;
        DrnDetailsField ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    enum DrnAuditLogColumn {
        CREATED_ON("1"), CHANGED_BY("2"), NOC_PROPERTY_NAME("3"),
        OLD_VALUE("4"), NEW_VALUE("5");
        private String description;
        DrnAuditLogColumn ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    enum DrnWorkflowLogColumn {
        DOCUMENT_REF_NUMBER("1"), STEP_NAME("2"), STARTED_ON("3"),
        ACTION_TAKEN("4"), ACTION_TAKEN_ON("5"), PERFORMED_BY("6");
        private String description;
        DrnWorkflowLogColumn ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    /**
     * Checks if User Logo is displayed on Navigation Bar
     * @author erlan.beisen
     * @return - boolean
     */
    boolean isUserInfo () { return isDisplayed(headerUserInfoLogo); }

    /**
     * @author erlan.beisen
     * @param fieldName - Field Name text
     * @param value - value
     * @return - selected dropdown value
     */
    protected String selectDropdown ( String fieldName, String value ) {
        By fieldLocator = By.xpath("//label[contains(text(),'" + fieldName + "')]/..");
        By arrowLocator = By.cssSelector(".Select-arrow-zone");
        By valueLocator = By.xpath("//div[contains(@class,'VirtualizedSelectOption')][contains(text(),'" + value + "')]");
        click(getElementInElement(fieldLocator, arrowLocator));
        click(getElementInElement(fieldLocator, valueLocator));

        By selectedValueLocator = By.cssSelector(".Select-value-label");
        return getText(fieldLocator, selectedValueLocator);
    }

    /**
     * @author erlan.beisen
     * @param fieldName - Field Name text
     * @return - randomly selected dropdown value
     */
    protected String randomSelectDropdown ( String fieldName ) {
        By fieldNameLocator = By.xpath("//label[contains(text(),'" + fieldName + "')]/..");
        By arrowLocator = By.cssSelector(".Select-arrow-zone");
        By valueLocator = By.xpath("//div[contains(@class,'VirtualizedSelectOption')]");
        By inputLocator = By.tagName("input");
        By selectedValueLocator = By.cssSelector(".Select-value-label");

        click(getElementInElement(fieldNameLocator, arrowLocator));
        List<String> dropdownValues = getElementsInElementString(fieldNameLocator, valueLocator);
        String value = dropdownValues.get(Common.getRandomInt(0, dropdownValues.size() - 1));
        /* Sends randomly selected value to dropdown input */
        getElementInElement(fieldNameLocator, inputLocator).sendKeys(value);

        String virtualizedSelectOption = "//div[contains(@class,'VirtualizedSelectOption')]";
        boolean isValue = isDisplayed(By.xpath(virtualizedSelectOption + "[contains(text(),'" + value + "')]"));
        if ( !isValue ) {
            String firstValueText = getText(By.xpath(virtualizedSelectOption));
            isValue = value.contains(firstValueText);
            if ( isValue ) {
                click(By.xpath(virtualizedSelectOption));
            }
        } else {
            click(By.xpath(virtualizedSelectOption + "[contains(text(),'" + value + "')]"));
        }
        return getText(fieldNameLocator, selectedValueLocator);
    }

    protected List<String> selectedDropdownValues ( String fieldName ) {
        By dropdownValueLocator = By.xpath("//label[contains(text(),'" + fieldName + "')]/..//*[@class='Select-value-label']");

        boolean isSelectedDropdownValue = isDisplayed(dropdownValueLocator);
        int secondsWait = 0;
        while ( !isSelectedDropdownValue && secondsWait < 3 ) {
            Common.sleep(1);
            secondsWait++;
            isSelectedDropdownValue = isDisplayed(dropdownValueLocator);
        }
        return isSelectedDropdownValue ? getElementsString(dropdownValueLocator) : new ArrayList<>();
    }

    protected String selectedDropdownValue ( String fieldName ) {
        return selectedDropdownValues(fieldName).get(0);
    }

    protected void showResults ( By byDropdown, String results ) {
        String [] possibleNumberOfResults = {"10", "25", "all"};
        for ( String possibleNumberOfResult : possibleNumberOfResults ) {
            if ( !possibleNumberOfResult.equalsIgnoreCase(results) ) {
                Common.failTest(results + " can not be as Show Results value\nPossible values are: 10, 25, All");
            }
        }
        selectDropdown(byDropdown, results);
    }

    protected int getRowByColumnValue ( By tableLocator, String columnName, String value ) {
        List<WebElement> columnElements = getElementsInElement(tableLocator, By.tagName("th"));
        int columnNumber = 0;
        for ( int index = 0; index < columnElements.size(); index++ ) {
            String actualColumnName = getText(columnElements.get(index));
            if ( actualColumnName.equalsIgnoreCase(columnName) ) {
                columnNumber = index + 1;
                break;
            }
        }
        List<WebElement> rowElements = getElementsInElement(tableLocator, By.xpath(".//tbody//tr"));
        int rowNumber = 0;
        for ( int row = 1; row <= rowElements.size(); row++ ) {
            WebElement rowValueElements = getElementInElement(tableLocator, By.xpath(".//tbody//tr[" + row + "]//td[" + columnNumber + "]"));
            String actualRowValue = getText(rowValueElements);
            if ( actualRowValue.contains(value) ) {
                rowNumber = row;
                break;
            }
        }
        return rowNumber;
    }

    void clickDrnLink ( String drn ) {
        String xpath = MessageFormat.format(drnLinkXpath, drn);
        click(By.xpath(xpath));
    }

    private By getDrnSummaryModalWindowLocator ( String drn ) {
        String xpath = MessageFormat.format(drnSummaryModalWindowXpath, drn);
        return By.xpath(xpath);
    }

    boolean isDrnSummaryModalWindow ( String drn ) {
        return isDisplayed(getDrnSummaryModalWindowLocator(drn));
    }

    void clickDrnDetailsLinkOnDrnSummaryWindow ( String drn ) { click(getDrnSummaryModalWindowLocator(drn), By.xpath(drnDetailsModalWindowXLinkXpath)); }

    boolean isDrnDetailsTabOnDrnSummaryWindow () {
        return isDisplayed(By.xpath(drnDetailsTabModalWindowXLinkXpath));
    }

    void clickDrnAuditLogLinkOnDrnSummaryWindow ( String drn ) { click(getDrnSummaryModalWindowLocator(drn), By.xpath(drnAuditLogModalWindowXLinkXpath)); }

    boolean isDrnAuditLogTabOnDrnSummaryWindow () {
        return isDisplayed(By.xpath(drnAuditLogTabModalWindowXLinkXpath));
    }

    void clickDrnWorkflowLogLinkOnDrnSummaryWindow ( String drn ) { click(getDrnSummaryModalWindowLocator(drn), By.xpath(drnWorkflowLogModalWindowXLinkXpath)); }

    boolean isDrnWorkflowLogTabOnDrnSummaryWindow () { return isDisplayed(By.xpath(drnWorkflowLogTabModalWindowXLinkXpath)); }

    boolean isNoRecords () { return isDisplayed(noRecordsTextField); }

    String getDrnDetailsFieldValue ( DrnDetailsField drnDetailsField ) {
        String xpath = MessageFormat.format(drnDetailsModalWindowFieldXpath, drnDetailsField.getFieldName());
        By fieldLocator = By.xpath(xpath);
        if ( isDisplayed(fieldLocator) ) { scrollToElementView(fieldLocator); }
        return getText(fieldLocator);
    }

    String getNumberOfRecords () { return getText(recordsTextField); }

    String getDrnAuditLogFieldValue ( int row, DrnAuditLogColumn drnAuditLogColumn ) {
        String xpath = MessageFormat.format(drnModalWindowTableFieldXpath, row, drnAuditLogColumn.getFieldName());
        By fieldLocator = By.xpath(xpath);
        if ( isDisplayed(fieldLocator) ) { scrollToElementView(fieldLocator); }
        return getText(fieldLocator);
    }

    int getModalWindowRowByColumnValue ( String columnName, String value ) { return getRowByColumnValue(drnModalWindowTableXpath, columnName, value); }

    String getDrnWorkFlowLogFieldValue ( int row, DrnWorkflowLogColumn drnWorkflowLogColumn ) {
        String xpath = MessageFormat.format(drnModalWindowTableFieldXpath, row, drnWorkflowLogColumn.getFieldName());
        By fieldLocator = By.xpath(xpath);
        if ( isDisplayed(fieldLocator) ) { scrollToElementView(fieldLocator); }
        return getText(fieldLocator);
    }

    void closeModalWindow () {
        boolean isModalWindow = isDisplayed(By.cssSelector(".modal-content"));
        if ( isModalWindow ) click(By.xpath("//*[@class='modal-content']//span[text()='×']"));
    }
}