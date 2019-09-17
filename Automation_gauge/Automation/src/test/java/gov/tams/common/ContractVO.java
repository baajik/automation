package gov.tams.common;

import org.apache.log4j.Logger;

/**
 * @author erlan.beisen
 * August, 20 2019
 * Contract common values
 */
public final class ContractVO {

    private static Logger logger;

    static { init(); }

    private ContractVO() {}

    private static void init () { logger = logger == null ? Logger.getLogger(ContractVO.class) : logger; }

    private static String contractNumber;
    private static String contractorCode;
    private static String companyName;
    private static String address1;
    private static String address2;
    private static String city;
    private static String state;
    private static String zip;
    private static String tin;
    private static String representative;
    private static String email;
    private static String phone;
    private static String faxNumber;
    private static String contractStartDate;
    private static String contractEndDate;
    private static String accountNumber;
    private static String amountAllocated;
    private static String amountSpent;
    private static String modeDescription;
    private static String status;
    private static String commission;
    private static String auditType;
    private static String numberOfOverchargeIssues;
    private static String amountOfOverchargesIssued;
    private static String amountOfOverchargesCollected;
    private static String amountOfCommissionDue;
    private static String amountOfCommissionPaid;
    private static String amountOfProtestAllowed;
    private static String amountOfWriteOffsAllowed;
    private static String amountOfReclaimsAllowed;
    private static String allocatedAmountRemaining;
    private static String allocatedAmountSpent;
    private static int fiscalYear;

    public static String getContractNumber() { return contractNumber; }

    public static void setContractNumber(String contractNumber) {
        ContractVO.contractNumber = contractNumber;
        logger.info("Contract Number set to " + contractNumber);
    }

    public static String getContractorCode() { return contractorCode; }

    public static void setContractorCode(String contractorCode) {
        ContractVO.contractorCode = contractorCode;
        logger.info("Contractor Code set to " + contractorCode);
    }

    public static String getCompanyName() { return companyName; }

    public static void setCompanyName(String companyName) {
        ContractVO.companyName = companyName;
        logger.info("Company Name set to " + companyName);
    }

    public static String getAddress1() { return address1; }

    public static void setAddress1(String address1) {
        ContractVO.address1 = address1;
        logger.info("Address 1 set to " + address2);
    }

    public static String getAddress2() { return address2; }

    public static void setAddress2(String address2) {
        ContractVO.address2 = address2;
        logger.info("Address 2 set to " + address2);
    }

    public static String getCity() { return city; }

    public static void setCity(String city) {
        ContractVO.city = city;
        logger.info("City set to " + city);
    }

    public static String getState() { return state; }

    public static void setState(String state) {
        ContractVO.state = state;
        logger.info("State set to " + state);
    }

    public static String getZip() { return zip; }

    public static void setZip(String zip) {
        ContractVO.zip = zip;
        logger.info("ZIP set to " + zip);
    }

    public static String getTin() { return tin; }

    public static void setTin(String tin) {
        ContractVO.tin = tin;
        logger.info("TIN set to " + tin);
    }

    public static String getRepresentative() { return representative; }

    public static void setRepresentative(String representative) {
        ContractVO.representative = representative;
        logger.info("Representative set to " + representative);
    }

    public static String getEmail() { return email; }

    public static void setEmail(String email) {
        ContractVO.email = email;
        logger.info("Email set to " + email);
    }

    public static String getPhone() { return phone; }

    public static void setPhone(String phone) {
        ContractVO.phone = phone;
        logger.info("Phone set to " + phone);
    }

    public static String getFaxNumber() { return faxNumber; }

    public static void setFaxNumber(String faxNumber) {
        ContractVO.faxNumber = faxNumber;
        logger.info("Fax Number set to " + faxNumber);
    }

    public static String getContractStartDate() { return contractStartDate; }

    public static void setContractStartDate(String contractStartDate) {
        ContractVO.contractStartDate = contractStartDate;
        logger.info("Contract Start Date set to " + contractStartDate);
    }

    public static String getContractEndDate() { return contractEndDate; }

    public static void setContractEndDate(String contractEndDate) {
        ContractVO.contractEndDate = contractEndDate;
        logger.info("Contract End Date set to " + contractEndDate);
    }

    public static String getAccountNumber() { return accountNumber; }

    public static void setAccountNumber(String accountNumber) {
        ContractVO.accountNumber = accountNumber;
        logger.info("Account Number set to " + accountNumber);
    }

    public static String getAmountAllocated() { return amountAllocated; }

    public static void setAmountAllocated(String amountAllocated) {
        ContractVO.amountAllocated = amountAllocated;
        logger.info("Amount Allocated set to " + amountAllocated);
    }

