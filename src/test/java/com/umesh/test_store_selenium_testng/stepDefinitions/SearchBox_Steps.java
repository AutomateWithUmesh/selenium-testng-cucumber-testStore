package com.umesh.test_store_selenium_testng.stepDefinitions;

import com.umesh.test_store_selenium_testng.context.TestContext;
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

    public SearchBox_Steps(TestContext context) {
        this.context = context;
    }

    @When("the user searches for an item with data from {string}")
    public void the_user_searches_for_an_item_with_data_from(String testDataPath) {
        tc001_test_data = JsonUtil.getTestData(testDataPath, TC001_Test_Data.class);
        log.info("Test data loaded");
//        globalMenu.searchItem(tc001_test_data.searchText());
    }

    @Then("the search results should be displayed")
    public void the_search_results_should_be_displayed() {
        log.info("Test data loaded");
       Assert.assertTrue(false);
    }
}
