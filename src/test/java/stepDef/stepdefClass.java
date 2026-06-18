package stepDef;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import utils.ExcelReader;

import java.io.File;
import java.io.IOException;

public class stepdefClass {

    @When("Enter username and password")
    public void enter_username_and_password() throws Exception {


        String username = ExcelReader.getData(1, 0);
        String password = ExcelReader.getData(1, 1);

        System.out.println(username);
        System.out.println(password);
    }
    @Given("get url")
    public void get_url() {
    }


    }






