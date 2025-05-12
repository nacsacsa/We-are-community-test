package weAreCommunity.pageobjects;

import io.cucumber.java.en.And;
import weAreCommunity.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommunitiesPage {

    private final WebDriver webDriver;

    public CommunitiesPage(WebDriverFactory webDriverFactory) {
        this.webDriver = webDriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".evnt-name-wrapper")
    private List<WebElement> communityCardTitles;

    @FindBy(xpath = "//*[@id='e2b6a836-b315-4d74-ba79-7dc98bd70fd1']")
    private WebElement communityCardButtonText;

    @FindBy(className = "evnt-sorting-dropdown")
    private WebElement sortingDropdown;

    @FindBy(className = "evnt-info-cell")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-search-filter .form-control.evnt-search")
    private WebElement searchInput;

    @FindBy(className = "evnt-toggle-filters-button")
    private WebElement moreFiltersButton;

    @FindBy(id = "filter_language")
    private WebElement languageFilter;

    @FindBy(id = "filter_community_participation_format")
    private WebElement formatFilter;

    @FindBy(xpath = "//label[@data-value='Hungarian']")
    private WebElement hungarianLanguage;

    @FindBy(xpath = "//label[@data-value='Online only']")
    private WebElement onlineOnly;

    @FindBy(className = "evnt-clear-filters")
    private WebElement clearAll;

    public WebElement getCard() {
        return cards.get(0);
    }


    public String getCommunityCardButtonText(){
        return communityCardButtonText.getText();
    }

    public void searchForCommunity(String input) {
        searchInput.sendKeys(input);
    }

    public int getResultCount() {
        return cards.size();
    }

    public boolean hasResults() {
        return !cards.isEmpty();
    }
    public List<String> getCommunityCardTitles() {
        return communityCardTitles.stream()
                .map(WebElement::getText)
                .toList();
    }

    public void clickOnShowMore(){moreFiltersButton.click();}

    public void addHungarianAndOnlineOnlyFilters(){
        languageFilter.click();
        hungarianLanguage.click();
        formatFilter.click();
        onlineOnly.click();
    }
    public void clickOnClearAll(){
        clearAll.click();
    }
}