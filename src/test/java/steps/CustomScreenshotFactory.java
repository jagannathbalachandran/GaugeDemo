package steps;

import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CustomScreenshotFactory implements ICustomScreenshotGrabber {

    // Return a screenshot byte array
    public byte[] takeScreenshot() {
        WebDriver driver = MyDriverFactory.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
