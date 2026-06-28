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

    @Before(order = 1)
    public void setup() throws Exception {
        AllureclearReport.clearAllureReport();
        DriverFactory.initializeBrowser();
        extent = ExtentManager.setup();
        log.info("Browser initialized");
    }

    @Before(order = 2)
    public void scenarioSetup(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

    // Merged both @After into ONE method
    @After
    public void tearDown(Scenario scenario) {

        // Handle pass/fail reporting
        if (scenario.isFailed()) {
            log.error("Scenario Failed: " + scenario.getName());
            test.fail("Scenario Failed: " + scenario.getName());
        } else {
            log.info("Scenario Passed: " + scenario.getName());
            test.pass("Scenario Passed: " + scenario.getName());
        }
        //  Quit driver safely with null check
        if (DriverFactory.getDriver() != null) {
            DriverFactory.closeBrowser();   // use closeBrowser() — removes ThreadLocal too
            log.info("Browser closed.");
        }

    }
}