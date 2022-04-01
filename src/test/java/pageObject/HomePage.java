package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
        public WebDriver driver;
        public HomePage(WebDriver driver){
                this.driver=driver;
        }
Operations operations = new Operations();

            By operato = By.xpath("//input[@name='operator' and @data-qa='celular-operator' ]");
            By operatorSelection = By.xpath("//*[@data-name='telcel']");
            By mobile = By.name("mobile");
            By montoRecharge = By.xpath("//*[@name='amount' and@data-qa='celular-amount']");
            By amountDetails = By.cssSelector(".cat1 > .category-suggest:nth-child(1) > a");
            By submit = By.xpath("//*[@data-qa='celular-pay']");
public void enterOperatorDetails(){
   operations.clickable(driver,operato);
   operations.clickable(driver,operatorSelection);

}
public void enterMobileNumber(String mobileNumber){
    operations.sendInformation(driver,mobile,mobileNumber);

}
    public void enterAmount(){
    operations.clickable(driver,montoRecharge);
    operations.csslocatorClick(driver,amountDetails);

    }

    public void submit(){
  operations.clickable(driver,submit);

    }


}
