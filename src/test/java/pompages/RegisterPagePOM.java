package pompages;


import base.BasePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPagePOM extends BasePage {
    private static WebDriver driver;


    public void register(){
        RegisterPagePOM registerPage = new RegisterPagePOM();
        registerPage.enterWebsite();
        registerPage.pressLoginAndRegisterButton();

    }



    @Test
    //Enter to buyme website
    public void enterWebsite() {
        driver.get("https://buyme.co.il");
//        test.log(Status.PASS, "Enter to BuyMe website");
    }


    @Test
    //Press for login and registration
    public void pressLoginAndRegisterButton() {
       String getWindow = driver.getWindowHandle();

        //Press on register and login button
        clickElement(driver.findElement(By.className("seperator-link")));

        //Press on to register button for new registration
        clickElement(driver.findElement(By.className("text-btn")));
        clickElement(driver.findElement(By.className("field")));

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
        clickElement(driver.findElement(By.linkText("תנאי השימוש של BUYME")));
        //return to register window
        driver.switchTo().window(getWindow);

        Assert.assertEquals(enterName.getAttribute("value"),privetName);
        Assert.assertEquals(enterEmail.getAttribute("value"),email);
        Assert.assertEquals(enterPassword.getAttribute("value"),password);
        Assert.assertEquals(enterVerificationPassword.getAttribute("value"),verificationPassword);


        //press on register to BUYME button

        clickElement(driver.findElement(By.cssSelector("button[type=submit]")));
//        test.log(Status.PASS, "Enter to register and fill in data");

    }
}
