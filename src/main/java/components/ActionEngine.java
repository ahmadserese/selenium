package components;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testBase.ExtentFactory;

public class ActionEngine {

    public void enterText(WebElement element, String fieldName, String valueToBeSent) {
        try {
            element.sendKeys(valueToBeSent);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Ented value as: " + valueToBeSent);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Value enter in field: " + fieldName + " is failed due to exception: " + e.getMessage());
        }
    }

    public void clickElement(WebElement element, String fieldName) {
        try {
            element.click();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Clicked Successfully! ");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click on field: " + fieldName + " due to exception: " + e.getMessage());
        }
    }


    public void clearField(WebElement element, String fieldName) {
        try {
            element.clear();
            Thread.sleep(250);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Data Cleared Successfully! ");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to clear Data on field: " + fieldName + " due to exception: " + e.getMessage());

        }
    }


    public boolean isElementPresent(WebElement element, String fieldName) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Presence of field is: " + flag);
            return flag;
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Checking for presence of field: " + fieldName + " not tested due to exception: " + e.getMessage());
            return flag;
        }
    }


    public void selectDropDownByVisibleText(WebElement element, String fieldName, String ddVisibleText) {
        try {
            Select s = new Select(element);
            s.selectByVisibleText(ddVisibleText);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " + fieldName + "  due to exception: " + e.getMessage());
        }
    }

    public void selectDropDownByValue(WebElement element, String fieldName, String ddValue) {
        try {
            Select s = new Select(element);
            s.selectByValue(ddValue);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Dropdown Value Selected by visible text: " + ddValue);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " + fieldName + "  due to exception: " + e.getMessage());
        }
    }

    public String getText(WebElement element, String fieldName) {
        String text = "";
        try {
            text = element.getText();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName + "==> Text retried is: " + text);
            return text;
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName + "==> Text not retried due to exception: " + e.getMessage());

        }
        return text;
    }

}