package com.au.covidgame.utils;

import com.au.covidgame.test.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {
    public void onFinish(ITestContext result) {
    }

    public void onStart(ITestContext result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        try {

            test.log(Status.FAIL, "Failed Case is: " + result.getName());
            test.addScreenCaptureFromPath(TestUtilities.takeScreenShot(result.getName(),driver));
            test.log(Status.FAIL, result.getName()+" FAIL with error " + result.getThrowable());

        } catch (IOException e) {
            e.printStackTrace();
        }

        report.flush();

    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        try {
            test.log(Status.PASS, "Passed Case is: " + result.getName());
            test.addScreenCaptureFromPath(TestUtilities.takeScreenShot(result.getName(),driver));

        } catch (IOException e) {
            e.printStackTrace();
        }

        report.flush();

    }

}