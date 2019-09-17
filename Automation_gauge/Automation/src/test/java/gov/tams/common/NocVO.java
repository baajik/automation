package gov.tams.common;

import org.apache.log4j.Logger;

/**
 * @author erlan.beisen
 * August, 14 2019
 */
public final class NocVO {

    private static Logger logger;

    static { init(); }

    private NocVO() {}

    private static void init () { logger = logger == null ? Logger.getLogger(NocVO.class) : logger; }

    private static String drn;
    private static String carrierBillNumber;
    private static String scac;
    private static String agencyCode;
    private static String specialIssueCode;
    private static String iataCode;
    private static String auditorNumber;
    private static String timeSpentByAuditor;
    private static String auditCompany;
    private static String prepaymentAuditor;
    private static String dateEBillCreated;
    private static String overchargeType;
    private static String foreignCurrency;
    private static String dateBillPaid;
    private static String dateInvoiceReceived;
    private static String originCity;
    private static String originState;
    private static String originCountry;
    private static String destinationCity;
    private static String destinationState;
    private static String destinationCountry;
    private static String shippingDate;
    private static String mode;
    private static String gtrGblIndicator;
    private static String shipSpecificReference;
    private static String additionalRoutingInformation;
    private static String basisAndAuthority;
    private static String nocStatus;
    private static double shouldBeAmount;
    private static double amountPaid;
    private static double overchargeAmount;

    public static String getDrn() { return drn; }

    public static void setDrn(String drn) {
        NocVO.drn = drn;
        logger.info("NOC - DRN set to " + drn);
    }

    public static String getCarrierBillNumber() {
        return carrierBillNumber;
    }

    public static void setCarrierBillNumber(String carrierBillNumber) {
        NocVO.carrierBillNumber = carrierBillNumber;
        logger.info("NOC - Carrier Bill Number set to " + carrierBillNumber);
    }

    public static String getScac() {
        return scac;
    }

    public static void setScac(String scac) {
        NocVO.scac = scac;
        logger.info("NOC - SCAC set to " + scac);
    }

    public static String getAgencyCode() { return agencyCode; }

    public static void setAgencyCode(String agencyCode) {
        NocVO.agencyCode = agencyCode;
        logger.info("NOC - Agency Code set to " + agencyCode);
    }

    public static String getSpecialIssueCode() {
        return specialIssueCode;
    }

    public static void setSpecialIssueCode(String specialIssueCode) {
        NocVO.specialIssueCode = specialIssueCode;
        logger.info("NOC - Special Issue Code set to " + specialIssueCode);
    }

    public static String getIataCode() {
        return iataCode;
    }

    public static void setIataCode(String iataCode) {
        NocVO.iataCode = iataCode;
        logger.info("NOC - IATA Code set to " + iataCode);
    }

    public static String getAuditorNumber() {
        return auditorNumber;
    }

    public static void setAuditorNumber(String auditorNumber) {
        NocVO.auditorNumber = auditorNumber;
        logger.info("NOC - Auditor Number set to " + auditorNumber);
    }

    public static String getTimeSpentByAuditor() {
        return timeSpentByAuditor;
    }

    public static void setTimeSpentByAuditor(String timeSpentByAuditor) {
        NocVO.timeSpentByAuditor = timeSpentByAuditor;
        logger.info("NOC - Time Spent By Auditor set to " + timeSpentByAuditor);
    }

    public static String getAuditCompany() {
        return auditCompany;
    }

    public static void setAuditCompany(String auditCompany) {
        NocVO.auditCompany = auditCompany;
        logger.info("NOC - Audit Company set to " + auditCompany);
    }

    public static String getPrepaymentAuditor() {
        return prepaymentAuditor;
    }

    public static void setPrepaymentAuditor(String prepaymentAuditor) {
        NocVO.prepaymentAuditor = prepaymentAuditor;
        logger.info("NOC - Prepayment Auditor set to " + prepaymentAuditor);
    }

    public static String getDateEBillCreated() {
        return dateEBillCreated;
    }

    public static void setDateEBillCreated(String dateEBillCreated) {
        NocVO.dateEBillCreated = dateEBillCreated;
        logger.info("NOC - Date E-Bill Created set to " + dateEBillCreated);
    }

    public static double getShouldBeAmount() {
        return shouldBeAmount;
    }

    public static void setShouldBeAmount(String shouldBeAmount) {
        NocVO.shouldBeAmount = Double.parseDouble(shouldBeAmount);
        logger.info("NOC - Should Be Amount set to " + shouldBeAmount);
    }

    public static double getAmountPaid() {
        return amountPaid;
    }

