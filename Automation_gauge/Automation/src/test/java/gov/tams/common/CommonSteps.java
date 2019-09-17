package gov.tams.common;

import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utilities.Common;
import utilities.DataStore;
import utilities.Steps;

import java.util.List;

/**
 * @author erlan.beisen
 * August, 16 2019
 * TAMS common steps
 */
public class CommonSteps extends Steps {

    private Logger logger;
    private CommonPage commonPage;
    private CommonDatabaseActions commonDatabaseActions;

    public CommonSteps() { init(); }

    private void init () {
        logger = logger == null ? Logger.getLogger(CommonSteps.class) : logger;
        commonPage = commonPage == null ? new CommonPage(getDriver()) : commonPage;
        commonDatabaseActions = commonDatabaseActions == null ? new CommonDatabaseActions() : commonDatabaseActions;
    }

    @Step("Scenario/Row <scenario>")
    public void clickSubmitButtonOnCreateNocPage ( String scenario ) {
        Common.getPastDate("MM/dd/yyyy", 3);
        Gauge.writeMessage(scenario);
    }

    @Step("Click DRN link")
    public void clickDrnLink() {
        String drn = NocVO.getDrn();
        commonPage.clickDrnLink(drn);
        Assert.assertTrue(commonPage.isDrnSummaryModalWindow(drn), drn + " Summary modal window was not displayed");
    }

    @Step("Click DRN-Details Link on DRN Summary Window")
    public void clickDrnDetailsLinkOnDrnSummaryWindow() {
        commonPage.clickDrnDetailsLinkOnDrnSummaryWindow(NocVO.getDrn());
        softAssertTrue(commonPage.isDrnDetailsTabOnDrnSummaryWindow(), "DRN-Details tab on DRN Summary modal window was not displayed");
        assertAll();
    }

