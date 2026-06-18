package factory;

import io.opentelemetry.sdk.autoconfigure.spi.internal.ConfigurableMetricReaderProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.configReader;

import java.io.IOException;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initializeBrowser() throws IOException {
        configReader c = new configReader();

        String browser = c.getBrowser();



        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();

// Open browser in incognito
            options.addArguments("--incognito");

// Maximize browser
            options.addArguments("--start-maximized");

// Disable notifications
            options.addArguments("--disable-notifications");

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else {
            System.out.println("Browser not available");
        }

        driver.manage().window().maximize();
        driver.get(c.getUrl());

        return driver;


    }

    public static void closebrowser(){
        driver.quit();
    }



}
