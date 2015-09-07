package pages;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withName;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

public class AccountDemoHomePage extends FluentPage {
    private WebDriver webDriver;

    public AccountDemoHomePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public void goToHomePage() {
        webDriver.navigate().to("http://accountsdemo.herokuapp.com");
    }


    public void login(String username, String password) {
        fill("#user_email").with(username);
        fill("#user_password").with(password);
        find("input", withName("commit")).click();
    }

    public void updateClient(String client)  {
        Gauge.writeMessage("Updating " + client + " with details");
        find(".navbar-fixed-top").find("a", withText("Clients")).click();
        fill("input", withId("Search")).with(client);
        find(".searchBtn").click();
    }
 }
