package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertErrorMessages {

    public static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");
    }

    @Test
    public static void test01_asserterrormessage(){


        //Press on register and login button
        WebElement toRegisterButton = driver.findElement(By.className("seperator-link"));
        toRegisterButton.click();

        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();


        WebElement mailMessage = driver.findElement(By.xpath("//ul[@id='parsley-id-12']"));
        mailMessage.isDisplayed();
        System.out.println(mailMessage.getText());

        WebElement passwordMessage = driver.findElement(By.xpath("//ul[@id=\'parsley-id-14\']"));
        passwordMessage.isDisplayed();
        System.out.println(passwordMessage.getText());

        Assert.assertEquals(mailMessage.getText(),passwordMessage.getText());

    }
}
