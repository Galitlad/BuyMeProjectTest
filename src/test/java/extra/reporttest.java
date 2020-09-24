package extra;




import base.BasePage;
import buymepages.Singleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class reporttest extends BasePage {

    private static WebDriver driver;

        // create ExtentReports and attach reporter(s)
        private static ExtentReports extent;
        // creates a toggle for the given test, adds all log events under it
        private static ExtentTest test;

        @BeforeClass
        public void test() {
            this.driver = Singleton.getDriverInstance();
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\extent.html");
// attach reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
// name your test and add description
            test = extent.createTest("BuyMeTest", "BuyMe report");
        }

        @Test
        public void test01_assertWebsiteURL() {
            String actualURL = driver.getCurrentUrl();
            String expectedURL = "https://buyme.co.il/";
            System.out.println("actual URL is - " + actualURL + " and expected URL is - " + expectedURL);
            Assert.assertEquals(actualURL,expectedURL);

            test.log(Status.PASS, "Actual and expected URL are equal ");
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
