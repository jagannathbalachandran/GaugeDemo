package steps;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FlipkartHomePage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StepFlipkart extends BaseStep{

    FlipkartHomePage homePage;


    public StepFlipkart() {
        this.driver = MyDriverFactory.getDriver();
    }

    @Step("login to flipkart website")
    public void login() {
        homePage = new FlipkartHomePage(driver);
        homePage.goToHomePage();
    }


    @Step("search for <product>")
    public void searchFor(String productType) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Boolean myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("overlay"))));
        driver.findElement(By.name("q")).sendKeys(productType);
        driver.findElement(By.className("search-bar-submit")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("select <product> and add to cart")
    public void selectProductAndAddToCart(String product) {
        List<WebElement> elements = driver.findElements(By.tagName("img"));
        System.out.println("No of elements is " + elements.size());
//        try {
        for (Iterator<WebElement> iterator = elements.iterator(); iterator.hasNext(); ) {
            WebElement webElement = iterator.next();
            if (webElement.getAttribute("alt").contains(product)) {
                webElement.click();
                break;
            }
        }
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("btn-buy-now")));
        driver.findElement(By.className("btn-buy-now")).click();
    }

    @Step("check cart contains <Table>")
    public void checkCartContains(Table products) throws InterruptedException {
        Boolean myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("loader-overlay"))));
        driver.findElement(By.className("cart-label")).click();
        Thread.sleep(2000);
        List<WebElement> productsInCart = driver.findElements(By.className("title"));
        int rows = products.getRows().size();
        System.out.println();


    }

    @Step("add products to cart <table>")
    public void addProductsToCart(Table table) {
        List<List<String>> rows = table.getRows();
        for (Iterator<List<String>> iterator = rows.iterator(); iterator.hasNext(); ) {
            List<String> row = iterator.next();
            searchFor(row.get(0));
            selectProductAndAddToCart(row.get(1));
        }


    }

    @Step("place the order")
    public void placeTheOrder() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.className("cart-label")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("place-order-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("jagannathbalachandran@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.className("btn-large")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("mobile")).sendKeys("9880610823");
        Thread.sleep(3000);
        driver.findElement(By.className("btn-large")).click();
    }


    @Step("buy a gift")
    public void buyAGift() {
        homePage.navigateToGiftPage("jagannathbalachandran@gmail.com");

    }
}