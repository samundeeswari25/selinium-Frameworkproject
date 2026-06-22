package page;

import factory.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage {

    By username = By.id("user");
    By password = By.id("pass");
    By loginBtn = By.id("login");

    public void login(String user, String pass) {
        DriverFactory.getDriver().findElement(username).sendKeys(user);
        DriverFactory.getDriver().findElement(password).sendKeys(pass);
        DriverFactory.getDriver().findElement(loginBtn).click();
    }
}

