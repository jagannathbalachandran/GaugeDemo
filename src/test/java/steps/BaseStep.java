package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseStep {
    WebDriver driver;

    public BaseStep(){
        setUpDriver();
    }

    protected void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "/Users/jbalacha/bin/chromedriver");
    }
}
