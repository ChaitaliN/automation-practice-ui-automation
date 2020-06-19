package TestContext;

import driver.Driver;
import webpage.OrderPage;

public class TestContext {

    OrderPage orderPage;
    public Driver driver;

  public void init(){
      driver = new Driver();
      driver.start();
      orderPage = new OrderPage(driver.get());
  }

    public OrderPage getOrderPage() {
        return orderPage;
    }
}
