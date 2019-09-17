package gov.tams.noc_list;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gov.tams.common.CommonPage;
import gov.tams.common.NocVO;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Common;
import utilities.DataStore;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static gov.tams.noc_list.NocListVO.*;
import static gov.tams.noc_list.CreateNocVO.*;

/**
 * @author erlan.beisen
 * August, 13 2019
 * Actions of NOC List page
 */
final class NocListPage extends CommonPage {

    private Logger logger;

    NocListPage(WebDriver webDriver) {
        super(webDriver);
        init();
    }

    private void init () { logger = logger == null ? Logger.getLogger(NocListPage.class) : logger; }

    String getTitle () {
        return getText(NOC_LIST_TITLE);
    }

    void clickCreateNocButton () {
        click(createNocButton);
        logger.info("Clicked on Create NOC button");
    }

    String getIssueDate ( String drn ) {
        String xpath = MessageFormat.format(issueDateFieldXpath, drn);
        scrollToElement(By.xpath(xpath));
        return getText(By.xpath(xpath));
    }

    String getPaidDate ( String drn ) {
        String xpath = MessageFormat.format(paidDateFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getOvercharge ( String drn ) {
        String xpath = MessageFormat.format(overchargeFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getStatus ( String drn ) {
        String xpath = MessageFormat.format(statusFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getOwner ( String drn ) {
        String xpath = MessageFormat.format(ownerFieldXpath, drn);
        return getText(By.xpath(xpath));
    }

    String getCreatedDate ( String drn ) {
        String xpath = MessageFormat.format(createdDateFieldXpath, drn);
        return getText(By.xpath(xpath));
    }
}

/**
 * @author erlan.beisen
 * August, 21 2019
 * A sub page of NOC List
 * Notice of Overcharge Form page User actions
 */
final class NoticeOfOverchargeFormPage extends CommonPage {

    private Logger logger;

    NoticeOfOverchargeFormPage(WebDriver webDriver) {
        super(webDriver);
        init();
    }

    private void init () { logger = logger == null ? Logger.getLogger(NoticeOfOverchargeFormPage.class) : logger; }

    enum NocSectionField {
        RECEIVABLE_DATA_ENTRY("Receivable Data Entry"), AUDITOR_DATA("Auditor Data"),
        OVERCHARGE_DATA("Overcharge Data"), ROUTING("Routing"), BASIS("Basis");

        private String description;
        NocSectionField ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    private enum NocFormDropdownField {
        SCAC("SCAC"), AGENCY_CODE("Agency Code"), SPECIAL_ISSUE_CODE("Special Issue Code"),
        AUDIT_COMPANY("Audit Company"),
        OVERCHARGE_TYPE("Overcharge Type"), FOREIGN_CURRENCY("Foreign Currency"),
        MODE("Mode"), GTR_GBL_INDICATOR("GTR/GBL Indicator");

        private String description;
        NocFormDropdownField ( String description ) { this.description = description; }
        public String getFieldName () { return this.description; }
    }

    void scrollTo ( NocSectionField nocSectionField ) {
        String xpath = MessageFormat.format(dataEntrySections, nocSectionField.getFieldName());
        scrollToElement(By.xpath(xpath));
    }

    void enterReceivableDataEntry ( @NotNull JsonObject jsonObject ) {
        for ( Map.Entry<String, JsonElement> entrySet : jsonObject.entrySet() ) {
            String key = entrySet.getKey();
            String value = entrySet.getValue().getAsString();
            String actualValue = "";
            boolean isRandomValue = value.trim().equalsIgnoreCase("random");

            switch ( key ) {
                case "Document Reference Number" :
                    value = isRandomValue ? "AUTO_" + Common.getRandomText(11, true, true,false).toUpperCase() : value.toUpperCase();
                    actualValue = sendKeys(drnTextBox, value);
                    NocVO.setDrn(value);
                    break;
                case "Carrier Bill Number" :
                    value = isRandomValue ? Common.getRandomText(10, true, true, false).toUpperCase() : value.toUpperCase();
                    actualValue = sendKeys(carrierBillNumberTextBox, value);
                    NocVO.setCarrierBillNumber(value);
                    break;
                case "SCAC" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.SCAC.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.SCAC.getFieldName(), value);
                    }
                    NocVO.setScac(value);
                    break;
                case "Agency Code" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.AGENCY_CODE.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.AGENCY_CODE.getFieldName(), value);
                    }
                    NocVO.setAgencyCode(value);
                    break;
                case "Special Issue Code" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.SPECIAL_ISSUE_CODE.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.SPECIAL_ISSUE_CODE.getFieldName(), value);
                    }
                    NocVO.setSpecialIssueCode(value);
                    break;
                case "IATA Code" :
                    value = isRandomValue ? Common.getRandomText(8, true, true, false).toUpperCase() : value.toUpperCase();
                    actualValue = sendKeys(iataCodeTextBox, value);
                    NocVO.setIataCode(value);
                    break;
                default:
                    String errorMessage = "Test Data: \"" + key + "\" not found";
                    logger.error(errorMessage);
                    Common.failTest(errorMessage);
            }
            logger.info(key + " - " + value);
            saveAuditLog(key, value);
            softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
        }
    }

    void enterAuditorData ( @NotNull JsonObject jsonObject ) {
        for ( Map.Entry<String, JsonElement> entrySet : jsonObject.entrySet() ) {
            String key = entrySet.getKey();
            String value = entrySet.getValue().getAsString();
            String actualValue = "";
            boolean isRandomValue = value.trim().equalsIgnoreCase("random");

            switch ( key ) {
                case "Auditor Number" :
                    value = isRandomValue ? Common.getRandomText(5, true, true,false).toUpperCase() : value.toUpperCase();
                    actualValue = sendKeys(auditorNumberTextBox, value);
                    NocVO.setAuditorNumber(value);
                    break;
                case "Time Spent By Auditor" :
                    value = isRandomValue ? String.valueOf(Common.getRandomInt(100, 999)) : value;
                    actualValue = sendKeys(timeSpentByAuditorTextBox, String.valueOf(Integer.parseInt(value)));
                    NocVO.setTimeSpentByAuditor(value);
                    break;
                case "Audit Company" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.AUDIT_COMPANY.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.AUDIT_COMPANY.getFieldName(), value);
                    }
                    NocVO.setAuditCompany(value);
                    break;
                case "Prepayment Auditor" :
                    value = isRandomValue ? Common.getRandomText(25) : value;
                    actualValue = sendKeys(prepaymentAuditorTextBox, value);
                    NocVO.setPrepaymentAuditor(value);
                    break;
                case "Date E-Bill Created" :
                    value = isRandomValue ? Common.getPastDate("MM/dd/yyyy", 3) : value;
                    actualValue = sendKeys(dateE_BillCreatedTextBox, value);
                    closeFieldCalendar(key);
                    NocVO.setDateEBillCreated(value);
                    break;
                default:
                    String errorMessage = "Test Data: \"" + key + "\" not found";
                    logger.error(errorMessage);
                    Common.failTest(errorMessage);
            }
            logger.info(key + " - " + value);
            saveAuditLog(key, value);
            softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
        }
    }

    void enterOverchargeData ( @NotNull JsonObject jsonObject ) {
        for ( Map.Entry<String, JsonElement> entrySet : jsonObject.entrySet() ) {
            String key = entrySet.getKey();
            String value = entrySet.getValue().getAsString();
            String actualValue = "";
            boolean isRandomValue = value.trim().equalsIgnoreCase("random");

            switch ( key ) {
                case "Should Be Amount" :
                    value = isRandomValue ? Common.formatDouble2D(Common.getRandomDouble(10.99, 9999.99)) : value;
                    sendKeys(shouldBeAmountTextBox, value);
                    clickFieldIcon(key);
                    actualValue = getAttribute(shouldBeAmountTextBox, "value");
                    NocVO.setShouldBeAmount(value);
                    break;
                case "Amount Paid" :
                    double shouldBeAmount = NocVO.getShouldBeAmount();
                    double amountPaid = shouldBeAmount + Common.getRandomDouble(10, 999);
                    value = Common.formatDouble2D(amountPaid);
                    sendKeys(amountPaidTextBox, value);
                    clickFieldIcon(key);
                    actualValue = getAttribute(amountPaidTextBox, "value");
                    NocVO.setAmountPaid(value);
                    break;
                case "Overcharge Amount" :
                    shouldBeAmount = NocVO.getShouldBeAmount();
                    amountPaid = NocVO.getAmountPaid();
                    double overchargeAmount = amountPaid - shouldBeAmount;
                    value = Common.formatDouble2D(overchargeAmount);
                    actualValue = getAttribute(overchargeAmountTextBox, "value");
                    NocVO.setOverchargeAmount(value);
                    break;
                case "Overcharge Type" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.OVERCHARGE_TYPE.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.OVERCHARGE_TYPE.getFieldName(), value);
                    }
                    NocVO.setOverchargeType(value);
                    break;
                case "Foreign Currency" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.FOREIGN_CURRENCY.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.FOREIGN_CURRENCY.getFieldName(), value);
                    }
                    NocVO.setForeignCurrency(value);
                    break;
                case "Date Bill Paid" :
                    value = isRandomValue ? Common.getPastDate("MM/dd/yyyy", 1) : value;
                    actualValue = sendKeys(dateBillPaidTextBox, value);
                    closeFieldCalendar(key);
                    NocVO.setDateBillPaid(value);
                    break;
                case "Date Invoice Received" :
                    value = isRandomValue ? Common.getPastDate("MM/dd/yyyy", 2) : value;
                    actualValue = sendKeys(dateInvoiceReceivedTextBox, value);
                    closeFieldCalendar(key);
                    NocVO.setDateInvoiceReceived(value);
                    break;
                default:
                    String errorMessage = "Test Data: \"" + key + "\" not found";
                    logger.error(errorMessage);
                    Common.failTest(errorMessage);
            }
            logger.info(key + " - " + value);
            saveAuditLog(key, value);
            softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
        }
    }

    void enterRouting ( @NotNull JsonObject jsonObject ) {
        for ( Map.Entry<String, JsonElement> entrySet : jsonObject.entrySet() ) {
            String key = entrySet.getKey();
            String value = entrySet.getValue().getAsString();
            String actualValue = "";
            boolean isRandomValue = value.trim().equalsIgnoreCase("random");

            switch ( key ) {
                case "Origin City" :
                    value = isRandomValue ? Common.getRandomCity() : value;
                    actualValue = sendKeys(originCityTextBox, value);
                    NocVO.setOriginCity(value);
                    break;
                case "Origin State" :
                    value = isRandomValue ? Common.getRandomState() : value;
                    value = value.length() > 10 ? value.substring(0, 9) : value;//added temporary
                    actualValue = sendKeys(originStateTextBox, value);
                    NocVO.setOriginState(value);
                    break;
                case "Origin Country" :
                    actualValue = sendKeys(originCountryTextBox, value);
                    NocVO.setOriginCountry(value);
                    break;
                case "Destination City" :
                    value = isRandomValue ? Common.getRandomCity() : value;
                    actualValue = sendKeys(destinationCityTextBox, value);
                    NocVO.setDestinationCity(value);
                    break;
                case "Destination State" :
                    value = isRandomValue ? Common.getRandomState() : value;
                    value = value.length() > 10 ? value.substring(0, 9) : value;//added temporary
                    actualValue = sendKeys(destinationStateTextBox, value);
                    NocVO.setDestinationState(value);
                    break;
                case "Destination Country" :
                    actualValue = sendKeys(destinationCountryTextBox, value);
                    NocVO.setDestinationCountry(value);
                    break;
                case "Shipping Date" :
                    value = isRandomValue ? Common.getCurrentDate("MM/dd/yyyy") : value;
                    actualValue = sendKeys(shippingDateTextBox, value);
                    closeFieldCalendar(key);
                    NocVO.setShippingDate(value);
                    break;
                case "Mode" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.MODE.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.MODE.getFieldName(), value);
                    }
                    NocVO.setMode(value);
                    break;
                case "GTR/GBL Indicator" :
                    if ( isRandomValue ) {
                        value = randomSelectDropdown(NocFormDropdownField.GTR_GBL_INDICATOR.getFieldName());
                        actualValue = value;
                    } else {
                        actualValue = selectDropdown(NocFormDropdownField.GTR_GBL_INDICATOR.getFieldName(), value);
                    }
                    NocVO.setGtrGblIndicator(value);
                    break;
                case "Ship Specific Reference" :
                    value = isRandomValue ? Common.getRandomText(15, true, true, false) : value;
                    actualValue = sendKeys(shipSpecificReferenceTextBox, value);
                    NocVO.setShipSpecificReference(value);
                    break;
                case "Additional Routing Information" :
                    value = isRandomValue ? Common.getRandomText(200) : value;
                    actualValue = sendKeys(additionalRoutingInformationTextBox, value);
                    NocVO.setAdditionalRoutingInformation(value);
                    break;
                default:
                    String errorMessage = "Test Data: \"" + key + "\" not found";
                    logger.error(errorMessage);
                    Common.failTest(errorMessage);
            }
            logger.info(key + " - " + value);
            saveAuditLog(key, value);
            softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
        }
    }

    void enterBasis ( @NotNull JsonObject jsonObject ) {
        String key = "Basis And Authority";
        String value = jsonObject.get(key).getAsString();
        boolean isRandomValue = value.trim().equalsIgnoreCase("random");
        value = isRandomValue ? Common.getRandomText(300) : value;
        String actualValue = sendKeys(basisAndAuthorityTextBox, value);
        logger.info(key + " - " + value);
        NocVO.setBasisAndAuthority(value);
        saveAuditLog(key, value);
        softAssert().assertEquals(actualValue, value, "Value for \"" + key + "\" ");
    }

    void uploadFiles ( @NotNull JsonArray jsonArray ) {
        scrollToElement(FILE_UPLOAD_FIELD);
        for ( JsonElement jsonElement : jsonArray ) {
            String relativeFilePath = jsonElement.getAsString();
            String filePath = Common.getAbsoluteFilePath(relativeFilePath);
            uploadFile(FILE_UPLOAD_TEXT_BOX, filePath);

            String file = Common.getFileName(relativeFilePath);
            String xpath = MessageFormat.format(UPLOADED_FILE_XPATH, file);
            waitElementVisibility(By.xpath(xpath));
            logger.info("File \"" + file + "\" uploaded");
        }
    }

    /**
     * Saves audit log for each updated filed on NOC form
     * @param key - key
     * @param value - value
     */
    private void saveAuditLog(String key, String value ) {
        if ( !key.equals("Overcharge Amount") ) {
            int keyIndex = DataStore.isObjectKey(key + " index") ? DataStore.getValueAsInt(key + " index") + 1 : 1;
            if (keyIndex > 1) {
                String prevKeyIndexValue = DataStore.getValueAsString(key + " " + (keyIndex - 1));
                if ( !prevKeyIndexValue.equals(value) ) {
                    int auditLog = DataStore.isObjectKey("audit log") ? DataStore.getValueAsInt("audit log") + 1 : 1;
                    DataStore.storeObject("audit log", auditLog);

                    List<String> updatedNocPropertyList = DataStore.isObjectKey("updated noc property list") ? DataStore.getValueAsList("updated noc property list") : new ArrayList<>();
                    updatedNocPropertyList.add(key);
                    DataStore.storeObject("updated noc property list", updatedNocPropertyList);
                }
            }
            DataStore.storeObject(key + " index", keyIndex);
            DataStore.storeObject(key + " " + keyIndex, value);
        }
    }

    /**
     * Clicks on filed icon based ob filed`s name. Ex: Shipping Date field --> calendar icon
     * @param field - field
     */
    private void clickFieldIcon ( String field ) {
        click(By.xpath("//label[contains(text(), '" + field + "')]/..//i"));
    }

    private void closeFieldCalendar ( String field ) {
        By fieldCalendar = By.xpath("//label[contains(text(), '" + field + "')]/..//*[@class='react-datepicker']");
        if ( isDisplayed(fieldCalendar) ) {
            clickFieldIcon(field);
        }
        softAssert().assertTrue(!isDisplayed(fieldCalendar), "Could not close field calendar");
    }

    void clickSubmitButton () {
        click(submitButton);
    }

    void clickSaveDraftButton () {
        click(saveDraftButton);
    }

    String getDrn () { return getAttribute(drnTextBox, "value"); }

    String getCarrierBillNumber () { return getAttribute(carrierBillNumberTextBox, "value"); }

    String getScas () { return selectedDropdownValue(NocFormDropdownField.SCAC.getFieldName()); }

    String getAgencyCode () { return selectedDropdownValue(NocFormDropdownField.AGENCY_CODE.getFieldName()); }

    String getSpecialIssueCode () { return selectedDropdownValue(NocFormDropdownField.SPECIAL_ISSUE_CODE.getFieldName()); }

    String getIataCode () { return getAttribute(iataCodeTextBox, "value"); }

    String getAuditorNumber () { return getAttribute(auditorNumberTextBox, "value"); }

    String getTimeSpentByAuditor () { return getAttribute(timeSpentByAuditorTextBox, "value"); }

    String getAuditCompany () { return selectedDropdownValue(NocFormDropdownField.AUDIT_COMPANY.getFieldName()); }

    String getPrepaymentAuditor () { return getAttribute(prepaymentAuditorTextBox, "value"); }

    String getDateEBillCreated () { return getAttribute(dateE_BillCreatedTextBox, "value"); }

    String getShouldBeAmount () { return getAttribute(shouldBeAmountTextBox, "value"); }

    String getAmountPaid () { return getAttribute(amountPaidTextBox, "value"); }

    String getOverchargeAmount () { return getAttribute(overchargeAmountTextBox, "value"); }

    String getOverchargeType () { return selectedDropdownValue(NocFormDropdownField.OVERCHARGE_TYPE.getFieldName()); }

    String getForeignCurrency () { return selectedDropdownValue(NocFormDropdownField.FOREIGN_CURRENCY.getFieldName()); }

    String getDateBillPaid () { return getAttribute(dateBillPaidTextBox, "value"); }

    String getDateInvoiceReceived () { return getAttribute(dateInvoiceReceivedTextBox, "value"); }

    String getOriginCity () { return getAttribute(originCityTextBox, "value"); }

    String getOriginState () { return getAttribute(originStateTextBox, "value"); }

    String getOriginCountry () { return getAttribute(originCountryTextBox, "value"); }

    String getDestinationCity () { return getAttribute(destinationCityTextBox, "value"); }

    String getDestinationState () { return getAttribute(destinationStateTextBox, "value"); }

    String getDestinationCountry () { return getAttribute(destinationCountryTextBox, "value"); }

    String getShippingDate () { return getAttribute(shippingDateTextBox, "value"); }

    String getMode () { return selectedDropdownValue(NocFormDropdownField.MODE.getFieldName()); }

    String getGtrGblIndicator () { return selectedDropdownValue(NocFormDropdownField.GTR_GBL_INDICATOR.getFieldName()); }

    String getShipSpecificReference () { return getAttribute(shipSpecificReferenceTextBox, "value"); }

    String getAdditionalRoutingInformation () { return getAttribute(additionalRoutingInformationTextBox, "value"); }

    String getBasisAndAuthority () { return getAttribute(basisAndAuthorityTextBox, "value"); }
}