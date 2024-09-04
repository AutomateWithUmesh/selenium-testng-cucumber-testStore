package com.umesh.test_store_selenium_testng_cucumber.stepDefinitions;

import com.umesh.test_store_selenium_testng_cucumber.context.TestContext;
import com.umesh.test_store_selenium_testng_cucumber.pages.ClothesMenPage;
import com.umesh.test_store_selenium_testng_cucumber.pages.ClothesPage;
import com.umesh.test_store_selenium_testng_cucumber.pages.GlobalMenu;
import com.umesh.test_store_selenium_testng_cucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class MenClothes_Steps {

    protected static final Logger log = LoggerFactory.getLogger(MenClothes_Steps.class);
    //    GlobalMenu globalMenu;
    private final TestContext context;
    private final GlobalMenu globalMenu;
    private final ClothesPage clothesPage;
    private final ClothesMenPage clothesMenPage;

    public MenClothes_Steps(TestContext context) {
        this.context = context;
        clothesPage = PageFactoryManager.getClothesPage(context.driver);
        clothesMenPage = PageFactoryManager.getClothesMenPage(context.driver);
        globalMenu = PageFactoryManager.getGlobalMenu(context.driver);
    }

    @When("the user navigates to Clothes Page")
    public void theUserNavigatesToClothesPage() {
        globalMenu.goToClothesPage();
        Assert.assertTrue(clothesPage.isDisplayed(), "clothes page is not displayed");
    }

    @And("click on Men link")
    public void clickOnMenLink() {
        clothesPage.goToClothesMenPage();

    }

    @Then("mens cloth page should be displayed")
    public void mensClothPageShouldBeDisplayed() {
        Assert.assertTrue(clothesMenPage.isDisplayed(), "men clothes page is not displayed");
    }
}
