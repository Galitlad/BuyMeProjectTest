package pompages;


import base.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SenderReceiverPagePOM extends BasePage {
    private static WebDriver driver;

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;


    @BeforeClass
    public static void runOnceBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\galit\\Desktop\\extent.html");
// attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
// name your test and add description
        test = extent.createTest("BuyMeTest", "BuyMe report");

        //Pick buisness and choose price befor moving to the next screen "for whom to send"
        //Enter to Pick buisness screen
        driver.navigate().to("https://buyme.co.il/search?budget=4&category=8&region=12");
        //Pick a buisness
        driver.findElement(By.id("ember906")).click();
        //Enter price
        WebElement enterPriceField = driver.findElement(By.id("ember1162"));
        enterPriceField.click();
        enterPriceField.sendKeys("200");
        //Press to select button
        driver.findElement(By.cssSelector("button[type=submit]")).click();
    }


    @Test
    public void test09_pressRadioButtonToSomeoneElse() {
        //Press radio button "to someone else"
        clickElement(driver.findElement(By.cssSelector("label[data=forSomeone")));
        test.log(Status.PASS, "Press radio button to someone else");
    }

    @Test
    public void test10_enterDataForWhomToSend() {
        //Enter Reciver Name
        WebElement reciverName = driver.findElement(By.id("ember1291"));
        reciverName.click();
        reciverName.sendKeys("אדר לדני");

        // Enter sender name
        WebElement senderName = driver.findElement(By.id("ember1293"));
        senderName.click();
        senderName.sendKeys("גלית לדני");

        //Pick an event
        WebElement clickOnEventButton = driver.findElement(By.id("ember1294"));
        clickOnEventButton.click();
        List<WebElement> eventList = driver.findElements(By.cssSelector("li[data-option-array-index"));
        if (eventList.size() > 0) {
            for (WebElement chooseEvent : eventList) {
                if (chooseEvent.getText().equals("יום הולדת")) {
                    chooseEvent.click();
                    break;
                }

            }
        }



        //Enter a blessing
        WebElement enterBlessing = driver.findElement(By.cssSelector("textarea[rows=\"4\"]"));
        enterBlessing.click();
        enterBlessing.clear();
        enterBlessing.sendKeys("מזל טוב חמודי, בהצלחה בלימודים, ושיהיו מסביבך רק אנשים טובים, אוהבת אותך מאד ");
        test.log(Status.PASS, "Enter data for whom to send the gift card");
    }

    @Test
    public void test11_upLoadPicture() {
        //Up load a picture
        WebElement upLoadPicture = driver.findElement(By.id("ember1324"));
        upLoadPicture.sendKeys("C:\\Users\\galit\\Desktop\\new file\\picture.jpg");
        test.log(Status.PASS, "Upload picture");
    }

    @Test
    public void test12_pressRadioButton() {
        //Press radio button "after payment"
        clickElement(driver.findElement(By.className("send-now")));
        test.log(Status.PASS, "Press radio button after payment");
    }

    @Test
    public void test13_pickEmail() {
        //Pick Email/sms
        clickElement(driver.findElement(By.cssSelector("button[data-ember-action=\"1233\"]")));
        //Enter email address
        driver.findElement(By.cssSelector("input[type=email]")).sendKeys("Adar@gmail.com");
        //Press save
        clickElement(driver.findElement(By.cssSelector("button[type=submit]")));
        test.log(Status.PASS, "Enter an email address");
    }

    @Test
    public void test14_assertReciverName() {
        String ReciverName = "אדר לדני";

        WebElement reciverName = driver.findElement(By.id("ember1291"));
        reciverName.click();
        reciverName.sendKeys("אדר לדני");
        Assert.assertEquals(ReciverName,reciverName.getAttribute("value") );
        test.log(Status.PASS, "Assert reciver name");

    }

    @Test
    public void test15_assertSenderName() {
        String SenderName = "גלית לדני";

        WebElement senderName = driver.findElement(By.id("ember1293"));
        senderName.click();
        senderName.sendKeys("גלית לדני");
        Assert.assertEquals(SenderName, senderName.getAttribute("value"));
        test.log(Status.PASS, "Assert sender name");


    }
}













