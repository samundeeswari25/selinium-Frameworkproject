package runnerPack;

import Hooks.Hooks;
import base.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ExtentManager;
import java.io.IOException;

import static factory.DriverFactory.driver;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFolder/intro.feature",glue = {"stepDef","Hooks"}, dryRun = false, plugin = {"pretty","html:target/cucumber-report.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class runnerClass   {



}










