package gov.tams.contract_management;

import com.google.gson.JsonObject;
import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import gov.tams.common.CommonSteps;
import gov.tams.common.ContractVO;
import org.apache.log4j.Logger;

import gov.tams.contract_management.ContractManagementPage.*;
import org.testng.Assert;
import utilities.Common;
import utilities.TestDataFactory;

import java.util.List;

/**
 * @author erlan.beisen
 * August, 19 2019
 * Steps for Contract Management page
 */
public final class ContractManagementSteps extends CommonSteps {

    private Logger logger;
    private ContractManagementPage contractManagementPage;
    private ContractManagementPage.ContractDetailsPage contractDetailsPage;

    public ContractManagementSteps() { init(); }

    private void init () {
        logger = logger == null ? Logger.getLogger(ContractManagementSteps.class) : logger;
        contractManagementPage = contractManagementPage == null ? new ContractManagementPage(getDriver()) : contractManagementPage;
        contractDetailsPage = contractDetailsPage == null ? contractManagementPage.new ContractDetailsPage() : contractDetailsPage;
    }

    @Step("Select <dropdownValue> on <dropdown> dropdown filter")
    public void selectDropdownFilter ( String dropdownValue, String dropdown ) {
        ContractListDropdownField contractListDropdownField;
        switch ( dropdown ) {
            case "Fiscal Year":
                contractListDropdownField = ContractListDropdownField.FISCAL_YEAR;
                break;
            case "Contract Company Name":
                contractListDropdownField = ContractListDropdownField.CONTRACT_COMPANY_NAME;
                break;
            default:
                failTest("Dropdown \"" + dropdown + "\" not found on Contract management page.\n" +
                        "Possible values for dropdown are: Fiscal Year, Contract Company Name and Contract Number");
                return;
        }
        String selectedValue = contractManagementPage.selectFilter(contractListDropdownField, dropdownValue);
        softAssertEquals(selectedValue, dropdownValue, dropdown + ": " + dropdownValue + " was not selected");
    }

    @ContinueOnFailure
    @Step("Validate current Fiscal Year is selected")
    public void validateCurrentFiscalYearIsSelected () {
        String currentYear = Common.getCurrentDate("yyyy");
        List<String> selectedFilters = contractManagementPage.selectedFilters(ContractListDropdownField.FISCAL_YEAR);
        Assert.assertEquals(selectedFilters.get(0), currentYear, "Fiscal Year");
    }

    @ContinueOnFailure
    @Step("Select Fiscal Year dropdown filter")
    public void selectFiscalYearDropdownFilter () {
        int currentYear = Integer.parseInt(Common.getCurrentDate("yyyy"));
        Assert.assertTrue(ContractVO.getFiscalYear() >= 2000 && ContractVO.getFiscalYear() <= currentYear, "The Fiscal year '" + ContractVO.getFiscalYear() + "' can not be less than 2000 or more than " + currentYear);
        List<String> selectedFilters = contractManagementPage.selectedFilters(ContractListDropdownField.FISCAL_YEAR);
        boolean isSelected = false;
        for ( String selectedFilter : selectedFilters ) {
            if ( Integer.parseInt(selectedFilter) == ContractVO.getFiscalYear() ) {
                isSelected = true;
                break;
            }
        }
        if ( !isSelected ) {
            selectDropdownFilter(String.valueOf(ContractVO.getFiscalYear()), "Fiscal Year");
        }
    }

    @Step("Select Contract Company Name dropdown filter")
    public void selectContractCompanyNameDropdownFilter () {
        selectDropdownFilter(ContractVO.getCompanyName(), "Contract Company Name");
    }

    @Step("Click Reset Filters button")
    public void clickResetFiltersButton () {
        contractManagementPage.clickResetFiltersButton();
    }

    @Step("Validate contract data on Contract Management table")
    public void validateContractDataOnContractManagementTable () {
        softAssertEquals(contractManagementPage.getContractCompanyName(ContractVO.getContractNumber()), ContractVO.getCompanyName(), "Contract Company Name");
        softAssertEquals(contractManagementPage.getFiscalYear(ContractVO.getContractNumber()), String.valueOf(ContractVO.getFiscalYear()), "Fiscal Year");
        assertAll();
    }

    @Step("Click Contract Number link")
    public void clickContractNumberLink () {
        contractManagementPage.clickContractNumberLink(ContractVO.getContractNumber());
        String expectedContractDetailsPageTitle = ContractVO.getContractNumber() + " |" + ContractVO.getCompanyName() + " |";
        softAssertTrue(contractDetailsPage.isFiscalYearActive(ContractVO.getFiscalYear()), "Fiscal Year " + ContractVO.getFiscalYear() + " was not active");
        softAssertEquals(contractDetailsPage.getTitle(), expectedContractDetailsPageTitle, "Contract Details Title");
        assertAll();
    }

