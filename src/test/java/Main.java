import base.Singleton;
import buymepages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;



public class Main {

    // create ExtentReports and attach reporter(s)
    public static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test;
    public static WebDriver driver;

    @BeforeClass

    public static void runOnceBeforeClass() {
        driver = Singleton.getDriverInstance();
        //initialize reporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\new file\\extent.html");
        // attached reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // test's name  and description
        test = extent.createTest("BuyMeTest", "BuyMe report");
        test.log(Status.INFO, "@Before class");
    }




    @Test
    //Enter to buyme website and make a registration
    public void test01_enterToBuyMeAndRegister() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.enterToWebsite();
        test.log(Status.PASS, "enter to buy me site and make a registration");
    }


    @Test
    //Choose gift card price, region and category
    public void test02_chooseGiftCardType(){
        HomePage homePage = new HomePage();
        homePage.chooseGiftType();
        test.log(Status.PASS, "Choose gift price, region, category and press on find me a gift button");
    }

    @Test
    //Assert website URL
    public void test03_assertWebsiteURL(){
        BusinessPage businessPage = new BusinessPage();
        businessPage.assertURL();
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\galit\\Desktop\\new file"+ timeNow)).build());
        test.log(Status.FAIL, "URL and expected URL are not equals");
    }

    @Test
    //Choose business and enter price
    public void test04_chooseBusiness(){
        BusinessPage businessPage = new BusinessPage();
        businessPage.chooseBusinessGiftCard();
        test.log(Status.PASS, "Choose buisness and enter gift card price");
    }

    @Test
    //Enter sender and receiver data, add blessing and picture
    public void test05_senderAndReceiverData(){
        SenderReceiverPage senderReceiverPage = new SenderReceiverPage();
        senderReceiverPage.senderAndReceiverInfo();
        test.log(Status.PASS, "Enter sender and receiver data, enter blessing and picture");
    }

    @AfterClass
    //Add test result to reporter and close website
    public static void afterClass(){
        driver.quit();
        extent.flush();
    }


    //Screenshot when test is fail
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C:\\Users\\galit\\Desktop\\new file\\extent.html"+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "C:\\Users\\galit\\Desktop\\extent.html"+".png";
    }


}


