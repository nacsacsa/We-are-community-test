package weAreCommunity.pageobjects;

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

    @FindBy(className = "evnt-sorting-dropdown")
    private WebElement sortingDropdown;

    @FindBy(className = "evnt-info-cell")
    private List<WebElement> cards;

    @FindBy(css = ".evnt-search-filter .form-control.evnt-search")
    private WebElement searchInput;

    public WebElement getCard() {
        return cards.get(0);
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

}
