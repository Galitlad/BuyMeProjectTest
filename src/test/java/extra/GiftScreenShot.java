package extra;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GiftScreenShot {


    public static WebDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;


    @BeforeClass
    public static void runOnceBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("BuyMeTest", "BuyMe report");
    }


    @Test
    //Scroll to the bottom of the screen, take screenshot and add it to the report
    public static void test01_giftScreenShot() {
    //press on find me a gift button
     driver.findElement(By.id("ember836")).click();

     //Scroll to the bottom of the screen
     WebElement lastElement = driver.findElement(By.id("ember1145"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",lastElement);


     test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\galit\\Desktop")).build());
     test.log(Status.PASS, "this is the last element ");


    }

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }



    @AfterClass
    public static void afterClass() {
//end test and save data into report file
        extent.flush();
    }

}


