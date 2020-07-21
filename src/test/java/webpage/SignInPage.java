package webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage implements Authentication {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    WebElement signinLabel;

    @FindBy(xpath = "//form[@id='login_form']")
    WebElement signinForm;

    @FindBy(xpath = "//input[@id='email']")
    WebElement username;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement signinButton;

    public void click() throws Throwable {
        signinLabel.click();
    }

    public void isFormDisplayed() throws Throwable {
        signinForm.isDisplayed();
    }

    public void enterUsername(String name) throws Throwable {
        username.clear();
        username.sendKeys(name);
    }

    public void enterPassword(String pass) throws Throwable {
        password.clear();
        password.sendKeys(pass);
    }

    public void submit() throws Throwable {
        signinButton.click();
    }

    public String getTitle() throws Throwable {
        return driver.getTitle();
    }

    public void login(String username, String password) throws Throwable {
        this.click();
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();
    }
}
