package components;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.DriverFactory;
import testBase.ExtentFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import testBase.ExtentReportNG;

public class ListenersImplementation implements ITestListener {
    static ExtentReports report;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        try {
            report = ExtentReportNG.setupExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = ExtentFactory.getInstance().getExtent();
        extentTest.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
        extentTest.log(Status.FAIL, result.getThrowable());

        File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String relativePath = "/Reports/Screenshots/"+actualDate+".jpeg";
        String screenshotPath = System.getProperty("user.dir") + relativePath;
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            extentTest.addScreenCaptureFromPath( relativePath, "Test case failure screenshot");
            ExtentFactory.getInstance().removeExtentObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}
