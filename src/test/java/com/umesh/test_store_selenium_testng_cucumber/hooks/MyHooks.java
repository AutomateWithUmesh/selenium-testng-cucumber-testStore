package com.umesh.test_store_selenium_testng_cucumber.hooks;

/**
 * BaseTest provides a common setup and teardown framework for test cases.
 * It initializes the WebDriver, performs login, and provides access to page objects and utilities.
 * 
 * @author Umesh Deshmukh
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.umesh.test_store_selenium_testng_cucumber.context.TestContext;
import com.umesh.test_store_selenium_testng_cucumber.factory.DriverFactory;

import java.io.File;
import java.net.MalformedURLException;

import com.umesh.test_store_selenium_testng_cucumber.stepDefinitions.Common_Steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.umesh.test_store_selenium_testng_cucumber.util.Config;

public class MyHooks {

    protected static final Logger log = LoggerFactory.getLogger(MyHooks.class);
    private final TestContext context;
    protected WebDriver driver; // WebDriver instance for browser interactions
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private Common_Steps common_steps;

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
        //common_steps = new Common_Steps(this.context);
    }

    @After(order = 1)
    public void quitDriver(Scenario scenario) {
        if(scenario.isFailed())
        {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
        }
        if (driver != null) {
            DriverFactory.quitDriver(); // Quit the WebDriver
        }
    }

    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
