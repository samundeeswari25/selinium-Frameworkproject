package base;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.baseClass;
import utils.LoggerUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;


public class baseClass {

    public static Logger log = LogManager.getLogger(baseClass.class);
    public static Alert alert;
    public static Robot robot;

//    // Launch browser logs
//    public void launchBrowser() {
//
//        LoggerUtils.log.info("Browser launching");
//
//        LoggerUtils.log.info("Browser launched");
//
//    }

    // Sendkeys
    public static void sendKeys(By locator, String value) {
        DriverFactory.getDriver().findElement(locator).sendKeys(value);
    }

    // Implicit wait
    public static void implWait() {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Explicit wait
    public static void explicitWait(By locator) {
        WebDriverWait wait =
                new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Full page screenshot
    public static void fullScreen(String img) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();

        File src = ss.getScreenshotAs(OutputType.FILE);

        File path = new File(
                "target\\screenshot\\" + img + ".png"
        );

        Files.copy(src.toPath(), path.toPath());
    }

    // Single element screenshot
    public static void singleScreenshot(WebElement e, String img)
            throws IOException {

        File src = e.getScreenshotAs(OutputType.FILE);

        File path = new File(
                "target\\screenshot\\" + img + ".png"
        );

        Files.copy(src.toPath(), path.toPath());
    }

    // Alert
    public static void simpleAlert() {
        alert = DriverFactory.getDriver().switchTo().alert();
    }

    public static void accept() {
        alert.accept();
    }

    public static void dismiss() {
        alert.dismiss();
    }

    public static String getText() {
        return alert.getText();
    }

    // Robot
    public static void robotMethod(int key) throws AWTException {
        robot = new Robot();

        robot.keyPress(key);
        robot.keyRelease(key);
    }
//Js click
    public static void jsClick(WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) DriverFactory.getDriver();

        js.executeScript("arguments[0].click();", element);
    }
}




