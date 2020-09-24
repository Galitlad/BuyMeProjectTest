package buymepages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;





public class BusinessPage extends BasePage {

    private static WebDriver driver;

//    // create ExtentReports and attach reporter(s)
//    private static ExtentReports extent;
//    // creates a toggle for the given test, adds all log events under it
//    private static ExtentTest test;
//
    @BeforeClass
    public static void runOnceBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
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
//    }



    public void chooseBusinessGiftCard(){
        BusinessPage businessPage = new BusinessPage();
        businessPage.assertWebsiteURL();
        businessPage.pickBusinessButton();
    }
@Test
    public void assertWebsiteURL() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://buyme.co.il/";
        System.out.println("actual URL is - " + actualURL + " and expected URL is - " + expectedURL);
        Assert.assertEquals(actualURL,expectedURL);

//        test.log(Status.PASS, "Actual and expected URL are equal ");
    }

@Test
    //Pick buisness and choose price
    public void pickBusinessButton(){
        //Enter to Pick buisness screen
        driver.navigate().to("https://buyme.co.il/search?budget=4&category=8&region=12");
        //Pick a buisness
        clickElement(driver.findElement(By.id("ember944")));
        //Enter price
        WebElement enterPriceField = driver.findElement(By.id("ember1202"));
        enterPriceField.click();
        enterPriceField.sendKeys("200");
        //Press "to select" button
        clickElement(driver.findElement(By.cssSelector("button[type=\"submit\"]")));
//        test.log(Status.PASS, "Choose buisness and enter price ");


    }

}
