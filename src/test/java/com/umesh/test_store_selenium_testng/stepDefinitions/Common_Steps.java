package com.umesh.test_store_selenium_testng.stepDefinitions;

import com.umesh.test_store_selenium_testng.context.TestContext;
import com.umesh.test_store_selenium_testng.dataModel.Credentials;
import com.umesh.test_store_selenium_testng.pages.GlobalHeader;
import com.umesh.test_store_selenium_testng.pages.HomePage;
import com.umesh.test_store_selenium_testng.pages.LoginPage;
import com.umesh.test_store_selenium_testng.pages.PageFactoryManager;
import com.umesh.test_store_selenium_testng.util.Config;
import com.umesh.test_store_selenium_testng.util.Constants;
import com.umesh.test_store_selenium_testng.util.JsonUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.SkipException;

public class Common_Steps {

    protected static final Logger log = LoggerFactory.getLogger(SearchBox_Steps.class);
    //    GlobalMenu globalMenu;
    private final TestContext context;
    private final LoginPage loginPage;
    private final HomePage homePage;
    //private final GlobalMenu globalMenu;
    private final Credentials credentials;
    private final GlobalHeader globalHeader;
    private  boolean isLoginSuccessful = false; // Flag to track if login was successful

    public Common_Steps(TestContext context) {
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
        homePage = PageFactoryManager.getHomePage(context.driver);
        credentials = JsonUtil.getTestData(Config.get(Constants.CREDENTIALS_FILE_PATH), Credentials.class);
        globalHeader = PageFactoryManager.getGlobalHeader(context.driver);
    }

    @Given("the user is on Test Store Home Page")
    public void the_user_is_on_test_store_home_page() {
        loginPage.goTo(Config.get(Constants.TEST_STORE_URL));
        Assert.assertTrue(loginPage.isDisplayed());
        loginPage.login(credentials.email(),credentials.password());
        log.info("Login successful");
        // Assert that the global menu is displayed
        Assert.assertTrue(homePage.getGlobalMenu().isDisplayed());
        isLoginSuccessful = true;
    }

    @Then("the user logs out of the system")
    public void theUserLogsOutOfTheSystem() {
                if (isLoginSuccessful) {
            log.info("Running the sign out");
            globalHeader.signout(); // Perform sign out
            Assert.assertTrue(loginPage.isDisplayed()); // Verify login page is displayed after sign out
            log.info("Sign out completed");
            context.driver.manage().deleteAllCookies(); // Clear cookies
            log.info("Cookies deleted");
        } else {
            log.info("Skipping the sign out as login failed");
            throw new SkipException("Skipping the sign out as login failed"); // Skip sign out if login failed
        }
    }


}
