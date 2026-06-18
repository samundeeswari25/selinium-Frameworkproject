package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class baseClass {

    public static WebDriver driver;
    public static Alert alert;
    public static Robot robot;


    //Sendkeys
    public static void sendkeys(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }


    //implicity wait
    public static void implWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // explicitwait
    public static void explicitywait(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // screenshot fullpage
    public static void fullscreen(String fullpage) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver;
        File ssc = ss.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\D E L L\\IdeaProjects\\cucumbertask\\target\\screenshot/\" + img + \".png");
        Files.copy(ssc.toPath(), path.toPath());

    }

    // singleElement screenshot
    public static void singlescreenshot(WebElement e, String img) throws IOException {
        File ss = e.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\D E L L\\IdeaProjects\\cucumbertask\\target\\screenshot/\" + img + \".png");
        Files.copy(ss.toPath(), path.toPath());

    }

    // alert
    public static void simplealert() {
        alert = driver.switchTo().alert();
    }

    public static void accept() {
        alert.accept();
    }

    public static void dismiss() {
        alert.dismiss();
    }

    public static void gettext() {
        String text = alert.getText();
    }

    // Robot
    public static void robotmethod(int enterkey) throws AWTException {
        robot = new Robot();
        robot.keyPress(enterkey);
        robot.keyRelease(enterkey);
    }




}
