package weAreCommunity.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {

    @Bean
    @Scope("scenario") // optional: use "singleton" or "scenario" depending on your test needs
    public WebDriver webDriver() {
        // You can use any driver (Chrome, Firefox, etc.)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        return new ChromeDriver();
    }
}
