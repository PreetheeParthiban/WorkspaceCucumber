package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Operations {
    public  void clickable(WebDriver driver, By information){
        driver.findElement(information).click();
    }
    public  void csslocatorClick(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public void  sendInformation(WebDriver driver,By sentInfo, String data){
        driver.findElement(sentInfo).sendKeys(data);
    }
}
