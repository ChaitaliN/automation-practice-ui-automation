package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {



    final private String propFileName = "test.config.properties";
    private String chromeBrowser = "chrome";
    private Properties prop;
    public static WebDriver driver;
    protected static WebDriverWait wait;

    public Driver() {

        try {
            loadProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void start() {
       if (this.prop.getProperty("browser").toLowerCase().equals(chromeBrowser)) {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        } else {
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
        }
    }

    public void navigateToHomePage() {
        driver.manage().window().maximize();
        driver.get(this.prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void quit() {
        driver.quit();
    }

    public WebDriver get() {
        return driver;
    }

    public Properties getProperties() {
        return this.prop;
    }

    private void loadProperties() throws Exception {

        this.prop = new Properties();
        InputStream inputStream;

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                this.prop.load(inputStream);
                inputStream.close();
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
