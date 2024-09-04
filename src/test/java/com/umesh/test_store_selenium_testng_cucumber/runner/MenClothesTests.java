//package com.umesh.test_store_selenium_testng_cucumber.runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//
//@CucumberOptions(
//        features = "src/test/resources/features",
//        glue = {"com.umesh.test_store_selenium_testng_cucumber"},
//        plugin = {
//                "pretty",
//                "html:target/cucumber/cucumber-report.html",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//        },
//        monochrome = true
//)
//public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//
//    @BeforeClass
//    public void setup() {
//        // Get browser from System property
//        String browser = System.getProperty("browser", "chrome");
//        // Set up WebDriver based on the browser
//        System.out.println("Running tests on browser: " + browser);
//        // You can initialize the WebDriver here based on the browser value
//    }
//}
package com.umesh.test_store_selenium_testng_cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        features = { "src/test/resources/features/MenClothes.feature" },
        features = { "classpath:features/MenClothes.feature" },
        glue = {"com.umesh.test_store_selenium_testng_cucumber"},
        plugin = {
                "pretty",
                "html:target/cucumber/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class MenClothesTests extends AbstractTestNGCucumberTests {
}
