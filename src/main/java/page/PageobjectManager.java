package page;

import org.openqa.selenium.WebDriver;

public class PageobjectManager {

    private WebDriver driver;
    private LoginPage loginPage;

    public PageobjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}

