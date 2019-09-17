package gov.tams.contract_management;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gov.tams.common.CommonPage;
import gov.tams.common.ContractVO;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Common;
import utilities.DataStore;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import static gov.tams.contract_management.ContractManagementVO.*;
import static gov.tams.contract_management.ContractManagementVO.ContractDetailsVO.*;

/**
 * @author erlan.beisen
 * August, 19 2019
 * Contract Management page User actions
 */
final class ContractManagementPage extends CommonPage {

    private Logger logger;

    ContractManagementPage(WebDriver webDriver ) {
        super( webDriver );
        init();
    }

    private void init () { logger = logger == null ? Logger.getLogger(ContractManagementPage.class) : logger; }

    enum ContractListDropdownField {
        FISCAL_YEAR("Fiscal Year"), CONTRACT_COMPANY_NAME("Contract Company Name");

        private String description;
        ContractListDropdownField ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    enum ContractDetailsField {
        CONTRACTOR_CODE("Contractor Code"), COMPANY_NAME("Company Name"),
        ADDRESS("Address"), ADDRESS_1("Address"),  ADDRESS_2("Address"),
        CITY("City"), STATE("State"), ZIP("ZIP"), TIN("TIN"), REPRESENTATIVE("Representative"),
        EMAIL("Email"), PHONE("Phone"), FAX_NUMBER("Fax Number"),
        CONTRACT_START_DATE("Contract Start Date"), CONTRACT_END_DATE("Contract End Date"), ACCOUNT_NUMBER("Account Number"),
        AMOUNT_ALLOCATED("Amount Allocated"), AMOUNT_SPENT("Amount Spent"),
        DESCRIPTION("Description"), STATUS("Status"), COMMISSION("Commission %"), AUDIT_TYPE("Audit Type");

        private String description;
        ContractDetailsField ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    enum ContractPerformanceDataTableField {
        NUMBER_OF_OVERCHARGE_ISSUES("Number of Overcharge Issues"), AMOUNT_OF_OVERCHARGES_ISSUED("Amount of Overcharges Issued"),
        AMOUNT_OF_OVERCHARGES_COLLECTED("Amount of Overcharges Collected"), AMOUNT_OF_COMMISSION_DUE("Amount of Commission Due"),
        AMOUNT_OF_COMMISSION_PAID("Amount of Commission Paid"), AMOUNT_OF_PROTEST_ALLOWED("Amount of Protest Allowed"),
        AMOUNT_OF_WRITE_OFFS_ALLOWED("Amount of Write-offs Allowed"), AMOUNT_OF_RECLAIMS_ALLOWED("Amount of Reclaims Allowed");

        private String description;
        ContractPerformanceDataTableField ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    List<String> selectedFilters ( ContractListDropdownField contractListDropdownField ) {
        return selectedDropdownValues(contractListDropdownField.getFieldName());
    }

    String selectFilter ( ContractListDropdownField contractListDropdownField, String filterValue ) {
        return selectDropdown(contractListDropdownField.getFieldName(), filterValue);
    }

    void clickResetFiltersButton () {
        click(RESET_FILTERS_BUTTON);
    }

    void showResults ( int results ) {
        String resultsText = String.valueOf(results);
        String selectedValue = selectDropdown(SHOW_RECORDS_DROPDOWN, resultsText);
        softAssert().assertEquals(selectedValue, resultsText, results + " Results was not selected");
    }

    void clickContractNumberLink ( String contractNumber ) {
        String xpath = MessageFormat.format(CONTRACT_NUMBER_LINK_XPATH, contractNumber);
        click(By.xpath(xpath));
    }

    /**
     * Returns Contract Company Name by Contract Number
     * @return - Contract Company Name
     */
    String getContractCompanyName ( String contractNumber ) {
        String xpath = MessageFormat.format(CONTRACT_COMPANY_NAME_FIELD_XPATH, contractNumber);
        return getText(By.xpath(xpath));
    }

    /**
     * Returns Fiscal Year by Contract Number
     * @return - Fiscal Year
     */
    String getFiscalYear ( String contractNumber ) {
        String xpath = MessageFormat.format(FISCAL_YEAR_FIELD_XPATH, contractNumber);
        return getText(By.xpath(xpath));
    }

    /**
     * @author erlan.beisen
     * August, 19 2019
     * A Sub Page of Contract Management page
     *  Actions of Contract Details Page
     */
    final class ContractDetailsPage {
        private Logger logger;

        ContractDetailsPage () { init(); }

        private void init () { logger = logger == null ? Logger.getLogger(ContractDetailsPage.class) : logger; }

        void clickReturnToSearchResultsLink () {
            click(RETURN_TO_SEARCH_RESULTS_LINK);
        }

        boolean isFiscalYearActive ( int fiscalYear ) {
            String xpath = MessageFormat.format(CONTRACT_FISCAL_YEAR_LINK_XPATH, fiscalYear);
            String classAttribute = getAttribute(By.xpath(xpath + "/.."), "class");
            return classAttribute.contains("active");
        }

        void clickContractFiscalYearLink ( int fiscalYear ) {
            String xpath = MessageFormat.format(CONTRACT_FISCAL_YEAR_LINK_XPATH, fiscalYear);
            click(By.xpath(xpath));
        }

        String getTitle () {
            return getText(CONTRACT_DETAILS_TITLE);
        }

        /**
         * Captures field value on contract details page from Contract Auditor Profile, Appropriations and Allocations and Commission By Mode sections
         * @author erlan.beisen
         * @param contractDetailsField - Contract Details Field
         * @return - field value
         */
        String getContractDetailsFieldValue ( ContractDetailsField contractDetailsField ) {
            String xpath = MessageFormat.format(FIELD_VALUE_XPATH, contractDetailsField.getFieldName());
            By fieldValueLocator = By.xpath(xpath);
            scrollToElement(fieldValueLocator);
            return getText(fieldValueLocator);
        }

        String getContractDetailsFieldValueEditMode ( ContractDetailsField contractDetailsField ) {
            String fieldValue = null;
            switch ( contractDetailsField ) {
                case CONTRACTOR_CODE: fieldValue = getAttribute(CONTRACTOR_CODE_TEXT_BOX, "value");
                    break;
                case COMPANY_NAME: fieldValue = getAttribute(COMPANY_NAME_TEXT_BOX, "value");
                    break;
                case ADDRESS_1: fieldValue = getAttribute(ADDRESS_1_TEXT_BOX, "value");
                    break;
                case ADDRESS_2: fieldValue = getAttribute(ADDRESS_2_TEXT_BOX, "value");
                    break;
                case CITY: fieldValue = getAttribute(CITY_TEXT_BOX, "value");
                    break;
                case STATE: fieldValue = selectedDropdownValue(STATE_DROPDOWN);
                    break;
                case ZIP: fieldValue = getAttribute(ZIP_TEXT_BOX, "value");
                    break;
                case TIN: fieldValue = getAttribute(TIN_TEXT_BOX, "value");
                    break;
                case REPRESENTATIVE: fieldValue = getAttribute(REPRESENTATIVE_TEXT_BOX, "value");
                    break;
                case EMAIL: fieldValue = getAttribute(EMAIL_TEXT_BOX, "value");
                    break;
                case PHONE: fieldValue = getAttribute(PHONE_TEXT_BOX, "value");
                    break;
                case FAX_NUMBER: fieldValue = getAttribute(FAX_NUMBER_TEXT_BOX, "value");
                    break;
                case COMMISSION: fieldValue = getAttribute(COMMISSION_TEXT_BOX, "value");
                    break;
                case AUDIT_TYPE: fieldValue = selectedDropdownValue(AUDIT_TYPE_DROPDOWN);
                    break;
                case STATUS: fieldValue = selectedDropdownValue(STATUS_DROPDOWN);
                    break;
                default:
                    String errorMessage = "Test Data: \"" + contractDetailsField.getFieldName() + "\" not found";
                    logger.error(errorMessage);
                    Common.failTest(errorMessage);
            }
            return fieldValue;
        }

        /**
         * Captures field value on contract details page from Contract Performance Data table
         * @author erlan.beisen
         * @param contractPerformanceDataTableField - Contract Performance Data Table Field
         * @return - field value
         */
        String getContractPerformanceDataTableFieldValue ( ContractPerformanceDataTableField contractPerformanceDataTableField ) {
            String xpath = MessageFormat.format(CONTRACT_PERFORMANCE_DATA_TABLE_FIELD_VALUE_XPATH, contractPerformanceDataTableField.getFieldName());
            By fieldValueLocator = By.xpath(xpath);
            scrollToElement(fieldValueLocator);
            return getText(fieldValueLocator);
        }

        void clickContractAuditorProfileUpdateButton () { click(CONTRACT_AUDITOR_PROFILE_UPDATE_BUTTON); }

        void clickContractAuditorProfileSaveButton () { click(CONTRACT_AUDITOR_PROFILE_SAVE_BUTTON); }

        void clickContractAuditorProfileCancelButton () { click(CONTRACT_AUDITOR_PROFILE_CANCEL_BUTTON); }

        void clickAppropriationsAndAllocationsUpdateButton () { click(APPROPRIATIONS_AND_ALLOCATIONS_UPDATE_BUTTON); }

        void clickAppropriationsAndAllocationsSaveButton () { click(APPROPRIATIONS_AND_ALLOCATIONS_SAVE_BUTTON); }

        void clickAppropriationsAndAllocationsCancelButton () { click(APPROPRIATIONS_AND_ALLOCATIONS_CANCEL_BUTTON); }

        void clickCommissionByModeUpdateButton () { click(COMMISSION_BY_MODE_UPDATE_BUTTON); }

        void clickCommissionByModeSaveButton () { click(COMMISSION_BY_MODE_SAVE_BUTTON); }

        void clickCommissionByModeCancelButton () { click(COMMISSION_BY_MODE_CANCEL_BUTTON); }

        void updateContractAuditorProfile ( @NotNull JsonObject jsonObject ) {
            for ( Map.Entry<String, JsonElement> entrySet : jsonObject.entrySet() ) {
                String key = entrySet.getKey();
                String value = entrySet.getValue().getAsString();
                String actualValue = "";
                boolean isRandomValue = value.trim().equalsIgnoreCase("random");

                switch ( key ) {
                    case "Contractor Code" :
                        value = isRandomValue ? "AUTO_" + Common.getRandomText(11, true, true,false).toUpperCase() : value.toUpperCase();
                        actualValue = sendKeys(CONTRACTOR_CODE_TEXT_BOX, value);
                        ContractVO.setContractorCode(value);
                        break;
                    case "Company Name" :
                        value = isRandomValue ? Common.getRandomCompany() : value;
                        actualValue = sendKeys(COMPANY_NAME_TEXT_BOX, value);
                        ContractVO.setCompanyName(value);
                        break;
                    case "Address 1" :
                        value = isRandomValue ? Common.getRandomAddress() : value;
                        actualValue = sendKeys(ADDRESS_1_TEXT_BOX, value);
                        ContractVO.setAddress1(value);
                        break;
                    case "Address 2" :
                        value = isRandomValue ? "Suite " + Common.getRandomInt(100, 999) : value;
                        actualValue = sendKeys(ADDRESS_2_TEXT_BOX, value);
                        ContractVO.setAddress2(value);
                        break;
                    case "City":
                        value = isRandomValue ? Common.getRandomCity() : value;
                        actualValue = sendKeys(CITY_TEXT_BOX, value);
                        ContractVO.setCity(value);
                        break;
                    case "State" :
                        if ( isRandomValue ) {
                            value = randomSelectDropdown(STATE_DROPDOWN);
                            actualValue = value;
                        } else {
                            actualValue = selectDropdown(STATE_DROPDOWN, value);
                        }
                        ContractVO.setState(value);
                        break;
                    case "ZIP" :
                        value = isRandomValue ? String.valueOf(Common.getRandomInt(10000, 99999)) : value;
                        actualValue = sendKeys(ZIP_TEXT_BOX, value);
                        ContractVO.setZip(value);
                        break;
                    case "TIN" :
                        value = isRandomValue ? String.valueOf(Common.getRandomLong(100000000, 999999999)) : value;
                        actualValue = sendKeys(TIN_TEXT_BOX, value);
                        ContractVO.setTin(value);
                        break;
                    case "Representative" :
                        value = isRandomValue ? Common.getRandomFirstName() + " " + Common.getRandomFirstName(): value;
                        actualValue = sendKeys(REPRESENTATIVE_TEXT_BOX, value);
                        ContractVO.setRepresentative(value);
                        break;
                    case "Email" :
                        value = isRandomValue ? (ContractVO.getRepresentative().replaceAll("\\s+", "") + "@" + ContractVO.getCompanyName() + ".com").toLowerCase() : value;
                        actualValue = sendKeys(EMAIL_TEXT_BOX, value);
                        ContractVO.setEmail(value);
                        break;
                    case "Phone" :
                        value = isRandomValue ? Common.getRandomPhoneNumber() : value;
                        actualValue = sendKeys(PHONE_TEXT_BOX, value);
                        ContractVO.setPhone(value);
                        break;
                    case "Fax Number" :
                        value = isRandomValue ? Common.getRandomPhoneNumber() : value;
                        actualValue = sendKeys(FAX_NUMBER_TEXT_BOX, value);
                        ContractVO.setFaxNumber(value);
                        break;
                    default:
                        String errorMessage = "Test Data: \"" + key + "\" not found";
                        logger.error(errorMessage);
                        Common.failTest(errorMessage);
                }
                logger.info(key + " - " + value);
                DataStore.storeObject(key, value);
                softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
            }
        }

        void updateCommissionByMode ( @NotNull JsonObject jsonObject ) {
            for ( Map.Entry<String, JsonElement> entrySet : jsonObject.entrySet() ) {
                String key = entrySet.getKey();
                String value = entrySet.getValue().getAsString();
                String actualValue = "";
                boolean isRandomValue = value.trim().equalsIgnoreCase("random");

                switch ( key ) {
                    case "Commission" :
                        value = isRandomValue ? String.valueOf(Common.getRandomInt(1, 100)) : value;
                        actualValue = sendKeys(COMMISSION_TEXT_BOX, value);
                        ContractVO.setCommission(value);
                        break;
                    case "Audit Type" :
                        if ( isRandomValue ) {
                            value = randomSelectDropdown(AUDIT_TYPE_DROPDOWN);
                            actualValue = value;
                        } else {
                            actualValue = selectDropdown(AUDIT_TYPE_DROPDOWN, value);
                        }
                        ContractVO.setAuditType(value);
                        break;
                    case "Status" :
                        if ( isRandomValue ) {
                            value = randomSelectDropdown(STATUS_DROPDOWN);
                            actualValue = value;
                        } else {
                            actualValue = selectDropdown(STATUS_DROPDOWN, value);
                        }
                        ContractVO.setStatus(value);
                        break;
                    default:
                        String errorMessage = "Test Data: \"" + key + "\" not found";
                        logger.error(errorMessage);
                        Common.failTest(errorMessage);
                }
                logger.info(key + " - " + value);
                DataStore.storeObject(key, value);
                softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
            }
        }

        /**
         * wip
         * @return - null
         */
        String getMode () {
            return null;
        }
    }
}