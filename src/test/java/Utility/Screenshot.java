package Utility;


import driver.Driver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
    public Driver driver;
    public void takeScreenshot(Scenario scenario){
        driver = new Driver();
        System.out.println(scenario.getName()+"is failed");
        byte[] screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot,"image/png" );
    }
}
