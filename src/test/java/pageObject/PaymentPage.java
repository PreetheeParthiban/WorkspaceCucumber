package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    public WebDriver driver;
    public PaymentPage(WebDriver driver){
        this.driver=driver;
    }
    Operations operations = new Operations();

    By payTarjeta = By.xpath("//*[@id='new-card-toggle']/div/p[contains(text(),'Tarjeta')]");
    By payNueva = By.xpath("//*[contains(text(),'Usar nueva tarjeta')]");
    By cardNum = By.xpath("//*[@data-qa='numero-de-tarjeta-input']");
    By expMonth = By.xpath("//*[@data-qa='mes-input']");
    By expDate = By.xpath("//*[@data-qa='expyear-input']");
    By cvv = By.xpath("//*[@data-qa='cvv-input']");
    By emailID = By.xpath("//*[@name='txtEmail']");
    By payButton = By.xpath("//*[@id='paylimit']");

    public void selectPaymentMethod(){
        operations.clickable(driver,payTarjeta);

    }
    public void selectPaymentOption(){
        /*Actions action = new Actions(driver);
        WebElement element=driver.findElement(payNueva);
        action.doubleClick(element).click().build().perform();
        */
// This radio button click dosen't click always
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(payNueva)).click();
        operations.clickable(driver,payNueva);
        //operations.clickable(driver,payNueva);
    }
    public void enterCardNumber(String cardNumber ){
        operations.sendInformation(driver,cardNum,cardNumber);

    }
    public void enterCardDetails(String month,String date,String cvvnum){
    operations.sendInformation(driver,expMonth,month);
    operations.sendInformation(driver,expDate,date);
    operations.sendInformation(driver,cvv,cvvnum);

}
    public void enterEmail(String email){
    operations.sendInformation(driver,emailID,email);
}

    public void submitPayButton(){
        operations.clickable(driver,payButton);
}

}
