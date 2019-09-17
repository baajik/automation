package gov.tams.noc_list;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import gov.tams.common.CommonProperties;
import gov.tams.common.CommonSteps;
import gov.tams.common.NocVO;
import org.apache.log4j.Logger;
import utilities.Common;
import utilities.TestDataFactory;

import java.util.Map;

/**
 * @author erlan.beisen
 * August, 13 2019
 * Steps for NOC List page
 */
public final class NocListSteps extends CommonSteps {

    private Logger logger;
    private NocListPage nocListPage;
    private NoticeOfOverchargeFormPage noticeOfOverchargeFormPage;

    public NocListSteps() {
        init();
    }

    private void init() {
        logger = logger == null ? Logger.getLogger(NocListSteps.class) : logger;
        nocListPage = nocListPage == null ? new NocListPage(getDriver()) : nocListPage;
        noticeOfOverchargeFormPage = noticeOfOverchargeFormPage == null ? new NoticeOfOverchargeFormPage(getDriver()) : noticeOfOverchargeFormPage;
    }

    @ContinueOnFailure
    @Step("Validate user is on NOC List page")
    public void validateUserIsOnNocListPage() {
        softAssertEquals(nocListPage.getTitle(), "Notice Of Overcharge", "NOC List title");
        assertAll();
    }

    @Step("Click Create NOC button")
    public void clickCreateNocButton() {
        nocListPage.clickCreateNocButton();
    }

    @ContinueOnFailure
    @Step("Validate submitted NOC Data on NOC List page table")
    public void validateSubmittedNocDataOnNocListPageTable() {
        String drn = NocVO.getDrn();
        softAssertEquals(nocListPage.getIssueDate(drn), Common.changeDateFormat(NocVO.getDateInvoiceReceived(), "MM/dd/yyyy", "M/d/yyyy"), "Issue Date");
        softAssertEquals(nocListPage.getPaidDate(drn), Common.changeDateFormat(NocVO.getDateBillPaid(), "MM/dd/yyyy", "M/d/yyyy"), "Paid Date");
        softAssertEquals(nocListPage.getOvercharge(drn), Common.getUsCurrency(NocVO.getOverchargeAmount()), "Overcharge");
        softAssertEquals(nocListPage.getStatus(drn), "Pending Review", "Status");
        softAssertEquals(nocListPage.getOwner(drn), CommonProperties.CURRENT_USER_ID, "Owner");
        softAssertEquals(nocListPage.getCreatedDate(drn), Common.getCurrentDate("M/d/yyyy"), "NOC Created Date");
        assertAll();
    }

    /**
     * @author erlan.beisen
     * August, 21 2019
     * A sub page of NOC List page
     * Steps for Notice of Overcharge Form page
     */
    @Step("Fill Notice of Overcharge Form")
    public void fillNoticeOfOverchargeForm() {
        JsonObject nocFormObject = TestDataFactory.scenarioTestDataObject.getAsJsonObject("Notice of Overcharge Form");
        for (Map.Entry<String, JsonElement> entrySet : nocFormObject.entrySet()) {
            String key = entrySet.getKey();
            JsonElement valueObject = entrySet.getValue();

            switch ( key ) {
                case "Receivable Data Entry":
                    noticeOfOverchargeFormPage.enterReceivableDataEntry(valueObject.getAsJsonObject());
                    break;
                case "Auditor Data":
                    noticeOfOverchargeFormPage.enterAuditorData(valueObject.getAsJsonObject());
                    break;
                case "Overcharge Data":
                    noticeOfOverchargeFormPage.enterOverchargeData(valueObject.getAsJsonObject());
                    break;
                case "Routing":
                    noticeOfOverchargeFormPage.enterRouting(valueObject.getAsJsonObject());
                    break;
                case "Basis":
                    noticeOfOverchargeFormPage.enterBasis(valueObject.getAsJsonObject());
                    break;
                default:
                    String errorMessage = "Test Data: \"" + key + "\" not found";
                    logger.error(errorMessage);
                    failTest(errorMessage);
            }
        }
    }