    /**
     * @author erlan.beisen
     * August, 21 2019
     * A sub page of Contract Management page
     * Steps for Contract Details page
     */
    @ContinueOnFailure
    @Step("Validate contract details")
    public void validateContractDetails() {
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.CONTRACTOR_CODE), ContractVO.getContractorCode(), "Contractor Code");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.COMPANY_NAME), ContractVO.getCompanyName(), "Company Name");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.ADDRESS), ContractVO.getAddress1(), "Address");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.CITY), ContractVO.getCity(), "City");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.STATE), ContractVO.getState(), "State");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.ZIP), ContractVO.getZip(), "Zip");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.TIN), ContractVO.getTin(), "TIN");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.REPRESENTATIVE), ContractVO.getRepresentative(), "Representative");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.EMAIL), ContractVO.getEmail(), "Email");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.PHONE), ContractVO.getPhone(), "Phone");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.FAX_NUMBER), ContractVO.getFaxNumber(), "Fax Number");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.CONTRACT_START_DATE), ContractVO.getContractStartDate(), "Contract Start Date");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.CONTRACT_END_DATE), ContractVO.getContractEndDate(), "Contract End Date");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.ACCOUNT_NUMBER), ContractVO.getAccountNumber(), "Account Number");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.AMOUNT_ALLOCATED), ContractVO.getAmountAllocated(), "Amount Allocated");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.AMOUNT_SPENT), ContractVO.getAmountSpent(), "Amount Spent");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.NUMBER_OF_OVERCHARGE_ISSUES), ContractVO.getNumberOfOverchargeIssues(), "Number of Overcharge Issues");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_OVERCHARGES_ISSUED), ContractVO.getAmountOfOverchargesIssued(), "Amount of Overcharges Issued");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_OVERCHARGES_COLLECTED), ContractVO.getAmountOfOverchargesCollected(), "Amount of Overcharges Collected");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_COMMISSION_DUE), ContractVO.getAmountOfCommissionDue(), "Amount of Commission Due");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_COMMISSION_PAID), ContractVO.getAmountOfCommissionPaid(), "Amount of Commission Paid");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_PROTEST_ALLOWED), ContractVO.getAmountOfProtestAllowed(), "Amount of Protest Allowed");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_WRITE_OFFS_ALLOWED), ContractVO.getAmountOfWriteOffsAllowed(), "Amount of Write-offs Allowed");
        softAssertEquals(contractDetailsPage.getContractPerformanceDataTableFieldValue(ContractPerformanceDataTableField.AMOUNT_OF_RECLAIMS_ALLOWED), ContractVO.getAmountOfReclaimsAllowed(), "Amount of Reclaims Allowed");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.DESCRIPTION), ContractVO.getModeDescription(), "Description");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.STATUS), ContractVO.getStatus(), "Status");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.COMMISSION), ContractVO.getCommission(), "Commission");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValue(ContractDetailsField.AUDIT_TYPE), ContractVO.getAuditType(), "Audit Type");
        assertAll();
    }

    @Step("Click <fiscalYear> fiscal year link")
    public void clickFiscalYearLink(String fiscalYear) {
        contractDetailsPage.clickContractFiscalYearLink(Integer.parseInt(fiscalYear));
    }

    @Step("Update Contract Auditor Profile data")
    public void updateContractAuditorProfileData () {
        JsonObject jsonObject = TestDataFactory.scenarioTestDataObject.getAsJsonObject("Contract Auditor Profile");
        contractDetailsPage.clickContractAuditorProfileUpdateButton();
        contractDetailsPage.updateContractAuditorProfile(jsonObject);
        contractDetailsPage.clickContractAuditorProfileSaveButton();
    }

    @Step("Validate Contract Auditor Profile data on edit mode")
    public void validateContractAuditorProfileDataOnEditMode () {
        contractDetailsPage.clickContractAuditorProfileUpdateButton();
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.CONTRACTOR_CODE), ContractVO.getContractorCode(), "Contractor Code");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.COMPANY_NAME), ContractVO.getCompanyName(), "Company Name");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.ADDRESS_1), ContractVO.getAddress1(), "Address 1");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.ADDRESS_2), ContractVO.getAddress2(), "Address 2");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.CITY), ContractVO.getCity(), "City");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.STATE), ContractVO.getState(), "State");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.ZIP), ContractVO.getZip(), "ZIP");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.TIN), ContractVO.getTin(), "TIN");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.REPRESENTATIVE), ContractVO.getRepresentative(), "Representative");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.EMAIL), ContractVO.getEmail(), "Email");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.PHONE), ContractVO.getPhone(), "Phone");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.FAX_NUMBER), ContractVO.getFaxNumber(), "Fax Number");

        contractDetailsPage.clickContractAuditorProfileCancelButton();
        assertAll();
    }

    @Step("Update Commission By Mode data")
    public void updateCommissionByModeData () {
        JsonObject jsonObject = TestDataFactory.scenarioTestDataObject.getAsJsonObject("Commission By Mode");
        contractDetailsPage.clickCommissionByModeUpdateButton();
        contractDetailsPage.updateCommissionByMode(jsonObject);
        contractDetailsPage.clickCommissionByModeSaveButton();
    }

    @Step("Validate Commission By Mode data on edit mode")
    public void validateCommissionByModeDataOnEditMode () {
        contractDetailsPage.clickCommissionByModeUpdateButton();
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.COMMISSION), ContractVO.getCommission(), "Commission");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.AUDIT_TYPE), ContractVO.getAuditType(), "Audit Type");
        softAssertEquals(contractDetailsPage.getContractDetailsFieldValueEditMode(ContractDetailsField.STATUS), ContractVO.getStatus(), "Status");
        contractDetailsPage.clickCommissionByModeCancelButton();
        assertAll();
    }

    @Step("Click Return to Search Results")
    public void clickReturnToSearchResults () {
        contractDetailsPage.clickReturnToSearchResultsLink();
    }
}