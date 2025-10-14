package com.example.orangehrm.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.example.orangehrm.utils.DriverSingleton;
import com.example.orangehrm.utils.ExtentManager;
import com.example.orangehrm.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest testLogger;

    @BeforeMethod
    @Parameters({"headless"})
    public void setUp(Method method, @Optional("true") String headless) {
        boolean headlessMode = "true".equalsIgnoreCase(headless);
        driver = DriverSingleton.getDriver(headlessMode);
        testLogger = extent.createTest(method.getDeclaringClass().getSimpleName() + " - " + method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
                testLogger.fail(result.getThrowable());
                if (path != null) testLogger.addScreenCaptureFromPath(path);
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                testLogger.pass("Test passed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                testLogger.skip("Test skipped: " + result.getThrowable());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DriverSingleton.quitDriver();
            extent.flush();
        }
    }
}
