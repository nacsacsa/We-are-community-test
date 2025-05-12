package weAreCommunity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import weAreCommunity.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    private final WebDriver webDriver;

    public MainPage(WebDriverFactory webDriverFactory) {
        this.webDriver = webDriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(className = "communities-icon")
    private WebElement communitiesButton;

    @FindBy(className = "events-icon")
    private WebElement eventsButton;

    @FindBy(className = "talks-library-icon")
    private WebElement videoButton;

    @FindBy(id = "languageDropdown")
    private WebElement langChange;

    @FindBy(xpath = "//a[contains(text(),'Русский')]")
    private WebElement langRU;

    @FindBy(xpath = "//a[contains(text(),'English')]")
    private WebElement langEN;

    public void changeLangToRUS() {
        langChange.click();
        langRU.click();
    }

    public void changeLangToENG() {
        langChange.click();
        langEN.click();
    }

    public void clickOnCommunitiesButton() {
        communitiesButton.click();
    }

    public void clickOnEventsButton() {
        eventsButton.click();
    }

    public void clickOnVideoButton() {
        videoButton.click();
    }
}
