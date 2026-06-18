package Hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import utils.ExtentManager;

import java.io.File;
import java.io.IOException;

public class Hooks {
    public static ExtentReports extent;
    public static ExtentTest test;

    public Hooks() {
    }

    @Before(order = 0)
    public void clearAllureReport() throws Exception {
        try {
            File clearfile = new File("allure-results");
            File clearreport = new File("allure-report");
            if (clearfile.exists() || clearreport.exists()) {
                FileUtils.cleanDirectory(clearfile);
                FileUtils.cleanDirectory(clearreport);
                System.out.println("allure results cleaned");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Before(order = 1)
    public void setup(Scenario scenario) throws IOException {
        DriverFactory.initializeBrowser();
        extent = ExtentManager.setup();
        test = extent.createTest(scenario.getName());

    }

    @After
    public void closeBrowser(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()) {
            test.fail("Scenario Failed");
        } else {
            test.pass("Scenario Passed");
        }
        extent.flush();
        DriverFactory.closebrowser();

    }



}
