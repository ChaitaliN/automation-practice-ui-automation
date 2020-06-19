package webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage extends SignInPage {



    public static WebDriver driver;
    private String email = "peter@gmail.com";
    private String password = "test@123";

    public OrderPage(WebDriver drv) {
        super(drv);
        driver = drv;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id='header_logo']//a")
    WebElement logo;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    WebElement continueShopping;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    WebElement goToSummary;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement goToAddress;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[contains(text(),'United States')]")
    WebElement verifyAddress;

    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement goToShipping;

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement agreeTermsOfService;

    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement goToPayment;

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement bankPayment;

    @FindBy(xpath = "//h3[@class='page-subheading']")
    WebElement verifyBankPayment;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement submitOrder;

    @FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
    WebElement confirmPlacedOrder;

    public void homePage() throws Throwable {
        this.login(email, password);
        logo.click();
    }

    public void addItemsToCart(Integer count) throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (int i = 0; i < count; i++) {

            // Make item visible with js executor
            String jsScript = String
                    .format("document.querySelectorAll('#homefeatured li')[%s].className += ' hovered';", i);
            js.executeScript(jsScript);

            // Get path for item
            String itemPath = String.format("//ul[@id='homefeatured']//li[%s]//div[1]//div[2]//div[2]//a[1]", i + 1);
            WebElement item = driver.findElement(By.xpath(itemPath));

            // Wait till item is visible
            wait.until(ExpectedConditions.visibilityOf(item));
            wait.until(ExpectedConditions.elementToBeClickable(item));

            // Click on item
            item.click();

            // If it's last item proceed to checkout
            // or continue shopping
            if (i == count - 1) {
                goToSummary.click();
            } else {
                continueShopping.click();
            }
        }
    }

    public Integer validateItemsInSummary() throws Throwable {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='cart_summary']//tbody//tr"));
        return rows.size();
    }

    public String proceedAndVerifyAddress() throws Throwable {
        goToAddress.click();
        return verifyAddress.getText();
    }

    public void proceedAndVerifyTermsForShipping() throws Throwable {
        goToShipping.click();
        agreeTermsOfService.click();
    }

    public String makePayment() throws Throwable {
        goToPayment.click();
        bankPayment.click();
        return verifyBankPayment.getText();
    }

    public void confirmOrder() throws Throwable {
        submitOrder.click();
    }

    public String verifyOrder() throws Throwable {
        return confirmPlacedOrder.getText();
    }
}
