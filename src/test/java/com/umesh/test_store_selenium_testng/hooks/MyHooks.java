package com.umesh.test_store_selenium_testng.hooks;

/**
 * BaseTest provides a common setup and teardown framework for test cases.
 * It initializes the WebDriver, performs login, and provides access to page objects and utilities.
 * 
 * @author Umesh Deshmukh
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.umesh.test_store_selenium_testng.context.TestContext;
import com.umesh.test_store_selenium_testng.factory.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.umesh.test_store_selenium_testng.util.Config;

public class MyHooks {

    protected static final Logger log = LoggerFactory.getLogger(MyHooks.class);
    private final TestContext context;
    protected WebDriver driver; // WebDriver instance for browser interactions
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    public MyHooks(TestContext context) {
        this.context = context;
    }
    //askomdch.com


    @Before(order = 0)
    public void setupConfig() {
        Config.initialize(); // Load configuration settings
    }


    @Before(order = 1)
    public void setupDriver() throws MalformedURLException {
        driver = DriverFactory.getDriver(); // Initialize the WebDriver
        context.driver = driver;
    }
     
    @After(order = 0)
    public void quitDriver(Scenario scenario) {
//        if(scenario.isFailed()) {
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String screenshotName = "screenshot_" + System.currentTimeMillis() + ".png";
//            try {
//                Files.copy(screenshot.toPath(), Paths.get("test-output/screenshots", screenshotName));
//                scenario.attach(Files.readAllBytes(screenshot.toPath()), "image/png", screenshotName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        if (driver != null) {
            DriverFactory.quitDriver(); // Quit the WebDriver
        }
    }
}
