// package stepDefinition;
//
// import TestContext.TestContext;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import webpage.OrderPage;
//
// import static org.junit.Assert.assertEquals;
//
// public class OrderstepDef {
// TestContext testContext;
// OrderPage orderPage;
//
// public OrderstepDef(TestContext testContext) {
// this.testContext = testContext;
// }
//
// @When("^I confirm order$")
// public void i_confirm_order() throws Throwable {
// testContext.getOrderPage().confirmOrder();
// }
//
// @Then("^I see \"([^\"]*)\" for placed order$")
// public void i_see_for_placed_order(String confirmation) throws Throwable {
// assertEquals(confirmation, testContext.getOrderPage().verifyOrder());
// }
// }