    @ContinueOnFailure
    @Step("Validate DRN-Details on DRN Summary Window")
    public void validateDrnDetailsOnDrnSummaryWindow() {
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DOC_REF_NUMBER), NocVO.getDrn(), "Document Reference Number (DRN)");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.CARRIER_BILL_NUMBER), NocVO.getCarrierBillNumber(), "Carrier Bill Number");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.SCAC), NocVO.getScac().substring(0, NocVO.getScac().indexOf(' ')), "SCAC");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.AGENCY_CODE), NocVO.getAgencyCode(), "Agency Code");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.SPECIAL_ISSUE_CODE), NocVO.getSpecialIssueCode().substring(0, NocVO.getSpecialIssueCode().indexOf(' ')), "Special Issue Code");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.IATA_CODE), NocVO.getIataCode(), "IATA Code");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.AUDITOR_NUMBER), NocVO.getAuditorNumber(), "Auditor Number");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.TIME_SPEND_BY_AUDITOR), NocVO.getTimeSpentByAuditor(), "Time Spent By Auditor");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.AUDIT_COMPANY), NocVO.getAuditCompany().substring(0, NocVO.getAuditCompany().indexOf(' ')), "Audit Company");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.PREPAYMENT_AUDITOR), NocVO.getPrepaymentAuditor(), "Prepayment Auditor");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DATE_EBILL_CREATED), Common.changeDateFormat(NocVO.getDateEBillCreated(), "MM/dd/yyyy", "M/d/yyyy"), "Date EBill Created");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.SHOULD_BE_AMOUNT), Common.getUsCurrency(NocVO.getShouldBeAmount()), "Should Be Amount");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.AMOUNT_PAID), Common.getUsCurrency(NocVO.getAmountPaid()), "Amount Paid");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.OVERCHARGE_AMOUNT), Common.getUsCurrency(NocVO.getOverchargeAmount()), "Overcharge Amount");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.OVERCHARGE_TYPE), NocVO.getOverchargeType().substring(0, NocVO.getOverchargeType().indexOf(' ')), "Overcharge Type");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.FOREIGN_CURRENCY), NocVO.getForeignCurrency(), "Foreign Currency");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DATE_BILL_PAID), Common.changeDateFormat(NocVO.getDateBillPaid(), "MM/dd/yyyy", "M/d/yyyy"), "Date Bill Paid");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DATE_INVOICE_RECEIVED), Common.changeDateFormat(NocVO.getDateInvoiceReceived(), "MM/dd/yyyy", "M/d/yyyy"), "Date Invoice Received");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.ORIGIN_CITY), NocVO.getOriginCity(), "Origin City");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.ORIGIN_STATE), NocVO.getOriginState(), "Origin State");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.ORIGIN_COUNTRY), NocVO.getOriginCountry(), "Origin Country");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DESTINATION_CITY), NocVO.getDestinationCity(), "Destination City");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DESTINATION_STATE), NocVO.getDestinationState(), "Destination State");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.DESTINATION_COUNTRY), NocVO.getDestinationCountry(), "Destination Country");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.SHIPPING_DATE), Common.changeDateFormat(NocVO.getShippingDate(), "MM/dd/yyyy", "M/d/yyyy"), "Shipping Date");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.MODE), NocVO.getMode().substring(0, NocVO.getMode().indexOf(' ')), "Mode");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.GTR_GBL_INDICATOR), NocVO.getGtrGblIndicator(), "GTR/GBL Indicator");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.SHIP_SPECIFIC_REFERENCE), NocVO.getShipSpecificReference(), "Ship Specific Reference");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.ROUTING), NocVO.getAdditionalRoutingInformation(), "Routing");
        softAssertEquals(commonPage.getDrnDetailsFieldValue(CommonPage.DrnDetailsField.BASIS_AND_AUTHORITY), NocVO.getBasisAndAuthority(), "Basis And Authority");
        assertAll();
    }

    @Step("Click DRN-Audit Log Link on DRN Summary Window")
    public void clickDrnAuditLogLinkOnDrnSummaryWindow() {
        commonPage.clickDrnAuditLogLinkOnDrnSummaryWindow(NocVO.getDrn());
        softAssertTrue(commonPage.isDrnAuditLogTabOnDrnSummaryWindow(), "DRN-Audit Log tab on DRN Summary modal window was not displayed");
        assertAll();
    }

    @ContinueOnFailure
    @Step("Validate DRN-Audit Log on DRN Summary Window")
    public void validateDrnAuditLogOnDRNSummaryWindow() {
        int numberOfAuditLogs = DataStore.isObjectKey("audit log") ? DataStore.getValueAsInt("audit log") : 0;
        if ( numberOfAuditLogs == 0 ) {
            softAssertTrue(commonPage.isNoRecords(), "DRN - Audit Log: No Records");
        } else {
            String actualRecords = commonPage.getNumberOfRecords();
            softAssertTrue(actualRecords.contains("Total Records Found " + numberOfAuditLogs + "."), "Number of Audit Logs");

            List<String> updatedNocPropertyList = DataStore.getValueAsList("updated noc property list");
            int auditLogRecordsNumber = updatedNocPropertyList.size();
            for ( int index = 0; index < updatedNocPropertyList.size(); index++ ) {
                String nocPropertyName = updatedNocPropertyList.get(index);
                logger.info("NOC property name: " + nocPropertyName);
                int row = commonPage.getModalWindowRowByColumnValue("Noc Property Name", nocPropertyName);

                String actualCreatedOn = Common.changeDateFormat(commonPage.getDrnAuditLogFieldValue(row, CommonPage.DrnAuditLogColumn.CREATED_ON), "MM/dd/yyyy hh:mm:ss", "M/d/yyyy");
                String actualChangedBy = commonPage.getDrnAuditLogFieldValue(row, CommonPage.DrnAuditLogColumn.CHANGED_BY);
                String actualOldValue = commonPage.getDrnAuditLogFieldValue(row, CommonPage.DrnAuditLogColumn.OLD_VALUE);
                String actualNewValue = commonPage.getDrnAuditLogFieldValue(row, CommonPage.DrnAuditLogColumn.NEW_VALUE);

                softAssertEquals(actualCreatedOn, Common.getCurrentDate("M/d/yyyy"), nocPropertyName + "Created on");
                softAssertEquals(actualChangedBy, CommonProperties.CURRENT_USER_NAME, nocPropertyName + "Changed by");
                softAssertEquals(actualOldValue, DataStore.getValueAsString(nocPropertyName + " 1"), nocPropertyName + " Old Value");
                softAssertEquals(actualNewValue, DataStore.getValueAsString(nocPropertyName + " 2"), nocPropertyName + " New Value");
                auditLogRecordsNumber--;
            }
            softAssertEquals(String.valueOf(auditLogRecordsNumber), "0", "Updated NOC Property List");
        }
        assertAll();
    }

    @Step("Click DRN-Workflow Log Link on DRN Summary Window")
    public void clickDrnWorkflowLogLinkOnDrnSummaryWindow() {
        commonPage.clickDrnWorkflowLogLinkOnDrnSummaryWindow(NocVO.getDrn());
        softAssertTrue(commonPage.isDrnWorkflowLogTabOnDrnSummaryWindow(), "DRN-Workflow Log tab on DRN Summary modal window was not displayed");
        assertAll();
    }

    /**
     * Step is not valid
     */
    @ContinueOnFailure
    @Step("Validate DRN-Workflow Log on DRN Summary Window")
    public void validateDrnWorkflowLogOnDRNSummaryWindow() {
//        temporary commented validation for DRN workflow log
//        validateRow1UnderDrnWorkflowLog();
//        validateRow2UnderDrnWorkflowLog();
//        validateRow3UnderDrnWorkflowLog();
//        assertAll();
    }