    public static String getAmountSpent() { return amountSpent; }

    public static void setAmountSpent(String amountSpent) {
        ContractVO.amountSpent = amountSpent;
        logger.info("Amount Spent set to " + amountSpent);
    }

    public static String getModeDescription() { return modeDescription; }

    public static void setModeDescription(String modeDescription) {
        ContractVO.modeDescription = modeDescription;
        logger.info("Mode Description set to " + modeDescription);
    }

    public static String getStatus() { return status; }

    public static void setStatus(String status) {
        ContractVO.status = status;
        logger.info("Status set to " + status);
    }

    public static String getCommission() { return commission; }

    public static void setCommission(String commission) {
        ContractVO.commission = commission;
        logger.info("Commission set to " + commission);
    }

    public static String getAuditType() { return auditType; }

    public static void setAuditType(String auditType) {
        ContractVO.auditType = auditType;
        logger.info("Audit Type set to " + auditType);
    }

    public static String getNumberOfOverchargeIssues() { return numberOfOverchargeIssues; }

    public static void setNumberOfOverchargeIssues(String numberOfOverchargeIssues) {
        ContractVO.numberOfOverchargeIssues = numberOfOverchargeIssues;
        logger.info("Number of Overcharge Issues set to " + numberOfOverchargeIssues);
    }

    public static String getAmountOfOverchargesIssued() { return amountOfOverchargesIssued; }

    public static void setAmountOfOverchargesIssued(String amountOfOverchargesIssued) {
        ContractVO.amountOfOverchargesIssued = amountOfOverchargesIssued;
        logger.info("Amount of Overcharges Issued set to " + amountOfOverchargesIssued);
    }

    public static String getAmountOfOverchargesCollected() { return amountOfOverchargesCollected; }

    public static void setAmountOfOverchargesCollected(String amountOfOverchargesCollected) {
        ContractVO.amountOfOverchargesCollected = amountOfOverchargesCollected;
        logger.info("Amount of Overcharges Collected set to " + amountOfOverchargesCollected);
    }

    public static String getAmountOfCommissionDue() { return amountOfCommissionDue; }

    public static void setAmountOfCommissionDue(String amountOfCommissionDue) {
        ContractVO.amountOfCommissionDue = amountOfCommissionDue;
        logger.info("Amount of Commission Due set to " + amountOfCommissionDue);
    }

    public static String getAmountOfCommissionPaid() { return amountOfCommissionPaid; }

    public static void setAmountOfCommissionPaid(String amountOfCommissionPaid) {
        ContractVO.amountOfCommissionPaid = amountOfCommissionPaid;
        logger.info("Amount of Commission Paid set to " + amountOfCommissionPaid);
    }

    public static String getAmountOfProtestAllowed() { return amountOfProtestAllowed; }

    public static void setAmountOfProtestAllowed(String amountOfProtestAllowed) {
        ContractVO.amountOfProtestAllowed = amountOfProtestAllowed;
        logger.info("Amount of Protest Allowed set to " + amountOfProtestAllowed);
    }

    public static String getAmountOfWriteOffsAllowed() { return amountOfWriteOffsAllowed; }

    public static void setAmountOfWriteOffsAllowed(String amountOfWriteOffsAllowed) {
        ContractVO.amountOfWriteOffsAllowed = amountOfWriteOffsAllowed;
        logger.info("Amount of Write Offs Allowed set to " + amountOfWriteOffsAllowed);
    }

    public static String getAmountOfReclaimsAllowed() { return amountOfReclaimsAllowed; }

    public static void setAmountOfReclaimsAllowed(String amountOfReclaimsAllowed) {
        ContractVO.amountOfReclaimsAllowed = amountOfReclaimsAllowed;
        logger.info("Amount of Reclaims Allowed set to " + amountOfReclaimsAllowed);
    }

    public static String getAllocatedAmountRemaining() { return allocatedAmountRemaining; }

    public static void setAllocatedAmountRemaining(String allocatedAmountRemaining) {
        ContractVO.allocatedAmountRemaining = allocatedAmountRemaining;
        logger.info("Allocated Amount Remaining set to " + allocatedAmountRemaining);
    }

    public static String getAllocatedAmountSpent() { return allocatedAmountSpent; }

    public static void setAllocatedAmountSpent(String allocatedAmountSpent) {
        ContractVO.allocatedAmountSpent = allocatedAmountSpent;
        logger.info("Allocated Amount Spent set to " + allocatedAmountSpent);
    }

    public static int getFiscalYear() { return fiscalYear; }

    public static void setFiscalYear(int fiscalYear) {
        ContractVO.fiscalYear = fiscalYear;
        logger.info("Fiscal Year set to " + fiscalYear);
    }
}