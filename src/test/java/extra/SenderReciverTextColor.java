package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SenderReciverTextColor {

    public static WebDriver driver;


    @BeforeClass
    public static void runOnceBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");


    }

    @Test
    public void test01_chooseGift(){

        //Press find me a gift button
        driver.findElement(By.id("ember836")).click();

        //Press on a gift card
        driver.findElement(By.id("ember1246")).click();

        //Press on to select button
        driver.findElement(By.id("ember1416")).click();

        //Find text "To whom to send" color
        WebElement textElement = driver.findElement(By.cssSelector("div[data-ember-action=\"1438\"]"));
        textElement.getCssValue("color");
        String textColor = textElement.getCssValue("color");
        System.out.println(textColor);


    }

}
