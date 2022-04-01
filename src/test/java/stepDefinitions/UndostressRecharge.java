package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.HomePage;
import pageObject.PaymentPage;
import pageObject.UserDetailsPage;

import java.util.concurrent.TimeUnit;

public class UndostressRecharge {
    WebDriver driver;
    HomePage homePage;
    PaymentPage paymentPage;
    UserDetailsPage userDetailsPage;

    @Given("I launch {string}")
    public void iLaunch(String browser) {
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/test/resources/Drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @When("I open {string}")
    public void i_open(String url) {
        driver.get(url);
    }
    @Then("I select operator as Telcel from Operador field")
    public void iSelectOperatorAsTelcelFromOperadorField() {
        homePage = new HomePage(driver);
        homePage.enterOperatorDetails();


    }
    @Then("Enter {string} under Numero de celular")
    public void enter_under_numero_de_celular(String mobileNumber) {
        homePage.enterMobileNumber(mobileNumber);

    }

    @Then("Select recharge under Monto de Recarga")
    public void selectRechargeUnderMontoDeRecarga() {
        homePage.enterAmount();
    }
    @Then("Click on siguiente")
    public void click_on_siguiente() {
        homePage.submit();
    }
    @Then("Verify if payment screen is reached")
    public void verify_if_payment_screen_is_reached() {
        // Assert.assertArrayEquals();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        String title= driver.getTitle();
        System.out.println(title);
        //UnDosTres - Recargas en l�nea Telcel, Movistar, AT&T, Unefon, Virgin, Bait, TeleV�a, PASE, Boletos de Cine, Pagos CFE
        //String nxtPge="undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, TeleVía, PASE Urbano, IAVE, Viapass";
        String nxtPge ="undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, TeleVía, PASE Urbano, IAVE, Viapass";
        if(nxtPge.equalsIgnoreCase(title)){
            System.out.println("Valid page");
            //undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, TeleVía, PASE Urbano, IAVE, Viapass
        }
//Assert.assertEquals("",nxtPge,title);

    }
    @Then("Select Tarjeta payment method")
    public void selectTarjetaPaymentMethod() {
        paymentPage=new PaymentPage(driver);
        paymentPage.selectPaymentMethod();
    }

    @And("Select Usar nueva tarjeta payment option")
    public void selectUsarNuevaTarjetaPaymentOption() {
        paymentPage.selectPaymentOption();
    }

    @Then("Enter the {string}")
    public void enter_the(String cardNumber) {
        paymentPage.enterCardNumber(cardNumber);

    }
    @Then("Enter {string}, {string},{string}")
    public void enter(String month, String date, String cvv) {
        paymentPage.enterCardDetails(month,date,cvv);

    }
    @Then("Enter {string} under correo electronico")
    public void enter_under_correo_electronico(String email) {
        paymentPage.enterEmail(email);

    }
    @Then("Click on Pagar con Tarjeta")
    public void click_on_pagar_con_tarjeta() {
        paymentPage.submitPayButton();

    }

    @Then("Enter the {string} and {string}")
    public void enter_the_and(String useremail, String password) throws InterruptedException {
        userDetailsPage = new UserDetailsPage(driver);
        //new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
        userDetailsPage.enterDetailsInPayment(useremail,password);

    }
    @Then("Verify if user gets success message and recharge is successful")
    public void verify_if_user_gets_success_message_and_recharge_is_successful() {
        String text = driver.findElement(By.xpath("//*[@class='visual-message']")).getText();
        if(text.equalsIgnoreCase("Success")){
            System.out.println("data validation Success");
        }
        else{
            System.out.println("data not reach final page");
        }
        System.out.println("#########"+text);

    }


    @And("Close the browser")
    public void closeTheBrowser() {
        driver.close();
    }



}
