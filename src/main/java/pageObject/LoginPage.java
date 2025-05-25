package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.DriverFactory;

import java.time.Duration;

public class LoginPage extends BasePage {
    By userNameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    public void enterUserName(String userName) {
        actionEngine.enterText(DriverFactory.getInstance().getDriver().findElement(userNameField), "Username", userName);
    }

    public void enterPassword(String password){
        actionEngine.enterText(DriverFactory.getInstance().getDriver().findElement(passwordField), "Password", password);
    }

    public void clickLoginButton() {
        actionEngine.clickElement(DriverFactory.getInstance().getDriver().findElement(loginButton), "Login Button");
    }

    public void login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }


    public void validateLogin() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsListTitle));
        actionEngine.isElementPresent(DriverFactory.getInstance().getDriver().findElement(productsListTitle), "Products List Title");
    }
}
