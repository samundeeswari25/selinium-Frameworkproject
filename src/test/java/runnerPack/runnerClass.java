package runnerPack;

import base.baseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "", glue = "", plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class runnerClass extends baseClass {
    @BeforeClass
    public static void startbrowser() {
        openTheBrowser();
        maximize();
    }

    @AfterClass
    public static void closebrowser() {
        closethebrowser();
    }

}
