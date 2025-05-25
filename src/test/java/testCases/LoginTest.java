package testCases;

import org.testng.annotations.Test;
import pageObject.LoginPage;
import testBase.TestBase;

public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void validLogin() {
        loginPage.login("standard_user", "secret_sauce");
        loginPage.validateLogin();

    }

    @Test
    public void invalidPassword() {
        loginPage.login("standard_user", "invalid_password");
    }

    @Test
    public void invalidUserName() {
        loginPage.login("invalid_user", "secret_sauce");
    }

    @Test
    public void loginWithoutPassword() {
        loginPage.enterUserName("standard_user");
        loginPage.clickLoginButton();
    }

    @Test
    public void textContainPassword() {
        loginPage.login("standard_user", "secret_sauce_invalid_password");
    }

    @Test
    public void partialPassword() {
        loginPage.login("standard_user", "secret");
    }

}
