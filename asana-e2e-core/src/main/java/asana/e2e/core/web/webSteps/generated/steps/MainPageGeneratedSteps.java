package asana.e2e.core.web.webSteps.generated.steps;


import static asana.e2e.core.web.browsers.BrowserConfigProvider.driver;
import static asana.e2e.core.web.browsers.BrowserConfigProvider.setSelenoidConfigs;

import asana.e2e.core.web.pages.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPageGeneratedSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            MainPageGeneratedSteps.class);

    // "click_logIn_button"
    public MainPageGeneratedSteps click_logIn_button() {
        LOGGER.info("Auto-generated keyword 'click_logIn_button' started");
        new MainPage().clickLogInButton();
        return this;
    }

    // "click_get_started_button"
    public MainPageGeneratedSteps click_get_started_button() {
        LOGGER.info("Auto-generated keyword 'click_get_started_button' started");
        new MainPage().clickGetStartedButton();
        return this;
    }
}
