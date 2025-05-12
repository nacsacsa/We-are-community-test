package weAreCommunity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import weAreCommunity.factory.WebDriverFactory;

@Component
public class VideosPage {

    private final WebDriver webDriver;

    public VideosPage(WebDriverFactory webDriverFactory) {
        this.webDriver = webDriverFactory.getDriver();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'evnt-cards-container')]//h3")
    private WebElement title;

    public String GetTitle()
    {
        return title.getText();
    }
}
