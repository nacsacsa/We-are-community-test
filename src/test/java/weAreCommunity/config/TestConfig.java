package weAreCommunity.config;

import weAreCommunity.config.factory.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("weAreCommunity")
public class TestConfig {

    @Bean(destroyMethod = "tearDown")
    WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }
}
