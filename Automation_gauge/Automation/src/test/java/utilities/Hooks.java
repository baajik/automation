package utilities;

import com.thoughtworks.gauge.*;
import gov.tams.common.CommonProperties;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Hooks class to set up test for execution
 */
public final class Hooks extends Steps {

    private Logger logger;

    public Hooks () { init(); }

    private void init () {
        logger = logger == null ? Logger.getLogger(Hooks.class) : logger;
    }

    /**
     * @author erlan.beisen
     * Environment set up for test automation scripts
     */
    @BeforeSuite
    public void suiteSetUp () {
        Gauge.writeMessage("URL: " + CommonProperties.BASE_URL);
    }

    @BeforeSpec
    public void specSetUp ( ExecutionContext executionContext ) {
        String specName = executionContext.getCurrentSpecification().getName();
        logger.info("Specification: \"" + specName + "\" started");
    }

    /**
     * @author erlan.beisen
     * Scenario set up
     */
    @BeforeScenario
    public void scenarioSetUp ( ExecutionContext executionContext ) throws IOException {
        String specName = executionContext.getCurrentSpecification().getName();
        String scenarioName = executionContext.getCurrentScenario().getName();
        DataStore.storeObject("scenario name", scenarioName);
        TestDataFactory.setScenarioTestData(specName, scenarioName);
        logger.info("Scenario: \"" + scenarioName + "\" of Specification: \"" + specName + "\" started");

        boolean isVideoRecord = Boolean.parseBoolean(System.getenv("video_record"));
        if ( isVideoRecord ) {
            TestVideoRecord.screenRecorder.start();
            logger.info("Video record for Scenario \"" + scenarioName + "\" started");
        }
    }

    @BeforeStep
    public void stepSetUp ( ExecutionContext executionContext ) {
        String stepName = executionContext.getCurrentStep().getText();
        DataStore.storeObject("step name", stepName);
        softAssert = new SoftAssert();
    }

    @AfterStep
    public void stepTearDown ( ExecutionContext executionContext ) {
        String scenarioName = executionContext.getCurrentScenario().getName();
        String stepName = executionContext.getCurrentStep().getText();
        boolean isFailed = executionContext.getCurrentStep().getIsFailing();
        String stepStatus = isFailed ? "failed" : "passed";
        logger.info("Step: \"" + stepName + "\" of Scenario: \"" + scenarioName + "\" ended with Status: \"" + stepStatus + "\"");
        softAssert = null;

        boolean isAssertStatus = DataStore.isObjectKey(stepName + " assert");
        if ( isAssertStatus ) {
            String assertStatus = DataStore.getValueAsString(stepName + " assert");
            if ( assertStatus.equals("start") ) {
                String errorMessage = "Assert for Step \"" + stepName + "\" never ended (add assertAll(); in the end of the step)";
                logger.error(errorMessage);
                Gauge.writeMessage(errorMessage);
            }
        }
    }

    /**
     * @author erlan.beisen
     * Checks Scenario execution status
     */
    @AfterScenario
    public void scenarioTearDown ( ExecutionContext executionContext ) throws IOException {
        String specName = executionContext.getCurrentSpecification().getName();
        String scenarioName = executionContext.getCurrentScenario().getName();
        boolean isFailed = executionContext.getCurrentScenario().getIsFailing();
        String scenarioStatus = isFailed ? "failed" : "passed";
        logger.info("Scenario: \"" + scenarioName + "\" of Specification: \"" + specName + "\" ended with Status: \"" + scenarioStatus + "\"");

        Gauge.captureScreenshot();
        TestVideoRecord.screenRecorder.stop();
    }

    @AfterSpec
    public void specTearDown ( ExecutionContext executionContext ) {
        String specName = executionContext.getCurrentSpecification().getName();
        logger.info("Specification: \"" + specName + "\" ended");
    }

    /**
     * @author erlan.beisen
     * Close browser action after all test executed
     */
    @AfterSuite
    public void suiteTearDown () {
        this.closeBrowser();
        DatabaseConnection.closeDatabaseConnection();
        System.gc();
        System.runFinalization();
    }
}
