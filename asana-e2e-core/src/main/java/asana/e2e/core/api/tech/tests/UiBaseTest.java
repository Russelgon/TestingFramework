package asana.e2e.core.api.tech.tests;

import asana.e2e.core.web.browsers.BrowserConfigProvider;
import asana.e2e.core.web.webSteps.generated.steps.AuthorizationPageGeneratedSteps;
import asana.e2e.core.web.webSteps.generated.steps.MainPageGeneratedSteps;
import org.junit.Before;

public abstract class UiBaseTest {

  protected MainPageGeneratedSteps mainPage = new MainPageGeneratedSteps();
  protected AuthorizationPageGeneratedSteps authorizationPage = new AuthorizationPageGeneratedSteps();

  @Before
  public void openSite() {
    BrowserConfigProvider.setSelenoidConfigs();
  }
}
