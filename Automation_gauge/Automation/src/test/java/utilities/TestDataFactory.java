package utilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gov.tams.common.CommonProperties;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author erlan.beisen
 * August, 9 2019
 * Fetches test data from recources folder using Spec name or Scenario name
 */
public final class TestDataFactory {

    public static JsonObject scenarioTestDataObject;
    private static Logger logger;

    private TestDataFactory () {}

    static { init(); }

    private static void init () { logger = logger == null ? Logger.getLogger(TestDataFactory.class) : logger; }

    /**
     * Sets up scenario test data object
     * @param specName - specName
     * @param scenarioName - scenarioName
     * @throws FileNotFoundException - FileNotFoundException
     */
    static void setScenarioTestData ( String specName, String scenarioName ) throws FileNotFoundException {
        String specTestDataFilePath = CommonProperties.USER_DIR + "/src/test/resources/test-data/" + specName + ".json";

        File jsonFile = new File(specTestDataFilePath);
        boolean isTestDataFile = jsonFile.exists();
        if ( isTestDataFile ) {
            JsonObject jsonObject = new Gson().fromJson(new FileReader(jsonFile), JsonObject.class);
            scenarioTestDataObject = jsonObject.getAsJsonObject(scenarioName);
            logger.info("Test data for Scenario \"" + scenarioName + "\" of Specification: \"" + specName + "\" found");
        } else {
            logger.error("Test data for Spec \"" + specName + "\" not found in 'test-data' directory");
        }
    }

    /**
     * Work in progress
     * Fetches current scenario row (from .CSV file, which set as test data source in Spec file as table) test data
     * @param specName - specName
     * @param scenarioName - scenarioName
     * @return Test data in json format
     */
    private static JsonObject getScenarioRowTestData ( String specName, String scenarioName ) {
        JsonObject scenarioTestDataObject;
        return null;
    }
}
