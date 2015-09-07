package steps;

import com.thoughtworks.gauge.Step;
import pages.AccountDemoHomePage;


public class StepAccountDemo extends BaseStep{

    AccountDemoHomePage demoHomePage;

    public StepAccountDemo() {
        this.driver = MyDriverFactory.getDriver();
    }

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
