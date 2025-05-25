package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static WebDriver createBrowserInstance(String driverName) {
        Browser browserInstance = switch (driverName) {
            case "chrome" -> new ChromeBrowserImpl();
            case "firefox" -> new FireFoxBrowserImpl();
            default -> throw new IllegalArgumentException(String.format("Unsupported browser: %s ", driverName));
        };
        return browserInstance.createBrowser();
    }
}
