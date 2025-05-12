package weAreCommunity.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import weAreCommunity.factory.WebDriverFactory;

@Component
public class EventsPage {
    private final WebDriver webDriver;

    private static final int EXPECTED_NUMBER_OF_UPCOMING_EVENTS = 48;

    public EventsPage(WebDriverFactory webDriverFactory) {
        this.webDriver = webDriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"agenda_filters\"]/div/div[1]/div[1]/div/div/div[4]/div/div[1]")
    private WebElement moreFiltersButton;

    @FindBy(id = "dates_fromDate")
    private WebElement dateFromFilterInput;

    @FindBy(id = "dates_toDate")
    private WebElement dateTillFilterInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/section[3]/div/div/div[1]/ul/li[1]/a/span[3]")
    private WebElement upcomingEventsCounter;

    public void clickOnMoreFilters() {
        moreFiltersButton.click();
    }

    public void applyDateFromFilter() {
        dateFromFilterInput.click();
        var may18thButton = webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[1]/a"));
        may18thButton.click();
    }

    public void applyDateFillFilter() {
        dateTillFilterInput.click();
        var may31stButton = webDriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[7]/a"));
        may31stButton.click();
    }

    public boolean isUpcomingEventsCounterCorrect() {
        var actualCounterValue = upcomingEventsCounter.getText();
        var expectedCounterValue = String.valueOf(EXPECTED_NUMBER_OF_UPCOMING_EVENTS);

        return actualCounterValue.equals(expectedCounterValue);
    }
}
