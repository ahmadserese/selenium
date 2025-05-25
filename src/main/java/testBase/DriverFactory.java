package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final DriverFactory instance = new DriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        return instance;
    }


    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driverParm) {
        driver.set(driverParm);
    }


    public void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }
}