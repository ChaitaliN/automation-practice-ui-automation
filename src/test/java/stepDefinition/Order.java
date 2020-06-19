package stepDefinition;

import TestContext.TestContext;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import webpage.OrderPage;

import static org.junit.Assert.assertEquals;

public class Order {

    TestContext testContext;
    public Order(TestContext testContext) {
        this.testContext = testContext;
    }

    public Driver driver;
    public OrderPage orderPage;

    @Before()
    public void setup() {
        driver = new Driver();
        testContext.init();
    }

    @After()
    public void teardown() throws Exception {
        driver.quit();
    }

    public void initialize() throws Throwable {
        //driver.start();
        //orderPage = new OrderPage(driver.get());
       // testContext.init();

    }

    @Given("^I am on home page to place a order$")
    public void i_am_on_home_page_to_place_a_order() throws Throwable {
       // this.initialize();
        driver.navigateToHomePage();
        testContext.getOrderPage().homePage();
    }

    @Given("^I add \"([^\"]*)\" to cart$")
    public void i_add_to_cart(String items) throws Throwable {
        testContext.getOrderPage().addItemsToCart(Integer.valueOf(items));
    }

    @Given("^I check if summary has \"([^\"]*)\" items$")
    public void i_check_if_summary_has_items(String items) throws Throwable {
        assertEquals(Integer.valueOf(items), testContext.getOrderPage().validateItemsInSummary());
    }

    @Given("^I verify \"([^\"]*)\" in address details$")
    public void i_verify_in_address_details(String country) throws Throwable {
        assertEquals(country, testContext.getOrderPage().proceedAndVerifyAddress());
    }

    @Given("^I agree terms of service for shipping$")
    public void i_agree_terms_of_service_for_shipping() throws Throwable {
        testContext.getOrderPage().proceedAndVerifyTermsForShipping();
    }

    @When("^I make and verify \"([^\"]*)\" payment$")
    public void i_make_and_verify_payment(String bank) throws Throwable {
        assertEquals(bank, testContext.getOrderPage().makePayment());
    }

//    @When("^I confirm order$")
//    public void i_confirm_order() throws Throwable {
//        orderPage.confirmOrder();
//    }
//
//    @Then("^I see \"([^\"]*)\" for placed order$")
//    public void i_see_for_placed_order(String confirmation) throws Throwable {
//        assertEquals(confirmation, orderPage.verifyOrder());
//    }
}
