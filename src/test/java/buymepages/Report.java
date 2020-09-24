package buymepages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.FileAssert.fail;

public class Report {


    private static ChromeDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;

    @BeforeClass
    public static void beforeClass() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\new file\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("BuyMeTest", "BuyMe report");
        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Galit");
        // log results
        test.log(Status.INFO, "@Before class");

        boolean driverEstablish = false;
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Desktop\\new file\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driverEstablish = true;
        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect chromeDriver");
            test.log(Status.FAIL, "Driver Connection Failed! " + e.getMessage());
            driverEstablish = false;
        } finally {
            if (driverEstablish) {
                test.log(Status.PASS, "Driver established successfully");
            }
        }
    }
    @Test
    public void test01_assertWebsiteURL() {
        //check Assert website URL
        String URL = driver.getCurrentUrl();
        String title = driver.getTitle();
        Assert.assertEquals(URL, title);
        System.out.println("URL is - " + URL + " Titel is - " + title);

        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\galit\\Desktop\\new file\\"+ timeNow)).build());
        test.log(Status.FAIL, "URL and Titel are not equal ");

    }

    @Test
    public static void test01_enterWebsite() {
        driver.get("https://buyme.co.il");

        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\galit\\Desktop\\new file\\"+ timeNow)).build());

        test.log(Status.PASS, "buyme web open successfully");






    }


    @AfterClass
public static void afterClass(){
    driver.quit();
    extent.flush();
    }

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C:\\Users\\galit\\Desktop\\new file\\extent.html"+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "C:\\Users\\galit\\Desktop\\new file\\extent.html"+".png";
    }
}