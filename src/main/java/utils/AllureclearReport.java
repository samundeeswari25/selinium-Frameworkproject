package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

import static base.baseClass.log;

public class AllureclearReport {

    public static void clearAllureReport() throws Exception {
        try {
            log.info("Clearing Allure Reports");

            File clearfile = new File("allure-results");
            File clearreport = new File("allure-report");

            if (clearfile.exists()) {
                FileUtils.cleanDirectory(clearfile);
            }

            if (clearreport.exists()) {
                FileUtils.cleanDirectory(clearreport);
            }
            log.info("Allure results cleaned");


        } catch (Exception e) {
            log.error("Error while clearing Allure reports: " + e.getMessage());
        }
    }

}
