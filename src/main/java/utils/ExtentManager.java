package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports setup() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("target/ExtentReport.html");

        spark.config().setReportName("Automation Report");
        spark.config().setDocumentTitle("Cucumber Test Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        return extent;
    }
}

