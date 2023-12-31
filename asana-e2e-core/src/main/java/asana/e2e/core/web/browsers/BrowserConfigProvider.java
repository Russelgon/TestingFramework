package asana.e2e.core.web.browsers;

import asana.e2e.core.web.ConfigProvider;

import java.net.URI;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserConfigProvider {

    public static RemoteWebDriver driver;
    public final static DesiredCapabilities capabilities = new DesiredCapabilities();

    /**
     * Sets selenoid options to selenide config based on project configuration
     */
    @SneakyThrows
    public static RemoteWebDriver setSelenoidConfigs() {
        if (driver == null) {
            capabilities.setBrowserName(ConfigProvider.BrowserProperties.getBrowser());
            capabilities.setVersion(ConfigProvider.BrowserProperties.getBrowserVersion());
            capabilities.setCapability("enableVNC", ConfigProvider.SelenoidProperties.getVnc());
            capabilities.setCapability("enableVideo",
                    ConfigProvider.SelenoidProperties.getRecordEnabled());
            capabilities.setCapability("enableLog",
                    ConfigProvider.SelenoidProperties.getLoggingEnabled());
            capabilities.setCapability("screenResolution",
                    ConfigProvider.BrowserProperties.getWindowSize());
            driver = new RemoteWebDriver(
                    URI.create(ConfigProvider.SelenoidProperties.getSelenoidUrl()).toURL(),
                    capabilities);
            driver.get(ConfigProvider.AppProperties.getAsanaUrl());
        }
        return driver;
    }
}
