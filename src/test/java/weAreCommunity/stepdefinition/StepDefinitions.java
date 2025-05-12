package weAreCommunity.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import weAreCommunity.factory.WebDriverFactory;
import weAreCommunity.pageobjects.CommunitiesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import weAreCommunity.pageobjects.MainPage;
import weAreCommunity.pageobjects.VideosPage;

import static org.junit.Assert.*;
import static weAreCommunity.helpers.Addresses.MAIN_PAGE;


public class StepDefinitions {

    @Autowired
    CommunitiesPage communitiesPage;

    @Autowired
    MainPage mainPage;

    @Autowired
    VideosPage videoPage;

    @Autowired
    WebDriverFactory webDriverFactory;

    private static final Duration TIMEOUT_SECONDS = Duration.ofSeconds(3);
    private static final Duration POLLING_TIMEOUT_SECONDS = Duration.ofSeconds(1);

    @Given("the user is on the main page")
    public void userIsOnTheCommunitiesPage() {
        webDriverFactory.getDriver().get(MAIN_PAGE);
    }

    @When("The Communities button is clicked")
    public void theCommunitiesButtonIsClicked() {
        mainPage.clickOnCommunitiesButton();
    }

    @When("The {string} is typed in to the Search bar")
    public void userSearchesFor(String searchTerm) throws InterruptedException {
        Thread.sleep(500);
        communitiesPage.searchForCommunity(searchTerm);
    }

    @Then("The search results should contain communities")
    public void systemShouldDisplayCommunitiesRelatedTo() throws InterruptedException {
        Thread.sleep(500);
        WebDriver driver = webDriverFactory.getDriver();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT_SECONDS)
                .pollingEvery(POLLING_TIMEOUT_SECONDS)
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(
                    (ExpectedCondition<Boolean>) driver1 -> !communitiesPage.getCommunityCardTitles().isEmpty());
        } catch (TimeoutException e) {
            Assert.fail("Expected card count did not match actual card count.");
        }
    }

    @When("The Videos button is clicked")
    public void theVideosButtonIsClicked() {
        mainPage.clickOnVideoButton();
    }

    @And("The language is changed to Russian")
    public void theLanguageIsChangedToRussian() {
        mainPage.changeLangToRUS();
    }

    @Then("The page should display the text {string}")
    public void thePageShouldDisplayTheText(String text) throws InterruptedException {
        Thread.sleep(500);
        WebDriver driver = webDriverFactory.getDriver();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT_SECONDS)
                .pollingEvery(POLLING_TIMEOUT_SECONDS)
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(
                    (ExpectedCondition<Boolean>) driver1 -> videoPage.GetTitle().equals("Популярные вещи"));
        } catch (TimeoutException e) {
            Assert.fail("Expected title should be Популярные вещи");
        }
    }
}
