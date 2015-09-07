package pages;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static junit.framework.TestCase.assertTrue;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

public class FlipkartGiftPage extends FluentPage {

    private WebDriver driver;


    @Override
    public String getUrl() {
        return "www.flipkart.com";
    }

    @Override
    public void isAt() {
        assertTrue("Not in the title/home page" , driver.getCurrentUrl().contains("buy-gift-voucher"));
    }

    public FlipkartGiftPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;

    }

    public void purchaseGift(String email) {
        fill("input", withId("recipient-email1")).with(email);
        fill("input", withId("confirm-recipient-email1")).with(email);
        driver.findElement(By.className("btn-orange")).click();
    }
}
