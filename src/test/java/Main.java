import buymepages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeClass
    public static void runOnceBeforeClass() {


        //initialize reporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\extent.html");
        // attached reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // test's name and description
        test = extent.createTest("BuyMeTest", "BuyMe report");
    }



        @Test
        //Enter to buyme website and make a registration
        public void test01_enterToBuyMeAndRegister() {
            RegisterPage registerPage = new RegisterPage();
            registerPage.register();
            test.log(Status.PASS, "Enter to BuyMe website");
        }

        @Test
        public void test02_chooseGiftCardType(){
            HomePage homePage = new HomePage();
            homePage.chooseGiftType();
        }

        @Test
        public void test03_chooseBusiness(){
            BusinessPage businessPage = new BusinessPage();
            businessPage.chooseBusinessGiftCard();
        }

        @Test
    public void test04_senderAndReceiverData(){
            SenderReceiverPage senderReceiverPage = new SenderReceiverPage();
            senderReceiverPage.senderAndReceiverInfo();

        }










//    //Screenshot
//    private static String takeScreenShot(String ImagesPath) {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File(ImagesPath+".png");
//        try {
//            FileUtils.copyFile(screenShotFile, destinationFile);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return ImagesPath+".png";
//    }

    @AfterClass
    public static void afterClass() {
//end test and save data into report file
//        driver.quit();
        extent.flush();



        }



}


