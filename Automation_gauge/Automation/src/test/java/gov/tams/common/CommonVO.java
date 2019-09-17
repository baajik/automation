package gov.tams.common;

import org.openqa.selenium.By;

final class CommonVO {

    final static By headerUserInfoLogo = By.cssSelector(".header-user-info");

    final static String drnLinkXpath = "//a[contains(., \"{0}\")]";
    final static String issueDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[2]";
    final static String paidDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[3]";
    final static String overchargeFieldXpath = "//tr[contains(.,\"{0}\")]//td[4]";
    final static String statusFieldXpath = "//tr[contains(.,\"{0}\")]//td[5]";
    final static String ownerFieldXpath = "//tr[contains(.,\"{0}\")]//td[6]";
    final static String createdDateFieldXpath = "//tr[contains(.,\"{0}\")]//td[7]";

    private static String modalWindow = "//div[@class=\"modal-content\"]";
    final static String drnSummaryModalWindowXpath = modalWindow + "[contains(., \"{0} Summary\")]";
    final static String drnDetailsModalWindowXLinkXpath = "//a[text()='DRN-Details']";
    final static String drnDetailsTabModalWindowXLinkXpath = "(" + modalWindow + "//div[contains(@id, 'tabs')])[1]";
    final static String drnAuditLogModalWindowXLinkXpath = "//a[text()='DRN-AuditLog']";
    final static String drnAuditLogTabModalWindowXLinkXpath = "(" + modalWindow + "//div[contains(@id, 'tabs')])[2]";
    final static String drnWorkflowLogModalWindowXLinkXpath = "//a[text()='DRN-WorkflowLog']";
    final static String drnWorkflowLogTabModalWindowXLinkXpath = "(" + modalWindow + "//div[contains(@id, 'tabs')])[3]";
    final static String drnDetailsModalWindowFieldXpath = "//label[contains(text(), \"{0}\")]/following-sibling::span";
    final static String drnModalWindowTableFieldXpath = "(" + modalWindow + "//div[contains(@class,\"active show\")]//tbody//tr[{0}])//td[{1}]";

    final static By noRecordsTextField = By.cssSelector("[aria-label='No records found']");
    final static By recordsTextField = By.xpath("//div[contains(@class,'active show')]//span[@class='paging-text']");
    final static By drnModalWindowTableXpath = By.xpath(modalWindow + "//div[contains(@class,'active show')]//table");
}
