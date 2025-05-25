package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserImpl implements Browser {
    @Override
    public WebDriver createBrowser() {
        return  new ChromeDriver();
    }
}
