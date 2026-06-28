package stepDef;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import page.PageobjectManager;
import utils.ExcelManager;
import utils.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class stepdefClass {

    PageobjectManager pom =
            new PageobjectManager(DriverFactory.getDriver());

    public static Logger log = LogManager.getLogger(stepdefClass.class);

    @Given("User data{string}")
    public void user_details(String Testcase) throws IOException {
        Map<String, String> data =
                ExcelReader.getData(
                        "src/test/resources/testData.xlsx",
                        "Sheet1",
                        Testcase
                );

        System.out.println(data);
        ExcelManager.setTestdata(data);
    }
}








