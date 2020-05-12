package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;
import webpage.SignInPage;

import static org.junit.Assert.assertEquals;

public class SignIn {

    public Driver driver;
    public SignInPage signinPage;

    @Before()
    public void setup() {
        driver = new Driver();
    }

    @After()
    public void teardown() throws Exception {
        driver.quit();
    }

    public void initialize() throws Throwable {
        driver.start();
        signinPage = new SignInPage(driver.get());
    }

    @Given("^I am on home page$")
    public void i_am_on_home_page() throws Throwable {
        this.initialize();
        driver.navigateToHomePage();
    }

    @Given("^I click on Signin$")
    public void i_click_on_Signin() throws Throwable {
        signinPage.click();
    }

    @Given("^I see Signin form displayed$")
    public void i_see_Signin_form_displayed() throws Throwable {
        signinPage.isFormDisplayed();
    }

    @When("^I enter username \"([^\"]*)\"$")
    public void i_enter_username(String email) throws Throwable {
        signinPage.enterUsername(email);
    }

    @When("^I enter password \"([^\"]*)\"$")
    public void i_enter_password(String password) throws Throwable {
        signinPage.enterPassword(password);
    }

    @When("^I click on Signin button$")
    public void i_click_on_Signin_button() throws Throwable {
        signinPage.submit();
    }

    @Then("^I should see \"([^\"]*)\" in browser title$")
    public void i_should_see_in_browser_title(String title) throws Throwable {
        assertEquals(title, signinPage.getTitle());
    }
}
