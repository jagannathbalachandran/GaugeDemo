package pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

public class FlipkartHomePage extends FluentPage {

    private WebDriver webDriver;
    FlipkartGiftPage giftPage;

    @Override
    public String getUrl() {
        return "www.flipkart.com";
    }

    @Override
    public void isAt() {
        assertTrue("Not in the title/home page" , webDriver.getTitle().equals("steps.StepFlipkart"));
    }

    public FlipkartHomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;

    }

    public void goToHomePage() {
        webDriver.navigate().to("http://www.flipkart.com");
    }

    public void navigateToGiftPage(String email) {
        find("div" , withId("fk-mainhead-id")).find("span", withText("Gift Card")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        giftPage = new FlipkartGiftPage(webDriver);
        giftPage.purchaseGift(email);
    }
}
