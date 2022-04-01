package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserDetailsPage {
    public WebDriver driver;
    public UserDetailsPage(WebDriver driver){
        this.driver=driver;
    }
    Operations operations = new Operations();
    By userEmail = By.xpath("//*[@id='usrname']");
    By pwd = By.xpath("//*[@id='psw']");
    //By robotCapture = By.xpath("//span[@id='recaptcha-anchor']/div");
     By robotCapture = By.cssSelector(".recaptcha-checkbox-border");
    //
    By loginButton = By.xpath("//*[@id='loginBtn']");

    public void enterDetailsInPayment(String useremail,String password) throws InterruptedException {
        operations.sendInformation(driver,userEmail,useremail);
        operations.sendInformation(driver,pwd,password);
       /* driver.switchTo().frame(6);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
       */ //operations.clickable(driver,robotCapture);
        //operations.csslocatorClick(driver,robotCapture);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     //  operations.clickable(driver,loginButton);

    }
}
