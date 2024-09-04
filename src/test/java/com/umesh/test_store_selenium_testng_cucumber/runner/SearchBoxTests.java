package com.umesh.test_store_selenium_testng_cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        features = { "src/test/resources/features/SearchBox.feature" },
        features = { "classpath:features/SearchBox.feature" },
        glue = {"com.umesh.test_store_selenium_testng_cucumber"},
        plugin = {
                "pretty",
                "html:target/cucumber/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class SearchBoxTests extends AbstractTestNGCucumberTests {
}