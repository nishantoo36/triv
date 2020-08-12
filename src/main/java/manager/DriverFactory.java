package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    private WebDriver driver;
    private String browser;

    public DriverFactory() {
        browser = FileReaderManager.getInstance().getConfigReader().getBrowserName();
    }

    public WebDriver getDriver() {
        if (driver == null)
            try {
                driver = startDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        return driver;
    }

    private WebDriver startDriver() throws MalformedURLException {
        if ("Chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if ("FireFox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;

    }

    public void closeDriver() {
        driver.quit();
    }

}
