package steps;

import com.thoughtworks.gauge.Step;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AccountDemoHomePage;
import pages.FlipkartHomePage;

import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;


public class StepAccountDemo extends BaseStep{

    AccountDemoHomePage demoHomePage;

    @Step("login to account demo app")
    public void loginToAccountDemo() {
         demoHomePage = new AccountDemoHomePage(driver);
        demoHomePage.goToHomePage();
        demoHomePage.login("jagannathbalachandran@gmail.com" , "password");
    }

    @Step("update <client> with details")
    public void updateClient(String client) {
        demoHomePage.updateClient(client);
    }


}
