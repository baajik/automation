package gov.tams.noc_list;

import org.openqa.selenium.By;

/**
 * @author erlan.beisen
 * August, 13 2019
 * Web Elements locators of NOC List page
 */
final class NocListVO {

    private NocListVO () {}

    /* title */
    static final By NOC_LIST_TITLE = By.tagName("h3");
    /* links/buttons */
    static final By createNocButton = By.xpath("//button[contains(text(), 'Create NOC')]");
    /* Table fields found by using 'Doc Ref Number - DRN' */
    static final String drnLinkXpath = "//a[contains(., \"{0}\")]";
    static final String issueDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[2]";
    static final String paidDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[3]";
    static final String overchargeFieldXpath = "//tr[contains(.,\"{0}\")]//td[4]";
    static final String statusFieldXpath = "//tr[contains(.,\"{0}\")]//td[5]";
    static final String ownerFieldXpath = "//tr[contains(.,\"{0}\")]//td[6]";
    static final String createdDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[7]";
}

/**
 * @author erlan.beisen
 * August, 21 2019
 * A sub page of NOC List page
 */
final class CreateNocVO {

    private CreateNocVO() {}

    static final By pageTitle = By.tagName("h3");
    /* Button locators */
    static final By findDrnButton = By.id("button-addon2");
    static final By cancelButton = By.xpath("//button[contains(text(), 'Cancel')]");
    static final By resetButton = By.xpath("//button[contains(text(), 'Reset')]");
    static final By saveDraftButton = By.xpath("//button[contains(text(), 'Save Draft')]");
    static final By submitButton = By.xpath("//button[contains(text(), 'Submit')]");
    /* Data entry sections */
    static final String dataEntrySections = "//h4[text()=\"{0}\"]";
    /* Text input box locators */
    static final By findDrnTextBox = By.xpath("//button[contains(text(), 'Find DRN')]/../..//input");
    /* Receivable Data Entry */
    static final By drnTextBox = By.name("docRefNum");
    static final By carrierBillNumberTextBox = By.name("carrierBillNum");
    static final By scacTextBox = By.cssSelector("[id^=scacId]");
    static final By agencyCodeTextBox = By.cssSelector("[id^=agencodeId]");
    static final By specialIssueCodeTextBox = By.cssSelector("[id^=spIssueCodeId]");
    static final By iataCodeTextBox = By.name("airlineTrnspCd");
    /* Auditor Data */
    static final By auditorNumberTextBox = By.name("govAudtNum");
    static final By timeSpentByAuditorTextBox = By.name("audtTimeSpent");
    static final By prepaymentAuditorTextBox = By.name("prepaymentAuditor");
    static final By dateE_BillCreatedTextBox = By.cssSelector("[id^=dateBillCreatedId]");
    /* Overcharge Data */
    static final By shouldBeAmountTextBox = By.name("shouldBeAmount");
    static final By amountPaidTextBox = By.name("paidAmount");
    static final By overchargeAmountTextBox = By.name("overchargeAmt");
    static final By dateBillPaidTextBox = By.name("dateBillPaid");
    static final By dateInvoiceReceivedTextBox = By.cssSelector("[id^=dateInvoiceReceivedId]");
    /* Routing */
    static final By originCityTextBox = By.name("originCity");
    static final By originStateTextBox = By.name("originState");
    static final By originCountryTextBox = By.name("originCountry");
    static final By destinationCityTextBox = By.name("destinationCity");
    static final By destinationStateTextBox = By.name("destinationState");
    static final By destinationCountryTextBox = By.name("destinationCountry");
    static final By shippingDateTextBox = By.cssSelector("[id^=shippingDateId]");
    static final By shipSpecificReferenceTextBox = By.name("shippingSpecRefNum");
    static final By additionalRoutingInformationTextBox = By.name("routingInfo");
    /* Basic */
    static final By basisAndAuthorityTextBox = By.name("basis");
    /* File upload */
    static final By FILE_UPLOAD_FIELD = By.cssSelector(".custom-file");
    static final By FILE_UPLOAD_TEXT_BOX = By.cssSelector("input.custom-file-input");
    static final By UPLOADED_FILES_LIST =  By.cssSelector(".list-inline li");
    static final String UPLOADED_FILE_XPATH = "//ul[@class=\"list-inline\"]//li[contains(., \"{0}\")]";
}