package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
    private ExtentFactory() {

    }

    private static final ExtentFactory instance  = new ExtentFactory();

    public static ExtentFactory getInstance() {
        return instance;
    }

    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent() {
        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    public void removeExtentObject() {
        extent.remove();
    }
}