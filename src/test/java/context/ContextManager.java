package context;

import org.openqa.selenium.WebDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ContextManager implements Context {

    final private String propFileName = "test.config.properties";
    private WebDriver driver;
    private Properties prop;

    public ContextManager() {
        // Load config from properties file
        try {
            prop = new ConfigManager().load(propFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get web driver for given broser
        driver = new BrowserDriver().get(this.prop.getProperty("browser"));
    }

    public void openBrowser() {
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public Properties getProperties() {
        return prop;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