    public static void setAmountPaid(String amountPaid) {
        NocVO.amountPaid = Double.parseDouble(amountPaid);
        logger.info("NOC - Amount Paid set to " + amountPaid);
    }

    public static double getOverchargeAmount() { return overchargeAmount; }

    public static void setOverchargeAmount(String overchargeAmount) {
        NocVO.overchargeAmount = Double.parseDouble(overchargeAmount);
        logger.info("NOC - Overcharge Amount set to " + overchargeAmount);
    }

    public static String getOverchargeType() {
        return overchargeType;
    }

    public static void setOverchargeType(String overchargeType) {
        NocVO.overchargeType = overchargeType;
        logger.info("NOC - Overcharge Type set to " + overchargeType);
    }

    public static String getForeignCurrency() {
        return foreignCurrency;
    }

    public static void setForeignCurrency(String foreignCurrency) {
        NocVO.foreignCurrency = foreignCurrency;
        logger.info("NOC - Foreign Currency set to " + foreignCurrency);
    }

    public static String getDateBillPaid() {
        return dateBillPaid;
    }

    public static void setDateBillPaid(String dateBillPaid) {
        NocVO.dateBillPaid = dateBillPaid;
        logger.info("NOC - Date Bill Paid set to " + dateBillPaid);
    }

    public static String getDateInvoiceReceived() {
        return dateInvoiceReceived;
    }

    public static void setDateInvoiceReceived(String dateInvoiceReceived) {
        NocVO.dateInvoiceReceived = dateInvoiceReceived;
        logger.info("NOC - Date Invoice Received set to " + dateInvoiceReceived);
    }

    public static String getOriginCity() {
        return originCity;
    }

    public static void setOriginCity(String originCity) {
        NocVO.originCity = originCity;
        logger.info("NOC - Origin City set to " + originCity);
    }

    public static String getOriginState() {
        return originState;
    }

    public static void setOriginState(String originState) {
        NocVO.originState = originState;
        logger.info("NOC - Origin State set to " + originState);
    }

    public static String getOriginCountry() {
        return originCountry;
    }

    public static void setOriginCountry(String originCountry) {
        NocVO.originCountry = originCountry;
        logger.info("NOC - Origin Country set to " + originCountry);
    }

    public static String getDestinationCity() {
        return destinationCity;
    }

    public static void setDestinationCity(String destinationCity) {
        NocVO.destinationCity = destinationCity;
        logger.info("NOC - Destination City set to " + destinationCity);
    }

    public static String getDestinationState() {
        return destinationState;
    }

    public static void setDestinationState(String destinationState) {
        NocVO.destinationState = destinationState;
        logger.info("NOC - Destination State set to " + destinationState);
    }

    public static String getDestinationCountry() {
        return destinationCountry;
    }

    public static void setDestinationCountry(String destinationCountry) {
        NocVO.destinationCountry = destinationCountry;
        logger.info("NOC - Destination Country set to " + destinationCountry);
    }

    public static String getShippingDate() {
        return shippingDate;
    }

    public static void setShippingDate(String shippingDate) {
        NocVO.shippingDate = shippingDate;
        logger.info("NOC - Shipping Date set to " + shippingDate);
    }

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        NocVO.mode = mode;
        logger.info("NOC - Mode set to " + mode);
    }

    public static String getGtrGblIndicator() {
        return gtrGblIndicator;
    }

    public static void setGtrGblIndicator(String gtrGblIndicator) {
        NocVO.gtrGblIndicator = gtrGblIndicator;
        logger.info("NOC - GTR/GBL Indicator set to " + gtrGblIndicator);
    }

    public static String getShipSpecificReference() {
        return shipSpecificReference;
    }

    public static void setShipSpecificReference(String shipSpecificReference) {
        NocVO.shipSpecificReference = shipSpecificReference;
        logger.info("NOC - Ship Specific Reference set to " + shipSpecificReference);
    }

    public static String getAdditionalRoutingInformation() {
        return additionalRoutingInformation;
    }

    public static void setAdditionalRoutingInformation(String additionalRoutingInformation) {
        NocVO.additionalRoutingInformation = additionalRoutingInformation;
        logger.info("NOC - Additional Routing Information set to " + additionalRoutingInformation);
    }

    public static String getBasisAndAuthority() {
        return basisAndAuthority;
    }

    public static void setBasisAndAuthority(String basisAndAuthority) {
        NocVO.basisAndAuthority = basisAndAuthority;
        logger.info("NOC - Basis and Authority set to " + basisAndAuthority);
    }

    public static String getNocStatus() {
        return nocStatus;
    }

    public static void setNocStatus(String nocStatus) {
        NocVO.nocStatus = nocStatus;
        logger.info("NOC - NOC Status set to " + nocStatus);
    }
}
