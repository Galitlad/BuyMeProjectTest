package buymepages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;


public class HomePage extends BasePage {

    private static WebDriver driver;

//
//    // create ExtentReports and attach reporter(s)
//    private static ExtentReports extent;
//    // creates a toggle for the given test, adds all log events under it
//    private static ExtentTest test;
//


        @BeforeClass
        public static void runOnceBeforeClass() {

            //initialize driver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
//        driver = Singleton.getDriverInstance();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://buyme.co.il");
        }

//
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\extent.html");
//// attach reporter
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//// name your test and add description
//        test = extent.createTest("BuyMeTest", "BuyMe report");
//
//    }

    public void chooseGiftType(){
        HomePage homePage = new HomePage();
        homePage.pickPricePoint();
        homePage.pickRegionButton();
        homePage.pickCategoryButton();
        homePage.pressFindMeGift();

    }


@Test
    public void pickPricePoint(){
        //open pricelist dropdown
        clickElement(driver.findElement(By.id("ember776_chosen")));
        //pick price from pricelist dropdown
        clickElement(driver.findElement(By.xpath("//li[@data-option-array-index='4']")));
//        test.log(Status.PASS, "Pick gift card price ");

    }

@Test
    public void pickRegionButton(){
        //open region dropdown
        clickElement(driver.findElement(By.id("ember791_chosen")));
        //pick region from region dropdown
        clickElement(driver.findElement(By.xpath("//li[@data-option-array-index=\"1\"]")));
//        test.log(Status.PASS, "Pick a region ");

    }

@Test
    public void pickCategoryButton(){
        //open category dropdown
        clickElement(driver.findElement(By.id("ember801_chosen")));
        //pick category from category dropdown
        clickElement(driver.findElement(By.xpath("//li[@data-option-array-index=\"4\"]")));
//        test.log(Status.PASS, "Pick category");
    }

@Test
    public void pressFindMeGift(){
        //press on find me a gift button
        clickElement(driver.findElement(By.id("ember836")));
//        test.log(Status.PASS, "Press on find me a gift button");
    }
}
