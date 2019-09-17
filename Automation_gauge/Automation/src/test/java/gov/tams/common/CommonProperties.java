package gov.tams.common;

/**
 * @author erlan.beisen
 * August, 9 2019
 */
public final class CommonProperties {

    private CommonProperties() {}

    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String BASE_URL = System.getenv("base_url");
    public static final String CONTRACT_AUDITOR_USER_NAME = System.getenv("contract_auditor_username");
    public static final String CONTRACT_AUDITOR_USER_PASSWORD = System.getenv("contract_auditor_password");
    public static final String GSA_AUDITOR_USER_NAME = System.getenv("gsa_auditor_username");
    public static final String GSA_AUDITOR_USER_PASSWORD = System.getenv("gsa_auditor_password");

    public static String CURRENT_USER_ID;
    public static String CURRENT_USER_NAME;
}
