package factory;

import io.opentelemetry.sdk.autoconfigure.spi.internal.ConfigurableMetricReaderProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.configReader;

import java.io.IOException;

public class DriverFactory {

    public static configReader config;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeBrowser() throws IOException {
//        configReader c = new configReader();
        config = new configReader();

        String browser = config.getBrowser();
        System.out.println("Browser from .env: " + browser);

//        String browser = c.getBrowser();


        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

// Open browser in incognito
            options.addArguments("--incognito");

// Maximize browser
            options.addArguments("--start-maximized");

// Disable notifications
            options.addArguments("--disable-notifications");

            driver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {


        } else {
            System.out.println("Browser not available");
        }

        driver.get().get(config.getUrl());
        System.out.println(" Opened URL: " + config.getUrl());


//        driver.get().manage().window().maximize();
//        driver.get().get(c.getUrl());
        return driver.get();

    }


    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }



    public static WebDriver getDriver() {
       return driver.get();
    }

    public static void setDriver(WebDriver dri){
       DriverFactory.driver.set(dri);
    }
}
