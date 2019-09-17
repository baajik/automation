package utilities;

import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Local test data storage
 */
public final class DataStore {

    private static Logger logger;

    private DataStore() {}

    static { init(); }

    private static void init () { logger = logger == null ? Logger.getLogger(DataStore.class) : logger; }

    public static void storeObject ( String key, Object value ) {
        DataStoreFactory.getScenarioDataStore().put(key, value);
        logger.info(key + " : " + value + " - stored in Data Store");
    }

    public static Object getValueAsObject ( String key ) {
        Object object = null;
        if ( isObjectKey( key ) ) {
            object = DataStoreFactory.getScenarioDataStore().get(key);
        } else {
            Common.failTest("Object \"" + key + "\" was not found");
        }
        return object;
    }

    public static String getValueAsString ( String key ) {
        return getValueAsObject(key).toString();
    }

    public static int getValueAsInt ( String key ) {
        return Integer.parseInt(getValueAsString(key));
    }

    @SuppressWarnings("unchecked")
    public static List<String> getValueAsList (String key ) { return (List) getValueAsObject(key); }

    public static double getValueAsDouble ( String key ) {
        return Double.parseDouble(getValueAsString(key));
    }

    public static boolean isObjectKey ( String key ) { return DataStoreFactory.getScenarioDataStore().get(key) != null; }
}