//    private void validateRow1UnderDrnWorkflowLog () {
//        int row = 1;
//        String expectedDocumentRefNumber = NocVO.getDrn();
//        String expectedStepName = "Edit NOC";
//        String expectedStartedOn = Common.getCurrentDate("M/d/yyyy");
//        String expectedActionTaken = "Submit NOC";
//        String expectedActionTakenOn = Common.getCurrentDate("M/d/yyyy");
//        String expectedPerformedBy = CommonProperties.CURRENT_USER_ID;
//
//        String actualDocumentRefNumber = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.DOCUMENT_REF_NUMBER);
//        String actualStepName = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.STEP_NAME);
//        String actualStartedOn = Common.changeDateFormat(commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.STARTED_ON), "MM/dd/yyyy, h:mm:ss a", "M/d/yyyy");
//        String actualActionTaken = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.ACTION_TAKEN);
//        String actualActionTakenOn = Common.changeDateFormat(commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.ACTION_TAKEN_ON), "M/d/yyyy, h:mm:ss a", "M/d/yyyy");
//        String actualPerformedBy = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.PERFORMED_BY);
//
//        softAssertEquals(actualDocumentRefNumber, expectedDocumentRefNumber, "Row " + row + " Document Ref Number");
//        softAssertEquals(actualStepName, expectedStepName, "Row " + row + " Step Name");
//        softAssertEquals(actualStartedOn, expectedStartedOn, "Row " + row + " Started On");
//        softAssertEquals(actualActionTaken, expectedActionTaken, "Row " + row + " Action Taken");
//        softAssertEquals(actualActionTakenOn, expectedActionTakenOn, "Row " + row + " Action Taken On");
//        softAssertEquals(actualPerformedBy, expectedPerformedBy, "Row " + row + " Performed By");
//    }
//
//    private void validateRow2UnderDrnWorkflowLog () {
//        int row = 2;
//        String expectedDocumentRefNumber = NocVO.getDrn();
//        String expectedStepName = "Review Submitted NOC";
//        String expectedStartedOn = Common.getCurrentDate("M/d/yyyy");
//        String expectedActionTaken = "Sent to TSP";
//        String expectedActionTakenOn = Common.getCurrentDate("M/d/yyyy");
//        String expectedPerformedBy = CommonProperties.CURRENT_USER_ID;
//
//        String actualDocumentRefNumber = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.DOCUMENT_REF_NUMBER);
//        String actualStepName = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.STEP_NAME);
//        String actualStartedOn = Common.changeDateFormat(commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.STARTED_ON), "M/d/yyyy, h:mm:ss a", "M/d/yyyy");
//        String actualActionTaken = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.ACTION_TAKEN);
//        String actualActionTakenOn = Common.changeDateFormat(commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.ACTION_TAKEN_ON), "M/d/yyyy, h:mm:ss a", "M/d/yyyy");
//        String actualPerformedBy = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.PERFORMED_BY);
//
//        softAssertEquals(actualDocumentRefNumber, expectedDocumentRefNumber, "Row " + row + " Document Ref Number");
//        softAssertEquals(actualStepName, expectedStepName, "Row " + row + " Step Name");
//        softAssertEquals(actualStartedOn, expectedStartedOn, "Row " + row + " Started On");
//        softAssertEquals(actualActionTaken, expectedActionTaken, "Row " + row + " Action Taken");
//        softAssertEquals(actualActionTakenOn, expectedActionTakenOn, "Row " + row + " Action Taken On");
//        softAssertEquals(actualPerformedBy, expectedPerformedBy, "Row " + row + " Performed By");
//    }
//
//    private void validateRow3UnderDrnWorkflowLog () {
//        int row = 3;
//        String expectedDocumentRefNumber = NocVO.getDrn();
//        String expectedStepName = "TSP Review NOC";
//        String expectedStartedOn = Common.getCurrentDate("M/d/yyyy");
//        String expectedActionTaken = "";
//        String expectedActionTakenOn = "";
//        String expectedPerformedBy = "tfedex";
//
//        String actualDocumentRefNumber = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.DOCUMENT_REF_NUMBER);
//        String actualStepName = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.STEP_NAME);
//        String actualStartedOn = Common.changeDateFormat(commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.STARTED_ON), "M/d/yyyy, h:mm:ss a", "M/d/yyyy");
//        String actualActionTaken = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.ACTION_TAKEN);
//        String actualActionTakenOn = Common.changeDateFormat(commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.ACTION_TAKEN_ON), "M/d/yyyy, h:mm:ss a", "M/d/yyyy");
//        String actualPerformedBy = commonPage.getDrnWorkFlowLogFieldValue(row, CommonPage.DrnWorkflowLogColumn.PERFORMED_BY);
//
//        softAssertEquals(actualDocumentRefNumber, expectedDocumentRefNumber, "Row " + row + " Document Ref Number");
//        softAssertEquals(actualStepName, expectedStepName, "Row " + row + " Step Name");
//        softAssertEquals(actualStartedOn, expectedStartedOn, "Row " + row + " Started On");
//        softAssertEquals(actualActionTaken, expectedActionTaken, "Row " + row + " Action Taken");
//        softAssertEquals(actualActionTakenOn, expectedActionTakenOn, "Row " + row + " Action Taken On");
//        softAssertEquals(actualPerformedBy, expectedPerformedBy, "Row " + row + " Performed By");
//    }

    @Step("Close modal window")
    public void closeModalWindow () {
        commonPage.closeModalWindow();
        logger.info("Closed modal window");
    }

    @Step("Fail test with <errorMessage> error message")
    public void failTest ( String errorMessage ) {
        logger.error(errorMessage);
        Gauge.writeMessage(errorMessage);
        throw new RuntimeException(errorMessage);
    }

    @Step("Delete NOC record")
    public void deleteNocRecord () {
        commonDatabaseActions.deleteNocRecord();
    }

    protected boolean isUserProfile () { return commonPage.isUserInfo(); }
}
