package stepDefinitionParallel;

import context.ContextManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpage.OrderPage;

import static org.junit.Assert.assertEquals;

public class Order {

    public ContextManager context;
    public OrderPage orderPage;

    public Order(ContextManager context) {
        this.context = context;
    }

    @After()
    public void teardown() throws Exception {
        context.quitDriver();
    }

    public void initialize() throws Throwable {
        orderPage = new OrderPage(context.getDriver());
    }

    @Given("^I am on home page to place a order$")
    public void i_am_on_home_page_to_place_a_order() throws Throwable {
        this.initialize();
        orderPage.homePage();
    }

    @Given("^I add \"([^\"]*)\" to cart$")
    public void i_add_to_cart(String items) throws Throwable {
        orderPage.addItemsToCart(Integer.valueOf(items));
    }

    @Given("^I check if summary has \"([^\"]*)\" items$")
    public void i_check_if_summary_has_items(String items) throws Throwable {
        assertEquals(Integer.valueOf(items), orderPage.validateItemsInSummary());
    }

    @Given("^I verify \"([^\"]*)\" in address details$")
    public void i_verify_in_address_details(String country) throws Throwable {
        assertEquals(country, orderPage.proceedAndVerifyAddress());
    }

    @Given("^I agree terms of service for shipping$")
    public void i_agree_terms_of_service_for_shipping() throws Throwable {
        orderPage.proceedAndVerifyTermsForShipping();
    }

    @When("^I make and verify \"([^\"]*)\" payment$")
    public void i_make_and_verify_payment(String bank) throws Throwable {
        assertEquals(bank, orderPage.makePayment());
    }

    @When("^I confirm order$")
    public void i_confirm_order() throws Throwable {
        orderPage.confirmOrder();
    }

    @Then("^I see \"([^\"]*)\" for placed order$")
    public void i_see_for_placed_order(String confirmation) throws Throwable {
        assertEquals(confirmation, orderPage.verifyOrder());
    }
}
