package Hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.AllureclearReport;
import utils.ExcelManager;
import utils.ExtentManager;
import utils.LoggerUtils;

public class HooksClass {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static Logger log = LoggerUtils.getlogger(HooksClass.class);

    @Before
    public void setup() throws Exception {
        AllureclearReport.clearAllureReport();
        DriverFactory.initializeBrowser();
        extent = ExtentManager.setup();
        log.info("Browser initialized");
    }

    @Before
    public void scenarioSetup(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

    @After
    public void scenarioStatus(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Scenario Failed: " + scenario.getName());
            test.fail("Scenario Failed");
        } else {
            log.info("Scenario Passed: " + scenario.getName());
            test.pass("Scenario Passed");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error("Scenario Failed: " + scenario.getName());
        } else {
            log.info("Scenario Passed: " + scenario.getName());
        }

        DriverFactory.getDriver().quit();
    }
}