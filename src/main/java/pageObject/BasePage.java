package pageObject;

import components.ActionEngine;
import components.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.DriverFactory;

public class BasePage {
    ActionEngine actionEngine;
    Assertions assertions;

    By productsListTitle = By.cssSelector("[data-test='title']");

    public BasePage() {
        actionEngine = new ActionEngine();
        assertions = new Assertions();
    }

}
