package gov.tams.common;

import com.thoughtworks.gauge.Gauge;
import org.apache.log4j.Logger;
import utilities.DatabaseConnection;

/**
 * @author erlan.beisen
 * August, 16 2019
 * TAMS common database calls
 */
public class CommonDatabaseActions extends DatabaseConnection {

    private Logger logger;

    protected CommonDatabaseActions () { init(); }

    private void init () {
        logger = logger == null ? Logger.getLogger(CommonDatabaseActions.class) : logger;
    }

    /**
     * @author erlan.beisen
     * Deletes NOC created form from database by using DRN
     */
    void deleteNocRecord () {
        String drn = NocVO.getDrn();
        if ( drn != null ) {
            String query = "SELECT id FROM tamsnoc.receivable WHERE doc_ref_num = '" + drn + "';";
            String nocId = getQueryResult(query);
            String storeProc = "SELECT tamsnoc.delete_noc(" + nocId + ")";
            executeStoreProcedure(storeProc);
            String infoMessage = "DRN \"" + drn + "\" with ID " + nocId + " was removed from database";
            logger.info(infoMessage);
            Gauge.writeMessage(infoMessage);
        } else {
            logger.error("Could not remove DRN from database. DRN was not define");
        }
    }
}