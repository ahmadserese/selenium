package testBase;

import components.PropertiesOperations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    @BeforeMethod
    public void LaunchApplication() throws Exception {
        String browser = PropertiesOperations.getPropertyValueByKey("config","browser");
        String url = 	PropertiesOperations.getPropertyValueByKey("config","url");

        DriverFactory.getInstance().setDriver(BrowserFactory.createBrowserInstance(browser));

        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.getInstance().getDriver().navigate().to(url);

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
    }

}
