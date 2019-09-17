package gov.tams.contract_management;

import gov.tams.common.CommonDatabaseActions;
import org.apache.log4j.Logger;

/**
 * @author erlan.beisen
 * August, 22 2019
 * Common Contract Management database actions
 */
final class ContractManagementDB extends CommonDatabaseActions {

    private Logger logger;

    ContractManagementDB () { init(); }

    private void init () { logger = logger == null ? Logger.getLogger(ContractManagementDB.class) : logger; }

    String getModeDescription ( char accountMode ) {
        String query = "SELECT mode_desc FROM cnmgmt.account_mode WHERE account_mode = '" + accountMode + "';";
        return getQueryResult(query);
    }
}
