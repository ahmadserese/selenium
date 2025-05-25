package components;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import testBase.ExtentFactory;

public class Assertions {
    public void assertEqualsString(String expValue, String actualValue, String locatorName) {
        try {
            if (actualValue.equals(expValue)) {
                ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field " + locatorName + " Expected value was: " + expValue + " actual value is: " + actualValue);
            } else {
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field " + locatorName + " Expected value was: " + expValue + " actual value is: " + actualValue);
                Assert.fail("String Assertion FAILED on field " + locatorName + " Expected value was: " + expValue + " actual value is: " + actualValue);
            }
        } catch (Exception e) {
            Assert.fail("String Assertion FAILED on field " + locatorName + " Expected value was: " + expValue + " actual value is: " + actualValue + " due to exception: " + e.getMessage());
        }
    }
}
