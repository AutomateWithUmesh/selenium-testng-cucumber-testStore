package com.umesh.test_store_selenium_testng.stepDefinitions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.umesh.test_store_selenium_testng.context.TestContext;
import com.umesh.test_store_selenium_testng.pages.GlobalMenu;
import com.umesh.test_store_selenium_testng.pages.HomePage;
import com.umesh.test_store_selenium_testng.pages.LoginPage;
import com.umesh.test_store_selenium_testng.pages.PageFactoryManager;
import com.umesh.test_store_selenium_testng.dataModel.Credentials;
import com.umesh.test_store_selenium_testng.dataModel.TC001_Test_Data;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SearchBox_Steps {

    protected static final Logger log = LoggerFactory.getLogger(SearchBox_Steps.class);
    //    GlobalMenu globalMenu;
    private final TestContext context;
    private TC001_Test_Data tc001_test_data;
    private final GlobalMenu globalMenu;

    public SearchBox_Steps(TestContext context) {
        this.context = context;
        globalMenu = PageFactoryManager.getGlobalMenu(context.driver);
    }

    @When("the user searches for an item with data from {string}")
    public void the_user_searches_for_an_item_with_data_from(String testDataPath) {
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("Step Started: the user searches for an item with data from", ExtentColor.GREY));
        tc001_test_data = JsonUtil.getTestData(testDataPath, TC001_Test_Data.class);
        log.info("Test data loaded");
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("Test data loaded", ExtentColor.GREY));
        globalMenu.searchItem(tc001_test_data.searchText());
    }

    @Then("the search results should be displayed")
    public void the_search_results_should_be_displayed() {
        log.info("the search results should be displayed");
       Assert.assertTrue(false);
    }
}
