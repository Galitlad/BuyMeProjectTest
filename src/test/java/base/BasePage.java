package base;

import buymepages.Singleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BasePage {



    public static final String privetName = "Galit";
    public static final String email = "galitlad1975@gmail.com";
    public static final String password = "Galit1975";
    public static final String verificationPassword = "Galit1975";




public static WebDriver driver;





    public static void reporter() throws IOException {

        //initialize driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\galit\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://buyme.co.il");


    }

    private WebElement getWebElement(By locator){
        return Singleton.getDriverInstance().findElement(locator);
    }

    public void clickElement(By locator){
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text){
        getWebElement(locator).sendKeys(text);
    }


    //Method to click on any element
    public void clickElement(WebElement element){
        element.click();
    }

}
