package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;



public class LoadingScreenDotSize {

    public static WebDriver driver;


    @BeforeClass
    public static void runOnceBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");
    }

    @Test
    //Print the size of one of the loading dots:
    public static void test02_printDotSize() {

        driver.get("https://buyme.co.il");

        WebElement spinner = driver.findElement(By.className("bounce1"));
        System.out.println("The spinner's height is : " + spinner.getRect().getHeight() + " and width is : " + spinner.getRect().getWidth());
    }
}



