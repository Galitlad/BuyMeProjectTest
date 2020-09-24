package pompages;

import base.BasePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class HomePagePOM extends BasePage {
    private static WebDriver driver;

//
//    // create ExtentReports and attach reporter(s)
//    private static ExtentReports extent;
//    // creates a toggle for the given test, adds all log events under it
//    private static ExtentTest test;
//
//    @BeforeClass
//    public static void runOnceBeforeClass(){
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get("https://buyme.co.il");
//
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\extent.html");
//// attach reporter
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//// name your test and add description
//        test = extent.createTest("BuyMeTest", "BuyMe report");
//
//    }


    @Test
    public void test03_pickPricePoint(){
       //open pricelist dropdown
       clickElement(driver.findElement(By.id("ember776_chosen")));
       //pick price from pricelist dropdown
       clickElement(driver.findElement(By.xpath("//*[@id=\"ember776\"]/option[5]")));
//        test.log(Status.PASS, "Pick gift card price ");

    }

    @Test
    public void test04_pickRegionButton(){
        //open region dropdown
        clickElement(driver.findElement(By.id("ember753_chosen")));
        //pick region from region dropdown
        clickElement(driver.findElement(By.xpath("//*[@id=\"ember753_chosen\"]/div/ul/li[8]")));
//        test.log(Status.PASS, "Pick a region ");

    }

    @Test
    public void test05_pickCategoryButton(){
        //open category dropdown
        clickElement(driver.findElement(By.id("ember763_chosen")));
        //pick category from category dropdown
        clickElement(driver.findElement(By.xpath("//*[@id=\"ember763_chosen\"]/div/ul/li[5]")));
//        test.log(Status.PASS, "Pick category");
    }

    @Test
    public void test06_pressFindMeGift(){
        //press on find me a gift button
        clickElement(driver.findElement(By.id("ember798")));
//        test.log(Status.PASS, "Press on find me a gift button");
    }
}
