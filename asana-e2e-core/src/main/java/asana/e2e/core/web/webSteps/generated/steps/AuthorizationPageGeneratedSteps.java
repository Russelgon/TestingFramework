package asana.e2e.core.web.webSteps.generated.steps;

import static asana.e2e.core.baseTech.logger.LoggerMapper.LOGGER;

import asana.e2e.core.web.asserts.AssertsUi;
import asana.e2e.core.web.pages.AuthorizationPage;
import org.junit.jupiter.api.ClassOrderer.ClassName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationPageGeneratedSteps extends BaseGenSteps {

    public void wait_page() {
        LOGGER.info("Waiting AuthorizationPage");
        baseRouter.authorizationPage();
    }

    // "click_continue_button"
    public AuthorizationPageGeneratedSteps click_continue_button() {
        LOGGER.info("Auto-generated keyword 'click_continue_button' started");
        new AuthorizationPage().clickContinueButton();
        return this;
    }

    // "fill_email"
    public AuthorizationPageGeneratedSteps fill_email(String text) {
        LOGGER.info("Auto-generated keyword 'fill_email' started");
        AssertsUi.softAssertMessage(new AuthorizationPage().inputFieldIsBlank(), "");
        new AuthorizationPage().setInputField(text);
        return this;
    }

    // "fill_password"
    public AuthorizationPageGeneratedSteps fill_password(String text) {
        LOGGER.info("Auto-generated keyword 'fill_password' started");
        AssertsUi.softAssertMessage(new AuthorizationPage().inputFieldIsBlank(), "");
        new AuthorizationPage().setInputField(text);
        return this;
    }

    // "get_alert_message"
    public String get_alert_message() {
        LOGGER.info("Auto-generated keyword 'get_alert_message' started");
        return new AuthorizationPage().getAlertMessage();
    }

    // "get_emailAddress_message"
    public String get_emailAddress_message() {
        LOGGER.info("Auto-generated keyword 'get_emailAddress_message' started");
        return new AuthorizationPage().getEmailAddressText();
    }
}
