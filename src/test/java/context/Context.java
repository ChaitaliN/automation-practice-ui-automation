package context;

import org.openqa.selenium.WebDriver;
import java.util.Properties;

public interface Context {
    public void openBrowser();

    public Properties getProperties();

    public WebDriver getDriver();

    public void quitDriver();
}
