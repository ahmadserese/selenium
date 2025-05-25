package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowserImpl implements Browser {
    @Override
    public WebDriver createBrowser() {
        return  new FirefoxDriver();
    }
}