    @ContinueOnFailure
    @Step("Validate Notice of Overcharge Form Data")
    public void validateNoticeOfOverchargeFormData() {
        noticeOfOverchargeFormPage.scrollTo(NoticeOfOverchargeFormPage.NocSectionField.RECEIVABLE_DATA_ENTRY);
        softAssertEquals(noticeOfOverchargeFormPage.getDrn(), NocVO.getDrn(), "Document Reference Number (DRN)");
        softAssertEquals(noticeOfOverchargeFormPage.getCarrierBillNumber(), NocVO.getCarrierBillNumber(), "Carrier Bill Number");
        softAssertEquals(noticeOfOverchargeFormPage.getScas(), NocVO.getScac(), "SCAC");
        softAssertEquals(noticeOfOverchargeFormPage.getAgencyCode(), NocVO.getAgencyCode(), "Agency Code");
        softAssertEquals(noticeOfOverchargeFormPage.getSpecialIssueCode(), NocVO.getSpecialIssueCode(), "Special Issue Code");
        softAssertEquals(noticeOfOverchargeFormPage.getIataCode(), NocVO.getIataCode(), "IATA Code");

        noticeOfOverchargeFormPage.scrollTo(NoticeOfOverchargeFormPage.NocSectionField.AUDITOR_DATA);
        softAssertEquals(noticeOfOverchargeFormPage.getAuditorNumber(), NocVO.getAuditorNumber(), "Auditor Number");
        softAssertEquals(noticeOfOverchargeFormPage.getTimeSpentByAuditor(), NocVO.getTimeSpentByAuditor(), "Time Spent By Auditor (Minutes)");
        softAssertEquals(noticeOfOverchargeFormPage.getAuditCompany(), NocVO.getAuditCompany(), "Audit Company");
        softAssertEquals(noticeOfOverchargeFormPage.getPrepaymentAuditor(), NocVO.getPrepaymentAuditor(), "Prepayment Auditor");
        softAssertEquals(noticeOfOverchargeFormPage.getDateEBillCreated(), NocVO.getDateEBillCreated(), "Date E-Bill Created");

        noticeOfOverchargeFormPage.scrollTo(NoticeOfOverchargeFormPage.NocSectionField.OVERCHARGE_DATA);
        softAssertEquals(noticeOfOverchargeFormPage.getShouldBeAmount(), String.valueOf(NocVO.getShouldBeAmount()), "Should Be Amount");
        softAssertEquals(noticeOfOverchargeFormPage.getAmountPaid(), String.valueOf(NocVO.getAmountPaid()), "Amount Paid");
        softAssertEquals(noticeOfOverchargeFormPage.getOverchargeAmount(), Common.formatDouble2D(NocVO.getOverchargeAmount()), "Overcharge Amount");
        softAssertEquals(noticeOfOverchargeFormPage.getOverchargeType(), NocVO.getOverchargeType(), "Overcharge Type");
        softAssertEquals(noticeOfOverchargeFormPage.getForeignCurrency(), NocVO.getForeignCurrency(), "Foreign Currency");
        softAssertEquals(noticeOfOverchargeFormPage.getDateBillPaid(), NocVO.getDateBillPaid(), "Date Bill Paid");
        softAssertEquals(noticeOfOverchargeFormPage.getDateInvoiceReceived(), NocVO.getDateInvoiceReceived(), "Date Invoice Received");

        noticeOfOverchargeFormPage.scrollTo(NoticeOfOverchargeFormPage.NocSectionField.ROUTING);
        softAssertEquals(noticeOfOverchargeFormPage.getOriginCity(), NocVO.getOriginCity(), "Origin City");
        softAssertEquals(noticeOfOverchargeFormPage.getOriginState(), NocVO.getOriginState(), "Origin State");
        softAssertEquals(noticeOfOverchargeFormPage.getOriginCountry(), NocVO.getOriginCountry(), "Origin Country");
        softAssertEquals(noticeOfOverchargeFormPage.getDestinationCity(), NocVO.getDestinationCity(), "Destination City");
        softAssertEquals(noticeOfOverchargeFormPage.getDestinationState(), NocVO.getDestinationState(), "Destination State");
        softAssertEquals(noticeOfOverchargeFormPage.getDestinationCountry(), NocVO.getDestinationCountry(), "Destination Country");
        softAssertEquals(noticeOfOverchargeFormPage.getShippingDate(), NocVO.getShippingDate(), "Shipping Date");
        softAssertEquals(noticeOfOverchargeFormPage.getMode(), NocVO.getMode(), "Mode");
        softAssertEquals(noticeOfOverchargeFormPage.getGtrGblIndicator(), NocVO.getGtrGblIndicator(), "GTR/GBL Indicator");
        softAssertEquals(noticeOfOverchargeFormPage.getShipSpecificReference(), NocVO.getShipSpecificReference(), "Ship Specific Reference");
        softAssertEquals(noticeOfOverchargeFormPage.getAdditionalRoutingInformation(), NocVO.getAdditionalRoutingInformation(), "Additional Routing Information");

        noticeOfOverchargeFormPage.scrollTo(NoticeOfOverchargeFormPage.NocSectionField.BASIS);
        softAssertEquals(noticeOfOverchargeFormPage.getBasisAndAuthority(), NocVO.getBasisAndAuthority(), "Basis And Authority");
        assertAll();
    }

    @Step("Click Submit button on Notice of Overcharge Form page")
    public void clickSubmitButtonOnNoticeOfOverchargeFormPage() {
        noticeOfOverchargeFormPage.clickSubmitButton();
        NocVO.setNocStatus("Submit");
    }

    @Step("Click Save Draft button on Notice of Overcharge Form page")
    public void clickSaveDraftButtonOnNoticeOfOverchargeFormPage() {
        noticeOfOverchargeFormPage.clickSaveDraftButton();
        NocVO.setNocStatus("Draft");
    }

    @Step("Update Notice of Overcharge Form")
    public void updateNoticeOfOverchargeForm() {
        JsonObject nocFormObject = TestDataFactory.scenarioTestDataObject.getAsJsonObject("Notice of Overcharge Form update");
        for (Map.Entry<String, JsonElement> entrySet : nocFormObject.entrySet()) {
            String key = entrySet.getKey();
            JsonElement jsonElement = entrySet.getValue();

            switch (key) {
                case "Receivable Data Entry":
                    noticeOfOverchargeFormPage.enterReceivableDataEntry(jsonElement.getAsJsonObject());
                    break;
                case "Auditor Data":
                    noticeOfOverchargeFormPage.enterAuditorData(jsonElement.getAsJsonObject());
                    break;
                case "Overcharge Data":
                    noticeOfOverchargeFormPage.enterOverchargeData(jsonElement.getAsJsonObject());
                    break;
                case "Routing":
                    noticeOfOverchargeFormPage.enterRouting(jsonElement.getAsJsonObject());
                    break;
                case "Basis":
                    noticeOfOverchargeFormPage.enterBasis(jsonElement.getAsJsonObject());
                    break;
                case "NOC files":
                    noticeOfOverchargeFormPage.uploadFiles(jsonElement.getAsJsonArray());
                    break;
                default:
                    String errorMessage = "Test Data: \"" + key + "\" not found";
                    logger.error(errorMessage);
                    failTest(errorMessage);
            }
        }
    }
}