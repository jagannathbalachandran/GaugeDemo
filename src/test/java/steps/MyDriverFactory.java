package steps;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriverFactory {
    private static final String CHROME = "chrome";

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @BeforeSuite
    public void Setup() {
        String browser = System.getenv("browser.name");
        if (browser.toLowerCase().equals(CHROME)) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @AfterSuite
    public void TearDown() {
        Gauge.writeMessage("Browser closing");
        driver.close();
    }
}
