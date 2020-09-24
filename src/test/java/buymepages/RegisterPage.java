package buymepages;


import base.BasePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterPage extends BasePage {


    public static WebDriver driver;



    @BeforeClass
    public static void runOnceBeforeClass() {

        //initialize driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
//        driver = Singleton.getDriverInstance();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");
    }

    public void register(){
        RegisterPage registerPage = new RegisterPage();
        registerPage.enterWebsite();
        registerPage.pressLoginAndRegisterButton();

    }


        @Test
        //Enter to buyme website
        public void enterWebsite () {
            driver.get("https://buyme.co.il");
//        test.log(Status.PASS, "Enter to BuyMe website");
        }

        @Test
        //Press for login and registration
        public void pressLoginAndRegisterButton () {
            String getWindow = driver.getWindowHandle();

            //Press on register and login button
            driver.findElement(By.className("seperator-link")).click();


            //Press on to register button for new registration
            driver.findElement(By.className("text-btn")).click();

            driver.findElement(By.className("field")).click();

            //fill privet name in privet name field
            WebElement enterName = driver.findElement(By.id("ember1219"));
            enterName.sendKeys("Galit");

            System.out.println("name " + enterName.getAttribute("value"));

            //fill email address in email field
            WebElement enterEmail = driver.findElement(By.id("ember1221"));
            enterEmail.sendKeys("galitlad1975@gmail.com");
            System.out.println("email" + enterEmail.getAttribute("value"));

            //fill password in password field
            WebElement enterPassword = driver.findElement(By.id("valPass"));
            enterPassword.sendKeys("Galit1975");
            System.out.println(enterPassword.getAttribute("value"));


            //fill verification password in password field
            WebElement enterVerificationPassword = driver.findElement(By.id("ember1225"));
            enterVerificationPassword.sendKeys("Galit1975");
            System.out.println("verification" + enterVerificationPassword.getAttribute("value"));

            // press on I agree to BuyMe conditions button
            driver.findElement(By.linkText("תנאי השימוש של BUYME")).click();
            //return to register window
            driver.switchTo().window(getWindow);

            Assert.assertEquals(enterName.getAttribute("value"), privetName);
            Assert.assertEquals(enterEmail.getAttribute("value"), email);
            Assert.assertEquals(enterPassword.getAttribute("value"), password);
            Assert.assertEquals(enterVerificationPassword.getAttribute("value"), verificationPassword);


            //press on register to BUYME button
            driver.findElement(By.cssSelector("button[type=submit]")).click();
//        test.log(Status.PASS, "Enter to register and fill in data");

        }
    }
